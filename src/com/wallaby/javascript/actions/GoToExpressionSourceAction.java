package com.wallaby.javascript.actions;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.execution.b.f;

public class GoToExpressionSourceAction extends AnAction {
  private final f a;
  
  public GoToExpressionSourceAction(f valueNode) {
    super("Go to source", "Goes to the expression source code", AllIcons.Actions.EditSource);
    this.a = valueNode;
  }
  
  public void actionPerformed(AnActionEvent event) {
    this.a.h();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/GoToExpressionSourceAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */