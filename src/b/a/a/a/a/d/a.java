package b.a.a.a.a.d;

class a {
  private final int a;
  
  private final int b;
  
  private final int c;
  
  private final String d;
  
  a(int paramInt1, int paramInt2, int paramInt3, String paramString) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString;
  }
  
  int a() {
    return this.a;
  }
  
  int b() {
    return this.b;
  }
  
  int c() {
    return this.c;
  }
  
  String d() {
    return this.d;
  }
  
  public String toString() {
    return String.format("[%d]: %s", new Object[] { Integer.valueOf(this.a), this.d });
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */