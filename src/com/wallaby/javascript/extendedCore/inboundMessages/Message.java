package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Message extends Location {
  private String type;
  
  private String text;
  
  private String expected;
  
  private String actual;
  
  private ValueBag valueBag;
  
  public String g() {
    return StringUtil.notNullize(this.type);
  }
  
  public String h() {
    return StringUtil.notNullize(this.text);
  }
  
  public ExpressionNode i() {
    return this.valueBag.a();
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    if (!super.equals(o))
      return false; 
    Message message = (Message)o;
    return ((this.type != null) ? !this.type.equals(message.type) : (message.type != null)) ? false : (((this.text != null) ? !this.text.equals(message.text) : (message.text != null)) ? false : (((this.expected != null) ? !this.expected.equals(message.expected) : (message.expected != null)) ? false : ((this.actual != null) ? this.actual.equals(message.actual) : ((message.actual == null)))));
  }
  
  public int hashCode() {
    null = super.hashCode();
    null = 31 * null + ((this.type != null) ? this.type.hashCode() : 0);
    null = 31 * null + ((this.text != null) ? this.text.hashCode() : 0);
    null = 31 * null + ((this.expected != null) ? this.expected.hashCode() : 0);
    return 31 * null + ((this.actual != null) ? this.actual.hashCode() : 0);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */