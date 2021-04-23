package b.a.a.a.b;

import b.a.a.a.a.a;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class b {
  private final Set<a> a = new LinkedHashSet<a>();
  
  public void a(String paramString) {
    b(new a(paramString, 1));
  }
  
  public void b(String paramString) {
    b(new a(paramString, 4));
  }
  
  public void a(a parama, InputStream paramInputStream) {
    a(parama, paramInputStream, true);
  }
  
  public void a(a parama, InputStream paramInputStream, boolean paramBoolean) {
    a(new a(parama, paramInputStream, paramBoolean));
  }
  
  private void a(a parama) {
    if (2 != parama.d() || parama.b() == null)
      return; 
    if (!this.a.isEmpty()) {
      Iterator<a> iterator = this.a.iterator();
      while (iterator.hasNext()) {
        a a1 = iterator.next();
        if (a1.d() == 2 && a1.a() != null) {
          a a2 = a1.a();
          if (a2.equals(parama.a())) {
            if (parama.e()) {
              iterator.remove();
              this.a.add(parama);
              return;
            } 
            return;
          } 
        } 
      } 
    } 
    this.a.add(parama);
  }
  
  private void b(a parama) {
    if ((1 != parama.d() && 4 != parama.d()) || parama.c() == null)
      return; 
    String str = parama.c();
    if (str != null && !this.a.isEmpty()) {
      Iterator<a> iterator = this.a.iterator();
      while (iterator.hasNext()) {
        a a1 = iterator.next();
        if (a1.d() == 2 && a1.a() != null) {
          String str1 = a1.a().getName();
          if (str1 == null)
            continue; 
          if (1 == parama.d() && str.equals(str1)) {
            iterator.remove();
            continue;
          } 
          if (4 == parama.d() && str1.matches(str + "/.*"))
            iterator.remove(); 
        } 
      } 
    } 
    this.a.add(parama);
  }
  
  Set<a> a() {
    return new LinkedHashSet<a>(this.a);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/b/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */