package b.b.f;

import b.b.d;
import b.b.d.d;
import b.b.e;
import b.b.e.f;
import b.b.e.i;
import b.b.f;
import b.b.g;
import b.b.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c extends e implements Runnable {
  public static int a;
  
  private final Collection<d> c;
  
  private final InetSocketAddress d;
  
  private ServerSocketChannel e;
  
  private Selector f;
  
  private List<b.b.b.a> g;
  
  private Thread h;
  
  private volatile AtomicBoolean i = new AtomicBoolean(false);
  
  private List<b> j;
  
  private List<g> k;
  
  private BlockingQueue<ByteBuffer> l;
  
  private int m = 0;
  
  private AtomicInteger n = new AtomicInteger(0);
  
  private a o = new b();
  
  public c() throws UnknownHostException {
    this(new InetSocketAddress(80), a, null);
  }
  
  public c(InetSocketAddress paramInetSocketAddress) {
    this(paramInetSocketAddress, a, null);
  }
  
  public c(InetSocketAddress paramInetSocketAddress, int paramInt) {
    this(paramInetSocketAddress, paramInt, null);
  }
  
  public c(InetSocketAddress paramInetSocketAddress, List<b.b.b.a> paramList) {
    this(paramInetSocketAddress, a, paramList);
  }
  
  public c(InetSocketAddress paramInetSocketAddress, int paramInt, List<b.b.b.a> paramList) {
    this(paramInetSocketAddress, paramInt, paramList, new HashSet<d>());
  }
  
  public c(InetSocketAddress paramInetSocketAddress, int paramInt, List<b.b.b.a> paramList, Collection<d> paramCollection) {
    if (paramInetSocketAddress == null || paramInt < 1 || paramCollection == null)
      throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder"); 
    if (paramList == null) {
      this.g = Collections.emptyList();
    } else {
      this.g = paramList;
    } 
    this.d = paramInetSocketAddress;
    this.c = paramCollection;
    this.k = new LinkedList<g>();
    this.j = new ArrayList<b>(paramInt);
    this.l = new LinkedBlockingQueue<ByteBuffer>();
    for (byte b = 0; b < paramInt; b++) {
      b b1 = new b(this);
      this.j.add(b1);
      b1.start();
    } 
  }
  
  public void a() {
    if (this.h != null)
      throw new IllegalStateException(getClass().getName() + " can only be started once."); 
    (new Thread(this)).start();
  }
  
  public void a(int paramInt) throws InterruptedException {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual compareAndSet : (ZZ)Z
    //   9: ifne -> 13
    //   12: return
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: getfield c : Ljava/util/Collection;
    //   19: dup
    //   20: astore_3
    //   21: monitorenter
    //   22: new java/util/ArrayList
    //   25: dup
    //   26: aload_0
    //   27: getfield c : Ljava/util/Collection;
    //   30: invokespecial <init> : (Ljava/util/Collection;)V
    //   33: astore_2
    //   34: aload_3
    //   35: monitorexit
    //   36: goto -> 46
    //   39: astore #4
    //   41: aload_3
    //   42: monitorexit
    //   43: aload #4
    //   45: athrow
    //   46: aload_2
    //   47: invokeinterface iterator : ()Ljava/util/Iterator;
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 86
    //   62: aload_3
    //   63: invokeinterface next : ()Ljava/lang/Object;
    //   68: checkcast b/b/d
    //   71: astore #4
    //   73: aload #4
    //   75: sipush #1001
    //   78: invokeinterface a : (I)V
    //   83: goto -> 53
    //   86: aload_0
    //   87: dup
    //   88: astore_3
    //   89: monitorenter
    //   90: aload_0
    //   91: getfield h : Ljava/lang/Thread;
    //   94: ifnull -> 149
    //   97: invokestatic currentThread : ()Ljava/lang/Thread;
    //   100: aload_0
    //   101: getfield h : Ljava/lang/Thread;
    //   104: if_acmpeq -> 107
    //   107: aload_0
    //   108: getfield h : Ljava/lang/Thread;
    //   111: invokestatic currentThread : ()Ljava/lang/Thread;
    //   114: if_acmpeq -> 149
    //   117: aload_2
    //   118: invokeinterface size : ()I
    //   123: ifle -> 135
    //   126: aload_0
    //   127: getfield h : Ljava/lang/Thread;
    //   130: iload_1
    //   131: i2l
    //   132: invokevirtual join : (J)V
    //   135: aload_0
    //   136: getfield h : Ljava/lang/Thread;
    //   139: invokevirtual interrupt : ()V
    //   142: aload_0
    //   143: getfield h : Ljava/lang/Thread;
    //   146: invokevirtual join : ()V
    //   149: aload_3
    //   150: monitorexit
    //   151: goto -> 161
    //   154: astore #5
    //   156: aload_3
    //   157: monitorexit
    //   158: aload #5
    //   160: athrow
    //   161: return
    // Exception table:
    //   from	to	target	type
    //   22	36	39	finally
    //   39	43	39	finally
    //   90	151	154	finally
    //   154	158	154	finally
  }
  
  public void b() throws IOException, InterruptedException {
    a(0);
  }
  
  public Collection<d> c() {
    return this.c;
  }
  
  public InetSocketAddress d() {
    return this.d;
  }
  
  public int e() {
    int i = d().getPort();
    if (i == 0 && this.e != null)
      i = this.e.socket().getLocalPort(); 
    return i;
  }
  
  public List<b.b.b.a> f() {
    return Collections.unmodifiableList(this.g);
  }
  
  public void run() {
    synchronized (this) {
      if (this.h != null)
        throw new IllegalStateException(getClass().getName() + " can only be started once."); 
      this.h = Thread.currentThread();
      if (this.i.get())
        return; 
    } 
    this.h.setName("WebsocketSelector" + this.h.getId());
    try {
      this.e = ServerSocketChannel.open();
      this.e.configureBlocking(false);
      ServerSocket serverSocket = this.e.socket();
      serverSocket.setReceiveBufferSize(g.a);
      serverSocket.bind(this.d);
      this.f = Selector.open();
      this.e.register(this.f, this.e.validOps());
    } catch (IOException iOException) {
      c(null, iOException);
      return;
    } 
    try {
      while (!this.h.isInterrupted()) {
        SelectionKey selectionKey = null;
        g g = null;
        try {
          this.f.select();
          Set<SelectionKey> set = this.f.selectedKeys();
          Iterator<SelectionKey> iterator = set.iterator();
          while (iterator.hasNext()) {
            selectionKey = iterator.next();
            if (!selectionKey.isValid())
              continue; 
            if (selectionKey.isAcceptable()) {
              if (!a(selectionKey)) {
                selectionKey.cancel();
                continue;
              } 
              SocketChannel socketChannel = this.e.accept();
              socketChannel.configureBlocking(false);
              g g1 = this.o.b(this, this.g, socketChannel.socket());
              g1.d = socketChannel.register(this.f, 1, g1);
              g1.g = this.o.a(socketChannel, g1.d);
              iterator.remove();
              e((d)g1);
              continue;
            } 
            if (selectionKey.isReadable()) {
              g = (g)selectionKey.attachment();
              ByteBuffer byteBuffer = j();
              try {
                if (b.b.c.a(byteBuffer, g, g.g)) {
                  if (byteBuffer.hasRemaining()) {
                    g.i.put(byteBuffer);
                    a(g);
                    iterator.remove();
                    if (g.g instanceof i && ((i)g.g).c())
                      this.k.add(g); 
                  } else {
                    a(byteBuffer);
                  } 
                } else {
                  a(byteBuffer);
                } 
              } catch (IOException iOException) {
                a(byteBuffer);
                throw iOException;
              } 
            } 
            if (selectionKey.isWritable()) {
              g = (g)selectionKey.attachment();
              if (b.b.c.a(g, g.g) && selectionKey.isValid())
                selectionKey.interestOps(1); 
            } 
          } 
          while (!this.k.isEmpty()) {
            g = this.k.remove(0);
            i i = (i)g.g;
            ByteBuffer byteBuffer = j();
            try {
              if (b.b.c.a(byteBuffer, g, i))
                this.k.add(g); 
              if (byteBuffer.hasRemaining()) {
                g.i.put(byteBuffer);
                a(g);
                continue;
              } 
              a(byteBuffer);
            } catch (IOException iOException) {
              a(byteBuffer);
              throw iOException;
            } 
          } 
        } catch (CancelledKeyException cancelledKeyException) {
        
        } catch (ClosedByInterruptException closedByInterruptException) {
          return;
        } catch (IOException iOException) {
          if (selectionKey != null)
            selectionKey.cancel(); 
          a(selectionKey, (d)g, iOException);
        } catch (InterruptedException interruptedException) {
          return;
        } 
      } 
    } catch (RuntimeException runtimeException) {
      c(null, runtimeException);
    } finally {
      if (this.j != null)
        for (b b : this.j)
          b.interrupt();  
      if (this.e != null)
        try {
          this.e.close();
        } catch (IOException iOException) {
          b((d)null, iOException);
        }  
    } 
  }
  
  protected void e(d paramd) throws InterruptedException {
    if (this.n.get() >= 2 * this.j.size() + 1)
      return; 
    this.n.incrementAndGet();
    this.l.put(g());
  }
  
  protected void f(d paramd) throws InterruptedException {}
  
  public ByteBuffer g() {
    return ByteBuffer.allocate(g.a);
  }
  
  private void a(g paramg) throws InterruptedException {
    if (paramg.j == null) {
      paramg.j = this.j.get(this.m % this.j.size());
      this.m++;
    } 
    paramg.j.a(paramg);
  }
  
  private ByteBuffer j() throws InterruptedException {
    return this.l.take();
  }
  
  private void a(ByteBuffer paramByteBuffer) throws InterruptedException {
    if (this.l.size() > this.n.intValue())
      return; 
    this.l.put(paramByteBuffer);
  }
  
  private void a(SelectionKey paramSelectionKey, d paramd, IOException paramIOException) {
    if (paramd != null) {
      paramd.b(1006, paramIOException.getMessage());
    } else if (paramSelectionKey != null) {
      SelectableChannel selectableChannel = paramSelectionKey.channel();
      if (selectableChannel != null && selectableChannel.isOpen()) {
        try {
          selectableChannel.close();
        } catch (IOException iOException) {}
        if (g.b)
          System.out.println("Connection closed because of" + paramIOException); 
      } 
    } 
  }
  
  private void c(d paramd, Exception paramException) {
    b(paramd, paramException);
    try {
      b();
    } catch (IOException iOException) {
      b((d)null, iOException);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      b((d)null, interruptedException);
    } 
  }
  
  protected String h() {
    return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + e() + "\" /></cross-domain-policy>";
  }
  
  public final void a(d paramd, String paramString) {
    b(paramd, paramString);
  }
  
  public void a(d paramd, d paramd1) {
    d(paramd, paramd1);
  }
  
  public final void a(d paramd, ByteBuffer paramByteBuffer) {
    b(paramd, paramByteBuffer);
  }
  
  public final void a(d paramd, f paramf) {
    if (h(paramd))
      b(paramd, (b.b.e.a)paramf); 
  }
  
  public final void a(d paramd, int paramInt, String paramString, boolean paramBoolean) {
    this.f.wakeup();
    try {
      if (g(paramd))
        d(paramd, paramInt, paramString, paramBoolean); 
    } finally {
      try {
        f(paramd);
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
      } 
    } 
  }
  
  protected boolean g(d paramd) {
    boolean bool;
    synchronized (this.c) {
      bool = this.c.remove(paramd);
      if (!b && !bool)
        throw new AssertionError(); 
    } 
    if (this.i.get() && this.c.size() == 0)
      this.h.interrupt(); 
    return bool;
  }
  
  public i a(d paramd, b.b.b.a parama, b.b.e.a parama1) throws b.b.c.b {
    return super.a(paramd, parama, parama1);
  }
  
  protected boolean h(d paramd) {
    if (!this.i.get())
      synchronized (this.c) {
        boolean bool = this.c.add(paramd);
        if (!b && !bool)
          throw new AssertionError(); 
        return bool;
      }  
    paramd.a(1001);
    return true;
  }
  
  public final void a(d paramd, Exception paramException) {
    b(paramd, paramException);
  }
  
  public final void b(d paramd) {
    g g = (g)paramd;
    try {
      g.d.interestOps(5);
    } catch (CancelledKeyException cancelledKeyException) {
      g.h.clear();
    } 
    this.f.wakeup();
  }
  
  public void a(d paramd, int paramInt, String paramString) {
    b(paramd, paramInt, paramString);
  }
  
  public void b(d paramd, int paramInt, String paramString, boolean paramBoolean) {
    c(paramd, paramInt, paramString, paramBoolean);
  }
  
  public void b(d paramd, int paramInt, String paramString) {}
  
  public void c(d paramd, int paramInt, String paramString, boolean paramBoolean) {}
  
  public final void a(a parama) {
    this.o = parama;
  }
  
  public final f i() {
    return this.o;
  }
  
  protected boolean a(SelectionKey paramSelectionKey) {
    return true;
  }
  
  private Socket i(d paramd) {
    g g = (g)paramd;
    return ((SocketChannel)g.d.channel()).socket();
  }
  
  public InetSocketAddress c(d paramd) {
    return (InetSocketAddress)i(paramd).getLocalSocketAddress();
  }
  
  public InetSocketAddress d(d paramd) {
    return (InetSocketAddress)i(paramd).getRemoteSocketAddress();
  }
  
  public abstract void b(d paramd, b.b.e.a parama);
  
  public abstract void d(d paramd, int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void b(d paramd, String paramString);
  
  public abstract void b(d paramd, Exception paramException);
  
  public void b(d paramd, ByteBuffer paramByteBuffer) {}
  
  public void d(d paramd, d paramd1) {}
  
  static {
    a = Runtime.getRuntime().availableProcessors();
  }
  
  public static interface a extends f {
    g b(e param1e, b.b.b.a param1a, Socket param1Socket);
    
    g b(e param1e, List<b.b.b.a> param1List, Socket param1Socket);
    
    ByteChannel a(SocketChannel param1SocketChannel, SelectionKey param1SelectionKey) throws IOException;
  }
  
  public class b extends Thread {
    private BlockingQueue<g> c = new LinkedBlockingQueue<g>();
    
    public b(c this$0) {
      setName("WebSocketWorker-" + getId());
      setUncaughtExceptionHandler(new d(this, this$0));
    }
    
    public void a(g param1g) throws InterruptedException {
      this.c.put(param1g);
    }
    
    public void run() {
      g g = null;
      try {
        while (true) {
          ByteBuffer byteBuffer = null;
          g = this.c.take();
          byteBuffer = g.i.poll();
          if (!a && byteBuffer == null)
            throw new AssertionError(); 
          try {
            g.b(byteBuffer);
          } finally {
            c.a(this.b, byteBuffer);
          } 
        } 
      } catch (InterruptedException interruptedException) {
      
      } catch (RuntimeException runtimeException) {
        c.a(this.b, (d)g, runtimeException);
      } 
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/f/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */