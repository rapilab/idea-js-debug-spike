package b.a.a.a.a.d;

public final class b {
  public static final int a = 1024;
  
  public static final int b = 10;
  
  public static final int c = 32;
  
  public static final int d = 60011;
  
  public static final int e = 60012;
  
  public static final int f = 424935705;
  
  public static final int g = 84446;
  
  public static final int h = 16;
  
  public static final int i = 64;
  
  public enum a {
    a(0),
    b(1),
    c(2);
    
    int d;
    
    public static a[] a() {
      return (a[])e.clone();
    }
    
    public static a a(String param1String) {
      return Enum.<a>valueOf(a.class, param1String);
    }
    
    a(int param1Int1) {
      this.d = param1Int1;
    }
    
    public static a a(int param1Int) {
      for (a a1 : a()) {
        if (a1.d == param1Int)
          return a1; 
      } 
      return null;
    }
  }
  
  public enum b {
    a(1),
    b(2),
    c(3),
    d(4),
    e(5),
    f(6);
    
    int g;
    
    public static b[] a() {
      return (b[])h.clone();
    }
    
    public static b a(String param1String) {
      return Enum.<b>valueOf(b.class, param1String);
    }
    
    b(int param1Int1) {
      this.g = param1Int1;
    }
    
    public static b a(int param1Int) {
      for (b b1 : a()) {
        if (b1.g == param1Int)
          return b1; 
      } 
      return null;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */