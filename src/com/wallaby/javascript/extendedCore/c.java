package com.wallaby.javascript.extendedCore;

import com.wallaby.javascript.WallabyController;
import java.net.URI;

class c extends Client.d {
  c(Client paramClient, URI paramURI, String paramString, int paramInt) {
    super(paramClient, paramURI);
  }
  
  public void a(Exception paramException) {
    if ((paramException instanceof java.net.ConnectException || paramException instanceof java.net.UnknownHostException) && this.a.equals(Client.n())) {
      try {
        Client.e(this.c).interrupt();
        Client.a(this.c, this.b, "127.0.0.1");
      } catch (Exception exception) {
        WallabyController.a.warn(exception);
      } 
    } else {
      super.a(paramException);
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */