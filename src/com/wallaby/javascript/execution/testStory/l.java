package com.wallaby.javascript.execution.testStory;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

public class l implements PsiParser {
  public ASTNode parse(IElementType root, PsiBuilder builder) {
    PsiBuilder.Marker marker = builder.mark();
    while (!builder.eof()) {
      IElementType iElementType = builder.lookAhead(1);
      if (iElementType == e.c) {
        builder.advanceLexer();
        PsiBuilder.Marker marker1 = builder.mark();
        builder.advanceLexer();
        marker1.done(e.b);
        continue;
      } 
      builder.advanceLexer();
    } 
    marker.done(root);
    return builder.getTreeBuilt();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */