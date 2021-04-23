package com.wallaby.javascript;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.ex.MarkupModelEx;
import com.intellij.openapi.editor.impl.DocumentMarkupModel;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Alarm;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import com.wallaby.javascript.extendedCore.inboundMessages.DocumentUpdate;
import com.wallaby.javascript.extendedCore.inboundMessages.LineData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b implements Disposable {
  private final DocumentListener a;
  
  private final Document b;
  
  private final Alarm c;
  
  private final int d;
  
  private final Runnable e;
  
  private final Project f;
  
  private final VirtualFile g;
  
  private ArrayList<f> h = new ArrayList<>();
  
  private boolean i;
  
  private volatile long j;
  
  private final Object k = new Object();
  
  private volatile a l = new a(null);
  
  private boolean m;
  
  public b(Project paramProject, m paramm, VirtualFile paramVirtualFile, Document paramDocument, int paramInt) {
    this.g = paramVirtualFile;
    this.f = paramProject;
    this.b = paramDocument;
    this.c = new Alarm(Alarm.ThreadToUse.SWING_THREAD, (Disposable)paramProject);
    this.d = paramInt;
    this.e = (() -> {
        a a1 = (a)ApplicationManager.getApplication().runReadAction(());
        if (this.i)
          return; 
        paramm.a(paramVirtualFile, a.c(a1), a.a(a1).intValue(), a.b(a1).intValue());
      });
    this.a = new c(this);
    paramDocument.addDocumentListener(this.a);
  }
  
  static EditorEx[] a(Project paramProject, VirtualFile paramVirtualFile) {
    ArrayList<EditorEx> arrayList = new ArrayList();
    for (FileEditor fileEditor : FileEditorManager.getInstance(paramProject).getAllEditors(paramVirtualFile)) {
      if (fileEditor instanceof TextEditor) {
        TextEditor textEditor = (TextEditor)fileEditor;
        Editor editor = textEditor.getEditor();
        if (editor instanceof EditorEx)
          arrayList.add((EditorEx)editor); 
      } 
    } 
    return arrayList.<EditorEx>toArray(new EditorEx[0]);
  }
  
  Document a() {
    return this.b;
  }
  
  public void dispose() {
    if (this.i)
      return; 
    this.i = true;
    this.c.dispose();
    this.b.removeDocumentListener(this.a);
    i();
  }
  
  void b() {
    if (this.i)
      return; 
    for (f f : this.h)
      f.l(); 
  }
  
  public void a(DocumentUpdate paramDocumentUpdate) {
    ArrayList<f> arrayList1 = new ArrayList<>(this.h);
    ArrayList<f> arrayList2 = new ArrayList();
    ArrayList<f> arrayList3 = new ArrayList();
    HashMap<Object, Object> hashMap = new HashMap<>();
    boolean bool = false;
    for (LineData lineData : paramDocumentUpdate.a())
      hashMap.put(Integer.valueOf(lineData.a()), lineData); 
    this.h.clear();
    for (f f : arrayList1) {
      if (!f.h()) {
        arrayList2.add(f);
        continue;
      } 
      LineData lineData = (LineData)hashMap.remove(Integer.valueOf(f.k()));
      if (lineData == null) {
        arrayList2.add(f);
        continue;
      } 
      this.h.add(f);
      if (f.a(lineData))
        arrayList3.add(f); 
      if (f.g())
        bool = true; 
    } 
    for (LineData lineData : hashMap.values()) {
      f f = new f(this.f, this.g, this.b, lineData);
      this.h.add(f);
      arrayList3.add(f);
      if (f.g())
        bool = true; 
    } 
    this.m = bool;
    ApplicationManager.getApplication().invokeLater(() -> {
          if (this.i || ContainerUtil.find((Object[])a(this.f, this.g), ()) == null)
            return; 
          for (f f : paramList1)
            f.dispose(); 
          for (f f : paramList2)
            f.j(); 
        });
  }
  
  public f a(int paramInt) {
    f[] arrayOfF = new f[1];
    MarkupModelEx markupModelEx = (MarkupModelEx)DocumentMarkupModel.forDocument(this.b, this.f, true);
    markupModelEx.processRangeHighlightersOverlappingWith(paramInt, paramInt, (Processor)new e(this, arrayOfF));
    return arrayOfF[0];
  }
  
  public f b(int paramInt) {
    return (paramInt == -1) ? null : a(this.b.getLineStartOffset(paramInt));
  }
  
  public long c() {
    return this.j;
  }
  
  private void i() {
    ArrayList<f> arrayList = new ArrayList<>(this.h);
    this.h.clear();
    ApplicationManager.getApplication().invokeLater(() -> {
          for (f f : paramList)
            f.dispose(); 
        });
  }
  
  public String d() {
    return this.g.getPath();
  }
  
  public int e() {
    return 0;
  }
  
  public String f() {
    String str = (String)ApplicationManager.getApplication().runReadAction(() -> this.b.getCharsSequence().toString());
    return StringUtil.notNullize(a(str, this.g.getDetectedLineSeparator()));
  }
  
  public boolean g() {
    ArrayList<f> arrayList = new ArrayList<>(this.h);
    for (f f : arrayList) {
      if (f.a() == CoverageState.NOT_COVERED || f.a() == CoverageState.PARTIAL_COVERAGE)
        return true; 
    } 
    return false;
  }
  
  public boolean h() {
    return this.m;
  }
  
  public static String a(String paramString1, String paramString2) {
    paramString2 = StringUtil.notNullize(paramString2);
    if (paramString2.length() == 0)
      paramString2 = "\n"; 
    if (!paramString2.equals("\n"))
      paramString1 = paramString1.replace("\n", paramString2); 
    return paramString1;
  }
  
  public String a(int paramInt1, int paramInt2) {
    return (String)ApplicationManager.getApplication().runReadAction(() -> this.b.getCharsSequence().subSequence(paramInt1, paramInt2).toString().trim());
  }
  
  public String c(int paramInt) {
    int i = this.b.getLineStartOffset(paramInt);
    int j = this.b.getLineEndOffset(paramInt);
    return a(i, j);
  }
  
  private class a {
    private String b = null;
    
    private Integer c = null;
    
    private Integer d = null;
    
    private a(b this$0) {}
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */