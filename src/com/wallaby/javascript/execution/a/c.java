package com.wallaby.javascript.execution.a;

import com.intellij.ui.treeStructure.SimpleNode;
import com.wallaby.javascript.extendedCore.inboundMessages.StatsTrace;
import com.wallaby.javascript.extendedCore.inboundMessages.Trace;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceCallStack;
import com.wallaby.javascript.m;

public class c extends g {
  private final m b;
  
  private Trace.TraceData c;
  
  private StatsTrace d;
  
  private h e;
  
  private i f;
  
  private b g;
  
  public c(m paramm, f paramf) {
    super(paramf, "DebugRoot");
    this.b = paramm;
  }
  
  public void a(Trace.TraceData paramTraceData, StatsTrace paramStatsTrace) {
    this.c = paramTraceData;
    this.d = paramStatsTrace;
    if (this.d == null || this.c == null)
      return; 
    boolean bool = false;
    if (this.d.c() != null)
      for (TraceCallStack traceCallStack : this.d.c()) {
        if (traceCallStack.a() == this.c.b()) {
          this.g = new b(this.a, this.b, this.c.b(), traceCallStack);
          bool = true;
          break;
        } 
      }  
    if (!bool)
      this.g = new b(this.a, this.b, this.c.b(), null); 
    this.e = new h(this.a, this.b, this.c.b(), this.d.e());
    this.f = new i(this.a, this.b, this.d);
  }
  
  public SimpleNode[] getChildren() {
    return (this.e == null || this.f == null || this.g == null) ? new SimpleNode[0] : new SimpleNode[] { this.e, this.f, this.g };
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */