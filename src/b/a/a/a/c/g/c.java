package b.a.a.a.c.g;

import b.a.a.a.c.e;
import java.util.HashMap;

public class c {
  private static final e a;
  
  private static final byte[] b = new byte[] { -3, 55, 122, 88, 90, 0 };
  
  private static volatile a c;
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt < b.length)
      return false; 
    for (byte b = 0; b < b.length; b++) {
      if (paramArrayOfbyte[b] != b[b])
        return false; 
    } 
    return true;
  }
  
  public static boolean a() {
    a a1 = c;
    return (a1 != a.a) ? ((a1 == a.b)) : c();
  }
  
  private static boolean c() {
    try {
      a.a(null, 0);
      return true;
    } catch (NoClassDefFoundError noClassDefFoundError) {
      return false;
    } 
  }
  
  public static boolean a(String paramString) {
    return a.a(paramString);
  }
  
  public static String b(String paramString) {
    return a.b(paramString);
  }
  
  public static String c(String paramString) {
    return a.c(paramString);
  }
  
  public static void a(boolean paramBoolean) {
    if (!paramBoolean) {
      c = a.a;
    } else if (c == a.a) {
      boolean bool = c();
      c = bool ? a.b : a.c;
    } 
  }
  
  static a b() {
    return c;
  }
  
  static {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put(".txz", ".tar");
    hashMap.put(".xz", "");
    hashMap.put("-xz", "");
    a = new e(hashMap, ".xz");
    c = a.a;
    try {
      Class.forName("org.osgi.framework.BundleEvent");
    } catch (Exception exception) {
      a(true);
    } 
  }
  
  enum a {
    a, b, c;
    
    public static a[] a() {
      return (a[])d.clone();
    }
    
    public static a a(String param1String) {
      return Enum.<a>valueOf(a.class, param1String);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/g/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */