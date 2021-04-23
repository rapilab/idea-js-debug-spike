package com.wallaby.javascript;

import com.intellij.openapi.util.io.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

class s implements WallabyDependencies.c.a {
  private URLConnection b;
  
  private InputStream c;
  
  s(WallabyDependencies.c.b paramb) {}
  
  public URLConnection a() throws IOException {
    if (this.b == null)
      this.b = WallabyDependencies.c.a(this.a); 
    return this.b;
  }
  
  public InputStream b() throws IOException {
    if (this.c == null) {
      this.c = a().getInputStream();
      if (this.a.e && "gzip".equalsIgnoreCase(a().getContentEncoding()))
        this.c = new GZIPInputStream(this.c); 
    } 
    return this.c;
  }
  
  private void c() {
    StreamUtil.closeStream(this.c);
    if (this.b instanceof HttpURLConnection)
      ((HttpURLConnection)this.b).disconnect(); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */