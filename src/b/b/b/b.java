package b.b.b;

import b.b.c.c;
import b.b.c.d;
import b.b.c.e;
import b.b.c.f;
import b.b.d;
import b.b.d.d;
import b.b.d.e;
import b.b.e.c;
import b.b.e.f;
import b.b.e.h;
import b.b.e.i;
import b.b.g.c;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class b extends a {
  private ByteBuffer g;
  
  private d h = null;
  
  private final Random i = new Random();
  
  public static int b(f paramf) {
    String str = paramf.b("Sec-WebSocket-Version");
    if (str.length() > 0)
      try {
        return (new Integer(str.trim())).intValue();
      } catch (NumberFormatException numberFormatException) {
        return -1;
      }  
    return -1;
  }
  
  public a.b a(b.b.e.a parama, h paramh) throws d {
    if (!parama.c("Sec-WebSocket-Key") || !paramh.c("Sec-WebSocket-Accept"))
      return a.b.b; 
    String str1 = paramh.b("Sec-WebSocket-Accept");
    String str2 = parama.b("Sec-WebSocket-Key");
    str2 = a(str2);
    return str2.equals(str1) ? a.b.a : a.b.b;
  }
  
  public a.b a(b.b.e.a parama) throws d {
    int i = b((f)parama);
    return (i == 7 || i == 8) ? (a((f)parama) ? a.b.a : a.b.b) : a.b.b;
  }
  
  public ByteBuffer a(d paramd) {
    ByteBuffer byteBuffer1 = paramd.c();
    boolean bool = (this.d == d.b.a) ? true : false;
    byte b1 = (byteBuffer1.remaining() <= 125) ? 1 : ((byteBuffer1.remaining() <= 65535) ? 2 : 8);
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(1 + ((b1 > 1) ? (b1 + 1) : b1) + (bool ? 4 : 0) + byteBuffer1.remaining());
    byte b2 = a(paramd.f());
    byte b3 = (byte)(paramd.d() ? Byte.MIN_VALUE : 0);
    b3 = (byte)(b3 | b2);
    byteBuffer2.put(b3);
    byte[] arrayOfByte = a(byteBuffer1.remaining(), b1);
    if (!f && arrayOfByte.length != b1)
      throw new AssertionError(); 
    if (b1 == 1) {
      byteBuffer2.put((byte)(arrayOfByte[0] | (bool ? Byte.MIN_VALUE : 0)));
    } else if (b1 == 2) {
      byteBuffer2.put((byte)(0x7E | (bool ? Byte.MIN_VALUE : 0)));
      byteBuffer2.put(arrayOfByte);
    } else if (b1 == 8) {
      byteBuffer2.put((byte)(Byte.MAX_VALUE | (bool ? Byte.MIN_VALUE : 0)));
      byteBuffer2.put(arrayOfByte);
    } else {
      throw new RuntimeException("Size representation not supported/specified");
    } 
    if (bool) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(4);
      byteBuffer.putInt(this.i.nextInt());
      byteBuffer2.put(byteBuffer.array());
      for (byte b4 = 0; byteBuffer1.hasRemaining(); b4++)
        byteBuffer2.put((byte)(byteBuffer1.get() ^ byteBuffer.get(b4 % 4))); 
    } else {
      byteBuffer2.put(byteBuffer1);
    } 
    if (!f && byteBuffer2.remaining() != 0)
      throw new AssertionError(byteBuffer2.remaining()); 
    byteBuffer2.flip();
    return byteBuffer2;
  }
  
  public List<d> a(ByteBuffer paramByteBuffer, boolean paramBoolean) {
    e e = new e();
    try {
      e.a(paramByteBuffer);
    } catch (b.b.c.b b1) {
      throw new f(b1);
    } 
    e.a(true);
    e.a(d.a.c);
    e.b(paramBoolean);
    return (List)Collections.singletonList(e);
  }
  
  public List<d> a(String paramString, boolean paramBoolean) {
    e e = new e();
    try {
      e.a(ByteBuffer.wrap(c.a(paramString)));
    } catch (b.b.c.b b1) {
      throw new f(b1);
    } 
    e.a(true);
    e.a(d.a.b);
    e.b(paramBoolean);
    return (List)Collections.singletonList(e);
  }
  
  private byte a(d.a parama) {
    if (parama == d.a.a)
      return 0; 
    if (parama == d.a.b)
      return 1; 
    if (parama == d.a.c)
      return 2; 
    if (parama == d.a.f)
      return 8; 
    if (parama == d.a.d)
      return 9; 
    if (parama == d.a.e)
      return 10; 
    throw new RuntimeException("Don't know how to handle " + parama.toString());
  }
  
  private String a(String paramString) {
    MessageDigest messageDigest;
    String str1 = paramString.trim();
    String str2 = str1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try {
      messageDigest = MessageDigest.getInstance("SHA1");
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } 
    return b.b.g.a.a(messageDigest.digest(str2.getBytes()));
  }
  
  public b.b.e.b a(b.b.e.b paramb) {
    paramb.a("Upgrade", "websocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.i.nextBytes(arrayOfByte);
    paramb.a("Sec-WebSocket-Key", b.b.g.a.a(arrayOfByte));
    return paramb;
  }
  
  public c a(b.b.e.a parama, i parami) throws d {
    parami.a("Upgrade", "websocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Switching Protocols");
    String str = parama.b("Sec-WebSocket-Key");
    if (str == null)
      throw new d("missing Sec-WebSocket-Key"); 
    parami.a("Sec-WebSocket-Accept", a(str));
    return (c)parami;
  }
  
  private byte[] a(long paramLong, int paramInt) {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 8 * paramInt - 8;
    for (byte b1 = 0; b1 < paramInt; b1++)
      arrayOfByte[b1] = (byte)(int)(paramLong >>> i - 8 * b1); 
    return arrayOfByte;
  }
  
  private d.a a(byte paramByte) throws c {
    switch (paramByte) {
      case 0:
        return d.a.a;
      case 1:
        return d.a.b;
      case 2:
        return d.a.c;
      case 8:
        return d.a.f;
      case 9:
        return d.a.d;
      case 10:
        return d.a.e;
    } 
    throw new c("unknow optcode " + (short)paramByte);
  }
  
  public List<d> c(ByteBuffer paramByteBuffer) throws e, b.b.c.b {
    LinkedList<d> linkedList = new LinkedList();
    if (this.g != null)
      try {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.g.remaining();
        if (j > i) {
          this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(paramByteBuffer.position() + i);
          return Collections.emptyList();
        } 
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        d d1 = e((ByteBuffer)this.g.duplicate().position(0));
        linkedList.add(d1);
        this.g = null;
      } catch (a a1) {
        int i = this.g.limit();
        ByteBuffer byteBuffer = ByteBuffer.allocate(a(a1.a()));
        if (!f && byteBuffer.limit() <= this.g.limit())
          throw new AssertionError(); 
        this.g.rewind();
        byteBuffer.put(this.g);
        this.g = byteBuffer;
        return c(paramByteBuffer);
      }  
    while (paramByteBuffer.hasRemaining()) {
      paramByteBuffer.mark();
      try {
        d d1 = e(paramByteBuffer);
        linkedList.add(d1);
      } catch (a a1) {
        paramByteBuffer.reset();
        int i = a1.a();
        this.g = ByteBuffer.allocate(a(i));
        this.g.put(paramByteBuffer);
        break;
      } 
    } 
    return linkedList;
  }
  
  public d e(ByteBuffer paramByteBuffer) throws a, b.b.c.b {
    e e;
    int i = paramByteBuffer.remaining();
    int j = 2;
    if (i < j)
      throw new a(this, j); 
    byte b1 = paramByteBuffer.get();
    boolean bool1 = (b1 >> 8 != 0) ? true : false;
    byte b2 = (byte)((b1 & Byte.MAX_VALUE) >> 4);
    if (b2 != 0)
      throw new c("bad rsv " + b2); 
    byte b3 = paramByteBuffer.get();
    boolean bool2 = ((b3 & Byte.MIN_VALUE) != 0) ? true : false;
    int k = (byte)(b3 & Byte.MAX_VALUE);
    d.a a1 = a((byte)(b1 & 0xF));
    if (!bool1 && (a1 == d.a.d || a1 == d.a.e || a1 == d.a.f))
      throw new c("control frames may no be fragmented"); 
    if (k < 0 || k > 125) {
      if (a1 == d.a.d || a1 == d.a.e || a1 == d.a.f)
        throw new c("more than 125 octets"); 
      if (k == 126) {
        j += 2;
        if (i < j)
          throw new a(this, j); 
        byte[] arrayOfByte = new byte[3];
        arrayOfByte[1] = paramByteBuffer.get();
        arrayOfByte[2] = paramByteBuffer.get();
        int m = (new BigInteger(arrayOfByte)).intValue();
      } else {
        j += 8;
        if (i < j)
          throw new a(this, j); 
        byte[] arrayOfByte = new byte[8];
        for (byte b4 = 0; b4 < 8; b4++)
          arrayOfByte[b4] = paramByteBuffer.get(); 
        long l = (new BigInteger(arrayOfByte)).longValue();
        if (l > 2147483647L)
          throw new e("Payloadsize is to big..."); 
        k = (int)l;
      } 
    } 
    j += bool2 ? 4 : 0;
    j += k;
    if (i < j)
      throw new a(this, j); 
    ByteBuffer byteBuffer = ByteBuffer.allocate(a(k));
    if (bool2) {
      byte[] arrayOfByte = new byte[4];
      paramByteBuffer.get(arrayOfByte);
      for (byte b4 = 0; b4 < k; b4++)
        byteBuffer.put((byte)(paramByteBuffer.get() ^ arrayOfByte[b4 % 4])); 
    } else {
      byteBuffer.put(paramByteBuffer.array(), paramByteBuffer.position(), byteBuffer.limit());
      paramByteBuffer.position(paramByteBuffer.position() + byteBuffer.limit());
    } 
    if (a1 == d.a.f) {
      b.b.d.b b4 = new b.b.d.b();
    } else {
      e = new e();
      e.a(bool1);
      e.a(a1);
    } 
    byteBuffer.flip();
    e.a(byteBuffer);
    return (d)e;
  }
  
  public void a() {
    this.g = null;
  }
  
  public a c() {
    return new b();
  }
  
  public a.a b() {
    return a.a.c;
  }
  
  private class a extends Throwable {
    private static final long b = 7330519489840500997L;
    
    private int c;
    
    public a(b this$0, int param1Int) {
      this.c = param1Int;
    }
    
    public int a() {
      return this.c;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/b/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */