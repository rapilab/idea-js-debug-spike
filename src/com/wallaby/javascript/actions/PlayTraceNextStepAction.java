package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class PlayTraceNextStepAction extends WallabyControllerAction {
  public PlayTraceNextStepAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.n);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.G();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.F();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTraceNextStepAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */