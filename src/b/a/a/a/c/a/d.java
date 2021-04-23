package b.a.a.a.c.a;

import b.a.a.a.c.e;
import java.util.LinkedHashMap;

public abstract class d {
  private static final e a;
  
  public static boolean a(String paramString) {
    return a.a(paramString);
  }
  
  public static String b(String paramString) {
    return a.b(paramString);
  }
  
  public static String c(String paramString) {
    return a.c(paramString);
  }
  
  static {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    linkedHashMap.put(".tar.bz2", ".tar");
    linkedHashMap.put(".tbz2", ".tar");
    linkedHashMap.put(".tbz", ".tar");
    linkedHashMap.put(".bz2", "");
    linkedHashMap.put(".bz", "");
    a = new e(linkedHashMap, ".bz2");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/a/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */