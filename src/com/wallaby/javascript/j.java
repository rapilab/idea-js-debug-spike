package com.wallaby.javascript;

import com.intellij.execution.impl.ConsoleViewImpl;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.ui.popup.JBPopupListener;
import com.intellij.openapi.ui.popup.LightweightWindowEvent;

class j implements JBPopupListener {
  j(h.a parama) {}
  
  public void beforeShown(LightweightWindowEvent event) {
    if (h.a.b(this.a) instanceof ConsoleViewImpl) {
      Editor editor = ((ConsoleViewImpl)h.a.b(this.a)).getEditor();
      if (editor != null) {
        EditorSettings editorSettings = editor.getSettings();
        editorSettings.setUseSoftWraps(true);
      } 
    } 
  }
  
  public void onClosed(LightweightWindowEvent event) {
    h.a.b(this.a).dispose();
    h.a.c(this.a).dispose();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */