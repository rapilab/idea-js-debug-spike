package com.wallaby.javascript.actions;

import com.intellij.execution.filters.HyperlinkInfo;
import com.intellij.execution.testframework.actions.ViewAssertEqualsDiffAction;
import com.intellij.execution.testframework.stacktrace.DiffHyperlink;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import com.wallaby.javascript.WallabyController;
import java.lang.reflect.Method;

public class j implements HyperlinkInfo {
  private final String a;
  
  private final String b;
  
  private final Runnable c;
  
  public j(String paramString1, String paramString2, Runnable paramRunnable) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramRunnable;
  }
  
  public void navigate(Project project) {
    DiffHyperlink diffHyperlink = new DiffHyperlink(this.a, this.b, null);
    try {
      Method method = diffHyperlink.getClass().getMethod("openDiff", new Class[] { Project.class });
      method.invoke(diffHyperlink, new Object[] { project });
    } catch (Exception exception) {
      try {
        Method method = ViewAssertEqualsDiffAction.class.getMethod("openDiff", new Class[] { DataContext.class, DiffHyperlink.class });
        WindowManager windowManager = WindowManager.getInstance();
        method.invoke(null, new Object[] { DataManager.getInstance().getDataContext(windowManager.getFrame(project)), diffHyperlink });
      } catch (Exception exception1) {
        WallabyController.a.warn("Can not find the openDiff method", exception1);
      } 
    } 
    if (this.c != null)
      this.c.run(); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */