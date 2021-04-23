package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class ShowAssertionErrorDiffIntentionAction extends h {
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    return paramm.h(paramString, paramInt);
  }
  
  protected void a(m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    paramm.g(paramString, paramInt);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ShowAssertionErrorDiffIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */