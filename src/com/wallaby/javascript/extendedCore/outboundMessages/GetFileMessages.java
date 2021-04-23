package com.wallaby.javascript.extendedCore.outboundMessages;

public class GetFileMessages extends OutboundMessageBase {
  private final String request;
  
  public GetFileMessages(String request) {
    super("getFileMessages");
    this.request = request;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/GetFileMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */