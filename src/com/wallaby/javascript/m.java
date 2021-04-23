package com.wallaby.javascript;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.util.Consumer;
import com.wallaby.javascript.b.a;
import com.wallaby.javascript.execution.b.d;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLocation;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionNode;
import com.wallaby.javascript.extendedCore.inboundMessages.Test;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterTestSelectionRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import com.wallaby.javascript.extendedCore.outboundMessages.LineLocation;

public interface m {
  String a();
  
  ToolWindow b();
  
  RunContentDescriptor c();
  
  Project d();
  
  void a(z paramz);
  
  ProcessHandler a(a parama) throws ExecutionException;
  
  a e();
  
  boolean f();
  
  boolean g();
  
  boolean h();
  
  boolean i();
  
  boolean j();
  
  void k();
  
  void l();
  
  void m();
  
  void n();
  
  void a(String[] paramArrayOfString, d paramd, ExpressionLocation paramExpressionLocation);
  
  void a(String paramString);
  
  void a(ExpressionNode paramExpressionNode);
  
  b a(Editor paramEditor);
  
  b a(VirtualFile paramVirtualFile);
  
  void a(VirtualFile paramVirtualFile, String paramString, int paramInt1, int paramInt2);
  
  VirtualFile b(String paramString);
  
  void c(String paramString);
  
  void o();
  
  void a(String paramString, int paramInt, boolean paramBoolean);
  
  void d(String paramString);
  
  void a(String paramString, int paramInt);
  
  void a(String paramString1, String paramString2);
  
  boolean b(String paramString, int paramInt);
  
  boolean c(String paramString, int paramInt);
  
  void d(String paramString, int paramInt);
  
  boolean e(String paramString, int paramInt);
  
  void a(b paramb, int[] paramArrayOfint, String paramString);
  
  void f(String paramString, int paramInt);
  
  void e(String paramString);
  
  void a(Consumer<Test[]> paramConsumer);
  
  void a(Integer paramInteger, TestStory.TestStoryEntry paramTestStoryEntry, Consumer<o> paramConsumer);
  
  o p();
  
  void q();
  
  void r();
  
  boolean s();
  
  boolean t();
  
  void a(String paramString, int paramInt, Editor paramEditor, AnActionEvent paramAnActionEvent);
  
  void g(String paramString, int paramInt);
  
  boolean h(String paramString, int paramInt);
  
  boolean u();
  
  boolean f(String paramString);
  
  boolean i(String paramString, int paramInt);
  
  void g(String paramString);
  
  void a(String paramString, int paramInt, Consumer<TestFilterTestSelectionRequested.Test[]> paramConsumer);
  
  void a(String paramString, Object[] paramArrayOfObject);
  
  void h(String paramString);
  
  void a(String[] paramArrayOfString);
  
  void j(String paramString, int paramInt);
  
  void a(String paramString, Integer paramInteger);
  
  String v();
  
  void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int[] paramArrayOfint);
  
  boolean w();
  
  void x();
  
  boolean y();
  
  void a(Editor paramEditor, String paramString, int paramInt, Runnable paramRunnable);
  
  boolean z();
  
  void A();
  
  boolean B();
  
  void a(String paramString, int paramInt, Integer paramInteger);
  
  boolean C();
  
  void b(String paramString, int paramInt, Integer paramInteger);
  
  boolean D();
  
  boolean E();
  
  void a(LineLocation[] paramArrayOfLineLocation);
  
  void b(LineLocation[] paramArrayOfLineLocation);
  
  boolean F();
  
  void G();
  
  boolean H();
  
  void I();
  
  boolean J();
  
  void K();
  
  boolean L();
  
  void M();
  
  boolean N();
  
  void O();
  
  boolean P();
  
  void Q();
  
  boolean R();
  
  void a(int paramInt);
  
  void b(int paramInt);
  
  boolean S();
  
  boolean a(v paramv);
  
  boolean T();
  
  boolean U();
  
  void k(String paramString, int paramInt);
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */