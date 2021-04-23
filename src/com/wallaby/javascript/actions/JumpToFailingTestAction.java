package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;

public class JumpToFailingTestAction extends AnAction {
  public JumpToFailingTestAction() {
    super(a.a);
  }
  
  public void actionPerformed(AnActionEvent event) {
    Project project = event.getProject();
    if (project == null)
      return; 
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(event.getDataContext());
    if (editor == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    b b = wallabyController.a(editor);
    if (b == null)
      return; 
    f f = b.a(editor.getCaretModel().getOffset());
    if (f != null)
      wallabyController.a(b.d(), f.k()); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/JumpToFailingTestAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */