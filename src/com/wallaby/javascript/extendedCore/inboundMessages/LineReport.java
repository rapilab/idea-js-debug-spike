package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;

public class LineReport {
  private String id;
  
  private LineReportData data;
  
  public String a() {
    return StringUtil.notNullize(this.id);
  }
  
  public String b() {
    return this.data.a();
  }
  
  public int c() {
    return this.data.c();
  }
  
  public TestEntry[] d() {
    return this.data.b();
  }
  
  private class LineReportTests {
    private ArrayList<TestEntry> tests;
    
    public TestEntry[] a() {
      return (this.tests == null) ? new TestEntry[0] : this.tests.<TestEntry>toArray(new TestEntry[0]);
    }
  }
  
  private class LineReportData {
    private String file;
    
    private int line;
    
    private LineReport.LineReportTests report;
    
    public String a() {
      return StringUtil.notNullize(this.file);
    }
    
    public TestEntry[] b() {
      return this.report.a();
    }
    
    public int c() {
      return this.line;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/LineReport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */