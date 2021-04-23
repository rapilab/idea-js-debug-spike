package b.a.a.a.c.e;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class j extends i {
  private final File a = File.createTempFile("commons-compress", "packtemp");
  
  j() throws IOException {
    this.a.deleteOnExit();
    this.out = new FileOutputStream(this.a);
  }
  
  InputStream a() throws IOException {
    this.out.close();
    return new k(this, this.a);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e/j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */