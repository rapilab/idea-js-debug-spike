package b.a.a.a.a.h;

import java.util.zip.ZipException;

public class s extends ZipException {
  private final a a;
  
  private final y b;
  
  private static final long c = 20130101L;
  
  public s(a parama, y paramy) {
    super("unsupported feature " + parama + " used in entry " + paramy.getName());
    this.a = parama;
    this.b = paramy;
  }
  
  public s(K paramK, y paramy) {
    super("unsupported feature method '" + paramK.name() + "' used in entry " + paramy.getName());
    this.a = a.b;
    this.b = paramy;
  }
  
  public s(a parama) {
    super("unsupported feature " + parama + " used in archive.");
    this.a = parama;
    this.b = null;
  }
  
  public a a() {
    return this.a;
  }
  
  public y b() {
    return this.b;
  }
  
  public static class a {
    public static final a a = new a("encryption");
    
    public static final a b = new a("compression method");
    
    public static final a c = new a("data descriptor");
    
    public static final a d = new a("splitting");
    
    private final String e;
    
    private a(String param1String) {
      this.e = param1String;
    }
    
    public String toString() {
      return this.e;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/s.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */