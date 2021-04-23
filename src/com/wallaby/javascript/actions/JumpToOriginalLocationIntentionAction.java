package com.wallaby.javascript.actions;

import a.a;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.injected.editor.EditorWindow;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import com.wallaby.javascript.k;
import javax.swing.Icon;

public class JumpToOriginalLocationIntentionAction implements IntentionAction, Iconable {
  private Icon a = a.a;
  
  public final String getText() {
    return k.a("intention.action.text." + getClass().getSimpleName(), new Object[0]);
  }
  
  public final String getFamilyName() {
    return getText();
  }
  
  public boolean isAvailable(Project project, Editor editor, PsiFile file) {
    if (editor == null)
      return false; 
    if (editor instanceof EditorWindow)
      editor = ((EditorWindow)editor).getDelegate(); 
    VirtualFile virtualFile = ((EditorEx)editor).getVirtualFile();
    if (!(virtualFile instanceof o))
      return false; 
    o o = (o)virtualFile;
    if (o.l())
      return false; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return false; 
    this.a = wallabyController.g() ? a.b : a.a;
    TestStory.OriginalLineData originalLineData = o.b((editor.getCaretModel().getLogicalPosition()).line);
    return (originalLineData != null);
  }
  
  public void invoke(Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
    if (editor == null)
      return; 
    if (editor instanceof EditorWindow)
      editor = ((EditorWindow)editor).getDelegate(); 
    VirtualFile virtualFile1 = ((EditorEx)editor).getVirtualFile();
    if (!(virtualFile1 instanceof o))
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    LogicalPosition logicalPosition = editor.getCaretModel().getLogicalPosition();
    TestStory.OriginalLineData originalLineData = ((o)virtualFile1).b(logicalPosition.line);
    if (originalLineData == null)
      return; 
    VirtualFile virtualFile2 = wallabyController.b(originalLineData.a());
    ApplicationManager.getApplication().invokeLater(() -> {
          OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(paramProject, paramVirtualFile, paramOriginalLineData.b(), paramLogicalPosition.column);
          try {
            openFileDescriptor.navigate(true);
          } catch (Exception exception) {
            WallabyController.a.warn(exception);
          } 
        });
  }
  
  public boolean startInWriteAction() {
    return false;
  }
  
  public Icon getIcon(int flags) {
    return this.a;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/JumpToOriginalLocationIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */