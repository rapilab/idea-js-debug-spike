package com.wallaby.javascript;

import com.intellij.execution.ExecutionManager;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.ui.RunContentDescriptor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

class x extends MouseInputAdapter {
  x(w paramw, m paramm) {}
  
  public void mouseClicked(MouseEvent mouseEvent) {
    ExecutionManager executionManager = ExecutionManager.getInstance(this.a.d());
    RunContentDescriptor runContentDescriptor = this.a.c();
    if (runContentDescriptor == null)
      return; 
    executionManager.getContentManager().toFrontRunContent(DefaultRunExecutor.getRunExecutorInstance(), runContentDescriptor);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */