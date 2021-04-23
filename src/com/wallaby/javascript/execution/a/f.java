package com.wallaby.javascript.execution.a;

import com.intellij.ui.treeStructure.SimpleTreeBuilder;
import com.intellij.util.ui.tree.TreeUtil;
import com.wallaby.javascript.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class f {
  private SimpleTreeBuilder a;
  
  private final m b;
  
  private final Map<String, g> c = new HashMap<>();
  
  public f(SimpleTreeBuilder paramSimpleTreeBuilder, m paramm) {
    this.a = paramSimpleTreeBuilder;
    this.b = paramm;
  }
  
  void a(g paramg) {
    this.c.put(paramg.a(), paramg);
  }
  
  public void a() {
    ArrayList<String> arrayList1 = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();
    DefaultMutableTreeNode defaultMutableTreeNode = this.a.getRootNode();
    if (defaultMutableTreeNode == null)
      return; 
    JTree jTree = this.a.getTree();
    a(jTree, defaultMutableTreeNode, arrayList1, arrayList2);
    this.a.addSubtreeToUpdate(defaultMutableTreeNode, () -> {
          if (this.a.isDisposed() || this.c.isEmpty())
            return; 
          String[] arrayOfString = (String[])this.c.keySet().toArray((Object[])new String[this.c.keySet().size()]);
          for (String str : arrayOfString) {
            g g = this.c.get(str);
            if (g != null) {
              DefaultMutableTreeNode defaultMutableTreeNode = this.a.getUi().getNodeForElement(g, false);
              if (defaultMutableTreeNode != null && paramArrayList1.contains(str))
                paramJTree.expandPath(TreeUtil.getPathFromRoot(defaultMutableTreeNode)); 
            } 
          } 
          paramJTree.clearSelection();
          for (String str : paramArrayList2) {
            g g = this.c.get(str);
            if (g == null)
              continue; 
            DefaultMutableTreeNode defaultMutableTreeNode = this.a.getUi().getNodeForElement(g, false);
            if (defaultMutableTreeNode != null) {
              TreePath treePath = new TreePath((Object[])defaultMutableTreeNode.getPath());
              paramJTree.addSelectionPath(treePath);
            } 
          } 
          this.c.clear();
        });
  }
  
  private static void a(JTree paramJTree, DefaultMutableTreeNode paramDefaultMutableTreeNode, List<String> paramList1, List<String> paramList2) {
    List<TreeNode> list = a(paramDefaultMutableTreeNode);
    for (TreeNode treeNode : list) {
      DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treeNode;
      TreePath treePath = new TreePath((Object[])defaultMutableTreeNode.getPath());
      if (defaultMutableTreeNode.getUserObject() == null)
        return; 
      if (!(defaultMutableTreeNode.getUserObject() instanceof g))
        return; 
      g g = (g)defaultMutableTreeNode.getUserObject();
      if (g == null)
        return; 
      if (paramJTree.isPathSelected(treePath))
        paramList2.add(g.a()); 
      if (paramJTree.isExpanded(treePath) || defaultMutableTreeNode.getChildCount() == 0) {
        paramList1.add(g.a());
        a(paramJTree, defaultMutableTreeNode, paramList1, paramList2);
      } 
    } 
  }
  
  private static List<TreeNode> a(TreeNode paramTreeNode) {
    int i = paramTreeNode.getChildCount();
    ArrayList<TreeNode> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++) {
      TreeNode treeNode = paramTreeNode.getChildAt(b);
      arrayList.add(treeNode);
    } 
    return arrayList;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */