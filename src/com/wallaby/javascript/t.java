package com.wallaby.javascript;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import com.intellij.openapi.editor.event.SelectionEvent;
import com.intellij.openapi.editor.event.SelectionListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.util.Consumer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

class t implements Disposable, EditorFactoryListener {
  private final Object a = new Object();
  
  private final Object b = new Object();
  
  private final HashMap<String, VirtualFile> c = new HashMap<>();
  
  private final HashMap<String, Document> d = new HashMap<>();
  
  private final HashMap<String, Integer> e = new HashMap<>();
  
  private Project f;
  
  private volatile boolean g = false;
  
  private Consumer<VirtualFile> h = null;
  
  private Consumer<VirtualFile> i = null;
  
  private final HashSet<Editor> j = new HashSet<>();
  
  private Consumer<SelectionEvent> k = null;
  
  private SelectionListener l;
  
  t(Project paramProject) {
    this.f = paramProject;
    this.l = new u(this);
  }
  
  Collection<VirtualFile> a() {
    return this.c.values();
  }
  
  Document a(VirtualFile paramVirtualFile) {
    null = this.d.get(paramVirtualFile.getPath());
    if (null == null)
      for (FileEditor fileEditor : FileEditorManager.getInstance(this.f).getAllEditors(paramVirtualFile)) {
        if (fileEditor instanceof TextEditor) {
          TextEditor textEditor = (TextEditor)fileEditor;
          Editor editor = textEditor.getEditor();
          a(editor);
        } 
      }  
    return this.d.get(paramVirtualFile.getPath());
  }
  
  void b() {
    this.h = null;
    this.i = null;
  }
  
  void a(Consumer<VirtualFile> paramConsumer1, Consumer<VirtualFile> paramConsumer2, Consumer<SelectionEvent> paramConsumer) {
    this.h = paramConsumer1;
    this.i = paramConsumer2;
    this.k = paramConsumer;
  }
  
  public void editorCreated(EditorFactoryEvent event) {
    synchronized (this.a) {
      if (this.g)
        return; 
    } 
    Editor editor = event.getEditor();
    if (editor.getProject() != this.f)
      return; 
    a(editor);
    this.j.add(editor);
    editor.getSelectionModel().addSelectionListener(this.l);
  }
  
  private void a(Editor paramEditor) {
    PsiFile psiFile = (PsiFile)ApplicationManager.getApplication().runReadAction(() -> {
          if (this.f.isDisposed())
            return null; 
          PsiDocumentManager psiDocumentManager = PsiDocumentManager.getInstance(this.f);
          Document document = paramEditor.getDocument();
          return psiDocumentManager.getPsiFile(document);
        });
    if (psiFile == null || !psiFile.isPhysical())
      return; 
    VirtualFile virtualFile = psiFile.getVirtualFile();
    String str = virtualFile.getPath();
    boolean bool = false;
    synchronized (this.b) {
      if (this.e.containsKey(str)) {
        this.e.put(str, Integer.valueOf(((Integer)this.e.get(str)).intValue() + 1));
      } else {
        this.e.put(str, Integer.valueOf(1));
        this.c.put(str, virtualFile);
        this.d.put(str, paramEditor.getDocument());
        bool = true;
      } 
    } 
    if (this.h != null && bool) {
      WallabyController.a.debug("File opened in editor: " + virtualFile.getPath());
      this.h.consume(virtualFile);
    } 
  }
  
  public void editorReleased(EditorFactoryEvent event) {
    Editor editor = event.getEditor();
    if (editor.getProject() != this.f)
      return; 
    if (this.j.contains(editor)) {
      editor.getSelectionModel().removeSelectionListener(this.l);
      this.j.remove(editor);
    } 
    VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(editor.getDocument());
    if (virtualFile == null)
      return; 
    boolean bool = false;
    String str = virtualFile.getPath();
    synchronized (this.b) {
      if (this.e.containsKey(str)) {
        int i = ((Integer)this.e.get(str)).intValue() - 1;
        if (i > 0) {
          this.e.put(str, Integer.valueOf(i));
        } else {
          this.e.remove(str);
          this.c.remove(str);
          this.d.remove(str);
          bool = true;
        } 
      } 
    } 
    if (this.i != null && bool) {
      WallabyController.a.debug("File closed in editor: " + virtualFile.getPath());
      this.i.consume(virtualFile);
    } 
  }
  
  public void a(String paramString) {
    synchronized (this.b) {
      Document document = this.d.get(paramString);
      if (document != null) {
        VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
        String str = virtualFile.getPath();
        this.e.put(str, this.e.get(paramString));
        this.c.put(str, virtualFile);
        this.d.put(str, document);
      } 
      this.e.remove(paramString);
      this.c.remove(paramString);
      this.d.remove(paramString);
    } 
  }
  
  public void dispose() {
    if (this.g)
      return; 
    synchronized (this.a) {
      this.g = true;
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */