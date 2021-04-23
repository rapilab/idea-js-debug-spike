package b.b;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class b implements i, ByteChannel {
  protected static ByteBuffer a;
  
  protected ExecutorService b;
  
  protected List<Future<?>> c;
  
  protected ByteBuffer d;
  
  protected ByteBuffer e;
  
  protected ByteBuffer f;
  
  protected SocketChannel g;
  
  protected SelectionKey h;
  
  protected SSLEngine i;
  
  protected SSLEngineResult j;
  
  protected SSLEngineResult k;
  
  protected int l = 0;
  
  public b(SocketChannel paramSocketChannel, SSLEngine paramSSLEngine, ExecutorService paramExecutorService, SelectionKey paramSelectionKey) throws IOException {
    if (paramSocketChannel == null || paramSSLEngine == null || paramExecutorService == null)
      throw new IllegalArgumentException("parameter must not be null"); 
    this.g = paramSocketChannel;
    this.i = paramSSLEngine;
    this.b = paramExecutorService;
    this.j = this.k = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, paramSSLEngine.getHandshakeStatus(), 0, 0);
    this.c = new ArrayList<Future<?>>(3);
    if (paramSelectionKey != null) {
      paramSelectionKey.interestOps(paramSelectionKey.interestOps() | 0x4);
      this.h = paramSelectionKey;
    } 
    a(paramSSLEngine.getSession());
    this.g.write(b(a));
    j();
  }
  
  private void a(Future<?> paramFuture) {
    try {
      boolean bool = false;
      while (true) {
        try {
          paramFuture.get();
        } catch (InterruptedException interruptedException) {
          bool = true;
          continue;
        } 
        if (bool)
          Thread.currentThread().interrupt(); 
        return;
      } 
    } catch (ExecutionException executionException) {
      throw new RuntimeException(executionException);
    } 
  }
  
  private synchronized void j() throws IOException {
    if (this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)
      return; 
    if (!this.c.isEmpty()) {
      Iterator<Future<?>> iterator = this.c.iterator();
      while (iterator.hasNext()) {
        Future<?> future = iterator.next();
        if (future.isDone()) {
          iterator.remove();
          continue;
        } 
        if (d())
          a(future); 
        return;
      } 
    } 
    if (this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
      if (!d() || this.j.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
        this.f.compact();
        int j = this.g.read(this.f);
        if (j == -1)
          throw new IOException("connection closed unexpectedly by peer"); 
        this.f.flip();
      } 
      this.d.compact();
      k();
      if (this.j.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
        a(this.i.getSession());
        return;
      } 
    } 
    e();
    if (this.c.isEmpty() || this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
      this.g.write(b(a));
      if (this.k.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
        a(this.i.getSession());
        return;
      } 
    } 
    if (!m && this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)
      throw new AssertionError(); 
    this.l = 1;
  }
  
  private synchronized ByteBuffer b(ByteBuffer paramByteBuffer) throws SSLException {
    this.e.compact();
    this.k = this.i.wrap(paramByteBuffer, this.e);
    this.e.flip();
    return this.e;
  }
  
  private synchronized ByteBuffer k() throws SSLException {
    int j;
    do {
      j = this.d.remaining();
      this.j = this.i.unwrap(this.f, this.d);
    } while (this.j.getStatus() == SSLEngineResult.Status.OK && (j != this.d.remaining() || this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP));
    this.d.flip();
    return this.d;
  }
  
  protected void e() {
    Runnable runnable;
    while ((runnable = this.i.getDelegatedTask()) != null)
      this.c.add(this.b.submit(runnable)); 
  }
  
  protected void a(SSLSession paramSSLSession) {
    int j = paramSSLSession.getApplicationBufferSize();
    int k = paramSSLSession.getPacketBufferSize();
    if (this.d == null) {
      this.d = ByteBuffer.allocate(j);
      this.e = ByteBuffer.allocate(k);
      this.f = ByteBuffer.allocate(k);
    } else {
      if (this.d.capacity() != j)
        this.d = ByteBuffer.allocate(j); 
      if (this.e.capacity() != k)
        this.e = ByteBuffer.allocate(k); 
      if (this.f.capacity() != k)
        this.f = ByteBuffer.allocate(k); 
    } 
    this.d.rewind();
    this.d.flip();
    this.f.rewind();
    this.f.flip();
    this.e.rewind();
    this.e.flip();
    this.l++;
  }
  
  public int write(ByteBuffer src) throws IOException {
    if (!l()) {
      j();
      return 0;
    } 
    if (this.l <= 1)
      a(this.i.getSession()); 
    return this.g.write(b(src));
  }
  
  public int read(ByteBuffer dst) throws IOException {
    if (!dst.hasRemaining())
      return 0; 
    if (!l())
      if (d()) {
        while (!l())
          j(); 
      } else {
        j();
        if (!l())
          return 0; 
      }  
    if (this.l <= 1)
      a(this.i.getSession()); 
    int j = c(dst);
    if (j != 0)
      return j; 
    if (!m && this.d.position() != 0)
      throw new AssertionError(); 
    this.d.clear();
    if (!this.f.hasRemaining()) {
      this.f.clear();
    } else {
      this.f.compact();
    } 
    if ((d() || this.j.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.g.read(this.f) == -1)
      return -1; 
    this.f.flip();
    k();
    int k = a(this.d, dst);
    return (k == 0 && d()) ? read(dst) : k;
  }
  
  private int c(ByteBuffer paramByteBuffer) throws SSLException {
    if (this.d.hasRemaining())
      return a(this.d, paramByteBuffer); 
    if (!this.d.hasRemaining())
      this.d.clear(); 
    if (this.f.hasRemaining()) {
      k();
      int j = a(this.d, paramByteBuffer);
      if (j > 0)
        return j; 
    } 
    return 0;
  }
  
  public boolean f() {
    return this.g.isConnected();
  }
  
  public void close() throws IOException {
    this.i.closeOutbound();
    this.i.getSession().invalidate();
    if (this.g.isOpen())
      this.g.write(b(a)); 
    this.g.close();
    this.b.shutdownNow();
  }
  
  private boolean l() {
    SSLEngineResult.HandshakeStatus handshakeStatus = this.i.getHandshakeStatus();
    return (handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
  }
  
  public SelectableChannel a(boolean paramBoolean) throws IOException {
    return this.g.configureBlocking(paramBoolean);
  }
  
  public boolean a(SocketAddress paramSocketAddress) throws IOException {
    return this.g.connect(paramSocketAddress);
  }
  
  public boolean g() throws IOException {
    return this.g.finishConnect();
  }
  
  public Socket h() {
    return this.g.socket();
  }
  
  public boolean i() {
    return this.i.isInboundDone();
  }
  
  public boolean isOpen() {
    return this.g.isOpen();
  }
  
  public boolean a() {
    return (this.e.hasRemaining() || !l());
  }
  
  public void b() throws IOException {
    write(this.e);
  }
  
  public boolean c() {
    return (this.d.hasRemaining() || (this.f.hasRemaining() && this.j.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW && this.j.getStatus() != SSLEngineResult.Status.CLOSED));
  }
  
  public int a(ByteBuffer paramByteBuffer) throws SSLException {
    return c(paramByteBuffer);
  }
  
  private int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2) {
    int j = paramByteBuffer1.remaining();
    int k = paramByteBuffer2.remaining();
    if (j > k) {
      int m = Math.min(j, k);
      for (byte b1 = 0; b1 < m; b1++)
        paramByteBuffer2.put(paramByteBuffer1.get()); 
      return m;
    } 
    paramByteBuffer2.put(paramByteBuffer1);
    return j;
  }
  
  public boolean d() {
    return this.g.isBlocking();
  }
  
  static {
    a = ByteBuffer.allocate(0);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */