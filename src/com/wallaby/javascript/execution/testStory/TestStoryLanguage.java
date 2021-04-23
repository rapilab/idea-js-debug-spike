package com.wallaby.javascript.execution.testStory;

import com.intellij.lang.Language;

public class TestStoryLanguage extends Language {
  public static final TestStoryLanguage INSTANCE = new TestStoryLanguage();
  
  private TestStoryLanguage() {
    super("TestStory");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryLanguage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */