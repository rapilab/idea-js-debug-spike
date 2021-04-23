package b.a.a.a.d;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class i {
  private static final int a = 8024;
  
  private static final int b = 4096;
  
  private static final byte[] c = new byte[4096];
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    return a(paramInputStream, paramOutputStream, 8024);
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) throws IOException {
    byte[] arrayOfByte = new byte[paramInt];
    int j = 0;
    long l;
    for (l = 0L; -1 != (j = paramInputStream.read(arrayOfByte)); l += j)
      paramOutputStream.write(arrayOfByte, 0, j); 
    return l;
  }
  
  public static long a(InputStream paramInputStream, long paramLong) throws IOException {
    long l = paramLong;
    while (paramLong > 0L) {
      long l1 = paramInputStream.skip(paramLong);
      if (l1 == 0L)
        break; 
      paramLong -= l1;
    } 
    while (paramLong > 0L) {
      int j = a(paramInputStream, c, 0, (int)Math.min(paramLong, 4096L));
      if (j < 1)
        break; 
      paramLong -= j;
    } 
    return l - paramLong;
  }
  
  public static int a(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
    return a(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static int a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 < 0 || paramInt1 < 0 || paramInt2 + paramInt1 > paramArrayOfbyte.length)
      throw new IndexOutOfBoundsException(); 
    int j = 0;
    int k = 0;
    while (j != paramInt2) {
      k = paramInputStream.read(paramArrayOfbyte, paramInt1 + j, paramInt2 - j);
      if (k == -1)
        break; 
      j += k;
    } 
    return j;
  }
  
  public static byte[] a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (IOException iOException) {} 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */