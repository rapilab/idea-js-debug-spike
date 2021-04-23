package b.a.a.a.d;

import java.io.UnsupportedEncodingException;

public class a {
  public static String a(b.a.a.a.a.a parama) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.isDirectory() ? 100 : 45);
    String str = Long.toString(parama.getSize());
    stringBuilder.append(' ');
    for (byte b = 7; b > str.length(); b--)
      stringBuilder.append(' '); 
    stringBuilder.append(str);
    stringBuilder.append(' ').append(parama.getName());
    return stringBuilder.toString();
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte[] arrayOfByte;
    try {
      arrayOfByte = paramString.getBytes("US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
    return a(arrayOfByte, 0, arrayOfByte.length, paramArrayOfbyte, paramInt1, paramInt2, false);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfbyte) {
    return a(paramString, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static byte[] a(String paramString) {
    try {
      return paramString.getBytes("US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    try {
      return new String(paramArrayOfbyte, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return new String(paramArrayOfbyte, paramInt1, paramInt2, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static boolean a(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4, boolean paramBoolean) {
    int i = (paramInt2 < paramInt4) ? paramInt2 : paramInt4;
    int j;
    for (j = 0; j < i; j++) {
      if (paramArrayOfbyte1[paramInt1 + j] != paramArrayOfbyte2[paramInt3 + j])
        return false; 
    } 
    if (paramInt2 == paramInt4)
      return true; 
    if (paramBoolean) {
      if (paramInt2 > paramInt4) {
        for (j = paramInt4; j < paramInt2; j++) {
          if (paramArrayOfbyte1[paramInt1 + j] != 0)
            return false; 
        } 
      } else {
        for (j = paramInt2; j < paramInt4; j++) {
          if (paramArrayOfbyte2[paramInt3 + j] != 0)
            return false; 
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
    return a(paramArrayOfbyte1, paramInt1, paramInt2, paramArrayOfbyte2, paramInt3, paramInt4, false);
  }
  
  public static boolean a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    return a(paramArrayOfbyte1, 0, paramArrayOfbyte1.length, paramArrayOfbyte2, 0, paramArrayOfbyte2.length, false);
  }
  
  public static boolean a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, boolean paramBoolean) {
    return a(paramArrayOfbyte1, 0, paramArrayOfbyte1.length, paramArrayOfbyte2, 0, paramArrayOfbyte2.length, paramBoolean);
  }
  
  public static boolean b(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
    return a(paramArrayOfbyte1, paramInt1, paramInt2, paramArrayOfbyte2, paramInt3, paramInt4, true);
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    for (byte b = 0; b < paramInt; b++) {
      if (paramArrayOfbyte[b] != 0)
        return false; 
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */