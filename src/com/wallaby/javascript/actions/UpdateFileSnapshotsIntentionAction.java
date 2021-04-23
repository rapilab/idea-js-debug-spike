package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class UpdateFileSnapshotsIntentionAction extends RunTestFileIntentionAction {
  protected boolean a(m paramm, Editor paramEditor, b paramb, String paramString) {
    return (super.a(paramm, paramEditor, paramb, paramString) && paramm.f(paramString));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/UpdateFileSnapshotsIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */