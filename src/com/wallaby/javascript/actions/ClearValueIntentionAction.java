package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;
import com.wallaby.javascript.v;

public class ClearValueIntentionAction extends h {
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    if (paramb.h()) {
      f f = paramb.b(paramInt - 1);
      return (f != null && f.g() && paramm.a(v.h));
    } 
    return false;
  }
  
  protected void a(m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    paramm.a(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ClearValueIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */