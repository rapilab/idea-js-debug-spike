package b.a.a.a.a.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

class n extends j {
  n() {
    super(new Class[] { Number.class });
  }
  
  InputStream a(InputStream paramInputStream, long paramLong, i parami, byte[] paramArrayOfbyte) throws IOException {
    return (new DeltaOptions(a(parami))).getInputStream(paramInputStream);
  }
  
  OutputStream a(OutputStream paramOutputStream, Object paramObject) throws IOException {
    int i = a(paramObject, 1);
    try {
      return (OutputStream)(new DeltaOptions(i)).getOutputStream((FinishableOutputStream)new FinishableWrapperOutputStream(paramOutputStream));
    } catch (UnsupportedOptionsException unsupportedOptionsException) {
      throw new IOException(unsupportedOptionsException.getMessage());
    } 
  }
  
  byte[] b(Object paramObject) {
    return new byte[] { (byte)(a(paramObject, 1) - 1) };
  }
  
  Object a(i parami, InputStream paramInputStream) {
    return Integer.valueOf(a(parami));
  }
  
  private int a(i parami) {
    return (parami.d == null || parami.d.length == 0) ? 1 : ((0xFF & parami.d[0]) + 1);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */