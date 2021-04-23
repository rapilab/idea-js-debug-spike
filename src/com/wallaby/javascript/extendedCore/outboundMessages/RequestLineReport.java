package com.wallaby.javascript.extendedCore.outboundMessages;

public class RequestLineReport extends RequestWithCallbackBase {
  private final RequestLineReportDetails request;
  
  public RequestLineReport(String file, int line) {
    super("lineReport");
    this.request = new RequestLineReportDetails(file, line, null);
  }
  
  private class RequestLineReportDetails {
    private final String file;
    
    private final int line;
    
    private RequestLineReportDetails(String file, int line) {
      this.file = file;
      this.line = line;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RequestLineReport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */