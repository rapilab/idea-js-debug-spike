package com.wallaby.javascript.execution.a;

import com.intellij.icons.AllIcons;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceCallStack;
import com.wallaby.javascript.m;
import java.util.ArrayList;

public class b extends g {
  private final m b;
  
  private final ArrayList<SimpleNode> c;
  
  private int d;
  
  private TraceCallStack e;
  
  private boolean f = false;
  
  public b(f paramf, m paramm, int paramInt, TraceCallStack paramTraceCallStack) {
    super(paramf, "CallStackRoot" + paramInt);
    this.b = paramm;
    this.d = paramInt;
    this.e = paramTraceCallStack;
    if (this.e != null) {
      this.c = new ArrayList<>();
      for (TraceCallStack.TraceCallStackDetail traceCallStackDetail : this.e.b())
        this.c.add(new a(this.a, this.b, traceCallStackDetail)); 
    } else {
      this.c = null;
    } 
    setIcon(AllIcons.Debugger.Frame);
    getTemplatePresentation().clearText();
    getTemplatePresentation().addText("Call Stack", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
  }
  
  public SimpleNode[] getChildren() {
    if (this.e == null) {
      if (!this.f) {
        this.f = true;
        this.b.b(this.d);
      } 
      return new SimpleNode[0];
    } 
    return this.c.<SimpleNode>toArray(new SimpleNode[this.c.size()]);
  }
  
  public boolean isAlwaysShowPlus() {
    return true;
  }
  
  public Object[] getEqualityObjects() {
    return new Object[] { Integer.valueOf(this.d), Boolean.valueOf((this.e != null)) };
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */