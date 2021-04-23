package b.a.a.a.a.h;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.zip.ZipException;

public class u implements F, Serializable, Cloneable {
  private static final L a = new L(30837);
  
  private static final BigInteger b = BigInteger.valueOf(1000L);
  
  private static final long c = 1L;
  
  private int d = 1;
  
  private BigInteger e;
  
  private BigInteger f;
  
  public u() {
    h();
  }
  
  public L a() {
    return a;
  }
  
  public long b() {
    return M.a(this.e);
  }
  
  public long g() {
    return M.a(this.f);
  }
  
  public void a(long paramLong) {
    this.e = M.b(paramLong);
  }
  
  public void b(long paramLong) {
    this.f = M.b(paramLong);
  }
  
  public L f() {
    int i = (a(this.e.toByteArray())).length;
    int j = (a(this.f.toByteArray())).length;
    return new L(3 + i + j);
  }
  
  public L d() {
    return f();
  }
  
  public byte[] e() {
    byte[] arrayOfByte1 = this.e.toByteArray();
    byte[] arrayOfByte2 = this.f.toByteArray();
    arrayOfByte1 = a(arrayOfByte1);
    arrayOfByte2 = a(arrayOfByte2);
    byte[] arrayOfByte3 = new byte[3 + arrayOfByte1.length + arrayOfByte2.length];
    M.a(arrayOfByte1);
    M.a(arrayOfByte2);
    int i = 0;
    arrayOfByte3[i++] = M.b(this.d);
    arrayOfByte3[i++] = M.b(arrayOfByte1.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, i, arrayOfByte1.length);
    i += arrayOfByte1.length;
    arrayOfByte3[i++] = M.b(arrayOfByte2.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, i, arrayOfByte2.length);
    return arrayOfByte3;
  }
  
  public byte[] c() {
    return e();
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ZipException {
    h();
    this.d = M.a(paramArrayOfbyte[paramInt1++]);
    int i = M.a(paramArrayOfbyte[paramInt1++]);
    byte[] arrayOfByte1 = new byte[i];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte1, 0, i);
    paramInt1 += i;
    this.e = new BigInteger(1, M.a(arrayOfByte1));
    int j = M.a(paramArrayOfbyte[paramInt1++]);
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte2, 0, j);
    this.f = new BigInteger(1, M.a(arrayOfByte2));
  }
  
  public void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ZipException {
    h();
    a(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private void h() {
    this.e = b;
    this.f = b;
  }
  
  public String toString() {
    return "0x7875 Zip Extra Field: UID=" + this.e + " GID=" + this.f;
  }
  
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  
  public boolean equals(Object o) {
    if (o instanceof u) {
      u u1 = (u)o;
      return (this.d == u1.d && this.e.equals(u1.e) && this.f.equals(u1.f));
    } 
    return false;
  }
  
  public int hashCode() {
    int i = -1234567 * this.d;
    i ^= Integer.rotateLeft(this.e.hashCode(), 16);
    i ^= this.f.hashCode();
    return i;
  }
  
  static byte[] a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return paramArrayOfbyte; 
    byte b = 0;
    byte[] arrayOfByte1 = paramArrayOfbyte;
    int i = arrayOfByte1.length;
    int j = 0;
    while (j < i) {
      byte b1 = arrayOfByte1[j];
      if (b1 == 0) {
        b++;
        j++;
      } 
    } 
    boolean bool = true;
    byte[] arrayOfByte2 = new byte[Math.max(1, paramArrayOfbyte.length - b)];
    j = arrayOfByte2.length - paramArrayOfbyte.length - b;
    System.arraycopy(paramArrayOfbyte, b, arrayOfByte2, j, arrayOfByte2.length - j);
    return arrayOfByte2;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/u.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */