package b.a.a.a.a.c;

import b.a.a.a.a.a;
import b.a.a.a.a.d;
import b.a.a.a.a.h.D;
import b.a.a.a.a.h.E;
import b.a.a.a.d.a;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class c extends d implements d {
  private a H;
  
  private boolean I = false;
  
  private boolean J;
  
  private final short K;
  
  private final HashMap<String, a> L = new HashMap<String, a>();
  
  private long M = 0L;
  
  private long N;
  
  private final OutputStream O;
  
  private final int P;
  
  private long Q = 1L;
  
  private final D R;
  
  public c(OutputStream paramOutputStream, short paramShort) {
    this(paramOutputStream, paramShort, 512, "US-ASCII");
  }
  
  public c(OutputStream paramOutputStream, short paramShort, int paramInt) {
    this(paramOutputStream, paramShort, paramInt, "US-ASCII");
  }
  
  public c(OutputStream paramOutputStream, short paramShort, int paramInt, String paramString) {
    this.O = paramOutputStream;
    switch (paramShort) {
      case 1:
      case 2:
      case 4:
      case 8:
        break;
      default:
        throw new IllegalArgumentException("Unknown format: " + paramShort);
    } 
    this.K = paramShort;
    this.P = paramInt;
    this.R = E.a(paramString);
  }
  
  public c(OutputStream paramOutputStream) {
    this(paramOutputStream, (short)1);
  }
  
  public c(OutputStream paramOutputStream, String paramString) {
    this(paramOutputStream, (short)1, 512, paramString);
  }
  
  private void e() throws IOException {
    if (this.I)
      throw new IOException("Stream closed"); 
  }
  
  public void a(a parama) throws IOException {
    if (this.J)
      throw new IOException("Stream has already been finished"); 
    a a1 = (a)parama;
    e();
    if (this.H != null)
      a(); 
    if (a1.r() == -1L)
      a1.m(System.currentTimeMillis() / 1000L); 
    short s = a1.f();
    if (s != this.K)
      throw new IOException("Header format: " + s + " does not match existing format: " + this.K); 
    if (this.L.put(a1.getName(), a1) != null)
      throw new IOException("duplicate entry: " + a1.getName()); 
    a(a1);
    this.H = a1;
    this.N = 0L;
  }
  
  private void a(a parama) throws IOException {
    boolean bool;
    switch (parama.f()) {
      case 1:
        this.O.write(a.a("070701"));
        a(6);
        b(parama);
        return;
      case 2:
        this.O.write(a.a("070702"));
        a(6);
        b(parama);
        return;
      case 4:
        this.O.write(a.a("070707"));
        a(6);
        c(parama);
        return;
      case 8:
        bool = true;
        a(29127L, 2, bool);
        a(parama, bool);
        return;
    } 
    throw new IOException("unknown format " + parama.f());
  }
  
  private void b(a parama) throws IOException {
    long l1 = parama.l();
    long l2 = parama.e();
    l1 = l2 = 0L;
    l1 = this.Q & 0xFFFFFFFFFFFFFFFFL;
    l2 = this.Q++ >> 32L & 0xFFFFFFFFFFFFFFFFL;
    this.Q = Math.max(this.Q, l1 + 4294967296L * l2) + 1L;
    a(l1, 8, 16);
    a(parama.m(), 8, 16);
    a(parama.s(), 8, 16);
    a(parama.g(), 8, 16);
    a(parama.n(), 8, 16);
    a(parama.r(), 8, 16);
    a(parama.getSize(), 8, 16);
    a(parama.d(), 8, 16);
    a(l2, 8, 16);
    a(parama.p(), 8, 16);
    a(parama.q(), 8, 16);
    a((parama.getName().length() + 1), 8, 16);
    a(parama.b(), 8, 16);
    a(parama.getName());
    b(parama.j());
  }
  
  private void c(a parama) throws IOException {
    long l1 = parama.l();
    long l2 = parama.c();
    l1 = l2 = 0L;
    l1 = this.Q & 0x3FFFFL;
    l2 = this.Q++ >> 18L & 0x3FFFFL;
    this.Q = Math.max(this.Q, l1 + 262144L * l2) + 1L;
    a(l2, 6, 8);
    a(l1, 6, 8);
    a(parama.m(), 6, 8);
    a(parama.s(), 6, 8);
    a(parama.g(), 6, 8);
    a(parama.n(), 6, 8);
    a(parama.o(), 6, 8);
    a(parama.r(), 11, 8);
    a((parama.getName().length() + 1), 6, 8);
    a(parama.getSize(), 11, 8);
    a(parama.getName());
  }
  
  private void a(a parama, boolean paramBoolean) throws IOException {
    long l1 = parama.l();
    long l2 = parama.c();
    l1 = l2 = 0L;
    l1 = this.Q & 0xFFFFL;
    l2 = this.Q++ >> 16L & 0xFFFFL;
    this.Q = Math.max(this.Q, l1 + 65536L * l2) + 1L;
    a(l2, 2, paramBoolean);
    a(l1, 2, paramBoolean);
    a(parama.m(), 2, paramBoolean);
    a(parama.s(), 2, paramBoolean);
    a(parama.g(), 2, paramBoolean);
    a(parama.n(), 2, paramBoolean);
    a(parama.o(), 2, paramBoolean);
    a(parama.r(), 4, paramBoolean);
    a((parama.getName().length() + 1), 2, paramBoolean);
    a(parama.getSize(), 4, paramBoolean);
    a(parama.getName());
    b(parama.j());
  }
  
  public void a() throws IOException {
    if (this.J)
      throw new IOException("Stream has already been finished"); 
    e();
    if (this.H == null)
      throw new IOException("Trying to close non-existent entry"); 
    if (this.H.getSize() != this.N)
      throw new IOException("invalid entry size (expected " + this.H.getSize() + " but got " + this.N + " bytes)"); 
    b(this.H.k());
    if (this.H.f() == 2 && this.M != this.H.b())
      throw new IOException("CRC Error"); 
    this.H = null;
    this.M = 0L;
    this.N = 0L;
  }
  
  public void write(byte[] b, int off, int len) throws IOException {
    e();
    if (off < 0 || len < 0 || off > b.length - len)
      throw new IndexOutOfBoundsException(); 
    if (len == 0)
      return; 
    if (this.H == null)
      throw new IOException("no current CPIO entry"); 
    if (this.N + len > this.H.getSize())
      throw new IOException("attempt to write past end of STORED entry"); 
    this.O.write(b, off, len);
    this.N += len;
    if (this.H.f() == 2)
      for (byte b1 = 0; b1 < len; b1++)
        this.M += (b[b1] & 0xFF);  
    a(len);
  }
  
  public void b() throws IOException {
    e();
    if (this.J)
      throw new IOException("This archive has already been finished"); 
    if (this.H != null)
      throw new IOException("This archive contains unclosed entries."); 
    this.H = new a(this.K);
    this.H.a("TRAILER!!!");
    this.H.i(1L);
    a(this.H);
    a();
    int i = (int)(d() % this.P);
    if (i != 0)
      b(this.P - i); 
    this.J = true;
  }
  
  public void close() throws IOException {
    if (!this.J)
      b(); 
    if (!this.I) {
      this.O.close();
      this.I = true;
    } 
  }
  
  private void b(int paramInt) throws IOException {
    if (paramInt > 0) {
      byte[] arrayOfByte = new byte[paramInt];
      this.O.write(arrayOfByte);
      a(paramInt);
    } 
  }
  
  private void a(long paramLong, int paramInt, boolean paramBoolean) throws IOException {
    byte[] arrayOfByte = e.a(paramLong, paramInt, paramBoolean);
    this.O.write(arrayOfByte);
    a(arrayOfByte.length);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2) throws IOException {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (paramInt2 == 16) {
      stringBuilder.append(Long.toHexString(paramLong));
    } else if (paramInt2 == 8) {
      stringBuilder.append(Long.toOctalString(paramLong));
    } else {
      stringBuilder.append(Long.toString(paramLong));
    } 
    if (stringBuilder.length() <= paramInt1) {
      long l = (paramInt1 - stringBuilder.length());
      for (byte b = 0; b < l; b++)
        stringBuilder.insert(0, "0"); 
      str = stringBuilder.toString();
    } else {
      str = stringBuilder.substring(stringBuilder.length() - paramInt1);
    } 
    byte[] arrayOfByte = a.a(str);
    this.O.write(arrayOfByte);
    a(arrayOfByte.length);
  }
  
  private void a(String paramString) throws IOException {
    ByteBuffer byteBuffer = this.R.b(paramString);
    int i = byteBuffer.limit() - byteBuffer.position();
    this.O.write(byteBuffer.array(), byteBuffer.arrayOffset(), i);
    this.O.write(0);
    a(i + 1);
  }
  
  public a a(File paramFile, String paramString) throws IOException {
    if (this.J)
      throw new IOException("Stream has already been finished"); 
    return new a(paramFile, paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/c/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */