package b.b.f;

import b.b.b;
import b.b.d;
import b.b.e;
import b.b.g;
import b.b.h;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class a implements c.a {
  protected SSLContext a;
  
  protected ExecutorService b;
  
  public a(SSLContext paramSSLContext) {
    this(paramSSLContext, Executors.newSingleThreadScheduledExecutor());
  }
  
  public a(SSLContext paramSSLContext, ExecutorService paramExecutorService) {
    if (paramSSLContext == null || paramExecutorService == null)
      throw new IllegalArgumentException(); 
    this.a = paramSSLContext;
    this.b = paramExecutorService;
  }
  
  public ByteChannel a(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey) throws IOException {
    SSLEngine sSLEngine = this.a.createSSLEngine();
    sSLEngine.setUseClientMode(false);
    return (ByteChannel)new b(paramSocketChannel, sSLEngine, this.b, paramSelectionKey);
  }
  
  public g b(e parame, b.b.b.a parama, Socket paramSocket) {
    return new g((h)parame, parama);
  }
  
  public g b(e parame, List<b.b.b.a> paramList, Socket paramSocket) {
    return new g((h)parame, paramList);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/f/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */