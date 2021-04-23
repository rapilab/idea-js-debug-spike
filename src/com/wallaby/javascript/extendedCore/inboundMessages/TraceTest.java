package com.wallaby.javascript.extendedCore.inboundMessages;

public class TraceTest {
  private String name;
  
  private int start;
  
  public TraceTest(String name, int start) {
    this.name = name;
    this.start = start;
  }
  
  public String a() {
    return this.name;
  }
  
  public int b() {
    return this.start;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TraceTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */