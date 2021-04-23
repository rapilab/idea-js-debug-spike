package b.a.a.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class e {
  private final Map<String, String> a = new HashMap<String, String>();
  
  private final Map<String, String> b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private final int f;
  
  private final String g;
  
  public e(Map<String, String> paramMap, String paramString) {
    this.b = Collections.unmodifiableMap(paramMap);
    int i = Integer.MIN_VALUE;
    int j = Integer.MAX_VALUE;
    int k = Integer.MIN_VALUE;
    int m = Integer.MAX_VALUE;
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      int n = ((String)entry.getKey()).length();
      if (n > i)
        i = n; 
      if (n < j)
        j = n; 
      String str = (String)entry.getValue();
      int i1 = str.length();
      if (i1 > 0) {
        if (!this.a.containsKey(str))
          this.a.put(str, (String)entry.getKey()); 
        if (i1 > k)
          k = i1; 
        if (i1 < m)
          m = i1; 
      } 
    } 
    this.c = i;
    this.e = k;
    this.d = j;
    this.f = m;
    this.g = paramString;
  }
  
  public boolean a(String paramString) {
    String str = paramString.toLowerCase(Locale.ENGLISH);
    int i = str.length();
    for (int j = this.d; j <= this.c && j < i; j++) {
      if (this.b.containsKey(str.substring(i - j)))
        return true; 
    } 
    return false;
  }
  
  public String b(String paramString) {
    String str = paramString.toLowerCase(Locale.ENGLISH);
    int i = str.length();
    for (int j = this.d; j <= this.c && j < i; j++) {
      String str1 = this.b.get(str.substring(i - j));
      if (str1 != null)
        return paramString.substring(0, i - j) + str1; 
    } 
    return paramString;
  }
  
  public String c(String paramString) {
    String str = paramString.toLowerCase(Locale.ENGLISH);
    int i = str.length();
    for (int j = this.f; j <= this.e && j < i; j++) {
      String str1 = this.a.get(str.substring(i - j));
      if (str1 != null)
        return paramString.substring(0, i - j) + str1; 
    } 
    return paramString + this.g;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */