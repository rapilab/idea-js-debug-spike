package com.wallaby.javascript.extendedCore.inboundMessages;

import java.util.ArrayList;

public class DocumentUpdate {
  private ArrayList<LineData> lines;
  
  private Coverage myCoverage;
  
  public LineData[] a() {
    return (this.lines == null) ? new LineData[0] : this.lines.<LineData>toArray(new LineData[0]);
  }
  
  public class Coverage {
    private String value;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/DocumentUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */