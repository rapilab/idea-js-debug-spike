package com.wallaby.javascript.execution.a;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.ui.treeStructure.SimpleTree;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.tree.TreePath;

class e implements MouseListener {
  e(d paramd, SimpleTree paramSimpleTree) {}
  
  public void mouseClicked(MouseEvent mouseEvent) {}
  
  public void mousePressed(MouseEvent mouseEvent) {
    if (!mouseEvent.isPopupTrigger() && mouseEvent.getClickCount() > 0 && mouseEvent.getClickCount() % 2 == 1) {
      TreePath treePath = this.b.getClosestPathForLocation(mouseEvent.getX(), mouseEvent.getY());
      Runnable runnable = () -> this.b.getNodeFor(paramTreePath).handleDoubleClickOrEnter(paramSimpleTree, paramMouseEvent);
      ApplicationManager.getApplication().invokeLater(runnable, ModalityState.stateForComponent((Component)this.a));
    } 
  }
  
  public void mouseReleased(MouseEvent mouseEvent) {}
  
  public void mouseEntered(MouseEvent mouseEvent) {}
  
  public void mouseExited(MouseEvent mouseEvent) {}
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */