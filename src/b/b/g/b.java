package b.b.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

final class b extends ObjectInputStream {
  b(InputStream paramInputStream, ClassLoader paramClassLoader) {
    super(paramInputStream);
  }
  
  public Class<?> resolveClass(ObjectStreamClass streamClass) throws IOException, ClassNotFoundException {
    Class<?> clazz = Class.forName(streamClass.getName(), false, this.a);
    return (clazz == null) ? super.resolveClass(streamClass) : clazz;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/g/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */