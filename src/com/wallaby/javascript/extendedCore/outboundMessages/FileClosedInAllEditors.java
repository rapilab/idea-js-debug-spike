package com.wallaby.javascript.extendedCore.outboundMessages;

public class FileClosedInAllEditors extends OutboundMessageBase {
  private final String path;
  
  public FileClosedInAllEditors(String path) {
    super("fileClosedInAllEditors");
    this.path = path;
  }
  
  public String a() {
    return this.path;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/FileClosedInAllEditors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */