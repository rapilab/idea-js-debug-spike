package com.wallaby.javascript.execution.b;

import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.wallaby.javascript.extendedCore.inboundMessages.FileMessage;
import com.wallaby.javascript.extendedCore.inboundMessages.Message;
import com.wallaby.javascript.m;

public class a extends SimpleNode {
  private final m a;
  
  private FileMessage b;
  
  private boolean c = false;
  
  public a(m paramm, FileMessage paramFileMessage) {
    this.a = paramm;
    getPresentation().addText(paramFileMessage.c(), SimpleTextAttributes.REGULAR_ATTRIBUTES);
    getTemplatePresentation().setIcon(paramm.b(paramFileMessage.c()).getFileType().getIcon());
    this.b = paramFileMessage;
  }
  
  public Message[] a() {
    if ((this.b.a()).length == 0 && !this.c) {
      this.c = true;
      this.a.c(this.b.b());
    } 
    return this.b.a();
  }
  
  public boolean b() {
    return ((this.b.a()).length != 0);
  }
  
  public SimpleNode[] getChildren() {
    return new SimpleNode[0];
  }
  
  public void handleSelection(SimpleTree tree) {
    ((b)tree).a(this);
  }
  
  public void a(FileMessage paramFileMessage) {
    this.b = paramFileMessage;
  }
  
  public String getName() {
    return this.b.c();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/b/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */