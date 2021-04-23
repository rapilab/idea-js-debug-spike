package b.a.a.a.a.b;

import b.a.a.a.a.a;
import b.a.a.a.a.h.M;
import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;

public class a implements a {
  private final c b = new c();
  
  public a() {}
  
  a(c paramc) {}
  
  public String getName() {
    return ((this.b.d & 0x10) != 0) ? this.b.t.replaceAll("/", Matcher.quoteReplacement(File.separator)) : this.b.t;
  }
  
  public long getSize() {
    return this.b.j;
  }
  
  public boolean isDirectory() {
    return (this.b.f == 3);
  }
  
  public Date a() {
    long l = e() ? (this.b.h * 1000L) : M.c(0xFFFFFFFFL & this.b.h);
    return new Date(l);
  }
  
  public int b() {
    return this.b.m;
  }
  
  public int c() {
    return e() ? b() : 0;
  }
  
  public int d() {
    return this.b.c;
  }
  
  public boolean e() {
    return (d() == 2 || d() == 8);
  }
  
  int f() {
    return this.b.e;
  }
  
  public static class a {
    public static final int a = 0;
    
    public static final int b = 1;
    
    public static final int c = 2;
    
    public static final int d = 3;
    
    public static final int e = 4;
    
    public static final int f = 5;
    
    public static final int g = 6;
    
    public static final int h = 7;
    
    public static final int i = 8;
    
    public static final int j = 9;
    
    public static final int k = 10;
    
    public static final int l = 11;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/b/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */