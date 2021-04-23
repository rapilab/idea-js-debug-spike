package com.wallaby.javascript.execution;

import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.ui.ExecutionConsole;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.k;
import com.wallaby.javascript.m;

public class d implements RunProfileState {
  private Project a;
  
  private ExecutionEnvironment b;
  
  private static final String c = "http://localhost:51245";
  
  d(Project paramProject, ExecutionEnvironment paramExecutionEnvironment) {
    this.a = paramProject;
    this.b = paramExecutionEnvironment;
  }
  
  public ExecutionResult execute(Executor executor, ProgramRunner runner) throws ExecutionException {
    j j = (j)this.b.getRunProfile();
    x x = new x(this.a);
    WallabyController wallabyController = WallabyController.a(j.getProject());
    j.a().a((String[])null);
    ProcessHandler processHandler = wallabyController.a(j.a().d());
    n n = new n(x, processHandler, (m)wallabyController);
    wallabyController.a(n);
    Disposer.register((Disposable)this.a, (Disposable)n);
    String str1 = k.a("console.run.actions.searchTests", new Object[0]);
    String str2 = k.a("console.run.actions.searchTests.description", new Object[0]);
    e e = new e(this, str1, str2, AllIcons.Actions.Find, (m)wallabyController);
    str1 = k.a("console.run.actions.openWallabyApp", new Object[0]);
    str2 = k.a("console.run.actions.openWallabyApp.description", new Object[0]);
    f f = new f(this, str1, str2, AllIcons.RunConfigurations.Web_app, (m)wallabyController);
    str1 = k.a("console.run.actions.runImmediately", new Object[0]);
    str2 = k.a("console.run.actions.runImmediately.description", new Object[0]);
    g g = new g(this, str1, str2, AllIcons.Actions.Refresh, (m)wallabyController);
    str1 = k.a("console.run.actions.runOnSave", new Object[0]);
    str2 = k.a("console.run.actions.runOnSave.description", new Object[0]);
    h h = new h(this, str1, str2, AllIcons.Actions.ProfileCPU, (m)wallabyController);
    str1 = k.a("console.run.actions.resetTestFilter", new Object[0]);
    str2 = k.a("console.run.actions.resetTestFilter.description", new Object[0]);
    i i = new i(this, str1, str2, AllIcons.General.Filter, (m)wallabyController);
    DefaultExecutionResult defaultExecutionResult = new DefaultExecutionResult((ExecutionConsole)n, processHandler);
    defaultExecutionResult.setActions(new AnAction[] { f, e, i, g, h });
    return (ExecutionResult)defaultExecutionResult;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */