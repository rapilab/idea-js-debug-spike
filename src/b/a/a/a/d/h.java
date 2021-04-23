package b.a.a.a.d;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class h extends FilterOutputStream {
  private long a = 0L;
  
  public h(OutputStream paramOutputStream) {
    super(paramOutputStream);
  }
  
  public void write(int b) throws IOException {
    this.out.write(b);
    a(1L);
  }
  
  public void write(byte[] b) throws IOException {
    write(b, 0, b.length);
  }
  
  public void write(byte[] b, int off, int len) throws IOException {
    this.out.write(b, off, len);
    a(len);
  }
  
  protected void a(long paramLong) {
    if (paramLong != -1L)
      this.a += paramLong; 
  }
  
  public long a() {
    return this.a;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */