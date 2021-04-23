package com.wallaby.javascript.extendedCore.outboundMessages;

public class RequestTrace extends RequestWithCallbackBase {
  private RequestTraceDetails request;
  
  public RequestTrace(StepType stepType, StepDirection direction) {
    super("trace");
    this.request = new RequestTraceDetails(Boolean.valueOf((direction == StepDirection.Backward)), Boolean.valueOf((stepType == StepType.Out)), Boolean.valueOf((stepType == StepType.Over)), null, null, null, null, null);
  }
  
  public RequestTrace(String file, Integer line, StepDirection direction) {
    super("trace");
    this.request = new RequestTraceDetails(Boolean.valueOf((direction == StepDirection.Backward)), null, null, file, line, null, null, null);
  }
  
  public RequestTrace(StepType stepType, StepDirection direction, int frame) {
    super("trace");
    this.request = new RequestTraceDetails(Boolean.valueOf((direction == StepDirection.Backward)), Boolean.valueOf((stepType == StepType.Out)), Boolean.valueOf((stepType == StepType.Over)), null, null, Integer.valueOf(frame), null, null);
  }
  
  public RequestTrace(String file, int line, Integer frame, StepDirection direction) {
    super("trace");
    this.request = new RequestTraceDetails(Boolean.valueOf((direction == StepDirection.Backward)), null, null, file, Integer.valueOf(line), frame, null, null);
  }
  
  public RequestTrace(LineLocation[] breakpoints, StepDirection direction) {
    super("trace");
    this.request = new RequestTraceDetails(Boolean.valueOf((direction == StepDirection.Backward)), null, null, null, null, null, breakpoints, null);
  }
  
  private class RequestTraceDetails {
    private final Boolean back;
    
    private final Boolean out;
    
    private final Boolean over;
    
    private final String file;
    
    private Integer line = null;
    
    private Integer frame = null;
    
    private LineLocation[] breakpoints = null;
    
    private RequestTraceDetails(Boolean back, Boolean out, Boolean over, String file, Integer line, Integer frame, LineLocation[] breakpoints) {
      this.back = back;
      this.out = out;
      this.over = over;
      this.file = file;
      this.line = line;
      this.frame = frame;
      this.breakpoints = breakpoints;
    }
  }
  
  public enum StepDirection {
    Forward, Backward;
  }
  
  public enum StepType {
    Into, Over, Out;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RequestTrace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */