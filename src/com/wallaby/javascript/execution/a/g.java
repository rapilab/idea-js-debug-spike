package com.wallaby.javascript.execution.a;

import com.intellij.ui.treeStructure.SimpleNode;

public abstract class g extends SimpleNode {
  protected final f a;
  
  private final String b;
  
  public g(f paramf, String paramString) {
    this.a = paramf;
    this.b = paramString;
    this.a.a(this);
  }
  
  public SimpleNode[] getChildren() {
    return new SimpleNode[0];
  }
  
  public final String a() {
    return this.b;
  }
  
  public Object[] getEqualityObjects() {
    return new Object[] { this.b };
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */