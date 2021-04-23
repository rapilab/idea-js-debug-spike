package com.wallaby.javascript.extendedCore.inboundMessages;

import java.util.ArrayList;

public class TestFilterTestSelectionRequested {
  private Test[] tests;
  
  public Test[] a() {
    return this.tests;
  }
  
  public class Test {
    private Object[] path;
    
    private String file;
    
    private boolean failing;
    
    public Object[] a() {
      return this.path;
    }
    
    public boolean b() {
      return this.failing;
    }
    
    public String c() {
      ArrayList<String> arrayList = new ArrayList();
      for (byte b = 1; b < this.path.length; b++)
        arrayList.add((String)this.path[b]); 
      return String.join(" > ", (Iterable)arrayList);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TestFilterTestSelectionRequested.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */