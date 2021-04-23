package b.b;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLException;

public class a implements i {
  private final ByteChannel a;
  
  public a(ByteChannel paramByteChannel) {
    this.a = paramByteChannel;
  }
  
  public a(i parami) {
    this.a = parami;
  }
  
  public int read(ByteBuffer dst) throws IOException {
    return this.a.read(dst);
  }
  
  public boolean isOpen() {
    return this.a.isOpen();
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public int write(ByteBuffer src) throws IOException {
    return this.a.write(src);
  }
  
  public boolean a() {
    return (this.a instanceof i) ? ((i)this.a).a() : false;
  }
  
  public void b() throws IOException {
    if (this.a instanceof i)
      ((i)this.a).b(); 
  }
  
  public boolean c() {
    return (this.a instanceof i) ? ((i)this.a).c() : false;
  }
  
  public int a(ByteBuffer paramByteBuffer) throws SSLException {
    return (this.a instanceof i) ? ((i)this.a).a(paramByteBuffer) : 0;
  }
  
  public boolean d() {
    return (this.a instanceof SocketChannel) ? ((SocketChannel)this.a).isBlocking() : ((this.a instanceof i) ? ((i)this.a).d() : false);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */