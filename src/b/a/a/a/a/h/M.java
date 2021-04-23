package b.a.a.a.a.h;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

public abstract class M {
  private static final byte[] a = J.a(8448L);
  
  public static J a(Date paramDate) {
    return new J(a(paramDate.getTime()));
  }
  
  public static byte[] a(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    int i = calendar.get(1);
    if (i < 1980)
      return b(a); 
    int j = calendar.get(2) + 1;
    long l = (i - 1980 << 25 | j << 21 | calendar.get(5) << 16 | calendar.get(11) << 11 | calendar.get(12) << 5 | calendar.get(13) >> 1);
    return J.a(l);
  }
  
  public static long a(int paramInt) {
    return (paramInt < 0) ? (4294967296L + paramInt) : paramInt;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length - 1;
    for (byte b = 0; b < paramArrayOfbyte.length / 2; b++) {
      byte b1 = paramArrayOfbyte[b];
      paramArrayOfbyte[b] = paramArrayOfbyte[i - b];
      paramArrayOfbyte[i - b] = b1;
    } 
    return paramArrayOfbyte;
  }
  
  static long a(BigInteger paramBigInteger) {
    if (paramBigInteger.bitLength() <= 63)
      return paramBigInteger.longValue(); 
    throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + paramBigInteger + "]");
  }
  
  static BigInteger b(long paramLong) {
    if (paramLong < -2147483648L)
      throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + paramLong + "]"); 
    if (paramLong < 0L && paramLong >= -2147483648L)
      paramLong = a((int)paramLong); 
    return BigInteger.valueOf(paramLong);
  }
  
  public static int a(byte paramByte) {
    return (paramByte >= 0) ? paramByte : (256 + paramByte);
  }
  
  public static byte b(int paramInt) {
    if (paramInt > 255 || paramInt < 0)
      throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + paramInt + "]"); 
    return (paramInt < 128) ? (byte)paramInt : (byte)(paramInt - 256);
  }
  
  public static Date a(J paramJ) {
    long l = paramJ.b();
    return new Date(c(l));
  }
  
  public static long c(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(1, (int)(paramLong >> 25L & 0x7FL) + 1980);
    calendar.set(2, (int)(paramLong >> 21L & 0xFL) - 1);
    calendar.set(5, (int)(paramLong >> 16L) & 0x1F);
    calendar.set(11, (int)(paramLong >> 11L) & 0x1F);
    calendar.set(12, (int)(paramLong >> 5L) & 0x3F);
    calendar.set(13, (int)(paramLong << 1L) & 0x3E);
    calendar.set(14, 0);
    return calendar.getTime().getTime();
  }
  
  static void a(y paramy, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    n n = (n)paramy.b(n.a);
    String str1 = paramy.getName();
    String str2 = a(n, paramArrayOfbyte1);
    if (str2 != null && !str1.equals(str2))
      paramy.a(str2); 
    if (paramArrayOfbyte2 != null && paramArrayOfbyte2.length > 0) {
      m m = (m)paramy.b(m.a);
      String str = a(m, paramArrayOfbyte2);
      if (str != null)
        paramy.setComment(str); 
    } 
  }
  
  private static String a(a parama, byte[] paramArrayOfbyte) {
    if (parama != null) {
      CRC32 cRC32 = new CRC32();
      cRC32.update(paramArrayOfbyte);
      long l = cRC32.getValue();
      if (l == parama.a_())
        try {
          return E.b.a(parama.b());
        } catch (IOException iOException) {
          return null;
        }  
    } 
    return null;
  }
  
  static byte[] b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    } 
    return null;
  }
  
  static boolean a(y paramy) {
    return (c(paramy) && d(paramy));
  }
  
  private static boolean c(y paramy) {
    return !paramy.p().c();
  }
  
  private static boolean d(y paramy) {
    return (paramy.getMethod() == 0 || paramy.getMethod() == K.b.b() || paramy.getMethod() == K.g.b() || paramy.getMethod() == 8);
  }
  
  static void b(y paramy) throws s {
    if (!c(paramy))
      throw new s(s.a.a, paramy); 
    if (!d(paramy)) {
      K k = K.a(paramy.getMethod());
      if (k == null)
        throw new s(s.a.b, paramy); 
      throw new s(k, paramy);
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/M.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */