package com.wallaby.javascript.extendedCore.inboundMessages;

public class ValueBag {
  private ExpressionNode data;
  
  public ExpressionNode a() {
    return this.data;
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    ValueBag valueBag = (ValueBag)o;
    return (a() != null) ? a().equals(valueBag.a()) : ((valueBag.a() == null));
  }
  
  public int hashCode() {
    return (a() != null) ? a().hashCode() : 0;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ValueBag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */