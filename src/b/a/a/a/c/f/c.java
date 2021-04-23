package b.a.a.a.c.f;

import b.a.a.a.c.b;
import b.a.a.a.d.i;
import java.io.IOException;
import java.io.InputStream;

public class c extends b {
  private static final int b = 3;
  
  public static final int a = 32768;
  
  private final byte[] c;
  
  private int d;
  
  private int e;
  
  private final int f;
  
  private final InputStream g;
  
  private final int h;
  
  private int i;
  
  private final byte[] j = new byte[1];
  
  private boolean k = false;
  
  public c(InputStream paramInputStream) throws IOException {
    this(paramInputStream, 32768);
  }
  
  public c(InputStream paramInputStream, int paramInt) throws IOException {
    this.g = paramInputStream;
    this.f = paramInt;
    this.c = new byte[paramInt * 3];
    this.d = this.e = 0;
    this.i = this.h = (int)f();
  }
  
  public int read() throws IOException {
    return (read(this.j, 0, 1) == -1) ? -1 : (this.j[0] & 0xFF);
  }
  
  public void close() throws IOException {
    this.g.close();
  }
  
  public int available() {
    return this.d - this.e;
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    if (this.k)
      return -1; 
    int i = available();
    if (len > i)
      b(len - i); 
    int j = Math.min(len, available());
    System.arraycopy(this.c, this.e, arrayOfByte, off, j);
    this.e += j;
    if (this.e > this.f)
      d(); 
    return j;
  }
  
  private void b(int paramInt) throws IOException {
    if (this.i == 0)
      this.k = true; 
    int i = Math.min(paramInt, this.i);
    while (i > 0) {
      int j = e();
      int k = 0;
      long l = 0L;
      switch (j & 0x3) {
        case 0:
          k = c(j);
          if (d(k))
            return; 
          break;
        case 1:
          k = 4 + (j >> 2 & 0x7);
          l = ((j & 0xE0) << 3);
          l |= e();
          if (a(l, k))
            return; 
          break;
        case 2:
          k = (j >> 2) + 1;
          l = e();
          l |= (e() << 8);
          if (a(l, k))
            return; 
          break;
        case 3:
          k = (j >> 2) + 1;
          l = e();
          l |= (e() << 8);
          l |= (e() << 16);
          l |= e() << 24L;
          if (a(l, k))
            return; 
          break;
      } 
      i -= k;
      this.i -= k;
    } 
  }
  
  private void d() {
    System.arraycopy(this.c, this.f, this.c, 0, this.f * 2);
    this.d -= this.f;
    this.e -= this.f;
  }
  
  private int c(int paramInt) throws IOException {
    switch (paramInt >> 2) {
      case 60:
        i = e();
        return i + 1;
      case 61:
        i = e();
        i |= e() << 8;
        return i + 1;
      case 62:
        i = e();
        i |= e() << 8;
        i |= e() << 16;
        return i + 1;
      case 63:
        i = e();
        i |= e() << 8;
        i |= e() << 16;
        i = (int)(i | e() << 24L);
        return i + 1;
    } 
    int i = paramInt >> 2;
    return i + 1;
  }
  
  private boolean d(int paramInt) throws IOException {
    int i = i.a(this.g, this.c, this.d, paramInt);
    a(i);
    if (paramInt != i)
      throw new IOException("Premature end of stream"); 
    this.d += paramInt;
    return (this.d >= 2 * this.f);
  }
  
  private boolean a(long paramLong, int paramInt) throws IOException {
    if (paramLong > this.f)
      throw new IOException("Offset is larger than block size"); 
    int i = (int)paramLong;
    if (i == 1) {
      byte b1 = this.c[this.d - 1];
      for (byte b2 = 0; b2 < paramInt; b2++)
        this.c[this.d++] = b1; 
    } else if (paramInt < i) {
      System.arraycopy(this.c, this.d - i, this.c, this.d, paramInt);
      this.d += paramInt;
    } else {
      int j = paramInt / i;
      int k = paramInt - i * j;
      while (j-- != 0) {
        System.arraycopy(this.c, this.d - i, this.c, this.d, i);
        this.d += i;
      } 
      if (k > 0) {
        System.arraycopy(this.c, this.d - i, this.c, this.d, k);
        this.d += k;
      } 
    } 
    return (this.d >= 2 * this.f);
  }
  
  private int e() throws IOException {
    int i = this.g.read();
    if (i == -1)
      throw new IOException("Premature end of stream"); 
    a(1);
    return i & 0xFF;
  }
  
  private long f() throws IOException {
    byte b1 = 0;
    long l = 0L;
    int i = 0;
    while (true) {
      i = e();
      l |= ((i & 0x7F) << b1++ * 7);
      if (0 == (i & 0x80))
        return l; 
    } 
  }
  
  public int a() {
    return this.h;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/f/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */