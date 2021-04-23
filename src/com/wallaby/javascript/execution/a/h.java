package com.wallaby.javascript.execution.a;

import com.intellij.icons.AllIcons;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.wallaby.javascript.m;
import java.awt.event.InputEvent;

public class h extends g {
  private final m b;
  
  private final int c;
  
  private int d;
  
  public h(f paramf, m paramm, int paramInt1, int paramInt2) {
    super(paramf, "ExecutionNode");
    this.d = paramInt1;
    this.b = paramm;
    this.c = paramInt2;
    setIcon(AllIcons.Debugger.AddToWatch);
    getTemplatePresentation().clearText();
    if (paramInt2 > 0) {
      getTemplatePresentation().addText("Executed " + (int)Math.floor(((paramInt1 + 1) * 100 / paramInt2)) + "% ", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
      getTemplatePresentation().addText("step " + (paramInt1 + 1) + " of " + paramInt2 + " (click to locate)", SimpleTextAttributes.GRAYED_SMALL_ATTRIBUTES);
    } else {
      getTemplatePresentation().addText("Step " + (paramInt1 + 1) + " of " + paramInt2 + " (click to locate)", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    } 
  }
  
  public SimpleNode[] getChildren() {
    return new SimpleNode[0];
  }
  
  public void handleDoubleClickOrEnter(SimpleTree tree, InputEvent inputEvent) {
    this.b.a(this.d);
  }
  
  public Object[] getEqualityObjects() {
    return new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c) };
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */