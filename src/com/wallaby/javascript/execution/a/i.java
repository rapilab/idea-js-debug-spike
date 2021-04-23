package com.wallaby.javascript.execution.a;

import com.intellij.icons.AllIcons;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.wallaby.javascript.extendedCore.inboundMessages.StatsTrace;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceTest;
import com.wallaby.javascript.m;
import java.util.ArrayList;
import java.util.Collection;

public class i extends g {
  private final m b;
  
  private final ArrayList<SimpleNode> c;
  
  private StatsTrace d;
  
  public i(f paramf, m paramm, StatsTrace paramStatsTrace) {
    super(paramf, "JumpTo");
    SimpleNode simpleNode;
    this.d = paramStatsTrace;
    this.b = paramm;
    setIcon(AllIcons.Actions.RunToCursor);
    getTemplatePresentation().clearText();
    getTemplatePresentation().addText("Jump to", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    ArrayList<l> arrayList = new ArrayList();
    for (TraceTest traceTest : this.d.b())
      arrayList.add(new l(this.a, this.b, traceTest)); 
    if (this.d.a() != null && (this.d.a()).length > 0) {
      simpleNode = new k(this.a, this.b, this.d.a());
    } else {
      simpleNode = null;
    } 
    this.c = new ArrayList<>();
    this.c.addAll((Collection)arrayList);
    if (simpleNode != null)
      this.c.add(simpleNode); 
  }
  
  public SimpleNode[] getChildren() {
    return this.c.<SimpleNode>toArray(new SimpleNode[this.c.size()]);
  }
  
  public boolean isAutoExpandNode() {
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */