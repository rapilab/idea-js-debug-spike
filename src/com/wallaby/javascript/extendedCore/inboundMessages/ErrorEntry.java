package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;

public class ErrorEntry {
  private String message;
  
  private String expected;
  
  private String actual;
  
  private String missingPackage;
  
  private String undefinedName;
  
  private Boolean snapshot;
  
  private ArrayList<Location> stack;
  
  private String missingBrowserGlobal;
  
  public String a() {
    return StringUtil.notNullize(this.message);
  }
  
  public String b() {
    return StringUtil.notNullize(this.actual);
  }
  
  public boolean c() {
    return (this.snapshot != null && this.snapshot.booleanValue());
  }
  
  public String d() {
    return StringUtil.notNullize(this.expected);
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    ErrorEntry errorEntry = (ErrorEntry)o;
    return !a().equals(errorEntry.a()) ? false : (!d().equals(errorEntry.d()) ? false : (!b().equals(errorEntry.b()) ? false : ((this.stack != null) ? this.stack.equals(errorEntry.stack) : ((errorEntry.stack == null)))));
  }
  
  public int hashCode() {
    null = (this.message != null) ? this.message.hashCode() : 0;
    null = 31 * null + ((this.expected != null) ? this.expected.hashCode() : 0);
    null = 31 * null + ((this.actual != null) ? this.actual.hashCode() : 0);
    null = 31 * null + ((this.stack != null) ? this.stack.hashCode() : 0);
    return 31 * null + ((this.missingPackage != null) ? this.missingPackage.hashCode() : 0);
  }
  
  public Location[] e() {
    return (this.stack == null) ? new Location[0] : this.stack.<Location>toArray(new Location[0]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ErrorEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */