package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.CoverageState;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public class DebugStartAction extends WallabyControllerAction {
  public DebugStartAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.h);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    a((Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext()), paramm, null);
  }
  
  public static void a(Editor paramEditor, m paramm, Runnable paramRunnable) {
    if (paramEditor == null)
      return; 
    b b = paramm.a(paramEditor);
    if (b == null)
      return; 
    f f = b.a(paramEditor.getCaretModel().getOffset());
    if (f == null)
      return; 
    if (f.a() == CoverageState.NOT_COVERED)
      return; 
    String str = b.d();
    paramm.a(paramEditor, str, f.k(), paramRunnable);
  }
  
  public static boolean c(AnActionEvent paramAnActionEvent, m paramm) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext());
    if (editor == null)
      return false; 
    b b = paramm.a(editor);
    if (b == null)
      return false; 
    f f = b.a(editor.getCaretModel().getOffset());
    return (f == null) ? false : ((f.a() == CoverageState.NOT_COVERED) ? false : paramm.y());
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return c(paramAnActionEvent, paramm);
  }
  
  protected boolean d(AnActionEvent paramAnActionEvent, m paramm) {
    return paramm.R();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/DebugStartAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */