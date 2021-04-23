package com.wallaby.javascript.execution;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiUtilBase;
import com.intellij.refactoring.listeners.UndoRefactoringElementAdapter;
import com.wallaby.javascript.b.a;

class k extends UndoRefactoringElementAdapter {
  k(j paramj) {}
  
  protected void refactored(PsiElement element, String oldQualifiedName) {
    VirtualFile virtualFile = PsiUtilBase.asVirtualFile(element);
    if (virtualFile != null) {
      String str = FileUtil.toSystemDependentName(virtualFile.getPath());
      b b = new b(str, j.a(this.a).b(), j.a(this.a).c(), j.a(this.a).e(), j.a(this.a).f());
      a a = this.a.a().d();
      if (a != null) {
        b.a(a);
        this.a.a(b);
      } 
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */