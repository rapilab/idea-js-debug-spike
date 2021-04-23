package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class PlayTracePrevStepOutAction extends WallabyControllerAction {
  public PlayTracePrevStepOutAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.l);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.O();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.N();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTracePrevStepOutAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */