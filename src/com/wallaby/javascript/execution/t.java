package com.wallaby.javascript.execution;

import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.util.containers.ContainerUtil;
import com.wallaby.javascript.execution.b.a;
import com.wallaby.javascript.execution.b.f;
import com.wallaby.javascript.execution.b.g;
import com.wallaby.javascript.extendedCore.inboundMessages.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class t extends SimpleNode {
  t(n paramn, Callable paramCallable, g paramg, boolean paramBoolean) {}
  
  public SimpleNode[] getChildren() {
    List list = null;
    try {
      list = ContainerUtil.flatten(ContainerUtil.map(this.a.call(), parama -> ContainerUtil.map((Object[])parama.a(), ())));
    } catch (Exception exception) {
      list = new ArrayList();
      exception.printStackTrace();
    } 
    return (SimpleNode[])list.toArray((Object[])new f[list.size()]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */