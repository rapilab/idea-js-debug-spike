package com.wallaby.javascript;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceTestSelectionRequested;
import com.wallaby.javascript.extendedCore.outboundMessages.RunTests;
import javax.swing.Icon;

class q extends AnAction {
  q(WallabyController paramWallabyController, String paramString1, String paramString2, Icon paramIcon, TraceTestSelectionRequested paramTraceTestSelectionRequested, TraceTestSelectionRequested.TraceTestSelectionData paramTraceTestSelectionData) {
    super(paramString1, paramString2, paramIcon);
  }
  
  public void actionPerformed(AnActionEvent event) {
    RunTests.RunTestParameters runTestParameters = this.a.b();
    WallabyController.e(this.c).a(new RunTests(runTestParameters.a(), runTestParameters.b().intValue(), true, this.b.c()));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */