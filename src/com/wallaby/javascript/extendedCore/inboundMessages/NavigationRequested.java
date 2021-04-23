package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class NavigationRequested {
  private String file;
  
  private String loc;
  
  public String a() {
    return StringUtil.notNullize(this.file);
  }
  
  public int b() {
    if (this.loc == null)
      return 0; 
    String[] arrayOfString = this.loc.split(":");
    return Integer.parseInt(arrayOfString[0]);
  }
  
  public int c() {
    if (this.loc == null)
      return 0; 
    String[] arrayOfString = this.loc.split(":");
    return (arrayOfString.length != 2) ? 0 : Integer.parseInt(arrayOfString[1]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/NavigationRequested.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */