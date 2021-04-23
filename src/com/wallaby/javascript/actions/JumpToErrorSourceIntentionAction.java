package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.CoverageState;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public class JumpToErrorSourceIntentionAction extends h {
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    f f = paramb.b(paramInt - 1);
    return (f == null) ? false : ((f.a() == CoverageState.ERROR_PATH || f.a() == CoverageState.ERROR_SOURCE) ? true : paramm.e(paramString, paramInt));
  }
  
  protected void a(m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    paramm.d(paramString, paramInt);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/JumpToErrorSourceIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */