package com.wallaby.javascript.execution;

import com.intellij.execution.process.ProcessAdapter;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.execution.process.ProcessOutputTypes;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.util.Key;

class o extends ProcessAdapter {
  o(n paramn) {}
  
  public void onTextAvailable(ProcessEvent event, Key outputType) {
    if (!n.a(this.a) && outputType.equals(ProcessOutputTypes.SYSTEM)) {
      n.a(this.a, true);
      return;
    } 
    String str = event.getText();
    if (str == null)
      return; 
    n.b(this.a).print(str, ConsoleViewContentType.getConsoleViewType(outputType));
    if (outputType.equals(ProcessOutputTypes.STDERR))
      ApplicationManager.getApplication().invokeLater(() -> {
            if (n.c(this.a) != null)
              n.c(this.a).fireAlert(); 
          }ModalityState.any()); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */