package com.wallaby.javascript.execution.testStory;

import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.markup.HighlighterTargetArea;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.ColorUtil;
import com.wallaby.javascript.WallabyController;
import java.awt.Color;
import java.lang.reflect.Method;

public class g extends PsiAwareTextEditorImpl {
  private static final Key<Boolean> a = new Key("IsTestStoryHighlighterKey");
  
  public g(Project paramProject, VirtualFile paramVirtualFile) {
    super(paramProject, paramVirtualFile, new m());
    EditorSettings editorSettings = getEditor().getSettings();
    editorSettings.setLineNumbersShown(false);
    try {
      Method method = EditorSettings.class.getMethod("setShowingSpecialChars", new Class[] { boolean.class });
      method.invoke(editorSettings, new Object[] { Boolean.valueOf(false) });
    } catch (Exception exception) {
      WallabyController.a.warn("Can not find the setShowingSpecialChars method", exception);
    } 
    getEditor().getDocument().setReadOnly(true);
    if (paramVirtualFile instanceof o) {
      o o = (o)paramVirtualFile;
      a(getEditor(), o);
      getEditor().getGutter().registerTextAnnotation(new h(this, o));
    } 
  }
  
  public static void a(Editor paramEditor, o paramo) {
    TextAttributes textAttributes;
    MarkupModel markupModel = paramEditor.getMarkupModel();
    Color color = paramEditor.getColorsScheme().getColor(EditorColors.INDENT_GUIDE_COLOR);
    if (color == null) {
      textAttributes = ConsoleViewContentType.SYSTEM_OUTPUT.getAttributes();
    } else {
      textAttributes = new TextAttributes(ColorUtil.isDark(color) ? color.brighter().brighter() : color.darker(), null, null, null, 0);
    } 
    for (RangeHighlighter rangeHighlighter : markupModel.getAllHighlighters()) {
      Boolean bool = (Boolean)rangeHighlighter.getUserData(a);
      if (bool != null && bool.booleanValue())
        markupModel.removeHighlighter(rangeHighlighter); 
    } 
    for (TextRange textRange : paramo.a()) {
      RangeHighlighter rangeHighlighter = markupModel.addRangeHighlighter(textRange.getStartOffset(), textRange.getEndOffset(), 6000, textAttributes, HighlighterTargetArea.EXACT_RANGE);
      rangeHighlighter.putUserData(a, Boolean.valueOf(true));
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */