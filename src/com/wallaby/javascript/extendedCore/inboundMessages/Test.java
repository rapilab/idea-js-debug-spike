package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Test {
  private String file;
  
  private int[] location;
  
  private String suite;
  
  private String name;
  
  private String status;
  
  private boolean failing;
  
  public String a() {
    return StringUtil.notNullize(this.file);
  }
  
  public int[] b() {
    return this.location;
  }
  
  public String c() {
    return this.suite;
  }
  
  public String d() {
    return this.name;
  }
  
  public TestStatus e() {
    return (this.status == null) ? TestStatus.Executed : (this.status.equals("skipped") ? TestStatus.Skipped : (this.status.equals("todo") ? TestStatus.Todo : TestStatus.Executed));
  }
  
  public boolean f() {
    return this.failing;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Test.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */