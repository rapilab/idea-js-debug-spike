package b.a.a.a.a.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum K {
  a(0),
  b(1),
  c(2),
  d(3),
  e(4),
  f(5),
  g(6),
  h(7),
  i(8),
  j(9),
  k(10),
  l(12),
  m(14),
  n(96),
  o(97),
  p(98),
  q(99),
  r(-1);
  
  private final int s;
  
  private static final Map<Integer, K> t;
  
  public static K[] a() {
    return (K[])u.clone();
  }
  
  public static K a(String paramString) {
    return Enum.<K>valueOf(K.class, paramString);
  }
  
  K(int paramInt1) {
    this.s = paramInt1;
  }
  
  public int b() {
    return this.s;
  }
  
  public static K a(int paramInt) {
    return t.get(Integer.valueOf(paramInt));
  }
  
  static {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (K k : a())
      hashMap.put(Integer.valueOf(k.b()), k); 
    t = Collections.unmodifiableMap(hashMap);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/K.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */