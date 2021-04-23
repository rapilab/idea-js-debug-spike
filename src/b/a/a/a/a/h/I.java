package b.a.a.a.a.h;

import java.util.Comparator;

class I implements Comparator<y> {
  I(G paramG) {}
  
  public int a(y paramy1, y paramy2) {
    if (paramy1 == paramy2)
      return 0; 
    G.b b1 = (paramy1 instanceof G.b) ? (G.b)paramy1 : null;
    G.b b2 = (paramy2 instanceof G.b) ? (G.b)paramy2 : null;
    if (b1 == null)
      return 1; 
    if (b2 == null)
      return -1; 
    long l = G.d.b(b1.b()) - G.d.b(b2.b());
    return (l == 0L) ? 0 : ((l < 0L) ? -1 : 1);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/I.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */