package b.a.a.a.a.g;

import b.a.a.a.a.a;
import b.a.a.a.a.h.D;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class a implements a, e {
  private String ah = "";
  
  private int ai;
  
  private int aj = 0;
  
  private int ak = 0;
  
  private long al = 0L;
  
  private long am;
  
  private boolean an;
  
  private byte ao;
  
  private String ap = "";
  
  private String aq = "ustar\000";
  
  private String ar = "00";
  
  private String as;
  
  private String at = "";
  
  private int au = 0;
  
  private int av = 0;
  
  private boolean aw;
  
  private long ax;
  
  private final File ay;
  
  public static final int b = 31;
  
  public static final int c = 16877;
  
  public static final int d = 33188;
  
  public static final int e = 1000;
  
  private a() {
    String str = System.getProperty("user.name", "");
    if (str.length() > 31)
      str = str.substring(0, 31); 
    this.as = str;
    this.ay = null;
  }
  
  public a(String paramString) {
    this(paramString, false);
  }
  
  public a(String paramString, boolean paramBoolean) {
    this();
    paramString = a(paramString, paramBoolean);
    boolean bool = paramString.endsWith("/");
    this.ah = paramString;
    this.ai = bool ? 16877 : 33188;
    this.ao = bool ? 53 : 48;
    this.am = (new Date()).getTime() / 1000L;
    this.as = "";
  }
  
  public a(String paramString, byte paramByte) {
    this(paramString, paramByte, false);
  }
  
  public a(String paramString, byte paramByte, boolean paramBoolean) {
    this(paramString, paramBoolean);
    this.ao = paramByte;
    if (paramByte == 76) {
      this.aq = "ustar ";
      this.ar = " \000";
    } 
  }
  
  public a(File paramFile) {
    this(paramFile, a(paramFile.getPath(), false));
  }
  
  public a(File paramFile, String paramString) {
    this.ay = paramFile;
    if (paramFile.isDirectory()) {
      this.ai = 16877;
      this.ao = 53;
      int i = paramString.length();
      if (i == 0 || paramString.charAt(i - 1) != '/') {
        this.ah = paramString + "/";
      } else {
        this.ah = paramString;
      } 
    } else {
      this.ai = 33188;
      this.ao = 48;
      this.al = paramFile.length();
      this.ah = paramString;
    } 
    this.am = paramFile.lastModified() / 1000L;
    this.as = "";
  }
  
  public a(byte[] paramArrayOfbyte) {
    this();
    b(paramArrayOfbyte);
  }
  
  public a(byte[] paramArrayOfbyte, D paramD) throws IOException {
    this();
    a(paramArrayOfbyte, paramD);
  }
  
  public boolean a(a parama) {
    return getName().equals(parama.getName());
  }
  
  public boolean equals(Object it) {
    return (it == null || getClass() != it.getClass()) ? false : a((a)it);
  }
  
  public int hashCode() {
    return getName().hashCode();
  }
  
  public boolean b(a parama) {
    return parama.getName().startsWith(getName());
  }
  
  public String getName() {
    return this.ah.toString();
  }
  
  public void a(String paramString) {
    this.ah = a(paramString, false);
  }
  
  public void a(int paramInt) {
    this.ai = paramInt;
  }
  
  public String b() {
    return this.ap.toString();
  }
  
  public void b(String paramString) {
    this.ap = paramString;
  }
  
  public int c() {
    return this.aj;
  }
  
  public void b(int paramInt) {
    this.aj = paramInt;
  }
  
  public int d() {
    return this.ak;
  }
  
  public void c(int paramInt) {
    this.ak = paramInt;
  }
  
  public String e() {
    return this.as.toString();
  }
  
  public void c(String paramString) {
    this.as = paramString;
  }
  
  public String f() {
    return this.at.toString();
  }
  
  public void d(String paramString) {
    this.at = paramString;
  }
  
  public void a(int paramInt1, int paramInt2) {
    b(paramInt1);
    c(paramInt2);
  }
  
  public void a(String paramString1, String paramString2) {
    c(paramString1);
    d(paramString2);
  }
  
  public void a(long paramLong) {
    this.am = paramLong / 1000L;
  }
  
  public void a(Date paramDate) {
    this.am = paramDate.getTime() / 1000L;
  }
  
  public Date g() {
    return new Date(this.am * 1000L);
  }
  
  public Date a() {
    return g();
  }
  
  public boolean h() {
    return this.an;
  }
  
  public File i() {
    return this.ay;
  }
  
  public int j() {
    return this.ai;
  }
  
  public long getSize() {
    return this.al;
  }
  
  public void b(long paramLong) {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Size is out of range: " + paramLong); 
    this.al = paramLong;
  }
  
  public int k() {
    return this.au;
  }
  
  public void d(int paramInt) {
    if (paramInt < 0)
      throw new IllegalArgumentException("Major device number is out of range: " + paramInt); 
    this.au = paramInt;
  }
  
  public int l() {
    return this.av;
  }
  
  public void e(int paramInt) {
    if (paramInt < 0)
      throw new IllegalArgumentException("Minor device number is out of range: " + paramInt); 
    this.av = paramInt;
  }
  
  public boolean m() {
    return this.aw;
  }
  
  public long n() {
    return this.ax;
  }
  
  public boolean o() {
    return (this.ao == 83);
  }
  
  public boolean p() {
    return (this.ao == 75 && this.ah.equals("././@LongLink"));
  }
  
  public boolean q() {
    return (this.ao == 76 && this.ah.equals("././@LongLink"));
  }
  
  public boolean r() {
    return (this.ao == 120 || this.ao == 88);
  }
  
  public boolean s() {
    return (this.ao == 103);
  }
  
  public boolean isDirectory() {
    return (this.ay != null) ? this.ay.isDirectory() : ((this.ao == 53) ? true : (getName().endsWith("/")));
  }
  
  public boolean t() {
    return (this.ay != null) ? this.ay.isFile() : ((this.ao == 0 || this.ao == 48) ? true : (!getName().endsWith("/")));
  }
  
  public boolean u() {
    return (this.ao == 50);
  }
  
  public boolean v() {
    return (this.ao == 49);
  }
  
  public boolean w() {
    return (this.ao == 51);
  }
  
  public boolean x() {
    return (this.ao == 52);
  }
  
  public boolean y() {
    return (this.ao == 54);
  }
  
  public a[] z() {
    if (this.ay == null || !this.ay.isDirectory())
      return new a[0]; 
    String[] arrayOfString = this.ay.list();
    a[] arrayOfA = new a[arrayOfString.length];
    for (byte b = 0; b < arrayOfString.length; b++)
      arrayOfA[b] = new a(new File(this.ay, arrayOfString[b])); 
    return arrayOfA;
  }
  
  public void a(byte[] paramArrayOfbyte) {
    try {
      a(paramArrayOfbyte, f.a, false);
    } catch (IOException iOException) {
      try {
        a(paramArrayOfbyte, f.b, false);
      } catch (IOException iOException1) {
        throw new RuntimeException(iOException1);
      } 
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, D paramD, boolean paramBoolean) throws IOException {
    int i = 0;
    i = f.a(this.ah, paramArrayOfbyte, i, 100, paramD);
    i = a(this.ai, paramArrayOfbyte, i, 8, paramBoolean);
    i = a(this.aj, paramArrayOfbyte, i, 8, paramBoolean);
    i = a(this.ak, paramArrayOfbyte, i, 8, paramBoolean);
    i = a(this.al, paramArrayOfbyte, i, 12, paramBoolean);
    i = a(this.am, paramArrayOfbyte, i, 12, paramBoolean);
    int j = i;
    for (byte b = 0; b < 8; b++)
      paramArrayOfbyte[i++] = 32; 
    paramArrayOfbyte[i++] = this.ao;
    i = f.a(this.ap, paramArrayOfbyte, i, 100, paramD);
    i = f.a(this.aq, paramArrayOfbyte, i, 6);
    i = f.a(this.ar, paramArrayOfbyte, i, 2);
    i = f.a(this.as, paramArrayOfbyte, i, 32, paramD);
    i = f.a(this.at, paramArrayOfbyte, i, 32, paramD);
    i = a(this.au, paramArrayOfbyte, i, 8, paramBoolean);
    i = a(this.av, paramArrayOfbyte, i, 8, paramBoolean);
    while (i < paramArrayOfbyte.length)
      paramArrayOfbyte[i++] = 0; 
    long l = f.a(paramArrayOfbyte);
    f.e(l, paramArrayOfbyte, j, 8);
  }
  
  private int a(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    return (!paramBoolean && (paramLong < 0L || paramLong >= 1L << 3 * (paramInt2 - 1))) ? f.c(0L, paramArrayOfbyte, paramInt1, paramInt2) : f.d(paramLong, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void b(byte[] paramArrayOfbyte) {
    try {
      a(paramArrayOfbyte, f.a);
    } catch (IOException iOException) {
      try {
        b(paramArrayOfbyte, f.a, true);
      } catch (IOException iOException1) {
        throw new RuntimeException(iOException1);
      } 
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, D paramD) throws IOException {
    b(paramArrayOfbyte, paramD, false);
  }
  
  private void b(byte[] paramArrayOfbyte, D paramD, boolean paramBoolean) throws IOException {
    byte b = 0;
    this.ah = paramBoolean ? f.c(paramArrayOfbyte, b, 100) : f.a(paramArrayOfbyte, b, 100, paramD);
    b += true;
    this.ai = (int)f.b(paramArrayOfbyte, b, 8);
    b += true;
    this.aj = (int)f.b(paramArrayOfbyte, b, 8);
    b += true;
    this.ak = (int)f.b(paramArrayOfbyte, b, 8);
    b += true;
    this.al = f.b(paramArrayOfbyte, b, 12);
    b += true;
    this.am = f.b(paramArrayOfbyte, b, 12);
    b += true;
    this.an = f.b(paramArrayOfbyte);
    b += true;
    this.ao = paramArrayOfbyte[b++];
    this.ap = paramBoolean ? f.c(paramArrayOfbyte, b, 100) : f.a(paramArrayOfbyte, b, 100, paramD);
    b += 100;
    this.aq = f.c(paramArrayOfbyte, b, 6);
    b += 6;
    this.ar = f.c(paramArrayOfbyte, b, 2);
    b += 2;
    this.as = paramBoolean ? f.c(paramArrayOfbyte, b, 32) : f.a(paramArrayOfbyte, b, 32, paramD);
    b += 32;
    this.at = paramBoolean ? f.c(paramArrayOfbyte, b, 32) : f.a(paramArrayOfbyte, b, 32, paramD);
    b += 32;
    this.au = (int)f.b(paramArrayOfbyte, b, 8);
    b += 8;
    this.av = (int)f.b(paramArrayOfbyte, b, 8);
    b += 8;
    int i = c(paramArrayOfbyte);
    switch (i) {
      case 2:
        b += 12;
        b += 12;
        b += 12;
        b += 4;
        b++;
        b += 96;
        this.aw = f.a(paramArrayOfbyte, b);
        this.ax = f.a(paramArrayOfbyte, ++b, 12);
        b += 12;
        return;
    } 
    String str = paramBoolean ? f.c(paramArrayOfbyte, b, 155) : f.a(paramArrayOfbyte, b, 155, paramD);
    if (isDirectory() && !this.ah.endsWith("/"))
      this.ah += "/"; 
    if (str.length() > 0)
      this.ah = str + "/" + this.ah; 
  }
  
  private static String a(String paramString, boolean paramBoolean) {
    String str = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    if (str != null)
      if (str.startsWith("windows")) {
        if (paramString.length() > 2) {
          char c1 = paramString.charAt(0);
          char c2 = paramString.charAt(1);
          if (c2 == ':' && ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')))
            paramString = paramString.substring(2); 
        } 
      } else if (str.indexOf("netware") > -1) {
        int i = paramString.indexOf(':');
        if (i != -1)
          paramString = paramString.substring(i + 1); 
      }  
    for (paramString = paramString.replace(File.separatorChar, '/'); !paramBoolean && paramString.startsWith("/"); paramString = paramString.substring(1));
    return paramString;
  }
  
  private int c(byte[] paramArrayOfbyte) {
    return b.a.a.a.d.a.a("ustar ", paramArrayOfbyte, 257, 6) ? 2 : (b.a.a.a.d.a.a("ustar\000", paramArrayOfbyte, 257, 6) ? 3 : 0);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/g/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */