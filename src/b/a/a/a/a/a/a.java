package b.a.a.a.a.a;

import b.a.a.a.a.a;
import java.io.File;
import java.util.Date;

public class a implements a {
  public static final String b = "!<arch>\n";
  
  public static final String c = "`\n";
  
  private final String d;
  
  private final int e;
  
  private final int f;
  
  private final int g;
  
  private static final int h = 33188;
  
  private final long i;
  
  private final long j;
  
  public a(String paramString, long paramLong) {
    this(paramString, paramLong, 0, 0, 33188, System.currentTimeMillis() / 1000L);
  }
  
  public a(String paramString, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2) {
    this.d = paramString;
    this.j = paramLong1;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.i = paramLong2;
  }
  
  public a(File paramFile, String paramString) {
    this(paramString, paramFile.isFile() ? paramFile.length() : 0L, 0, 0, 33188, paramFile.lastModified() / 1000L);
  }
  
  public long getSize() {
    return f();
  }
  
  public String getName() {
    return this.d;
  }
  
  public int b() {
    return this.e;
  }
  
  public int c() {
    return this.f;
  }
  
  public int d() {
    return this.g;
  }
  
  public long e() {
    return this.i;
  }
  
  public Date a() {
    return new Date(1000L * e());
  }
  
  public long f() {
    return this.j;
  }
  
  public boolean isDirectory() {
    return false;
  }
  
  public int hashCode() {
    byte b = 31;
    null = 1;
    return 31 * null + ((this.d == null) ? 0 : this.d.hashCode());
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null || getClass() != obj.getClass())
      return false; 
    a a1 = (a)obj;
    if (this.d == null) {
      if (a1.d != null)
        return false; 
    } else if (!this.d.equals(a1.d)) {
      return false;
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/a/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */