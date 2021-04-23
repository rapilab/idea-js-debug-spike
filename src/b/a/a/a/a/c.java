package b.a.a.a.a;

import java.io.IOException;
import java.io.InputStream;

public abstract class c extends InputStream {
  private final byte[] a = new byte[1];
  
  private static final int b = 255;
  
  private long c = 0L;
  
  public abstract a a() throws IOException;
  
  public int read() throws IOException {
    int i = read(this.a, 0, 1);
    return (i == -1) ? -1 : (this.a[0] & 0xFF);
  }
  
  protected void a(int paramInt) {
    a(paramInt);
  }
  
  protected void a(long paramLong) {
    if (paramLong != -1L)
      this.c += paramLong; 
  }
  
  protected void b(long paramLong) {
    this.c -= paramLong;
  }
  
  public int b() {
    return (int)this.c;
  }
  
  public long c() {
    return this.c;
  }
  
  public boolean a(a parama) {
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */