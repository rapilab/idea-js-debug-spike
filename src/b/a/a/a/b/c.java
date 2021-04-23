package b.a.a.a.b;

import b.a.a.a.a.d;
import b.a.a.a.a.h.G;
import b.a.a.a.a.h.y;
import b.a.a.a.d.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class c {
  private final Set<a> a;
  
  public c(b paramb) {
    this.a = paramb.a();
  }
  
  public d a(b.a.a.a.a.c paramc, d paramd) throws IOException {
    return a(new b(paramc), paramd);
  }
  
  public d a(G paramG, d paramd) throws IOException {
    return a(new c(paramG), paramd);
  }
  
  private d a(a parama, d paramd) throws IOException {
    d d1 = new d();
    LinkedHashSet<a> linkedHashSet = new LinkedHashSet<a>(this.a);
    Iterator<a> iterator = linkedHashSet.iterator();
    while (iterator.hasNext()) {
      a a1 = iterator.next();
      if (a1.d() == 2 && a1.e()) {
        a(a1.b(), paramd, a1.a());
        iterator.remove();
        d1.c(a1.a().getName());
      } 
    } 
    while (parama.a()) {
      b.a.a.a.a.a a1 = parama.b();
      boolean bool = true;
      Iterator<a> iterator1 = linkedHashSet.iterator();
      while (iterator1.hasNext()) {
        a a2 = iterator1.next();
        int i = a2.d();
        String str = a1.getName();
        if (i == 1 && str != null) {
          if (str.equals(a2.c())) {
            bool = false;
            iterator1.remove();
            d1.a(str);
            break;
          } 
          continue;
        } 
        if (i == 4 && str != null && str.startsWith(a2.c() + "/")) {
          bool = false;
          d1.a(str);
          break;
        } 
      } 
      if (bool && !a(linkedHashSet, a1) && !d1.d(a1.getName())) {
        a(parama.c(), paramd, a1);
        d1.b(a1.getName());
      } 
    } 
    iterator = linkedHashSet.iterator();
    while (iterator.hasNext()) {
      a a1 = iterator.next();
      if (a1.d() == 2 && !a1.e() && !d1.d(a1.a().getName())) {
        a(a1.b(), paramd, a1.a());
        iterator.remove();
        d1.c(a1.a().getName());
      } 
    } 
    paramd.b();
    return d1;
  }
  
  private boolean a(Set<a> paramSet, b.a.a.a.a.a parama) {
    String str = parama.getName();
    if (!paramSet.isEmpty())
      for (a a1 : paramSet) {
        int i = a1.d();
        String str1 = a1.c();
        if (i == 1 && str.equals(str1))
          return true; 
        if (i == 4 && str.startsWith(str1 + "/"))
          return true; 
      }  
    return false;
  }
  
  private void a(InputStream paramInputStream, d paramd, b.a.a.a.a.a parama) throws IOException {
    paramd.a(parama);
    i.a(paramInputStream, (OutputStream)paramd);
    paramd.a();
  }
  
  private static class c implements a {
    private final G a;
    
    private final Enumeration<y> b;
    
    private y c;
    
    c(G param1G) {
      this.a = param1G;
      this.b = param1G.c();
    }
    
    public boolean a() {
      return this.b.hasMoreElements();
    }
    
    public b.a.a.a.a.a b() {
      return (b.a.a.a.a.a)(this.c = this.b.nextElement());
    }
    
    public InputStream c() throws IOException {
      return this.a.b(this.c);
    }
  }
  
  private static class b implements a {
    private final b.a.a.a.a.c a;
    
    private b.a.a.a.a.a b;
    
    b(b.a.a.a.a.c param1c) {
      this.a = param1c;
    }
    
    public boolean a() throws IOException {
      return ((this.b = this.a.a()) != null);
    }
    
    public b.a.a.a.a.a b() {
      return this.b;
    }
    
    public InputStream c() {
      return (InputStream)this.a;
    }
  }
  
  static interface a {
    boolean a() throws IOException;
    
    b.a.a.a.a.a b();
    
    InputStream c() throws IOException;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/b/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */