package b.a.a.a.a.h;

import java.util.zip.ZipException;

public class v implements F {
  static final L a = new L(1);
  
  private static final String b = "Zip64 extended information must contain both size values in the local file header.";
  
  private static final byte[] c = new byte[0];
  
  private C d;
  
  private C e;
  
  private C f;
  
  private J g;
  
  private byte[] h;
  
  public v() {}
  
  public v(C paramC1, C paramC2) {
    this(paramC1, paramC2, null, null);
  }
  
  public v(C paramC1, C paramC2, C paramC3, J paramJ) {
    this.d = paramC1;
    this.e = paramC2;
    this.f = paramC3;
    this.g = paramJ;
  }
  
  public L a() {
    return a;
  }
  
  public L f() {
    return new L((this.d != null) ? 16 : 0);
  }
  
  public L d() {
    return new L(((this.d != null) ? 8 : 0) + ((this.e != null) ? 8 : 0) + ((this.f != null) ? 8 : 0) + ((this.g != null) ? 4 : 0));
  }
  
  public byte[] e() {
    if (this.d != null || this.e != null) {
      if (this.d == null || this.e == null)
        throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header."); 
      byte[] arrayOfByte = new byte[16];
      a(arrayOfByte);
      return arrayOfByte;
    } 
    return c;
  }
  
  public byte[] c() {
    byte[] arrayOfByte = new byte[d().b()];
    int i = a(arrayOfByte);
    if (this.f != null) {
      System.arraycopy(this.f.a(), 0, arrayOfByte, i, 8);
      i += 8;
    } 
    if (this.g != null) {
      System.arraycopy(this.g.a(), 0, arrayOfByte, i, 4);
      i += 4;
    } 
    return arrayOfByte;
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ZipException {
    if (paramInt2 == 0)
      return; 
    if (paramInt2 < 16)
      throw new ZipException("Zip64 extended information must contain both size values in the local file header."); 
    this.d = new C(paramArrayOfbyte, paramInt1);
    paramInt1 += 8;
    this.e = new C(paramArrayOfbyte, paramInt1);
    paramInt1 += 8;
    int i = paramInt2 - 16;
    if (i >= 8) {
      this.f = new C(paramArrayOfbyte, paramInt1);
      paramInt1 += 8;
      i -= 8;
    } 
    if (i >= 4) {
      this.g = new J(paramArrayOfbyte, paramInt1);
      paramInt1 += 4;
      i -= 4;
    } 
  }
  
  public void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ZipException {
    this.h = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, this.h, 0, paramInt2);
    if (paramInt2 >= 28) {
      a(paramArrayOfbyte, paramInt1, paramInt2);
    } else if (paramInt2 == 24) {
      this.d = new C(paramArrayOfbyte, paramInt1);
      paramInt1 += 8;
      this.e = new C(paramArrayOfbyte, paramInt1);
      paramInt1 += 8;
      this.f = new C(paramArrayOfbyte, paramInt1);
    } else if (paramInt2 % 8 == 4) {
      this.g = new J(paramArrayOfbyte, paramInt1 + paramInt2 - 4);
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) throws ZipException {
    if (this.h != null) {
      int i = (paramBoolean1 ? 8 : 0) + (paramBoolean2 ? 8 : 0) + (paramBoolean3 ? 8 : 0) + (paramBoolean4 ? 4 : 0);
      if (this.h.length < i)
        throw new ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i + " but is " + this.h.length); 
      boolean bool = false;
      if (paramBoolean1) {
        this.d = new C(this.h, bool);
        bool += true;
      } 
      if (paramBoolean2) {
        this.e = new C(this.h, bool);
        bool += true;
      } 
      if (paramBoolean3) {
        this.f = new C(this.h, bool);
        bool += true;
      } 
      if (paramBoolean4) {
        this.g = new J(this.h, bool);
        bool += true;
      } 
    } 
  }
  
  public C b() {
    return this.d;
  }
  
  public void a(C paramC) {
    this.d = paramC;
  }
  
  public C g() {
    return this.e;
  }
  
  public void b(C paramC) {
    this.e = paramC;
  }
  
  public C h() {
    return this.f;
  }
  
  public void c(C paramC) {
    this.f = paramC;
  }
  
  public J i() {
    return this.g;
  }
  
  public void a(J paramJ) {
    this.g = paramJ;
  }
  
  private int a(byte[] paramArrayOfbyte) {
    boolean bool = false;
    if (this.d != null) {
      System.arraycopy(this.d.a(), 0, paramArrayOfbyte, 0, 8);
      bool += true;
    } 
    if (this.e != null) {
      System.arraycopy(this.e.a(), 0, paramArrayOfbyte, bool, 8);
      bool += true;
    } 
    return bool;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/v.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */