package com.wallaby.javascript.execution.a;

import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceFile;
import com.wallaby.javascript.m;
import java.awt.event.InputEvent;

public class j extends g {
  private final m b;
  
  private final TraceFile c;
  
  public j(f paramf, m paramm, TraceFile paramTraceFile) {
    super(paramf, "File" + paramTraceFile.a() + ":" + paramTraceFile.b());
    this.b = paramm;
    this.c = paramTraceFile;
    getTemplatePresentation().setIcon(paramm.b(paramTraceFile.a()).getFileType().getIcon());
    getTemplatePresentation().clearText();
    getTemplatePresentation().addText(paramTraceFile.a(), SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
  }
  
  public SimpleNode[] getChildren() {
    return new SimpleNode[0];
  }
  
  public void handleDoubleClickOrEnter(SimpleTree tree, InputEvent inputEvent) {
    this.b.a(this.c.b());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */