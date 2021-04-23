package b.a.a.a.c.b;

import b.a.a.a.c.c;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class b extends c {
  private final DeflaterOutputStream a;
  
  public b(OutputStream paramOutputStream) throws IOException {
    this(paramOutputStream, new c());
  }
  
  public b(OutputStream paramOutputStream, c paramc) throws IOException {
    this.a = new DeflaterOutputStream(paramOutputStream, new Deflater(paramc.b(), !paramc.a()));
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


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/b/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */