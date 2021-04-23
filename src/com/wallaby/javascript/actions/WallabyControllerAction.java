package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.m;

public abstract class WallabyControllerAction extends AnAction {
  protected abstract void a(AnActionEvent paramAnActionEvent, m paramm);
  
  protected boolean d(AnActionEvent paramAnActionEvent, m paramm) {
    return true;
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return true;
  }
  
  private m a(AnActionEvent paramAnActionEvent) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(paramAnActionEvent.getDataContext());
    return (m)((project == null) ? null : WallabyController.a(project));
  }
  
  public void update(AnActionEvent event) {
    super.update(event);
    m m = a(event);
    event.getPresentation().setVisible((m == null || d(event, m)));
    event.getPresentation().setEnabled((m == null || b(event, m)));
  }
  
  public void actionPerformed(AnActionEvent event) {
    m m = a(event);
    if (m != null)
      a(event, m); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/WallabyControllerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */