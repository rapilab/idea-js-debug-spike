package com.wallaby.javascript.execution;

import a.a;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.wallaby.javascript.k;

public class WallabyConfigurationType extends ConfigurationTypeBase {
  protected WallabyConfigurationType() {
    super(k.a("configuration.id", new Object[0]), k.a("configuration.name", new Object[0]), k.a("configuration.description", new Object[0]), a.a);
    addFactory(new c(this, (ConfigurationType)this));
  }
  
  public boolean isDumbAware() {
    return this instanceof com.intellij.openapi.project.DumbAware;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/WallabyConfigurationType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */