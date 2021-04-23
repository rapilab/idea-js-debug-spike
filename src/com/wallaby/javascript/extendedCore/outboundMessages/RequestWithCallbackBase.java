package com.wallaby.javascript.extendedCore.outboundMessages;

import java.util.Date;

public abstract class RequestWithCallbackBase extends OutboundMessageBase {
  private static final Object LOCK = new Object();
  
  private static volatile long counter = 0L;
  
  private final String id;
  
  public RequestWithCallbackBase(String type) {
    super(type);
    long l;
    Date date = new Date();
    synchronized (LOCK) {
      l = counter++;
    } 
    this.id = date.getTime() + ":" + l;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RequestWithCallbackBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */