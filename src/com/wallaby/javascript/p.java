package com.wallaby.javascript;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;

class p extends Task.Backgroundable {
  p(WallabyController paramWallabyController, Project paramProject, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramProject, paramString, paramBoolean1);
  }
  
  public void run(ProgressIndicator indicator) {
    indicator.setIndeterminate(true);
    WallabyController.a(this.b).a(indicator, this.a);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */