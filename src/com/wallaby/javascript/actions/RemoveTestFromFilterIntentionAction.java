package com.wallaby.javascript.actions;

import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.m;

public class RemoveTestFromFilterIntentionAction extends AddTestToFilterIntentionAction {
  protected boolean a(m paramm, b paramb, String paramString, int paramInt) {
    f f = paramb.b(paramInt - 1);
    return (f != null && f.d() && f.e());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/RemoveTestFromFilterIntentionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */