package com.wallaby.javascript.execution.testStory;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.WeighedFileEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

public class TestStoryFileEditorProvider extends WeighedFileEditorProvider {
  public boolean accept(Project project, VirtualFile file) {
    return (file.isValid() && file.getFileType() instanceof TestStoryFileType);
  }
  
  public FileEditor createEditor(Project project, VirtualFile file) {
    return (FileEditor)new g(project, file);
  }
  
  public String getEditorTypeId() {
    return "TestStoryFileEditor";
  }
  
  public FileEditorPolicy getPolicy() {
    return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/TestStoryFileEditorProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */