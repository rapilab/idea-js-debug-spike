package com.wallaby.javascript.execution.testStory;

import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.tree.CompositePsiElement;
import com.intellij.psi.impl.source.tree.injected.InjectionBackgroundSuppressor;
import com.intellij.psi.tree.IElementType;

public class a extends CompositePsiElement implements PsiLanguageInjectionHost, InjectionBackgroundSuppressor {
  public a(IElementType paramIElementType) {
    super(paramIElementType);
  }
  
  public boolean isValidHost() {
    return true;
  }
  
  public PsiLanguageInjectionHost updateText(String s) {
    return null;
  }
  
  public LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
    return new b(this, this);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */