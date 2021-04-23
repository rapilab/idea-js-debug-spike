package b.a.a.a.a.f;

import java.io.File;
import java.io.IOException;

public class f {
  private static final byte[] a = new byte[8192];
  
  public static void a(String[] paramArrayOfString) throws Exception {
    if (paramArrayOfString.length == 0) {
      b();
      return;
    } 
    a a = b(paramArrayOfString);
    System.out.println(a.b() + " " + paramArrayOfString[0]);
    File file = new File(paramArrayOfString[0]);
    if (!file.isFile())
      System.err.println(file + " doesn't exist or is a directory"); 
    s s = new s(file);
    try {
      r r;
      while ((r = s.a()) != null)
        a.a(s, r); 
    } finally {
      s.close();
    } 
  }
  
  private static void b() {
    System.out.println("Parameters: archive-name [list|extract]");
  }
  
  private static a b(String[] paramArrayOfString) {
    return (paramArrayOfString.length < 2) ? a.a : Enum.<a>valueOf(a.class, paramArrayOfString[1].toUpperCase());
  }
  
  private enum a {
    a("Analysing"),
    b("Extracting");
    
    private final String c;
    
    public static a[] a() {
      return (a[])d.clone();
    }
    
    public static a a(String param1String) {
      return Enum.<a>valueOf(a.class, param1String);
    }
    
    a(String param1String1) {
      this.c = param1String1;
    }
    
    public String b() {
      return this.c;
    }
    
    public abstract void a(s param1s, r param1r) throws IOException;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */