package b.a.a.a.a.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class j {
  private final Class<?>[] a;
  
  private static final byte[] b = new byte[0];
  
  protected j(Class<?>... paramVarArgs) {
    this.a = paramVarArgs;
  }
  
  boolean a(Object paramObject) {
    for (Class<?> clazz : this.a) {
      if (clazz.isInstance(paramObject))
        return true; 
    } 
    return false;
  }
  
  byte[] b(Object paramObject) {
    return b;
  }
  
  Object a(i parami, InputStream paramInputStream) {
    return null;
  }
  
  abstract InputStream a(InputStream paramInputStream, long paramLong, i parami, byte[] paramArrayOfbyte) throws IOException;
  
  OutputStream a(OutputStream paramOutputStream, Object paramObject) throws IOException {
    throw new UnsupportedOperationException("method doesn't support writing");
  }
  
  protected static int a(Object paramObject, int paramInt) {
    return (paramObject instanceof Number) ? ((Number)paramObject).intValue() : paramInt;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */