package com.wallaby.javascript.execution.testStory;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;

public class TestStoryFileViewProviderFactory implements FileViewProviderFactory {
  public FileViewProvider createFileViewProvider(VirtualFile file, Language language, PsiManager manager, boolean eventSystemEnabled) {
    return (FileViewProvider)new j(manager, file, eventSystemEnabled);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryFileViewProviderFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */