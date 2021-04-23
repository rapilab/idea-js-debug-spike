package b.a.a.a.a.f;

import b.a.a.a.d.h;
import java.io.IOException;
import java.io.OutputStream;

class w extends h {
  w(v paramv, OutputStream paramOutputStream) {
    super(paramOutputStream);
  }
  
  public void write(int b) throws IOException {
    super.write(b);
    v.a(this.a).update(b);
  }
  
  public void write(byte[] b) throws IOException {
    super.write(b);
    v.a(this.a).update(b);
  }
  
  public void write(byte[] b, int off, int len) throws IOException {
    super.write(b, off, len);
    v.a(this.a).update(b, off, len);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/w.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */