package com.wallaby.javascript.execution.a;

import com.intellij.icons.AllIcons;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceFile;
import com.wallaby.javascript.m;
import java.util.ArrayList;

public class k extends g {
  private final m b;
  
  private final ArrayList<SimpleNode> c;
  
  private TraceFile[] d;
  
  public k(f paramf, m paramm, TraceFile[] paramArrayOfTraceFile) {
    super(paramf, "LoadedFiles");
    this.b = paramm;
    this.d = paramArrayOfTraceFile;
    setIcon(AllIcons.Nodes.Folder);
    getTemplatePresentation().clearText();
    getTemplatePresentation().addText("Loaded Files", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    this.c = new ArrayList<>();
    for (TraceFile traceFile : this.d)
      this.c.add(new j(this.a, this.b, traceFile)); 
  }
  
  public boolean isAutoExpandNode() {
    return false;
  }
  
  public SimpleNode[] getChildren() {
    return this.c.<SimpleNode>toArray(new SimpleNode[this.c.size()]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */