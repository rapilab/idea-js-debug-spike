package com.wallaby.javascript.extendedCore.inboundMessages;

public class StatsTrace {
  private TraceFile[] files;
  
  private TraceTest[] tests;
  
  private TraceCallStack[] callStacks;
  
  private Integer length;
  
  private Integer currentFrame;
  
  public TraceFile[] a() {
    return this.files;
  }
  
  public void a(TraceFile[] paramArrayOfTraceFile) {
    this.files = paramArrayOfTraceFile;
  }
  
  public TraceTest[] b() {
    return this.tests;
  }
  
  public void a(TraceTest[] paramArrayOfTraceTest) {
    this.tests = paramArrayOfTraceTest;
  }
  
  public TraceCallStack[] c() {
    return this.callStacks;
  }
  
  public void a(TraceCallStack[] paramArrayOfTraceCallStack) {
    this.callStacks = paramArrayOfTraceCallStack;
  }
  
  public boolean d() {
    return (this.length != null);
  }
  
  public int e() {
    return this.length.intValue();
  }
  
  public void a(int paramInt) {
    this.length = Integer.valueOf(paramInt);
  }
  
  public boolean f() {
    return (this.currentFrame != null);
  }
  
  public int g() {
    return this.currentFrame.intValue();
  }
  
  public void b(int paramInt) {
    this.currentFrame = Integer.valueOf(paramInt);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/StatsTrace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */