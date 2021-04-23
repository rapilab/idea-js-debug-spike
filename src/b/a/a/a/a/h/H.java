package b.a.a.a.a.h;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

class H extends InflaterInputStream {
  H(G paramG, InputStream paramInputStream, Inflater paramInflater1, Inflater paramInflater2) {
    super(paramInputStream, paramInflater1);
  }
  
  public void close() throws IOException {
    super.close();
    this.a.end();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/H.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */