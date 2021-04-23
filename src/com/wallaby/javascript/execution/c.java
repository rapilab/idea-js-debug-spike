package com.wallaby.javascript.execution;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationSingletonPolicy;
import com.intellij.openapi.project.Project;
import com.wallaby.javascript.k;

class c extends ConfigurationFactory {
  c(WallabyConfigurationType paramWallabyConfigurationType, ConfigurationType paramConfigurationType) {
    super(paramConfigurationType);
  }
  
  public RunConfiguration createTemplateConfiguration(Project project) {
    return (RunConfiguration)new j(project, this, k.a("configuration.name", new Object[0]));
  }
  
  public RunConfigurationSingletonPolicy getSingletonPolicy() {
    return RunConfigurationSingletonPolicy.SINGLE_INSTANCE;
  }
  
  public String getId() {
    return k.a("configuration.id", new Object[0]);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */