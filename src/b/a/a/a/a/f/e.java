package b.a.a.a.a.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

class e extends InputStream {
  private final RandomAccessFile a;
  
  private long b;
  
  public e(RandomAccessFile paramRandomAccessFile, long paramLong) {
    this.a = paramRandomAccessFile;
    this.b = paramLong;
  }
  
  public int read() throws IOException {
    if (this.b > 0L) {
      this.b--;
      return this.a.read();
    } 
    return -1;
  }
  
  public int read(byte[] b, int off, int len) throws IOException {
    if (this.b == 0L)
      return -1; 
    int i = len;
    if (i > this.b)
      i = (int)this.b; 
    int j = this.a.read(b, off, i);
    if (j >= 0)
      this.b -= j; 
    return j;
  }
  
  public void close() {}
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */