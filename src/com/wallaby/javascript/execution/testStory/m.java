package com.wallaby.javascript.execution.testStory;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

public class m extends TextEditorProvider {
  public FileEditor createEditor(Project project, VirtualFile file) {
    return super.createEditor(project, file);
  }
  
  public TextEditor getTextEditor(Editor editor) {
    return super.getTextEditor(editor);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */