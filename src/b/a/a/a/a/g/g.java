package b.a.a.a.a.g;

import b.a.a.a.a.h.D;
import java.nio.ByteBuffer;

final class g implements D {
  public boolean a(String paramString) {
    return true;
  }
  
  public ByteBuffer b(String paramString) {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i];
    for (byte b = 0; b < i; b++)
      arrayOfByte[b] = (byte)paramString.charAt(b); 
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public String a(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    StringBuilder stringBuilder = new StringBuilder(i);
    for (byte b = 0; b < i; b++) {
      byte b1 = paramArrayOfbyte[b];
      if (b1 == 0)
        break; 
      stringBuilder.append((char)(b1 & 0xFF));
    } 
    return stringBuilder.toString();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/g/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */