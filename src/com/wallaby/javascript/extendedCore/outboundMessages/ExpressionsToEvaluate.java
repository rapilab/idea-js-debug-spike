package com.wallaby.javascript.extendedCore.outboundMessages;

import com.google.gson.JsonObject;

public class ExpressionsToEvaluate extends OutboundMessageBase {
  private ExpressionsToEvaluateRequest request;
  
  public ExpressionsToEvaluate(JsonObject expressionsToEvaluate) {
    super("expressionsToEvaluate");
    this.request = new ExpressionsToEvaluateRequest(expressionsToEvaluate);
  }
  
  private class ExpressionsToEvaluateRequest {
    private JsonObject expressionsToEvaluate;
    
    public ExpressionsToEvaluateRequest(JsonObject expressionsToEvaluate) {
      this.expressionsToEvaluate = expressionsToEvaluate;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/ExpressionsToEvaluate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */