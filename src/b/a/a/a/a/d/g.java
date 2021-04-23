package b.a.a.a.a.d;

import b.a.a.a.a.h.D;
import java.io.IOException;
import java.util.Date;

public class g {
  private long a;
  
  private long b;
  
  private int c;
  
  private String d;
  
  private int e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  g(byte[] paramArrayOfbyte, D paramD) throws IOException {
    this.a = 1000L * h.b(paramArrayOfbyte, 4);
    this.b = 1000L * h.b(paramArrayOfbyte, 8);
    this.c = h.b(paramArrayOfbyte, 12);
    this.d = h.a(paramD, paramArrayOfbyte, 676, 16).trim();
    this.e = h.b(paramArrayOfbyte, 692);
    this.f = h.a(paramD, paramArrayOfbyte, 696, 64).trim();
    this.g = h.a(paramD, paramArrayOfbyte, 760, 64).trim();
    this.h = h.a(paramD, paramArrayOfbyte, 824, 64).trim();
    this.i = h.b(paramArrayOfbyte, 888);
    this.j = h.b(paramArrayOfbyte, 892);
    this.k = h.b(paramArrayOfbyte, 896);
  }
  
  public Date a() {
    return new Date(this.a);
  }
  
  public void a(Date paramDate) {
    this.a = paramDate.getTime();
  }
  
  public Date b() {
    return new Date(this.b);
  }
  
  public void b(Date paramDate) {
    this.b = paramDate.getTime();
  }
  
  public int c() {
    return this.c;
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public int d() {
    return this.e;
  }
  
  public void b(int paramInt) {
    this.e = paramInt;
  }
  
  public String e() {
    return this.d;
  }
  
  public void a(String paramString) {
    this.d = paramString;
  }
  
  public String f() {
    return this.f;
  }
  
  public void b(String paramString) {
    this.f = paramString;
  }
  
  public String g() {
    return this.g;
  }
  
  public void c(String paramString) {
    this.g = paramString;
  }
  
  public String h() {
    return this.h;
  }
  
  public void d(String paramString) {
    this.h = paramString;
  }
  
  public int i() {
    return this.i;
  }
  
  public void c(int paramInt) {
    this.i = paramInt;
  }
  
  public int j() {
    return this.j;
  }
  
  public void d(int paramInt) {
    this.j = paramInt;
  }
  
  public int k() {
    return this.k;
  }
  
  public void e(int paramInt) {
    this.k = paramInt;
  }
  
  public boolean l() {
    return ((this.i & 0x1) == 1);
  }
  
  public boolean m() {
    return ((this.i & 0x2) == 2);
  }
  
  public boolean n() {
    return ((this.i & 0x80) == 128);
  }
  
  public boolean o() {
    return ((this.i & 0x100) == 256);
  }
  
  public boolean p() {
    return ((this.i & 0x8000) == 32768);
  }
  
  public int hashCode() {
    int i = 17;
    if (this.d != null)
      i = this.d.hashCode(); 
    i = (int)(i + 31L * this.a);
    if (this.h != null)
      i = 31 * this.h.hashCode() + 17; 
    if (this.g != null)
      i = 31 * this.g.hashCode() + 17; 
    return i;
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || !o.getClass().equals(getClass()))
      return false; 
    g g1 = (g)o;
    return (this.a != g1.a) ? false : ((h() == null || !h().equals(g1.h())) ? false : (!(g() == null || !g().equals(g1.g()))));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */