package b.a.a.a.a.c;

import b.a.a.a.a.a;
import java.io.File;
import java.util.Date;

public class a implements a, d {
  private final short H;
  
  private final int I;
  
  private final int J;
  
  private long K = 0L;
  
  private long L = 0L;
  
  private long M = 0L;
  
  private long N = 0L;
  
  private long O = 0L;
  
  private long P = 0L;
  
  private long Q = 0L;
  
  private long R = 0L;
  
  private String S;
  
  private long T = 0L;
  
  private long U = 0L;
  
  private long V = 0L;
  
  private long W = 0L;
  
  public a(short paramShort) {
    switch (paramShort) {
      case 1:
        this.I = 110;
        this.J = 4;
        break;
      case 2:
        this.I = 110;
        this.J = 4;
        break;
      case 4:
        this.I = 76;
        this.J = 0;
        break;
      case 8:
        this.I = 26;
        this.J = 2;
        break;
      default:
        throw new IllegalArgumentException("Unknown header type");
    } 
    this.H = paramShort;
  }
  
  public a(String paramString) {
    this((short)1, paramString);
  }
  
  public a(short paramShort, String paramString) {
    this(paramShort);
    this.S = paramString;
  }
  
  public a(String paramString, long paramLong) {
    this(paramString);
    e(paramLong);
  }
  
  public a(short paramShort, String paramString, long paramLong) {
    this(paramShort, paramString);
    e(paramLong);
  }
  
  public a(File paramFile, String paramString) {
    this((short)1, paramFile, paramString);
  }
  
  public a(short paramShort, File paramFile, String paramString) {
    this(paramShort, paramString, paramFile.isFile() ? paramFile.length() : 0L);
    if (paramFile.isDirectory()) {
      h(16384L);
    } else if (paramFile.isFile()) {
      h(32768L);
    } else {
      throw new IllegalArgumentException("Cannot determine type of file " + paramFile.getName());
    } 
    m(paramFile.lastModified() / 1000L);
  }
  
  private void A() {
    if ((this.H & 0x3) == 0)
      throw new UnsupportedOperationException(); 
  }
  
  private void B() {
    if ((this.H & 0xC) == 0)
      throw new UnsupportedOperationException(); 
  }
  
  public long b() {
    A();
    return this.K;
  }
  
  public long c() {
    B();
    return this.P;
  }
  
  public long d() {
    A();
    return this.O;
  }
  
  public long e() {
    A();
    return this.P;
  }
  
  public long getSize() {
    return this.L;
  }
  
  public short f() {
    return this.H;
  }
  
  public long g() {
    return this.M;
  }
  
  public int h() {
    return this.I;
  }
  
  public int i() {
    return this.J;
  }
  
  public int j() {
    if (this.J == 0)
      return 0; 
    int i = this.I + 1;
    if (this.S != null)
      i += this.S.length(); 
    int j = i % this.J;
    return (j > 0) ? (this.J - j) : 0;
  }
  
  public int k() {
    if (this.J == 0)
      return 0; 
    long l = this.L;
    int i = (int)(l % this.J);
    return (i > 0) ? (this.J - i) : 0;
  }
  
  public long l() {
    return this.N;
  }
  
  public long m() {
    return (this.Q == 0L && !"TRAILER!!!".equals(this.S)) ? 32768L : this.Q;
  }
  
  public String getName() {
    return this.S;
  }
  
  public long n() {
    return (this.T == 0L) ? (isDirectory() ? 2L : 1L) : this.T;
  }
  
  public long o() {
    B();
    return this.V;
  }
  
  public long p() {
    A();
    return this.U;
  }
  
  public long q() {
    A();
    return this.V;
  }
  
  public long r() {
    return this.R;
  }
  
  public Date a() {
    return new Date(1000L * r());
  }
  
  public long s() {
    return this.W;
  }
  
  public boolean t() {
    return (e.a(this.Q) == 24576L);
  }
  
  public boolean u() {
    return (e.a(this.Q) == 8192L);
  }
  
  public boolean isDirectory() {
    return (e.a(this.Q) == 16384L);
  }
  
  public boolean v() {
    return (e.a(this.Q) == 36864L);
  }
  
  public boolean w() {
    return (e.a(this.Q) == 4096L);
  }
  
  public boolean x() {
    return (e.a(this.Q) == 32768L);
  }
  
  public boolean y() {
    return (e.a(this.Q) == 49152L);
  }
  
  public boolean z() {
    return (e.a(this.Q) == 40960L);
  }
  
  public void a(long paramLong) {
    A();
    this.K = paramLong;
  }
  
  public void b(long paramLong) {
    B();
    this.P = paramLong;
  }
  
  public void c(long paramLong) {
    A();
    this.O = paramLong;
  }
  
  public void d(long paramLong) {
    A();
    this.P = paramLong;
  }
  
  public void e(long paramLong) {
    if (paramLong < 0L || paramLong > 4294967295L)
      throw new IllegalArgumentException("invalid entry size <" + paramLong + ">"); 
    this.L = paramLong;
  }
  
  public void f(long paramLong) {
    this.M = paramLong;
  }
  
  public void g(long paramLong) {
    this.N = paramLong;
  }
  
  public void h(long paramLong) {
    long l = paramLong & 0xF000L;
    switch ((int)l) {
      case 4096:
      case 8192:
      case 16384:
      case 24576:
      case 32768:
      case 36864:
      case 40960:
      case 49152:
        break;
      default:
        throw new IllegalArgumentException("Unknown mode. Full: " + Long.toHexString(paramLong) + " Masked: " + Long.toHexString(l));
    } 
    this.Q = paramLong;
  }
  
  public void a(String paramString) {
    this.S = paramString;
  }
  
  public void i(long paramLong) {
    this.T = paramLong;
  }
  
  public void j(long paramLong) {
    B();
    this.V = paramLong;
  }
  
  public void k(long paramLong) {
    A();
    this.U = paramLong;
  }
  
  public void l(long paramLong) {
    A();
    this.V = paramLong;
  }
  
  public void m(long paramLong) {
    this.R = paramLong;
  }
  
  public void n(long paramLong) {
    this.W = paramLong;
  }
  
  public int hashCode() {
    byte b = 31;
    null = 1;
    return 31 * null + ((this.S == null) ? 0 : this.S.hashCode());
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null || getClass() != obj.getClass())
      return false; 
    a a1 = (a)obj;
    if (this.S == null) {
      if (a1.S != null)
        return false; 
    } else if (!this.S.equals(a1.S)) {
      return false;
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/c/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */