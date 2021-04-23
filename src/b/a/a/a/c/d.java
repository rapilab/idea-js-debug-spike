package b.a.a.a.c;

import b.a.a.a.c.a.a;
import b.a.a.a.c.a.b;
import b.a.a.a.c.b.a;
import b.a.a.a.c.b.b;
import b.a.a.a.c.c.a;
import b.a.a.a.c.c.b;
import b.a.a.a.c.d.a;
import b.a.a.a.c.e.b;
import b.a.a.a.c.e.d;
import b.a.a.a.c.f.a;
import b.a.a.a.c.f.c;
import b.a.a.a.c.g.a;
import b.a.a.a.c.g.b;
import b.a.a.a.c.g.c;
import b.a.a.a.c.h.a;
import b.a.a.a.d.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d {
  public static final String a = "bzip2";
  
  public static final String b = "gz";
  
  public static final String c = "pack200";
  
  public static final String d = "xz";
  
  public static final String e = "lzma";
  
  public static final String f = "snappy-framed";
  
  public static final String g = "snappy-raw";
  
  public static final String h = "z";
  
  public static final String i = "deflate";
  
  private boolean j = false;
  
  public void a(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public b a(InputStream paramInputStream) throws a {
    if (paramInputStream == null)
      throw new IllegalArgumentException("Stream must not be null."); 
    if (!paramInputStream.markSupported())
      throw new IllegalArgumentException("Mark is not supported."); 
    byte[] arrayOfByte = new byte[12];
    paramInputStream.mark(arrayOfByte.length);
    try {
      int i = i.a(paramInputStream, arrayOfByte);
      paramInputStream.reset();
      if (a.a(arrayOfByte, i))
        return (b)new a(paramInputStream, this.j); 
      if (a.a(arrayOfByte, i))
        return (b)new a(paramInputStream, this.j); 
      if (b.a(arrayOfByte, i))
        return (b)new b(paramInputStream); 
      if (a.a(arrayOfByte, i))
        return (b)new a(paramInputStream); 
      if (a.a(arrayOfByte, i))
        return (b)new a(paramInputStream); 
      if (c.a(arrayOfByte, i) && c.a())
        return (b)new a(paramInputStream, this.j); 
    } catch (IOException iOException) {
      throw new a("Failed to detect Compressor from InputStream.", iOException);
    } 
    throw new a("No Compressor found for the stream signature.");
  }
  
  public b a(String paramString, InputStream paramInputStream) throws a {
    if (paramString == null || paramInputStream == null)
      throw new IllegalArgumentException("Compressor name and stream must not be null."); 
    try {
      if ("gz".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream, this.j); 
      if ("bzip2".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream, this.j); 
      if ("xz".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream, this.j); 
      if ("lzma".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream); 
      if ("pack200".equalsIgnoreCase(paramString))
        return (b)new b(paramInputStream); 
      if ("snappy-raw".equalsIgnoreCase(paramString))
        return (b)new c(paramInputStream); 
      if ("snappy-framed".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream); 
      if ("z".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream); 
      if ("deflate".equalsIgnoreCase(paramString))
        return (b)new a(paramInputStream); 
    } catch (IOException iOException) {
      throw new a("Could not create CompressorInputStream.", iOException);
    } 
    throw new a("Compressor: " + paramString + " not found.");
  }
  
  public c a(String paramString, OutputStream paramOutputStream) throws a {
    if (paramString == null || paramOutputStream == null)
      throw new IllegalArgumentException("Compressor name and stream must not be null."); 
    try {
      if ("gz".equalsIgnoreCase(paramString))
        return (c)new b(paramOutputStream); 
      if ("bzip2".equalsIgnoreCase(paramString))
        return (c)new b(paramOutputStream); 
      if ("xz".equalsIgnoreCase(paramString))
        return (c)new b(paramOutputStream); 
      if ("pack200".equalsIgnoreCase(paramString))
        return (c)new d(paramOutputStream); 
      if ("deflate".equalsIgnoreCase(paramString))
        return (c)new b(paramOutputStream); 
    } catch (IOException iOException) {
      throw new a("Could not create CompressorOutputStream", iOException);
    } 
    throw new a("Compressor: " + paramString + " not found.");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */