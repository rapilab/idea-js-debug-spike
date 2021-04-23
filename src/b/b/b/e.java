package b.b.b;

import b.b.c.a;
import b.b.c.b;
import b.b.c.c;
import b.b.c.d;
import b.b.d;
import b.b.d.b;
import b.b.d.d;
import b.b.e.a;
import b.b.e.b;
import b.b.e.c;
import b.b.e.f;
import b.b.e.h;
import b.b.e.i;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class e extends d {
  private boolean m = false;
  
  private static final byte[] n = new byte[] { -1, 0 };
  
  private final Random o = new Random();
  
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws d {
    MessageDigest messageDigest;
    byte[] arrayOfByte1 = a(paramString1);
    byte[] arrayOfByte2 = a(paramString2);
    byte[] arrayOfByte3 = new byte[16];
    arrayOfByte3[0] = arrayOfByte1[0];
    arrayOfByte3[1] = arrayOfByte1[1];
    arrayOfByte3[2] = arrayOfByte1[2];
    arrayOfByte3[3] = arrayOfByte1[3];
    arrayOfByte3[4] = arrayOfByte2[0];
    arrayOfByte3[5] = arrayOfByte2[1];
    arrayOfByte3[6] = arrayOfByte2[2];
    arrayOfByte3[7] = arrayOfByte2[3];
    arrayOfByte3[8] = paramArrayOfbyte[0];
    arrayOfByte3[9] = paramArrayOfbyte[1];
    arrayOfByte3[10] = paramArrayOfbyte[2];
    arrayOfByte3[11] = paramArrayOfbyte[3];
    arrayOfByte3[12] = paramArrayOfbyte[4];
    arrayOfByte3[13] = paramArrayOfbyte[5];
    arrayOfByte3[14] = paramArrayOfbyte[6];
    arrayOfByte3[15] = paramArrayOfbyte[7];
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } 
    return messageDigest.digest(arrayOfByte3);
  }
  
  private static String f() {
    Random random = new Random();
    long l1 = 4294967295L;
    long l2 = (random.nextInt(12) + 1);
    int i = (new Long(l1 / l2)).intValue();
    i = Math.abs(i);
    int j = random.nextInt(i) + 1;
    long l3 = j * l2;
    String str = Long.toString(l3);
    int k = random.nextInt(12) + 1;
    byte b;
    for (b = 0; b < k; b++) {
      int m = random.nextInt(str.length());
      m = Math.abs(m);
      char c = (char)(random.nextInt(95) + 33);
      if (c >= '0' && c <= '9')
        c = (char)(c - 15); 
      str = (new StringBuilder(str)).insert(m, c).toString();
    } 
    for (b = 0; b < l2; b++) {
      int m = random.nextInt(str.length() - 1) + 1;
      m = Math.abs(m);
      str = (new StringBuilder(str)).insert(m, " ").toString();
    } 
    return str;
  }
  
  private static byte[] a(String paramString) throws d {
    try {
      long l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      long l2 = ((paramString.split(" ")).length - 1);
      if (l2 == 0L)
        throw new d("invalid Sec-WebSocket-Key (/key2/)"); 
      long l3 = (new Long(l1 / l2)).longValue();
      return new byte[] { (byte)(int)(l3 >> 24L), (byte)(int)(l3 << 8L >> 24L), (byte)(int)(l3 << 16L >> 24L), (byte)(int)(l3 << 24L >> 24L) };
    } catch (NumberFormatException numberFormatException) {
      throw new d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    } 
  }
  
  public a.b a(a parama, h paramh) {
    if (this.m)
      return a.b.b; 
    try {
      if (!paramh.b("Sec-WebSocket-Origin").equals(parama.b("Origin")) || !a((f)paramh))
        return a.b.b; 
      byte[] arrayOfByte = paramh.d();
      if (arrayOfByte == null || arrayOfByte.length == 0)
        throw new a(); 
      return Arrays.equals(arrayOfByte, a(parama.b("Sec-WebSocket-Key1"), parama.b("Sec-WebSocket-Key2"), parama.d())) ? a.b.a : a.b.b;
    } catch (d d1) {
      throw new RuntimeException("bad handshakerequest", d1);
    } 
  }
  
  public a.b a(a parama) {
    return (parama.b("Upgrade").equals("WebSocket") && parama.b("Connection").contains("Upgrade") && parama.b("Sec-WebSocket-Key1").length() > 0 && !parama.b("Sec-WebSocket-Key2").isEmpty() && parama.c("Origin")) ? a.b.a : a.b.b;
  }
  
  public b a(b paramb) {
    paramb.a("Upgrade", "WebSocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Key1", f());
    paramb.a("Sec-WebSocket-Key2", f());
    if (!paramb.c("Origin"))
      paramb.a("Origin", "random" + this.o.nextInt()); 
    byte[] arrayOfByte = new byte[8];
    this.o.nextBytes(arrayOfByte);
    paramb.a(arrayOfByte);
    return paramb;
  }
  
  public c a(a parama, i parami) throws d {
    parami.a("WebSocket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Sec-WebSocket-Origin", parama.b("Origin"));
    String str1 = "ws://" + parama.b("Host") + parama.a();
    parami.a("Sec-WebSocket-Location", str1);
    String str2 = parama.b("Sec-WebSocket-Key1");
    String str3 = parama.b("Sec-WebSocket-Key2");
    byte[] arrayOfByte = parama.d();
    if (str2 == null || str3 == null || arrayOfByte == null || arrayOfByte.length != 8)
      throw new d("Bad keys"); 
    parami.a(a(str2, str3, arrayOfByte));
    return (c)parami;
  }
  
  public f d(ByteBuffer paramByteBuffer) throws d {
    c c = a(paramByteBuffer, this.d);
    if ((c.c("Sec-WebSocket-Key1") || this.d == d.b.a) && !c.c("Sec-WebSocket-Version")) {
      byte[] arrayOfByte = new byte[(this.d == d.b.b) ? 8 : 16];
      try {
        paramByteBuffer.get(arrayOfByte);
      } catch (BufferUnderflowException bufferUnderflowException) {
        throw new a(paramByteBuffer.capacity() + 16);
      } 
      c.a(arrayOfByte);
    } 
    return (f)c;
  }
  
  public List<d> c(ByteBuffer paramByteBuffer) throws b {
    paramByteBuffer.mark();
    List<d> list = e(paramByteBuffer);
    if (list == null) {
      paramByteBuffer.reset();
      list = this.k;
      this.j = true;
      if (this.l == null) {
        this.l = ByteBuffer.allocate(2);
      } else {
        throw new c();
      } 
      if (paramByteBuffer.remaining() > this.l.remaining())
        throw new c(); 
      this.l.put(paramByteBuffer);
      if (!this.l.hasRemaining()) {
        if (Arrays.equals(this.l.array(), n)) {
          list.add(new b(1000));
          return list;
        } 
        throw new c();
      } 
      this.k = new LinkedList<d>();
      return list;
    } 
    return list;
  }
  
  public ByteBuffer a(d paramd) {
    return (paramd.f() == d.a.f) ? ByteBuffer.wrap(n) : super.a(paramd);
  }
  
  public a.a b() {
    return a.a.b;
  }
  
  public a c() {
    return new e();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/b/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */