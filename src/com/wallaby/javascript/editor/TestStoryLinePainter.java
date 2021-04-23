package com.wallaby.javascript.editor;

import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorLinePainter;
import com.intellij.openapi.editor.LineExtensionInfo;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.ColorUtil;
import com.intellij.ui.JBColor;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import com.wallaby.javascript.l;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestStoryLinePainter extends EditorLinePainter {
  private static Color a;
  
  private static Color b;
  
  private static Color c;
  
  private static Map<TestStory.LineType, TextAttributes> d;
  
  private static final Runnable e = () -> {
      a = l.a(l.f);
      b = l.a(l.g);
      c = l.a(l.h);
      d = new HashMap<>();
    };
  
  public static void a() {
    e.run();
  }
  
  public Collection<LineExtensionInfo> getLineExtensions(Project project, VirtualFile file, int lineNumber) {
    if (!(file instanceof o))
      return null; 
    TextEditor textEditor = (TextEditor)FileEditorManager.getInstance(project).getSelectedEditor(file);
    if (textEditor == null)
      return null; 
    Editor editor = textEditor.getEditor();
    o o = (o)file;
    TestStory.LineDecorationData lineDecorationData = o.a(lineNumber);
    if (lineDecorationData == null)
      return null; 
    TestStory.LineType lineType = lineDecorationData.a();
    ArrayList<LineExtensionInfo> arrayList = new ArrayList();
    TextAttributes textAttributes = d.get(lineType);
    if (textAttributes == null) {
      textAttributes = a(lineType, editor);
      d.put(lineType, textAttributes);
    } 
    if (!o.l() || (lineDecorationData.a() != TestStory.LineType.USER_LOG && lineDecorationData.a() != TestStory.LineType.SYSTEM_LOG))
      arrayList.add(new LineExtensionInfo(a(lineDecorationData, editor), textAttributes)); 
    return arrayList;
  }
  
  private static String a(TestStory.LineDecorationData paramLineDecorationData, Editor paramEditor) {
    TestStory.LineType lineType = paramLineDecorationData.a();
    return (lineType == TestStory.LineType.FILE_NAME) ? ("  " + paramLineDecorationData.b() + "  ") : ((lineType == TestStory.LineType.ERROR || lineType == TestStory.LineType.USER_LOG || lineType == TestStory.LineType.SYSTEM_LOG) ? ("  " + paramLineDecorationData.b()) : paramLineDecorationData.b());
  }
  
  private static TextAttributes a(TestStory.LineType paramLineType, Editor paramEditor) {
    if (paramLineType == TestStory.LineType.ERROR)
      return new TextAttributes(a, null, null, null, 2); 
    if (paramLineType == TestStory.LineType.USER_LOG)
      return new TextAttributes(b, null, null, null, 2); 
    if (paramLineType == TestStory.LineType.SYSTEM_LOG)
      return new TextAttributes(c, null, null, null, 2); 
    Color color1 = paramEditor.getColorsScheme().getColor(EditorColors.INDENT_GUIDE_COLOR);
    if (color1 == null)
      return ConsoleViewContentType.SYSTEM_OUTPUT.getAttributes(); 
    Color color2 = color1;
    Color color3 = null;
    if (paramLineType == TestStory.LineType.FILE_NAME || paramLineType == TestStory.LineType.FILE_CONTENT_SEPARATOR) {
      color2 = ColorUtil.isDark(color1) ? color1.brighter().brighter() : color1.darker().darker();
      if (paramLineType == TestStory.LineType.FILE_NAME)
        color3 = (Color)(ColorUtil.isDark(color1) ? color1.darker() : new JBColor(new Color(236, 250, 235), new Color(236, 250, 235))); 
    } else if (paramLineType == TestStory.LineType.FILES_SEPARATOR) {
      color2 = ColorUtil.isDark(color1) ? color1.brighter() : color1;
    } 
    return new TextAttributes(color2, color3, null, null, (paramLineType == TestStory.LineType.FILE_NAME) ? 1 : 0);
  }
  
  static {
    e.run();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/editor/TestStoryLinePainter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */