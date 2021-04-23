package com.wallaby.javascript.actions;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.execution.b.f;

public class CopyExpressionDataAction extends AnAction {
  private final f a;
  
  public CopyExpressionDataAction(f valueNode) {
    super("Copy data", "Copies data from expanded tree nodes to clipboard", AllIcons.Actions.Copy);
    this.a = valueNode;
  }
  
  public void actionPerformed(AnActionEvent event) {
    this.a.e();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/CopyExpressionDataAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */