package com.wallaby.javascript.execution.testStory;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.SingleRootFileViewProvider;

public class j extends SingleRootFileViewProvider {
  public j(PsiManager paramPsiManager, VirtualFile paramVirtualFile, boolean paramBoolean) {
    super(paramPsiManager, paramVirtualFile, paramBoolean);
  }
  
  protected PsiFile createFile(Language lang) {
    ParserDefinition parserDefinition = (ParserDefinition)LanguageParserDefinitions.INSTANCE.forLanguage(lang);
    return (parserDefinition == null) ? null : parserDefinition.createFile((FileViewProvider)this);
  }
  
  public Language getBaseLanguage() {
    return TestStoryLanguage.INSTANCE;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */