package com.wallaby.javascript.editor;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorLinePainter;
import com.intellij.openapi.editor.LineExtensionInfo;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Alarm;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.b;
import com.wallaby.javascript.f;
import com.wallaby.javascript.l;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class WallabyLinePainter extends EditorLinePainter {
  private static Color a;
  
  private static Color b;
  
  private static Color c;
  
  private static final int d = 750;
  
  private static final Alarm e = new Alarm();
  
  private static final Runnable f = () -> {
      a = l.a(l.f);
      b = l.a(l.g);
      c = l.a(l.h);
    };
  
  public static void a() {
    f.run();
  }
  
  public Collection<LineExtensionInfo> getLineExtensions(Project project, VirtualFile file, int lineNumber) {
    try {
      Document document = FileDocumentManager.getInstance().getDocument(file);
      if (document == null)
        return null; 
      TextRange textRange = TextRange.create(document.getLineStartOffset(lineNumber), document.getLineEndOffset(lineNumber));
      if (StringUtil.isEmpty(document.getText(textRange)))
        return null; 
      WallabyController wallabyController = WallabyController.a(project);
      if (wallabyController == null)
        return null; 
      b b = wallabyController.a(file);
      if (b == null)
        return null; 
      f f = b.b(lineNumber);
      if (f == null)
        return null; 
      String str = f.b();
      if (StringUtil.isEmpty(str)) {
        String str1 = f.c();
        if (StringUtil.isEmpty(str1))
          return null; 
        ArrayList<LineExtensionInfo> arrayList1 = new ArrayList();
        arrayList1.add(new LineExtensionInfo("  " + str1, f.f() ? c : b, null, null, 2));
        return arrayList1;
      } 
      TextEditor textEditor = (TextEditor)FileEditorManager.getInstance(project).getSelectedEditor(file);
      if (textEditor != null) {
        Editor editor = textEditor.getEditor();
        if ((editor.getCaretModel().getLogicalPosition()).line == lineNumber && b.c() + 750L > (new Date()).getTime()) {
          e.cancelAllRequests();
          e.addRequest(() -> {
                if (paramEditor instanceof EditorEx) {
                  EditorEx editorEx = (EditorEx)paramEditor;
                  if (editorEx.isDisposed())
                    return; 
                  editorEx.repaint(paramTextRange.getStartOffset(), paramTextRange.getEndOffset());
                } 
              }750);
          return null;
        } 
      } 
      ArrayList<LineExtensionInfo> arrayList = new ArrayList();
      arrayList.add(new LineExtensionInfo("  " + str, a, null, null, 2));
      return arrayList;
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
      return null;
    } 
  }
  
  static {
    f.run();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/editor/WallabyLinePainter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */