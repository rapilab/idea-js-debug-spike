package b.a.a.a.c.h.a;

import b.a.a.a.c.b;
import java.io.IOException;
import java.io.InputStream;

public abstract class a extends b {
  private final byte[] j = new byte[1];
  
  protected final InputStream a;
  
  protected int b = -1;
  
  protected int c = 9;
  
  protected int d = 0;
  
  protected int e = 0;
  
  protected int f = -1;
  
  protected int g = 0;
  
  protected int[] h;
  
  protected byte[] i;
  
  private byte[] k;
  
  private int l;
  
  protected a(InputStream paramInputStream) {
    this.a = paramInputStream;
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public int read() throws IOException {
    int i = read(this.j);
    return (i < 0) ? i : (0xFF & this.j[0]);
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    int i;
    for (i = a(arrayOfByte, off, len); len - i > 0; i += a(arrayOfByte, off + i, len - i)) {
      int j = a();
      if (j < 0) {
        if (i > 0) {
          a(i);
          return i;
        } 
        return j;
      } 
    } 
    a(i);
    return i;
  }
  
  protected abstract int a() throws IOException;
  
  protected abstract int a(int paramInt, byte paramByte) throws IOException;
  
  protected void b(int paramInt) {
    this.b = 1 << paramInt - 1;
  }
  
  protected void c(int paramInt) {
    int i = 1 << paramInt;
    this.h = new int[i];
    this.i = new byte[i];
    this.k = new byte[i];
    this.l = i;
    char c = 'Ā';
    for (byte b1 = 0; b1 < 'Ā'; b1++) {
      this.h[b1] = -1;
      this.i[b1] = (byte)b1;
    } 
  }
  
  protected int d() throws IOException {
    while (this.e < this.c) {
      int k = this.a.read();
      if (k < 0)
        return k; 
      this.d |= k << this.e;
      this.e += 8;
    } 
    int i = (1 << this.c) - 1;
    int j = this.d & i;
    this.d >>>= this.c;
    this.e -= this.c;
    return j;
  }
  
  protected int a(int paramInt1, byte paramByte, int paramInt2) {
    if (this.g < paramInt2) {
      int i = this.g;
      this.h[this.g] = paramInt1;
      this.i[this.g] = paramByte;
      this.g++;
      return i;
    } 
    return -1;
  }
  
  protected int e() throws IOException {
    if (this.f == -1)
      throw new IOException("The first code can't be a reference to its preceding code"); 
    byte b1 = 0;
    for (int i = this.f; i >= 0; i = this.h[i])
      b1 = this.i[i]; 
    return a(this.f, b1);
  }
  
  protected int a(int paramInt, boolean paramBoolean) throws IOException {
    for (int i = paramInt; i >= 0; i = this.h[i])
      this.k[--this.l] = this.i[i]; 
    if (this.f != -1 && !paramBoolean)
      a(this.f, this.k[this.l]); 
    this.f = paramInt;
    return this.l;
  }
  
  private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = this.k.length - this.l;
    if (i > 0) {
      int j = Math.min(i, paramInt2);
      System.arraycopy(this.k, this.l, paramArrayOfbyte, paramInt1, j);
      this.l += j;
      return j;
    } 
    return 0;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/h/a/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */