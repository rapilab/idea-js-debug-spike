package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.containers.ContainerUtil;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.v;

public class AddToExclusiveTestRunAction extends AnAction {
  public AddToExclusiveTestRunAction() {
    super(a.a);
  }
  
  public void update(AnActionEvent event) {
    super.update(event);
    VirtualFile virtualFile = (VirtualFile)CommonDataKeys.VIRTUAL_FILE.getData(event.getDataContext());
    if (virtualFile == null) {
      event.getPresentation().setVisible(false);
      return;
    } 
    Project project = event.getProject();
    if (project == null) {
      event.getPresentation().setVisible(false);
      return;
    } 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null || !wallabyController.h()) {
      event.getPresentation().setVisible(false);
      return;
    } 
    if (!a(virtualFile)) {
      event.getPresentation().setVisible(false);
      return;
    } 
    if (!wallabyController.a(v.d)) {
      event.getPresentation().setVisible(false);
      return;
    } 
    event.getPresentation().setVisible(true);
  }
  
  public void actionPerformed(AnActionEvent event) {
    Project project = (Project)CommonDataKeys.PROJECT.getData(event.getDataContext());
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController == null)
      return; 
    VirtualFile[] arrayOfVirtualFile = (VirtualFile[])CommonDataKeys.VIRTUAL_FILE_ARRAY.getData(event.getDataContext());
    if (arrayOfVirtualFile == null || arrayOfVirtualFile.length == 0)
      return; 
    wallabyController.a((String[])ContainerUtil.map((Object[])arrayOfVirtualFile, VirtualFile::getPath).toArray((Object[])new String[arrayOfVirtualFile.length]));
  }
  
  public boolean a(VirtualFile paramVirtualFile) {
    if (paramVirtualFile.isDirectory()) {
      String str = paramVirtualFile.getName();
      if (str.equals("node_modules") || str.equals(".vs") || str.equals(".vscode") || str.equals(".idea"))
        return false; 
    } else {
      String str1 = paramVirtualFile.getExtension();
      if (StringUtil.isEmptyOrSpaces(str1))
        return false; 
      String str2 = paramVirtualFile.getName();
      if (!str1.equals("js") && !str1.equals("jsx") && !str1.equals("ts") && !str1.equals("tsx") && !str1.equals("coffee") && !str1.equals("vue"))
        return false; 
      if (str2.equals("jest.config.js"))
        return false; 
      if (str2.startsWith("wallaby") && str1.equals("js"))
        return false; 
    } 
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/AddToExclusiveTestRunAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */