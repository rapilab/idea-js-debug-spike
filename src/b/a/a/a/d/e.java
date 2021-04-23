package b.a.a.a.d;

import java.nio.charset.Charset;

public class e {
  public static final Charset a = Charset.forName("ISO-8859-1");
  
  public static final Charset b = Charset.forName("US-ASCII");
  
  public static final Charset c = Charset.forName("UTF-16");
  
  public static final Charset d = Charset.forName("UTF-16BE");
  
  public static final Charset e = Charset.forName("UTF-16LE");
  
  public static final Charset f = Charset.forName("UTF-8");
  
  public static Charset a(Charset paramCharset) {
    return (paramCharset == null) ? Charset.defaultCharset() : paramCharset;
  }
  
  public static Charset a(String paramString) {
    return (paramString == null) ? Charset.defaultCharset() : Charset.forName(paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/d/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */