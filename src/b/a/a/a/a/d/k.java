package b.a.a.a.a.d;

import b.a.a.a.d.i;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class k extends FilterInputStream {
  private byte[] a = new byte[1024];
  
  private int b = -1;
  
  private int c = 1024;
  
  private static final int d = 1024;
  
  private int e = 1024;
  
  private boolean f = false;
  
  private long g = 0L;
  
  public k(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  public void a(int paramInt, boolean paramBoolean) throws IOException {
    this.f = paramBoolean;
    this.c = 1024 * paramInt;
    byte[] arrayOfByte = this.a;
    this.a = new byte[this.c];
    System.arraycopy(arrayOfByte, 0, this.a, 0, 1024);
    a(this.a, 1024, this.c - 1024);
    this.b = 0;
    this.e = 1024;
  }
  
  public int available() throws IOException {
    return (this.e < this.c) ? (this.c - this.e) : this.in.available();
  }
  
  public int read() throws IOException {
    throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
  }
  
  public int read(byte[] b, int off, int len) throws IOException {
    if (len % 1024 != 0)
      throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes."); 
    int i = 0;
    while (i < len) {
      if (this.e == this.c && !a(true))
        return -1; 
      int j = 0;
      if (this.e + len - i <= this.c) {
        j = len - i;
      } else {
        j = this.c - this.e;
      } 
      System.arraycopy(this.a, this.e, b, off, j);
      this.e += j;
      i += j;
      off += j;
    } 
    return i;
  }
  
  public long skip(long len) throws IOException {
    if (len % 1024L != 0L)
      throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes."); 
    long l;
    for (l = 0L; l < len; l += l1) {
      if (this.e == this.c && !a((len - l < this.c)))
        return -1L; 
      long l1 = 0L;
      if (this.e + len - l <= this.c) {
        l1 = len - l;
      } else {
        l1 = (this.c - this.e);
      } 
      this.e = (int)(this.e + l1);
    } 
    return l;
  }
  
  public void close() throws IOException {
    if (this.in != null && this.in != System.in)
      this.in.close(); 
  }
  
  public byte[] a() throws IOException {
    if (this.e == this.c && !a(true))
      return null; 
    byte[] arrayOfByte = new byte[1024];
    System.arraycopy(this.a, this.e, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] b() throws IOException {
    byte[] arrayOfByte = new byte[1024];
    if (-1 == read(arrayOfByte, 0, arrayOfByte.length))
      throw new j(); 
    return arrayOfByte;
  }
  
  private boolean a(boolean paramBoolean) throws IOException {
    boolean bool = true;
    if (this.in == null)
      throw new IOException("input buffer is closed"); 
    if (!this.f || this.b == -1) {
      bool = a(this.a, 0, this.c);
      this.g += this.c;
    } else {
      if (!a(this.a, 0, 4))
        return false; 
      this.g += 4L;
      int i = h.b(this.a, 0);
      boolean bool1 = ((i & 0x1) == 1) ? true : false;
      if (!bool1) {
        bool = a(this.a, 0, this.c);
        this.g += this.c;
      } else {
        int j = i >> 1 & 0x7;
        int m = i >> 4 & 0xFFFFFFF;
        byte[] arrayOfByte = new byte[m];
        bool = a(arrayOfByte, 0, m);
        this.g += m;
        if (!paramBoolean) {
          Arrays.fill(this.a, (byte)0);
        } else {
          switch (null.a[b.a.a(j & 0x3).ordinal()]) {
            case 1:
              try {
                Inflater inflater = new Inflater();
                inflater.setInput(arrayOfByte, 0, arrayOfByte.length);
                m = inflater.inflate(this.a);
                if (m != this.c)
                  throw new j(); 
                inflater.end();
              } catch (DataFormatException dataFormatException) {
                throw new d("bad data", dataFormatException);
              } 
              this.b++;
              this.e = 0;
              return bool;
            case 2:
              throw new m("BZLIB2");
            case 3:
              throw new m("LZO");
          } 
          throw new m();
        } 
      } 
    } 
    this.b++;
    this.e = 0;
    return bool;
  }
  
  private boolean a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = i.a(this.in, paramArrayOfbyte, paramInt1, paramInt2);
    if (i < paramInt2)
      throw new j(); 
    return true;
  }
  
  public long c() {
    return this.g;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */