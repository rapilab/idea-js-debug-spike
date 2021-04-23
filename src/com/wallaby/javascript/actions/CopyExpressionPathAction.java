package com.wallaby.javascript.actions;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.execution.b.f;

public class CopyExpressionPathAction extends AnAction {
  private final f a;
  
  public CopyExpressionPathAction(f valueNode) {
    super("Copy path", "Copies selected expression path to clipboard", AllIcons.Actions.Copy);
    this.a = valueNode;
  }
  
  public void actionPerformed(AnActionEvent event) {
    this.a.f();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/CopyExpressionPathAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */