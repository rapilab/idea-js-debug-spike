package com.wallaby.javascript.extendedCore.inboundMessages;

import com.wallaby.javascript.extendedCore.outboundMessages.RunTests;
import java.util.ArrayList;

public class TraceTestSelectionRequested {
  private RunTests.RunTestParameters originalRequest;
  
  private TraceTestSelectionData[] tests;
  
  public TraceTestSelectionData[] a() {
    return this.tests;
  }
  
  public RunTests.RunTestParameters b() {
    return this.originalRequest;
  }
  
  public class TraceTestSelectionData {
    private Object[] testData;
    
    private String file;
    
    private boolean failing;
    
    public boolean a() {
      return this.failing;
    }
    
    public String b() {
      ArrayList<String> arrayList = new ArrayList();
      for (byte b = 1; b < this.testData.length; b++)
        arrayList.add((String)this.testData[b]); 
      return String.join(" > ", (Iterable)arrayList);
    }
    
    public Object[] c() {
      return this.testData;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TraceTestSelectionRequested.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */