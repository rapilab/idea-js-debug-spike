package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.b;

public class RunTestFileAction extends AnAction {
  protected boolean a = false;
  
  public RunTestFileAction() {
    super(a.a);
  }
  
  public void actionPerformed(AnActionEvent e) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(e.getDataContext());
    if (project == null)
      return; 
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(e.getDataContext());
    if (editor == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    b b = wallabyController.a(editor);
    if (b == null)
      return; 
    wallabyController.d(b.d());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/RunTestFileAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */