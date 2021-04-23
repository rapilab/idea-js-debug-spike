package b.a.a.a.a.h;

import b.a.a.a.c.h.a.a;
import java.io.IOException;
import java.io.InputStream;

class r extends a {
  private static final int j = 13;
  
  private static final int k = 8192;
  
  private final boolean[] l;
  
  public r(InputStream paramInputStream) throws IOException {
    super(paramInputStream);
    b(this.c);
    c(13);
    this.l = new boolean[this.h.length];
    for (byte b = 0; b < 'Ā'; b++)
      this.l[b] = true; 
    this.g = this.b + 1;
  }
  
  protected int a(int paramInt, byte paramByte) throws IOException {
    while (this.g < 8192 && this.l[this.g])
      this.g++; 
    int i = a(paramInt, paramByte, 8192);
    if (i >= 0)
      this.l[i] = true; 
    return i;
  }
  
  private void f() {
    boolean[] arrayOfBoolean = new boolean[8192];
    int i;
    for (i = 0; i < this.l.length; i++) {
      if (this.l[i] && this.h[i] != -1)
        arrayOfBoolean[this.h[i]] = true; 
    } 
    for (i = this.b + 1; i < arrayOfBoolean.length; i++) {
      if (!arrayOfBoolean[i]) {
        this.l[i] = false;
        this.h[i] = -1;
      } 
    } 
  }
  
  protected int a() throws IOException {
    int i = d();
    if (i < 0)
      return -1; 
    if (i == this.b) {
      int k = d();
      if (k < 0)
        throw new IOException("Unexpected EOF;"); 
      if (k == 1) {
        if (this.c < 13) {
          this.c++;
        } else {
          throw new IOException("Attempt to increase code size beyond maximum");
        } 
      } else if (k == 2) {
        f();
        this.g = this.b + 1;
      } else {
        throw new IOException("Invalid clear code subcode " + k);
      } 
      return 0;
    } 
    boolean bool = false;
    int j = i;
    if (!this.l[i]) {
      j = e();
      bool = true;
    } 
    return a(j, bool);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/r.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */