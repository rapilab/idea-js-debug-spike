package b.a.a.a.c.g;

import b.a.a.a.c.c;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

public class b extends c {
  private final XZOutputStream a;
  
  public b(OutputStream paramOutputStream) throws IOException {
    this.a = new XZOutputStream(paramOutputStream, (FilterOptions)new LZMA2Options());
  }
  
  public b(OutputStream paramOutputStream, int paramInt) throws IOException {
    this.a = new XZOutputStream(paramOutputStream, (FilterOptions)new LZMA2Options(paramInt));
  }
  
  public void write(int i) throws IOException {
    this.a.write(i);
  }
  
  public void write(byte[] buf, int off, int len) throws IOException {
    this.a.write(buf, off, len);
  }
  
  public void flush() throws IOException {
    this.a.flush();
  }
  
  public void a() throws IOException {
    this.a.finish();
  }
  
  public void close() throws IOException {
    this.a.close();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/g/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */