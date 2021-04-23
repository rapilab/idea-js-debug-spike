package b.a.a.a.a.e;

import b.a.a.a.a.h.y;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class a extends y {
  private final Attributes d = null;
  
  private final Certificate[] e = null;
  
  public a(ZipEntry paramZipEntry) throws ZipException {
    super(paramZipEntry);
  }
  
  public a(String paramString) {
    super(paramString);
  }
  
  public a(y paramy) throws ZipException {
    super(paramy);
  }
  
  public a(JarEntry paramJarEntry) throws ZipException {
    super(paramJarEntry);
  }
  
  public Attributes b() {
    return this.d;
  }
  
  public Certificate[] c() {
    if (this.e != null) {
      Certificate[] arrayOfCertificate = new Certificate[this.e.length];
      System.arraycopy(this.e, 0, arrayOfCertificate, 0, arrayOfCertificate.length);
      return arrayOfCertificate;
    } 
    return null;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/e/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */