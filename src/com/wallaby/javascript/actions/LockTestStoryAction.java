package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.m;

public class LockTestStoryAction extends WallabyControllerAction {
  public LockTestStoryAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.u);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    Project project = paramAnActionEvent.getProject();
    if (project == null)
      return; 
    paramm.r();
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return (paramm.s() && paramm.t());
  }
  
  protected boolean d(AnActionEvent paramAnActionEvent, m paramm) {
    return b(paramAnActionEvent, paramm);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/LockTestStoryAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */