package com.wallaby.javascript.execution.testStory;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

public class TestStoryParserDefinition implements ParserDefinition {
  public Lexer createLexer(Project project) {
    return (Lexer)new k(project);
  }
  
  public PsiParser createParser(Project project) {
    return new l();
  }
  
  public IFileElementType getFileNodeType() {
    return e.a;
  }
  
  public TokenSet getCommentTokens() {
    return TokenSet.EMPTY;
  }
  
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }
  
  public PsiElement createElement(ASTNode node) {
    IElementType iElementType = node.getElementType();
    return (PsiElement)((iElementType == e.b) ? node : new ASTWrapperPsiElement(node));
  }
  
  public PsiFile createFile(FileViewProvider provider) {
    return (PsiFile)new f(provider);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryParserDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */