package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.m;

public class UnlockTestStoryAction extends WallabyControllerAction {
  public UnlockTestStoryAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.v);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    Project project = paramAnActionEvent.getProject();
    if (project == null)
      return; 
    paramm.q();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return (paramm.s() && !paramm.t());
  }
  
  protected boolean d(AnActionEvent paramAnActionEvent, m paramm) {
    return (paramm.R() || b(paramAnActionEvent, paramm));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/UnlockTestStoryAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */