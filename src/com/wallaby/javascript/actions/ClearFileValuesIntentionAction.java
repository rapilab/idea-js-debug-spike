package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;
import com.wallaby.javascript.v;

public class ClearFileValuesIntentionAction extends b {
  protected boolean a(m paramm, Editor paramEditor, b paramb, String paramString) {
    if (paramb.h()) {
      f f = paramb.a(paramEditor.getCaretModel().getOffset());
      return (f != null && f.g()) ? false : paramm.a(v.h);
    } 
    return false;
  }
  
  protected void b(m paramm, Editor paramEditor, b paramb, String paramString) {
    paramm.a(paramString, null);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ClearFileValuesIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */