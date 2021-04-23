package com.wallaby.javascript.settings;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter;

class b extends PlainSyntaxHighlighter {
  b(WallabyColorSettingsPage paramWallabyColorSettingsPage) {}
  
  public Lexer getHighlightingLexer() {
    return (Lexer)new c(this);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/settings/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */