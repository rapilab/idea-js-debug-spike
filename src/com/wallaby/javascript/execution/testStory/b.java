package com.wallaby.javascript.execution.testStory;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.util.PsiTreeUtil;

class b extends LiteralTextEscaper<PsiLanguageInjectionHost> {
  b(a parama, PsiLanguageInjectionHost paramPsiLanguageInjectionHost) {
    super(paramPsiLanguageInjectionHost);
  }
  
  public boolean decode(TextRange rangeInsideHost, StringBuilder outChars) {
    outChars.append(rangeInsideHost.substring(this.myHost.getText()));
    return true;
  }
  
  public int getOffsetInHost(int offsetInDecoded, TextRange rangeInsideHost) {
    return rangeInsideHost.getStartOffset() + offsetInDecoded;
  }
  
  public TextRange getRelevantTextRange() {
    return a();
  }
  
  public TextRange a() {
    c c1 = (c)PsiTreeUtil.findChildOfType((PsiElement)this.myHost, c.class);
    if (c1 == null)
      return TextRange.EMPTY_RANGE; 
    c c2 = null;
    for (PsiElement psiElement = this.myHost.getLastChild(); psiElement != null; psiElement = psiElement.getPrevSibling()) {
      if (psiElement instanceof c) {
        c2 = (c)psiElement;
        break;
      } 
    } 
    if (!a && c2 == null)
      throw new AssertionError(); 
    return TextRange.create(c1.getStartOffsetInParent(), c2.getStartOffsetInParent() + c2.getTextLength());
  }
  
  public boolean isOneLine() {
    return false;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */