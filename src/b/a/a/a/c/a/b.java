package b.a.a.a.c.a;

import b.a.a.a.c.c;
import java.io.IOException;
import java.io.OutputStream;

public class b extends c implements c {
  public static final int a = 1;
  
  public static final int b = 9;
  
  private static final int m = 15;
  
  private static final int n = 0;
  
  private int o;
  
  private final int p;
  
  private int q;
  
  private int r;
  
  private final f s = new f();
  
  private int t;
  
  private int u;
  
  private int v = -1;
  
  private int w = 0;
  
  private int x;
  
  private int y;
  
  private final int z;
  
  private a A;
  
  private e B;
  
  private OutputStream C;
  
  private static void a(byte[] paramArrayOfbyte, int[] paramArrayOfint, a parama, int paramInt1, int paramInt2) {
    int[] arrayOfInt1 = parama.n;
    int[] arrayOfInt2 = parama.o;
    int[] arrayOfInt3 = parama.p;
    int i = paramInt1;
    while (--i >= 0)
      arrayOfInt2[i + 1] = ((paramArrayOfint[i] == 0) ? 1 : paramArrayOfint[i]) << 8; 
    i = 1;
    while (i != 0) {
      i = 0;
      int j = paramInt1;
      byte b1 = 0;
      arrayOfInt1[0] = 0;
      arrayOfInt2[0] = 0;
      arrayOfInt3[0] = -2;
      int k;
      for (k = 1; k <= paramInt1; k++) {
        arrayOfInt3[k] = -1;
        arrayOfInt1[++b1] = k;
        int m = b1;
        int n = arrayOfInt1[m];
        while (arrayOfInt2[n] < arrayOfInt2[arrayOfInt1[m >> 1]]) {
          arrayOfInt1[m] = arrayOfInt1[m >> 1];
          m >>= 1;
        } 
        arrayOfInt1[m] = n;
      } 
      while (b1 > 1) {
        k = arrayOfInt1[1];
        arrayOfInt1[1] = arrayOfInt1[b1];
        b1--;
        int m = 0;
        int n = 1;
        int i1 = arrayOfInt1[1];
        while (true) {
          m = n << 1;
          if (m > b1)
            break; 
          if (m < b1 && arrayOfInt2[arrayOfInt1[m + 1]] < arrayOfInt2[arrayOfInt1[m]])
            m++; 
          if (arrayOfInt2[i1] < arrayOfInt2[arrayOfInt1[m]])
            break; 
          arrayOfInt1[n] = arrayOfInt1[m];
          n = m;
        } 
        arrayOfInt1[n] = i1;
        int i2 = arrayOfInt1[1];
        arrayOfInt1[1] = arrayOfInt1[b1];
        b1--;
        m = 0;
        n = 1;
        i1 = arrayOfInt1[1];
        while (true) {
          m = n << 1;
          if (m > b1)
            break; 
          if (m < b1 && arrayOfInt2[arrayOfInt1[m + 1]] < arrayOfInt2[arrayOfInt1[m]])
            m++; 
          if (arrayOfInt2[i1] < arrayOfInt2[arrayOfInt1[m]])
            break; 
          arrayOfInt1[n] = arrayOfInt1[m];
          n = m;
        } 
        arrayOfInt1[n] = i1;
        arrayOfInt3[i2] = ++j;
        arrayOfInt3[k] = ++j;
        int i3 = arrayOfInt2[k];
        int i4 = arrayOfInt2[i2];
        arrayOfInt2[j] = (i3 & 0xFFFFFF00) + (i4 & 0xFFFFFF00) | 1 + (((i3 & 0xFF) > (i4 & 0xFF)) ? (i3 & 0xFF) : (i4 & 0xFF));
        arrayOfInt3[j] = -1;
        arrayOfInt1[++b1] = j;
        i1 = 0;
        n = b1;
        i1 = arrayOfInt1[n];
        int i5 = arrayOfInt2[i1];
        while (i5 < arrayOfInt2[arrayOfInt1[n >> 1]]) {
          arrayOfInt1[n] = arrayOfInt1[n >> 1];
          n >>= 1;
        } 
        arrayOfInt1[n] = i1;
      } 
      for (k = 1; k <= paramInt1; k++) {
        byte b2 = 0;
        int m = k;
        int n;
        while ((n = arrayOfInt3[m]) >= 0) {
          m = n;
          b2++;
        } 
        paramArrayOfbyte[k - 1] = (byte)b2;
        if (b2 > paramInt2)
          i = 1; 
      } 
      if (i != 0)
        for (k = 1; k < paramInt1; k++) {
          int m = arrayOfInt2[k] >> 8;
          m = 1 + (m >> 1);
          arrayOfInt2[k] = m << 8;
        }  
    } 
  }
  
  public static int a(long paramLong) {
    return (paramLong > 0L) ? (int)Math.min(paramLong / 132000L + 1L, 9L) : 9;
  }
  
  public b(OutputStream paramOutputStream) throws IOException {
    this(paramOutputStream, 9);
  }
  
  public b(OutputStream paramOutputStream, int paramInt) throws IOException {
    if (paramInt < 1)
      throw new IllegalArgumentException("blockSize(" + paramInt + ") < 1"); 
    if (paramInt > 9)
      throw new IllegalArgumentException("blockSize(" + paramInt + ") > 9"); 
    this.p = paramInt;
    this.C = paramOutputStream;
    this.z = this.p * 100000 - 20;
    d();
  }
  
  public void write(int i) throws IOException {
    if (this.C != null) {
      a(i);
    } else {
      throw new IOException("closed");
    } 
  }
  
  private void c() throws IOException {
    int i = this.o;
    if (i < this.z) {
      int j = this.v;
      a a1 = this.A;
      a1.a[j] = true;
      byte b1 = (byte)j;
      int k = this.w;
      this.s.a(j, k);
      switch (k) {
        case 1:
          a1.q[i + 2] = b1;
          this.o = i + 1;
          return;
        case 2:
          a1.q[i + 2] = b1;
          a1.q[i + 3] = b1;
          this.o = i + 2;
          return;
        case 3:
          arrayOfByte = a1.q;
          arrayOfByte[i + 2] = b1;
          arrayOfByte[i + 3] = b1;
          arrayOfByte[i + 4] = b1;
          this.o = i + 3;
          return;
      } 
      k -= 4;
      a1.a[k] = true;
      byte[] arrayOfByte = a1.q;
      arrayOfByte[i + 2] = b1;
      arrayOfByte[i + 3] = b1;
      arrayOfByte[i + 4] = b1;
      arrayOfByte[i + 5] = b1;
      arrayOfByte[i + 6] = (byte)k;
      this.o = i + 5;
    } else {
      f();
      e();
      c();
    } 
  }
  
  protected void finalize() throws Throwable {
    a();
    super.finalize();
  }
  
  public void a() throws IOException {
    if (this.C != null)
      try {
        if (this.w > 0)
          c(); 
        this.v = -1;
        f();
        g();
      } finally {
        this.C = null;
        this.A = null;
        this.B = null;
      }  
  }
  
  public void close() throws IOException {
    if (this.C != null) {
      OutputStream outputStream = this.C;
      a();
      outputStream.close();
    } 
  }
  
  public void flush() throws IOException {
    OutputStream outputStream = this.C;
    if (outputStream != null)
      outputStream.flush(); 
  }
  
  private void d() throws IOException {
    b(66);
    b(90);
    this.A = new a(this.p);
    this.B = new e(this.A);
    b(104);
    b(48 + this.p);
    this.y = 0;
    e();
  }
  
  private void e() {
    this.s.a();
    this.o = -1;
    boolean[] arrayOfBoolean = this.A.a;
    char c1 = 'Ā';
    while (--c1 >= '\000')
      arrayOfBoolean[c1] = false; 
  }
  
  private void f() throws IOException {
    this.x = this.s.b();
    this.y = this.y << 1 | this.y >>> 31;
    this.y ^= this.x;
    if (this.o == -1)
      return; 
    m();
    b(49);
    b(65);
    b(89);
    b(38);
    b(83);
    b(89);
    c(this.x);
    a(1, 0);
    l();
  }
  
  private void g() throws IOException {
    b(23);
    b(114);
    b(69);
    b(56);
    b(80);
    b(144);
    c(this.y);
    h();
  }
  
  public final int b() {
    return this.p;
  }
  
  public void write(byte[] buf, int offs, int len) throws IOException {
    if (offs < 0)
      throw new IndexOutOfBoundsException("offs(" + offs + ") < 0."); 
    if (len < 0)
      throw new IndexOutOfBoundsException("len(" + len + ") < 0."); 
    if (offs + len > buf.length)
      throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > buf.length(" + buf.length + ")."); 
    if (this.C == null)
      throw new IOException("stream closed"); 
    int i = offs + len;
    while (offs < i)
      a(buf[offs++]); 
  }
  
  private void a(int paramInt) throws IOException {
    if (this.v != -1) {
      paramInt &= 0xFF;
      if (this.v == paramInt) {
        if (++this.w > 254) {
          c();
          this.v = -1;
          this.w = 0;
        } 
      } else {
        c();
        this.w = 1;
        this.v = paramInt;
      } 
    } else {
      this.v = paramInt & 0xFF;
      this.w++;
    } 
  }
  
  private static void a(int[] paramArrayOfint, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    int i = 0;
    for (int j = paramInt1; j <= paramInt2; j++) {
      for (byte b1 = 0; b1 < paramInt3; b1++) {
        if ((paramArrayOfbyte[b1] & 0xFF) == j) {
          paramArrayOfint[b1] = i;
          i++;
        } 
      } 
      i <<= 1;
    } 
  }
  
  private void h() throws IOException {
    while (this.r > 0) {
      int i = this.q >> 24;
      this.C.write(i);
      this.q <<= 8;
      this.r -= 8;
    } 
  }
  
  private void a(int paramInt1, int paramInt2) throws IOException {
    OutputStream outputStream = this.C;
    int i = this.r;
    int j = this.q;
    while (i >= 8) {
      outputStream.write(j >> 24);
      j <<= 8;
      i -= 8;
    } 
    this.q = j | paramInt2 << 32 - i - paramInt1;
    this.r = i + paramInt1;
  }
  
  private void b(int paramInt) throws IOException {
    a(8, paramInt);
  }
  
  private void c(int paramInt) throws IOException {
    a(8, paramInt >> 24 & 0xFF);
    a(8, paramInt >> 16 & 0xFF);
    a(8, paramInt >> 8 & 0xFF);
    a(8, paramInt & 0xFF);
  }
  
  private void i() throws IOException {
    byte[][] arrayOfByte = this.A.g;
    int i = this.t + 2;
    byte b1 = 6;
    while (--b1 >= 0) {
      byte[] arrayOfByte1 = arrayOfByte[b1];
      int k = i;
      while (--k >= 0)
        arrayOfByte1[k] = 15; 
    } 
    b1 = (this.u < 200) ? 2 : ((this.u < 600) ? 3 : ((this.u < 1200) ? 4 : ((this.u < 2400) ? 5 : 6)));
    b(b1, i);
    int j = c(b1, i);
    d(b1, j);
    e(b1, i);
    j();
    f(b1, j);
    g(b1, i);
    k();
  }
  
  private void b(int paramInt1, int paramInt2) {
    byte[][] arrayOfByte = this.A.g;
    int[] arrayOfInt = this.A.c;
    int i = this.u;
    int j = 0;
    for (int k = paramInt1; k > 0; k--) {
      int m = i / k;
      int n = j - 1;
      int i1 = 0;
      int i2 = paramInt2 - 1;
      while (i1 < m && n < i2)
        i1 += arrayOfInt[++n]; 
      if (n > j && k != paramInt1 && k != 1 && (paramInt1 - k & 0x1) != 0)
        i1 -= arrayOfInt[n--]; 
      byte[] arrayOfByte1 = arrayOfByte[k - 1];
      int i3 = paramInt2;
      while (--i3 >= 0) {
        if (i3 >= j && i3 <= n) {
          arrayOfByte1[i3] = 0;
          continue;
        } 
        arrayOfByte1[i3] = 15;
      } 
      j = n + 1;
      i -= i1;
    } 
  }
  
  private int c(int paramInt1, int paramInt2) {
    a a1 = this.A;
    int[][] arrayOfInt = a1.h;
    int[] arrayOfInt1 = a1.i;
    short[] arrayOfShort = a1.j;
    char[] arrayOfChar = a1.s;
    byte[] arrayOfByte1 = a1.d;
    byte[][] arrayOfByte = a1.g;
    byte[] arrayOfByte2 = arrayOfByte[0];
    byte[] arrayOfByte3 = arrayOfByte[1];
    byte[] arrayOfByte4 = arrayOfByte[2];
    byte[] arrayOfByte5 = arrayOfByte[3];
    byte[] arrayOfByte6 = arrayOfByte[4];
    byte[] arrayOfByte7 = arrayOfByte[5];
    int i = this.u;
    byte b1 = 0;
    for (byte b2 = 0; b2 < 4; b2++) {
      int j = paramInt1;
      while (--j >= 0) {
        arrayOfInt1[j] = 0;
        int[] arrayOfInt2 = arrayOfInt[j];
        int k = paramInt2;
        while (--k >= 0)
          arrayOfInt2[k] = 0; 
      } 
      b1 = 0;
      for (j = 0; j < this.u; j = k + 1) {
        int k = Math.min(j + 50 - 1, i - 1);
        if (paramInt1 == 6) {
          short s1 = 0;
          short s2 = 0;
          short s3 = 0;
          short s4 = 0;
          short s5 = 0;
          short s6 = 0;
          for (int i2 = j; i2 <= k; i2++) {
            char c1 = arrayOfChar[i2];
            s1 = (short)(s1 + (arrayOfByte2[c1] & 0xFF));
            s2 = (short)(s2 + (arrayOfByte3[c1] & 0xFF));
            s3 = (short)(s3 + (arrayOfByte4[c1] & 0xFF));
            s4 = (short)(s4 + (arrayOfByte5[c1] & 0xFF));
            s5 = (short)(s5 + (arrayOfByte6[c1] & 0xFF));
            s6 = (short)(s6 + (arrayOfByte7[c1] & 0xFF));
          } 
          arrayOfShort[0] = s1;
          arrayOfShort[1] = s2;
          arrayOfShort[2] = s3;
          arrayOfShort[3] = s4;
          arrayOfShort[4] = s5;
          arrayOfShort[5] = s6;
        } else {
          int i2 = paramInt1;
          while (--i2 >= 0)
            arrayOfShort[i2] = 0; 
          for (i2 = j; i2 <= k; i2++) {
            char c1 = arrayOfChar[i2];
            int i3 = paramInt1;
            while (--i3 >= 0)
              arrayOfShort[i3] = (short)(arrayOfShort[i3] + (arrayOfByte[i3][c1] & 0xFF)); 
          } 
        } 
        int m = -1;
        int n = paramInt1;
        int i1 = 999999999;
        while (--n >= 0) {
          short s = arrayOfShort[n];
          if (s < i1) {
            i1 = s;
            m = n;
          } 
        } 
        arrayOfInt1[m] = arrayOfInt1[m] + 1;
        arrayOfByte1[b1] = (byte)m;
        b1++;
        int[] arrayOfInt2 = arrayOfInt[m];
        for (i1 = j; i1 <= k; i1++)
          arrayOfInt2[arrayOfChar[i1]] = arrayOfInt2[arrayOfChar[i1]] + 1; 
      } 
      for (j = 0; j < paramInt1; j++)
        a(arrayOfByte[j], arrayOfInt[j], this.A, paramInt2, 20); 
    } 
    return b1;
  }
  
  private void d(int paramInt1, int paramInt2) {
    a a1 = this.A;
    byte[] arrayOfByte = a1.l;
    int i = paramInt1;
    while (--i >= 0)
      arrayOfByte[i] = (byte)i; 
    for (i = 0; i < paramInt2; i++) {
      byte b1 = a1.d[i];
      byte b2 = arrayOfByte[0];
      byte b3 = 0;
      while (b1 != b2) {
        b3++;
        byte b4 = b2;
        b2 = arrayOfByte[b3];
        arrayOfByte[b3] = b4;
      } 
      arrayOfByte[0] = b2;
      a1.e[i] = (byte)b3;
    } 
  }
  
  private void e(int paramInt1, int paramInt2) {
    int[][] arrayOfInt = this.A.k;
    byte[][] arrayOfByte = this.A.g;
    for (byte b1 = 0; b1 < paramInt1; b1++) {
      int i = 32;
      int j = 0;
      byte[] arrayOfByte1 = arrayOfByte[b1];
      int k = paramInt2;
      while (--k >= 0) {
        int m = arrayOfByte1[k] & 0xFF;
        if (m > j)
          j = m; 
        if (m < i)
          i = m; 
      } 
      a(arrayOfInt[b1], arrayOfByte[b1], i, j, paramInt2);
    } 
  }
  
  private void j() throws IOException {
    boolean[] arrayOfBoolean1 = this.A.a;
    boolean[] arrayOfBoolean2 = this.A.m;
    byte b1 = 16;
    while (--b1 >= 0) {
      arrayOfBoolean2[b1] = false;
      int k = b1 * 16;
      byte b3 = 16;
      while (--b3 >= 0) {
        if (arrayOfBoolean1[k + b3])
          arrayOfBoolean2[b1] = true; 
      } 
    } 
    for (b1 = 0; b1 < 16; b1++)
      a(1, arrayOfBoolean2[b1] ? 1 : 0); 
    OutputStream outputStream = this.C;
    int i = this.r;
    int j = this.q;
    for (byte b2 = 0; b2 < 16; b2++) {
      if (arrayOfBoolean2[b2]) {
        int k = b2 * 16;
        for (byte b3 = 0; b3 < 16; b3++) {
          while (i >= 8) {
            outputStream.write(j >> 24);
            j <<= 8;
            i -= 8;
          } 
          if (arrayOfBoolean1[k + b3])
            j |= 1 << 32 - i - 1; 
          i++;
        } 
      } 
    } 
    this.q = j;
    this.r = i;
  }
  
  private void f(int paramInt1, int paramInt2) throws IOException {
    a(3, paramInt1);
    a(15, paramInt2);
    OutputStream outputStream = this.C;
    byte[] arrayOfByte = this.A.e;
    int i = this.r;
    int j = this.q;
    for (byte b1 = 0; b1 < paramInt2; b1++) {
      byte b2 = 0;
      int k = arrayOfByte[b1] & 0xFF;
      while (b2 < k) {
        while (i >= 8) {
          outputStream.write(j >> 24);
          j <<= 8;
          i -= 8;
        } 
        j |= 1 << 32 - i - 1;
        i++;
        b2++;
      } 
      while (i >= 8) {
        outputStream.write(j >> 24);
        j <<= 8;
        i -= 8;
      } 
      i++;
    } 
    this.q = j;
    this.r = i;
  }
  
  private void g(int paramInt1, int paramInt2) throws IOException {
    byte[][] arrayOfByte = this.A.g;
    OutputStream outputStream = this.C;
    int i = this.r;
    int j = this.q;
    for (byte b1 = 0; b1 < paramInt1; b1++) {
      byte[] arrayOfByte1 = arrayOfByte[b1];
      int k = arrayOfByte1[0] & 0xFF;
      while (i >= 8) {
        outputStream.write(j >> 24);
        j <<= 8;
        i -= 8;
      } 
      j |= k << 32 - i - 5;
      i += 5;
      for (byte b2 = 0; b2 < paramInt2; b2++) {
        int m = arrayOfByte1[b2] & 0xFF;
        while (k < m) {
          while (i >= 8) {
            outputStream.write(j >> 24);
            j <<= 8;
            i -= 8;
          } 
          j |= 2 << 32 - i - 2;
          i += 2;
          k++;
        } 
        while (k > m) {
          while (i >= 8) {
            outputStream.write(j >> 24);
            j <<= 8;
            i -= 8;
          } 
          j |= 3 << 32 - i - 2;
          i += 2;
          k--;
        } 
        while (i >= 8) {
          outputStream.write(j >> 24);
          j <<= 8;
          i -= 8;
        } 
        i++;
      } 
    } 
    this.q = j;
    this.r = i;
  }
  
  private void k() throws IOException {
    a a1 = this.A;
    byte[][] arrayOfByte = a1.g;
    int[][] arrayOfInt = a1.k;
    OutputStream outputStream = this.C;
    byte[] arrayOfByte1 = a1.d;
    char[] arrayOfChar = a1.s;
    int i = this.u;
    byte b1 = 0;
    int j = this.r;
    int k = this.q;
    int m = 0;
    while (m < i) {
      int n = Math.min(m + 50 - 1, i - 1);
      int i1 = arrayOfByte1[b1] & 0xFF;
      int[] arrayOfInt1 = arrayOfInt[i1];
      byte[] arrayOfByte2 = arrayOfByte[i1];
      while (m <= n) {
        char c1 = arrayOfChar[m];
        while (j >= 8) {
          outputStream.write(k >> 24);
          k <<= 8;
          j -= 8;
        } 
        int i2 = arrayOfByte2[c1] & 0xFF;
        k |= arrayOfInt1[c1] << 32 - j - i2;
        j += i2;
        m++;
      } 
      m = n + 1;
      b1++;
    } 
    this.q = k;
    this.r = j;
  }
  
  private void l() throws IOException {
    a(24, this.A.t);
    n();
    i();
  }
  
  private void m() {
    this.B.a(this.A, this.o);
  }
  
  private void n() {
    int i = this.o;
    a a1 = this.A;
    boolean[] arrayOfBoolean = a1.a;
    byte[] arrayOfByte1 = a1.q;
    int[] arrayOfInt1 = a1.r;
    char[] arrayOfChar = a1.s;
    int[] arrayOfInt2 = a1.c;
    byte[] arrayOfByte2 = a1.b;
    byte[] arrayOfByte3 = a1.f;
    byte b1 = 0;
    int j;
    for (j = 0; j < 256; j++) {
      if (arrayOfBoolean[j]) {
        arrayOfByte2[j] = (byte)b1;
        b1++;
      } 
    } 
    this.t = b1;
    j = b1 + 1;
    int k;
    for (k = j; k >= 0; k--)
      arrayOfInt2[k] = 0; 
    k = b1;
    while (--k >= 0)
      arrayOfByte3[k] = (byte)k; 
    k = 0;
    int m = 0;
    for (byte b2 = 0; b2 <= i; b2++) {
      byte b3 = arrayOfByte2[arrayOfByte1[arrayOfInt1[b2]] & 0xFF];
      byte b4 = arrayOfByte3[0];
      byte b5 = 0;
      while (b3 != b4) {
        b5++;
        byte b6 = b4;
        b4 = arrayOfByte3[b5];
        arrayOfByte3[b5] = b6;
      } 
      arrayOfByte3[0] = b4;
      if (b5 == 0) {
        m++;
      } else {
        if (m > 0) {
          m--;
          while (true) {
            if ((m & 0x1) == 0) {
              arrayOfChar[k] = Character.MIN_VALUE;
              k++;
              arrayOfInt2[0] = arrayOfInt2[0] + 1;
            } else {
              arrayOfChar[k] = '\001';
              k++;
              arrayOfInt2[1] = arrayOfInt2[1] + 1;
            } 
            if (m >= 2) {
              m = m - 2 >> 1;
              continue;
            } 
            m = 0;
            break;
          } 
        } 
        arrayOfChar[k] = (char)(b5 + 1);
        k++;
        arrayOfInt2[b5 + 1] = arrayOfInt2[b5 + 1] + 1;
      } 
    } 
    if (m > 0) {
      m--;
      while (true) {
        if ((m & 0x1) == 0) {
          arrayOfChar[k] = Character.MIN_VALUE;
          k++;
          arrayOfInt2[0] = arrayOfInt2[0] + 1;
        } else {
          arrayOfChar[k] = '\001';
          k++;
          arrayOfInt2[1] = arrayOfInt2[1] + 1;
        } 
        if (m >= 2) {
          m = m - 2 >> 1;
          continue;
        } 
        break;
      } 
    } 
    arrayOfChar[k] = (char)j;
    arrayOfInt2[j] = arrayOfInt2[j] + 1;
    this.u = k + 1;
  }
  
  static final class a {
    final boolean[] a = new boolean[256];
    
    final byte[] b = new byte[256];
    
    final int[] c = new int[258];
    
    final byte[] d = new byte[18002];
    
    final byte[] e = new byte[18002];
    
    final byte[] f = new byte[256];
    
    final byte[][] g = new byte[6][258];
    
    final int[][] h = new int[6][258];
    
    final int[] i = new int[6];
    
    final short[] j = new short[6];
    
    final int[][] k = new int[6][258];
    
    final byte[] l = new byte[6];
    
    final boolean[] m = new boolean[16];
    
    final int[] n = new int[260];
    
    final int[] o = new int[516];
    
    final int[] p = new int[516];
    
    final byte[] q;
    
    final int[] r;
    
    final char[] s;
    
    int t;
    
    a(int param1Int) {
      int i = param1Int * 100000;
      this.q = new byte[i + 1 + 20];
      this.r = new int[i];
      this.s = new char[2 * i];
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/a/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */