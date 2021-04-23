package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public abstract class a extends AnAction {
  public a() {
    super(a.a.a);
  }
  
  public final void actionPerformed(AnActionEvent e) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(e.getDataContext());
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(e.getDataContext());
    if (editor == null)
      return; 
    b b = wallabyController.a(editor);
    if (b == null)
      return; 
    String str = b.d();
    a(e, project, (m)wallabyController, editor, b, str);
  }
  
  protected abstract void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString);
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */