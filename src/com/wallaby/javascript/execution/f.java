package com.wallaby.javascript.execution;

import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.m;
import javax.swing.Icon;

class f extends AnAction {
  f(d paramd, String paramString1, String paramString2, Icon paramIcon, m paramm) {
    super(paramString1, paramString2, paramIcon);
  }
  
  public void update(AnActionEvent e) {
    e.getPresentation().setEnabled(this.a.h());
  }
  
  public void actionPerformed(AnActionEvent e) {
    BrowserLauncher.getInstance().open("http://localhost:51245");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */