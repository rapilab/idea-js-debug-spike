package b.b.d;

import b.b.c.c;
import b.b.g.c;
import java.nio.ByteBuffer;

public class b extends e implements a {
  static final ByteBuffer p = ByteBuffer.allocate(0);
  
  private int q;
  
  private String r;
  
  public b() {
    super(d.a.f);
    a(true);
  }
  
  public b(int paramInt) throws b.b.c.b {
    super(d.a.f);
    a(true);
    a(paramInt, "");
  }
  
  public b(int paramInt, String paramString) throws b.b.c.b {
    super(d.a.f);
    a(true);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString) throws b.b.c.b {
    if (paramString == null)
      paramString = ""; 
    if (paramInt == 1015) {
      paramInt = 1005;
      paramString = "";
    } 
    if (paramInt == 1005) {
      if (0 < paramString.length())
        throw new b.b.c.b(1002, "A close frame must have a closecode if it has a reason"); 
      return;
    } 
    byte[] arrayOfByte = c.a(paramString);
    ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
    byteBuffer1.putInt(paramInt);
    byteBuffer1.position(2);
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(2 + arrayOfByte.length);
    byteBuffer2.put(byteBuffer1);
    byteBuffer2.put(arrayOfByte);
    byteBuffer2.rewind();
    a(byteBuffer2);
  }
  
  private void g() throws c {
    this.q = 1005;
    ByteBuffer byteBuffer = super.c();
    byteBuffer.mark();
    if (byteBuffer.remaining() >= 2) {
      ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
      byteBuffer1.position(2);
      byteBuffer1.putShort(byteBuffer.getShort());
      byteBuffer1.position(0);
      this.q = byteBuffer1.getInt();
      if (this.q == 1006 || this.q == 1015 || this.q == 1005 || this.q > 4999 || this.q < 1000 || this.q == 1004)
        throw new c("closecode must not be sent over the wire: " + this.q); 
    } 
    byteBuffer.reset();
  }
  
  public int a() {
    return this.q;
  }
  
  private void h() throws b.b.c.b {
    if (this.q == 1005) {
      this.r = c.a(super.c());
    } else {
      ByteBuffer byteBuffer = super.c();
      int i = byteBuffer.position();
      try {
        byteBuffer.position(byteBuffer.position() + 2);
        this.r = c.a(byteBuffer);
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new c(illegalArgumentException);
      } finally {
        byteBuffer.position(i);
      } 
    } 
  }
  
  public String b() {
    return this.r;
  }
  
  public String toString() {
    return super.toString() + "code: " + this.q;
  }
  
  public void a(ByteBuffer paramByteBuffer) throws b.b.c.b {
    super.a(paramByteBuffer);
    g();
    h();
  }
  
  public ByteBuffer c() {
    return (this.q == 1005) ? p : super.c();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/d/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */