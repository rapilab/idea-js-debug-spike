package b.b;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

public class c {
  public static boolean a(ByteBuffer paramByteBuffer, g paramg, ByteChannel paramByteChannel) throws IOException {
    paramByteBuffer.clear();
    int i = paramByteChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1) {
      paramg.n();
      return false;
    } 
    return (i != 0);
  }
  
  public static boolean a(ByteBuffer paramByteBuffer, g paramg, i parami) throws IOException {
    paramByteBuffer.clear();
    int j = parami.a(paramByteBuffer);
    paramByteBuffer.flip();
    if (j == -1) {
      paramg.n();
      return false;
    } 
    return parami.c();
  }
  
  public static boolean a(g paramg, ByteChannel paramByteChannel) throws IOException {
    ByteBuffer byteBuffer = paramg.h.peek();
    i i = null;
    if (byteBuffer == null) {
      if (paramByteChannel instanceof i) {
        i = (i)paramByteChannel;
        if (i.a())
          i.b(); 
      } 
    } else {
      do {
        paramByteChannel.write(byteBuffer);
        if (byteBuffer.remaining() > 0)
          return false; 
        paramg.h.poll();
        byteBuffer = paramg.h.peek();
      } while (byteBuffer != null);
    } 
    if (paramg.h.isEmpty() && paramg.h() && paramg.j().d() == d.b.b)
      synchronized (paramg) {
        paramg.m();
      }  
    return (i != null) ? (!((i)paramByteChannel).a()) : true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */