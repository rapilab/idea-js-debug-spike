package b.a.a.a.c.a;

import java.util.BitSet;

class e {
  private static final int a = 1000;
  
  private static final int b = 100;
  
  private static final int c = 1000;
  
  private int d;
  
  private int e;
  
  private boolean f;
  
  private final int[] g = new int[1000];
  
  private final int[] h = new int[1000];
  
  private final int[] i = new int[1000];
  
  private final int[] j = new int[256];
  
  private final int[] k = new int[256];
  
  private final boolean[] l = new boolean[256];
  
  private final int[] m = new int[65537];
  
  private final char[] n;
  
  private static final int o = 10;
  
  private int[] p;
  
  private static final int[] q = new int[] { 
      1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 
      88573, 265720, 797161, 2391484 };
  
  private static final int r = 20;
  
  private static final int s = 10;
  
  private static final int t = 30;
  
  private static final int u = 2097152;
  
  private static final int v = -2097153;
  
  e(b.a parama) {
    this.n = parama.s;
  }
  
  void a(b.a parama, int paramInt) {
    this.e = 30 * paramInt;
    this.d = 0;
    this.f = true;
    if (paramInt + 1 < 10000) {
      b(parama, paramInt);
    } else {
      c(parama, paramInt);
      if (this.f && this.d > this.e)
        b(parama, paramInt); 
    } 
    int[] arrayOfInt = parama.r;
    parama.t = -1;
    for (byte b = 0; b <= paramInt; b++) {
      if (arrayOfInt[b] == 0) {
        parama.t = b;
        break;
      } 
    } 
  }
  
  final void b(b.a parama, int paramInt) {
    parama.q[0] = parama.q[paramInt + 1];
    a(parama.r, parama.q, paramInt + 1);
    byte b;
    for (b = 0; b < paramInt + 1; b++)
      parama.r[b] = parama.r[b] - 1; 
    for (b = 0; b < paramInt + 1; b++) {
      if (parama.r[b] == -1) {
        parama.r[b] = paramInt;
        break;
      } 
    } 
  }
  
  private void a(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2) {
    if (paramInt1 == paramInt2)
      return; 
    if (paramInt2 - paramInt1 > 3)
      for (int j = paramInt2 - 4; j >= paramInt1; j--) {
        int m = paramArrayOfint1[j];
        int n = paramArrayOfint2[m];
        int k;
        for (k = j + 4; k <= paramInt2 && n > paramArrayOfint2[paramArrayOfint1[k]]; k += 4)
          paramArrayOfint1[k - 4] = paramArrayOfint1[k]; 
        paramArrayOfint1[k - 4] = m;
      }  
    for (int i = paramInt2 - 1; i >= paramInt1; i--) {
      int k = paramArrayOfint1[i];
      int m = paramArrayOfint2[k];
      int j;
      for (j = i + 1; j <= paramInt2 && m > paramArrayOfint2[paramArrayOfint1[j]]; j++)
        paramArrayOfint1[j - 1] = paramArrayOfint1[j]; 
      paramArrayOfint1[j - 1] = k;
    } 
  }
  
  private void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    int i = paramArrayOfint[paramInt1];
    paramArrayOfint[paramInt1] = paramArrayOfint[paramInt2];
    paramArrayOfint[paramInt2] = i;
  }
  
  private void a(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    while (paramInt3 > 0) {
      a(paramArrayOfint, paramInt1, paramInt2);
      paramInt1++;
      paramInt2++;
      paramInt3--;
    } 
  }
  
  private int a(int paramInt1, int paramInt2) {
    return (paramInt1 < paramInt2) ? paramInt1 : paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    this.g[paramInt1] = paramInt2;
    this.h[paramInt1] = paramInt3;
  }
  
  private int[] a(int paramInt) {
    return new int[] { this.g[paramInt], this.h[paramInt] };
  }
  
  private void b(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2) {
    long l = 0L;
    byte b = 0;
    a(b++, paramInt1, paramInt2);
    while (b > 0) {
      long l2;
      int[] arrayOfInt = a(--b);
      int i = arrayOfInt[0];
      int m = arrayOfInt[1];
      if (m - i < 10) {
        a(paramArrayOfint1, paramArrayOfint2, i, m);
        continue;
      } 
      l = (l * 7621L + 1L) % 32768L;
      long l1 = l % 3L;
      if (l1 == 0L) {
        l2 = paramArrayOfint2[paramArrayOfint1[i]];
      } else if (l1 == 1L) {
        l2 = paramArrayOfint2[paramArrayOfint1[i + m >>> 1]];
      } else {
        l2 = paramArrayOfint2[paramArrayOfint1[m]];
      } 
      int k = i;
      int j = k;
      int n;
      int i1;
      for (n = i1 = m;; n--) {
        if (j <= n) {
          int i2 = paramArrayOfint2[paramArrayOfint1[j]] - (int)l2;
          if (i2 == 0) {
            a(paramArrayOfint1, j, k);
            k++;
            j++;
            continue;
          } 
          if (i2 <= 0) {
            j++;
            continue;
          } 
        } 
        while (j <= n) {
          int i2 = paramArrayOfint2[paramArrayOfint1[n]] - (int)l2;
          if (i2 == 0) {
            a(paramArrayOfint1, n, i1);
            i1--;
            n--;
            continue;
          } 
          if (i2 < 0)
            break; 
          n--;
        } 
        if (j > n) {
          if (i1 < k)
            continue; 
          int i2 = a(k - i, j - k);
          a(paramArrayOfint1, i, j - i2, i2);
          int i3 = a(m - i1, i1 - n);
          a(paramArrayOfint1, n + 1, m - i3 + 1, i3);
          i2 = i + j - k - 1;
          i3 = m - i1 - n + 1;
          if (i2 - i > m - i3) {
            a(b++, i, i2);
            a(b++, i3, m);
            continue;
          } 
          a(b++, i3, m);
          a(b++, i, i2);
          continue;
        } 
        a(paramArrayOfint1, j, n);
        j++;
      } 
    } 
  }
  
  private int[] a() {
    return (this.p == null) ? (this.p = new int[this.n.length / 2]) : this.p;
  }
  
  final void a(int[] paramArrayOfint, byte[] paramArrayOfbyte, int paramInt) {
    int k;
    int[] arrayOfInt1 = new int[257];
    int[] arrayOfInt2 = a();
    int j;
    for (j = 0; j < paramInt; j++)
      arrayOfInt2[j] = 0; 
    for (j = 0; j < paramInt; j++)
      arrayOfInt1[paramArrayOfbyte[j] & 0xFF] = arrayOfInt1[paramArrayOfbyte[j] & 0xFF] + 1; 
    for (j = 1; j < 257; j++)
      arrayOfInt1[j] = arrayOfInt1[j] + arrayOfInt1[j - 1]; 
    for (j = 0; j < paramInt; j++) {
      int n = paramArrayOfbyte[j] & 0xFF;
      int i1 = arrayOfInt1[n] - 1;
      arrayOfInt1[n] = i1;
      paramArrayOfint[i1] = j;
    } 
    int m = 64 + paramInt;
    BitSet bitSet = new BitSet(m);
    for (j = 0; j < 256; j++)
      bitSet.set(arrayOfInt1[j]); 
    for (j = 0; j < 32; j++) {
      bitSet.set(paramInt + 2 * j);
      bitSet.clear(paramInt + 2 * j + 1);
    } 
    int i = 1;
    do {
      int n = 0;
      for (j = 0; j < paramInt; j++) {
        if (bitSet.get(j))
          n = j; 
        int i2 = paramArrayOfint[j] - i;
        if (i2 < 0)
          i2 += paramInt; 
        arrayOfInt2[i2] = n;
      } 
      k = 0;
      int i1 = -1;
      while (true) {
        int i2 = i1 + 1;
        i2 = bitSet.nextClearBit(i2);
        int i3 = i2 - 1;
        if (i3 >= paramInt)
          break; 
        i2 = bitSet.nextSetBit(i2 + 1);
        i1 = i2 - 1;
        if (i1 >= paramInt)
          break; 
        if (i1 > i3) {
          k += i1 - i3 + 1;
          b(paramArrayOfint, arrayOfInt2, i3, i1);
          int i4 = -1;
          for (j = i3; j <= i1; j++) {
            int i5 = arrayOfInt2[paramArrayOfint[j]];
            if (i4 != i5) {
              bitSet.set(j);
              i4 = i5;
            } 
          } 
        } 
      } 
      i *= 2;
    } while (i <= paramInt && k != 0);
  }
  
  private boolean a(b.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = paramInt2 - paramInt1 + 1;
    if (i < 2)
      return (this.f && this.d > this.e); 
    byte b;
    for (b = 0; q[b] < i; b++);
    int[] arrayOfInt = parama.r;
    char[] arrayOfChar = this.n;
    byte[] arrayOfByte = parama.q;
    int j = paramInt4 + 1;
    boolean bool = this.f;
    int k = this.e;
    int m = this.d;
    label96: while (--b >= 0) {
      int n = q[b];
      int i1 = paramInt1 + n - 1;
      int i2 = paramInt1 + n;
      while (i2 <= paramInt2) {
        byte b1 = 3;
        while (i2 <= paramInt2 && --b1 >= 0) {
          int i3 = arrayOfInt[i2];
          int i4 = i3 + paramInt3;
          int i5 = i2;
          boolean bool1 = false;
          int i6 = 0;
          while (true) {
            if (bool1) {
              arrayOfInt[i5] = i6;
              if ((i5 -= n) <= i1)
                break; 
            } else {
              bool1 = true;
            } 
            i6 = arrayOfInt[i5 - n];
            int i7 = i6 + paramInt3;
            int i8 = i4;
            if (arrayOfByte[i7 + 1] == arrayOfByte[i8 + 1]) {
              if (arrayOfByte[i7 + 2] == arrayOfByte[i8 + 2]) {
                if (arrayOfByte[i7 + 3] == arrayOfByte[i8 + 3]) {
                  if (arrayOfByte[i7 + 4] == arrayOfByte[i8 + 4]) {
                    if (arrayOfByte[i7 + 5] == arrayOfByte[i8 + 5]) {
                      i7 += 6;
                      i8 += 6;
                      if (arrayOfByte[i7] == arrayOfByte[i8]) {
                        int i9 = paramInt4;
                        while (i9 > 0) {
                          i9 -= 4;
                          if (arrayOfByte[i7 + 1] == arrayOfByte[i8 + 1]) {
                            if (arrayOfChar[i7] == arrayOfChar[i8]) {
                              if (arrayOfByte[i7 + 2] == arrayOfByte[i8 + 2]) {
                                if (arrayOfChar[i7 + 1] == arrayOfChar[i8 + 1]) {
                                  if (arrayOfByte[i7 + 3] == arrayOfByte[i8 + 3]) {
                                    if (arrayOfChar[i7 + 2] == arrayOfChar[i8 + 2]) {
                                      if (arrayOfByte[i7 + 4] == arrayOfByte[i8 + 4]) {
                                        if (arrayOfChar[i7 + 3] == arrayOfChar[i8 + 3]) {
                                          i7 += 4;
                                          if (i7 >= j)
                                            i7 -= j; 
                                          i8 += 4;
                                          if (i8 >= j)
                                            i8 -= j; 
                                          m++;
                                          continue;
                                        } 
                                        if (arrayOfChar[i7 + 3] > arrayOfChar[i8 + 3])
                                          continue; 
                                        break;
                                      } 
                                      if ((arrayOfByte[i7 + 4] & 0xFF) > (arrayOfByte[i8 + 4] & 0xFF))
                                        continue; 
                                      break;
                                    } 
                                    if (arrayOfChar[i7 + 2] > arrayOfChar[i8 + 2])
                                      continue; 
                                    break;
                                  } 
                                  if ((arrayOfByte[i7 + 3] & 0xFF) > (arrayOfByte[i8 + 3] & 0xFF))
                                    continue; 
                                  break;
                                } 
                                if (arrayOfChar[i7 + 1] > arrayOfChar[i8 + 1])
                                  continue; 
                                break;
                              } 
                              if ((arrayOfByte[i7 + 2] & 0xFF) > (arrayOfByte[i8 + 2] & 0xFF))
                                continue; 
                              break;
                            } 
                            if (arrayOfChar[i7] > arrayOfChar[i8])
                              continue; 
                            break;
                          } 
                          if ((arrayOfByte[i7 + 1] & 0xFF) > (arrayOfByte[i8 + 1] & 0xFF));
                        } 
                        break;
                      } 
                      if ((arrayOfByte[i7] & 0xFF) > (arrayOfByte[i8] & 0xFF))
                        continue; 
                      break;
                    } 
                    if ((arrayOfByte[i7 + 5] & 0xFF) > (arrayOfByte[i8 + 5] & 0xFF))
                      continue; 
                    break;
                  } 
                  if ((arrayOfByte[i7 + 4] & 0xFF) > (arrayOfByte[i8 + 4] & 0xFF))
                    continue; 
                  break;
                } 
                if ((arrayOfByte[i7 + 3] & 0xFF) > (arrayOfByte[i8 + 3] & 0xFF))
                  continue; 
                break;
              } 
              if ((arrayOfByte[i7 + 2] & 0xFF) > (arrayOfByte[i8 + 2] & 0xFF))
                continue; 
              break;
            } 
            if ((arrayOfByte[i7 + 1] & 0xFF) > (arrayOfByte[i8 + 1] & 0xFF))
              continue; 
            break;
          } 
          arrayOfInt[i5] = i3;
          i2++;
        } 
        if (bool && i2 <= paramInt2 && m > k)
          break label96; 
      } 
    } 
    this.d = m;
    return (bool && m > k);
  }
  
  private static void b(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    paramInt3 += paramInt1;
    while (paramInt1 < paramInt3) {
      int i = paramArrayOfint[paramInt1];
      paramArrayOfint[paramInt1++] = paramArrayOfint[paramInt2];
      paramArrayOfint[paramInt2++] = i;
    } 
  }
  
  private static byte a(byte paramByte1, byte paramByte2, byte paramByte3) {
    return (paramByte1 < paramByte2) ? ((paramByte2 < paramByte3) ? paramByte2 : ((paramByte1 < paramByte3) ? paramByte3 : paramByte1)) : ((paramByte2 > paramByte3) ? paramByte2 : ((paramByte1 > paramByte3) ? paramByte3 : paramByte1));
  }
  
  private void b(b.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int[] arrayOfInt1 = this.g;
    int[] arrayOfInt2 = this.h;
    int[] arrayOfInt3 = this.i;
    int[] arrayOfInt4 = parama.r;
    byte[] arrayOfByte = parama.q;
    arrayOfInt1[0] = paramInt1;
    arrayOfInt2[0] = paramInt2;
    arrayOfInt3[0] = paramInt3;
    for (byte b = 1; --b >= 0; b++) {
      int i = arrayOfInt1[b];
      int j = arrayOfInt2[b];
      int k = arrayOfInt3[b];
      if (j - i < 20 || k > 10) {
        if (a(parama, i, j, k, paramInt4))
          return; 
        continue;
      } 
      int m = k + 1;
      int n = a(arrayOfByte[arrayOfInt4[i] + m], arrayOfByte[arrayOfInt4[j] + m], arrayOfByte[arrayOfInt4[i + j >>> 1] + m]) & 0xFF;
      int i1 = i;
      int i2 = j;
      int i3 = i;
      int i4 = j;
      while (true) {
        if (i1 <= i2) {
          int i8 = (arrayOfByte[arrayOfInt4[i1] + m] & 0xFF) - n;
          if (i8 == 0) {
            int i9 = arrayOfInt4[i1];
            arrayOfInt4[i1++] = arrayOfInt4[i3];
            arrayOfInt4[i3++] = i9;
            continue;
          } 
          if (i8 < 0) {
            i1++;
            continue;
          } 
        } 
        while (i1 <= i2) {
          int i8 = (arrayOfByte[arrayOfInt4[i2] + m] & 0xFF) - n;
          if (i8 == 0) {
            int i9 = arrayOfInt4[i2];
            arrayOfInt4[i2--] = arrayOfInt4[i4];
            arrayOfInt4[i4--] = i9;
            continue;
          } 
          if (i8 > 0)
            i2--; 
        } 
        if (i1 <= i2) {
          int i8 = arrayOfInt4[i1];
          arrayOfInt4[i1++] = arrayOfInt4[i2];
          arrayOfInt4[i2--] = i8;
          continue;
        } 
        if (i4 < i3) {
          arrayOfInt1[b] = i;
          arrayOfInt2[b] = j;
          arrayOfInt3[b] = m;
          b++;
          continue;
        } 
        int i7 = (i3 - i < i1 - i3) ? (i3 - i) : (i1 - i3);
        b(arrayOfInt4, i, i1 - i7, i7);
        if (j - i4 < i4 - i2);
        break;
      } 
      int i6 = i4 - i2;
      b(arrayOfInt4, i1, j - i6 + 1, i6);
      int i5 = i + i1 - i3 - 1;
      i6 = j - i4 - i2 + 1;
      arrayOfInt1[b] = i;
      arrayOfInt2[b] = i5;
      arrayOfInt3[b] = k;
      arrayOfInt1[++b] = i5 + 1;
      arrayOfInt2[b] = i6 - 1;
      arrayOfInt3[b] = m;
      arrayOfInt1[++b] = i6;
      arrayOfInt2[b] = j;
      arrayOfInt3[b] = k;
    } 
  }
  
  final void c(b.a parama, int paramInt) {
    int[] arrayOfInt1 = this.j;
    int[] arrayOfInt2 = this.k;
    boolean[] arrayOfBoolean = this.l;
    int[] arrayOfInt3 = this.m;
    byte[] arrayOfByte = parama.q;
    int[] arrayOfInt4 = parama.r;
    char[] arrayOfChar = this.n;
    int i = this.e;
    boolean bool = this.f;
    int j = 65537;
    while (--j >= 0)
      arrayOfInt3[j] = 0; 
    for (j = 0; j < 20; j++)
      arrayOfByte[paramInt + j + 2] = arrayOfByte[j % (paramInt + 1) + 1]; 
    j = paramInt + 20 + 1;
    while (--j >= 0)
      arrayOfChar[j] = Character.MIN_VALUE; 
    arrayOfByte[0] = arrayOfByte[paramInt + 1];
    j = arrayOfByte[0] & 0xFF;
    int k;
    for (k = 0; k <= paramInt; k++) {
      int m = arrayOfByte[k + 1] & 0xFF;
      arrayOfInt3[(j << 8) + m] = arrayOfInt3[(j << 8) + m] + 1;
      j = m;
    } 
    for (k = 1; k <= 65536; k++)
      arrayOfInt3[k] = arrayOfInt3[k] + arrayOfInt3[k - 1]; 
    j = arrayOfByte[1] & 0xFF;
    for (k = 0; k < paramInt; k++) {
      int m = arrayOfByte[k + 2] & 0xFF;
      arrayOfInt3[(j << 8) + m] = arrayOfInt3[(j << 8) + m] - 1;
      arrayOfInt4[arrayOfInt3[(j << 8) + m] - 1] = k;
      j = m;
    } 
    arrayOfInt3[((arrayOfByte[paramInt + 1] & 0xFF) << 8) + (arrayOfByte[1] & 0xFF)] = arrayOfInt3[((arrayOfByte[paramInt + 1] & 0xFF) << 8) + (arrayOfByte[1] & 0xFF)] - 1;
    arrayOfInt4[arrayOfInt3[((arrayOfByte[paramInt + 1] & 0xFF) << 8) + (arrayOfByte[1] & 0xFF)] - 1] = paramInt;
    k = 256;
    while (--k >= 0) {
      arrayOfBoolean[k] = false;
      arrayOfInt1[k] = k;
    } 
    k = 364;
    while (k != 1) {
      k /= 3;
      for (int m = k; m <= 255; m++) {
        int n = arrayOfInt1[m];
        int i1 = arrayOfInt3[n + 1 << 8] - arrayOfInt3[n << 8];
        int i2 = k - 1;
        int i3 = m;
        int i4;
        for (i4 = arrayOfInt1[i3 - k]; arrayOfInt3[i4 + 1 << 8] - arrayOfInt3[i4 << 8] > i1; i4 = arrayOfInt1[i3 - k]) {
          arrayOfInt1[i3] = i4;
          i3 -= k;
          if (i3 <= i2)
            break; 
        } 
        arrayOfInt1[i3] = n;
      } 
    } 
    for (k = 0; k <= 255; k++) {
      int m = arrayOfInt1[k];
      int n;
      for (n = 0; n <= 255; n++) {
        int i2 = (m << 8) + n;
        int i3 = arrayOfInt3[i2];
        if ((i3 & 0x200000) != 2097152) {
          int i4 = i3 & 0xFFDFFFFF;
          int i5 = (arrayOfInt3[i2 + 1] & 0xFFDFFFFF) - 1;
          if (i5 > i4) {
            b(parama, i4, i5, 2, paramInt);
            if (bool && this.d > i)
              return; 
          } 
          arrayOfInt3[i2] = i3 | 0x200000;
        } 
      } 
      for (n = 0; n <= 255; n++)
        arrayOfInt2[n] = arrayOfInt3[(n << 8) + m] & 0xFFDFFFFF; 
      n = arrayOfInt3[m << 8] & 0xFFDFFFFF;
      int i1 = arrayOfInt3[m + 1 << 8] & 0xFFDFFFFF;
      while (n < i1) {
        int i2 = arrayOfInt4[n];
        j = arrayOfByte[i2] & 0xFF;
        if (!arrayOfBoolean[j]) {
          arrayOfInt4[arrayOfInt2[j]] = (i2 == 0) ? paramInt : (i2 - 1);
          arrayOfInt2[j] = arrayOfInt2[j] + 1;
        } 
        n++;
      } 
      n = 256;
      while (--n >= 0)
        arrayOfInt3[(n << 8) + m] = arrayOfInt3[(n << 8) + m] | 0x200000; 
      arrayOfBoolean[m] = true;
      if (k < 255) {
        n = arrayOfInt3[m << 8] & 0xFFDFFFFF;
        i1 = (arrayOfInt3[m + 1 << 8] & 0xFFDFFFFF) - n;
        byte b1;
        for (b1 = 0; i1 >> b1 > 65534; b1++);
        for (byte b2 = 0; b2 < i1; b2++) {
          int i2 = arrayOfInt4[n + b2];
          char c = (char)(b2 >> b1);
          arrayOfChar[i2] = c;
          if (i2 < 20)
            arrayOfChar[i2 + paramInt + 1] = c; 
        } 
      } 
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/a/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */