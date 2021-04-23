package b.a.a.a.a.a;

import b.a.a.a.a.a;
import b.a.a.a.a.c;
import b.a.a.a.d.a;
import b.a.a.a.d.i;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class b extends c {
  private final InputStream b;
  
  private long c = 0L;
  
  private boolean d;
  
  private a e = null;
  
  private byte[] f = null;
  
  private long g = -1L;
  
  private final byte[] h = new byte[16];
  
  private final byte[] i = new byte[12];
  
  private final byte[] j = new byte[6];
  
  private final byte[] k = new byte[8];
  
  private final byte[] l = new byte[10];
  
  static final String a = "#1/";
  
  private static final int m = "#1/".length();
  
  private static final String n = "^#1/\\d+";
  
  private static final String o = "//";
  
  private static final String p = "^/\\d+";
  
  public b(InputStream paramInputStream) {
    this.b = paramInputStream;
    this.d = false;
  }
  
  public a d() throws IOException {
    if (this.e != null) {
      long l1 = this.g + this.e.f();
      i.a((InputStream)this, l1 - this.c);
      this.e = null;
    } 
    if (this.c == 0L) {
      byte[] arrayOfByte3 = a.a("!<arch>\n");
      byte[] arrayOfByte4 = new byte[arrayOfByte3.length];
      int m = i.a((InputStream)this, arrayOfByte4);
      if (m != arrayOfByte3.length)
        throw new IOException("failed to read header. Occured at byte: " + c()); 
      for (byte b1 = 0; b1 < arrayOfByte3.length; b1++) {
        if (arrayOfByte3[b1] != arrayOfByte4[b1])
          throw new IOException("invalid header " + a.a(arrayOfByte4)); 
      } 
    } 
    if (this.c % 2L != 0L && read() < 0)
      return null; 
    if (this.b.available() == 0)
      return null; 
    i.a((InputStream)this, this.h);
    i.a((InputStream)this, this.i);
    i.a((InputStream)this, this.j);
    int i = a(this.j, true);
    i.a((InputStream)this, this.j);
    i.a((InputStream)this, this.k);
    i.a((InputStream)this, this.l);
    byte[] arrayOfByte1 = a.a("`\n");
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    int j = i.a((InputStream)this, arrayOfByte2);
    if (j != arrayOfByte1.length)
      throw new IOException("failed to read entry trailer. Occured at byte: " + c()); 
    int k;
    for (k = 0; k < arrayOfByte1.length; k++) {
      if (arrayOfByte1[k] != arrayOfByte2[k])
        throw new IOException("invalid entry trailer. not read the content? Occured at byte: " + c()); 
    } 
    this.g = this.c;
    String str = a.a(this.h).trim();
    if (c(str)) {
      this.e = c(this.l);
      return d();
    } 
    long l = a(this.l);
    if (str.endsWith("/")) {
      str = str.substring(0, str.length() - 1);
    } else if (d(str)) {
      k = Integer.parseInt(str.substring(1));
      str = b(k);
    } else if (a(str)) {
      str = b(str);
      k = str.length();
      l -= k;
      this.g += k;
    } 
    this.e = new a(str, l, i, a(this.j, true), b(this.k, 8), a(this.i));
    return this.e;
  }
  
  private String b(int paramInt) throws IOException {
    if (this.f == null)
      throw new IOException("Cannot process GNU long filename as no // record was found"); 
    for (int i = paramInt; i < this.f.length; i++) {
      if (this.f[i] == 10) {
        if (this.f[i - 1] == 47)
          i--; 
        return a.a(this.f, paramInt, i - paramInt);
      } 
    } 
    throw new IOException("Failed to read entry: " + paramInt);
  }
  
  private long a(byte[] paramArrayOfbyte) {
    return Long.parseLong(a.a(paramArrayOfbyte).trim());
  }
  
  private int b(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 10, false);
  }
  
  private int a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    return a(paramArrayOfbyte, 10, paramBoolean);
  }
  
  private int b(byte[] paramArrayOfbyte, int paramInt) {
    return a(paramArrayOfbyte, paramInt, false);
  }
  
  private int a(byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
    String str = a.a(paramArrayOfbyte).trim();
    return (str.length() == 0 && paramBoolean) ? 0 : Integer.parseInt(str, paramInt);
  }
  
  public a a() throws IOException {
    return d();
  }
  
  public void close() throws IOException {
    if (!this.d) {
      this.d = true;
      this.b.close();
    } 
    this.e = null;
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    int i = len;
    if (this.e != null) {
      long l = this.g + this.e.f();
      if (len > 0 && l > this.c) {
        i = (int)Math.min(len, l - this.c);
      } else {
        return -1;
      } 
    } 
    int j = this.b.read(arrayOfByte, off, i);
    a(j);
    this.c += (j > 0) ? j : 0L;
    return j;
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < 8) ? false : ((paramArrayOfbyte[0] != 33) ? false : ((paramArrayOfbyte[1] != 60) ? false : ((paramArrayOfbyte[2] != 97) ? false : ((paramArrayOfbyte[3] != 114) ? false : ((paramArrayOfbyte[4] != 99) ? false : ((paramArrayOfbyte[5] != 104) ? false : ((paramArrayOfbyte[6] != 62) ? false : (!(paramArrayOfbyte[7] != 10)))))))));
  }
  
  private static boolean a(String paramString) {
    return (paramString != null && paramString.matches("^#1/\\d+"));
  }
  
  private String b(String paramString) throws IOException {
    int i = Integer.parseInt(paramString.substring(m));
    byte[] arrayOfByte = new byte[i];
    int j = i.a(this.b, arrayOfByte);
    a(j);
    if (j != i)
      throw new EOFException(); 
    return a.a(arrayOfByte);
  }
  
  private static boolean c(String paramString) {
    return "//".equals(paramString);
  }
  
  private a c(byte[] paramArrayOfbyte) throws IOException {
    int i = b(paramArrayOfbyte);
    this.f = new byte[i];
    int j = i.a((InputStream)this, this.f, 0, i);
    if (j != i)
      throw new IOException("Failed to read complete // record: expected=" + i + " read=" + j); 
    return new a("//", i);
  }
  
  private boolean d(String paramString) {
    return (paramString != null && paramString.matches("^/\\d+"));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/a/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */