package b.a.a.a.a.g;

import b.a.a.a.a.h.D;
import b.a.a.a.a.h.E;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class f {
  private static final int c = 255;
  
  static final D a = E.a(null);
  
  static final D b = new g();
  
  public static long a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l = 0L;
    int i = paramInt1 + paramInt2;
    int j = paramInt1;
    if (paramInt2 < 2)
      throw new IllegalArgumentException("Length " + paramInt2 + " must be at least 2"); 
    if (paramArrayOfbyte[j] == 0)
      return 0L; 
    while (j < i && paramArrayOfbyte[j] == 32)
      j++; 
    byte b;
    for (b = paramArrayOfbyte[i - 1]; j < i && (b == 0 || b == 32); b = paramArrayOfbyte[--i - 1]);
    while (j < i) {
      byte b1 = paramArrayOfbyte[j];
      if (b1 < 48 || b1 > 55)
        throw new IllegalArgumentException(a(paramArrayOfbyte, paramInt1, paramInt2, j, b1)); 
      l = (l << 3L) + (b1 - 48);
      j++;
    } 
    return l;
  }
  
  public static long b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if ((paramArrayOfbyte[paramInt1] & 0x80) == 0)
      return a(paramArrayOfbyte, paramInt1, paramInt2); 
    boolean bool = (paramArrayOfbyte[paramInt1] == -1) ? true : false;
    return (paramInt2 < 9) ? a(paramArrayOfbyte, paramInt1, paramInt2, bool) : b(paramArrayOfbyte, paramInt1, paramInt2, bool);
  }
  
  private static long a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramInt2 >= 9)
      throw new IllegalArgumentException("At offset " + paramInt1 + ", " + paramInt2 + " byte binary number" + " exceeds maximum signed long" + " value"); 
    long l = 0L;
    for (byte b = 1; b < paramInt2; b++)
      l = (l << 8L) + (paramArrayOfbyte[paramInt1 + b] & 0xFF); 
    if (paramBoolean) {
      l--;
      l ^= (long)Math.pow(2.0D, ((paramInt2 - 1) * 8)) - 1L;
    } 
    return paramBoolean ? -l : l;
  }
  
  private static long b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    byte[] arrayOfByte = new byte[paramInt2 - 1];
    System.arraycopy(paramArrayOfbyte, paramInt1 + 1, arrayOfByte, 0, paramInt2 - 1);
    BigInteger bigInteger = new BigInteger(arrayOfByte);
    if (paramBoolean)
      bigInteger = bigInteger.add(BigInteger.valueOf(-1L)).not(); 
    if (bigInteger.bitLength() > 63)
      throw new IllegalArgumentException("At offset " + paramInt1 + ", " + paramInt2 + " byte binary number" + " exceeds maximum signed long" + " value"); 
    return paramBoolean ? -bigInteger.longValue() : bigInteger.longValue();
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramArrayOfbyte[paramInt] == 1);
  }
  
  private static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, byte paramByte) {
    String str = new String(paramArrayOfbyte, paramInt1, paramInt2);
    str = str.replaceAll("\000", "{NUL}");
    return "Invalid byte " + paramByte + " at offset " + (paramInt3 - paramInt1) + " in '" + str + "' len=" + paramInt2;
  }
  
  public static String c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return a(paramArrayOfbyte, paramInt1, paramInt2, a);
    } catch (IOException iOException) {
      try {
        return a(paramArrayOfbyte, paramInt1, paramInt2, b);
      } catch (IOException iOException1) {
        throw new RuntimeException(iOException1);
      } 
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, D paramD) throws IOException {
    int i;
    for (i = paramInt2; i > 0 && paramArrayOfbyte[paramInt1 + i - 1] == 0; i--);
    if (i > 0) {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, i);
      return paramD.a(arrayOfByte);
    } 
    return "";
  }
  
  public static int a(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return a(paramString, paramArrayOfbyte, paramInt1, paramInt2, a);
    } catch (IOException iOException) {
      try {
        return a(paramString, paramArrayOfbyte, paramInt1, paramInt2, b);
      } catch (IOException iOException1) {
        throw new RuntimeException(iOException1);
      } 
    } 
  }
  
  public static int a(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, D paramD) throws IOException {
    int i = paramString.length();
    ByteBuffer byteBuffer;
    for (byteBuffer = paramD.b(paramString); byteBuffer.limit() > paramInt2 && i > 0; byteBuffer = paramD.b(paramString.substring(0, --i)));
    int j = byteBuffer.limit() - byteBuffer.position();
    System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), paramArrayOfbyte, paramInt1, j);
    for (int k = j; k < paramInt2; k++)
      paramArrayOfbyte[paramInt1 + k] = 0; 
    return paramInt1 + paramInt2;
  }
  
  public static void a(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = paramInt2;
    i--;
    if (paramLong == 0L) {
      paramArrayOfbyte[paramInt1 + i--] = 48;
    } else {
      long l = paramLong;
      while (i >= 0 && l != 0L) {
        paramArrayOfbyte[paramInt1 + i] = (byte)(48 + (byte)(int)(l & 0x7L));
        l >>>= 3L;
        i--;
      } 
      if (l != 0L)
        throw new IllegalArgumentException(paramLong + "=" + Long.toOctalString(paramLong) + " will not fit in octal number buffer of length " + paramInt2); 
    } 
    while (i >= 0) {
      paramArrayOfbyte[paramInt1 + i] = 48;
      i--;
    } 
  }
  
  public static int b(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = paramInt2 - 2;
    a(paramLong, paramArrayOfbyte, paramInt1, i);
    paramArrayOfbyte[paramInt1 + i++] = 32;
    paramArrayOfbyte[paramInt1 + i] = 0;
    return paramInt1 + paramInt2;
  }
  
  public static int c(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = paramInt2 - 1;
    a(paramLong, paramArrayOfbyte, paramInt1, i);
    paramArrayOfbyte[paramInt1 + i] = 32;
    return paramInt1 + paramInt2;
  }
  
  public static int d(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l = (paramInt2 == 8) ? 2097151L : 8589934591L;
    boolean bool = (paramLong < 0L) ? true : false;
    if (!bool && paramLong <= l)
      return c(paramLong, paramArrayOfbyte, paramInt1, paramInt2); 
    if (paramInt2 < 9)
      a(paramLong, paramArrayOfbyte, paramInt1, paramInt2, bool); 
    b(paramLong, paramArrayOfbyte, paramInt1, paramInt2, bool);
    paramArrayOfbyte[paramInt1] = (byte)(bool ? 255 : 128);
    return paramInt1 + paramInt2;
  }
  
  private static void a(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    int i = (paramInt2 - 1) * 8;
    long l1 = 1L << i;
    long l2 = Math.abs(paramLong);
    if (l2 >= l1)
      throw new IllegalArgumentException("Value " + paramLong + " is too large for " + paramInt2 + " byte field."); 
    if (paramBoolean) {
      l2 ^= l1 - 1L;
      l2 |= (255 << i);
      l2++;
    } 
    for (int j = paramInt1 + paramInt2 - 1; j >= paramInt1; j--) {
      paramArrayOfbyte[j] = (byte)(int)l2;
      l2 >>= 8L;
    } 
  }
  
  private static void b(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    BigInteger bigInteger = BigInteger.valueOf(paramLong);
    byte[] arrayOfByte = bigInteger.toByteArray();
    int i = arrayOfByte.length;
    int j = paramInt1 + paramInt2 - i;
    System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, j, i);
    byte b = (byte)(paramBoolean ? 255 : 0);
    for (int k = paramInt1 + 1; k < j; k++)
      paramArrayOfbyte[k] = b; 
  }
  
  public static int e(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = paramInt2 - 2;
    a(paramLong, paramArrayOfbyte, paramInt1, i);
    paramArrayOfbyte[paramInt1 + i++] = 0;
    paramArrayOfbyte[paramInt1 + i] = 32;
    return paramInt1 + paramInt2;
  }
  
  public static long a(byte[] paramArrayOfbyte) {
    long l = 0L;
    for (byte b : paramArrayOfbyte)
      l += (0xFF & b); 
    return l;
  }
  
  public static boolean b(byte[] paramArrayOfbyte) {
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    byte b1 = 0;
    for (byte b2 = 0; b2 < paramArrayOfbyte.length; b2++) {
      byte b = paramArrayOfbyte[b2];
      if ('' <= b2 && b2 < '') {
        if (48 <= b && b <= 55 && b1++ < 6) {
          l1 = l1 * 8L + b - 48L;
        } else if (b1 > 0) {
          b1 = 6;
        } 
        b = 32;
      } 
      l2 += (0xFF & b);
      l3 += b;
    } 
    return (l1 == l2 || l1 == l3 || l1 > l2);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/g/f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */