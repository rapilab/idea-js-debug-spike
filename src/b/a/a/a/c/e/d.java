package b.a.a.a.c.e;

import b.a.a.a.c.c;
import b.a.a.a.d.i;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.jar.JarInputStream;
import java.util.jar.Pack200;

public class d extends c {
  private boolean a = false;
  
  private final OutputStream b;
  
  private final i c;
  
  private final Map<String, String> d;
  
  public d(OutputStream paramOutputStream) throws IOException {
    this(paramOutputStream, e.a);
  }
  
  public d(OutputStream paramOutputStream, e parame) throws IOException {
    this(paramOutputStream, parame, null);
  }
  
  public d(OutputStream paramOutputStream, Map<String, String> paramMap) throws IOException {
    this(paramOutputStream, e.a, paramMap);
  }
  
  public d(OutputStream paramOutputStream, e parame, Map<String, String> paramMap) throws IOException {
    this.b = paramOutputStream;
    this.c = parame.b();
    this.d = paramMap;
  }
  
  public void write(int b) throws IOException {
    this.c.write(b);
  }
  
  public void write(byte[] b) throws IOException {
    this.c.write(b);
  }
  
  public void write(byte[] b, int from, int length) throws IOException {
    this.c.write(b, from, length);
  }
  
  public void close() throws IOException {
    a();
    try {
      this.c.c();
    } finally {
      this.b.close();
    } 
  }
  
  public void a() throws IOException {
    if (!this.a) {
      this.a = true;
      Pack200.Packer packer = Pack200.newPacker();
      if (this.d != null)
        packer.properties().putAll(this.d); 
      JarInputStream jarInputStream = null;
      boolean bool = false;
      try {
        packer.pack(jarInputStream = new JarInputStream(this.c.b()), this.b);
        bool = true;
      } finally {
        if (!bool)
          i.a(jarInputStream); 
      } 
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */