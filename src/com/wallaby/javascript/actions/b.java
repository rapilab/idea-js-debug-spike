package com.wallaby.javascript.actions;

import a.a;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Iconable;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.k;
import com.wallaby.javascript.m;
import javax.swing.Icon;

public abstract class b implements IntentionAction, Iconable {
  private Icon a = a.a;
  
  public final String getText() {
    return k.a("intention.action.text." + getClass().getSimpleName(), new Object[0]);
  }
  
  public final String getFamilyName() {
    return getText();
  }
  
  public final boolean isAvailable(Project project, Editor editor, PsiFile file) {
    if (editor == null)
      return false; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return false; 
    com.wallaby.javascript.b b1 = wallabyController.a(editor);
    if (b1 == null)
      return false; 
    String str = b1.d();
    this.a = wallabyController.g() ? a.b : a.a;
    return a((m)wallabyController, editor, b1, str);
  }
  
  protected abstract boolean a(m paramm, Editor paramEditor, com.wallaby.javascript.b paramb, String paramString);
  
  public final void invoke(Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
    if (editor == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    com.wallaby.javascript.b b1 = wallabyController.a(editor);
    if (b1 == null)
      return; 
    String str = b1.d();
    b((m)wallabyController, editor, b1, str);
  }
  
  protected abstract void b(m paramm, Editor paramEditor, com.wallaby.javascript.b paramb, String paramString);
  
  public final boolean startInWriteAction() {
    return false;
  }
  
  public Icon getIcon(int flags) {
    return this.a;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */