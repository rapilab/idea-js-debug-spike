package com.wallaby.javascript.execution;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.GenericProgramRunner;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.runners.RunContentBuilder;
import com.intellij.execution.ui.RunContentDescriptor;
import com.wallaby.javascript.k;

public class WallabyProgramRunner extends GenericProgramRunner {
  public String getRunnerId() {
    return k.a("runner.id", new Object[0]);
  }
  
  public boolean canRun(String executorId, RunProfile profile) {
    return (DefaultRunExecutor.EXECUTOR_ID.equals(executorId) && profile instanceof j);
  }
  
  protected RunContentDescriptor doExecute(RunProfileState state, ExecutionEnvironment env) throws ExecutionException {
    ExecutionResult executionResult = state.execute(env.getExecutor(), (ProgramRunner)this);
    return (executionResult == null) ? null : (new RunContentBuilder(executionResult, env)).showRunContent(env.getContentToReuse());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/WallabyProgramRunner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */