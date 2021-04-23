package b.b.g;

import b.b.c.b;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class c {
  public static CodingErrorAction a = CodingErrorAction.REPORT;
  
  public static byte[] a(String paramString) {
    try {
      return paramString.getBytes("UTF8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static byte[] b(String paramString) {
    try {
      return paramString.getBytes("ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return new String(paramArrayOfbyte, paramInt1, paramInt2, "ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static String b(byte[] paramArrayOfbyte) throws b {
    return a(ByteBuffer.wrap(paramArrayOfbyte));
  }
  
  public static String a(ByteBuffer paramByteBuffer) throws b {
    String str;
    CharsetDecoder charsetDecoder = Charset.forName("UTF8").newDecoder();
    charsetDecoder.onMalformedInput(a);
    charsetDecoder.onUnmappableCharacter(a);
    try {
      paramByteBuffer.mark();
      str = charsetDecoder.decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
    } catch (CharacterCodingException characterCodingException) {
      throw new b(1007, characterCodingException);
    } 
    return str;
  }
  
  public static void a(String[] paramArrayOfString) throws b {
    b(a("\000"));
    a(b("\000"));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/g/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */