package com.wallaby.javascript.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.m;

public abstract class LoadTruncatedTestStoryAction extends WallabyControllerAction {
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext());
    if (editor == null)
      return; 
    Project project = editor.getProject();
    if (project == null)
      return; 
    VirtualFile virtualFile = ((EditorEx)editor).getVirtualFile();
    if (!(virtualFile instanceof o))
      return; 
    o o = (o)virtualFile;
    paramm.a(Integer.valueOf(a(o)), null, o::i);
  }
  
  protected boolean d(AnActionEvent paramAnActionEvent, m paramm) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext());
    if (editor == null)
      return false; 
    VirtualFile virtualFile = ((EditorEx)editor).getVirtualFile();
    if (!(virtualFile instanceof o))
      return false; 
    o o = (o)virtualFile;
    return o.l() ? false : ((o.c() || o.b()));
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(paramAnActionEvent.getDataContext());
    if (editor == null)
      return false; 
    VirtualFile virtualFile = ((EditorEx)editor).getVirtualFile();
    if (!(virtualFile instanceof o))
      return false; 
    o o = (o)virtualFile;
    return o.l() ? false : a(o, paramm);
  }
  
  public abstract boolean a(o paramo, m paramm);
  
  public abstract int a(o paramo);
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/LoadTruncatedTestStoryAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */