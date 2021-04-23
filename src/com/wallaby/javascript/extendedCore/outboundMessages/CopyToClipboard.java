package com.wallaby.javascript.extendedCore.outboundMessages;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class CopyToClipboard extends OutboundMessageBase {
  private Request request;
  
  public CopyToClipboard(String str) {
    super("copyToClipboard");
    this.request = new Request((JsonElement)new JsonPrimitive(str), null);
  }
  
  public CopyToClipboard(JsonElement element) {
    super("copyToClipboard");
    this.request = new Request(element, null);
  }
  
  private class Request {
    private JsonElement data;
    
    private Request(JsonElement data) {
      this.data = data;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/CopyToClipboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */