package com.wallaby.javascript.actions;

import com.intellij.execution.filters.HyperlinkInfo;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.wallaby.javascript.WallabyController;

public class i implements HyperlinkInfo {
  private final int a;
  
  private final int b;
  
  private final String c;
  
  private final Runnable d;
  
  public i(String paramString1, String paramString2) {
    this(paramString1, paramString2, null);
  }
  
  public i(String paramString1, String paramString2, Runnable paramRunnable) {
    this.c = paramString1;
    this.d = paramRunnable;
    int j = 0;
    int k = 0;
    if (!StringUtil.notNullize(paramString2).isEmpty()) {
      String[] arrayOfString = paramString2.split(":");
      if (arrayOfString.length >= 1)
        try {
          j = Integer.parseInt(arrayOfString[0]) - 1;
        } catch (Exception exception) {} 
      if (arrayOfString.length >= 2)
        try {
          k = Integer.parseInt(arrayOfString[1]);
        } catch (Exception exception) {} 
    } 
    this.a = j;
    this.b = k;
  }
  
  public void navigate(Project project) {
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    VirtualFile virtualFile = wallabyController.b(this.c);
    if (virtualFile == null)
      return; 
    OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(project, virtualFile, this.a, this.b);
    try {
      openFileDescriptor.navigate(true);
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
    } 
    if (this.d != null)
      this.d.run(); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */