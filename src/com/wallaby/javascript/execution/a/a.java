package com.wallaby.javascript.execution.a;

import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceCallStack;
import com.wallaby.javascript.m;
import java.awt.event.InputEvent;

public class a extends g {
  private m b;
  
  private TraceCallStack.TraceCallStackDetail c;
  
  public a(f paramf, m paramm, TraceCallStack.TraceCallStackDetail paramTraceCallStackDetail) {
    super(paramf, "CallStackNode" + paramTraceCallStackDetail.c());
    this.b = paramm;
    this.c = paramTraceCallStackDetail;
    getTemplatePresentation().clearText();
    getTemplatePresentation().addText(paramTraceCallStackDetail.b() + " ", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    getTemplatePresentation().addText(paramTraceCallStackDetail.a(), SimpleTextAttributes.GRAYED_SMALL_ATTRIBUTES);
    if (paramTraceCallStackDetail.d() != null) {
      if ((paramTraceCallStackDetail.d()).length > 0)
        getTemplatePresentation().addText(":" + paramTraceCallStackDetail.d()[0], SimpleTextAttributes.GRAYED_SMALL_ATTRIBUTES); 
      if ((paramTraceCallStackDetail.d()).length > 1)
        getTemplatePresentation().addText(":" + paramTraceCallStackDetail.d()[1], SimpleTextAttributes.GRAYED_SMALL_ATTRIBUTES); 
    } 
  }
  
  public void handleDoubleClickOrEnter(SimpleTree tree, InputEvent inputEvent) {
    int[] arrayOfInt = this.c.d();
    this.b.a(this.c.c(), this.c.a(), arrayOfInt[0] - 1, arrayOfInt[1], this.c.e());
  }
  
  public SimpleNode[] getChildren() {
    return new SimpleNode[0];
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */