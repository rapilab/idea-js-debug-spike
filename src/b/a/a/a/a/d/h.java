package b.a.a.a.a.d;

import b.a.a.a.a.h.D;
import java.io.IOException;

class h {
  public static int a(byte[] paramArrayOfbyte) {
    int i = 0;
    for (byte b = 0; b < 'Ā'; b++)
      i += b(paramArrayOfbyte, 4 * b); 
    return 84446 - i - b(paramArrayOfbyte, 28);
  }
  
  public static final boolean b(byte[] paramArrayOfbyte) {
    int i = b(paramArrayOfbyte, 24);
    if (i != 60012)
      return false; 
    int j = b(paramArrayOfbyte, 28);
    return !(j != a(paramArrayOfbyte));
  }
  
  public static final int c(byte[] paramArrayOfbyte) {
    return b(paramArrayOfbyte, 20);
  }
  
  public static final long a(byte[] paramArrayOfbyte, int paramInt) {
    long l = 0L;
    l += paramArrayOfbyte[paramInt + 7] << 56L;
    l += paramArrayOfbyte[paramInt + 6] << 48L & 0xFF000000000000L;
    l += paramArrayOfbyte[paramInt + 5] << 40L & 0xFF0000000000L;
    l += paramArrayOfbyte[paramInt + 4] << 32L & 0xFF00000000L;
    l += paramArrayOfbyte[paramInt + 3] << 24L & 0xFF000000L;
    l += paramArrayOfbyte[paramInt + 2] << 16L & 0xFF0000L;
    l += paramArrayOfbyte[paramInt + 1] << 8L & 0xFF00L;
    l += paramArrayOfbyte[paramInt] & 0xFFL;
    return l;
  }
  
  public static final int b(byte[] paramArrayOfbyte, int paramInt) {
    int i = 0;
    i = paramArrayOfbyte[paramInt + 3] << 24;
    i += paramArrayOfbyte[paramInt + 2] << 16 & 0xFF0000;
    i += paramArrayOfbyte[paramInt + 1] << 8 & 0xFF00;
    i += paramArrayOfbyte[paramInt] & 0xFF;
    return i;
  }
  
  public static final int c(byte[] paramArrayOfbyte, int paramInt) {
    int i = 0;
    i += paramArrayOfbyte[paramInt + 1] << 8 & 0xFF00;
    i += paramArrayOfbyte[paramInt] & 0xFF;
    return i;
  }
  
  static String a(D paramD, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
    return paramD.a(arrayOfByte);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */