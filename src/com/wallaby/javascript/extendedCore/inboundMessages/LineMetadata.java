package com.wallaby.javascript.extendedCore.inboundMessages;

public class LineMetadata {
  private boolean filtered;
  
  private boolean system;
  
  private LineLogMetadata log;
  
  public LineLogMetadata a() {
    return this.log;
  }
  
  public boolean b() {
    return this.filtered;
  }
  
  public boolean c() {
    return this.system;
  }
  
  public class LineLogMetadata {
    private boolean removable;
    
    private boolean system;
    
    public boolean a() {
      return this.removable;
    }
    
    public boolean b() {
      return this.system;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/LineMetadata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */