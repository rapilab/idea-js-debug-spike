package b.a.a.a.a.h;

import java.util.zip.ZipException;

public class x extends ZipException {
  private static final long c = 20110809L;
  
  static final String a = "archive's size exceeds the limit of 4GByte.";
  
  static final String b = "archive contains more than 65535 entries.";
  
  static String a(y paramy) {
    return paramy.getName() + "'s size exceeds the limit of 4GByte.";
  }
  
  public x(String paramString) {
    super(paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/x.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */