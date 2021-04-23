package com.wallaby.javascript.extendedCore.outboundMessages;

public class RequestUncoveredRegions extends RequestWithCallbackBase {
  private RequestUncoveredRegionsDetails request;
  
  private RequestUncoveredRegions() {
    super("uncoveredRegions");
  }
  
  public RequestUncoveredRegions(String file) {
    this();
    this.request = new RequestUncoveredRegionsDetails(file, null);
  }
  
  public RequestUncoveredRegions(String file, int line) {
    this();
    this.request = new RequestUncoveredRegionsDetails(file, line, null);
  }
  
  private class RequestUncoveredRegionsDetails {
    private final String file;
    
    private Integer line = null;
    
    private RequestUncoveredRegionsDetails(String file) {
      this.file = file;
    }
    
    private RequestUncoveredRegionsDetails(String file, int line) {
      this.file = file;
      this.line = Integer.valueOf(line);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RequestUncoveredRegions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */