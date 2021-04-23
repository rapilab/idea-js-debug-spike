package b.a.a.a.a.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

class p extends j {
  p() {
    super(new Class[] { LZMA2Options.class, Number.class });
  }
  
  InputStream a(InputStream paramInputStream, long paramLong, i parami, byte[] paramArrayOfbyte) throws IOException {
    try {
      int k = a(parami);
      return (InputStream)new LZMA2InputStream(paramInputStream, k);
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IOException(illegalArgumentException.getMessage());
    } 
  }
  
  OutputStream a(OutputStream paramOutputStream, Object paramObject) throws IOException {
    LZMA2Options lZMA2Options = d(paramObject);
    FinishableWrapperOutputStream finishableWrapperOutputStream = new FinishableWrapperOutputStream(paramOutputStream);
    return (OutputStream)lZMA2Options.getOutputStream((FinishableOutputStream)finishableWrapperOutputStream);
  }
  
  byte[] b(Object paramObject) {
    int i = c(paramObject);
    int k = Integer.numberOfLeadingZeros(i);
    int m = (i >>> 30 - k) - 2;
    return new byte[] { (byte)((19 - k) * 2 + m) };
  }
  
  Object a(i parami, InputStream paramInputStream) {
    return Integer.valueOf(a(parami));
  }
  
  private int c(Object paramObject) {
    return (paramObject instanceof LZMA2Options) ? ((LZMA2Options)paramObject).getDictSize() : e(paramObject);
  }
  
  private int a(i parami) throws IllegalArgumentException {
    int k = 0xFF & parami.d[0];
    if ((k & 0xFFFFFFC0) != 0)
      throw new IllegalArgumentException("Unsupported LZMA2 property bits"); 
    if (k > 40)
      throw new IllegalArgumentException("Dictionary larger than 4GiB maximum size"); 
    return (k == 40) ? -1 : ((0x2 | k & 0x1) << k / 2 + 11);
  }
  
  private LZMA2Options d(Object paramObject) throws IOException {
    if (paramObject instanceof LZMA2Options)
      return (LZMA2Options)paramObject; 
    LZMA2Options lZMA2Options = new LZMA2Options();
    lZMA2Options.setDictSize(e(paramObject));
    return lZMA2Options;
  }
  
  private int e(Object paramObject) {
    return a(paramObject, 8388608);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/p.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */