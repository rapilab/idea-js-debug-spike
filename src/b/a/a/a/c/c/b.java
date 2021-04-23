package b.a.a.a.c.c;

import b.a.a.a.c.c;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public class b extends c {
  private static final int a = 8;
  
  private static final int b = 16;
  
  private final OutputStream c;
  
  private final Deflater d;
  
  private final byte[] e = new byte[512];
  
  private boolean f;
  
  private final CRC32 g = new CRC32();
  
  public b(OutputStream paramOutputStream) throws IOException {
    this(paramOutputStream, new c());
  }
  
  public b(OutputStream paramOutputStream, c paramc) throws IOException {
    this.c = paramOutputStream;
    this.d = new Deflater(paramc.a(), true);
    a(paramc);
  }
  
  private void a(c paramc) throws IOException {
    String str1 = paramc.c();
    String str2 = paramc.d();
    ByteBuffer byteBuffer = ByteBuffer.allocate(10);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byteBuffer.putShort((short)-29921);
    byteBuffer.put((byte)8);
    byteBuffer.put((byte)(((str1 != null) ? 8 : 0) | ((str2 != null) ? 16 : 0)));
    byteBuffer.putInt((int)(paramc.b() / 1000L));
    int i = paramc.a();
    if (i == 9) {
      byteBuffer.put((byte)2);
    } else if (i == 1) {
      byteBuffer.put((byte)4);
    } else {
      byteBuffer.put((byte)0);
    } 
    byteBuffer.put((byte)paramc.e());
    this.c.write(byteBuffer.array());
    if (str1 != null) {
      this.c.write(str1.getBytes("ISO-8859-1"));
      this.c.write(0);
    } 
    if (str2 != null) {
      this.c.write(str2.getBytes("ISO-8859-1"));
      this.c.write(0);
    } 
  }
  
  private void b() throws IOException {
    ByteBuffer byteBuffer = ByteBuffer.allocate(8);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byteBuffer.putInt((int)this.g.getValue());
    byteBuffer.putInt(this.d.getTotalIn());
    this.c.write(byteBuffer.array());
  }
  
  public void write(int i) throws IOException {
    write(new byte[] { (byte)(i & 0xFF) }, 0, 1);
  }
  
  public void write(byte[] buffer) throws IOException {
    write(buffer, 0, buffer.length);
  }
  
  public void write(byte[] buffer, int offset, int length) throws IOException {
    if (this.d.finished())
      throw new IOException("Cannot write more data, the end of the compressed data stream has been reached"); 
    if (length > 0) {
      this.d.setInput(buffer, offset, length);
      while (!this.d.needsInput())
        c(); 
      this.g.update(buffer, offset, length);
    } 
  }
  
  private void c() throws IOException {
    int i = this.d.deflate(this.e, 0, this.e.length);
    if (i > 0)
      this.c.write(this.e, 0, i); 
  }
  
  public void a() throws IOException {
    if (!this.d.finished()) {
      this.d.finish();
      while (!this.d.finished())
        c(); 
      b();
    } 
  }
  
  public void flush() throws IOException {
    this.c.flush();
  }
  
  public void close() throws IOException {
    if (!this.f) {
      a();
      this.d.end();
      this.c.close();
      this.f = true;
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/c/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */