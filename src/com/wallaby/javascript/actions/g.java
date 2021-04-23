package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public abstract class g extends a {
  protected void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString) {
    f f = paramb.a(paramEditor.getCaretModel().getOffset());
    if (f == null)
      return; 
    a(paramAnActionEvent, paramProject, paramm, paramEditor, paramb, paramString, f.k());
  }
  
  protected abstract void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString, int paramInt);
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */