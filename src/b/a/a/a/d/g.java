package b.a.a.a.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class g extends FilterInputStream {
  private long a;
  
  public g(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  public int read() throws IOException {
    int i = this.in.read();
    if (i >= 0)
      a(1L); 
    return i;
  }
  
  public int read(byte[] b) throws IOException {
    return read(b, 0, b.length);
  }
  
  public int read(byte[] b, int off, int len) throws IOException {
    int i = this.in.read(b, off, len);
    if (i >= 0)
      a(i); 
    return i;
  }
  
  protected final void a(long paramLong) {
    if (paramLong != -1L)
      this.a += paramLong; 
  }
  
  public long a() {
    return this.a;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */