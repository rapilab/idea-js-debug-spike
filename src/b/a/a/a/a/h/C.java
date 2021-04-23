package b.a.a.a.a.h;

import java.io.Serializable;
import java.math.BigInteger;

public final class C implements Serializable {
  private static final long b = 1L;
  
  private static final int c = 1;
  
  private static final int d = 65280;
  
  private static final int e = 8;
  
  private static final int f = 2;
  
  private static final int g = 16711680;
  
  private static final int h = 16;
  
  private static final int i = 3;
  
  private static final long j = 4278190080L;
  
  private static final int k = 24;
  
  private static final int l = 4;
  
  private static final long m = 1095216660480L;
  
  private static final int n = 32;
  
  private static final int o = 5;
  
  private static final long p = 280375465082880L;
  
  private static final int q = 40;
  
  private static final int r = 6;
  
  private static final long s = 71776119061217280L;
  
  private static final int t = 48;
  
  private static final int u = 7;
  
  private static final long v = 9151314442816847872L;
  
  private static final int w = 56;
  
  private static final int x = 63;
  
  private static final byte y = -128;
  
  private final BigInteger z;
  
  public static final C a = new C(0L);
  
  public C(long paramLong) {
    this(BigInteger.valueOf(paramLong));
  }
  
  public C(BigInteger paramBigInteger) {
    this.z = paramBigInteger;
  }
  
  public C(byte[] paramArrayOfbyte) {
    this(paramArrayOfbyte, 0);
  }
  
  public C(byte[] paramArrayOfbyte, int paramInt) {
    this.z = b(paramArrayOfbyte, paramInt);
  }
  
  public byte[] a() {
    return a(this.z);
  }
  
  public long b() {
    return this.z.longValue();
  }
  
  public BigInteger c() {
    return this.z;
  }
  
  public static byte[] a(long paramLong) {
    return a(BigInteger.valueOf(paramLong));
  }
  
  public static byte[] a(BigInteger paramBigInteger) {
    byte[] arrayOfByte = new byte[8];
    long l = paramBigInteger.longValue();
    arrayOfByte[0] = (byte)(int)(l & 0xFFL);
    arrayOfByte[1] = (byte)(int)((l & 0xFF00L) >> 8L);
    arrayOfByte[2] = (byte)(int)((l & 0xFF0000L) >> 16L);
    arrayOfByte[3] = (byte)(int)((l & 0xFF000000L) >> 24L);
    arrayOfByte[4] = (byte)(int)((l & 0xFF00000000L) >> 32L);
    arrayOfByte[5] = (byte)(int)((l & 0xFF0000000000L) >> 40L);
    arrayOfByte[6] = (byte)(int)((l & 0xFF000000000000L) >> 48L);
    arrayOfByte[7] = (byte)(int)((l & 0x7F00000000000000L) >> 56L);
    if (paramBigInteger.testBit(63))
      arrayOfByte[7] = (byte)(arrayOfByte[7] | Byte.MIN_VALUE); 
    return arrayOfByte;
  }
  
  public static long a(byte[] paramArrayOfbyte, int paramInt) {
    return b(paramArrayOfbyte, paramInt).longValue();
  }
  
  public static BigInteger b(byte[] paramArrayOfbyte, int paramInt) {
    long l = paramArrayOfbyte[paramInt + 7] << 56L & 0x7F00000000000000L;
    l += paramArrayOfbyte[paramInt + 6] << 48L & 0xFF000000000000L;
    l += paramArrayOfbyte[paramInt + 5] << 40L & 0xFF0000000000L;
    l += paramArrayOfbyte[paramInt + 4] << 32L & 0xFF00000000L;
    l += paramArrayOfbyte[paramInt + 3] << 24L & 0xFF000000L;
    l += paramArrayOfbyte[paramInt + 2] << 16L & 0xFF0000L;
    l += paramArrayOfbyte[paramInt + 1] << 8L & 0xFF00L;
    l += paramArrayOfbyte[paramInt] & 0xFFL;
    BigInteger bigInteger = BigInteger.valueOf(l);
    return ((paramArrayOfbyte[paramInt + 7] & Byte.MIN_VALUE) == -128) ? bigInteger.setBit(63) : bigInteger;
  }
  
  public static long a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 0);
  }
  
  public static BigInteger b(byte[] paramArrayOfbyte) {
    return b(paramArrayOfbyte, 0);
  }
  
  public boolean equals(Object o) {
    return (o == null || !(o instanceof C)) ? false : this.z.equals(((C)o).c());
  }
  
  public int hashCode() {
    return this.z.hashCode();
  }
  
  public String toString() {
    return "ZipEightByteInteger value: " + this.z;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/C.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */