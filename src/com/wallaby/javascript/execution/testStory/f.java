package com.wallaby.javascript.execution.testStory;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public class f extends PsiFileBase {
  public f(FileViewProvider paramFileViewProvider) {
    super(paramFileViewProvider, TestStoryLanguage.INSTANCE);
  }
  
  public FileType getFileType() {
    return (FileType)TestStoryFileType.INSTANCE;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */