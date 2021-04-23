package com.wallaby.javascript.execution.testStory;

import com.intellij.codeInsight.highlighting.HighlightErrorFilter;
import com.intellij.injected.editor.VirtualFileWindow;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;

public class TestStoryHighlightErrorFilter extends HighlightErrorFilter {
  public boolean shouldHighlightErrorElement(PsiErrorElement element) {
    PsiFile psiFile = element.getContainingFile();
    if (psiFile == null)
      return true; 
    VirtualFile virtualFile = psiFile.getVirtualFile();
    if (virtualFile == null)
      return true; 
    if (virtualFile instanceof VirtualFileWindow) {
      VirtualFile virtualFile1 = ((VirtualFileWindow)virtualFile).getDelegate();
      return !(virtualFile1 instanceof o);
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryHighlightErrorFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */