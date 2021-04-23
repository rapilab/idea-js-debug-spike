package com.wallaby.javascript.execution.testStory;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.Collections;
import java.util.List;

public class TestStoryMultiHostInjector implements MultiHostInjector {
  public void getLanguagesToInject(MultiHostRegistrar registrar, PsiElement context) {
    if (!(context instanceof a))
      return; 
    if (PsiTreeUtil.findChildOfType(context, c.class) == null)
      return; 
    Language language = Language.findLanguageByID("TypeScript");
    if (language == null || LanguageParserDefinitions.INSTANCE.forLanguage(language) == null)
      return; 
    PsiElement psiElement = context.getFirstChild();
    registrar.startInjecting(language);
    registrar.addPlace(null, null, (a)context, TextRange.from(psiElement.getStartOffsetInParent(), psiElement.getTextLength()));
    registrar.doneInjecting();
  }
  
  public List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
    return (List)Collections.singletonList(a.class);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryMultiHostInjector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */