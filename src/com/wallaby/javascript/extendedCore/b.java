package com.wallaby.javascript.extendedCore;

import com.intellij.execution.process.ProcessAdapter;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.openapi.util.Key;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.extendedCore.inboundMessages.Notification;
import com.wallaby.javascript.extendedCore.inboundMessages.Stopped;

class b extends ProcessAdapter {
  b(Client paramClient, int paramInt) {}
  
  public void processTerminated(ProcessEvent event) {
    if (!Client.a(this.b)) {
      WallabyController.a.warn("Process Terminated: " + event.getText() + ", Exit Code: " + event.getExitCode());
      Client.a(this.b, Client.b(this.b), new Notification("error", "Can not start node.js process (" + Client.c(this.b) + "), make sure your system has <a href=\"http://wallabyjs.com/docs/intro/install.html#jetbrains-ides\">node.js installed</a>."));
    } else if (event.getExitCode() != 0 && event.getExitCode() != -1073741510) {
      String str = event.getText();
      Client.a(this.b, Client.b(this.b), new Notification("error", "Wallaby stopped unexpectedly. Exit code: " + event.getExitCode() + ", Error Message: " + str));
    } 
    Client.a(this.b, Client.d(this.b), new Stopped());
  }
  
  public void onTextAvailable(ProcessEvent event, Key outputType) {
    String str = event.getText();
    if (!Client.a(this.b) && str != null && str.toLowerCase().contains("wallaby.js started".toLowerCase())) {
      Client.a(this.b, true);
      Client.a(this.b, this.a, Client.n());
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */