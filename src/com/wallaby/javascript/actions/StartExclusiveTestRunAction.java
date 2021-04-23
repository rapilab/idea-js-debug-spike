package com.wallaby.javascript.actions;

import com.intellij.execution.Executor;
import com.intellij.execution.ProgramRunnerUtil;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.containers.ContainerUtil;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.execution.WallabyConfigurationType;
import com.wallaby.javascript.execution.b;
import com.wallaby.javascript.execution.j;
import com.wallaby.javascript.v;
import java.util.List;

public class StartExclusiveTestRunAction extends AddToExclusiveTestRunAction {
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
    if (!a(virtualFile)) {
      event.getPresentation().setVisible(false);
      return;
    } 
    RunManager runManager = RunManager.getInstance(project);
    List list = runManager.getConfigurationSettingsList(WallabyConfigurationType.class);
    if (list.isEmpty()) {
      event.getPresentation().setVisible(false);
      return;
    } 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController != null && wallabyController.h()) {
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
    Project project = event.getProject();
    if (project == null)
      return; 
    VirtualFile[] arrayOfVirtualFile = (VirtualFile[])CommonDataKeys.VIRTUAL_FILE_ARRAY.getData(event.getDataContext());
    if (arrayOfVirtualFile == null || arrayOfVirtualFile.length == 0) {
      event.getPresentation().setVisible(false);
      return;
    } 
    RunManager runManager = RunManager.getInstance(project);
    List<RunnerAndConfigurationSettings> list = runManager.getConfigurationSettingsList(WallabyConfigurationType.class);
    if (list.isEmpty())
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    if (wallabyController != null && wallabyController.h())
      return; 
    Executor executor = DefaultRunExecutor.getRunExecutorInstance();
    RunnerAndConfigurationSettings runnerAndConfigurationSettings1 = null;
    RunnerAndConfigurationSettings runnerAndConfigurationSettings2 = runManager.getSelectedConfiguration();
    for (RunnerAndConfigurationSettings runnerAndConfigurationSettings : list) {
      if (runnerAndConfigurationSettings == runnerAndConfigurationSettings2) {
        runnerAndConfigurationSettings1 = runnerAndConfigurationSettings2;
        break;
      } 
    } 
    if (runnerAndConfigurationSettings1 == null)
      runnerAndConfigurationSettings1 = list.get(0); 
    j j = (j)runnerAndConfigurationSettings1.getConfiguration();
    b b = j.a();
    b.a((String[])ContainerUtil.map((Object[])arrayOfVirtualFile, VirtualFile::getPath).toArray((Object[])new String[arrayOfVirtualFile.length]));
    ProgramRunnerUtil.executeConfiguration(runnerAndConfigurationSettings1, executor);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/StartExclusiveTestRunAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */