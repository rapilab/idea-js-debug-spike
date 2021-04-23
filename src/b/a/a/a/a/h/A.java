package b.a.a.a.a.h;

import b.a.a.a.a.d;
import b.a.a.a.d.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;

public class A extends d {
  static final int b = 512;
  
  protected boolean c = false;
  
  private static final int p = 8192;
  
  public static final int d = 8;
  
  public static final int e = -1;
  
  public static final int f = 0;
  
  static final String g = "UTF8";
  
  public static final int h = 2048;
  
  private static final byte[] q = new byte[0];
  
  private a r;
  
  private String s = "";
  
  private int t = -1;
  
  private boolean u = false;
  
  private int v = 8;
  
  private final List<y> w = new LinkedList<y>();
  
  private final CRC32 x = new CRC32();
  
  private long y = 0L;
  
  private long z = 0L;
  
  private long A = 0L;
  
  private static final byte[] B = new byte[] { 0, 0 };
  
  private static final byte[] C = new byte[] { 0, 0, 0, 0 };
  
  private final Map<y, Long> D = new HashMap<y, Long>();
  
  private String E = "UTF8";
  
  private D F = E.a("UTF8");
  
  protected final Deflater i = new Deflater(this.t, true);
  
  private final byte[] G = new byte[512];
  
  private final RandomAccessFile H;
  
  private final OutputStream I;
  
  private boolean J = true;
  
  private boolean K = false;
  
  private b L = b.b;
  
  private boolean M = false;
  
  private w N = w.c;
  
  static final byte[] j = J.b.a();
  
  static final byte[] k = J.c.a();
  
  static final byte[] l = J.a.a();
  
  static final byte[] m = J.a(101010256L);
  
  static final byte[] n = J.a(101075792L);
  
  static final byte[] o = J.a(117853008L);
  
  private static final byte[] O = J.a(1L);
  
  public A(OutputStream paramOutputStream) {
    this.I = paramOutputStream;
    this.H = null;
  }
  
  public A(File paramFile) throws IOException {
    FileOutputStream fileOutputStream = null;
    RandomAccessFile randomAccessFile = null;
    try {
      randomAccessFile = new RandomAccessFile(paramFile, "rw");
      randomAccessFile.setLength(0L);
    } catch (IOException iOException) {
      i.a(randomAccessFile);
      randomAccessFile = null;
      fileOutputStream = new FileOutputStream(paramFile);
    } 
    this.I = fileOutputStream;
    this.H = randomAccessFile;
  }
  
  public boolean e() {
    return (this.H != null);
  }
  
  public void a(String paramString) {
    this.E = paramString;
    this.F = E.a(paramString);
    if (this.J && !E.b(paramString))
      this.J = false; 
  }
  
  public String f() {
    return this.E;
  }
  
  public void a(boolean paramBoolean) {
    this.J = (paramBoolean && E.b(this.E));
  }
  
  public void a(b paramb) {
    this.L = paramb;
  }
  
  public void b(boolean paramBoolean) {
    this.K = paramBoolean;
  }
  
  public void a(w paramw) {
    this.N = paramw;
  }
  
  public void b() throws IOException {
    if (this.c)
      throw new IOException("This archive has already been finished"); 
    if (this.r != null)
      throw new IOException("This archive contains unclosed entries."); 
    this.z = this.y;
    for (y y : this.w)
      c(y); 
    this.A = this.y - this.z;
    i();
    h();
    this.D.clear();
    this.w.clear();
    this.i.end();
    this.c = true;
  }
  
  public void a() throws IOException {
    if (this.c)
      throw new IOException("Stream has already been finished"); 
    if (this.r == null)
      throw new IOException("No current entry to close"); 
    if (!a.a(this.r))
      write(q, 0, 0); 
    k();
    w w1 = g(a.b(this.r));
    long l1 = this.y - a.c(this.r);
    long l2 = this.x.getValue();
    this.x.reset();
    boolean bool = a(l1, l2, w1);
    if (this.H != null)
      c(bool); 
    b(a.b(this.r));
    this.r = null;
  }
  
  private void k() throws IOException {
    if (a.b(this.r).getMethod() == 8) {
      this.i.finish();
      while (!this.i.finished())
        g(); 
    } 
  }
  
  private boolean a(long paramLong1, long paramLong2, w paramw) throws ZipException {
    if (a.b(this.r).getMethod() == 8) {
      a.b(this.r).setSize(a.d(this.r));
      a.b(this.r).setCompressedSize(paramLong1);
      a.b(this.r).setCrc(paramLong2);
      this.i.reset();
    } else if (this.H == null) {
      if (a.b(this.r).getCrc() != paramLong2)
        throw new ZipException("bad CRC checksum for entry " + a.b(this.r).getName() + ": " + Long.toHexString(a.b(this.r).getCrc()) + " instead of " + Long.toHexString(paramLong2)); 
      if (a.b(this.r).getSize() != paramLong1)
        throw new ZipException("bad size for entry " + a.b(this.r).getName() + ": " + a.b(this.r).getSize() + " instead of " + paramLong1); 
    } else {
      a.b(this.r).setSize(paramLong1);
      a.b(this.r).setCompressedSize(paramLong1);
      a.b(this.r).setCrc(paramLong2);
    } 
    boolean bool = (paramw == w.a || a.b(this.r).getSize() >= 4294967295L || a.b(this.r).getCompressedSize() >= 4294967295L) ? true : false;
    if (bool && paramw == w.b)
      throw new x(x.a(a.b(this.r))); 
    return bool;
  }
  
  private void c(boolean paramBoolean) throws IOException {
    long l = this.H.getFilePointer();
    this.H.seek(a.e(this.r));
    a(J.a(a.b(this.r).getCrc()));
    if (!f(a.b(this.r)) || !paramBoolean) {
      a(J.a(a.b(this.r).getCompressedSize()));
      a(J.a(a.b(this.r).getSize()));
    } else {
      a(J.d.a());
      a(J.d.a());
    } 
    if (f(a.b(this.r))) {
      this.H.seek(a.e(this.r) + 12L + 4L + i(a.b(this.r)).limit() + 4L);
      a(C.a(a.b(this.r).getSize()));
      a(C.a(a.b(this.r).getCompressedSize()));
      if (!paramBoolean) {
        this.H.seek(a.e(this.r) - 10L);
        a(L.a(10));
        a.b(this.r).a(v.a);
        a.b(this.r).l();
        if (a.f(this.r))
          this.M = false; 
      } 
    } 
    this.H.seek(l);
  }
  
  public void a(b.a.a.a.a.a parama) throws IOException {
    if (this.c)
      throw new IOException("Stream has already been finished"); 
    if (this.r != null)
      a(); 
    this.r = new a((y)parama);
    this.w.add(a.b(this.r));
    d(a.b(this.r));
    w w1 = g(a.b(this.r));
    b(w1);
    if (a(a.b(this.r), w1)) {
      v v = e(a.b(this.r));
      C c = C.a;
      if (a.b(this.r).getMethod() == 0 && a.b(this.r).getSize() != -1L)
        c = new C(a.b(this.r).getSize()); 
      v.a(c);
      v.b(c);
      a.b(this.r).l();
    } 
    if (a.b(this.r).getMethod() == 8 && this.u) {
      this.i.setLevel(this.t);
      this.u = false;
    } 
    a(a.b(this.r));
  }
  
  private void d(y paramy) {
    if (paramy.getMethod() == -1)
      paramy.setMethod(this.v); 
    if (paramy.getTime() == -1L)
      paramy.setTime(System.currentTimeMillis()); 
  }
  
  private void b(w paramw) throws ZipException {
    if (a.b(this.r).getMethod() == 0 && this.H == null) {
      if (a.b(this.r).getSize() == -1L)
        throw new ZipException("uncompressed size is required for STORED method when not writing to a file"); 
      if (a.b(this.r).getCrc() == -1L)
        throw new ZipException("crc checksum is required for STORED method when not writing to a file"); 
      a.b(this.r).setCompressedSize(a.b(this.r).getSize());
    } 
    if ((a.b(this.r).getSize() >= 4294967295L || a.b(this.r).getCompressedSize() >= 4294967295L) && paramw == w.b)
      throw new x(x.a(a.b(this.r))); 
  }
  
  private boolean a(y paramy, w paramw) {
    return (paramw == w.a || paramy.getSize() >= 4294967295L || paramy.getCompressedSize() >= 4294967295L || (paramy.getSize() == -1L && this.H != null && paramw != w.b));
  }
  
  public void b(String paramString) {
    this.s = paramString;
  }
  
  public void b(int paramInt) {
    if (paramInt < -1 || paramInt > 9)
      throw new IllegalArgumentException("Invalid compression level: " + paramInt); 
    this.u = (this.t != paramInt);
    this.t = paramInt;
  }
  
  public void c(int paramInt) {
    this.v = paramInt;
  }
  
  public boolean b(b.a.a.a.a.a parama) {
    if (parama instanceof y) {
      y y = (y)parama;
      return (y.getMethod() != K.g.b() && y.getMethod() != K.b.b() && M.a(y));
    } 
    return false;
  }
  
  public void write(byte[] arrayOfByte, int offset, int length) throws IOException {
    if (this.r == null)
      throw new IllegalStateException("No current entry"); 
    M.b(a.b(this.r));
    a.a(this.r, true);
    if (a.b(this.r).getMethod() == 8) {
      b(arrayOfByte, offset, length);
    } else {
      a(arrayOfByte, offset, length);
      this.y += length;
    } 
    this.x.update(arrayOfByte, offset, length);
    a(length);
  }
  
  private void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 > 0 && !this.i.finished()) {
      a.a(this.r, paramInt2);
      if (paramInt2 <= 8192) {
        this.i.setInput(paramArrayOfbyte, paramInt1, paramInt2);
        l();
      } else {
        int i = paramInt2 / 8192;
        int j;
        for (j = 0; j < i; j++) {
          this.i.setInput(paramArrayOfbyte, paramInt1 + j * 8192, 8192);
          l();
        } 
        j = i * 8192;
        if (j < paramInt2) {
          this.i.setInput(paramArrayOfbyte, paramInt1 + j, paramInt2 - j);
          l();
        } 
      } 
    } 
  }
  
  public void close() throws IOException {
    if (!this.c)
      b(); 
    j();
  }
  
  public void flush() throws IOException {
    if (this.I != null)
      this.I.flush(); 
  }
  
  protected final void g() throws IOException {
    int i = this.i.deflate(this.G, 0, this.G.length);
    if (i > 0) {
      a(this.G, 0, i);
      this.y += i;
    } 
  }
  
  protected void a(y paramy) throws IOException {
    boolean bool = this.F.a(paramy.getName());
    ByteBuffer byteBuffer = i(paramy);
    if (this.L != b.b)
      a(paramy, bool, byteBuffer); 
    this.D.put(paramy, Long.valueOf(this.y));
    a(j);
    this.y += 4L;
    int i = paramy.getMethod();
    a(i, (!bool && this.K), f(paramy));
    this.y += 4L;
    a(L.a(i));
    this.y += 2L;
    a(M.a(paramy.getTime()));
    this.y += 4L;
    a.b(this.r, this.y);
    if (i == 8 || this.H != null) {
      a(C);
      if (f(a.b(this.r))) {
        a(J.d.a());
        a(J.d.a());
      } else {
        a(C);
        a(C);
      } 
    } else {
      a(J.a(paramy.getCrc()));
      byte[] arrayOfByte1 = J.d.a();
      if (!f(paramy))
        arrayOfByte1 = J.a(paramy.getSize()); 
      a(arrayOfByte1);
      a(arrayOfByte1);
    } 
    this.y += 12L;
    a(L.a(byteBuffer.limit()));
    this.y += 2L;
    byte[] arrayOfByte = paramy.m();
    a(L.a(arrayOfByte.length));
    this.y += 2L;
    a(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    this.y += byteBuffer.limit();
    a(arrayOfByte);
    this.y += arrayOfByte.length;
    a.c(this.r, this.y);
  }
  
  private void a(y paramy, boolean paramBoolean, ByteBuffer paramByteBuffer) throws IOException {
    if (this.L == b.a || !paramBoolean)
      paramy.a(new n(paramy.getName(), paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.limit() - paramByteBuffer.position())); 
    String str = paramy.getComment();
    if (str != null && !"".equals(str)) {
      boolean bool = this.F.a(str);
      if (this.L == b.a || !bool) {
        ByteBuffer byteBuffer = h(paramy).b(str);
        paramy.a(new m(str, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
      } 
    } 
  }
  
  protected void b(y paramy) throws IOException {
    if (paramy.getMethod() != 8 || this.H != null)
      return; 
    a(k);
    a(J.a(paramy.getCrc()));
    byte b1 = 4;
    if (!f(paramy)) {
      a(J.a(paramy.getCompressedSize()));
      a(J.a(paramy.getSize()));
    } else {
      b1 = 8;
      a(C.a(paramy.getCompressedSize()));
      a(C.a(paramy.getSize()));
    } 
    this.y += (8 + 2 * b1);
  }
  
  protected void c(y paramy) throws IOException {
    a(l);
    this.y += 4L;
    long l = ((Long)this.D.get(paramy)).longValue();
    boolean bool = (f(paramy) || paramy.getCompressedSize() >= 4294967295L || paramy.getSize() >= 4294967295L || l >= 4294967295L) ? true : false;
    if (bool && this.N == w.b)
      throw new x("archive's size exceeds the limit of 4GByte."); 
    a(paramy, l, bool);
    a(L.a(paramy.h() << 8 | (!this.M ? 20 : 45)));
    this.y += 2L;
    int i = paramy.getMethod();
    boolean bool1 = this.F.a(paramy.getName());
    a(i, (!bool1 && this.K), bool);
    this.y += 4L;
    a(L.a(i));
    this.y += 2L;
    a(M.a(paramy.getTime()));
    this.y += 4L;
    a(J.a(paramy.getCrc()));
    if (paramy.getCompressedSize() >= 4294967295L || paramy.getSize() >= 4294967295L) {
      a(J.d.a());
      a(J.d.a());
    } else {
      a(J.a(paramy.getCompressedSize()));
      a(J.a(paramy.getSize()));
    } 
    this.y += 12L;
    ByteBuffer byteBuffer1 = i(paramy);
    a(L.a(byteBuffer1.limit()));
    this.y += 2L;
    byte[] arrayOfByte = paramy.n();
    a(L.a(arrayOfByte.length));
    this.y += 2L;
    String str = paramy.getComment();
    if (str == null)
      str = ""; 
    ByteBuffer byteBuffer2 = h(paramy).b(str);
    a(L.a(byteBuffer2.limit()));
    this.y += 2L;
    a(B);
    this.y += 2L;
    a(L.a(paramy.d()));
    this.y += 2L;
    a(J.a(paramy.e()));
    this.y += 4L;
    a(J.a(Math.min(l, 4294967295L)));
    this.y += 4L;
    a(byteBuffer1.array(), byteBuffer1.arrayOffset(), byteBuffer1.limit() - byteBuffer1.position());
    this.y += byteBuffer1.limit();
    a(arrayOfByte);
    this.y += arrayOfByte.length;
    a(byteBuffer2.array(), byteBuffer2.arrayOffset(), byteBuffer2.limit() - byteBuffer2.position());
    this.y += byteBuffer2.limit();
  }
  
  private void a(y paramy, long paramLong, boolean paramBoolean) {
    if (paramBoolean) {
      v v = e(paramy);
      if (paramy.getCompressedSize() >= 4294967295L || paramy.getSize() >= 4294967295L) {
        v.b(new C(paramy.getCompressedSize()));
        v.a(new C(paramy.getSize()));
      } else {
        v.b(null);
        v.a((C)null);
      } 
      if (paramLong >= 4294967295L)
        v.c(new C(paramLong)); 
      paramy.l();
    } 
  }
  
  protected void h() throws IOException {
    a(m);
    a(B);
    a(B);
    int i = this.w.size();
    if (i > 65535 && this.N == w.b)
      throw new x("archive contains more than 65535 entries."); 
    if (this.z > 4294967295L && this.N == w.b)
      throw new x("archive's size exceeds the limit of 4GByte."); 
    byte[] arrayOfByte = L.a(Math.min(i, 65535));
    a(arrayOfByte);
    a(arrayOfByte);
    a(J.a(Math.min(this.A, 4294967295L)));
    a(J.a(Math.min(this.z, 4294967295L)));
    ByteBuffer byteBuffer = this.F.b(this.s);
    a(L.a(byteBuffer.limit()));
    a(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
  }
  
  protected void i() throws IOException {
    if (this.N == w.b)
      return; 
    if (!this.M && (this.z >= 4294967295L || this.A >= 4294967295L || this.w.size() >= 65535))
      this.M = true; 
    if (!this.M)
      return; 
    long l = this.y;
    a(n);
    a(C.a(44L));
    a(L.a(45));
    a(L.a(45));
    a(C);
    a(C);
    byte[] arrayOfByte = C.a(this.w.size());
    a(arrayOfByte);
    a(arrayOfByte);
    a(C.a(this.A));
    a(C.a(this.z));
    a(o);
    a(C);
    a(C.a(l));
    a(O);
  }
  
  protected final void a(byte[] paramArrayOfbyte) throws IOException {
    a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  protected final void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (this.H != null) {
      this.H.write(paramArrayOfbyte, paramInt1, paramInt2);
    } else {
      this.I.write(paramArrayOfbyte, paramInt1, paramInt2);
    } 
  }
  
  private void l() throws IOException {
    while (!this.i.needsInput())
      g(); 
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    byte b1 = 10;
    i i = new i();
    i.a((this.J || paramBoolean1));
    if (paramInt == 8 && this.H == null) {
      b1 = 20;
      i.b(true);
    } 
    if (paramBoolean2)
      b1 = 45; 
    a(L.a(b1));
    a(i.g());
  }
  
  public b.a.a.a.a.a a(File paramFile, String paramString) throws IOException {
    if (this.c)
      throw new IOException("Stream has already been finished"); 
    return new y(paramFile, paramString);
  }
  
  private v e(y paramy) {
    if (this.r != null)
      a.b(this.r, !this.M); 
    this.M = true;
    v v = (v)paramy.b(v.a);
    if (v == null)
      v = new v(); 
    paramy.b(v);
    return v;
  }
  
  private boolean f(y paramy) {
    return (paramy.b(v.a) != null);
  }
  
  private w g(y paramy) {
    return (this.N != w.c || this.H != null || paramy.getMethod() != 8 || paramy.getSize() != -1L) ? this.N : w.b;
  }
  
  private D h(y paramy) {
    boolean bool = this.F.a(paramy.getName());
    return (!bool && this.K) ? E.b : this.F;
  }
  
  private ByteBuffer i(y paramy) throws IOException {
    return h(paramy).b(paramy.getName());
  }
  
  void j() throws IOException {
    if (this.H != null)
      this.H.close(); 
    if (this.I != null)
      this.I.close(); 
  }
  
  private static final class a {
    private final y a;
    
    private long b = 0L;
    
    private long c = 0L;
    
    private long d = 0L;
    
    private boolean e = false;
    
    private boolean f;
    
    private a(y param1y) {
      this.a = param1y;
    }
  }
  
  public static final class b {
    public static final b a = new b("always");
    
    public static final b b = new b("never");
    
    public static final b c = new b("not encodeable");
    
    private final String d;
    
    private b(String param1String) {
      this.d = param1String;
    }
    
    public String toString() {
      return this.d;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/A.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */