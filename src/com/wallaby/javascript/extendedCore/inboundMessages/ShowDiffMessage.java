package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class ShowDiffMessage {
  private String id;
  
  private ShowDiffMessageData data;
  
  public String a() {
    return StringUtil.notNullize(this.id);
  }
  
  public ErrorEntry b() {
    return this.data.a();
  }
  
  private class ShowDiffMessageData {
    private ErrorEntry error;
    
    public ErrorEntry a() {
      return this.error;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ShowDiffMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */