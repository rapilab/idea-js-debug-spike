package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Tests {
  private String id;
  
  private Test[] data;
  
  public String a() {
    return StringUtil.notNullize(this.id);
  }
  
  public Test[] b() {
    return this.data;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Tests.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */