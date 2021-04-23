package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class PlayTracePrevStepOverAction extends WallabyControllerAction {
  public PlayTracePrevStepOverAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.m);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.Q();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.P();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTracePrevStepOverAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */