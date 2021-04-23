package com.wallaby.javascript.extendedCore.outboundMessages;

public class LineLocation {
  private final String file;
  
  private final int line;
  
  public LineLocation(String filePath, int lineNumber) {
    this.file = filePath;
    this.line = lineNumber;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/LineLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */