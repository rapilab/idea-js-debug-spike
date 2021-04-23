package com.wallaby.javascript.c;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.util.io.HttpRequests;
import com.intellij.util.net.NetUtils;
import java.io.IOException;
import java.io.OutputStream;

final class c implements HttpRequests.RequestProcessor<Object> {
  c(ProgressIndicator paramProgressIndicator, String paramString, OutputStream paramOutputStream) {}
  
  public Object process(HttpRequests.Request request) throws IOException {
    try {
      int i = request.getConnection().getContentLength();
      b.a(this.a, this.b, i);
      NetUtils.copyStreamContent(this.a, request.getInputStream(), this.c, i);
    } catch (IOException iOException) {
      throw new IOException(HttpRequests.createErrorMessage(iOException, request, true), iOException);
    } 
    return null;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/c/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */