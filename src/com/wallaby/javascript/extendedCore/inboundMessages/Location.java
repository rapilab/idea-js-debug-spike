package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Location {
  private String file;
  
  private String loc;
  
  private String context;
  
  private String id;
  
  public int a() {
    if (this.loc == null)
      return 0; 
    String[] arrayOfString = this.loc.split(":");
    return Integer.parseInt(arrayOfString[0]);
  }
  
  public int b() {
    if (this.loc == null)
      return 0; 
    String[] arrayOfString = this.loc.split(":");
    return (arrayOfString.length != 2) ? 0 : Integer.parseInt(arrayOfString[1]);
  }
  
  public String c() {
    return StringUtil.notNullize(this.loc);
  }
  
  public String d() {
    return StringUtil.notNullize(this.file);
  }
  
  public String e() {
    return StringUtil.notNullize(this.context);
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    Location location = (Location)o;
    return ((this.file != null) ? !this.file.equals(location.file) : (location.file != null)) ? false : (((this.loc != null) ? !this.loc.equals(location.loc) : (location.loc != null)) ? false : ((this.context != null) ? this.context.equals(location.context) : ((location.context == null))));
  }
  
  public int hashCode() {
    null = (this.file != null) ? this.file.hashCode() : 0;
    null = 31 * null + ((this.loc != null) ? this.loc.hashCode() : 0);
    return 31 * null + ((this.context != null) ? this.context.hashCode() : 0);
  }
  
  public void a(String paramString) {
    this.file = paramString;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.loc = paramInt1 + ":" + paramInt2;
  }
  
  public void b(String paramString) {
    this.id = paramString;
  }
  
  public String f() {
    return StringUtil.notNullize(this.id);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Location.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */