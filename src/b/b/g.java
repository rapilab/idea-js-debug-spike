package b.b;

import b.b.b.a;
import b.b.b.b;
import b.b.b.c;
import b.b.b.d;
import b.b.b.e;
import b.b.c.a;
import b.b.c.b;
import b.b.c.d;
import b.b.c.g;
import b.b.d.a;
import b.b.d.b;
import b.b.d.d;
import b.b.e.a;
import b.b.e.b;
import b.b.e.f;
import b.b.e.h;
import b.b.e.i;
import b.b.f.c;
import b.b.g.c;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class g implements d {
  public static int a;
  
  public static boolean b;
  
  public static final List<a> c;
  
  public SelectionKey d;
  
  public ByteChannel g;
  
  public final BlockingQueue<ByteBuffer> h;
  
  public final BlockingQueue<ByteBuffer> i;
  
  public volatile c.b j;
  
  private volatile boolean l = false;
  
  private d.a m = d.a.a;
  
  private final h n;
  
  private List<a> o;
  
  private a p = null;
  
  private d.b q;
  
  private d.a r = null;
  
  private ByteBuffer s = ByteBuffer.allocate(0);
  
  private a t = null;
  
  private String u = null;
  
  private Integer v = null;
  
  private Boolean w = null;
  
  private String x = null;
  
  public g(h paramh, List<a> paramList) {
    this(paramh, (a)null);
    this.q = d.b.b;
    if (paramList == null || paramList.isEmpty()) {
      this.o = c;
    } else {
      this.o = paramList;
    } 
  }
  
  public g(h paramh, a parama) {
    if (paramh == null || (parama == null && this.q == d.b.b))
      throw new IllegalArgumentException("parameters must not be null"); 
    this.h = new LinkedBlockingQueue<ByteBuffer>();
    this.i = new LinkedBlockingQueue<ByteBuffer>();
    this.n = paramh;
    this.q = d.b.a;
    if (parama != null)
      this.p = parama.c(); 
  }
  
  public g(h paramh, a parama, Socket paramSocket) {
    this(paramh, parama);
  }
  
  public g(h paramh, List<a> paramList, Socket paramSocket) {
    this(paramh, paramList);
  }
  
  public void b(ByteBuffer paramByteBuffer) {
    if (!k && !paramByteBuffer.hasRemaining())
      throw new AssertionError(); 
    if (b)
      System.out.println("process(" + paramByteBuffer.remaining() + "): {" + ((paramByteBuffer.remaining() > 1000) ? "too big to display" : new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining())) + "}"); 
    if (this.m != d.a.a) {
      d(paramByteBuffer);
    } else if (c(paramByteBuffer)) {
      if (!k && this.s.hasRemaining() == paramByteBuffer.hasRemaining() && paramByteBuffer.hasRemaining())
        throw new AssertionError(); 
      if (paramByteBuffer.hasRemaining()) {
        d(paramByteBuffer);
      } else if (this.s.hasRemaining()) {
        d(this.s);
      } 
    } 
    if (!k && !g() && !h() && paramByteBuffer.hasRemaining())
      throw new AssertionError(); 
  }
  
  private boolean c(ByteBuffer paramByteBuffer) {
    ByteBuffer byteBuffer;
    if (this.s.capacity() == 0) {
      byteBuffer = paramByteBuffer;
    } else {
      if (this.s.remaining() < paramByteBuffer.remaining()) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(this.s.capacity() + paramByteBuffer.remaining());
        this.s.flip();
        byteBuffer1.put(this.s);
        this.s = byteBuffer1;
      } 
      this.s.put(paramByteBuffer);
      this.s.flip();
      byteBuffer = this.s;
    } 
    byteBuffer.mark();
    try {
      if (this.p == null) {
        a.b b2 = e(byteBuffer);
        if (b2 == a.b.a) {
          try {
            f(ByteBuffer.wrap(c.a(this.n.a(this))));
            a(-3, "");
          } catch (b b3) {
            c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
          } 
          return false;
        } 
      } 
      a.b b1 = null;
      try {
        if (this.q == d.b.b) {
          if (this.p == null) {
            for (a a2 : this.o) {
              a2 = a2.c();
              try {
                a2.a(this.q);
                byteBuffer.reset();
                f f1 = a2.d(byteBuffer);
                if (!(f1 instanceof a)) {
                  b(1002, "wrong http function", false);
                  return false;
                } 
                a a3 = (a)f1;
                b1 = a2.a(a3);
                if (b1 == a.b.a) {
                  i i;
                  this.x = a3.a();
                  try {
                    i = this.n.a(this, a2, a3);
                  } catch (b b2) {
                    b(b2.a(), b2.getMessage(), false);
                    return false;
                  } catch (RuntimeException runtimeException) {
                    this.n.a(this, runtimeException);
                    b(-1, runtimeException.getMessage(), false);
                    return false;
                  } 
                  a(a2.a((f)a2.a(a3, i), this.q));
                  this.p = a2;
                  a((f)a3);
                  return true;
                } 
              } catch (d d1) {}
            } 
            if (this.p == null)
              a(1002, "no draft matches"); 
            return false;
          } 
          f f = this.p.d(byteBuffer);
          if (!(f instanceof a)) {
            b(1002, "wrong http function", false);
            return false;
          } 
          a a1 = (a)f;
          b1 = this.p.a(a1);
          if (b1 == a.b.a) {
            a((f)a1);
            return true;
          } 
          a(1002, "the handshake did finaly not match");
          return false;
        } 
        if (this.q == d.b.a) {
          this.p.a(this.q);
          f f = this.p.d(byteBuffer);
          if (!(f instanceof h)) {
            b(1002, "wrong http function", false);
            return false;
          } 
          h h1 = (h)f;
          b1 = this.p.a(this.t, h1);
          if (b1 == a.b.a) {
            try {
              this.n.a(this, this.t, h1);
            } catch (b b2) {
              b(b2.a(), b2.getMessage(), false);
              return false;
            } catch (RuntimeException runtimeException) {
              this.n.a(this, runtimeException);
              b(-1, runtimeException.getMessage(), false);
              return false;
            } 
            a((f)h1);
            return true;
          } 
          a(1002, "draft " + this.p + " refuses handshake");
        } 
      } catch (d d1) {
        a((b)d1);
      } 
    } catch (a a1) {
      if (this.s.capacity() == 0) {
        byteBuffer.reset();
        int i = a1.a();
        if (i == 0) {
          i = byteBuffer.capacity() + 16;
        } else if (!k && a1.a() < byteBuffer.remaining()) {
          throw new AssertionError();
        } 
        this.s = ByteBuffer.allocate(i);
        this.s.put(paramByteBuffer);
      } else {
        this.s.position(this.s.limit());
        this.s.limit(this.s.capacity());
      } 
    } 
    return false;
  }
  
  private void d(ByteBuffer paramByteBuffer) {
    try {
      List list = this.p.c(paramByteBuffer);
      for (d d1 : list) {
        if (b)
          System.out.println("matched frame: " + d1); 
        d.a a1 = d1.f();
        boolean bool = d1.d();
        if (a1 == d.a.f) {
          int i = 1005;
          String str = "";
          if (d1 instanceof a) {
            a a2 = (a)d1;
            i = a2.a();
            str = a2.b();
          } 
          if (this.m == d.a.d) {
            a(i, str, true);
            continue;
          } 
          if (this.p.b() == a.a.c) {
            c(i, str, true);
            continue;
          } 
          b(i, str, false);
          continue;
        } 
        if (a1 == d.a.d) {
          this.n.b(this, d1);
          continue;
        } 
        if (a1 == d.a.e) {
          this.n.c(this, d1);
          continue;
        } 
        if (!bool || a1 == d.a.a) {
          if (a1 != d.a.a) {
            if (this.r != null)
              throw new b(1002, "Previous continuous frame sequence not completed."); 
            this.r = a1;
          } else if (bool) {
            if (this.r == null)
              throw new b(1002, "Continuous frame sequence was not started."); 
            this.r = null;
          } else if (this.r == null) {
            throw new b(1002, "Continuous frame sequence was not started.");
          } 
          try {
            this.n.a(this, d1);
          } catch (RuntimeException runtimeException) {
            this.n.a(this, runtimeException);
          } 
          continue;
        } 
        if (this.r != null)
          throw new b(1002, "Continuous frame sequence not completed."); 
        if (a1 == d.a.b) {
          try {
            this.n.a(this, c.a(d1.c()));
          } catch (RuntimeException runtimeException) {
            this.n.a(this, runtimeException);
          } 
          continue;
        } 
        if (a1 == d.a.c) {
          try {
            this.n.a(this, d1.c());
          } catch (RuntimeException runtimeException) {
            this.n.a(this, runtimeException);
          } 
          continue;
        } 
        throw new b(1002, "non control or continious frame expected");
      } 
    } catch (b b1) {
      this.n.a(this, (Exception)b1);
      a(b1);
      return;
    } 
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean) {
    if (this.m != d.a.d && this.m != d.a.e) {
      if (this.m == d.a.c) {
        if (paramInt == 1006) {
          if (!k && paramBoolean)
            throw new AssertionError(); 
          this.m = d.a.d;
          b(paramInt, paramString, false);
          return;
        } 
        if (this.p.b() != a.a.a)
          try {
            if (!paramBoolean)
              try {
                this.n.a(this, paramInt, paramString);
              } catch (RuntimeException runtimeException) {
                this.n.a(this, runtimeException);
              }  
            a((d)new b(paramInt, paramString));
          } catch (b b1) {
            this.n.a(this, (Exception)b1);
            b(1006, "generated frame is invalid", false);
          }  
        b(paramInt, paramString, paramBoolean);
      } else if (paramInt == -3) {
        if (!k && !paramBoolean)
          throw new AssertionError(); 
        b(-3, paramString, true);
      } else {
        b(-1, paramString, false);
      } 
      if (paramInt == 1002)
        b(paramInt, paramString, paramBoolean); 
      this.m = d.a.d;
      this.s = null;
      return;
    } 
  }
  
  public void a(int paramInt, String paramString) {
    c(paramInt, paramString, false);
  }
  
  protected synchronized void a(int paramInt, String paramString, boolean paramBoolean) {
    if (this.m == d.a.e)
      return; 
    if (this.d != null)
      this.d.cancel(); 
    if (this.g != null)
      try {
        this.g.close();
      } catch (IOException iOException) {
        this.n.a(this, iOException);
      }  
    try {
      this.n.a(this, paramInt, paramString, paramBoolean);
    } catch (RuntimeException runtimeException) {
      this.n.a(this, runtimeException);
    } 
    if (this.p != null)
      this.p.a(); 
    this.t = null;
    this.m = d.a.e;
    this.h.clear();
  }
  
  protected void a(int paramInt, boolean paramBoolean) {
    a(paramInt, "", paramBoolean);
  }
  
  public void m() {
    if (this.w == null)
      throw new IllegalStateException("this method must be used in conjuction with flushAndClose"); 
    a(this.v.intValue(), this.u, this.w.booleanValue());
  }
  
  public void b(int paramInt, String paramString) {
    a(paramInt, paramString, false);
  }
  
  protected synchronized void b(int paramInt, String paramString, boolean paramBoolean) {
    if (this.l)
      return; 
    this.v = Integer.valueOf(paramInt);
    this.u = paramString;
    this.w = Boolean.valueOf(paramBoolean);
    this.l = true;
    this.n.b(this);
    try {
      this.n.b(this, paramInt, paramString, paramBoolean);
    } catch (RuntimeException runtimeException) {
      this.n.a(this, runtimeException);
    } 
    if (this.p != null)
      this.p.a(); 
    this.t = null;
  }
  
  public void n() {
    if (k() == d.a.a) {
      a(-1, true);
    } else if (this.l) {
      a(this.v.intValue(), this.u, this.w.booleanValue());
    } else if (this.p.b() == a.a.a) {
      a(1000, true);
    } else if (this.p.b() == a.a.b) {
      if (this.q == d.b.b) {
        a(1006, true);
      } else {
        a(1000, true);
      } 
    } else {
      a(1006, true);
    } 
  }
  
  public void a(int paramInt) {
    c(paramInt, "", false);
  }
  
  public void a(b paramb) {
    c(paramb.a(), paramb.getMessage(), false);
  }
  
  public void b(String paramString) throws g {
    if (paramString == null)
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl."); 
    a(this.p.a(paramString, (this.q == d.b.a)));
  }
  
  public void a(ByteBuffer paramByteBuffer) throws IllegalArgumentException, g {
    if (paramByteBuffer == null)
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl."); 
    a(this.p.a(paramByteBuffer, (this.q == d.b.a)));
  }
  
  public void a(byte[] paramArrayOfbyte) throws IllegalArgumentException, g {
    a(ByteBuffer.wrap(paramArrayOfbyte));
  }
  
  private void a(Collection<d> paramCollection) {
    if (!f())
      throw new g(); 
    for (d d1 : paramCollection)
      a(d1); 
  }
  
  public void a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean) {
    a(this.p.a(parama, paramByteBuffer, paramBoolean));
  }
  
  public void a(d paramd) {
    if (b)
      System.out.println("send frame: " + paramd); 
    f(this.p.a(paramd));
  }
  
  public boolean b() {
    return !this.h.isEmpty();
  }
  
  private a.b e(ByteBuffer paramByteBuffer) throws a {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > a.c.length)
      return a.b.b; 
    if (paramByteBuffer.limit() < a.c.length)
      throw new a(a.c.length); 
    for (byte b1 = 0; paramByteBuffer.hasRemaining(); b1++) {
      if (a.c[b1] != paramByteBuffer.get()) {
        paramByteBuffer.reset();
        return a.b.b;
      } 
    } 
    return a.b.a;
  }
  
  public void a(b paramb) throws d {
    if (!k && this.m == d.a.b)
      throw new AssertionError("shall only be called once"); 
    this.t = (a)this.p.a(paramb);
    this.x = paramb.a();
    if (!k && this.x == null)
      throw new AssertionError(); 
    try {
      this.n.a(this, this.t);
    } catch (b b1) {
      throw new d("Handshake data rejected by client.");
    } catch (RuntimeException runtimeException) {
      this.n.a(this, runtimeException);
      throw new d("rejected because of" + runtimeException);
    } 
    a(this.p.a((f)this.t, this.q));
  }
  
  private void f(ByteBuffer paramByteBuffer) {
    if (b)
      System.out.println("write(" + paramByteBuffer.remaining() + "): {" + ((paramByteBuffer.remaining() > 1000) ? "too big to display" : new String(paramByteBuffer.array())) + "}"); 
    this.h.add(paramByteBuffer);
    this.n.b(this);
  }
  
  private void a(List<ByteBuffer> paramList) {
    for (ByteBuffer byteBuffer : paramList)
      f(byteBuffer); 
  }
  
  private void a(f paramf) {
    if (b)
      System.out.println("open using draft: " + this.p.getClass().getSimpleName()); 
    this.m = d.a.c;
    try {
      this.n.a(this, paramf);
    } catch (RuntimeException runtimeException) {
      this.n.a(this, runtimeException);
    } 
  }
  
  public boolean e() {
    if (k || !this.l || this.m == d.a.b)
      return (this.m == d.a.b); 
    throw new AssertionError();
  }
  
  public boolean f() {
    if (k || this.m != d.a.c || !this.l)
      return (this.m == d.a.c); 
    throw new AssertionError();
  }
  
  public boolean g() {
    return (this.m == d.a.d);
  }
  
  public boolean h() {
    return this.l;
  }
  
  public boolean i() {
    return (this.m == d.a.e);
  }
  
  public d.a k() {
    return this.m;
  }
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public String toString() {
    return super.toString();
  }
  
  public InetSocketAddress c() {
    return this.n.d(this);
  }
  
  public InetSocketAddress d() {
    return this.n.c(this);
  }
  
  public a j() {
    return this.p;
  }
  
  public void a() {
    a(1000);
  }
  
  public String l() {
    return this.x;
  }
  
  static {
    a = 16384;
    b = false;
    c = new ArrayList<a>(4);
    c.add(new c());
    c.add(new b());
    c.add(new e());
    c.add(new d());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */