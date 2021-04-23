package b.b.a;

import b.b.b.c;
import b.b.c.d;
import b.b.d;
import b.b.d.d;
import b.b.e;
import b.b.e.d;
import b.b.e.f;
import b.b.e.h;
import b.b.g;
import b.b.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public abstract class b extends e implements d, Runnable {
  protected URI g = null;
  
  private g a = null;
  
  private Socket b = null;
  
  private InputStream c;
  
  private OutputStream d;
  
  private Proxy i = Proxy.NO_PROXY;
  
  private Thread j;
  
  private b.b.b.a k;
  
  private Map<String, String> l;
  
  private CountDownLatch m = new CountDownLatch(1);
  
  private CountDownLatch n = new CountDownLatch(1);
  
  private int o = 0;
  
  public b(URI paramURI) {
    this(paramURI, (b.b.b.a)new c());
  }
  
  public b(URI paramURI, b.b.b.a parama) {
    this(paramURI, parama, null, 0);
  }
  
  public b(URI paramURI, b.b.b.a parama, Map<String, String> paramMap, int paramInt) {
    if (paramURI == null)
      throw new IllegalArgumentException(); 
    if (parama == null)
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!"); 
    this.g = paramURI;
    this.k = parama;
    this.l = paramMap;
    this.o = paramInt;
    this.a = new g((h)this, parama);
  }
  
  public URI m() {
    return this.g;
  }
  
  public b.b.b.a j() {
    return this.k;
  }
  
  public void n() {
    if (this.j != null)
      throw new IllegalStateException("WebSocketClient objects are not reuseable"); 
    this.j = new Thread(this);
    this.j.start();
  }
  
  public boolean o() throws InterruptedException {
    n();
    this.m.await();
    return this.a.f();
  }
  
  public void a() {
    if (this.j != null)
      this.a.a(1000); 
  }
  
  public void p() throws InterruptedException {
    a();
    this.n.await();
  }
  
  public void b(String paramString) throws NotYetConnectedException {
    this.a.b(paramString);
  }
  
  public void a(byte[] paramArrayOfbyte) throws NotYetConnectedException {
    this.a.a(paramArrayOfbyte);
  }
  
  public void run() {
    try {
      if (this.b == null) {
        this.b = new Socket(this.i);
      } else if (this.b.isClosed()) {
        throw new IOException();
      } 
      if (!this.b.isBound())
        this.b.connect(new InetSocketAddress(this.g.getHost(), r()), this.o); 
      this.c = this.b.getInputStream();
      this.d = this.b.getOutputStream();
      s();
    } catch (Exception exception) {
      a((d)this.a, exception);
      this.a.b(-1, exception.getMessage());
      return;
    } 
    this.j = new Thread(new a());
    this.j.start();
    byte[] arrayOfByte = new byte[g.a];
    try {
      int i;
      while (!i() && (i = this.c.read(arrayOfByte)) != -1)
        this.a.b(ByteBuffer.wrap(arrayOfByte, 0, i)); 
      this.a.n();
    } catch (IOException iOException) {
      this.a.n();
    } catch (RuntimeException runtimeException) {
      a(runtimeException);
      this.a.b(1006, runtimeException.getMessage());
    } 
    if (!h && !this.b.isClosed())
      throw new AssertionError(); 
  }
  
  private int r() {
    int i = this.g.getPort();
    if (i == -1) {
      String str = this.g.getScheme();
      if (str.equals("wss"))
        return 443; 
      if (str.equals("ws"))
        return 80; 
      throw new RuntimeException("unkonow scheme" + str);
    } 
    return i;
  }
  
  private void s() throws d {
    String str1;
    String str2 = this.g.getPath();
    String str3 = this.g.getQuery();
    if (str2 == null || str2.length() == 0) {
      str1 = "/";
    } else {
      str1 = str2;
    } 
    if (str3 != null)
      str1 = str1 + "?" + str3; 
    int i = r();
    String str4 = this.g.getHost() + ((i != 80) ? (":" + i) : "");
    d d1 = new d();
    d1.a(str1);
    d1.a("Host", str4);
    if (this.l != null)
      for (Map.Entry<String, String> entry : this.l.entrySet())
        d1.a((String)entry.getKey(), (String)entry.getValue());  
    this.a.a((b.b.e.b)d1);
  }
  
  public d.a k() {
    return this.a.k();
  }
  
  public final void a(d paramd, String paramString) {
    a(paramString);
  }
  
  public final void a(d paramd, ByteBuffer paramByteBuffer) {
    b(paramByteBuffer);
  }
  
  public void a(d paramd, d paramd1) {
    b(paramd1);
  }
  
  public final void a(d paramd, f paramf) {
    this.m.countDown();
    a((h)paramf);
  }
  
  public final void a(d paramd, int paramInt, String paramString, boolean paramBoolean) {
    this.m.countDown();
    this.n.countDown();
    if (this.j != null)
      this.j.interrupt(); 
    try {
      if (this.b != null)
        this.b.close(); 
    } catch (IOException iOException) {
      a(this, iOException);
    } 
    a(paramInt, paramString, paramBoolean);
  }
  
  public final void a(d paramd, Exception paramException) {
    a(paramException);
  }
  
  public final void b(d paramd) {}
  
  public void a(d paramd, int paramInt, String paramString) {
    c(paramInt, paramString);
  }
  
  public void b(d paramd, int paramInt, String paramString, boolean paramBoolean) {
    b(paramInt, paramString, paramBoolean);
  }
  
  public void c(int paramInt, String paramString) {}
  
  public void b(int paramInt, String paramString, boolean paramBoolean) {}
  
  public d q() {
    return (d)this.a;
  }
  
  public InetSocketAddress c(d paramd) {
    return (this.b != null) ? (InetSocketAddress)this.b.getLocalSocketAddress() : null;
  }
  
  public InetSocketAddress d(d paramd) {
    return (this.b != null) ? (InetSocketAddress)this.b.getRemoteSocketAddress() : null;
  }
  
  public abstract void a(h paramh);
  
  public abstract void a(String paramString);
  
  public abstract void a(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void a(Exception paramException);
  
  public void b(ByteBuffer paramByteBuffer) {}
  
  public void b(d paramd) {}
  
  public void a(Proxy paramProxy) {
    if (paramProxy == null)
      throw new IllegalArgumentException(); 
    this.i = paramProxy;
  }
  
  public void a(Socket paramSocket) {
    if (this.b != null)
      throw new IllegalStateException("socket has already been set"); 
    this.b = paramSocket;
  }
  
  public void a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean) {
    this.a.a(parama, paramByteBuffer, paramBoolean);
  }
  
  public boolean f() {
    return this.a.f();
  }
  
  public boolean h() {
    return this.a.h();
  }
  
  public boolean i() {
    return this.a.i();
  }
  
  public boolean g() {
    return this.a.g();
  }
  
  public boolean e() {
    return this.a.e();
  }
  
  public boolean b() {
    return this.a.b();
  }
  
  public void a(int paramInt) {
    this.a.a();
  }
  
  public void a(int paramInt, String paramString) {
    this.a.a(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString) {
    this.a.b(paramInt, paramString);
  }
  
  public void a(ByteBuffer paramByteBuffer) throws IllegalArgumentException, NotYetConnectedException {
    this.a.a(paramByteBuffer);
  }
  
  public void a(d paramd) {
    this.a.a(paramd);
  }
  
  public InetSocketAddress d() {
    return this.a.d();
  }
  
  public InetSocketAddress c() {
    return this.a.c();
  }
  
  public String l() {
    return this.g.getPath();
  }
  
  private class a implements Runnable {
    private a(b this$0) {}
    
    public void run() {
      Thread.currentThread().setName("WebsocketWriteThread");
      try {
        while (!Thread.interrupted()) {
          ByteBuffer byteBuffer = (b.a(this.a)).h.take();
          b.b(this.a).write(byteBuffer.array(), 0, byteBuffer.limit());
          b.b(this.a).flush();
        } 
      } catch (IOException iOException) {
        b.a(this.a).n();
      } catch (InterruptedException interruptedException) {}
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/a/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */