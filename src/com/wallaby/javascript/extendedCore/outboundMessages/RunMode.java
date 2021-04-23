package com.wallaby.javascript.extendedCore.outboundMessages;

public class RunMode extends OutboundMessageBase {
  private RunModeOptions request;
  
  public RunMode(String mode) {
    super("runMode");
    this.request = new RunModeOptions(mode);
  }
  
  private class RunModeOptions {
    private String mode;
    
    public RunModeOptions(String mode) {
      this.mode = mode;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RunMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */