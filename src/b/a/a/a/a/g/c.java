package b.a.a.a.a.g;

import b.a.a.a.a.a;
import b.a.a.a.a.d;
import b.a.a.a.a.h.D;
import b.a.a.a.a.h.E;
import b.a.a.a.d.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class c extends d {
  public static final int b = 0;
  
  public static final int c = 1;
  
  public static final int d = 2;
  
  public static final int e = 3;
  
  public static final int f = 0;
  
  public static final int g = 1;
  
  public static final int h = 2;
  
  private long i;
  
  private String j;
  
  private long k;
  
  private final byte[] l;
  
  private int m;
  
  private final byte[] n;
  
  private int o = 0;
  
  private int p = 0;
  
  private int q;
  
  private final int r;
  
  private final int s;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private final OutputStream w;
  
  private final D x;
  
  private boolean y = false;
  
  private static final D z = E.a("ASCII");
  
  public c(OutputStream paramOutputStream) {
    this(paramOutputStream, 10240, 512);
  }
  
  public c(OutputStream paramOutputStream, String paramString) {
    this(paramOutputStream, 10240, 512, paramString);
  }
  
  public c(OutputStream paramOutputStream, int paramInt) {
    this(paramOutputStream, paramInt, 512);
  }
  
  public c(OutputStream paramOutputStream, int paramInt, String paramString) {
    this(paramOutputStream, paramInt, 512, paramString);
  }
  
  public c(OutputStream paramOutputStream, int paramInt1, int paramInt2) {
    this(paramOutputStream, paramInt1, paramInt2, (String)null);
  }
  
  public c(OutputStream paramOutputStream, int paramInt1, int paramInt2, String paramString) {
    this.w = (OutputStream)new h(paramOutputStream);
    this.x = E.a(paramString);
    this.m = 0;
    this.n = new byte[paramInt2];
    this.l = new byte[paramInt2];
    this.s = paramInt2;
    this.r = paramInt1 / paramInt2;
  }
  
  public void b(int paramInt) {
    this.o = paramInt;
  }
  
  public void c(int paramInt) {
    this.p = paramInt;
  }
  
  public void a(boolean paramBoolean) {
    this.y = paramBoolean;
  }
  
  public int c() {
    return (int)d();
  }
  
  public long d() {
    return ((h)this.w).a();
  }
  
  public void b() throws IOException {
    if (this.v)
      throw new IOException("This archive has already been finished"); 
    if (this.u)
      throw new IOException("This archives contains unclosed entries."); 
    f();
    f();
    g();
    this.w.flush();
    this.v = true;
  }
  
  public void close() throws IOException {
    if (!this.v)
      b(); 
    if (!this.t) {
      this.w.close();
      this.t = true;
    } 
  }
  
  public int e() {
    return this.s;
  }
  
  public void a(a parama) throws IOException {
    if (this.v)
      throw new IOException("Stream has already been finished"); 
    a a1 = (a)parama;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String str1 = a1.getName();
    boolean bool = a(a1, str1, (Map)hashMap, "path", (byte)76, "file name");
    String str2 = a1.b();
    boolean bool1 = (str2 != null && str2.length() > 0 && a(a1, str2, (Map)hashMap, "linkpath", (byte)75, "link name")) ? true : false;
    if (this.p == 2) {
      a((Map)hashMap, a1);
    } else if (this.p != 1) {
      a(a1);
    } 
    if (this.y && !bool && !z.a(str1))
      hashMap.put("path", str1); 
    if (this.y && !bool1 && (a1.v() || a1.u()) && !z.a(str2))
      hashMap.put("linkpath", str2); 
    if (hashMap.size() > 0)
      a(a1, str1, (Map)hashMap); 
    a1.a(this.l, this.x, (this.p == 1));
    a(this.l);
    this.k = 0L;
    if (a1.isDirectory()) {
      this.i = 0L;
    } else {
      this.i = a1.getSize();
    } 
    this.j = str1;
    this.u = true;
  }
  
  public void a() throws IOException {
    if (this.v)
      throw new IOException("Stream has already been finished"); 
    if (!this.u)
      throw new IOException("No current entry to close"); 
    if (this.m > 0) {
      for (int i = this.m; i < this.n.length; i++)
        this.n[i] = 0; 
      a(this.n);
      this.k += this.m;
      this.m = 0;
    } 
    if (this.k < this.i)
      throw new IOException("entry '" + this.j + "' closed at '" + this.k + "' before the '" + this.i + "' bytes specified in the header were written"); 
    this.u = false;
  }
  
  public void write(byte[] wBuf, int wOffset, int numToWrite) throws IOException {
    if (!this.u)
      throw new IllegalStateException("No current tar entry"); 
    if (this.k + numToWrite > this.i)
      throw new IOException("request to write '" + numToWrite + "' bytes exceeds size in header of '" + this.i + "' bytes for entry '" + this.j + "'"); 
    if (this.m > 0)
      if (this.m + numToWrite >= this.l.length) {
        int i = this.l.length - this.m;
        System.arraycopy(this.n, 0, this.l, 0, this.m);
        System.arraycopy(wBuf, wOffset, this.l, this.m, i);
        a(this.l);
        this.k += this.l.length;
        wOffset += i;
        numToWrite -= i;
        this.m = 0;
      } else {
        System.arraycopy(wBuf, wOffset, this.n, this.m, numToWrite);
        wOffset += numToWrite;
        this.m += numToWrite;
        numToWrite = 0;
      }  
    while (numToWrite > 0) {
      if (numToWrite < this.l.length) {
        System.arraycopy(wBuf, wOffset, this.n, this.m, numToWrite);
        this.m += numToWrite;
        break;
      } 
      a(wBuf, wOffset);
      int i = this.l.length;
      this.k += i;
      numToWrite -= i;
      wOffset += i;
    } 
  }
  
  void a(a parama, String paramString, Map<String, String> paramMap) throws IOException {
    String str = "./PaxHeaders.X/" + a(paramString);
    if (str.length() >= 100)
      str = str.substring(0, 99); 
    a a1 = new a(str, (byte)120);
    a(parama, a1);
    StringWriter stringWriter = new StringWriter();
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      String str1 = (String)entry.getKey();
      String str2 = (String)entry.getValue();
      int i = str1.length() + str2.length() + 3 + 2;
      String str3 = i + " " + str1 + "=" + str2 + "\n";
      int j;
      for (j = (str3.getBytes("UTF-8")).length; i != j; j = (str3.getBytes("UTF-8")).length) {
        i = j;
        str3 = i + " " + str1 + "=" + str2 + "\n";
      } 
      stringWriter.write(str3);
    } 
    byte[] arrayOfByte = stringWriter.toString().getBytes("UTF-8");
    a1.b(arrayOfByte.length);
    a(a1);
    write(arrayOfByte);
    a();
  }
  
  private String a(String paramString) {
    int i = paramString.length();
    StringBuilder stringBuilder = new StringBuilder(i);
    for (byte b = 0; b < i; b++) {
      char c1 = (char)(paramString.charAt(b) & 0x7F);
      if (a(c1)) {
        stringBuilder.append("_");
      } else {
        stringBuilder.append(c1);
      } 
    } 
    return stringBuilder.toString();
  }
  
  private boolean a(char paramChar) {
    return (paramChar == '\000' || paramChar == '/' || paramChar == '\\');
  }
  
  private void f() throws IOException {
    Arrays.fill(this.l, (byte)0);
    a(this.l);
  }
  
  public void flush() throws IOException {
    this.w.flush();
  }
  
  public a a(File paramFile, String paramString) throws IOException {
    if (this.v)
      throw new IOException("Stream has already been finished"); 
    return new a(paramFile, paramString);
  }
  
  private void a(byte[] paramArrayOfbyte) throws IOException {
    if (paramArrayOfbyte.length != this.s)
      throw new IOException("record to write has length '" + paramArrayOfbyte.length + "' which is not the record size of '" + this.s + "'"); 
    this.w.write(paramArrayOfbyte);
    this.q++;
  }
  
  private void a(byte[] paramArrayOfbyte, int paramInt) throws IOException {
    if (paramInt + this.s > paramArrayOfbyte.length)
      throw new IOException("record has length '" + paramArrayOfbyte.length + "' with offset '" + paramInt + "' which is less than the record size of '" + this.s + "'"); 
    this.w.write(paramArrayOfbyte, paramInt, this.s);
    this.q++;
  }
  
  private void g() throws IOException {
    int i = this.q % this.r;
    if (i != 0)
      for (int j = i; j < this.r; j++)
        f();  
  }
  
  private void a(Map<String, String> paramMap, a parama) {
    a(paramMap, "size", parama.getSize(), 8589934591L);
    a(paramMap, "gid", parama.d(), 2097151L);
    a(paramMap, "mtime", parama.g().getTime() / 1000L, 8589934591L);
    a(paramMap, "uid", parama.c(), 2097151L);
    a(paramMap, "SCHILY.devmajor", parama.k(), 2097151L);
    a(paramMap, "SCHILY.devminor", parama.l(), 2097151L);
    a("mode", parama.j(), 2097151L);
  }
  
  private void a(Map<String, String> paramMap, String paramString, long paramLong1, long paramLong2) {
    if (paramLong1 < 0L || paramLong1 > paramLong2)
      paramMap.put(paramString, String.valueOf(paramLong1)); 
  }
  
  private void a(a parama) {
    a("entry size", parama.getSize(), 8589934591L);
    a("group id", parama.d(), 2097151L);
    a("last modification time", parama.g().getTime() / 1000L, 8589934591L);
    a("user id", parama.c(), 2097151L);
    a("mode", parama.j(), 2097151L);
    a("major device number", parama.k(), 2097151L);
    a("minor device number", parama.l(), 2097151L);
  }
  
  private void a(String paramString, long paramLong1, long paramLong2) {
    if (paramLong1 < 0L || paramLong1 > paramLong2)
      throw new RuntimeException(paramString + " '" + paramLong1 + "' is too big ( > " + paramLong2 + " )"); 
  }
  
  private boolean a(a parama, String paramString1, Map<String, String> paramMap, String paramString2, byte paramByte, String paramString3) throws IOException {
    ByteBuffer byteBuffer = this.x.b(paramString1);
    int i = byteBuffer.limit() - byteBuffer.position();
    if (i >= 100) {
      if (this.o == 3) {
        paramMap.put(paramString2, paramString1);
        return true;
      } 
      if (this.o == 2) {
        a a1 = new a("././@LongLink", paramByte);
        a1.b((i + 1));
        a(parama, a1);
        a(a1);
        write(byteBuffer.array(), byteBuffer.arrayOffset(), i);
        write(0);
        a();
      } else if (this.o != 1) {
        throw new RuntimeException(paramString3 + " '" + paramString1 + "' is too long ( > " + 'd' + " bytes)");
      } 
    } 
    return false;
  }
  
  private void a(a parama1, a parama2) {
    Date date = parama1.g();
    long l = date.getTime() / 1000L;
    if (l < 0L || l > 8589934591L)
      date = new Date(0L); 
    parama2.a(date);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/g/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */