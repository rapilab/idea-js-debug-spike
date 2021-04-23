package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class ShowValueAction extends g {
  public String a() {
    return "show";
  }
  
  protected void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    SelectionModel selectionModel = paramEditor.getSelectionModel();
    if (!selectionModel.hasSelection())
      return; 
    int i = selectionModel.getSelectionStart();
    int j = selectionModel.getSelectionEnd();
    LogicalPosition logicalPosition1 = paramEditor.offsetToLogicalPosition(i);
    LogicalPosition logicalPosition2 = paramEditor.offsetToLogicalPosition(j);
    int[] arrayOfInt = { logicalPosition1.line + 1, logicalPosition1.column, logicalPosition2.line + 1, logicalPosition2.column };
    paramm.a(paramb, arrayOfInt, a());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ShowValueAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */