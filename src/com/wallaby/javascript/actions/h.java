package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public abstract class h extends b {
  protected boolean a(m paramm, Editor paramEditor, b paramb, String paramString) {
    f f = paramb.a(paramEditor.getCaretModel().getOffset());
    return (f == null) ? false : a(paramm, paramb, paramString, f.k());
  }
  
  protected abstract boolean a(m paramm, b paramb, String paramString, int paramInt);
  
  protected void b(m paramm, Editor paramEditor, b paramb, String paramString) {
    f f = paramb.a(paramEditor.getCaretModel().getOffset());
    if (f == null)
      return; 
    a(paramm, paramEditor, paramb, paramString, f.k());
  }
  
  protected abstract void a(m paramm, Editor paramEditor, b paramb, String paramString, int paramInt);
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */