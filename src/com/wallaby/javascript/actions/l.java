package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterTestSelectionRequested;
import com.wallaby.javascript.m;
import javax.swing.Icon;

class l extends AnAction {
  l(ToggleTestFilterAction paramToggleTestFilterAction, String paramString1, String paramString2, Icon paramIcon, m paramm, String paramString3, TestFilterTestSelectionRequested.Test paramTest) {
    super(paramString1, paramString2, paramIcon);
  }
  
  public void actionPerformed(AnActionEvent event) {
    this.a.a(this.b, this.c.a());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */