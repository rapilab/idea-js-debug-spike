package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.wallaby.javascript.CoverageState;
import com.wallaby.javascript.b;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public class PlayTraceForwardToSelectionAction extends WallabyControllerAction {
  public PlayTraceForwardToSelectionAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.j);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext());
    if (editor == null)
      return; 
    VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(editor.getDocument());
    if (virtualFile instanceof o) {
      o o = (o)virtualFile;
      TestStory.OriginalLineData originalLineData = o.b((editor.getCaretModel().getLogicalPosition()).line);
      if (originalLineData == null || originalLineData.c() == null)
        return; 
      paramm.b(originalLineData.a(), originalLineData.b() + 1, originalLineData.c());
    } else {
      b b = paramm.a(editor);
      if (b == null)
        return; 
      String str = b.d();
      f f = b.a(editor.getCaretModel().getOffset());
      if (f == null)
        return; 
      if (f.a() == CoverageState.NOT_COVERED)
        return; 
      paramm.b(str, f.k(), null);
    } 
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext());
    if (editor == null)
      return false; 
    VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(editor.getDocument());
    if (virtualFile instanceof o) {
      o o = (o)virtualFile;
      TestStory.OriginalLineData originalLineData = o.b((editor.getCaretModel().getLogicalPosition()).line);
      return (originalLineData != null && originalLineData.c() != null);
    } 
    b b = paramm.a(editor);
    if (b == null)
      return false; 
    f f = b.a(editor.getCaretModel().getOffset());
    return (f == null) ? false : ((f.a() == CoverageState.NOT_COVERED) ? false : paramm.C());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTraceForwardToSelectionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */