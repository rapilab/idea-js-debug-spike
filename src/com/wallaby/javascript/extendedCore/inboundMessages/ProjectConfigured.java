package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class ProjectConfigured {
  private int editDelay;
  
  private String kind;
  
  private Boolean profiling;
  
  private Boolean screenshot;
  
  public int a() {
    return this.editDelay;
  }
  
  public String b() {
    return StringUtil.notNullize(this.kind);
  }
  
  public Boolean c() {
    return Boolean.valueOf((this.screenshot != null && this.screenshot.booleanValue()));
  }
  
  public boolean d() {
    return (this.profiling != null && this.profiling.booleanValue());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ProjectConfigured.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */