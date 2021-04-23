package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class DebugRevealTraceStepAction extends WallabyControllerAction {
  public DebugRevealTraceStepAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.a);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.x();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.w();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/DebugRevealTraceStepAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */