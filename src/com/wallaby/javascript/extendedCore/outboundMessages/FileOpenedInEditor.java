package com.wallaby.javascript.extendedCore.outboundMessages;

public class FileOpenedInEditor extends OutboundMessageBase {
  private final String path;
  
  public FileOpenedInEditor(String path) {
    super("fileOpenedInEditor");
    this.path = path;
  }
  
  public String a() {
    return this.path;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/FileOpenedInEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */