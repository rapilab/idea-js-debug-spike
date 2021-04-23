package b.a.a.a.a.h;

public final class p implements F {
  private static final L a = new L(44225);
  
  private byte[] b;
  
  private byte[] c;
  
  public L a() {
    return a;
  }
  
  public L f() {
    return new L((this.b == null) ? 0 : this.b.length);
  }
  
  public L d() {
    return (this.c == null) ? f() : new L(this.c.length);
  }
  
  public byte[] e() {
    return M.b(this.b);
  }
  
  public byte[] c() {
    return (this.c == null) ? e() : M.b(this.c);
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.b = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, this.b, 0, paramInt2);
  }
  
  public void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.c = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, this.c, 0, paramInt2);
    if (this.b == null)
      a(paramArrayOfbyte, paramInt1, paramInt2); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/p.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */