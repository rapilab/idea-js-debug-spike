package com.wallaby.javascript.execution.testStory;

import com.intellij.lang.ASTFactory;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;

public class TestStoryASTFactory extends ASTFactory {
  public CompositeElement createComposite(IElementType type) {
    return (CompositeElement)((type == e.b) ? new a(type) : super.createComposite(type));
  }
  
  public LeafElement createLeaf(IElementType type, CharSequence text) {
    return (LeafElement)((type == e.c) ? new c(type, text) : super.createLeaf(type, text));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryASTFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */