package b.a.a.a.c.e;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class i extends FilterOutputStream {
  private InputStream a;
  
  private final Object b = new Object();
  
  protected i(OutputStream paramOutputStream) {
    super(paramOutputStream);
  }
  
  protected i() {
    this(null);
  }
  
  InputStream b() throws IOException {
    synchronized (this.b) {
      if (this.a == null)
        this.a = a(); 
    } 
    return this.a;
  }
  
  abstract InputStream a() throws IOException;
  
  void c() throws IOException {
    close();
    synchronized (this.b) {
      if (this.a != null) {
        this.a.close();
        this.a = null;
      } 
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e/i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */