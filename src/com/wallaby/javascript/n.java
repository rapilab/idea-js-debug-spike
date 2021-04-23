package com.wallaby.javascript;

import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.LightweightWindowEvent;

class n extends WallabyController.b {
  n(WallabyController paramWallabyController, JBPopup paramJBPopup) {
    super(paramWallabyController);
  }
  
  public void onClosed(LightweightWindowEvent event) {
    this.a.dispose();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */