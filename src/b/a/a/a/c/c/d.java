package b.a.a.a.c.c;

import b.a.a.a.c.e;
import java.util.LinkedHashMap;

public class d {
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
    linkedHashMap.put(".tgz", ".tar");
    linkedHashMap.put(".taz", ".tar");
    linkedHashMap.put(".svgz", ".svg");
    linkedHashMap.put(".cpgz", ".cpio");
    linkedHashMap.put(".wmz", ".wmf");
    linkedHashMap.put(".emz", ".emf");
    linkedHashMap.put(".gz", "");
    linkedHashMap.put(".z", "");
    linkedHashMap.put("-gz", "");
    linkedHashMap.put("-z", "");
    linkedHashMap.put("_z", "");
    a = new e(linkedHashMap, ".gz");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/c/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */