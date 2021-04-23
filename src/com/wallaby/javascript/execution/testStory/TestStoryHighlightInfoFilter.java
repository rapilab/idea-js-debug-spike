package com.wallaby.javascript.execution.testStory;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoFilter;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.injected.editor.VirtualFileWindow;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

public class TestStoryHighlightInfoFilter implements HighlightInfoFilter {
  public boolean accept(HighlightInfo info, PsiFile file) {
    if (info.type != HighlightInfoType.ERROR && info.type != HighlightInfoType.WARNING && info.type != HighlightInfoType.WEAK_WARNING && info.type != HighlightInfoType.WRONG_REF && info.type != HighlightInfoType.GENERIC_WARNINGS_OR_ERRORS_FROM_SERVER && info.type != HighlightInfoType.DEPRECATED && info.type != HighlightInfoType.UNUSED_SYMBOL && info.type != HighlightInfoType.MARKED_FOR_REMOVAL && info.type != HighlightInfoType.UNHANDLED_EXCEPTION)
      return true; 
    if (file == null)
      return true; 
    VirtualFile virtualFile = file.getVirtualFile();
    if (virtualFile == null)
      return true; 
    if (virtualFile instanceof VirtualFileWindow) {
      VirtualFile virtualFile1 = ((VirtualFileWindow)virtualFile).getDelegate();
      return !(virtualFile1 instanceof o);
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryHighlightInfoFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */