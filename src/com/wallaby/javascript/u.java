package com.wallaby.javascript;

import com.intellij.openapi.editor.event.SelectionEvent;
import com.intellij.openapi.editor.event.SelectionListener;

class u implements SelectionListener {
  u(t paramt) {}
  
  public void selectionChanged(SelectionEvent e) {
    if (t.a(this.a) != null)
      t.a(this.a).consume(e); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */