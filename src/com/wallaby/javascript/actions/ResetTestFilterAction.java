package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;

public class ResetTestFilterAction extends AnAction {
  public ResetTestFilterAction() {
    super(a.a);
  }
  
  public final void actionPerformed(AnActionEvent e) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(e.getDataContext());
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    wallabyController.g(null);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ResetTestFilterAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */