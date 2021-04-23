package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Started {
  private String version;
  
  public String a() {
    return StringUtil.notNullize(this.version);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Started.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */