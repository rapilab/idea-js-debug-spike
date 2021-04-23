package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class PlayTraceNextStepOutAction extends WallabyControllerAction {
  public PlayTraceNextStepOutAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.o);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.I();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.H();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTraceNextStepOutAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */