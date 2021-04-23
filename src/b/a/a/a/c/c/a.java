package b.a.a.a.c.c;

import b.a.a.a.c.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class a extends b {
  private static final int b = 2;
  
  private static final int c = 4;
  
  private static final int d = 8;
  
  private static final int e = 16;
  
  private static final int f = 224;
  
  private final InputStream g;
  
  private final boolean h;
  
  private final byte[] i = new byte[8192];
  
  private int j = 0;
  
  private Inflater k = new Inflater(true);
  
  private final CRC32 l = new CRC32();
  
  private boolean m = false;
  
  private final byte[] n = new byte[1];
  
  private final c o = new c();
  
  public a(InputStream paramInputStream) throws IOException {
    this(paramInputStream, false);
  }
  
  public a(InputStream paramInputStream, boolean paramBoolean) throws IOException {
    if (paramInputStream.markSupported()) {
      this.g = paramInputStream;
    } else {
      this.g = new BufferedInputStream(paramInputStream);
    } 
    this.h = paramBoolean;
    a(true);
  }
  
  public c a() {
    return this.o;
  }
  
  private boolean a(boolean paramBoolean) throws IOException {
    if (!a && !paramBoolean && !this.h)
      throw new AssertionError(); 
    int i = this.g.read();
    int j = this.g.read();
    if (i == -1 && !paramBoolean)
      return false; 
    if (i != 31 || j != 139)
      throw new IOException(paramBoolean ? "Input is not in the .gz format" : "Garbage after a valid .gz stream"); 
    DataInputStream dataInputStream = new DataInputStream(this.g);
    int k = dataInputStream.readUnsignedByte();
    if (k != 8)
      throw new IOException("Unsupported compression method " + k + " in the .gz header"); 
    int m = dataInputStream.readUnsignedByte();
    if ((m & 0xE0) != 0)
      throw new IOException("Reserved flags are set in the .gz header"); 
    this.o.a(b(dataInputStream) * 1000L);
    switch (dataInputStream.readUnsignedByte()) {
      case 2:
        this.o.a(9);
        break;
      case 4:
        this.o.a(1);
        break;
    } 
    this.o.b(dataInputStream.readUnsignedByte());
    if ((m & 0x4) != 0) {
      int n = dataInputStream.readUnsignedByte();
      n |= dataInputStream.readUnsignedByte() << 8;
      while (n-- > 0)
        dataInputStream.readUnsignedByte(); 
    } 
    if ((m & 0x8) != 0)
      this.o.a(new String(a(dataInputStream), "ISO-8859-1")); 
    if ((m & 0x10) != 0)
      this.o.b(new String(a(dataInputStream), "ISO-8859-1")); 
    if ((m & 0x2) != 0)
      dataInputStream.readShort(); 
    this.k.reset();
    this.l.reset();
    return true;
  }
  
  private byte[] a(DataInputStream paramDataInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while ((i = paramDataInputStream.readUnsignedByte()) != 0)
      byteArrayOutputStream.write(i); 
    return byteArrayOutputStream.toByteArray();
  }
  
  private long b(DataInputStream paramDataInputStream) throws IOException {
    return (paramDataInputStream.readUnsignedByte() | paramDataInputStream.readUnsignedByte() << 8 | paramDataInputStream.readUnsignedByte() << 16) | paramDataInputStream.readUnsignedByte() << 24L;
  }
  
  public int read() throws IOException {
    return (read(this.n, 0, 1) == -1) ? -1 : (this.n[0] & 0xFF);
  }
  
  public int read(byte[] arrayOfByte, int off, int len) throws IOException {
    if (this.m)
      return -1; 
    int i = 0;
    while (len > 0) {
      int j;
      if (this.k.needsInput()) {
        this.g.mark(this.i.length);
        this.j = this.g.read(this.i);
        if (this.j == -1)
          throw new EOFException(); 
        this.k.setInput(this.i, 0, this.j);
      } 
      try {
        j = this.k.inflate(arrayOfByte, off, len);
      } catch (DataFormatException dataFormatException) {
        throw new IOException("Gzip-compressed data is corrupt");
      } 
      this.l.update(arrayOfByte, off, j);
      off += j;
      len -= j;
      i += j;
      a(j);
      if (this.k.finished()) {
        this.g.reset();
        int k = this.j - this.k.getRemaining();
        if (this.g.skip(k) != k)
          throw new IOException(); 
        this.j = 0;
        DataInputStream dataInputStream = new DataInputStream(this.g);
        long l1 = b(dataInputStream);
        if (l1 != this.l.getValue())
          throw new IOException("Gzip-compressed data is corrupt (CRC32 error)"); 
        long l2 = b(dataInputStream);
        if (l2 != (this.k.getBytesWritten() & 0xFFFFFFFFL))
          throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)"); 
        if (!this.h || !a(false)) {
          this.k.end();
          this.k = null;
          this.m = true;
          return (i == 0) ? -1 : i;
        } 
      } 
    } 
    return i;
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < 2) ? false : ((paramArrayOfbyte[0] != 31) ? false : (!(paramArrayOfbyte[1] != -117)));
  }
  
  public void close() throws IOException {
    if (this.k != null) {
      this.k.end();
      this.k = null;
    } 
    if (this.g != System.in)
      this.g.close(); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/c/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */