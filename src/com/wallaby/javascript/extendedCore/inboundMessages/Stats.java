package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;

public class Stats {
  private ArrayList<ErrorEntry> errors;
  
  private ArrayList<TestEntry> tests;
  
  private int skippedNumber;
  
  private int todoNumber;
  
  private int failingNumber;
  
  private int totalNumber;
  
  private String additionalHeaderMessage;
  
  private String error = null;
  
  private boolean myNoData = false;
  
  private StatsTrace trace = null;
  
  public void a() {
    this.myNoData = true;
  }
  
  public boolean b() {
    return (this.error != null || this.failingNumber > 0 || (j()).length > 0);
  }
  
  public String c() {
    return StringUtil.notNullize(this.error);
  }
  
  public void a(String paramString) {
    this.error = paramString;
  }
  
  public int d() {
    return this.skippedNumber;
  }
  
  public int e() {
    return this.todoNumber;
  }
  
  public int f() {
    return this.failingNumber;
  }
  
  public int g() {
    return this.totalNumber;
  }
  
  public String h() {
    return StringUtil.notNullize(this.additionalHeaderMessage);
  }
  
  public StatsTrace i() {
    return this.trace;
  }
  
  public ErrorEntry[] j() {
    return (this.errors == null) ? new ErrorEntry[0] : this.errors.<ErrorEntry>toArray(new ErrorEntry[0]);
  }
  
  public TestEntry[] k() {
    return (this.tests == null) ? new TestEntry[0] : this.tests.<TestEntry>toArray(new TestEntry[0]);
  }
  
  public boolean l() {
    return !this.myNoData;
  }
  
  public boolean m() {
    return ((j()).length > 0);
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    Stats stats = (Stats)o;
    return !h().equals(stats.h()) ? false : ((this.totalNumber != stats.totalNumber) ? false : ((this.failingNumber != stats.failingNumber) ? false : (((this.errors != null) ? !this.errors.equals(stats.errors) : (stats.errors != null)) ? false : (!StringUtil.notNullize(this.error).equals(StringUtil.notNullize(stats.error)) ? false : ((this.tests != null) ? this.tests.equals(stats.tests) : ((stats.tests == null)))))));
  }
  
  public int hashCode() {
    null = (this.errors != null) ? this.errors.hashCode() : 0;
    return 31 * null + ((this.tests != null) ? this.tests.hashCode() : 0);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Stats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */