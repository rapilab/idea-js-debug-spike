package com.wallaby.javascript.extendedCore.outboundMessages;

public class RemoveLogs extends OutboundMessageBase {
  private final RemoveLogsDetails data;
  
  public RemoveLogs(String path, Integer line) {
    super("removeLogs");
    this.data = new RemoveLogsDetails(path, line, null);
  }
  
  private class RemoveLogsDetails {
    private final String path;
    
    private final Integer line;
    
    private RemoveLogsDetails(String path, Integer line) {
      this.path = path;
      this.line = line;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RemoveLogs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */