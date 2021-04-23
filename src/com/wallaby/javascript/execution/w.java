package com.wallaby.javascript.execution;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ui.treeStructure.SimpleTree;
import com.wallaby.javascript.actions.CopyExpressionDataAction;
import com.wallaby.javascript.actions.CopyExpressionPathAction;
import com.wallaby.javascript.actions.GoToExpressionSourceAction;
import com.wallaby.javascript.execution.b.f;
import java.util.ArrayList;

class w extends ActionGroup {
  w(n paramn, SimpleTree paramSimpleTree) {}
  
  public AnAction[] getChildren(AnActionEvent e) {
    ArrayList<CopyExpressionDataAction> arrayList = new ArrayList();
    f f = (f)this.a.getSelectedNode();
    if (f != null) {
      if (f.b())
        arrayList.add(new CopyExpressionDataAction(f)); 
      if (f.a())
        arrayList.add(new CopyExpressionPathAction(f)); 
      if (f.g())
        arrayList.add(new GoToExpressionSourceAction(f)); 
    } 
    return arrayList.<AnAction>toArray(new AnAction[0]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */