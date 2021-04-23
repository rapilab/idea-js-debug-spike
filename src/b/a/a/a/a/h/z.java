package b.a.a.a.a.h;

import b.a.a.a.a.c;
import b.a.a.a.d.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public class z extends c {
  private final D a;
  
  private final boolean b;
  
  private final InputStream c;
  
  private final Inflater d = new Inflater(true);
  
  private final ByteBuffer e = ByteBuffer.allocate(512);
  
  private b f = null;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private ByteArrayInputStream i = null;
  
  private boolean j = false;
  
  private static final int k = 30;
  
  private static final int l = 46;
  
  private static final long m = 4294967296L;
  
  private final byte[] n = new byte[30];
  
  private final byte[] o = new byte[1024];
  
  private final byte[] p = new byte[2];
  
  private final byte[] q = new byte[4];
  
  private final byte[] r = new byte[16];
  
  private int s = 0;
  
  private static final byte[] t = J.b.a();
  
  private static final byte[] u = J.a.a();
  
  private static final byte[] v = J.c.a();
  
  public z(InputStream paramInputStream) {
    this(paramInputStream, "UTF8");
  }
  
  public z(InputStream paramInputStream, String paramString) {
    this(paramInputStream, paramString, true);
  }
  
  public z(InputStream paramInputStream, String paramString, boolean paramBoolean) {
    this(paramInputStream, paramString, paramBoolean, false);
  }
  
  public z(InputStream paramInputStream, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    this.a = E.a(paramString);
    this.b = paramBoolean1;
    this.c = new PushbackInputStream(paramInputStream, this.e.capacity());
    this.j = paramBoolean2;
    this.e.limit(0);
  }
  
  public y e() throws IOException {
    boolean bool = true;
    if (this.g || this.h)
      return null; 
    if (this.f != null) {
      d();
      bool = false;
    } 
    try {
      if (bool) {
        a(this.n);
      } else {
        b(this.n);
      } 
    } catch (EOFException eOFException) {
      return null;
    } 
    J j1 = new J(this.n);
    if (j1.equals(J.a) || j1.equals(J.f)) {
      this.h = true;
      k();
    } 
    if (!j1.equals(J.b))
      return null; 
    byte b1 = 4;
    this.f = new b();
    int i = L.a(this.n, b1);
    b1 += 2;
    b.a(this.f).c(i >> 8 & 0xF);
    i i1 = i.a(this.n, b1);
    boolean bool1 = i1.a();
    D d = bool1 ? E.b : this.a;
    b.a(this.f, i1.b());
    b.a(this.f).a(i1);
    b1 += 2;
    b.a(this.f).setMethod(L.a(this.n, b1));
    b1 += 2;
    long l = M.c(J.a(this.n, b1));
    b.a(this.f).setTime(l);
    b1 += 4;
    J j2 = null;
    J j3 = null;
    if (!b.b(this.f)) {
      b.a(this.f).setCrc(J.a(this.n, b1));
      b1 += 4;
      j3 = new J(this.n, b1);
      b1 += 4;
      j2 = new J(this.n, b1);
      b1 += 4;
    } else {
      b1 += 12;
    } 
    int j = L.a(this.n, b1);
    b1 += 2;
    int k = L.a(this.n, b1);
    b1 += 2;
    byte[] arrayOfByte1 = new byte[j];
    b(arrayOfByte1);
    b.a(this.f).a(d.a(arrayOfByte1), arrayOfByte1);
    byte[] arrayOfByte2 = new byte[k];
    b(arrayOfByte2);
    b.a(this.f).setExtra(arrayOfByte2);
    if (!bool1 && this.b)
      M.a(b.a(this.f), arrayOfByte1, null); 
    a(j2, j3);
    if (b.a(this.f).getCompressedSize() != -1L)
      if (b.a(this.f).getMethod() == K.b.b()) {
        b.a(this.f, (InputStream)new r(new a(this, this.c, b.a(this.f).getCompressedSize())));
      } else if (b.a(this.f).getMethod() == K.g.b()) {
        b.a(this.f, new f(b.a(this.f).p().e(), b.a(this.f).p().f(), new a(this, this.c, b.a(this.f).getCompressedSize())));
      }  
    this.s++;
    return b.a(this.f);
  }
  
  private void a(byte[] paramArrayOfbyte) throws IOException {
    b(paramArrayOfbyte);
    J j = new J(paramArrayOfbyte);
    if (j.equals(J.c))
      throw new s(s.a.d); 
    if (j.equals(J.e)) {
      byte[] arrayOfByte = new byte[4];
      b(arrayOfByte);
      System.arraycopy(paramArrayOfbyte, 4, paramArrayOfbyte, 0, 26);
      System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 26, 4);
    } 
  }
  
  private void a(J paramJ1, J paramJ2) {
    v v = (v)b.a(this.f).b(v.a);
    b.b(this.f, (v != null));
    if (!b.b(this.f))
      if (v != null && (paramJ2.equals(J.d) || paramJ1.equals(J.d))) {
        b.a(this.f).setCompressedSize(v.g().b());
        b.a(this.f).setSize(v.b().b());
      } else {
        b.a(this.f).setCompressedSize(paramJ2.b());
        b.a(this.f).setSize(paramJ1.b());
      }  
  }
  
  public b.a.a.a.a.a a() throws IOException {
    return e();
  }
  
  public boolean a(b.a.a.a.a.a parama) {
    if (parama instanceof y) {
      y y = (y)parama;
      return (M.a(y) && a(y));
    } 
    return false;
  }
  
  public int read(byte[] buffer, int offset, int length) throws IOException {
    int i;
    if (this.g)
      throw new IOException("The stream is closed"); 
    if (this.f == null)
      return -1; 
    if (offset > buffer.length || length < 0 || offset < 0 || buffer.length - offset < length)
      throw new ArrayIndexOutOfBoundsException(); 
    M.b(b.a(this.f));
    if (!a(b.a(this.f)))
      throw new s(s.a.c, b.a(this.f)); 
    if (b.a(this.f).getMethod() == 0) {
      i = a(buffer, offset, length);
    } else if (b.a(this.f).getMethod() == 8) {
      i = b(buffer, offset, length);
    } else if (b.a(this.f).getMethod() == K.b.b() || b.a(this.f).getMethod() == K.g.b()) {
      i = b.c(this.f).read(buffer, offset, length);
    } else {
      throw new s(K.a(b.a(this.f).getMethod()), b.a(this.f));
    } 
    if (i >= 0)
      b.d(this.f).update(buffer, offset, i); 
    return i;
  }
  
  private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (b.b(this.f)) {
      if (this.i == null)
        j(); 
      return this.i.read(paramArrayOfbyte, paramInt1, paramInt2);
    } 
    long l = b.a(this.f).getSize();
    if (b.e(this.f) >= l)
      return -1; 
    if (this.e.position() >= this.e.limit()) {
      this.e.position(0);
      int j = this.c.read(this.e.array());
      if (j == -1)
        return -1; 
      this.e.limit(j);
      a(j);
      b.a(this.f, j);
    } 
    int i = Math.min(this.e.remaining(), paramInt2);
    if (l - b.e(this.f) < i)
      i = (int)(l - b.e(this.f)); 
    this.e.get(paramArrayOfbyte, paramInt1, i);
    b.b(this.f, i);
    return i;
  }
  
  private int b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = c(paramArrayOfbyte, paramInt1, paramInt2);
    if (i <= 0) {
      if (this.d.finished())
        return -1; 
      if (this.d.needsDictionary())
        throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress."); 
      if (i == -1)
        throw new IOException("Truncated ZIP file"); 
    } 
    return i;
  }
  
  private int c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = 0;
    do {
      if (this.d.needsInput()) {
        int j = h();
        if (j > 0) {
          b.a(this.f, this.e.limit());
        } else {
          if (j == -1)
            return -1; 
          break;
        } 
      } 
      try {
        i = this.d.inflate(paramArrayOfbyte, paramInt1, paramInt2);
      } catch (DataFormatException dataFormatException) {
        throw (IOException)(new ZipException(dataFormatException.getMessage())).initCause(dataFormatException);
      } 
    } while (i == 0 && this.d.needsInput());
    return i;
  }
  
  public void close() throws IOException {
    if (!this.g) {
      this.g = true;
      this.c.close();
      this.d.end();
    } 
  }
  
  public long skip(long value) throws IOException {
    if (value >= 0L) {
      long l;
      for (l = 0L; l < value; l += i) {
        long l1 = value - l;
        int i = read(this.o, 0, (int)((this.o.length > l1) ? l1 : this.o.length));
        if (i == -1)
          return l; 
      } 
      return l;
    } 
    throw new IllegalArgumentException();
  }
  
  public static boolean b(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < A.j.length) ? false : ((a(paramArrayOfbyte, A.j) || a(paramArrayOfbyte, A.m) || a(paramArrayOfbyte, A.k) || a(paramArrayOfbyte, J.e.a())));
  }
  
  private static boolean a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    for (byte b1 = 0; b1 < paramArrayOfbyte2.length; b1++) {
      if (paramArrayOfbyte1[b1] != paramArrayOfbyte2[b1])
        return false; 
    } 
    return true;
  }
  
  private void d() throws IOException {
    if (this.g)
      throw new IOException("The stream is closed"); 
    if (this.f == null)
      return; 
    if (b.f(this.f) <= b.a(this.f).getCompressedSize() && !b.b(this.f)) {
      f();
    } else {
      skip(Long.MAX_VALUE);
      long l = (b.a(this.f).getMethod() == 8) ? g() : b.e(this.f);
      int i = (int)(b.f(this.f) - l);
      if (i > 0)
        d(this.e.array(), this.e.limit() - i, i); 
    } 
    if (this.i == null && b.b(this.f))
      i(); 
    this.d.reset();
    this.e.clear().flip();
    this.f = null;
    this.i = null;
  }
  
  private void f() throws IOException {
    for (long l = b.a(this.f).getCompressedSize() - b.f(this.f); l > 0L; l -= l1) {
      long l1 = this.c.read(this.e.array(), 0, (int)Math.min(this.e.capacity(), l));
      if (l1 < 0L)
        throw new EOFException("Truncated ZIP entry: " + b.a(this.f).getName()); 
      a(l1);
    } 
  }
  
  private long g() {
    long l = this.d.getBytesRead();
    if (b.f(this.f) >= 4294967296L)
      while (l + 4294967296L <= b.f(this.f))
        l += 4294967296L;  
    return l;
  }
  
  private int h() throws IOException {
    if (this.g)
      throw new IOException("The stream is closed"); 
    int i = this.c.read(this.e.array());
    if (i > 0) {
      this.e.limit(i);
      a(this.e.limit());
      this.d.setInput(this.e.array(), 0, this.e.limit());
    } 
    return i;
  }
  
  private void b(byte[] paramArrayOfbyte) throws IOException {
    int i = i.a(this.c, paramArrayOfbyte);
    a(i);
    if (i < paramArrayOfbyte.length)
      throw new EOFException(); 
  }
  
  private void i() throws IOException {
    b(this.q);
    J j1 = new J(this.q);
    if (J.c.equals(j1)) {
      b(this.q);
      j1 = new J(this.q);
    } 
    b.a(this.f).setCrc(j1.b());
    b(this.r);
    J j2 = new J(this.r, 8);
    if (j2.equals(J.a) || j2.equals(J.b)) {
      d(this.r, 8, 8);
      b.a(this.f).setCompressedSize(J.a(this.r));
      b.a(this.f).setSize(J.a(this.r, 4));
    } else {
      b.a(this.f).setCompressedSize(C.a(this.r));
      b.a(this.f).setSize(C.a(this.r, 8));
    } 
  }
  
  private boolean a(y paramy) {
    return (!paramy.p().b() || (this.j && paramy.getMethod() == 0) || paramy.getMethod() == 8);
  }
  
  private void j() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    boolean bool = false;
    byte b1 = b.g(this.f) ? 20 : 12;
    while (!bool) {
      int j = this.c.read(this.e.array(), i, 512 - i);
      if (j <= 0)
        throw new IOException("Truncated ZIP file"); 
      if (j + i < 4) {
        i += j;
        continue;
      } 
      bool = a(byteArrayOutputStream, i, j, b1);
      if (!bool)
        i = b(byteArrayOutputStream, i, j, b1); 
    } 
    byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    this.i = new ByteArrayInputStream(arrayOfByte);
  }
  
  private boolean a(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt1, int paramInt2, int paramInt3) throws IOException {
    boolean bool = false;
    int i = 0;
    for (byte b1 = 0; !bool && b1 < paramInt2 - 4; b1++) {
      if (this.e.array()[b1] == t[0] && this.e.array()[b1 + 1] == t[1]) {
        if ((this.e.array()[b1 + 2] == t[2] && this.e.array()[b1 + 3] == t[3]) || (this.e.array()[b1] == u[2] && this.e.array()[b1 + 3] == u[3])) {
          i = paramInt1 + paramInt2 - b1 - paramInt3;
          bool = true;
        } else if (this.e.array()[b1 + 2] == v[2] && this.e.array()[b1 + 3] == v[3]) {
          i = paramInt1 + paramInt2 - b1;
          bool = true;
        } 
        if (bool) {
          d(this.e.array(), paramInt1 + paramInt2 - i, i);
          paramByteArrayOutputStream.write(this.e.array(), 0, b1);
          i();
        } 
      } 
    } 
    return bool;
  }
  
  private int b(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1 + paramInt2 - paramInt3 - 3;
    if (i > 0) {
      paramByteArrayOutputStream.write(this.e.array(), 0, i);
      System.arraycopy(this.e.array(), i, this.e.array(), 0, paramInt3 + 3);
      paramInt1 = paramInt3 + 3;
    } else {
      paramInt1 += paramInt2;
    } 
    return paramInt1;
  }
  
  private void d(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    ((PushbackInputStream)this.c).unread(paramArrayOfbyte, paramInt1, paramInt2);
    b(paramInt2);
  }
  
  private void k() throws IOException {
    c((this.s * 46 - 30));
    l();
    c(16L);
    b(this.p);
    c(L.a(this.p));
  }
  
  private void l() throws IOException {
    int i = -1;
    for (boolean bool = false; bool || (i = m()) > -1; bool = b(i)) {
      bool = false;
      if (!b(i))
        continue; 
      i = m();
      if (i != A.m[1]) {
        if (i == -1)
          break; 
        bool = b(i);
        continue;
      } 
      i = m();
      if (i != A.m[2]) {
        if (i == -1)
          break; 
        bool = b(i);
        continue;
      } 
      i = m();
      if (i == -1 || i == A.m[3])
        break; 
    } 
  }
  
  private void c(long paramLong) throws IOException {
    if (paramLong >= 0L) {
      for (long l = 0L; l < paramLong; l += i) {
        long l1 = paramLong - l;
        int i = this.c.read(this.o, 0, (int)((this.o.length > l1) ? l1 : this.o.length));
        if (i == -1)
          return; 
        a(i);
      } 
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  private int m() throws IOException {
    int i = this.c.read();
    if (i != -1)
      a(1); 
    return i;
  }
  
  private boolean b(int paramInt) {
    return (paramInt == A.m[0]);
  }
  
  private class a extends InputStream {
    private final InputStream b;
    
    private final long c;
    
    private long d = 0L;
    
    public a(z this$0, InputStream param1InputStream, long param1Long) {
      this.c = param1Long;
      this.b = param1InputStream;
    }
    
    public int read() throws IOException {
      if (this.c >= 0L && this.d >= this.c)
        return -1; 
      int i = this.b.read();
      this.d++;
      z.a(this.a, 1);
      z.b.h(z.a(this.a));
      return i;
    }
    
    public int read(byte[] b) throws IOException {
      return read(b, 0, b.length);
    }
    
    public int read(byte[] b, int off, int len) throws IOException {
      if (this.c >= 0L && this.d >= this.c)
        return -1; 
      long l = (this.c >= 0L) ? Math.min(len, this.c - this.d) : len;
      int i = this.b.read(b, off, (int)l);
      if (i == -1)
        return -1; 
      this.d += i;
      z.b(this.a, i);
      z.b.a(z.a(this.a), i);
      return i;
    }
    
    public long skip(long n) throws IOException {
      long l1 = (this.c >= 0L) ? Math.min(n, this.c - this.d) : n;
      long l2 = this.b.skip(l1);
      this.d += l2;
      return l2;
    }
    
    public int available() throws IOException {
      return (this.c >= 0L && this.d >= this.c) ? 0 : this.b.available();
    }
  }
  
  private static final class b {
    private final y a = new y();
    
    private boolean b;
    
    private boolean c;
    
    private long d;
    
    private long e;
    
    private final CRC32 f = new CRC32();
    
    private InputStream g;
    
    private b() {}
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/z.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */