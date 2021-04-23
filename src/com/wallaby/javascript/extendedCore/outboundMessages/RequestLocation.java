package com.wallaby.javascript.extendedCore.outboundMessages;

public class RequestLocation extends RequestWithCallbackBase {
  private final RequestLocationDetails request;
  
  public RequestLocation(String file, int line, String type) {
    super("location");
    this.request = new RequestLocationDetails(file, line, type, null);
  }
  
  public RequestLocation(String file, String testName, String type) {
    super("location");
    this.request = new RequestLocationDetails(file, testName, type, null);
  }
  
  private class RequestLocationDetails {
    private String file;
    
    private int line;
    
    private String test;
    
    private String type;
    
    private RequestLocationDetails(String file, int line, String type) {
      this.file = file;
      this.line = line;
      this.type = type;
    }
    
    private RequestLocationDetails(String file, String test, String type) {
      this.file = file;
      this.test = test;
      this.type = type;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RequestLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */