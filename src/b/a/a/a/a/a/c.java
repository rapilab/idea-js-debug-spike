package b.a.a.a.a.a;

import b.a.a.a.a.a;
import b.a.a.a.a.d;
import b.a.a.a.d.a;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class c extends d {
  public static final int b = 0;
  
  public static final int c = 1;
  
  private final OutputStream d;
  
  private long e = 0L;
  
  private a f;
  
  private boolean g = false;
  
  private int h = 0;
  
  private boolean i = false;
  
  public c(OutputStream paramOutputStream) {
    this.d = paramOutputStream;
  }
  
  public void b(int paramInt) {
    this.h = paramInt;
  }
  
  private long e() throws IOException {
    byte[] arrayOfByte = a.a("!<arch>\n");
    this.d.write(arrayOfByte);
    return arrayOfByte.length;
  }
  
  public void a() throws IOException {
    if (this.i)
      throw new IOException("Stream has already been finished"); 
    if (this.f == null || !this.g)
      throw new IOException("No current entry to close"); 
    if (this.e % 2L != 0L)
      this.d.write(10); 
    this.g = false;
  }
  
  public void a(a parama) throws IOException {
    if (this.i)
      throw new IOException("Stream has already been finished"); 
    a a1 = (a)parama;
    if (this.f == null) {
      e();
    } else {
      if (this.f.f() != this.e)
        throw new IOException("length does not match entry (" + this.f.f() + " != " + this.e); 
      if (this.g)
        a(); 
    } 
    this.f = a1;
    a(a1);
    this.e = 0L;
    this.g = true;
  }
  
  private long a(long paramLong1, long paramLong2, char paramChar) throws IOException {
    long l = paramLong2 - paramLong1;
    if (l > 0L)
      for (byte b = 0; b < l; b++)
        write(paramChar);  
    return paramLong2;
  }
  
  private long a(String paramString) throws IOException {
    byte[] arrayOfByte = paramString.getBytes("ascii");
    write(arrayOfByte);
    return arrayOfByte.length;
  }
  
  private long a(a parama) throws IOException {
    long l = 0L;
    boolean bool = false;
    String str1 = parama.getName();
    if (0 == this.h && str1.length() > 16)
      throw new IOException("filename too long, > 16 chars: " + str1); 
    if (1 == this.h && (str1.length() > 16 || str1.indexOf(" ") > -1)) {
      bool = true;
      l += a("#1/" + String.valueOf(str1.length()));
    } else {
      l += a(str1);
    } 
    l = a(l, 16L, ' ');
    String str2 = "" + parama.e();
    if (str2.length() > 12)
      throw new IOException("modified too long"); 
    l += a(str2);
    l = a(l, 28L, ' ');
    String str3 = "" + parama.b();
    if (str3.length() > 6)
      throw new IOException("userid too long"); 
    l += a(str3);
    l = a(l, 34L, ' ');
    String str4 = "" + parama.c();
    if (str4.length() > 6)
      throw new IOException("groupid too long"); 
    l += a(str4);
    l = a(l, 40L, ' ');
    String str5 = "" + Integer.toString(parama.d(), 8);
    if (str5.length() > 8)
      throw new IOException("filemode too long"); 
    l += a(str5);
    l = a(l, 48L, ' ');
    String str6 = String.valueOf(parama.f() + (bool ? str1.length() : 0L));
    if (str6.length() > 10)
      throw new IOException("size too long"); 
    l += a(str6);
    l = a(l, 58L, ' ');
    l += a("`\n");
    if (bool)
      l += a(str1); 
    return l;
  }
  
  public void write(byte[] b, int off, int len) throws IOException {
    this.d.write(b, off, len);
    a(len);
    this.e += len;
  }
  
  public void close() throws IOException {
    if (!this.i)
      b(); 
    this.d.close();
    this.f = null;
  }
  
  public a a(File paramFile, String paramString) throws IOException {
    if (this.i)
      throw new IOException("Stream has already been finished"); 
    return new a(paramFile, paramString);
  }
  
  public void b() throws IOException {
    if (this.g)
      throw new IOException("This archive contains unclosed entries."); 
    if (this.i)
      throw new IOException("This archive has already been finished"); 
    this.i = true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/a/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */