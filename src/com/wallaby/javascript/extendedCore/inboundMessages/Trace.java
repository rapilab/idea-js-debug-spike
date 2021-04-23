package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class Trace {
  private String id;
  
  private TraceData data;
  
  public String a() {
    return StringUtil.notNullize(this.id);
  }
  
  public boolean b() {
    return (this.data != null);
  }
  
  public int[] c() {
    return this.data.a();
  }
  
  public int d() {
    return this.data.b();
  }
  
  public String e() {
    return this.data.c();
  }
  
  public int[] f() {
    return this.data.d();
  }
  
  public boolean g() {
    return this.data.e();
  }
  
  public TraceData h() {
    return this.data;
  }
  
  public class TraceData {
    private int[] range;
    
    private int frame;
    
    private String file;
    
    private int[] loc;
    
    private Boolean restart;
    
    public int[] a() {
      return this.range;
    }
    
    public int b() {
      return this.frame;
    }
    
    public String c() {
      return StringUtil.notNullize(this.file);
    }
    
    public int[] d() {
      return this.loc;
    }
    
    public boolean e() {
      return (this.restart != null && this.restart.booleanValue());
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/Trace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */