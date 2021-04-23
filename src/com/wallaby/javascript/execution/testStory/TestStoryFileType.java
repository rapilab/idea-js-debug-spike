package com.wallaby.javascript.execution.testStory;

import a.a;
import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.Icon;

public class TestStoryFileType extends LanguageFileType {
  public static final TestStoryFileType INSTANCE = new TestStoryFileType();
  
  private TestStoryFileType() {
    super(TestStoryLanguage.INSTANCE);
  }
  
  public String getName() {
    return "Test Story File";
  }
  
  public String getDescription() {
    return "Test story file";
  }
  
  public String getDefaultExtension() {
    return "testStory";
  }
  
  public Icon getIcon() {
    return a.a;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryFileType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */