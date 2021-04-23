package com.wallaby.javascript.extendedCore.inboundMessages;

public class FilesToTrack {
  private Boolean incremental;
  
  private String[] files;
  
  public String[] a() {
    return this.files;
  }
  
  public boolean b() {
    return (this.incremental != null && this.incremental.booleanValue());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/FilesToTrack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */