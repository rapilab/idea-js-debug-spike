package com.wallaby.javascript.execution.b;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;
import com.intellij.util.ui.tree.TreeUtil;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLocation;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionNode;
import com.wallaby.javascript.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class g {
  private final m a;
  
  private final Map<String, f> b = new HashMap<>();
  
  private final Set<String> c = new HashSet<>();
  
  public g(m paramm) {
    this.a = paramm;
  }
  
  void a(String paramString, int paramInt1, int paramInt2) {
    a(this.a.b(paramString), paramInt1, paramInt2);
  }
  
  private void a(VirtualFile paramVirtualFile, int paramInt1, int paramInt2) {
    Project project = this.a.d();
    if (paramInt2 == 0) {
      Document document = FileDocumentManager.getInstance().getDocument(paramVirtualFile);
      if (document != null) {
        String str = document.getText(TextRange.create(document.getLineStartOffset(paramInt1 - 1), document.getLineEndOffset(paramInt1 - 1)));
        paramInt2 = str.indexOf(str.trim());
      } 
    } 
    OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(project, paramVirtualFile, paramInt1 - 1, paramInt2);
    try {
      openFileDescriptor.navigate(true);
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
    } 
  }
  
  void a(String[] paramArrayOfString, d paramd, ExpressionLocation paramExpressionLocation) {
    this.a.a(paramArrayOfString, paramd, paramExpressionLocation);
  }
  
  void a(String paramString) {
    this.a.a(paramString);
  }
  
  void a(ExpressionNode paramExpressionNode) {
    this.a.a(paramExpressionNode);
  }
  
  void a(f paramf) {
    this.b.put(paramf.c(), paramf);
  }
  
  public void a(SimpleTreeBuilder paramSimpleTreeBuilder) {
    this.c.clear();
    ArrayList<String> arrayList1 = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();
    DefaultMutableTreeNode defaultMutableTreeNode = paramSimpleTreeBuilder.getRootNode();
    if (defaultMutableTreeNode == null)
      return; 
    JTree jTree = paramSimpleTreeBuilder.getTree();
    a(jTree, defaultMutableTreeNode, arrayList1, arrayList2);
    paramSimpleTreeBuilder.addSubtreeToUpdate(defaultMutableTreeNode, () -> {
          if (paramSimpleTreeBuilder.isDisposed() || this.b.isEmpty())
            return; 
          for (String str : paramArrayList1) {
            f f = this.b.get(str);
            if (f == null)
              continue; 
            DefaultMutableTreeNode defaultMutableTreeNode = paramSimpleTreeBuilder.getUi().getNodeForElement(f, false);
            if (defaultMutableTreeNode != null)
              paramJTree.expandPath(TreeUtil.getPathFromRoot(defaultMutableTreeNode)); 
          } 
          paramJTree.clearSelection();
          for (String str : paramArrayList2) {
            f f = this.b.get(str);
            if (f == null)
              continue; 
            DefaultMutableTreeNode defaultMutableTreeNode = paramSimpleTreeBuilder.getUi().getNodeForElement(f, false);
            if (defaultMutableTreeNode != null) {
              TreePath treePath = new TreePath((Object[])defaultMutableTreeNode.getPath());
              paramJTree.addSelectionPath(treePath);
            } 
          } 
          this.b.clear();
        });
  }
  
  public boolean b(String paramString) {
    if (this.c.size() > 30)
      return false; 
    this.c.add(paramString);
    return true;
  }
  
  private static void a(JTree paramJTree, DefaultMutableTreeNode paramDefaultMutableTreeNode, List<String> paramList1, List<String> paramList2) {
    List<TreeNode> list = a(paramDefaultMutableTreeNode);
    for (TreeNode treeNode : list) {
      DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treeNode;
      TreePath treePath = new TreePath((Object[])defaultMutableTreeNode.getPath());
      if (defaultMutableTreeNode.getUserObject() == null)
        return; 
      if (!(defaultMutableTreeNode.getUserObject() instanceof f))
        return; 
      f f = (f)defaultMutableTreeNode.getUserObject();
      if (f == null)
        return; 
      if (paramJTree.isPathSelected(treePath))
        paramList2.add(f.c()); 
      if (paramJTree.isExpanded(treePath) || defaultMutableTreeNode.getChildCount() == 0) {
        paramList1.add(f.c());
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


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/b/g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */