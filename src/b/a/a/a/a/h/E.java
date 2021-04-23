package b.a.a.a.a.h;

import b.a.a.a.d.e;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class E {
  private static final Map<String, a> c;
  
  private static final byte[] d = new byte[] { 
      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
      65, 66, 67, 68, 69, 70 };
  
  static final String a = "UTF8";
  
  static final D b = new h("UTF8");
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt) {
    paramByteBuffer.limit(paramByteBuffer.position());
    paramByteBuffer.rewind();
    int i = paramByteBuffer.capacity() * 2;
    ByteBuffer byteBuffer = ByteBuffer.allocate((i < paramInt) ? paramInt : i);
    byteBuffer.put(paramByteBuffer);
    return byteBuffer;
  }
  
  static void a(ByteBuffer paramByteBuffer, char paramChar) {
    paramByteBuffer.put((byte)37);
    paramByteBuffer.put((byte)85);
    paramByteBuffer.put(d[paramChar >> 12 & 0xF]);
    paramByteBuffer.put(d[paramChar >> 8 & 0xF]);
    paramByteBuffer.put(d[paramChar >> 4 & 0xF]);
    paramByteBuffer.put(d[paramChar & 0xF]);
  }
  
  public static D a(String paramString) {
    if (b(paramString))
      return b; 
    if (paramString == null)
      return new h(); 
    a a = c.get(paramString);
    if (a != null)
      return a.a(); 
    try {
      Charset charset = Charset.forName(paramString);
      return new k(charset);
    } catch (UnsupportedCharsetException unsupportedCharsetException) {
      return new h(paramString);
    } 
  }
  
  static boolean b(String paramString) {
    if (paramString == null)
      paramString = System.getProperty("file.encoding"); 
    if (e.f.name().equalsIgnoreCase(paramString))
      return true; 
    for (String str : e.f.aliases()) {
      if (str.equalsIgnoreCase(paramString))
        return true; 
    } 
    return false;
  }
  
  static {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    char[] arrayOfChar1 = { 
        'Ç', 'ü', 'é', 'â', 'ä', 'à', 'å', 'ç', 'ê', 'ë', 
        'è', 'ï', 'î', 'ì', 'Ä', 'Å', 'É', 'æ', 'Æ', 'ô', 
        'ö', 'ò', 'û', 'ù', 'ÿ', 'Ö', 'Ü', '¢', '£', '¥', 
        '₧', 'ƒ', 'á', 'í', 'ó', 'ú', 'ñ', 'Ñ', 'ª', 'º', 
        '¿', '⌐', '¬', '½', '¼', '¡', '«', '»', '░', '▒', 
        '▓', '│', '┤', '╡', '╢', '╖', '╕', '╣', '║', '╗', 
        '╝', '╜', '╛', '┐', '└', '┴', '┬', '├', '─', '┼', 
        '╞', '╟', '╚', '╔', '╩', '╦', '╠', '═', '╬', '╧', 
        '╨', '╤', '╥', '╙', '╘', '╒', '╓', '╫', '╪', '┘', 
        '┌', '█', '▄', '▌', '▐', '▀', 'α', 'ß', 'Γ', 'π', 
        'Σ', 'σ', 'µ', 'τ', 'Φ', 'Θ', 'Ω', 'δ', '∞', 'φ', 
        'ε', '∩', '≡', '±', '≥', '≤', '⌠', '⌡', '÷', '≈', 
        '°', '∙', '·', '√', 'ⁿ', '²', '■', ' ' };
    a a1 = new a(arrayOfChar1);
    hashMap.put("CP437", a1);
    hashMap.put("Cp437", a1);
    hashMap.put("cp437", a1);
    hashMap.put("IBM437", a1);
    hashMap.put("ibm437", a1);
    char[] arrayOfChar2 = { 
        'Ç', 'ü', 'é', 'â', 'ä', 'à', 'å', 'ç', 'ê', 'ë', 
        'è', 'ï', 'î', 'ì', 'Ä', 'Å', 'É', 'æ', 'Æ', 'ô', 
        'ö', 'ò', 'û', 'ù', 'ÿ', 'Ö', 'Ü', 'ø', '£', 'Ø', 
        '×', 'ƒ', 'á', 'í', 'ó', 'ú', 'ñ', 'Ñ', 'ª', 'º', 
        '¿', '®', '¬', '½', '¼', '¡', '«', '»', '░', '▒', 
        '▓', '│', '┤', 'Á', 'Â', 'À', '©', '╣', '║', '╗', 
        '╝', '¢', '¥', '┐', '└', '┴', '┬', '├', '─', '┼', 
        'ã', 'Ã', '╚', '╔', '╩', '╦', '╠', '═', '╬', '¤', 
        'ð', 'Ð', 'Ê', 'Ë', 'È', 'ı', 'Í', 'Î', 'Ï', '┘', 
        '┌', '█', '▄', '¦', 'Ì', '▀', 'Ó', 'ß', 'Ô', 'Ò', 
        'õ', 'Õ', 'µ', 'þ', 'Þ', 'Ú', 'Û', 'Ù', 'ý', 'Ý', 
        '¯', '´', '­', '±', '‗', '¾', '¶', '§', '÷', '¸', 
        '°', '¨', '·', '¹', '³', '²', '■', ' ' };
    a a2 = new a(arrayOfChar2);
    hashMap.put("CP850", a2);
    hashMap.put("Cp850", a2);
    hashMap.put("cp850", a2);
    hashMap.put("IBM850", a2);
    hashMap.put("ibm850", a2);
    c = Collections.unmodifiableMap(hashMap);
  }
  
  private static class a {
    private final char[] a;
    
    private l b;
    
    a(char[] param1ArrayOfchar) {
      this.a = param1ArrayOfchar;
    }
    
    public synchronized l a() {
      if (this.b == null)
        this.b = new l(this.a); 
      return this.b;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/E.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */