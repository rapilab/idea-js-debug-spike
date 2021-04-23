package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.text.StringUtil;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public class RevealValueIntentionAction extends h {
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    if (!paramm.y())
      return false; 
    f f = paramb.b(paramInt - 1);
    return (f != null && !f.d() && !StringUtil.isEmpty(f.c()));
  }
  
  protected void a(m paramm, Editor paramEditor, b paramb, String paramString, int paramInt) {
    if (paramm.y()) {
      f f = paramb.b(paramInt - 1);
      if (f != null && !f.d() && !StringUtil.isEmpty(f.c()))
        paramm.j(paramString, f.k()); 
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/RevealValueIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */