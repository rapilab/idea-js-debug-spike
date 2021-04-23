package b.a.a.a.a.h;

import java.io.Serializable;

public final class J implements Serializable, Cloneable {
  private static final long g = 1L;
  
  private static final int h = 1;
  
  private static final int i = 65280;
  
  private static final int j = 8;
  
  private static final int k = 2;
  
  private static final int l = 16711680;
  
  private static final int m = 16;
  
  private static final int n = 3;
  
  private static final long o = 4278190080L;
  
  private static final int p = 24;
  
  private final long q;
  
  public static final J a = new J(33639248L);
  
  public static final J b = new J(67324752L);
  
  public static final J c = new J(134695760L);
  
  static final J d = new J(4294967295L);
  
  public static final J e = new J(808471376L);
  
  public static final J f = new J(134630224L);
  
  public J(long paramLong) {
    this.q = paramLong;
  }
  
  public J(byte[] paramArrayOfbyte) {
    this(paramArrayOfbyte, 0);
  }
  
  public J(byte[] paramArrayOfbyte, int paramInt) {
    this.q = a(paramArrayOfbyte, paramInt);
  }
  
  public byte[] a() {
    return a(this.q);
  }
  
  public long b() {
    return this.q;
  }
  
  public static byte[] a(long paramLong) {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = (byte)(int)(paramLong & 0xFFL);
    arrayOfByte[1] = (byte)(int)((paramLong & 0xFF00L) >> 8L);
    arrayOfByte[2] = (byte)(int)((paramLong & 0xFF0000L) >> 16L);
    arrayOfByte[3] = (byte)(int)((paramLong & 0xFF000000L) >> 24L);
    return arrayOfByte;
  }
  
  public static long a(byte[] paramArrayOfbyte, int paramInt) {
    long l = (paramArrayOfbyte[paramInt + 3] << 24) & 0xFF000000L;
    l += (paramArrayOfbyte[paramInt + 2] << 16 & 0xFF0000);
    l += (paramArrayOfbyte[paramInt + 1] << 8 & 0xFF00);
    l += (paramArrayOfbyte[paramInt] & 0xFF);
    return l;
  }
  
  public static long a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 0);
  }
  
  public boolean equals(Object o) {
    return (o == null || !(o instanceof J)) ? false : ((this.q == ((J)o).b()));
  }
  
  public int hashCode() {
    return (int)this.q;
  }
  
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new RuntimeException(cloneNotSupportedException);
    } 
  }
  
  public String toString() {
    return "ZipLong value: " + this.q;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/J.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */