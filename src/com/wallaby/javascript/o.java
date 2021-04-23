package com.wallaby.javascript;

import com.intellij.ui.DocumentAdapter;
import javax.swing.event.DocumentEvent;

class o extends DocumentAdapter {
  o(WallabyController paramWallabyController, Runnable paramRunnable) {}
  
  protected void textChanged(DocumentEvent event) {
    this.a.run();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */