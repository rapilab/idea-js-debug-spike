package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import com.wallaby.javascript.CoverageState;

public class LineData {
  private int num;
  
  private boolean decl;
  
  private int state;
  
  private String log;
  
  private String err;
  
  private String longLog;
  
  private LineMetadata meta;
  
  public int a() {
    return this.num;
  }
  
  public CoverageState b() {
    switch (this.state) {
      case 1:
        return CoverageState.NOT_COVERED;
      case 2:
        return CoverageState.FULL_COVERAGE;
      case 3:
        return CoverageState.PARTIAL_COVERAGE;
      case 4:
        return CoverageState.ERROR_SOURCE;
      case 5:
        return CoverageState.ERROR_PATH;
    } 
    return CoverageState.NOT_COVERED;
  }
  
  public boolean c() {
    return this.decl;
  }
  
  public String d() {
    return StringUtil.notNullize(this.log);
  }
  
  public boolean e() {
    return (this.log != null);
  }
  
  public String f() {
    return StringUtil.notNullize(this.err);
  }
  
  public LineMetadata g() {
    return this.meta;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/LineData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */