package b.b.a;

import b.b.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

public abstract class a extends a {
  protected final ByteBuffer a;
  
  public a(ByteChannel paramByteChannel) {
    super(paramByteChannel);
    try {
      this.a = ByteBuffer.wrap(e().getBytes("ASCII"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public int write(ByteBuffer src) throws IOException {
    return !this.a.hasRemaining() ? super.write(src) : super.write(this.a);
  }
  
  public abstract String e();
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/a/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */