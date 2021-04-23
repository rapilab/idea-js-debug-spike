package com.wallaby.javascript.execution.testStory;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.TextAnnotationGutterProvider;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.colors.EditorFontType;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import java.awt.Color;
import java.util.List;

class h implements TextAnnotationGutterProvider {
  h(g paramg, o paramo) {}
  
  public String getLineText(int i, Editor editor) {
    TestStory.OriginalLineData originalLineData = this.a.b(i);
    return (originalLineData == null) ? null : String.format("%" + (String.valueOf(this.a.f()).length() + 1) + "s", new Object[] { Integer.valueOf(originalLineData.b() + 1) });
  }
  
  public String getToolTip(int i, Editor editor) {
    return null;
  }
  
  public EditorFontType getStyle(int i, Editor editor) {
    return null;
  }
  
  public ColorKey getColor(int i, Editor editor) {
    return EditorColors.LINE_NUMBERS_COLOR;
  }
  
  public Color getBgColor(int i, Editor editor) {
    return null;
  }
  
  public List<AnAction> getPopupActions(int i, Editor editor) {
    return null;
  }
  
  public void gutterClosed() {}
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */