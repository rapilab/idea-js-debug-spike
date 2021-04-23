package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.Presentation;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.m;

public class LoadStartOfTruncatedTestStoryAction extends LoadTruncatedTestStoryAction {
  public LoadStartOfTruncatedTestStoryAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.d);
  }
  
  public boolean a(o paramo, m paramm) {
    return paramo.b();
  }
  
  public int a(o paramo) {
    return paramo.d();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/LoadStartOfTruncatedTestStoryAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */