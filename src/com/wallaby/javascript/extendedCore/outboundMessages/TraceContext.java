package com.wallaby.javascript.extendedCore.outboundMessages;

public class TraceContext extends RequestWithCallbackBase {
  private TraceContextDetails request;
  
  public TraceContext(Boolean stopNavigation, Integer captureCallStackFrame, Integer currentFrame) {
    super("traceContext");
    this.request = new TraceContextDetails(stopNavigation, captureCallStackFrame, currentFrame, null);
  }
  
  private class TraceContextDetails {
    private final Boolean stopNavigation;
    
    private final Integer captureCallStackFrame;
    
    private final Integer currentFrame;
    
    private TraceContextDetails(Boolean stopNavigation, Integer captureCallStackFrame, Integer currentFrame) {
      if (stopNavigation.booleanValue()) {
        this.stopNavigation = stopNavigation;
      } else {
        this.stopNavigation = null;
      } 
      this.captureCallStackFrame = captureCallStackFrame;
      this.currentFrame = currentFrame;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/TraceContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */