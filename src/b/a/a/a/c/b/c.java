package b.a.a.a.c.b;

public class c {
  private boolean a = true;
  
  private int b = -1;
  
  public boolean a() {
    return this.a;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public int b() {
    return this.b;
  }
  
  public void a(int paramInt) {
    if (paramInt < -1 || paramInt > 9)
      throw new IllegalArgumentException("Invalid Deflate compression level: " + paramInt); 
    this.b = paramInt;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/b/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */