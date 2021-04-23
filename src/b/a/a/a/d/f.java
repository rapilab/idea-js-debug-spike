package b.a.a.a.d;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

public class f extends InputStream {
  private final InputStream a;
  
  private long b;
  
  private final long c;
  
  private final Checksum d;
  
  public f(Checksum paramChecksum, InputStream paramInputStream, long paramLong1, long paramLong2) {
    this.d = paramChecksum;
    this.a = paramInputStream;
    this.c = paramLong2;
    this.b = paramLong1;
  }
  
  public int read() throws IOException {
    if (this.b <= 0L)
      return -1; 
    int i = this.a.read();
    if (i >= 0) {
      this.d.update(i);
      this.b--;
    } 
    if (this.b == 0L && this.c != this.d.getValue())
      throw new IOException("Checksum verification failed"); 
    return i;
  }
  
  public int read(byte[] b) throws IOException {
    return read(b, 0, b.length);
  }
  
  public int read(byte[] b, int off, int len) throws IOException {
    int i = this.a.read(b, off, len);
    if (i >= 0) {
      this.d.update(b, off, i);
      this.b -= i;
    } 
    if (this.b <= 0L && this.c != this.d.getValue())
      throw new IOException("Checksum verification failed"); 
    return i;
  }
  
  public long skip(long n) throws IOException {
    return (read() >= 0) ? 1L : 0L;
  }
  
  public void close() throws IOException {
    this.a.close();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */