package b.a.a.a.c.c;

public class c {
  private int a = -1;
  
  private long b;
  
  private String c;
  
  private String d;
  
  private int e = 255;
  
  public int a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    if (paramInt < -1 || paramInt > 9)
      throw new IllegalArgumentException("Invalid gzip compression level: " + paramInt); 
    this.a = paramInt;
  }
  
  public long b() {
    return this.b;
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
  }
  
  public String c() {
    return this.c;
  }
  
  public void a(String paramString) {
    this.c = paramString;
  }
  
  public String d() {
    return this.d;
  }
  
  public void b(String paramString) {
    this.d = paramString;
  }
  
  public int e() {
    return this.e;
  }
  
  public void b(int paramInt) {
    this.e = paramInt;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/c/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */