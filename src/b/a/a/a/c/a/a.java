package b.a.a.a.c.a;

import b.a.a.a.c.b;
import java.io.IOException;
import java.io.InputStream;

public class a extends b implements c {
  private int a;
  
  private int b;
  
  private int m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private final f q = new f();
  
  private int r;
  
  private InputStream s;
  
  private final boolean t;
  
  private static final int u = 0;
  
  private static final int v = 1;
  
  private static final int w = 2;
  
  private static final int x = 3;
  
  private static final int y = 4;
  
  private static final int z = 5;
  
  private static final int A = 6;
  
  private static final int B = 7;
  
  private int C = 1;
  
  private int D;
  
  private int E;
  
  private int F;
  
  private int G;
  
  private int H;
  
  private int I;
  
  private int J;
  
  private int K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private int O;
  
  private char P;
  
  private a Q;
  
  public a(InputStream paramInputStream) throws IOException {
    this(paramInputStream, false);
  }
  
  public a(InputStream paramInputStream, boolean paramBoolean) throws IOException {
    this.s = paramInputStream;
    this.t = paramBoolean;
    a(true);
    e();
  }
  
  public int read() throws IOException {
    if (this.s != null) {
      int i = d();
      a((i < 0) ? -1 : 1);
      return i;
    } 
    throw new IOException("stream closed");
  }
  
  public int read(byte[] dest, int offs, int len) throws IOException {
    if (offs < 0)
      throw new IndexOutOfBoundsException("offs(" + offs + ") < 0."); 
    if (len < 0)
      throw new IndexOutOfBoundsException("len(" + len + ") < 0."); 
    if (offs + len > dest.length)
      throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > dest.length(" + dest.length + ")."); 
    if (this.s == null)
      throw new IOException("stream closed"); 
    int i = offs + len;
    int j = offs;
    int k;
    while (j < i && (k = d()) >= 0) {
      dest[j++] = (byte)k;
      a(1);
    } 
    return (j == offs) ? -1 : (j - offs);
  }
  
  private void a() {
    boolean[] arrayOfBoolean = this.Q.a;
    byte[] arrayOfByte = this.Q.b;
    byte b1 = 0;
    for (byte b2 = 0; b2 < 'Ā'; b2++) {
      if (arrayOfBoolean[b2])
        arrayOfByte[b1++] = (byte)b2; 
    } 
    this.r = b1;
  }
  
  private int d() throws IOException {
    switch (this.C) {
      case 0:
        return -1;
      case 1:
        return m();
      case 2:
        throw new IllegalStateException();
      case 3:
        return p();
      case 4:
        return q();
      case 5:
        throw new IllegalStateException();
      case 6:
        return r();
      case 7:
        return s();
    } 
    throw new IllegalStateException();
  }
  
  private boolean a(boolean paramBoolean) throws IOException {
    if (null == this.s)
      throw new IOException("No InputStream"); 
    int i = this.s.read();
    if (i == -1 && !paramBoolean)
      return false; 
    int j = this.s.read();
    int k = this.s.read();
    if (i != 66 || j != 90 || k != 104)
      throw new IOException(paramBoolean ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream"); 
    int m = this.s.read();
    if (m < 49 || m > 57)
      throw new IOException("BZip2 block size is invalid"); 
    this.m = m - 48;
    this.p = 0;
    this.G = 0;
    return true;
  }
  
  private void e() throws IOException {
    char c1;
    char c2;
    char c3;
    char c4;
    char c5;
    char c6;
    while (true) {
      c1 = i();
      c2 = i();
      c3 = i();
      c4 = i();
      c5 = i();
      c6 = i();
      if (c1 != '\027' || c2 != 'r' || c3 != 'E' || c4 != '8' || c5 != 'P' || c6 != '')
        break; 
      if (g())
        return; 
    } 
    if (c1 != '1' || c2 != 'A' || c3 != 'Y' || c4 != '&' || c5 != 'S' || c6 != 'Y') {
      this.C = 0;
      throw new IOException("bad block header");
    } 
    this.D = j();
    this.n = (b(1) == 1);
    if (this.Q == null)
      this.Q = new a(this.m); 
    l();
    this.q.a();
    this.C = 1;
  }
  
  private void f() throws IOException {
    this.F = this.q.b();
    if (this.D != this.F) {
      this.G = this.E << 1 | this.E >>> 31;
      this.G ^= this.D;
      throw new IOException("BZip2 CRC error");
    } 
    this.G = this.G << 1 | this.G >>> 31;
    this.G ^= this.F;
  }
  
  private boolean g() throws IOException {
    this.E = j();
    this.C = 0;
    this.Q = null;
    if (this.E != this.G)
      throw new IOException("BZip2 CRC error"); 
    return (!this.t || !a(false));
  }
  
  public void close() throws IOException {
    InputStream inputStream = this.s;
    if (inputStream != null)
      try {
        if (inputStream != System.in)
          inputStream.close(); 
      } finally {
        this.Q = null;
        this.s = null;
      }  
  }
  
  private int b(int paramInt) throws IOException {
    int i = this.p;
    int j = this.o;
    if (i < paramInt) {
      InputStream inputStream = this.s;
      while (true) {
        int k = inputStream.read();
        if (k < 0)
          throw new IOException("unexpected end of stream"); 
        j = j << 8 | k;
        i += 8;
        if (i >= paramInt) {
          this.o = j;
          break;
        } 
      } 
    } 
    this.p = i - paramInt;
    return j >> i - paramInt & (1 << paramInt) - 1;
  }
  
  private boolean h() throws IOException {
    int i = this.p;
    int j = this.o;
    if (i < 1) {
      int k = this.s.read();
      if (k < 0)
        throw new IOException("unexpected end of stream"); 
      j = j << 8 | k;
      i += 8;
      this.o = j;
    } 
    this.p = i - 1;
    return ((j >> i - 1 & 0x1) != 0);
  }
  
  private char i() throws IOException {
    return (char)b(8);
  }
  
  private int j() throws IOException {
    return ((b(8) << 8 | b(8)) << 8 | b(8)) << 8 | b(8);
  }
  
  private static void a(int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1;
    int j = 0;
    while (i <= paramInt2) {
      for (byte b1 = 0; b1 < paramInt3; b1++) {
        if (paramArrayOfchar[b1] == i)
          paramArrayOfint3[j++] = b1; 
      } 
      i++;
    } 
    i = 23;
    while (--i > 0) {
      paramArrayOfint2[i] = 0;
      paramArrayOfint1[i] = 0;
    } 
    for (i = 0; i < paramInt3; i++)
      paramArrayOfint2[paramArrayOfchar[i] + 1] = paramArrayOfint2[paramArrayOfchar[i] + 1] + 1; 
    i = 1;
    j = paramArrayOfint2[0];
    while (i < 23) {
      j += paramArrayOfint2[i];
      paramArrayOfint2[i] = j;
      i++;
    } 
    i = paramInt1;
    j = 0;
    int k = paramArrayOfint2[i];
    while (i <= paramInt2) {
      int m = paramArrayOfint2[i + 1];
      j += m - k;
      k = m;
      paramArrayOfint1[i] = j - 1;
      j <<= 1;
      i++;
    } 
    for (i = paramInt1 + 1; i <= paramInt2; i++)
      paramArrayOfint2[i] = (paramArrayOfint1[i - 1] + 1 << 1) - paramArrayOfint2[i]; 
  }
  
  private void k() throws IOException {
    a a1 = this.Q;
    boolean[] arrayOfBoolean = a1.a;
    byte[] arrayOfByte1 = a1.m;
    byte[] arrayOfByte2 = a1.c;
    byte[] arrayOfByte3 = a1.d;
    int i = 0;
    int j;
    for (j = 0; j < 16; j++) {
      if (h())
        i |= 1 << j; 
    } 
    j = 256;
    while (--j >= 0)
      arrayOfBoolean[j] = false; 
    for (j = 0; j < 16; j++) {
      if ((i & 1 << j) != 0) {
        int i1 = j << 4;
        for (byte b2 = 0; b2 < 16; b2++) {
          if (h())
            arrayOfBoolean[i1 + b2] = true; 
        } 
      } 
    } 
    a();
    j = this.r + 2;
    int k = b(3);
    int m = b(15);
    int n;
    for (n = 0; n < m; n++) {
      byte b2;
      for (b2 = 0; h(); b2++);
      arrayOfByte3[n] = (byte)b2;
    } 
    n = k;
    while (--n >= 0)
      arrayOfByte1[n] = (byte)n; 
    for (n = 0; n < m; n++) {
      int i1 = arrayOfByte3[n] & 0xFF;
      byte b2 = arrayOfByte1[i1];
      while (i1 > 0) {
        arrayOfByte1[i1] = arrayOfByte1[i1 - 1];
        i1--;
      } 
      arrayOfByte1[0] = b2;
      arrayOfByte2[n] = b2;
    } 
    char[][] arrayOfChar = a1.l;
    for (byte b1 = 0; b1 < k; b1++) {
      int i1 = b(5);
      char[] arrayOfChar1 = arrayOfChar[b1];
      for (byte b2 = 0; b2 < j; b2++) {
        while (h())
          i1 += h() ? -1 : 1; 
        arrayOfChar1[b2] = (char)i1;
      } 
    } 
    a(j, k);
  }
  
  private void a(int paramInt1, int paramInt2) {
    a a1 = this.Q;
    char[][] arrayOfChar = a1.l;
    int[] arrayOfInt = a1.i;
    int[][] arrayOfInt1 = a1.f;
    int[][] arrayOfInt2 = a1.g;
    int[][] arrayOfInt3 = a1.h;
    for (byte b1 = 0; b1 < paramInt2; b1++) {
      char c1 = ' ';
      char c2 = Character.MIN_VALUE;
      char[] arrayOfChar1 = arrayOfChar[b1];
      int i = paramInt1;
      while (--i >= 0) {
        char c3 = arrayOfChar1[i];
        if (c3 > c2)
          c2 = c3; 
        if (c3 < c1)
          c1 = c3; 
      } 
      a(arrayOfInt1[b1], arrayOfInt2[b1], arrayOfInt3[b1], arrayOfChar[b1], c1, c2, paramInt1);
      arrayOfInt[b1] = c1;
    } 
  }
  
  private void l() throws IOException {
    this.b = b(24);
    k();
    InputStream inputStream = this.s;
    a a1 = this.Q;
    byte[] arrayOfByte1 = a1.o;
    int[] arrayOfInt1 = a1.e;
    byte[] arrayOfByte2 = a1.c;
    byte[] arrayOfByte3 = a1.b;
    char[] arrayOfChar = a1.k;
    int[] arrayOfInt2 = a1.i;
    int[][] arrayOfInt3 = a1.f;
    int[][] arrayOfInt4 = a1.g;
    int[][] arrayOfInt5 = a1.h;
    int i = this.m * 100000;
    char c1 = 'Ā';
    while (--c1 >= '\000') {
      arrayOfChar[c1] = (char)c1;
      arrayOfInt1[c1] = 0;
    } 
    c1 = Character.MIN_VALUE;
    byte b1 = 49;
    int j = this.r + 1;
    int k = c(0);
    int m = this.o;
    int n = this.p;
    byte b2 = -1;
    int i1 = arrayOfByte2[c1] & 0xFF;
    int[] arrayOfInt6 = arrayOfInt4[i1];
    int[] arrayOfInt7 = arrayOfInt3[i1];
    int[] arrayOfInt8 = arrayOfInt5[i1];
    int i2 = arrayOfInt2[i1];
    while (k != j) {
      if (k == 0 || k == 1) {
        int i5 = -1;
        for (int i6 = 1;; i6 <<= 1) {
          if (k == 0) {
            i5 += i6;
          } else if (k == 1) {
            i5 += i6 << 1;
          } else {
            i6 = arrayOfByte3[arrayOfChar[0]];
            arrayOfInt1[i6 & 0xFF] = arrayOfInt1[i6 & 0xFF] + i5 + 1;
            while (i5-- >= 0)
              arrayOfByte1[++b2] = i6; 
            break;
          } 
          if (b1 == 0) {
            b1 = 49;
            i1 = arrayOfByte2[++c1] & 0xFF;
            arrayOfInt6 = arrayOfInt4[i1];
            arrayOfInt7 = arrayOfInt3[i1];
            arrayOfInt8 = arrayOfInt5[i1];
            i2 = arrayOfInt2[i1];
          } else {
            b1--;
          } 
          int i7 = i2;
          while (n < i7) {
            int i9 = inputStream.read();
            if (i9 >= 0) {
              m = m << 8 | i9;
              n += 8;
              continue;
            } 
            throw new IOException("unexpected end of stream");
          } 
          int i8 = m >> n - i7 & (1 << i7) - 1;
          n -= i7;
          while (i8 > arrayOfInt7[i7]) {
            i7++;
            while (n < 1) {
              int i9 = inputStream.read();
              if (i9 >= 0) {
                m = m << 8 | i9;
                n += 8;
                continue;
              } 
              throw new IOException("unexpected end of stream");
            } 
            i8 = i8 << 1 | m >> --n & 0x1;
          } 
          k = arrayOfInt8[i8 - arrayOfInt6[i7]];
        } 
        if (b2 >= i)
          throw new IOException("block overrun"); 
        continue;
      } 
      if (++b2 >= i)
        throw new IOException("block overrun"); 
      char c2 = arrayOfChar[k - 1];
      arrayOfInt1[arrayOfByte3[c2] & 0xFF] = arrayOfInt1[arrayOfByte3[c2] & 0xFF] + 1;
      arrayOfByte1[b2] = arrayOfByte3[c2];
      if (k <= 16) {
        int i5 = k - 1;
        while (i5 > 0)
          arrayOfChar[i5] = arrayOfChar[--i5]; 
      } else {
        System.arraycopy(arrayOfChar, 0, arrayOfChar, 1, k - 1);
      } 
      arrayOfChar[0] = c2;
      if (b1 == 0) {
        b1 = 49;
        i1 = arrayOfByte2[++c1] & 0xFF;
        arrayOfInt6 = arrayOfInt4[i1];
        arrayOfInt7 = arrayOfInt3[i1];
        arrayOfInt8 = arrayOfInt5[i1];
        i2 = arrayOfInt2[i1];
      } else {
        b1--;
      } 
      int i3 = i2;
      while (n < i3) {
        int i5 = inputStream.read();
        if (i5 >= 0) {
          m = m << 8 | i5;
          n += 8;
          continue;
        } 
        throw new IOException("unexpected end of stream");
      } 
      int i4 = m >> n - i3 & (1 << i3) - 1;
      n -= i3;
      while (i4 > arrayOfInt7[i3]) {
        i3++;
        while (n < 1) {
          int i5 = inputStream.read();
          if (i5 >= 0) {
            m = m << 8 | i5;
            n += 8;
            continue;
          } 
          throw new IOException("unexpected end of stream");
        } 
        i4 = i4 << 1 | m >> --n & 0x1;
      } 
      k = arrayOfInt8[i4 - arrayOfInt6[i3]];
    } 
    this.a = b2;
    this.p = n;
    this.o = m;
  }
  
  private int c(int paramInt) throws IOException {
    InputStream inputStream = this.s;
    a a1 = this.Q;
    int i = a1.c[paramInt] & 0xFF;
    int[] arrayOfInt = a1.f[i];
    int j = a1.i[i];
    int k = b(j);
    int m = this.p;
    int n = this.o;
    while (k > arrayOfInt[j]) {
      j++;
      while (m < 1) {
        int i1 = inputStream.read();
        if (i1 >= 0) {
          n = n << 8 | i1;
          m += 8;
          continue;
        } 
        throw new IOException("unexpected end of stream");
      } 
      k = k << 1 | n >> --m & 0x1;
    } 
    this.p = m;
    this.o = n;
    return a1.h[i][k - a1.g[i][j]];
  }
  
  private int m() throws IOException {
    if (this.C == 0 || this.Q == null)
      return -1; 
    int[] arrayOfInt1 = this.Q.j;
    int[] arrayOfInt2 = this.Q.a(this.a + 1);
    byte[] arrayOfByte = this.Q.o;
    arrayOfInt1[0] = 0;
    System.arraycopy(this.Q.e, 0, arrayOfInt1, 1, 256);
    byte b1 = 1;
    int i = arrayOfInt1[0];
    while (b1 <= 'Ā') {
      i += arrayOfInt1[b1];
      arrayOfInt1[b1] = i;
      b1++;
    } 
    b1 = 0;
    i = this.a;
    while (b1 <= i) {
      arrayOfInt1[arrayOfByte[b1] & 0xFF] = arrayOfInt1[arrayOfByte[b1] & 0xFF] + 1;
      arrayOfInt2[arrayOfInt1[arrayOfByte[b1] & 0xFF]] = b1;
      b1++;
    } 
    if (this.b < 0 || this.b >= arrayOfInt2.length)
      throw new IOException("stream corrupted"); 
    this.O = arrayOfInt2[this.b];
    this.H = 0;
    this.K = 0;
    this.I = 256;
    if (this.n) {
      this.M = 0;
      this.N = 0;
      return n();
    } 
    return o();
  }
  
  private int n() throws IOException {
    if (this.K <= this.a) {
      this.J = this.I;
      int i = this.Q.o[this.O] & 0xFF;
      this.O = this.Q.n[this.O];
      if (this.M == 0) {
        this.M = g.a(this.N) - 1;
        if (++this.N == 512)
          this.N = 0; 
      } else {
        this.M--;
      } 
      this.I = i ^= (this.M == 1) ? 1 : 0;
      this.K++;
      this.C = 3;
      this.q.b(i);
      return i;
    } 
    f();
    e();
    return m();
  }
  
  private int o() throws IOException {
    if (this.K <= this.a) {
      this.J = this.I;
      int i = this.Q.o[this.O] & 0xFF;
      this.I = i;
      this.O = this.Q.n[this.O];
      this.K++;
      this.C = 6;
      this.q.b(i);
      return i;
    } 
    this.C = 5;
    f();
    e();
    return m();
  }
  
  private int p() throws IOException {
    if (this.I != this.J) {
      this.C = 2;
      this.H = 1;
      return n();
    } 
    if (++this.H >= 4) {
      this.P = (char)(this.Q.o[this.O] & 0xFF);
      this.O = this.Q.n[this.O];
      if (this.M == 0) {
        this.M = g.a(this.N) - 1;
        if (++this.N == 512)
          this.N = 0; 
      } else {
        this.M--;
      } 
      this.L = 0;
      this.C = 4;
      if (this.M == 1)
        this.P = (char)(this.P ^ 0x1); 
      return q();
    } 
    this.C = 2;
    return n();
  }
  
  private int q() throws IOException {
    if (this.L < this.P) {
      this.q.b(this.I);
      this.L++;
      return this.I;
    } 
    this.C = 2;
    this.K++;
    this.H = 0;
    return n();
  }
  
  private int r() throws IOException {
    if (this.I != this.J) {
      this.H = 1;
      return o();
    } 
    if (++this.H >= 4) {
      this.P = (char)(this.Q.o[this.O] & 0xFF);
      this.O = this.Q.n[this.O];
      this.L = 0;
      return s();
    } 
    return o();
  }
  
  private int s() throws IOException {
    if (this.L < this.P) {
      int i = this.I;
      this.q.b(i);
      this.L++;
      this.C = 7;
      return i;
    } 
    this.K++;
    this.H = 0;
    return o();
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < 3) ? false : ((paramArrayOfbyte[0] != 66) ? false : ((paramArrayOfbyte[1] != 90) ? false : (!(paramArrayOfbyte[2] != 104))));
  }
  
  private static final class a {
    final boolean[] a = new boolean[256];
    
    final byte[] b = new byte[256];
    
    final byte[] c = new byte[18002];
    
    final byte[] d = new byte[18002];
    
    final int[] e = new int[256];
    
    final int[][] f = new int[6][258];
    
    final int[][] g = new int[6][258];
    
    final int[][] h = new int[6][258];
    
    final int[] i = new int[6];
    
    final int[] j = new int[257];
    
    final char[] k = new char[256];
    
    final char[][] l = new char[6][258];
    
    final byte[] m = new byte[6];
    
    int[] n;
    
    byte[] o;
    
    a(int param1Int) {
      this.o = new byte[param1Int * 100000];
    }
    
    int[] a(int param1Int) {
      int[] arrayOfInt = this.n;
      if (arrayOfInt == null || arrayOfInt.length < param1Int)
        this.n = arrayOfInt = new int[param1Int]; 
      return arrayOfInt;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/a/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */