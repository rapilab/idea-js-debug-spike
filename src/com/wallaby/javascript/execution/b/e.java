package com.wallaby.javascript.execution.b;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

class e implements ExclusionStrategy {
  e(d paramd) {}
  
  public boolean shouldSkipField(FieldAttributes attributes) {
    return attributes.getName().equals("props");
  }
  
  public boolean shouldSkipClass(Class<?> aClass) {
    return false;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/b/e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */