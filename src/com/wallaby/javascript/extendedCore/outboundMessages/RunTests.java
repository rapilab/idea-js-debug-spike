package com.wallaby.javascript.extendedCore.outboundMessages;

import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLocation;

public class RunTests extends OutboundMessageBase {
  private final RunTestParameters request;
  
  private RunTests(String file, Integer line, boolean evaluateExpression, boolean initialTraceRun, boolean profileTestRun, boolean updateSnapshots, Object[] testData) {
    super("runTests");
    this.request = new RunTestParameters(file, line, evaluateExpression, initialTraceRun, profileTestRun, updateSnapshots, testData);
  }
  
  public RunTests(String file) {
    this(file, null, false, false, false, false, null);
  }
  
  public RunTests() {
    this(null, null, false, false, false, false, null);
  }
  
  public RunTests(String file, int line, boolean profileTestRun, boolean updateSnapshots) {
    this(file, Integer.valueOf(line), false, false, profileTestRun, updateSnapshots, null);
  }
  
  public RunTests(String file, int line, boolean initialTraceRun, Object[] testData) {
    this(file, Integer.valueOf(line), false, initialTraceRun, false, false, testData);
  }
  
  public static RunTests a(ExpressionLocation paramExpressionLocation) {
    return new RunTests(paramExpressionLocation.a(), Integer.valueOf(paramExpressionLocation.b()), true, false, false, false, null);
  }
  
  public static RunTests a() {
    return new RunTests(null, null, true, false, false, false, null);
  }
  
  public RunTestParameters b() {
    return this.request;
  }
  
  public class RunTestParameters {
    private String file;
    
    private Integer line;
    
    private Boolean evaluateExpression = null;
    
    private Object[][] tests;
    
    private Boolean initialTraceRun = null;
    
    private String profileRun;
    
    private boolean updateSnapshots;
    
    public RunTestParameters(String file, Integer line, boolean evaluateExpression, boolean initialTraceRun, boolean profileTestRun, boolean updateSnapshots, Object[] testData) {
      this.file = file;
      this.line = line;
      this.updateSnapshots = updateSnapshots;
      if (evaluateExpression)
        this.evaluateExpression = Boolean.valueOf(evaluateExpression); 
      if (initialTraceRun)
        this.initialTraceRun = Boolean.valueOf(initialTraceRun); 
      if (testData != null) {
        this.tests = new Object[1][];
        this.tests[0] = testData;
      } 
      if (profileTestRun)
        this.profileRun = "devtools"; 
    }
    
    public String a() {
      return this.file;
    }
    
    public Integer b() {
      return this.line;
    }
    
    private RunTestParameters c() {
      return RunTests.a(RunTests.this);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RunTests.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */