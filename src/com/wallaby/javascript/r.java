package com.wallaby.javascript;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;

class r implements ProjectManagerListener {
  r(WallabyController paramWallabyController) {}
  
  public void projectClosing(Project project) {
    WallabyController.b(this.a);
    if (WallabyController.c(this.a) != null) {
      WallabyController.c(this.a).dispose();
      WallabyController.a(this.a, (t)null);
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */