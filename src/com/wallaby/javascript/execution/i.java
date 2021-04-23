package com.wallaby.javascript.execution;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.m;
import javax.swing.Icon;

class i extends AnAction {
  i(d paramd, String paramString1, String paramString2, Icon paramIcon, m paramm) {
    super(paramString1, paramString2, paramIcon);
  }
  
  public void update(AnActionEvent e) {
    e.getPresentation().setVisible((this.a.h() && this.a.j()));
  }
  
  public void actionPerformed(AnActionEvent e) {
    e.getPresentation().setVisible(false);
    this.a.g(null);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */