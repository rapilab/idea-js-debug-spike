package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;

public class ClearAllValuesAction extends AnAction {
  public ClearAllValuesAction() {
    super(a.a);
  }
  
  public void actionPerformed(AnActionEvent event) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(event.getDataContext());
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    wallabyController.a(null, null);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ClearAllValuesAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */