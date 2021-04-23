package com.wallaby.javascript.actions;

import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupListener;
import com.intellij.openapi.ui.popup.LightweightWindowEvent;

final class k implements JBPopupListener {
  k(JBPopup paramJBPopup) {}
  
  public void onClosed(LightweightWindowEvent event) {
    this.a.dispose();
  }
  
  public void beforeShown(LightweightWindowEvent event) {}
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */