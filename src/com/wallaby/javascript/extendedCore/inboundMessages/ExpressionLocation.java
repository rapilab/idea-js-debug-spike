package com.wallaby.javascript.extendedCore.inboundMessages;

public class ExpressionLocation {
  private final String file;
  
  private final int line;
  
  public ExpressionLocation(String file, int line) {
    this.file = file;
    this.line = line;
  }
  
  public String a() {
    return this.file;
  }
  
  public int b() {
    return this.line;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ExpressionLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */