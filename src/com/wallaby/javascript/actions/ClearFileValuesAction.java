package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;
import com.wallaby.javascript.v;

public class ClearFileValuesAction extends a {
  protected void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString) {
    if (paramb.h() && paramm.a(v.h))
      paramm.a(paramString, null); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ClearFileValuesAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */