package b.a.a.a.a.h;

import java.io.Serializable;
import java.util.Date;
import java.util.zip.ZipException;

public class t implements F, Serializable, Cloneable {
  private static final L d = new L(21589);
  
  private static final long e = 1L;
  
  public static final byte a = 1;
  
  public static final byte b = 2;
  
  public static final byte c = 4;
  
  private byte f;
  
  private boolean g;
  
  private boolean h;
  
  private boolean i;
  
  private J j;
  
  private J k;
  
  private J l;
  
  public L a() {
    return d;
  }
  
  public L f() {
    return new L(1 + (this.g ? 4 : 0) + ((this.h && this.k != null) ? 4 : 0) + ((this.i && this.l != null) ? 4 : 0));
  }
  
  public L d() {
    return new L(1 + (this.g ? 4 : 0));
  }
  
  public byte[] e() {
    byte[] arrayOfByte = new byte[f().b()];
    byte b = 0;
    arrayOfByte[b++] = 0;
    if (this.g) {
      arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x1);
      System.arraycopy(this.j.a(), 0, arrayOfByte, b, 4);
      b += 4;
    } 
    if (this.h && this.k != null) {
      arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x2);
      System.arraycopy(this.k.a(), 0, arrayOfByte, b, 4);
      b += 4;
    } 
    if (this.i && this.l != null) {
      arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x4);
      System.arraycopy(this.l.a(), 0, arrayOfByte, b, 4);
      b += 4;
    } 
    return arrayOfByte;
  }
  
  public byte[] c() {
    byte[] arrayOfByte1 = new byte[d().b()];
    byte[] arrayOfByte2 = e();
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte1.length);
    return arrayOfByte1;
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ZipException {
    p();
    int i = paramInt1 + paramInt2;
    a(paramArrayOfbyte[paramInt1++]);
    if (this.g) {
      this.j = new J(paramArrayOfbyte, paramInt1);
      paramInt1 += 4;
    } 
    if (this.h && paramInt1 + 4 <= i) {
      this.k = new J(paramArrayOfbyte, paramInt1);
      paramInt1 += 4;
    } 
    if (this.i && paramInt1 + 4 <= i) {
      this.l = new J(paramArrayOfbyte, paramInt1);
      paramInt1 += 4;
    } 
  }
  
  public void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ZipException {
    p();
    a(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private void p() {
    a((byte)0);
    this.j = null;
    this.k = null;
    this.l = null;
  }
  
  public void a(byte paramByte) {
    this.f = paramByte;
    this.g = ((paramByte & 0x1) == 1);
    this.h = ((paramByte & 0x2) == 2);
    this.i = ((paramByte & 0x4) == 4);
  }
  
  public byte b() {
    return this.f;
  }
  
  public boolean g() {
    return this.g;
  }
  
  public boolean h() {
    return this.h;
  }
  
  public boolean i() {
    return this.i;
  }
  
  public J j() {
    return this.j;
  }
  
  public J k() {
    return this.k;
  }
  
  public J l() {
    return this.l;
  }
  
  public Date m() {
    return (this.j != null) ? new Date(this.j.b() * 1000L) : null;
  }
  
  public Date n() {
    return (this.k != null) ? new Date(this.k.b() * 1000L) : null;
  }
  
  public Date o() {
    return (this.l != null) ? new Date(this.l.b() * 1000L) : null;
  }
  
  public void a(J paramJ) {
    this.g = (paramJ != null);
    this.f = (byte)((paramJ != null) ? (this.f | 0x1) : (this.f & 0xFFFFFFFE));
    this.j = paramJ;
  }
  
  public void b(J paramJ) {
    this.h = (paramJ != null);
    this.f = (byte)((paramJ != null) ? (this.f | 0x2) : (this.f & 0xFFFFFFFD));
    this.k = paramJ;
  }
  
  public void c(J paramJ) {
    this.i = (paramJ != null);
    this.f = (byte)((paramJ != null) ? (this.f | 0x4) : (this.f & 0xFFFFFFFB));
    this.l = paramJ;
  }
  
  public void a(Date paramDate) {
    a(d(paramDate));
  }
  
  public void b(Date paramDate) {
    b(d(paramDate));
  }
  
  public void c(Date paramDate) {
    c(d(paramDate));
  }
  
  private static J d(Date paramDate) {
    if (paramDate == null)
      return null; 
    long l1 = 4294967296L;
    long l2 = paramDate.getTime() / 1000L;
    if (l2 >= 4294967296L)
      throw new IllegalArgumentException("Cannot set an X5455 timestamp larger than 2^32: " + l2); 
    return new J(l2);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("0x5455 Zip Extra Field: Flags=");
    stringBuilder.append(Integer.toBinaryString(M.b(this.f))).append(" ");
    if (this.g && this.j != null) {
      Date date = m();
      stringBuilder.append(" Modify:[").append(date).append("] ");
    } 
    if (this.h && this.k != null) {
      Date date = n();
      stringBuilder.append(" Access:[").append(date).append("] ");
    } 
    if (this.i && this.l != null) {
      Date date = o();
      stringBuilder.append(" Create:[").append(date).append("] ");
    } 
    return stringBuilder.toString();
  }
  
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  
  public boolean equals(Object o) {
    if (o instanceof t) {
      t t1 = (t)o;
      return ((this.f & 0x7) == (t1.f & 0x7) && (this.j == t1.j || (this.j != null && this.j.equals(t1.j))) && (this.k == t1.k || (this.k != null && this.k.equals(t1.k))) && (this.l == t1.l || (this.l != null && this.l.equals(t1.l))));
    } 
    return false;
  }
  
  public int hashCode() {
    int i = -123 * (this.f & 0x7);
    if (this.j != null)
      i ^= this.j.hashCode(); 
    if (this.k != null)
      i ^= Integer.rotateLeft(this.k.hashCode(), 11); 
    if (this.l != null)
      i ^= Integer.rotateLeft(this.l.hashCode(), 22); 
    return i;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/t.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */