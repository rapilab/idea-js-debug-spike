package b.a.a.a.a.f;

import java.util.Arrays;

public enum t {
  a(new byte[] { 0 }),
  b(new byte[] { 3, 1, 1 }),
  c(new byte[] { 33 }),
  d(new byte[] { 4, 1, 8 }),
  e(new byte[] { 4, 2, 2 }),
  f(new byte[] { 6, -15, 7, 1 }),
  g(new byte[] { 3, 3, 1, 3 }),
  h(new byte[] { 3, 3, 2, 5 }),
  i(new byte[] { 3, 3, 4, 1 }),
  j(new byte[] { 3, 3, 5, 1 }),
  k(new byte[] { 3, 3, 7, 1 }),
  l(new byte[] { 3, 3, 8, 5 }),
  m(new byte[] { 3 });
  
  private final byte[] n;
  
  public static t[] a() {
    return (t[])o.clone();
  }
  
  public static t a(String paramString) {
    return Enum.<t>valueOf(t.class, paramString);
  }
  
  t(byte[] paramArrayOfbyte) {
    this.n = paramArrayOfbyte;
  }
  
  byte[] b() {
    byte[] arrayOfByte = new byte[this.n.length];
    System.arraycopy(this.n, 0, arrayOfByte, 0, this.n.length);
    return arrayOfByte;
  }
  
  static t a(byte[] paramArrayOfbyte) {
    for (t t1 : (t[])t.class.getEnumConstants()) {
      if (Arrays.equals(t1.n, paramArrayOfbyte))
        return t1; 
    } 
    return null;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/t.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */