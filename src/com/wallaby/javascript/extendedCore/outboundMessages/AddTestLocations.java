package com.wallaby.javascript.extendedCore.outboundMessages;

public class AddTestLocations extends OutboundMessageBase {
  private final String[] paths;
  
  public AddTestLocations(String[] paths) {
    super("addTestLocations");
    this.paths = paths;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/AddTestLocations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */