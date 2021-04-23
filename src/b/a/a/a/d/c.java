package b.a.a.a.d;

import java.io.InputStream;
import java.util.zip.CRC32;

public class c extends f {
  public c(InputStream paramInputStream, long paramLong, int paramInt) {
    this(paramInputStream, paramLong, paramInt & 0xFFFFFFFFL);
  }
  
  public c(InputStream paramInputStream, long paramLong1, long paramLong2) {
    super(new CRC32(), paramInputStream, paramLong1, paramLong2);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */