package com.wallaby.javascript.actions;

import com.wallaby.javascript.b;
import com.wallaby.javascript.m;

public class UpdateTestSnapshotsIntentionAction extends RunTestIntentionAction {
  protected boolean b = false;
  
  public UpdateTestSnapshotsIntentionAction() {
    this.b = true;
  }
  
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    return (super.a(paramm, paramb, paramString, paramInt) && paramm.i(paramString, paramInt));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/UpdateTestSnapshotsIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */