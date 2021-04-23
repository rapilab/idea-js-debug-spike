package b.a.a.a.a.g;

import b.a.a.a.a.a;
import b.a.a.a.a.c;
import b.a.a.a.a.h.D;
import b.a.a.a.a.h.E;
import b.a.a.a.d.a;
import b.a.a.a.d.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class b extends c {
  private static final int a = 256;
  
  private final byte[] b = new byte[256];
  
  private final int c;
  
  private final int d;
  
  private boolean e;
  
  private long f;
  
  private long g;
  
  private final InputStream h;
  
  private a i;
  
  private final D j;
  
  public b(InputStream paramInputStream) {
    this(paramInputStream, 10240, 512);
  }
  
  public b(InputStream paramInputStream, String paramString) {
    this(paramInputStream, 10240, 512, paramString);
  }
  
  public b(InputStream paramInputStream, int paramInt) {
    this(paramInputStream, paramInt, 512);
  }
  
  public b(InputStream paramInputStream, int paramInt, String paramString) {
    this(paramInputStream, paramInt, 512, paramString);
  }
  
  public b(InputStream paramInputStream, int paramInt1, int paramInt2) {
    this(paramInputStream, paramInt1, paramInt2, (String)null);
  }
  
  public b(InputStream paramInputStream, int paramInt1, int paramInt2, String paramString) {
    this.h = paramInputStream;
    this.e = false;
    this.j = E.a(paramString);
    this.c = paramInt2;
    this.d = paramInt1;
  }
  
  public void close() throws IOException {
    this.h.close();
  }
  
  public int d() {
    return this.c;
  }
  
  public int available() throws IOException {
    return (this.f - this.g > 2147483647L) ? Integer.MAX_VALUE : (int)(this.f - this.g);
  }
  
  public long skip(long n) throws IOException {
    if (n <= 0L)
      return 0L; 
    long l1 = this.f - this.g;
    long l2 = this.h.skip(Math.min(n, l1));
    a(l2);
    this.g += l2;
    return l2;
  }
  
  public boolean markSupported() {
    return false;
  }
  
  public void mark(int markLimit) {}
  
  public synchronized void reset() {}
  
  public a e() throws IOException {
    if (this.e)
      return null; 
    if (this.i != null) {
      i.a((InputStream)this, Long.MAX_VALUE);
      j();
    } 
    byte[] arrayOfByte = k();
    if (arrayOfByte == null) {
      this.i = null;
      return null;
    } 
    try {
      this.i = new a(arrayOfByte, this.j);
    } catch (IllegalArgumentException illegalArgumentException) {
      IOException iOException = new IOException("Error detected parsing the header");
      iOException.initCause(illegalArgumentException);
      throw iOException;
    } 
    this.g = 0L;
    this.f = this.i.getSize();
    if (this.i.p()) {
      byte[] arrayOfByte1 = f();
      if (arrayOfByte1 == null)
        return null; 
      this.i.b(this.j.a(arrayOfByte1));
    } 
    if (this.i.q()) {
      byte[] arrayOfByte1 = f();
      if (arrayOfByte1 == null)
        return null; 
      this.i.a(this.j.a(arrayOfByte1));
    } 
    if (this.i.r())
      l(); 
    if (this.i.o())
      m(); 
    this.f = this.i.getSize();
    return this.i;
  }
  
  private void j() throws IOException {
    if (this.f > 0L && this.f % this.c != 0L) {
      long l1 = this.f / this.c + 1L;
      long l2 = l1 * this.c - this.f;
      long l3 = i.a(this.h, l2);
      a(l3);
    } 
  }
  
  protected byte[] f() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while ((i = read(this.b)) >= 0)
      byteArrayOutputStream.write(this.b, 0, i); 
    a();
    if (this.i == null)
      return null; 
    byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    for (i = arrayOfByte.length; i > 0 && arrayOfByte[i - 1] == 0; i--);
    if (i != arrayOfByte.length) {
      byte[] arrayOfByte1 = new byte[i];
      System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, i);
      arrayOfByte = arrayOfByte1;
    } 
    return arrayOfByte;
  }
  
  private byte[] k() throws IOException {
    byte[] arrayOfByte = g();
    this.e = a(arrayOfByte);
    if (this.e && arrayOfByte != null) {
      n();
      o();
      arrayOfByte = null;
    } 
    return arrayOfByte;
  }
  
  protected boolean a(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null || a.a(paramArrayOfbyte, this.c));
  }
  
  protected byte[] g() throws IOException {
    byte[] arrayOfByte = new byte[this.c];
    int i = i.a(this.h, arrayOfByte);
    a(i);
    return (i != this.c) ? null : arrayOfByte;
  }
  
  private void l() throws IOException {
    Map<String, String> map = a((InputStream)this);
    a();
    a(map);
  }
  
  Map<String, String> a(InputStream paramInputStream) throws IOException {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    while (true) {
      int j = 0;
      byte b1 = 0;
      int i;
      while ((i = paramInputStream.read()) != -1) {
        b1++;
        if (i == 32) {
          ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
          while ((i = paramInputStream.read()) != -1) {
            b1++;
            if (i == 61) {
              String str1 = byteArrayOutputStream.toString("UTF-8");
              int k = j - b1;
              byte[] arrayOfByte = new byte[k];
              int m = i.a(paramInputStream, arrayOfByte);
              if (m != k)
                throw new IOException("Failed to read Paxheader. Expected " + k + " bytes, read " + m); 
              String str2 = new String(arrayOfByte, 0, k - 1, "UTF-8");
              hashMap.put(str1, str2);
              break;
            } 
            byteArrayOutputStream.write((byte)i);
          } 
          break;
        } 
        j *= 10;
        j += i - 48;
      } 
      if (i == -1)
        return (Map)hashMap; 
    } 
  }
  
  private void a(Map<String, String> paramMap) {
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      String str1 = (String)entry.getKey();
      String str2 = (String)entry.getValue();
      if ("path".equals(str1)) {
        this.i.a(str2);
        continue;
      } 
      if ("linkpath".equals(str1)) {
        this.i.b(str2);
        continue;
      } 
      if ("gid".equals(str1)) {
        this.i.c(Integer.parseInt(str2));
        continue;
      } 
      if ("gname".equals(str1)) {
        this.i.d(str2);
        continue;
      } 
      if ("uid".equals(str1)) {
        this.i.b(Integer.parseInt(str2));
        continue;
      } 
      if ("uname".equals(str1)) {
        this.i.c(str2);
        continue;
      } 
      if ("size".equals(str1)) {
        this.i.b(Long.parseLong(str2));
        continue;
      } 
      if ("mtime".equals(str1)) {
        this.i.a((long)(Double.parseDouble(str2) * 1000.0D));
        continue;
      } 
      if ("SCHILY.devminor".equals(str1)) {
        this.i.e(Integer.parseInt(str2));
        continue;
      } 
      if ("SCHILY.devmajor".equals(str1))
        this.i.d(Integer.parseInt(str2)); 
    } 
  }
  
  private void m() throws IOException {
    if (this.i.m()) {
      d d;
      do {
        byte[] arrayOfByte = k();
        if (arrayOfByte == null) {
          this.i = null;
          break;
        } 
        d = new d(arrayOfByte);
      } while (d.a());
    } 
  }
  
  public a a() throws IOException {
    return e();
  }
  
  private void n() throws IOException {
    boolean bool = true;
    boolean bool1 = this.h.markSupported();
    if (bool1)
      this.h.mark(this.c); 
    try {
      bool = !a(g()) ? true : false;
    } finally {
      if (bool && bool1) {
        b(this.c);
        this.h.reset();
      } 
    } 
  }
  
  public int read(byte[] buf, int offset, int numToRead) throws IOException {
    int i = 0;
    if (this.e || this.g >= this.f)
      return -1; 
    if (this.i == null)
      throw new IllegalStateException("No current tar entry"); 
    numToRead = Math.min(numToRead, available());
    i = this.h.read(buf, offset, numToRead);
    if (i == -1) {
      if (numToRead > 0)
        throw new IOException("Truncated TAR archive"); 
      this.e = true;
    } else {
      a(i);
      this.g += i;
    } 
    return i;
  }
  
  public boolean a(a parama) {
    if (parama instanceof a) {
      a a1 = (a)parama;
      return !a1.o();
    } 
    return false;
  }
  
  public a h() {
    return this.i;
  }
  
  protected final void a(a parama) {
    this.i = parama;
  }
  
  protected final boolean i() {
    return this.e;
  }
  
  protected final void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  private void o() throws IOException {
    long l = c() % this.d;
    if (l > 0L) {
      long l1 = i.a(this.h, this.d - l);
      a(l1);
    } 
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < 265) ? false : ((a.a("ustar\000", paramArrayOfbyte, 257, 6) && a.a("00", paramArrayOfbyte, 263, 2)) ? true : ((a.a("ustar ", paramArrayOfbyte, 257, 6) && (a.a(" \000", paramArrayOfbyte, 263, 2) || a.a("0\000", paramArrayOfbyte, 263, 2))) ? true : ((a.a("ustar\000", paramArrayOfbyte, 257, 6) && a.a("\000\000", paramArrayOfbyte, 263, 2)))));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/g/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */