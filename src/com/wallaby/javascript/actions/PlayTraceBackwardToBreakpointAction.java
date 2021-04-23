package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.m;

public class PlayTraceBackwardToBreakpointAction extends WallabyControllerAction {
  public PlayTraceBackwardToBreakpointAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.r);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.b(PlayTraceForwardToBreakpointAction.a(paramm));
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return (paramm.D() && (PlayTraceForwardToBreakpointAction.a(paramm)).length > 0);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTraceBackwardToBreakpointAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */