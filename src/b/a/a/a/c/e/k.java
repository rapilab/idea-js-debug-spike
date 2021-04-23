package b.a.a.a.c.e;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class k extends FileInputStream {
  k(j paramj, File paramFile) {
    super(paramFile);
  }
  
  public void close() throws IOException {
    super.close();
    j.a(this.a).delete();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e/k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */