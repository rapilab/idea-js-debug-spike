package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class PlayTracePrevStepAction extends WallabyControllerAction {
  public PlayTracePrevStepAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.k);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.M();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.L();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTracePrevStepAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */