package b.b.b;

import b.b.c.b;
import b.b.c.c;
import b.b.c.e;
import b.b.c.f;
import b.b.d.e;
import b.b.e.a;
import b.b.e.b;
import b.b.e.c;
import b.b.e.f;
import b.b.e.h;
import b.b.e.i;
import b.b.g.c;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class d extends a {
  public static final byte f = 13;
  
  public static final byte g = 10;
  
  public static final byte h = 0;
  
  public static final byte i = -1;
  
  protected boolean j = false;
  
  protected List<b.b.d.d> k = new LinkedList<b.b.d.d>();
  
  protected ByteBuffer l;
  
  private final Random m = new Random();
  
  public a.b a(a parama, h paramh) {
    return (parama.b("WebSocket-Origin").equals(paramh.b("Origin")) && a((f)paramh)) ? a.b.a : a.b.b;
  }
  
  public a.b a(a parama) {
    return (parama.c("Origin") && a((f)parama)) ? a.b.a : a.b.b;
  }
  
  public ByteBuffer a(b.b.d.d paramd) {
    if (paramd.f() != b.b.d.d.a.b)
      throw new RuntimeException("only text frames supported"); 
    ByteBuffer byteBuffer1 = paramd.c();
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer1.remaining() + 2);
    byteBuffer2.put((byte)0);
    byteBuffer1.mark();
    byteBuffer2.put(byteBuffer1);
    byteBuffer1.reset();
    byteBuffer2.put((byte)-1);
    byteBuffer2.flip();
    return byteBuffer2;
  }
  
  public List<b.b.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean) {
    throw new RuntimeException("not yet implemented");
  }
  
  public List<b.b.d.d> a(String paramString, boolean paramBoolean) {
    e e = new e();
    try {
      e.a(ByteBuffer.wrap(c.a(paramString)));
    } catch (b b) {
      throw new f(b);
    } 
    e.a(true);
    e.a(b.b.d.d.a.b);
    e.b(paramBoolean);
    return (List)Collections.singletonList(e);
  }
  
  public b a(b paramb) throws b.b.c.d {
    paramb.a("Upgrade", "WebSocket");
    paramb.a("Connection", "Upgrade");
    if (!paramb.c("Origin"))
      paramb.a("Origin", "random" + this.m.nextInt()); 
    return paramb;
  }
  
  public c a(a parama, i parami) throws b.b.c.d {
    parami.a("Web Socket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("WebSocket-Origin", parama.b("Origin"));
    String str = "ws://" + parama.b("Host") + parama.a();
    parami.a("WebSocket-Location", str);
    return (c)parami;
  }
  
  protected List<b.b.d.d> e(ByteBuffer paramByteBuffer) throws b {
    while (paramByteBuffer.hasRemaining()) {
      byte b = paramByteBuffer.get();
      if (b == 0) {
        if (this.j)
          throw new c("unexpected START_OF_FRAME"); 
        this.j = true;
        continue;
      } 
      if (b == -1) {
        if (!this.j)
          throw new c("unexpected END_OF_FRAME"); 
        if (this.l != null) {
          this.l.flip();
          e e = new e();
          e.a(this.l);
          e.a(true);
          e.a(b.b.d.d.a.b);
          this.k.add(e);
          this.l = null;
          paramByteBuffer.mark();
        } 
        this.j = false;
        continue;
      } 
      if (this.j) {
        if (this.l == null) {
          this.l = e();
        } else if (!this.l.hasRemaining()) {
          this.l = f(this.l);
        } 
        this.l.put(b);
        continue;
      } 
      return null;
    } 
    List<b.b.d.d> list = this.k;
    this.k = new LinkedList<b.b.d.d>();
    return list;
  }
  
  public List<b.b.d.d> c(ByteBuffer paramByteBuffer) throws b {
    List<b.b.d.d> list = e(paramByteBuffer);
    if (list == null)
      throw new b(1002); 
    return list;
  }
  
  public void a() {
    this.j = false;
    this.l = null;
  }
  
  public a.a b() {
    return a.a.a;
  }
  
  public ByteBuffer e() {
    return ByteBuffer.allocate(b);
  }
  
  public ByteBuffer f(ByteBuffer paramByteBuffer) throws e, b {
    paramByteBuffer.flip();
    ByteBuffer byteBuffer = ByteBuffer.allocate(a(paramByteBuffer.capacity() * 2));
    byteBuffer.put(paramByteBuffer);
    return byteBuffer;
  }
  
  public a c() {
    return new d();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/b/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */