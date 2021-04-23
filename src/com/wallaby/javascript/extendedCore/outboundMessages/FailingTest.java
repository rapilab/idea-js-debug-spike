package com.wallaby.javascript.extendedCore.outboundMessages;

public class FailingTest extends RequestWithCallbackBase {
  private final FailingTestDetails request;
  
  public FailingTest(String file, int line) {
    super("error");
    this.request = new FailingTestDetails(file, line, null);
  }
  
  private class FailingTestDetails {
    private final String file;
    
    private final int line;
    
    private final String type;
    
    private FailingTestDetails(String file, int line) {
      this.file = file;
      this.line = line;
      this.type = "failingTest";
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/FailingTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */