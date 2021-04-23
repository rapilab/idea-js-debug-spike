package b.a.a.a.a;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public abstract class d extends OutputStream {
  private final byte[] b = new byte[1];
  
  static final int a = 255;
  
  private long c = 0L;
  
  public abstract void a(a parama) throws IOException;
  
  public abstract void a() throws IOException;
  
  public abstract void b() throws IOException;
  
  public abstract a a(File paramFile, String paramString) throws IOException;
  
  public void write(int b) throws IOException {
    this.b[0] = (byte)(b & 0xFF);
    write(this.b, 0, 1);
  }
  
  protected void a(int paramInt) {
    a(paramInt);
  }
  
  protected void a(long paramLong) {
    if (paramLong != -1L)
      this.c += paramLong; 
  }
  
  public int c() {
    return (int)this.c;
  }
  
  public long d() {
    return this.c;
  }
  
  public boolean b(a parama) {
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */