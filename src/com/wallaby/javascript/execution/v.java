package com.wallaby.javascript.execution;

import com.intellij.ide.util.treeView.AbstractTreeStructure;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;
import java.util.Comparator;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

class v extends SimpleTreeBuilder {
  v(n paramn, JTree paramJTree, DefaultTreeModel paramDefaultTreeModel, AbstractTreeStructure paramAbstractTreeStructure, Comparator paramComparator) {
    super(paramJTree, paramDefaultTreeModel, paramAbstractTreeStructure, paramComparator);
  }
  
  protected boolean isSmartExpand() {
    return false;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */