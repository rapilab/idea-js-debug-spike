package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.CoverageState;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public class ProfileTestIntentionAction extends h {
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    return a(paramm, paramb, paramInt);
  }
  
  public static boolean a(m paramm, b paramb, int paramInt) {
    f f = paramb.b(paramInt - 1);
    return (f == null) ? false : ((f.a() == CoverageState.NOT_COVERED) ? false : ((paramm.T() && paramm.U())));
  }
  
  protected void a(m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    f f = paramb.b(paramInt - 1);
    if (f == null)
      return; 
    if (f.a() == CoverageState.NOT_COVERED)
      return; 
    paramm.k(paramString, f.k());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ProfileTestIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */