package b.a.a.a.c.b;

import b.a.a.a.c.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class a extends b {
  private final InputStream a;
  
  public a(InputStream paramInputStream) {
    this(paramInputStream, new c());
  }
  
  public a(InputStream paramInputStream, c paramc) {
    this.a = new InflaterInputStream(paramInputStream, new Inflater(!paramc.a()));
  }
  
  public int read() throws IOException {
    int i = this.a.read();
    a((i == -1) ? 0 : 1);
    return i;
  }
  
  public int read(byte[] buf, int off, int len) throws IOException {
    int i = this.a.read(buf, off, len);
    a(i);
    return i;
  }
  
  public long skip(long n) throws IOException {
    return this.a.skip(n);
  }
  
  public int available() throws IOException {
    return this.a.available();
  }
  
  public void close() throws IOException {
    this.a.close();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/b/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */