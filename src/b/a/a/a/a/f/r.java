package b.a.a.a.a.f;

import b.a.a.a.a.a;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

public class r implements a {
  private String b;
  
  private boolean c;
  
  private boolean d;
  
  private boolean e;
  
  private boolean f;
  
  private boolean g;
  
  private boolean h;
  
  private long i;
  
  private long j;
  
  private long k;
  
  private boolean l;
  
  private int m;
  
  private boolean n;
  
  private long o;
  
  private long p;
  
  private long q;
  
  private long r;
  
  private Iterable<? extends u> s;
  
  public String getName() {
    return this.b;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public boolean b() {
    return this.c;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public boolean isDirectory() {
    return this.d;
  }
  
  public void b(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public boolean c() {
    return this.e;
  }
  
  public void c(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public boolean d() {
    return this.f;
  }
  
  public void d(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public Date e() {
    if (this.f)
      return h(this.i); 
    throw new UnsupportedOperationException("The entry doesn't have this timestamp");
  }
  
  public void a(long paramLong) {
    this.i = paramLong;
  }
  
  public void a(Date paramDate) {
    this.f = (paramDate != null);
    if (this.f)
      this.i = d(paramDate); 
  }
  
  public boolean f() {
    return this.g;
  }
  
  public void e(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public Date a() {
    if (this.g)
      return h(this.j); 
    throw new UnsupportedOperationException("The entry doesn't have this timestamp");
  }
  
  public void b(long paramLong) {
    this.j = paramLong;
  }
  
  public void b(Date paramDate) {
    this.g = (paramDate != null);
    if (this.g)
      this.j = d(paramDate); 
  }
  
  public boolean g() {
    return this.h;
  }
  
  public void f(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public Date h() {
    if (this.h)
      return h(this.k); 
    throw new UnsupportedOperationException("The entry doesn't have this timestamp");
  }
  
  public void c(long paramLong) {
    this.k = paramLong;
  }
  
  public void c(Date paramDate) {
    this.h = (paramDate != null);
    if (this.h)
      this.k = d(paramDate); 
  }
  
  public boolean i() {
    return this.l;
  }
  
  public void g(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public int j() {
    return this.m;
  }
  
  public void a(int paramInt) {
    this.m = paramInt;
  }
  
  public boolean k() {
    return this.n;
  }
  
  public void h(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public int l() {
    return (int)this.o;
  }
  
  public void b(int paramInt) {
    this.o = paramInt;
  }
  
  public long m() {
    return this.o;
  }
  
  public void d(long paramLong) {
    this.o = paramLong;
  }
  
  int n() {
    return (int)this.p;
  }
  
  void c(int paramInt) {
    this.p = paramInt;
  }
  
  long o() {
    return this.p;
  }
  
  void e(long paramLong) {
    this.p = paramLong;
  }
  
  public long getSize() {
    return this.q;
  }
  
  public void f(long paramLong) {
    this.q = paramLong;
  }
  
  long p() {
    return this.r;
  }
  
  void g(long paramLong) {
    this.r = paramLong;
  }
  
  public void a(Iterable<? extends u> paramIterable) {
    if (paramIterable != null) {
      LinkedList<u> linkedList = new LinkedList();
      for (u u : paramIterable)
        linkedList.addLast(u); 
      this.s = Collections.unmodifiableList(linkedList);
    } else {
      this.s = null;
    } 
  }
  
  public Iterable<? extends u> q() {
    return this.s;
  }
  
  public static Date h(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
    calendar.set(1601, 0, 1, 0, 0, 0);
    calendar.set(14, 0);
    long l = calendar.getTimeInMillis() + paramLong / 10000L;
    return new Date(l);
  }
  
  public static long d(Date paramDate) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
    calendar.set(1601, 0, 1, 0, 0, 0);
    calendar.set(14, 0);
    return (paramDate.getTime() - calendar.getTimeInMillis()) * 1000L * 10L;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/r.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */