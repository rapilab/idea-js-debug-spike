package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class TestMessage {
  private String text;
  
  private String file;
  
  private String loc;
  
  private String context;
  
  public String a() {
    return StringUtil.notNullize(this.loc);
  }
  
  public String b() {
    return StringUtil.notNullize(this.file);
  }
  
  public String c() {
    return StringUtil.notNullize(this.context);
  }
  
  public String d() {
    return StringUtil.notNullize(this.text);
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    TestMessage testMessage = (TestMessage)o;
    return !a().equals(testMessage.a()) ? false : (!b().equals(testMessage.b()) ? false : (!c().equals(testMessage.c()) ? false : d().equals(testMessage.d())));
  }
  
  public int hashCode() {
    null = a().hashCode();
    null = 31 * null + b().hashCode();
    null = 31 * null + c().hashCode();
    return 31 * null + d().hashCode();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TestMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */