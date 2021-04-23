package b.a.a.a.c.g;

import b.a.a.a.c.b;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class a extends b {
  private final InputStream a;
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt < XZ.HEADER_MAGIC.length)
      return false; 
    for (byte b1 = 0; b1 < XZ.HEADER_MAGIC.length; b1++) {
      if (paramArrayOfbyte[b1] != XZ.HEADER_MAGIC[b1])
        return false; 
    } 
    return true;
  }
  
  public a(InputStream paramInputStream) throws IOException {
    this(paramInputStream, false);
  }
  
  public a(InputStream paramInputStream, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      this.a = (InputStream)new XZInputStream(paramInputStream);
    } else {
      this.a = (InputStream)new SingleXZInputStream(paramInputStream);
    } 
  }
  
  public int read() throws IOException {
    int i = this.a.read();
    a((i == -1) ? -1 : 1);
    return i;
  }
  
  public int read(byte[] buf, int off, int len) throws IOException {
    int i = this.a.read(buf, off, len);
    a(i);
    return i;
  }
  
  public long skip(long n) throws IOException {
    return this.a.skip(n);
  }
  
  public int available() throws IOException {
    return this.a.available();
  }
  
  public void close() throws IOException {
    this.a.close();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/g/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */