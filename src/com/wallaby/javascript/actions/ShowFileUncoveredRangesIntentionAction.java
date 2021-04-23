package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class ShowFileUncoveredRangesIntentionAction extends b {
  protected boolean a(m paramm, Editor paramEditor, b paramb, String paramString) {
    return paramb.g();
  }
  
  protected void b(m paramm, Editor paramEditor, b paramb, String paramString) {
    paramm.e(paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ShowFileUncoveredRangesIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */