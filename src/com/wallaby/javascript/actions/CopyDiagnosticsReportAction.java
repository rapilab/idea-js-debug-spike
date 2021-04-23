package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.v;

public class CopyDiagnosticsReportAction extends AnAction {
  public CopyDiagnosticsReportAction() {
    super(a.a);
  }
  
  public void update(AnActionEvent event) {
    super.update(event);
    Project project = (Project)CommonDataKeys.PROJECT.getData(event.getDataContext());
    if (project == null) {
      getTemplatePresentation().setEnabled(false);
      return;
    } 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null) {
      getTemplatePresentation().setEnabled(false);
      return;
    } 
    if (!wallabyController.a(v.f)) {
      getTemplatePresentation().setEnabled(false);
      return;
    } 
    getTemplatePresentation().setEnabled(wallabyController.h());
  }
  
  public void actionPerformed(AnActionEvent event) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(event.getDataContext());
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    wallabyController.l();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/CopyDiagnosticsReportAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */