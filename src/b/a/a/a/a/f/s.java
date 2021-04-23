package b.a.a.a.a.f;

import b.a.a.a.d.b;
import b.a.a.a.d.c;
import b.a.a.a.d.i;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.zip.CRC32;

public class s implements Closeable {
  static final int a = 32;
  
  private RandomAccessFile c;
  
  private final c d;
  
  private int e = -1;
  
  private int f = -1;
  
  private InputStream g = null;
  
  private InputStream h = null;
  
  private byte[] i;
  
  static final byte[] b = new byte[] { 55, 122, -68, -81, 39, 28 };
  
  public s(File paramFile, byte[] paramArrayOfbyte) throws IOException {
    boolean bool = false;
    this.c = new RandomAccessFile(paramFile, "r");
    try {
      this.d = b(paramArrayOfbyte);
      if (paramArrayOfbyte != null) {
        this.i = new byte[paramArrayOfbyte.length];
        System.arraycopy(paramArrayOfbyte, 0, this.i, 0, paramArrayOfbyte.length);
      } else {
        this.i = null;
      } 
      bool = true;
    } finally {
      if (!bool)
        this.c.close(); 
    } 
  }
  
  public s(File paramFile) throws IOException {
    this(paramFile, null);
  }
  
  public void close() throws IOException {
    if (this.c != null)
      try {
        this.c.close();
      } finally {
        this.c = null;
        if (this.i != null)
          Arrays.fill(this.i, (byte)0); 
        this.i = null;
      }  
  }
  
  public r a() throws IOException {
    if (this.e >= this.d.g.length - 1)
      return null; 
    this.e++;
    r r = this.d.g[this.e];
    c();
    return r;
  }
  
  private c b(byte[] paramArrayOfbyte) throws IOException {
    byte[] arrayOfByte1 = new byte[6];
    this.c.readFully(arrayOfByte1);
    if (!Arrays.equals(arrayOfByte1, b))
      throw new IOException("Bad 7z signature"); 
    byte b1 = this.c.readByte();
    byte b2 = this.c.readByte();
    if (b1 != 0)
      throw new IOException(String.format("Unsupported 7z version (%d,%d)", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2) })); 
    long l = 0xFFFFFFFFL & Integer.reverseBytes(this.c.readInt());
    x x = a(l);
    int i = (int)x.b;
    if (i != x.b)
      throw new IOException("cannot handle nextHeaderSize " + x.b); 
    this.c.seek(32L + x.a);
    byte[] arrayOfByte2 = new byte[i];
    this.c.readFully(arrayOfByte2);
    CRC32 cRC32 = new CRC32();
    cRC32.update(arrayOfByte2);
    if (x.c != cRC32.getValue())
      throw new IOException("NextHeader CRC mismatch"); 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte2);
    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
    c c1 = new c();
    int j = dataInputStream.readUnsignedByte();
    if (j == 23) {
      dataInputStream = a(dataInputStream, c1, paramArrayOfbyte);
      c1 = new c();
      j = dataInputStream.readUnsignedByte();
    } 
    if (j == 1) {
      a(dataInputStream, c1);
      dataInputStream.close();
    } else {
      throw new IOException("Broken or unsupported archive: no Header");
    } 
    return c1;
  }
  
  private x a(long paramLong) throws IOException {
    x x = new x();
    DataInputStream dataInputStream = null;
    try {
      dataInputStream = new DataInputStream((InputStream)new c(new e(this.c, 20L), 20L, paramLong));
      x.a = Long.reverseBytes(dataInputStream.readLong());
      x.b = Long.reverseBytes(dataInputStream.readLong());
      x.c = 0xFFFFFFFFL & Integer.reverseBytes(dataInputStream.readInt());
      return x;
    } finally {
      if (dataInputStream != null)
        dataInputStream.close(); 
    } 
  }
  
  private void a(DataInput paramDataInput, c paramc) throws IOException {
    int i = paramDataInput.readUnsignedByte();
    if (i == 2) {
      a(paramDataInput);
      i = paramDataInput.readUnsignedByte();
    } 
    if (i == 3)
      throw new IOException("Additional streams unsupported"); 
    if (i == 4) {
      b(paramDataInput, paramc);
      i = paramDataInput.readUnsignedByte();
    } 
    if (i == 5) {
      f(paramDataInput, paramc);
      i = paramDataInput.readUnsignedByte();
    } 
    if (i != 0)
      throw new IOException("Badly terminated header, found " + i); 
  }
  
  private void a(DataInput paramDataInput) throws IOException {
    for (int i = paramDataInput.readUnsignedByte(); i != 0; i = paramDataInput.readUnsignedByte()) {
      long l = c(paramDataInput);
      byte[] arrayOfByte = new byte[(int)l];
      paramDataInput.readFully(arrayOfByte);
    } 
  }
  
  private DataInputStream a(DataInputStream paramDataInputStream, c paramc, byte[] paramArrayOfbyte) throws IOException {
    c c1;
    b(paramDataInputStream, paramc);
    o o = paramc.e[0];
    boolean bool = false;
    long l = 32L + paramc.a + 0L;
    this.c.seek(l);
    InputStream inputStream = new e(this.c, paramc.b[0]);
    for (i i : o.a()) {
      if (i.b != 1L || i.c != 1L)
        throw new IOException("Multi input/output stream coders are not yet supported"); 
      inputStream = k.a(inputStream, o.a(i), i, paramArrayOfbyte);
    } 
    if (o.g)
      c1 = new c(inputStream, o.b(), o.h); 
    byte[] arrayOfByte = new byte[(int)o.b()];
    DataInputStream dataInputStream = new DataInputStream((InputStream)c1);
    try {
      dataInputStream.readFully(arrayOfByte);
    } finally {
      dataInputStream.close();
    } 
    return new DataInputStream(new ByteArrayInputStream(arrayOfByte));
  }
  
  private void b(DataInput paramDataInput, c paramc) throws IOException {
    int i = paramDataInput.readUnsignedByte();
    if (i == 6) {
      c(paramDataInput, paramc);
      i = paramDataInput.readUnsignedByte();
    } 
    if (i == 7) {
      d(paramDataInput, paramc);
      i = paramDataInput.readUnsignedByte();
    } else {
      paramc.e = new o[0];
    } 
    if (i == 8) {
      e(paramDataInput, paramc);
      i = paramDataInput.readUnsignedByte();
    } 
    if (i != 0)
      throw new IOException("Badly terminated StreamsInfo"); 
  }
  
  private void c(DataInput paramDataInput, c paramc) throws IOException {
    paramc.a = c(paramDataInput);
    long l = c(paramDataInput);
    int i = paramDataInput.readUnsignedByte();
    if (i == 9) {
      paramc.b = new long[(int)l];
      for (byte b = 0; b < paramc.b.length; b++)
        paramc.b[b] = c(paramDataInput); 
      i = paramDataInput.readUnsignedByte();
    } 
    if (i == 10) {
      paramc.c = a(paramDataInput, (int)l);
      paramc.d = new long[(int)l];
      for (byte b = 0; b < (int)l; b++) {
        if (paramc.c.get(b))
          paramc.d[b] = 0xFFFFFFFFL & Integer.reverseBytes(paramDataInput.readInt()); 
      } 
      i = paramDataInput.readUnsignedByte();
    } 
    if (i != 0)
      throw new IOException("Badly terminated PackInfo (" + i + ")"); 
  }
  
  private void d(DataInput paramDataInput, c paramc) throws IOException {
    int i = paramDataInput.readUnsignedByte();
    if (i != 11)
      throw new IOException("Expected kFolder, got " + i); 
    long l = c(paramDataInput);
    o[] arrayOfO = new o[(int)l];
    paramc.e = arrayOfO;
    int j = paramDataInput.readUnsignedByte();
    if (j != 0)
      throw new IOException("External unsupported"); 
    for (byte b = 0; b < (int)l; b++)
      arrayOfO[b] = b(paramDataInput); 
    i = paramDataInput.readUnsignedByte();
    if (i != 12)
      throw new IOException("Expected kCodersUnpackSize, got " + i); 
    for (o o : arrayOfO) {
      o.f = new long[(int)o.c];
      for (byte b1 = 0; b1 < o.c; b1++)
        o.f[b1] = c(paramDataInput); 
    } 
    i = paramDataInput.readUnsignedByte();
    if (i == 10) {
      BitSet bitSet = a(paramDataInput, (int)l);
      for (byte b1 = 0; b1 < (int)l; b1++) {
        if (bitSet.get(b1)) {
          (arrayOfO[b1]).g = true;
          (arrayOfO[b1]).h = 0xFFFFFFFFL & Integer.reverseBytes(paramDataInput.readInt());
        } else {
          (arrayOfO[b1]).g = false;
        } 
      } 
      i = paramDataInput.readUnsignedByte();
    } 
    if (i != 0)
      throw new IOException("Badly terminated UnpackInfo"); 
  }
  
  private void e(DataInput paramDataInput, c paramc) throws IOException {
    for (o o : paramc.e)
      o.i = 1; 
    int i = paramc.e.length;
    int j = paramDataInput.readUnsignedByte();
    if (j == 13) {
      i = 0;
      for (o o : paramc.e) {
        long l = c(paramDataInput);
        o.i = (int)l;
        i = (int)(i + l);
      } 
      j = paramDataInput.readUnsignedByte();
    } 
    z z = new z();
    z.a = new long[i];
    z.b = new BitSet(i);
    z.c = new long[i];
    byte b = 0;
    for (o o : paramc.e) {
      if (o.i != 0) {
        long l = 0L;
        if (j == 9)
          for (byte b1 = 0; b1 < o.i - 1; b1++) {
            long l1 = c(paramDataInput);
            z.a[b++] = l1;
            l += l1;
          }  
        z.a[b++] = o.b() - l;
      } 
    } 
    if (j == 9)
      j = paramDataInput.readUnsignedByte(); 
    int k = 0;
    for (o o : paramc.e) {
      if (o.i != 1 || !o.g)
        k += o.i; 
    } 
    if (j == 10) {
      BitSet bitSet = a(paramDataInput, k);
      long[] arrayOfLong = new long[k];
      byte b1;
      for (b1 = 0; b1 < k; b1++) {
        if (bitSet.get(b1))
          arrayOfLong[b1] = 0xFFFFFFFFL & Integer.reverseBytes(paramDataInput.readInt()); 
      } 
      b1 = 0;
      byte b2 = 0;
      for (o o : paramc.e) {
        if (o.i == 1 && o.g) {
          z.b.set(b1, true);
          z.c[b1] = o.h;
          b1++;
        } else {
          for (byte b3 = 0; b3 < o.i; b3++) {
            z.b.set(b1, bitSet.get(b2));
            z.c[b1] = arrayOfLong[b2];
            b1++;
            b2++;
          } 
        } 
      } 
      j = paramDataInput.readUnsignedByte();
    } 
    if (j != 0)
      throw new IOException("Badly terminated SubStreamsInfo"); 
    paramc.f = z;
  }
  
  private o b(DataInput paramDataInput) throws IOException {
    o o = new o();
    long l1 = c(paramDataInput);
    i[] arrayOfI = new i[(int)l1];
    long l2 = 0L;
    long l3 = 0L;
    for (byte b1 = 0; b1 < arrayOfI.length; b1++) {
      arrayOfI[b1] = new i();
      int i = paramDataInput.readUnsignedByte();
      int j = i & 0xF;
      boolean bool1 = ((i & 0x10) == 0) ? true : false;
      boolean bool2 = ((i & 0x20) != 0) ? true : false;
      boolean bool3 = ((i & 0x80) != 0) ? true : false;
      (arrayOfI[b1]).a = new byte[j];
      paramDataInput.readFully((arrayOfI[b1]).a);
      if (bool1) {
        (arrayOfI[b1]).b = 1L;
        (arrayOfI[b1]).c = 1L;
      } else {
        (arrayOfI[b1]).b = c(paramDataInput);
        (arrayOfI[b1]).c = c(paramDataInput);
      } 
      l2 += (arrayOfI[b1]).b;
      l3 += (arrayOfI[b1]).c;
      if (bool2) {
        long l = c(paramDataInput);
        (arrayOfI[b1]).d = new byte[(int)l];
        paramDataInput.readFully((arrayOfI[b1]).d);
      } 
      if (bool3)
        throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either."); 
    } 
    o.a = arrayOfI;
    o.b = l2;
    o.c = l3;
    if (l3 == 0L)
      throw new IOException("Total output streams can't be 0"); 
    long l4 = l3 - 1L;
    d[] arrayOfD = new d[(int)l4];
    for (byte b2 = 0; b2 < arrayOfD.length; b2++) {
      arrayOfD[b2] = new d();
      (arrayOfD[b2]).a = c(paramDataInput);
      (arrayOfD[b2]).b = c(paramDataInput);
    } 
    o.d = arrayOfD;
    if (l2 < l4)
      throw new IOException("Total input streams can't be less than the number of bind pairs"); 
    long l5 = l2 - l4;
    long[] arrayOfLong = new long[(int)l5];
    if (l5 == 1L) {
      byte b;
      for (b = 0; b < (int)l2 && o.a(b) >= 0; b++);
      if (b == (int)l2)
        throw new IOException("Couldn't find stream's bind pair index"); 
      arrayOfLong[0] = b;
    } else {
      for (byte b = 0; b < (int)l5; b++)
        arrayOfLong[b] = c(paramDataInput); 
    } 
    o.e = arrayOfLong;
    return o;
  }
  
  private BitSet a(DataInput paramDataInput, int paramInt) throws IOException {
    BitSet bitSet;
    int i = paramDataInput.readUnsignedByte();
    if (i != 0) {
      bitSet = new BitSet(paramInt);
      for (byte b = 0; b < paramInt; b++)
        bitSet.set(b, true); 
    } else {
      bitSet = b(paramDataInput, paramInt);
    } 
    return bitSet;
  }
  
  private BitSet b(DataInput paramDataInput, int paramInt) throws IOException {
    BitSet bitSet = new BitSet(paramInt);
    int i = 0;
    int j = 0;
    for (byte b = 0; b < paramInt; b++) {
      if (!i) {
        i = 128;
        j = paramDataInput.readUnsignedByte();
      } 
      bitSet.set(b, ((j & i) != 0));
      i >>>= 1;
    } 
    return bitSet;
  }
  
  private void f(DataInput paramDataInput, c paramc) throws IOException {
    long l = c(paramDataInput);
    r[] arrayOfR = new r[(int)l];
    for (byte b = 0; b < arrayOfR.length; b++)
      arrayOfR[b] = new r(); 
    BitSet bitSet1 = null;
    BitSet bitSet2 = null;
    BitSet bitSet3 = null;
    while (true) {
      int j;
      BitSet bitSet;
      byte[] arrayOfByte;
      int k;
      byte b1;
      int m;
      byte b2;
      int i = paramDataInput.readUnsignedByte();
      if (i == 0) {
        i = 0;
        byte b3 = 0;
        for (byte b4 = 0; b4 < arrayOfR.length; b4++) {
          arrayOfR[b4].a((bitSet1 == null) ? true : (!bitSet1.get(b4)));
          if (arrayOfR[b4].b()) {
            arrayOfR[b4].b(false);
            arrayOfR[b4].c(false);
            arrayOfR[b4].h(paramc.f.b.get(i));
            arrayOfR[b4].d(paramc.f.c[i]);
            arrayOfR[b4].f(paramc.f.a[i]);
            i++;
          } else {
            arrayOfR[b4].b((bitSet2 == null) ? true : (!bitSet2.get(b3)));
            arrayOfR[b4].c((bitSet3 == null) ? false : bitSet3.get(b3));
            arrayOfR[b4].h(false);
            arrayOfR[b4].f(0L);
            b3++;
          } 
        } 
        paramc.g = arrayOfR;
        a(paramc);
        return;
      } 
      long l1 = c(paramDataInput);
      switch (i) {
        case 14:
          bitSet1 = b(paramDataInput, arrayOfR.length);
          continue;
        case 15:
          if (bitSet1 == null)
            throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile"); 
          bitSet2 = b(paramDataInput, bitSet1.cardinality());
          continue;
        case 16:
          if (bitSet1 == null)
            throw new IOException("Header format error: kEmptyStream must appear before kAnti"); 
          bitSet3 = b(paramDataInput, bitSet1.cardinality());
          continue;
        case 17:
          j = paramDataInput.readUnsignedByte();
          if (j != 0)
            throw new IOException("Not implemented"); 
          if ((l1 - 1L & 0x1L) != 0L)
            throw new IOException("File names length invalid"); 
          arrayOfByte = new byte[(int)(l1 - 1L)];
          paramDataInput.readFully(arrayOfByte);
          b1 = 0;
          m = 0;
          for (b2 = 0; b2 < arrayOfByte.length; b2 += 2) {
            if (arrayOfByte[b2] == 0 && arrayOfByte[b2 + 1] == 0) {
              arrayOfR[b1++].a(new String(arrayOfByte, m, b2 - m, "UTF-16LE"));
              m = b2 + 2;
            } 
          } 
          if (m != arrayOfByte.length || b1 != arrayOfR.length)
            throw new IOException("Error parsing file names"); 
          continue;
        case 18:
          bitSet = a(paramDataInput, arrayOfR.length);
          k = paramDataInput.readUnsignedByte();
          if (k != 0)
            throw new IOException("Unimplemented"); 
          for (b1 = 0; b1 < arrayOfR.length; b1++) {
            arrayOfR[b1].d(bitSet.get(b1));
            if (arrayOfR[b1].d())
              arrayOfR[b1].a(Long.reverseBytes(paramDataInput.readLong())); 
          } 
          continue;
        case 19:
          bitSet = a(paramDataInput, arrayOfR.length);
          k = paramDataInput.readUnsignedByte();
          if (k != 0)
            throw new IOException("Unimplemented"); 
          for (b1 = 0; b1 < arrayOfR.length; b1++) {
            arrayOfR[b1].f(bitSet.get(b1));
            if (arrayOfR[b1].g())
              arrayOfR[b1].c(Long.reverseBytes(paramDataInput.readLong())); 
          } 
          continue;
        case 20:
          bitSet = a(paramDataInput, arrayOfR.length);
          k = paramDataInput.readUnsignedByte();
          if (k != 0)
            throw new IOException("Unimplemented"); 
          for (b1 = 0; b1 < arrayOfR.length; b1++) {
            arrayOfR[b1].e(bitSet.get(b1));
            if (arrayOfR[b1].f())
              arrayOfR[b1].b(Long.reverseBytes(paramDataInput.readLong())); 
          } 
          continue;
        case 21:
          bitSet = a(paramDataInput, arrayOfR.length);
          k = paramDataInput.readUnsignedByte();
          if (k != 0)
            throw new IOException("Unimplemented"); 
          for (b1 = 0; b1 < arrayOfR.length; b1++) {
            arrayOfR[b1].g(bitSet.get(b1));
            if (arrayOfR[b1].i())
              arrayOfR[b1].a(Integer.reverseBytes(paramDataInput.readInt())); 
          } 
          continue;
        case 24:
          throw new IOException("kStartPos is unsupported, please report");
        case 25:
          if (a(paramDataInput, l1) < l1)
            throw new IOException("Incomplete kDummy property"); 
          continue;
      } 
      if (a(paramDataInput, l1) < l1)
        throw new IOException("Incomplete property of type " + i); 
    } 
  }
  
  private void a(c paramc) throws IOException {
    y y = new y();
    int i = 0;
    byte b1 = (paramc.e != null) ? paramc.e.length : 0;
    y.a = new int[b1];
    for (byte b2 = 0; b2 < b1; b2++) {
      y.a[b2] = i;
      i += (paramc.e[b2]).e.length;
    } 
    long l = 0L;
    byte b3 = (paramc.b != null) ? paramc.b.length : 0;
    y.b = new long[b3];
    byte b4;
    for (b4 = 0; b4 < b3; b4++) {
      y.b[b4] = l;
      l += paramc.b[b4];
    } 
    y.c = new int[b1];
    y.d = new int[paramc.g.length];
    b4 = 0;
    byte b5 = 0;
    for (byte b6 = 0; b6 < paramc.g.length; b6++) {
      if (!paramc.g[b6].b() && !b5) {
        y.d[b6] = -1;
      } else {
        if (!b5) {
          while (b4 < paramc.e.length) {
            y.c[b4] = b6;
            if ((paramc.e[b4]).i > 0)
              break; 
            b4++;
          } 
          if (b4 >= paramc.e.length)
            throw new IOException("Too few folders in archive"); 
        } 
        y.d[b6] = b4;
        if (paramc.g[b6].b() && ++b5 >= (paramc.e[b4]).i) {
          b4++;
          b5 = 0;
        } 
      } 
    } 
    paramc.h = y;
  }
  
  private void c() throws IOException {
    int i = this.d.h.d[this.e];
    if (i < 0) {
      this.h = (InputStream)new b(new ByteArrayInputStream(new byte[0]), 0L);
      return;
    } 
    r r = this.d.g[this.e];
    if (this.f == i) {
      d();
      r.a(this.d.g[this.e - 1].q());
    } else {
      this.f = i;
      if (this.g != null) {
        this.g.close();
        this.g = null;
      } 
      o o = this.d.e[i];
      int j = this.d.h.a[i];
      long l = 32L + this.d.a + this.d.h.b[j];
      this.g = a(o, l, j, r);
    } 
    b b = new b(this.g, r.getSize());
    if (r.k()) {
      this.h = (InputStream)new c((InputStream)b, r.getSize(), r.m());
    } else {
      this.h = (InputStream)b;
    } 
  }
  
  private void d() throws IOException {
    if (this.h != null) {
      i.a(this.h, Long.MAX_VALUE);
      this.h.close();
      this.h = null;
    } 
  }
  
  private InputStream a(o paramo, long paramLong, int paramInt, r paramr) throws IOException {
    this.c.seek(paramLong);
    InputStream inputStream = new e(this.c, this.d.b[paramInt]);
    LinkedList<u> linkedList = new LinkedList();
    for (i i : paramo.a()) {
      if (i.b != 1L || i.c != 1L)
        throw new IOException("Multi input/output stream coders are not yet supported"); 
      t t = t.a(i.a);
      inputStream = k.a(inputStream, paramo.a(i), i, this.i);
      linkedList.addFirst(new u(t, k.a(t).a(i, inputStream)));
    } 
    paramr.a(linkedList);
    return (InputStream)(paramo.g ? new c(inputStream, paramo.b(), paramo.h) : inputStream);
  }
  
  public int b() throws IOException {
    if (this.h == null)
      throw new IllegalStateException("No current 7z entry"); 
    return this.h.read();
  }
  
  public int a(byte[] paramArrayOfbyte) throws IOException {
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (this.h == null)
      throw new IllegalStateException("No current 7z entry"); 
    return this.h.read(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private static long c(DataInput paramDataInput) throws IOException {
    long l1 = paramDataInput.readUnsignedByte();
    int i = 128;
    long l2 = 0L;
    for (byte b = 0; b < 8; b++) {
      if ((l1 & i) == 0L)
        return l2 | (l1 & (i - 1)) << 8 * b; 
      long l = paramDataInput.readUnsignedByte();
      l2 |= l << 8 * b;
      i >>>= 1;
    } 
    return l2;
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt < b.length)
      return false; 
    for (byte b = 0; b < b.length; b++) {
      if (paramArrayOfbyte[b] != b[b])
        return false; 
    } 
    return true;
  }
  
  private static long a(DataInput paramDataInput, long paramLong) throws IOException {
    if (paramLong < 1L)
      return 0L; 
    long l = 0L;
    while (paramLong > 2147483647L) {
      long l1 = a(paramDataInput, 2147483647L);
      if (l1 == 0L)
        return l; 
      l += l1;
      paramLong -= l1;
    } 
    while (paramLong > 0L) {
      int i = paramDataInput.skipBytes((int)paramLong);
      if (i == 0)
        return l; 
      l += i;
      paramLong -= i;
    } 
    return l;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/s.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */