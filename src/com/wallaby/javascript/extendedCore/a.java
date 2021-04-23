package com.wallaby.javascript.extendedCore;

import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import com.intellij.openapi.util.registry.Registry;
import com.intellij.util.io.BaseOutputReader;

class a extends KillableColoredProcessHandler {
  a(Client paramClient, GeneralCommandLine paramGeneralCommandLine, boolean paramBoolean) {
    super(paramGeneralCommandLine, paramBoolean);
  }
  
  protected BaseOutputReader.Options readerOptions() {
    return (!Registry.is("output.reader.blocking.mode.for.mostly.silent.processes", true) && !Registry.is("output.reader.blocking.mode", false)) ? BaseOutputReader.Options.NON_BLOCKING : BaseOutputReader.Options.BLOCKING;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */