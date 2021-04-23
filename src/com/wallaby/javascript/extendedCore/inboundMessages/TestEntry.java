package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;

public class TestEntry {
  private String file;
  
  private String[] path;
  
  private String loc;
  
  private String time;
  
  private Boolean failing;
  
  private ArrayList<ErrorEntry> errors;
  
  private ArrayList<TestMessage> messages;
  
  public String a() {
    return StringUtil.notNullize(this.file);
  }
  
  public String[] b() {
    return this.path;
  }
  
  public String c() {
    return StringUtil.notNullize(this.loc);
  }
  
  public Long d() {
    if (StringUtil.notNullize(this.time).isEmpty())
      return null; 
    try {
      return Long.valueOf(Long.parseLong(this.time));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public ErrorEntry[] e() {
    return (this.errors == null) ? new ErrorEntry[0] : this.errors.<ErrorEntry>toArray(new ErrorEntry[0]);
  }
  
  public TestMessage[] f() {
    return (this.messages == null) ? new TestMessage[0] : this.messages.<TestMessage>toArray(new TestMessage[0]);
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    TestEntry testEntry = (TestEntry)o;
    return !a().equals(testEntry.a()) ? false : ((b() == null && testEntry.b() != null) ? false : ((b() != null && testEntry.b() == null) ? false : (!Arrays.equals((Object[])b(), (Object[])testEntry.b()) ? false : (!c().equals(testEntry.c()) ? false : (!Arrays.equals((Object[])e(), (Object[])testEntry.e()) ? false : Arrays.equals((Object[])f(), (Object[])testEntry.f()))))));
  }
  
  public int hashCode() {
    null = a().hashCode();
    null = 31 * null + ((b() != null) ? Arrays.hashCode((Object[])b()) : 0);
    null = 31 * null + c().hashCode();
    null = 31 * null + ((d() != null) ? d().hashCode() : 0);
    null = 31 * null + Arrays.hashCode((Object[])e());
    return 31 * null + Arrays.hashCode((Object[])f());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TestEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */