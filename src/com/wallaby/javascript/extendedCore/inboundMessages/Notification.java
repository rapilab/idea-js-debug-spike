package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Notification {
  private String type;
  
  private String text;
  
  private Boolean allowMuting;
  
  private String id;
  
  public Notification() {}
  
  public Notification(String type, String text) {
    this.type = type;
    this.text = text;
  }
  
  public String a() {
    return StringUtil.notNullize(this.type);
  }
  
  public String b() {
    return StringUtil.notNullize(this.text);
  }
  
  public String c() {
    return StringUtil.notNullize(this.id);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Notification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */