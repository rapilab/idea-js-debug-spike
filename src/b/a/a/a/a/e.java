package b.a.a.a.a;

import b.a.a.a.a.a.b;
import b.a.a.a.a.a.c;
import b.a.a.a.a.b.b;
import b.a.a.a.a.c.b;
import b.a.a.a.a.c.c;
import b.a.a.a.a.d.e;
import b.a.a.a.a.e.b;
import b.a.a.a.a.e.c;
import b.a.a.a.a.f.s;
import b.a.a.a.a.g.b;
import b.a.a.a.a.g.c;
import b.a.a.a.a.h.A;
import b.a.a.a.a.h.z;
import b.a.a.a.d.i;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class e {
  public static final String a = "ar";
  
  public static final String b = "arj";
  
  public static final String c = "cpio";
  
  public static final String d = "dump";
  
  public static final String e = "jar";
  
  public static final String f = "tar";
  
  public static final String g = "zip";
  
  public static final String h = "7z";
  
  private String i = null;
  
  public String a() {
    return this.i;
  }
  
  public void a(String paramString) {
    this.i = paramString;
  }
  
  public c a(String paramString, InputStream paramInputStream) throws b {
    if (paramString == null)
      throw new IllegalArgumentException("Archivername must not be null."); 
    if (paramInputStream == null)
      throw new IllegalArgumentException("InputStream must not be null."); 
    if ("ar".equalsIgnoreCase(paramString))
      return (c)new b(paramInputStream); 
    if ("arj".equalsIgnoreCase(paramString))
      return (c)((this.i != null) ? new b(paramInputStream, this.i) : new b(paramInputStream)); 
    if ("zip".equalsIgnoreCase(paramString))
      return (c)((this.i != null) ? new z(paramInputStream, this.i) : new z(paramInputStream)); 
    if ("tar".equalsIgnoreCase(paramString))
      return (c)((this.i != null) ? new b(paramInputStream, this.i) : new b(paramInputStream)); 
    if ("jar".equalsIgnoreCase(paramString))
      return (c)new b(paramInputStream); 
    if ("cpio".equalsIgnoreCase(paramString))
      return (c)((this.i != null) ? new b(paramInputStream, this.i) : new b(paramInputStream)); 
    if ("dump".equalsIgnoreCase(paramString))
      return (c)((this.i != null) ? new e(paramInputStream, this.i) : new e(paramInputStream)); 
    if ("7z".equalsIgnoreCase(paramString))
      throw new g("7z"); 
    throw new b("Archiver: " + paramString + " not found.");
  }
  
  public d a(String paramString, OutputStream paramOutputStream) throws b {
    if (paramString == null)
      throw new IllegalArgumentException("Archivername must not be null."); 
    if (paramOutputStream == null)
      throw new IllegalArgumentException("OutputStream must not be null."); 
    if ("ar".equalsIgnoreCase(paramString))
      return (d)new c(paramOutputStream); 
    if ("zip".equalsIgnoreCase(paramString)) {
      A a = new A(paramOutputStream);
      if (this.i != null)
        a.a(this.i); 
      return (d)a;
    } 
    if ("tar".equalsIgnoreCase(paramString))
      return (d)((this.i != null) ? new c(paramOutputStream, this.i) : new c(paramOutputStream)); 
    if ("jar".equalsIgnoreCase(paramString))
      return (d)new c(paramOutputStream); 
    if ("cpio".equalsIgnoreCase(paramString))
      return (d)((this.i != null) ? new c(paramOutputStream, this.i) : new c(paramOutputStream)); 
    if ("7z".equalsIgnoreCase(paramString))
      throw new g("7z"); 
    throw new b("Archiver: " + paramString + " not found.");
  }
  
  public c a(InputStream paramInputStream) throws b {
    if (paramInputStream == null)
      throw new IllegalArgumentException("Stream must not be null."); 
    if (!paramInputStream.markSupported())
      throw new IllegalArgumentException("Mark is not supported."); 
    byte[] arrayOfByte = new byte[12];
    paramInputStream.mark(arrayOfByte.length);
    try {
      int i = i.a(paramInputStream, arrayOfByte);
      paramInputStream.reset();
      if (z.b(arrayOfByte, i))
        return (c)((this.i != null) ? new z(paramInputStream, this.i) : new z(paramInputStream)); 
      if (b.a(arrayOfByte, i))
        return (c)new b(paramInputStream); 
      if (b.a(arrayOfByte, i))
        return (c)new b(paramInputStream); 
      if (b.a(arrayOfByte, i))
        return (c)new b(paramInputStream); 
      if (b.a(arrayOfByte, i))
        return (c)new b(paramInputStream); 
      if (s.a(arrayOfByte, i))
        throw new g("7z"); 
      byte[] arrayOfByte1 = new byte[32];
      paramInputStream.mark(arrayOfByte1.length);
      i = i.a(paramInputStream, arrayOfByte1);
      paramInputStream.reset();
      if (e.a(arrayOfByte1, i))
        return (c)new e(paramInputStream); 
      byte[] arrayOfByte2 = new byte[512];
      paramInputStream.mark(arrayOfByte2.length);
      i = i.a(paramInputStream, arrayOfByte2);
      paramInputStream.reset();
      if (b.a(arrayOfByte2, i))
        return (c)((this.i != null) ? new b(paramInputStream, this.i) : new b(paramInputStream)); 
      if (i >= 512) {
        b b = null;
        try {
          b = new b(new ByteArrayInputStream(arrayOfByte2));
          if (b.e().h())
            return (c)new b(paramInputStream); 
        } catch (Exception exception) {
        
        } finally {
          i.a((Closeable)b);
        } 
      } 
    } catch (IOException iOException) {
      throw new b("Could not use reset and mark operations.", iOException);
    } 
    throw new b("No Archiver found for the stream signature");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */