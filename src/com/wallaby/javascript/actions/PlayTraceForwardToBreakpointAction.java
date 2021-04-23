package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.xdebugger.XDebuggerManager;
import com.intellij.xdebugger.breakpoints.XBreakpoint;
import com.intellij.xdebugger.breakpoints.XBreakpointManager;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;
import com.wallaby.javascript.extendedCore.outboundMessages.LineLocation;
import com.wallaby.javascript.m;
import java.util.ArrayList;

public class PlayTraceForwardToBreakpointAction extends WallabyControllerAction {
  public PlayTraceForwardToBreakpointAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.q);
  }
  
  protected void a(AnActionEvent paramAnActionEvent, m paramm) {
    paramm.a(a(paramm));
  }
  
  protected boolean b(AnActionEvent paramAnActionEvent, m paramm) {
    return (paramm.E() && (a(paramm)).length > 0);
  }
  
  public static LineLocation[] a(m paramm) {
    ArrayList<LineLocation> arrayList = new ArrayList();
    XBreakpointManager xBreakpointManager = XDebuggerManager.getInstance(paramm.d()).getBreakpointManager();
    for (XBreakpoint xBreakpoint : xBreakpointManager.getAllBreakpoints()) {
      if (xBreakpoint != null && xBreakpoint.isEnabled() && xBreakpoint instanceof XLineBreakpoint) {
        XLineBreakpoint xLineBreakpoint = (XLineBreakpoint)xBreakpoint;
        String str = paramm.e().a(xLineBreakpoint.getPresentableFilePath());
        arrayList.add(new LineLocation(str, xLineBreakpoint.getLine() + 1));
      } 
    } 
    return arrayList.<LineLocation>toArray(new LineLocation[0]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/PlayTraceForwardToBreakpointAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */