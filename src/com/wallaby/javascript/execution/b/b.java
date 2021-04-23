package com.wallaby.javascript.execution.b;

import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.util.Consumer;
import java.util.ArrayList;
import java.util.List;

public class b extends SimpleTree {
  private final List<Consumer<a>> a = new ArrayList<>();
  
  void a(a parama) {
    for (Consumer<a> consumer : this.a)
      consumer.consume(parama); 
  }
  
  public void a(Consumer<a> paramConsumer) {
    this.a.add(paramConsumer);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/b/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */