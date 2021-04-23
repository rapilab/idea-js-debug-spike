package com.wallaby.javascript.execution.testStory;

import com.intellij.lexer.LexerBase;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IElementType;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;

public class k extends LexerBase {
  private CharSequence b;
  
  private int c;
  
  private Project d;
  
  private TestStory.LexicalRegion[] e;
  
  public k(Project paramProject) {
    this.d = paramProject;
  }
  
  public void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
    o o = WallabyController.a(this.d).p();
    if (!a && o == null)
      throw new AssertionError(); 
    this.b = buffer;
    this.e = o.g();
  }
  
  public int getState() {
    return this.c;
  }
  
  public IElementType getTokenType() {
    if (this.c >= this.e.length)
      return null; 
    TestStory.LexicalRegion lexicalRegion = this.e[this.c];
    return (lexicalRegion.a() == TestStory.ContentRegionType.CODE) ? e.c : n.a;
  }
  
  public int getTokenStart() {
    return (this.c >= this.e.length) ? getBufferEnd() : this.e[this.c].b();
  }
  
  public int getTokenEnd() {
    return (this.c >= this.e.length) ? getBufferEnd() : this.e[this.c].c();
  }
  
  public void advance() {
    this.c++;
  }
  
  public CharSequence getBufferSequence() {
    return this.b;
  }
  
  public int getBufferEnd() {
    return this.b.length();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */