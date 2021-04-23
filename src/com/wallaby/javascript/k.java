package com.wallaby.javascript;

import com.intellij.CommonBundle;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

public class k {
  private static final String a = "messages.WallabyBundle";
  
  private static Reference<ResourceBundle> b;
  
  public static String a(String paramString, Object... paramVarArgs) {
    return CommonBundle.message(a(), paramString, paramVarArgs);
  }
  
  private static ResourceBundle a() {
    ResourceBundle resourceBundle = null;
    if (b != null)
      resourceBundle = b.get(); 
    if (resourceBundle == null) {
      resourceBundle = ResourceBundle.getBundle("messages.WallabyBundle");
      b = new SoftReference<>(resourceBundle);
    } 
    return resourceBundle;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */