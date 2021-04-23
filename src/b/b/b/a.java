package b.b.b;

import b.b.c.d;
import b.b.c.e;
import b.b.d;
import b.b.d.d;
import b.b.d.e;
import b.b.e.c;
import b.b.e.d;
import b.b.e.e;
import b.b.e.f;
import b.b.e.h;
import b.b.e.i;
import b.b.g.c;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a {
  public static int a = 1000;
  
  public static int b = 64;
  
  public static final byte[] c = c.a("<policy-file-request/>\000");
  
  protected d.b d = null;
  
  protected d.a e = null;
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1 = 48;
    byte b2 = 48;
    while (paramByteBuffer.hasRemaining()) {
      b1 = b2;
      b2 = paramByteBuffer.get();
      byteBuffer.put(b2);
      if (b1 == 13 && b2 == 10) {
        byteBuffer.limit(byteBuffer.position() - 2);
        byteBuffer.position(0);
        return byteBuffer;
      } 
    } 
    paramByteBuffer.position(paramByteBuffer.position() - byteBuffer.position());
    return null;
  }
  
  public static String b(ByteBuffer paramByteBuffer) {
    ByteBuffer byteBuffer = a(paramByteBuffer);
    return (byteBuffer == null) ? null : c.a(byteBuffer.array(), 0, byteBuffer.limit());
  }
  
  public static c a(ByteBuffer paramByteBuffer, d.b paramb) throws d, b.b.c.a {
    d d;
    String str = b(paramByteBuffer);
    if (str == null)
      throw new b.b.c.a(paramByteBuffer.capacity() + 128); 
    String[] arrayOfString = str.split(" ", 3);
    if (arrayOfString.length != 3)
      throw new d(); 
    if (paramb == d.b.a) {
      e e = new e();
      i i = (i)e;
      i.a(Short.parseShort(arrayOfString[1]));
      i.a(arrayOfString[2]);
    } else {
      d d1 = new d();
      d1.a(arrayOfString[1]);
      d = d1;
    } 
    for (str = b(paramByteBuffer); str != null && str.length() > 0; str = b(paramByteBuffer)) {
      String[] arrayOfString1 = str.split(":", 2);
      if (arrayOfString1.length != 2)
        throw new d("not an http header"); 
      d.a(arrayOfString1[0], arrayOfString1[1].replaceFirst("^ +", ""));
    } 
    if (str == null)
      throw new b.b.c.a(); 
    return (c)d;
  }
  
  public abstract b a(b.b.e.a parama, h paramh) throws d;
  
  public abstract b a(b.b.e.a parama) throws d;
  
  protected boolean a(f paramf) {
    return (paramf.b("Upgrade").equalsIgnoreCase("websocket") && paramf.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public abstract ByteBuffer a(d paramd);
  
  public abstract List<d> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract List<d> a(String paramString, boolean paramBoolean);
  
  public List<d> a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean) {
    if (parama != d.a.c && parama != d.a.b && parama != d.a.b)
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed"); 
    if (this.e != null) {
      this.e = d.a.a;
    } else {
      this.e = parama;
    } 
    e e = new e(this.e);
    try {
      e.a(paramByteBuffer);
    } catch (b.b.c.b b1) {
      throw new RuntimeException(b1);
    } 
    e.a(paramBoolean);
    if (paramBoolean) {
      this.e = null;
    } else {
      this.e = parama;
    } 
    return (List)Collections.singletonList(e);
  }
  
  public abstract void a();
  
  public List<ByteBuffer> a(f paramf, d.b paramb) {
    return a(paramf, paramb, true);
  }
  
  public List<ByteBuffer> a(f paramf, d.b paramb, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder(100);
    if (paramf instanceof b.b.e.a) {
      stringBuilder.append("GET ");
      stringBuilder.append(((b.b.e.a)paramf).a());
      stringBuilder.append(" HTTP/1.1");
    } else if (paramf instanceof h) {
      stringBuilder.append("HTTP/1.1 101 " + ((h)paramf).a());
    } else {
      throw new RuntimeException("unknow role");
    } 
    stringBuilder.append("\r\n");
    Iterator<String> iterator = paramf.c();
    while (iterator.hasNext()) {
      String str1 = iterator.next();
      String str2 = paramf.b(str1);
      stringBuilder.append(str1);
      stringBuilder.append(": ");
      stringBuilder.append(str2);
      stringBuilder.append("\r\n");
    } 
    stringBuilder.append("\r\n");
    byte[] arrayOfByte1 = c.b(stringBuilder.toString());
    byte[] arrayOfByte2 = paramBoolean ? paramf.d() : null;
    ByteBuffer byteBuffer = ByteBuffer.allocate(((arrayOfByte2 == null) ? 0 : arrayOfByte2.length) + arrayOfByte1.length);
    byteBuffer.put(arrayOfByte1);
    if (arrayOfByte2 != null)
      byteBuffer.put(arrayOfByte2); 
    byteBuffer.flip();
    return Collections.singletonList(byteBuffer);
  }
  
  public abstract b.b.e.b a(b.b.e.b paramb) throws d;
  
  public abstract c a(b.b.e.a parama, i parami) throws d;
  
  public abstract List<d> c(ByteBuffer paramByteBuffer) throws b.b.c.b;
  
  public abstract a b();
  
  public abstract a c();
  
  public f d(ByteBuffer paramByteBuffer) throws d {
    return (f)a(paramByteBuffer, this.d);
  }
  
  public int a(int paramInt) throws e, b.b.c.b {
    if (paramInt < 0)
      throw new b.b.c.b(1002, "Negative count"); 
    return paramInt;
  }
  
  public void a(d.b paramb) {
    this.d = paramb;
  }
  
  public d.b d() {
    return this.d;
  }
  
  public enum a {
    a, b, c;
    
    public static a[] a() {
      return (a[])d.clone();
    }
    
    public static a a(String param1String) {
      return Enum.<a>valueOf(a.class, param1String);
    }
  }
  
  public enum b {
    a, b;
    
    public static b[] a() {
      return (b[])c.clone();
    }
    
    public static b a(String param1String) {
      return Enum.<b>valueOf(b.class, param1String);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/b/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */