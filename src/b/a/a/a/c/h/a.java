package b.a.a.a.c.h;

import b.a.a.a.c.h.a.a;
import java.io.IOException;
import java.io.InputStream;

public class a extends a {
  private static final int j = 31;
  
  private static final int k = 157;
  
  private static final int l = 128;
  
  private static final int m = 31;
  
  private final boolean n;
  
  private final int o;
  
  private long p = 0L;
  
  public a(InputStream paramInputStream) throws IOException {
    super(paramInputStream);
    int i = this.a.read();
    int j = this.a.read();
    int k = this.a.read();
    if (i != 31 || j != 157 || k < 0)
      throw new IOException("Input is not in .Z format"); 
    this.n = ((k & 0x80) != 0);
    this.o = k & 0x1F;
    if (this.n)
      b(this.c); 
    c(this.o);
    f();
  }
  
  private void f() {
    this.g = 256;
    if (this.n)
      this.g++; 
  }
  
  protected int d() throws IOException {
    int i = super.d();
    if (i >= 0)
      this.p++; 
    return i;
  }
  
  private void g() throws IOException {
    long l1 = 8L - this.p % 8L;
    if (l1 == 8L)
      l1 = 0L; 
    for (long l2 = 0L; l2 < l1; l2++)
      d(); 
    this.d = 0;
    this.e = 0;
  }
  
  protected int a(int paramInt, byte paramByte) throws IOException {
    int i = 1 << this.c;
    int j = a(paramInt, paramByte, i);
    if (this.g == i && this.c < this.o) {
      g();
      this.c++;
    } 
    return j;
  }
  
  protected int a() throws IOException {
    int i = d();
    if (i < 0)
      return -1; 
    if (this.n && i == this.b) {
      f();
      g();
      this.c = 9;
      this.f = -1;
      return 0;
    } 
    boolean bool = false;
    if (i == this.g) {
      e();
      bool = true;
    } else if (i > this.g) {
      throw new IOException(String.format("Invalid %d bit code 0x%x", new Object[] { Integer.valueOf(this.c), Integer.valueOf(i) }));
    } 
    return a(i, bool);
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt > 3 && paramArrayOfbyte[0] == 31 && paramArrayOfbyte[1] == -99);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/h/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */