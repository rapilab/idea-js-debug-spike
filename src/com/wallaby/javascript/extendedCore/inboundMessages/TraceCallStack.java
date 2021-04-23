package com.wallaby.javascript.extendedCore.inboundMessages;

import java.util.ArrayList;

public class TraceCallStack {
  private final int frame;
  
  private final ArrayList<TraceCallStackDetail> stack;
  
  public TraceCallStack(int frame) {
    this.frame = frame;
    this.stack = new ArrayList<>();
  }
  
  public int a() {
    return this.frame;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2) {
    this.stack.add(new TraceCallStackDetail(paramString1, paramString2, paramInt, paramArrayOfInteger1, paramArrayOfInteger2));
  }
  
  public TraceCallStackDetail[] b() {
    return this.stack.<TraceCallStackDetail>toArray(new TraceCallStackDetail[this.stack.size()]);
  }
  
  public class TraceCallStackDetail {
    private final String file;
    
    private final String context;
    
    private final int frame;
    
    private final Integer[] location;
    
    private final Integer[] range;
    
    public TraceCallStackDetail(String file, String context, int frame, Integer[] location, Integer[] range) {
      this.file = file;
      this.context = context;
      this.frame = frame;
      this.location = location;
      this.range = range;
    }
    
    public String a() {
      return this.file;
    }
    
    public String b() {
      return this.context;
    }
    
    public int c() {
      return this.frame;
    }
    
    public int[] d() {
      int[] arrayOfInt = new int[this.location.length];
      for (byte b = 0; b < this.location.length; b++)
        arrayOfInt[b] = this.location[b].intValue(); 
      return arrayOfInt;
    }
    
    public int[] e() {
      int[] arrayOfInt = new int[this.range.length];
      for (byte b = 0; b < this.range.length; b++)
        arrayOfInt[b] = this.range[b].intValue(); 
      return arrayOfInt;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TraceCallStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */