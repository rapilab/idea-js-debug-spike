package com.wallaby.javascript.c;

import com.intellij.util.ArrayUtil;
import java.io.File;
import java.io.IOException;

public abstract class a {
  private static void a(String paramString) throws IOException {
    if (paramString.contains("..") && ArrayUtil.contains("..", paramString.split("[/\\\\]")))
      throw new IOException("Invalid entry name: " + paramString); 
  }
  
  public static File a(File paramFile, String paramString) throws IOException {
    a(paramString);
    return new File(paramFile, paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/c/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */