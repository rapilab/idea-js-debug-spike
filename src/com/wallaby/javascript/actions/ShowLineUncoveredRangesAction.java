package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class ShowLineUncoveredRangesAction extends g {
  protected void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    paramm.f(paramString, paramInt);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ShowLineUncoveredRangesAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */