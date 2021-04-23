package b.a.a.a.c.e;

import b.a.a.a.c.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

public class b extends b {
  private final InputStream a;
  
  private final i b;
  
  private static final byte[] c = new byte[] { -54, -2, -48, 13 };
  
  private static final int d = c.length;
  
  public b(InputStream paramInputStream) throws IOException {
    this(paramInputStream, e.a);
  }
  
  public b(InputStream paramInputStream, e parame) throws IOException {
    this(paramInputStream, null, parame, null);
  }
  
  public b(InputStream paramInputStream, Map<String, String> paramMap) throws IOException {
    this(paramInputStream, e.a, paramMap);
  }
  
  public b(InputStream paramInputStream, e parame, Map<String, String> paramMap) throws IOException {
    this(paramInputStream, null, parame, paramMap);
  }
  
  public b(File paramFile) throws IOException {
    this(paramFile, e.a);
  }
  
  public b(File paramFile, e parame) throws IOException {
    this(null, paramFile, parame, null);
  }
  
  public b(File paramFile, Map<String, String> paramMap) throws IOException {
    this(paramFile, e.a, paramMap);
  }
  
  public b(File paramFile, e parame, Map<String, String> paramMap) throws IOException {
    this(null, paramFile, parame, paramMap);
  }
  
  private b(InputStream paramInputStream, File paramFile, e parame, Map<String, String> paramMap) throws IOException {
    this.a = paramInputStream;
    this.b = parame.b();
    JarOutputStream jarOutputStream = new JarOutputStream(this.b);
    Pack200.Unpacker unpacker = Pack200.newUnpacker();
    if (paramMap != null)
      unpacker.properties().putAll(paramMap); 
    if (paramFile == null) {
      unpacker.unpack(new c(this, paramInputStream), jarOutputStream);
    } else {
      unpacker.unpack(paramFile, jarOutputStream);
    } 
    jarOutputStream.close();
  }
  
  public int read() throws IOException {
    return this.b.b().read();
  }
  
  public int read(byte[] arrayOfByte) throws IOException {
    return this.b.b().read(arrayOfByte);
  }
  
  public int read(byte[] arrayOfByte, int off, int count) throws IOException {
    return this.b.b().read(arrayOfByte, off, count);
  }
  
  public int available() throws IOException {
    return this.b.b().available();
  }
  
  public boolean markSupported() {
    try {
      return this.b.b().markSupported();
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  public void mark(int limit) {
    try {
      this.b.b().mark(limit);
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  public void reset() throws IOException {
    this.b.b().reset();
  }
  
  public long skip(long count) throws IOException {
    return this.b.b().skip(count);
  }
  
  public void close() throws IOException {
    try {
      this.b.c();
    } finally {
      if (this.a != null)
        this.a.close(); 
    } 
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt < d)
      return false; 
    for (byte b1 = 0; b1 < d; b1++) {
      if (paramArrayOfbyte[b1] != c[b1])
        return false; 
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */