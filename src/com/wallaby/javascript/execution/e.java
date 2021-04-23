package com.wallaby.javascript.execution;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.actions.JumpToTestAction;
import com.wallaby.javascript.m;
import javax.swing.Icon;

class e extends AnAction {
  e(d paramd, String paramString1, String paramString2, Icon paramIcon, m paramm) {
    super(paramString1, paramString2, paramIcon);
  }
  
  public void update(AnActionEvent anActionEvent) {
    anActionEvent.getPresentation().setEnabled(this.a.i());
  }
  
  public void actionPerformed(AnActionEvent anActionEvent) {
    (new JumpToTestAction()).actionPerformed(anActionEvent);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */