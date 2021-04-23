package b.a.a.a.d;

import java.io.IOException;
import java.io.InputStream;

public class b extends InputStream {
  private final InputStream a;
  
  private long b;
  
  public b(InputStream paramInputStream, long paramLong) {
    this.a = paramInputStream;
    this.b = paramLong;
  }
  
  public int read() throws IOException {
    if (this.b > 0L) {
      this.b--;
      return this.a.read();
    } 
    return -1;
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    if (this.b == 0L)
      return -1; 
    int i = len;
    if (i > this.b)
      i = (int)this.b; 
    int j = this.a.read(arrayOfByte, off, i);
    if (j >= 0)
      this.b -= j; 
    return j;
  }
  
  public void close() {}
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */