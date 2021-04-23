package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;

public class ExpressionLabel {
  private String type;
  
  private String name;
  
  private String value;
  
  private String description;
  
  public String a() {
    return StringUtil.notNullize(this.type);
  }
  
  public String b() {
    return StringUtil.notNullize(this.name);
  }
  
  public String c() {
    return StringUtil.notNullize(this.description);
  }
  
  public String d() {
    return StringUtil.notNullize(this.value);
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    ExpressionLabel expressionLabel = (ExpressionLabel)o;
    return !a().equals(expressionLabel.a()) ? false : (!b().equals(expressionLabel.b()) ? false : (!c().equals(expressionLabel.c()) ? false : d().equals(expressionLabel.d())));
  }
  
  public int hashCode() {
    null = a().hashCode();
    null = 31 * null + b().hashCode();
    null = 31 * null + d().hashCode();
    return 31 * null + c().hashCode();
  }
  
  public void a(String paramString) {
    this.name = paramString;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ExpressionLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */