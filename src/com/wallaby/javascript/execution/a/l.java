package com.wallaby.javascript.execution.a;

import a.a;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceTest;
import com.wallaby.javascript.m;
import java.awt.event.InputEvent;

public class l extends g {
  private final m b;
  
  private final TraceTest c;
  
  public l(f paramf, m paramm, TraceTest paramTraceTest) {
    super(paramf, "Test" + paramTraceTest.a() + ":" + paramTraceTest.b());
    this.b = paramm;
    this.c = paramTraceTest;
    setIcon(a.f);
    getTemplatePresentation().clearText();
    getTemplatePresentation().addText("Test ", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    getTemplatePresentation().addText(paramTraceTest.a(), SimpleTextAttributes.GRAYED_SMALL_ATTRIBUTES);
  }
  
  public SimpleNode[] getChildren() {
    return new SimpleNode[0];
  }
  
  public void handleDoubleClickOrEnter(SimpleTree tree, InputEvent inputEvent) {
    this.b.a(this.c.b());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */