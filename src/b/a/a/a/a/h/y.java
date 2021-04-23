package b.a.a.a.a.h;

import b.a.a.a.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class y extends ZipEntry implements a {
  public static final int b = 3;
  
  public static final int c = 0;
  
  private static final int d = 65535;
  
  private static final int e = 16;
  
  private static final byte[] f = new byte[0];
  
  private int g = -1;
  
  private long h = -1L;
  
  private int i = 0;
  
  private int j = 0;
  
  private long k = 0L;
  
  private LinkedHashMap<L, F> l = null;
  
  private p m = null;
  
  private String n = null;
  
  private byte[] o = null;
  
  private i p = new i();
  
  public y(String paramString) {
    super(paramString);
    a(paramString);
  }
  
  public y(ZipEntry paramZipEntry) throws ZipException {
    super(paramZipEntry);
    a(paramZipEntry.getName());
    byte[] arrayOfByte = paramZipEntry.getExtra();
    if (arrayOfByte != null) {
      a(g.a(arrayOfByte, true, g.a.f));
    } else {
      l();
    } 
    setMethod(paramZipEntry.getMethod());
    this.h = paramZipEntry.getSize();
  }
  
  public y(y paramy) throws ZipException {
    this(paramy);
    a(paramy.d());
    a(paramy.e());
    a(paramy.a(true));
  }
  
  protected y() {
    this("");
  }
  
  public y(File paramFile, String paramString) {
    this((paramFile.isDirectory() && !paramString.endsWith("/")) ? (paramString + "/") : paramString);
    if (paramFile.isFile())
      setSize(paramFile.length()); 
    setTime(paramFile.lastModified());
  }
  
  public Object clone() {
    y y1 = (y)super.clone();
    y1.a(d());
    y1.a(e());
    y1.a(a(true));
    return y1;
  }
  
  public int getMethod() {
    return this.g;
  }
  
  public void setMethod(int method) {
    if (method < 0)
      throw new IllegalArgumentException("ZIP compression method can not be negative: " + method); 
    this.g = method;
  }
  
  public int d() {
    return this.i;
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
  }
  
  public long e() {
    return this.k;
  }
  
  public void a(long paramLong) {
    this.k = paramLong;
  }
  
  public void b(int paramInt) {
    a((paramInt << 16 | (((paramInt & 0x80) == 0) ? 1 : 0) | (isDirectory() ? 16 : 0)));
    this.j = 3;
  }
  
  public int f() {
    return (this.j != 3) ? 0 : (int)(e() >> 16L & 0xFFFFL);
  }
  
  public boolean g() {
    return ((f() & 0xA000) == 40960);
  }
  
  public int h() {
    return this.j;
  }
  
  protected void c(int paramInt) {
    this.j = paramInt;
  }
  
  public void a(F[] paramArrayOfF) {
    this.l = new LinkedHashMap<L, F>();
    for (F f : paramArrayOfF) {
      if (f instanceof p) {
        this.m = (p)f;
      } else {
        this.l.put(f.a(), f);
      } 
    } 
    l();
  }
  
  public F[] i() {
    return a(false);
  }
  
  public F[] a(boolean paramBoolean) {
    if (this.l == null) {
      (new F[1])[0] = this.m;
      return (!paramBoolean || this.m == null) ? new F[0] : new F[1];
    } 
    ArrayList<p> arrayList = new ArrayList(this.l.values());
    if (paramBoolean && this.m != null)
      arrayList.add(this.m); 
    return arrayList.<F>toArray(new F[0]);
  }
  
  public void a(F paramF) {
    if (paramF instanceof p) {
      this.m = (p)paramF;
    } else {
      if (this.l == null)
        this.l = new LinkedHashMap<L, F>(); 
      this.l.put(paramF.a(), paramF);
    } 
    l();
  }
  
  public void b(F paramF) {
    if (paramF instanceof p) {
      this.m = (p)paramF;
    } else {
      LinkedHashMap<L, F> linkedHashMap = this.l;
      this.l = new LinkedHashMap<L, F>();
      this.l.put(paramF.a(), paramF);
      if (linkedHashMap != null) {
        linkedHashMap.remove(paramF.a());
        this.l.putAll(linkedHashMap);
      } 
    } 
    l();
  }
  
  public void a(L paramL) {
    if (this.l == null)
      throw new NoSuchElementException(); 
    if (this.l.remove(paramL) == null)
      throw new NoSuchElementException(); 
    l();
  }
  
  public void j() {
    if (this.m == null)
      throw new NoSuchElementException(); 
    this.m = null;
    l();
  }
  
  public F b(L paramL) {
    return (this.l != null) ? this.l.get(paramL) : null;
  }
  
  public p k() {
    return this.m;
  }
  
  public void setExtra(byte[] extra) throws RuntimeException {
    try {
      F[] arrayOfF = g.a(extra, true, g.a.f);
      a(arrayOfF, true);
    } catch (ZipException zipException) {
      throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + zipException.getMessage(), zipException);
    } 
  }
  
  protected void l() {
    super.setExtra(g.a(a(true)));
  }
  
  public void a(byte[] paramArrayOfbyte) {
    try {
      F[] arrayOfF = g.a(paramArrayOfbyte, false, g.a.f);
      a(arrayOfF, false);
    } catch (ZipException zipException) {
      throw new RuntimeException(zipException.getMessage(), zipException);
    } 
  }
  
  public byte[] m() {
    byte[] arrayOfByte = getExtra();
    return (arrayOfByte != null) ? arrayOfByte : f;
  }
  
  public byte[] n() {
    return g.b(a(true));
  }
  
  public String getName() {
    return (this.n == null) ? super.getName() : this.n;
  }
  
  public boolean isDirectory() {
    return getName().endsWith("/");
  }
  
  protected void a(String paramString) {
    if (paramString != null && h() == 0 && paramString.indexOf("/") == -1)
      paramString = paramString.replace('\\', '/'); 
    this.n = paramString;
  }
  
  public long getSize() {
    return this.h;
  }
  
  public void setSize(long size) {
    if (size < 0L)
      throw new IllegalArgumentException("invalid entry size"); 
    this.h = size;
  }
  
  protected void a(String paramString, byte[] paramArrayOfbyte) {
    a(paramString);
    this.o = paramArrayOfbyte;
  }
  
  public byte[] o() {
    if (this.o != null) {
      byte[] arrayOfByte = new byte[this.o.length];
      System.arraycopy(this.o, 0, arrayOfByte, 0, this.o.length);
      return arrayOfByte;
    } 
    return null;
  }
  
  public int hashCode() {
    return getName().hashCode();
  }
  
  public i p() {
    return this.p;
  }
  
  public void a(i parami) {
    this.p = parami;
  }
  
  private void a(F[] paramArrayOfF, boolean paramBoolean) throws ZipException {
    if (this.l == null) {
      a(paramArrayOfF);
    } else {
      for (F f1 : paramArrayOfF) {
        F f2;
        if (f1 instanceof p) {
          f2 = this.m;
        } else {
          f2 = b(f1.a());
        } 
        if (f2 == null) {
          a(f1);
        } else if (paramBoolean) {
          byte[] arrayOfByte = f1.e();
          f2.a(arrayOfByte, 0, arrayOfByte.length);
        } else {
          byte[] arrayOfByte = f1.c();
          f2.b(arrayOfByte, 0, arrayOfByte.length);
        } 
      } 
      l();
    } 
  }
  
  public Date a() {
    return new Date(getTime());
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null || getClass() != obj.getClass())
      return false; 
    y y1 = (y)obj;
    String str1 = getName();
    String str2 = y1.getName();
    if (str1 == null) {
      if (str2 != null)
        return false; 
    } else if (!str1.equals(str2)) {
      return false;
    } 
    String str3 = getComment();
    String str4 = y1.getComment();
    if (str3 == null)
      str3 = ""; 
    if (str4 == null)
      str4 = ""; 
    return (getTime() == y1.getTime() && str3.equals(str4) && d() == y1.d() && h() == y1.h() && e() == y1.e() && getMethod() == y1.getMethod() && getSize() == y1.getSize() && getCrc() == y1.getCrc() && getCompressedSize() == y1.getCompressedSize() && Arrays.equals(n(), y1.n()) && Arrays.equals(m(), y1.m()) && this.p.equals(y1.p));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/y.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */