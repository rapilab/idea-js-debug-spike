package com.wallaby.javascript.extendedCore.outboundMessages;

public class ToggleTestFilter extends RequestWithCallbackBase {
  private ToggleTestFilterDetails request;
  
  private ToggleTestFilter() {
    super("toggleTestFilter");
  }
  
  public ToggleTestFilter(String file) {
    this();
    this.request = new ToggleTestFilterDetails(file, null);
  }
  
  public ToggleTestFilter(String file, int line) {
    this();
    this.request = new ToggleTestFilterDetails(file, line, null);
  }
  
  public ToggleTestFilter(String file, Object[] test) {
    this();
    this.request = new ToggleTestFilterDetails(file, test, null);
  }
  
  private class ToggleTestFilterDetails {
    private final String file;
    
    private Integer line = null;
    
    private Object[] test = null;
    
    private ToggleTestFilterDetails(String file) {
      this.file = file;
    }
    
    private ToggleTestFilterDetails(String file, int line) {
      this.file = file;
      this.line = Integer.valueOf(line);
    }
    
    private ToggleTestFilterDetails(String file, Object[] test) {
      this.file = file;
      this.test = test;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/ToggleTestFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */