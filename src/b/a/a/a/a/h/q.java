package b.a.a.a.a.h;

public class q implements F {
  private L a;
  
  private byte[] b;
  
  private byte[] c;
  
  public void a(L paramL) {
    this.a = paramL;
  }
  
  public L a() {
    return this.a;
  }
  
  public void a(byte[] paramArrayOfbyte) {
    this.b = M.b(paramArrayOfbyte);
  }
  
  public L f() {
    return new L((this.b != null) ? this.b.length : 0);
  }
  
  public byte[] e() {
    return M.b(this.b);
  }
  
  public void b(byte[] paramArrayOfbyte) {
    this.c = M.b(paramArrayOfbyte);
  }
  
  public L d() {
    return (this.c != null) ? new L(this.c.length) : f();
  }
  
  public byte[] c() {
    return (this.c != null) ? M.b(this.c) : e();
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
    a(arrayOfByte);
  }
  
  public void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
    b(arrayOfByte);
    if (this.b == null)
      a(arrayOfByte); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/q.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */