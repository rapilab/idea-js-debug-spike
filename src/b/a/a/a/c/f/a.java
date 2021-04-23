package b.a.a.a.c.f;

import b.a.a.a.c.b;
import b.a.a.a.d.b;
import b.a.a.a.d.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;

public class a extends b {
  static final long a = 2726488792L;
  
  private static final int b = 255;
  
  private static final int c = 0;
  
  private static final int d = 1;
  
  private static final int e = 254;
  
  private static final int f = 2;
  
  private static final int g = 127;
  
  private static final int h = 253;
  
  private static final byte[] i = new byte[] { -1, 6, 0, 0, 115, 78, 97, 80, 112, 89 };
  
  private final PushbackInputStream j;
  
  private c k;
  
  private final byte[] l = new byte[1];
  
  private boolean m;
  
  private boolean n;
  
  private int o;
  
  private long p = -1L;
  
  private final b q = new b();
  
  public a(InputStream paramInputStream) throws IOException {
    this.j = new PushbackInputStream(paramInputStream, 1);
    g();
  }
  
  public int read() throws IOException {
    return (read(this.l, 0, 1) == -1) ? -1 : (this.l[0] & 0xFF);
  }
  
  public void close() throws IOException {
    if (this.k != null) {
      this.k.close();
      this.k = null;
    } 
    this.j.close();
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    int i = a(arrayOfByte, off, len);
    if (i == -1) {
      a();
      if (this.m)
        return -1; 
      i = a(arrayOfByte, off, len);
    } 
    return i;
  }
  
  public int available() throws IOException {
    return this.n ? Math.min(this.o, this.j.available()) : ((this.k != null) ? this.k.available() : 0);
  }
  
  private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = -1;
    if (this.n) {
      int j = Math.min(this.o, paramInt2);
      if (j == 0)
        return -1; 
      i = this.j.read(paramArrayOfbyte, paramInt1, j);
      if (i != -1) {
        this.o -= i;
        a(i);
      } 
    } else if (this.k != null) {
      long l = this.k.c();
      i = this.k.read(paramArrayOfbyte, paramInt1, paramInt2);
      if (i == -1) {
        this.k.close();
        this.k = null;
      } else {
        a(this.k.c() - l);
      } 
    } 
    if (i > 0)
      this.q.update(paramArrayOfbyte, paramInt1, i); 
    return i;
  }
  
  private void a() throws IOException {
    i();
    this.n = false;
    int i = h();
    if (i == -1) {
      this.m = true;
    } else if (i == 255) {
      this.j.unread(i);
      b(1L);
      g();
      a();
    } else if (i == 254 || (i > 127 && i <= 253)) {
      f();
      a();
    } else {
      if (i >= 2 && i <= 127)
        throw new IOException("unskippable chunk with type " + i + " (hex " + Integer.toHexString(i) + ")" + " detected."); 
      if (i == 1) {
        this.n = true;
        this.o = e() - 4;
        this.p = c(d());
      } else if (i == 0) {
        long l = (e() - 4);
        this.p = c(d());
        this.k = new c((InputStream)new b(this.j, l));
        a(this.k.c());
      } else {
        throw new IOException("unknown chunk type " + i + " detected.");
      } 
    } 
  }
  
  private long d() throws IOException {
    byte[] arrayOfByte = new byte[4];
    int i = i.a(this.j, arrayOfByte);
    a(i);
    if (i != 4)
      throw new IOException("premature end of stream"); 
    long l = 0L;
    for (byte b1 = 0; b1 < 4; b1++)
      l |= (arrayOfByte[b1] & 0xFFL) << 8 * b1; 
    return l;
  }
  
  static long c(long paramLong) {
    paramLong -= 2726488792L;
    paramLong &= 0xFFFFFFFFL;
    return (paramLong >> 17L | paramLong << 15L) & 0xFFFFFFFFL;
  }
  
  private int e() throws IOException {
    int i = 0;
    int j = 0;
    for (byte b1 = 0; b1 < 3; b1++) {
      i = h();
      if (i == -1)
        throw new IOException("premature end of stream"); 
      j |= i << b1 * 8;
    } 
    return j;
  }
  
  private void f() throws IOException {
    int i = e();
    long l = i.a(this.j, i);
    a(l);
    if (l != i)
      throw new IOException("premature end of stream"); 
  }
  
  private void g() throws IOException {
    byte[] arrayOfByte = new byte[10];
    int i = i.a(this.j, arrayOfByte);
    a(i);
    if (10 != i || !a(arrayOfByte, 10))
      throw new IOException("Not a framed Snappy stream"); 
  }
  
  private int h() throws IOException {
    int i = this.j.read();
    if (i != -1) {
      a(1);
      return i & 0xFF;
    } 
    return -1;
  }
  
  private void i() throws IOException {
    if (this.p >= 0L && this.p != this.q.getValue())
      throw new IOException("Checksum verification failed"); 
    this.p = -1L;
    this.q.reset();
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt < i.length)
      return false; 
    byte[] arrayOfByte = paramArrayOfbyte;
    if (paramArrayOfbyte.length > i.length) {
      arrayOfByte = new byte[i.length];
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, i.length);
    } 
    return Arrays.equals(arrayOfByte, i);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/f/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */