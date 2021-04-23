package b.b.d;

import b.b.c.b;
import b.b.c.c;
import b.b.g.c;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
  protected static byte[] c_ = new byte[0];
  
  protected boolean d_;
  
  protected d.a e_;
  
  private ByteBuffer e;
  
  protected boolean f_;
  
  public e() {}
  
  public e(d.a parama) {
    this.e_ = parama;
    this.e = ByteBuffer.wrap(c_);
  }
  
  public e(d paramd) {
    this.d_ = paramd.d();
    this.e_ = paramd.f();
    this.e = paramd.c();
    this.f_ = paramd.e();
  }
  
  public boolean d() {
    return this.d_;
  }
  
  public d.a f() {
    return this.e_;
  }
  
  public boolean e() {
    return this.f_;
  }
  
  public ByteBuffer c() {
    return this.e;
  }
  
  public void a(boolean paramBoolean) {
    this.d_ = paramBoolean;
  }
  
  public void a(d.a parama) {
    this.e_ = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer) throws b {
    this.e = paramByteBuffer;
  }
  
  public void b(boolean paramBoolean) {
    this.f_ = paramBoolean;
  }
  
  public void a(d paramd) throws c {
    ByteBuffer byteBuffer = paramd.c();
    if (this.e == null) {
      this.e = ByteBuffer.allocate(byteBuffer.remaining());
      byteBuffer.mark();
      this.e.put(byteBuffer);
      byteBuffer.reset();
    } else {
      byteBuffer.mark();
      this.e.position(this.e.limit());
      this.e.limit(this.e.capacity());
      if (byteBuffer.remaining() > this.e.remaining()) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(byteBuffer.remaining() + this.e.capacity());
        this.e.flip();
        byteBuffer1.put(this.e);
        byteBuffer1.put(byteBuffer);
        this.e = byteBuffer1;
      } else {
        this.e.put(byteBuffer);
      } 
      this.e.rewind();
      byteBuffer.reset();
    } 
    this.d_ = paramd.d();
  }
  
  public String toString() {
    return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.e.position() + ", len:" + this.e.remaining() + "], payload:" + Arrays.toString(c.a(new String(this.e.array()))) + "}";
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/d/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */