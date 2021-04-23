package b.a.a.a.a.h;

import java.io.Serializable;

public final class L implements Serializable, Cloneable {
  private static final long a = 1L;
  
  private static final int b = 65280;
  
  private static final int c = 8;
  
  private final int d;
  
  public L(int paramInt) {
    this.d = paramInt;
  }
  
  public L(byte[] paramArrayOfbyte) {
    this(paramArrayOfbyte, 0);
  }
  
  public L(byte[] paramArrayOfbyte, int paramInt) {
    this.d = a(paramArrayOfbyte, paramInt);
  }
  
  public byte[] a() {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = (byte)(this.d & 0xFF);
    arrayOfByte[1] = (byte)((this.d & 0xFF00) >> 8);
    return arrayOfByte;
  }
  
  public int b() {
    return this.d;
  }
  
  public static byte[] a(int paramInt) {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = (byte)(paramInt & 0xFF);
    arrayOfByte[1] = (byte)((paramInt & 0xFF00) >> 8);
    return arrayOfByte;
  }
  
  public static int a(byte[] paramArrayOfbyte, int paramInt) {
    int i = paramArrayOfbyte[paramInt + 1] << 8 & 0xFF00;
    i += paramArrayOfbyte[paramInt] & 0xFF;
    return i;
  }
  
  public static int a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 0);
  }
  
  public boolean equals(Object o) {
    return (o == null || !(o instanceof L)) ? false : ((this.d == ((L)o).b()));
  }
  
  public int hashCode() {
    return this.d;
  }
  
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new RuntimeException(cloneNotSupportedException);
    } 
  }
  
  public String toString() {
    return "ZipShort value: " + this.d;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/L.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */