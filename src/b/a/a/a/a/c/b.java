package b.a.a.a.a.c;

import b.a.a.a.a.a;
import b.a.a.a.a.c;
import b.a.a.a.a.h.D;
import b.a.a.a.a.h.E;
import b.a.a.a.d.a;
import b.a.a.a.d.i;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class b extends c implements d {
  private boolean H = false;
  
  private a I;
  
  private long J = 0L;
  
  private boolean K = false;
  
  private final byte[] L = new byte[4096];
  
  private long M = 0L;
  
  private final InputStream N;
  
  private final byte[] O = new byte[2];
  
  private final byte[] P = new byte[4];
  
  private final byte[] Q = new byte[6];
  
  private final int R;
  
  private final D S;
  
  public b(InputStream paramInputStream) {
    this(paramInputStream, 512, "US-ASCII");
  }
  
  public b(InputStream paramInputStream, String paramString) {
    this(paramInputStream, 512, paramString);
  }
  
  public b(InputStream paramInputStream, int paramInt) {
    this(paramInputStream, paramInt, "US-ASCII");
  }
  
  public b(InputStream paramInputStream, int paramInt, String paramString) {
    this.N = paramInputStream;
    this.R = paramInt;
    this.S = E.a(paramString);
  }
  
  public int available() throws IOException {
    f();
    return this.K ? 0 : 1;
  }
  
  public void close() throws IOException {
    if (!this.H) {
      this.N.close();
      this.H = true;
    } 
  }
  
  private void e() throws IOException {
    while (skip(2147483647L) == 2147483647L);
  }
  
  private void f() throws IOException {
    if (this.H)
      throw new IOException("Stream closed"); 
  }
  
  public a d() throws IOException {
    f();
    if (this.I != null)
      e(); 
    a(this.O, 0, this.O.length);
    if (e.a(this.O, false) == 29127L) {
      this.I = b(false);
    } else if (e.a(this.O, true) == 29127L) {
      this.I = b(true);
    } else {
      System.arraycopy(this.O, 0, this.Q, 0, this.O.length);
      a(this.Q, this.O.length, this.P.length);
      String str = a.a(this.Q);
      if (str.equals("070701")) {
        this.I = a(false);
      } else if (str.equals("070702")) {
        this.I = a(true);
      } else if (str.equals("070707")) {
        this.I = g();
      } else {
        throw new IOException("Unknown magic [" + str + "]. Occured at byte: " + c());
      } 
    } 
    this.J = 0L;
    this.K = false;
    this.M = 0L;
    if (this.I.getName().equals("TRAILER!!!")) {
      this.K = true;
      h();
      return null;
    } 
    return this.I;
  }
  
  private void b(int paramInt) throws IOException {
    if (paramInt > 0)
      a(this.P, 0, paramInt); 
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    f();
    if (off < 0 || len < 0 || off > arrayOfByte.length - len)
      throw new IndexOutOfBoundsException(); 
    if (len == 0)
      return 0; 
    if (this.I == null || this.K)
      return -1; 
    if (this.J == this.I.getSize()) {
      b(this.I.k());
      this.K = true;
      if (this.I.f() == 2 && this.M != this.I.b())
        throw new IOException("CRC Error. Occured at byte: " + c()); 
      return -1;
    } 
    int i = (int)Math.min(len, this.I.getSize() - this.J);
    if (i < 0)
      return -1; 
    int j = a(arrayOfByte, off, i);
    if (this.I.f() == 2)
      for (byte b1 = 0; b1 < j; b1++)
        this.M += (arrayOfByte[b1] & 0xFF);  
    this.J += j;
    return j;
  }
  
  private final int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = i.a(this.N, paramArrayOfbyte, paramInt1, paramInt2);
    a(i);
    if (i < paramInt2)
      throw new EOFException(); 
    return i;
  }
  
  private long a(int paramInt, boolean paramBoolean) throws IOException {
    byte[] arrayOfByte = new byte[paramInt];
    a(arrayOfByte, 0, arrayOfByte.length);
    return e.a(arrayOfByte, paramBoolean);
  }
  
  private long a(int paramInt1, int paramInt2) throws IOException {
    byte[] arrayOfByte = new byte[paramInt1];
    a(arrayOfByte, 0, arrayOfByte.length);
    return Long.parseLong(a.a(arrayOfByte), paramInt2);
  }
  
  private a a(boolean paramBoolean) throws IOException {
    a a1;
    if (paramBoolean) {
      a1 = new a((short)2);
    } else {
      a1 = new a((short)1);
    } 
    a1.g(a(8, 16));
    long l1 = a(8, 16);
    if (e.a(l1) != 0L)
      a1.h(l1); 
    a1.n(a(8, 16));
    a1.f(a(8, 16));
    a1.i(a(8, 16));
    a1.m(a(8, 16));
    a1.e(a(8, 16));
    a1.c(a(8, 16));
    a1.d(a(8, 16));
    a1.k(a(8, 16));
    a1.l(a(8, 16));
    long l2 = a(8, 16);
    a1.a(a(8, 16));
    String str = c((int)l2);
    a1.a(str);
    if (e.a(l1) == 0L && !str.equals("TRAILER!!!"))
      throw new IOException("Mode 0 only allowed in the trailer. Found entry name: " + str + " Occured at byte: " + c()); 
    b(a1.j());
    return a1;
  }
  
  private a g() throws IOException {
    a a1 = new a((short)4);
    a1.b(a(6, 8));
    a1.g(a(6, 8));
    long l1 = a(6, 8);
    if (e.a(l1) != 0L)
      a1.h(l1); 
    a1.n(a(6, 8));
    a1.f(a(6, 8));
    a1.i(a(6, 8));
    a1.j(a(6, 8));
    a1.m(a(11, 8));
    long l2 = a(6, 8);
    a1.e(a(11, 8));
    String str = c((int)l2);
    a1.a(str);
    if (e.a(l1) == 0L && !str.equals("TRAILER!!!"))
      throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + str + " Occured at byte: " + c()); 
    return a1;
  }
  
  private a b(boolean paramBoolean) throws IOException {
    a a1 = new a((short)8);
    a1.b(a(2, paramBoolean));
    a1.g(a(2, paramBoolean));
    long l1 = a(2, paramBoolean);
    if (e.a(l1) != 0L)
      a1.h(l1); 
    a1.n(a(2, paramBoolean));
    a1.f(a(2, paramBoolean));
    a1.i(a(2, paramBoolean));
    a1.j(a(2, paramBoolean));
    a1.m(a(4, paramBoolean));
    long l2 = a(2, paramBoolean);
    a1.e(a(4, paramBoolean));
    String str = c((int)l2);
    a1.a(str);
    if (e.a(l1) == 0L && !str.equals("TRAILER!!!"))
      throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + str + "Occured at byte: " + c()); 
    b(a1.j());
    return a1;
  }
  
  private String c(int paramInt) throws IOException {
    byte[] arrayOfByte = new byte[paramInt - 1];
    a(arrayOfByte, 0, arrayOfByte.length);
    this.N.read();
    return this.S.a(arrayOfByte);
  }
  
  public long skip(long n) throws IOException {
    if (n < 0L)
      throw new IllegalArgumentException("negative skip length"); 
    f();
    int i = (int)Math.min(n, 2147483647L);
    int j;
    for (j = 0; j < i; j += k) {
      int k = i - j;
      if (k > this.L.length)
        k = this.L.length; 
      k = read(this.L, 0, k);
      if (k == -1) {
        this.K = true;
        break;
      } 
    } 
    return j;
  }
  
  public a a() throws IOException {
    return d();
  }
  
  private void h() throws IOException {
    long l1 = c() % this.R;
    for (long l2 = (l1 == 0L) ? 0L : (this.R - l1); l2 > 0L; l2 -= l) {
      long l = skip(this.R - l1);
      if (l <= 0L)
        break; 
    } 
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < 6) ? false : ((paramArrayOfbyte[0] == 113 && (paramArrayOfbyte[1] & 0xFF) == 199) ? true : ((paramArrayOfbyte[1] == 113 && (paramArrayOfbyte[0] & 0xFF) == 199) ? true : ((paramArrayOfbyte[0] != 48) ? false : ((paramArrayOfbyte[1] != 55) ? false : ((paramArrayOfbyte[2] != 48) ? false : ((paramArrayOfbyte[3] != 55) ? false : ((paramArrayOfbyte[4] != 48) ? false : ((paramArrayOfbyte[5] == 49) ? true : ((paramArrayOfbyte[5] == 50) ? true : ((paramArrayOfbyte[5] == 55)))))))))));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/c/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */