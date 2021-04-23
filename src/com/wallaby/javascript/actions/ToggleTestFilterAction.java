package com.wallaby.javascript.actions;

import com.intellij.icons.AllIcons;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.wallaby.javascript.b;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterTestSelectionRequested;
import com.wallaby.javascript.m;

public class ToggleTestFilterAction extends g {
  protected void a(AnActionEvent paramAnActionEvent, Project paramProject, m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    paramm.a(paramString, paramInt, paramArrayOfTest -> ApplicationManager.getApplication().invokeLater(()));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ToggleTestFilterAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */