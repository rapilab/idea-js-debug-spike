package b.a.a.a.a.d;

import b.a.a.a.a.a;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class c implements a {
  private String b;
  
  private b c = b.i;
  
  private int d;
  
  private Set<a> e = Collections.emptySet();
  
  private long f;
  
  private long g;
  
  private long h;
  
  private int i;
  
  private int j;
  
  private final g k = null;
  
  private final c l = new c();
  
  private String m;
  
  private String n;
  
  private int o;
  
  private long p;
  
  private int q;
  
  private int r;
  
  private long s;
  
  private int t;
  
  private boolean u;
  
  public c() {}
  
  public c(String paramString1, String paramString2) {
    b(paramString1);
    this.m = paramString2;
  }
  
  protected c(String paramString1, String paramString2, int paramInt, b paramb) {
    a(paramb);
    b(paramString1);
    this.m = paramString2;
    this.q = paramInt;
    this.p = 0L;
  }
  
  public String b() {
    return this.m;
  }
  
  protected void a(String paramString) {
    this.m = paramString;
  }
  
  public int c() {
    return this.l.c();
  }
  
  public int d() {
    return this.r;
  }
  
  public void a(int paramInt) {
    this.r = paramInt;
  }
  
  public Date e() {
    return new Date(this.s);
  }
  
  public void a(Date paramDate) {
    this.s = paramDate.getTime();
  }
  
  public int f() {
    return this.t;
  }
  
  public void b(int paramInt) {
    this.t = paramInt;
  }
  
  public boolean g() {
    return this.u;
  }
  
  public void a(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public long h() {
    return this.p;
  }
  
  public void a(long paramLong) {
    this.p = paramLong;
  }
  
  public int i() {
    return this.o;
  }
  
  public void c(int paramInt) {
    this.o = paramInt;
  }
  
  public b.b j() {
    return this.l.a();
  }
  
  public int k() {
    return this.l.d();
  }
  
  public int l() {
    return this.l.e();
  }
  
  public boolean d(int paramInt) {
    return ((this.l.b(paramInt) & 0x1) == 0);
  }
  
  public int hashCode() {
    return this.q;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (o == null || !o.getClass().equals(getClass()))
      return false; 
    c c1 = (c)o;
    return (this.l == null || c1.l == null) ? false : ((this.q != c1.q) ? false : (!((this.k == null && c1.k != null) || (this.k != null && !this.k.equals(c1.k)))));
  }
  
  public String toString() {
    return getName();
  }
  
  static c a(byte[] paramArrayOfbyte) {
    c c1 = new c();
    c c2 = c1.l;
    c.a(c2, b.b.a(h.b(paramArrayOfbyte, 0)));
    c.a(c2, h.b(paramArrayOfbyte, 12));
    c1.q = c.b(c2, h.b(paramArrayOfbyte, 20));
    int i = h.c(paramArrayOfbyte, 32);
    c1.a(b.a(i >> 12 & 0xF));
    c1.e(i);
    c1.r = h.c(paramArrayOfbyte, 34);
    c1.b(h.a(paramArrayOfbyte, 40));
    long l = 1000L * h.b(paramArrayOfbyte, 48) + (h.b(paramArrayOfbyte, 52) / 1000);
    c1.c(new Date(l));
    l = 1000L * h.b(paramArrayOfbyte, 56) + (h.b(paramArrayOfbyte, 60) / 1000);
    c1.b(new Date(l));
    l = 1000L * h.b(paramArrayOfbyte, 64) + (h.b(paramArrayOfbyte, 68) / 1000);
    c1.s = l;
    c1.t = h.b(paramArrayOfbyte, 140);
    c1.f(h.b(paramArrayOfbyte, 144));
    c1.g(h.b(paramArrayOfbyte, 148));
    c.c(c2, h.b(paramArrayOfbyte, 160));
    c.d(c2, 0);
    for (byte b1 = 0; b1 < 'Ȁ' && b1 < c.a(c2); b1++) {
      if (paramArrayOfbyte[164 + b1] == 0)
        c.b(c2); 
    } 
    System.arraycopy(paramArrayOfbyte, 164, c.c(c2), 0, 512);
    c1.o = c2.b();
    return c1;
  }
  
  void b(byte[] paramArrayOfbyte) {
    c.a(this.l, h.b(paramArrayOfbyte, 16));
    c.c(this.l, h.b(paramArrayOfbyte, 160));
    c.d(this.l, 0);
    for (byte b1 = 0; b1 < 'Ȁ' && b1 < c.a(this.l); b1++) {
      if (paramArrayOfbyte[164 + b1] == 0)
        c.b(this.l); 
    } 
    System.arraycopy(paramArrayOfbyte, 164, c.c(this.l), 0, 512);
  }
  
  public String getName() {
    return this.b;
  }
  
  String m() {
    return this.n;
  }
  
  public final void b(String paramString) {
    this.n = paramString;
    if (paramString != null) {
      if (isDirectory() && !paramString.endsWith("/"))
        paramString = paramString + "/"; 
      if (paramString.startsWith("./"))
        paramString = paramString.substring(2); 
    } 
    this.b = paramString;
  }
  
  public Date a() {
    return new Date(this.h);
  }
  
  public boolean isDirectory() {
    return (this.c == b.f);
  }
  
  public boolean n() {
    return (this.c == b.d);
  }
  
  public boolean o() {
    return (this.c == b.b);
  }
  
  public boolean p() {
    return (this.c == b.g);
  }
  
  public boolean q() {
    return (this.c == b.e);
  }
  
  public boolean r() {
    return (this.c == b.h);
  }
  
  public b s() {
    return this.c;
  }
  
  public void a(b paramb) {
    this.c = paramb;
  }
  
  public int t() {
    return this.d;
  }
  
  public void e(int paramInt) {
    this.d = paramInt & 0xFFF;
    this.e = a.a(paramInt);
  }
  
  public Set<a> u() {
    return this.e;
  }
  
  public long getSize() {
    return isDirectory() ? -1L : this.f;
  }
  
  long v() {
    return this.f;
  }
  
  public void b(long paramLong) {
    this.f = paramLong;
  }
  
  public void b(Date paramDate) {
    this.h = paramDate.getTime();
  }
  
  public Date w() {
    return new Date(this.g);
  }
  
  public void c(Date paramDate) {
    this.g = paramDate.getTime();
  }
  
  public int x() {
    return this.i;
  }
  
  public void f(int paramInt) {
    this.i = paramInt;
  }
  
  public int y() {
    return this.j;
  }
  
  public void g(int paramInt) {
    this.j = paramInt;
  }
  
  public enum a {
    a(2048),
    b(1024),
    c(512),
    d(256),
    e(128),
    f(64),
    g(32),
    h(16),
    i(8),
    j(4),
    k(2),
    l(1);
    
    private int m;
    
    public static a[] a() {
      return (a[])n.clone();
    }
    
    public static a a(String param1String) {
      return Enum.<a>valueOf(a.class, param1String);
    }
    
    a(int param1Int1) {
      this.m = param1Int1;
    }
    
    public static Set<a> a(int param1Int) {
      HashSet<a> hashSet = new HashSet();
      for (a a1 : a()) {
        if ((param1Int & a1.m) == a1.m)
          hashSet.add(a1); 
      } 
      return hashSet.isEmpty() ? Collections.emptySet() : EnumSet.copyOf(hashSet);
    }
  }
  
  public enum b {
    a(14),
    b(12),
    c(10),
    d(8),
    e(6),
    f(4),
    g(2),
    h(1),
    i(15);
    
    private int j;
    
    public static b[] a() {
      return (b[])k.clone();
    }
    
    public static b a(String param1String) {
      return Enum.<b>valueOf(b.class, param1String);
    }
    
    b(int param1Int1) {
      this.j = param1Int1;
    }
    
    public static b a(int param1Int) {
      b b1 = i;
      for (b b2 : a()) {
        if (param1Int == b2.j)
          b1 = b2; 
      } 
      return b1;
    }
  }
  
  static class c {
    private b.b a;
    
    private int b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    private final byte[] f = new byte[512];
    
    public b.b a() {
      return this.a;
    }
    
    public int b() {
      return this.b;
    }
    
    public int c() {
      return this.c;
    }
    
    void a(int param1Int) {
      this.c = param1Int;
    }
    
    public int d() {
      return this.d;
    }
    
    public int e() {
      return this.e;
    }
    
    public int b(int param1Int) {
      return this.f[param1Int];
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */