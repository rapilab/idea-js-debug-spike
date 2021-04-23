package com.wallaby.javascript.settings;

import com.intellij.lang.Language;
import com.intellij.lexer.EmptyLexer;
import com.intellij.psi.tree.IElementType;

class c extends EmptyLexer {
  private boolean b;
  
  c(b paramb) {}
  
  public IElementType getTokenType() {
    if (this.b)
      return null; 
    this.b = true;
    return new IElementType("empty token", Language.ANY);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/settings/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */