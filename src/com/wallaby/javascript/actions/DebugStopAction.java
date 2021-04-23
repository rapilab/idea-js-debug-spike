package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class DebugStopAction extends WallabyControllerAction {
  public DebugStopAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.i);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.A();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.z();
  }
  
  protected boolean d(AnActionEvent paramAnActionEvent, m paramm) {
    return !paramm.R();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/DebugStopAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */