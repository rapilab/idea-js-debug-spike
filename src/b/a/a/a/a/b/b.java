package b.a.a.a.a.b;

import b.a.a.a.a.a;
import b.a.a.a.a.c;
import b.a.a.a.d.c;
import b.a.a.a.d.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;

public class b extends c {
  private static final int a = 96;
  
  private static final int b = 234;
  
  private final DataInputStream c;
  
  private final String d;
  
  private final d e;
  
  private c f = null;
  
  private InputStream g = null;
  
  public b(InputStream paramInputStream, String paramString) throws b.a.a.a.a.b {
    this.c = new DataInputStream(paramInputStream);
    this.d = paramString;
    try {
      this.e = h();
      if ((this.e.d & 0x1) != 0)
        throw new b.a.a.a.a.b("Encrypted ARJ files are unsupported"); 
      if ((this.e.d & 0x4) != 0)
        throw new b.a.a.a.a.b("Multi-volume ARJ files are unsupported"); 
    } catch (IOException iOException) {
      throw new b.a.a.a.a.b(iOException.getMessage(), iOException);
    } 
  }
  
  public b(InputStream paramInputStream) throws b.a.a.a.a.b {
    this(paramInputStream, "CP437");
  }
  
  public void close() throws IOException {
    this.c.close();
  }
  
  private int a(DataInputStream paramDataInputStream) throws IOException {
    int i = paramDataInputStream.readUnsignedByte();
    a(1);
    return i;
  }
  
  private int b(DataInputStream paramDataInputStream) throws IOException {
    int i = paramDataInputStream.readUnsignedShort();
    a(2);
    return Integer.reverseBytes(i) >>> 16;
  }
  
  private int c(DataInputStream paramDataInputStream) throws IOException {
    int i = paramDataInputStream.readInt();
    a(4);
    return Integer.reverseBytes(i);
  }
  
  private String d(DataInputStream paramDataInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i;
    while ((i = paramDataInputStream.readUnsignedByte()) != 0)
      byteArrayOutputStream.write(i); 
    return (this.d != null) ? new String(byteArrayOutputStream.toByteArray(), this.d) : new String(byteArrayOutputStream.toByteArray());
  }
  
  private void a(DataInputStream paramDataInputStream, byte[] paramArrayOfbyte) throws IOException {
    paramDataInputStream.readFully(paramArrayOfbyte);
    a(paramArrayOfbyte.length);
  }
  
  private byte[] g() throws IOException {
    boolean bool = false;
    byte[] arrayOfByte = null;
    while (true) {
      int i = 0;
      int j = a(this.c);
      do {
        i = j;
        j = a(this.c);
      } while (i != 96 && j != 234);
      int k = b(this.c);
      if (k == 0)
        return null; 
      if (k <= 2600) {
        arrayOfByte = new byte[k];
        a(this.c, arrayOfByte);
        long l = c(this.c) & 0xFFFFFFFFL;
        CRC32 cRC32 = new CRC32();
        cRC32.update(arrayOfByte);
        if (l == cRC32.getValue())
          bool = true; 
      } 
      if (bool)
        return arrayOfByte; 
    } 
  }
  
  private d h() throws IOException {
    byte[] arrayOfByte1 = g();
    if (arrayOfByte1 == null)
      throw new IOException("Archive ends without any headers"); 
    DataInputStream dataInputStream1 = new DataInputStream(new ByteArrayInputStream(arrayOfByte1));
    int i = dataInputStream1.readUnsignedByte();
    byte[] arrayOfByte2 = new byte[i - 1];
    dataInputStream1.readFully(arrayOfByte2);
    DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(arrayOfByte2));
    d d1 = new d();
    d1.a = dataInputStream2.readUnsignedByte();
    d1.b = dataInputStream2.readUnsignedByte();
    d1.c = dataInputStream2.readUnsignedByte();
    d1.d = dataInputStream2.readUnsignedByte();
    d1.e = dataInputStream2.readUnsignedByte();
    d1.f = dataInputStream2.readUnsignedByte();
    d1.g = dataInputStream2.readUnsignedByte();
    d1.h = c(dataInputStream2);
    d1.i = c(dataInputStream2);
    d1.j = 0xFFFFFFFFL & c(dataInputStream2);
    d1.k = c(dataInputStream2);
    d1.l = b(dataInputStream2);
    d1.m = b(dataInputStream2);
    b(20L);
    d1.n = dataInputStream2.readUnsignedByte();
    d1.o = dataInputStream2.readUnsignedByte();
    if (i >= 33) {
      d1.p = dataInputStream2.readUnsignedByte();
      d1.q = dataInputStream2.readUnsignedByte();
      dataInputStream2.readUnsignedByte();
      dataInputStream2.readUnsignedByte();
    } 
    d1.r = d(dataInputStream1);
    d1.s = d(dataInputStream1);
    int j = b(this.c);
    if (j > 0) {
      d1.t = new byte[j];
      a(this.c, d1.t);
      long l = 0xFFFFFFFFL & c(this.c);
      CRC32 cRC32 = new CRC32();
      cRC32.update(d1.t);
      if (l != cRC32.getValue())
        throw new IOException("Extended header CRC32 verification failure"); 
    } 
    return d1;
  }
  
  private c i() throws IOException {
    byte[] arrayOfByte1 = g();
    if (arrayOfByte1 == null)
      return null; 
    DataInputStream dataInputStream1 = new DataInputStream(new ByteArrayInputStream(arrayOfByte1));
    int i = dataInputStream1.readUnsignedByte();
    byte[] arrayOfByte2 = new byte[i - 1];
    dataInputStream1.readFully(arrayOfByte2);
    DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(arrayOfByte2));
    c c1 = new c();
    c1.a = dataInputStream2.readUnsignedByte();
    c1.b = dataInputStream2.readUnsignedByte();
    c1.c = dataInputStream2.readUnsignedByte();
    c1.d = dataInputStream2.readUnsignedByte();
    c1.e = dataInputStream2.readUnsignedByte();
    c1.f = dataInputStream2.readUnsignedByte();
    c1.g = dataInputStream2.readUnsignedByte();
    c1.h = c(dataInputStream2);
    c1.i = 0xFFFFFFFFL & c(dataInputStream2);
    c1.j = 0xFFFFFFFFL & c(dataInputStream2);
    c1.k = 0xFFFFFFFFL & c(dataInputStream2);
    c1.l = b(dataInputStream2);
    c1.m = b(dataInputStream2);
    b(20L);
    c1.n = dataInputStream2.readUnsignedByte();
    c1.o = dataInputStream2.readUnsignedByte();
    a(i, dataInputStream2, c1);
    c1.t = d(dataInputStream1);
    c1.u = d(dataInputStream1);
    ArrayList<byte[]> arrayList = new ArrayList();
    int j;
    while ((j = b(this.c)) > 0) {
      byte[] arrayOfByte = new byte[j];
      a(this.c, arrayOfByte);
      long l = 0xFFFFFFFFL & c(this.c);
      CRC32 cRC32 = new CRC32();
      cRC32.update(arrayOfByte);
      if (l != cRC32.getValue())
        throw new IOException("Extended header CRC32 verification failure"); 
      arrayList.add(arrayOfByte);
    } 
    c1.v = arrayList.<byte[]>toArray(new byte[arrayList.size()][]);
    return c1;
  }
  
  private void a(int paramInt, DataInputStream paramDataInputStream, c paramc) throws IOException {
    if (paramInt >= 33) {
      paramc.p = c(paramDataInputStream);
      if (paramInt >= 45) {
        paramc.q = c(paramDataInputStream);
        paramc.r = c(paramDataInputStream);
        paramc.s = c(paramDataInputStream);
        b(12L);
      } 
      b(4L);
    } 
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt >= 2 && (0xFF & paramArrayOfbyte[0]) == 96 && (0xFF & paramArrayOfbyte[1]) == 234);
  }
  
  public String d() {
    return this.e.r;
  }
  
  public String e() {
    return this.e.s;
  }
  
  public a f() throws IOException {
    if (this.g != null) {
      i.a(this.g, Long.MAX_VALUE);
      this.g.close();
      this.f = null;
      this.g = null;
    } 
    this.f = i();
    if (this.f != null) {
      this.g = (InputStream)new b.a.a.a.d.b(this.c, this.f.i);
      if (this.f.e == 0)
        this.g = (InputStream)new c(this.g, this.f.j, this.f.k); 
      return new a(this.f);
    } 
    this.g = null;
    return null;
  }
  
  public boolean a(a parama) {
    return (parama instanceof a && ((a)parama).f() == 0);
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    if (this.f == null)
      throw new IllegalStateException("No current arj entry"); 
    if (this.f.e != 0)
      throw new IOException("Unsupported compression method " + this.f.e); 
    return this.g.read(arrayOfByte, off, len);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/b/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */