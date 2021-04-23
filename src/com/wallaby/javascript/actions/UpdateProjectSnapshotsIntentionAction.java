package com.wallaby.javascript.actions;

import com.intellij.openapi.editor.Editor;
import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class UpdateProjectSnapshotsIntentionAction extends RunAllTestsIntentionAction {
  protected boolean a(m paramm, Editor paramEditor, b paramb, String paramString) {
    return (super.a(paramm, paramEditor, paramb, paramString) && paramm.u());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/UpdateProjectSnapshotsIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */