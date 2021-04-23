package b.a.a.a.a.f;

import b.a.a.a.d.h;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

public class v implements Closeable {
  private final RandomAccessFile a;
  
  private final List<r> b = new ArrayList<r>();
  
  private int c = 0;
  
  private final CRC32 d = new CRC32();
  
  private final CRC32 e = new CRC32();
  
  private long f = 0L;
  
  private boolean g = false;
  
  private h h;
  
  private h[] i;
  
  private Iterable<? extends u> j = Collections.singletonList(new u(t.c));
  
  private final Map<r, long[]> k = (Map)new HashMap<r, long>();
  
  public v(File paramFile) throws IOException {
    this.a = new RandomAccessFile(paramFile, "rw");
    this.a.seek(32L);
  }
  
  public void a(t paramt) {
    a(Collections.singletonList(new u(paramt)));
  }
  
  public void a(Iterable<? extends u> paramIterable) {
    this.j = b(paramIterable);
  }
  
  public void close() throws IOException {
    if (!this.g)
      b(); 
    this.a.close();
  }
  
  public r a(File paramFile, String paramString) throws IOException {
    r r = new r();
    r.b(paramFile.isDirectory());
    r.a(paramString);
    r.b(new Date(paramFile.lastModified()));
    return r;
  }
  
  public void a(b.a.a.a.a.a parama) throws IOException {
    r r = (r)parama;
    this.b.add(r);
  }
  
  public void a() throws IOException {
    if (this.h != null) {
      this.h.flush();
      this.h.close();
    } 
    r r = this.b.get(this.b.size() - 1);
    if (this.f > 0L) {
      r.a(true);
      this.c++;
      r.f(this.h.a());
      r.g(this.f);
      r.d(this.d.getValue());
      r.e(this.e.getValue());
      r.h(true);
      if (this.i != null) {
        long[] arrayOfLong = new long[this.i.length];
        for (byte b = 0; b < this.i.length; b++)
          arrayOfLong[b] = this.i[b].a(); 
        this.k.put(r, arrayOfLong);
      } 
    } else {
      r.a(false);
      r.f(0L);
      r.g(0L);
      r.h(false);
    } 
    this.h = null;
    this.i = null;
    this.d.reset();
    this.e.reset();
    this.f = 0L;
  }
  
  public void a(int paramInt) throws IOException {
    c().write(paramInt);
  }
  
  public void a(byte[] paramArrayOfbyte) throws IOException {
    a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 > 0)
      c().write(paramArrayOfbyte, paramInt1, paramInt2); 
  }
  
  public void b() throws IOException {
    if (this.g)
      throw new IOException("This archive has already been finished"); 
    this.g = true;
    long l = this.a.getFilePointer();
    ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream1 = new DataOutputStream(byteArrayOutputStream1);
    a(dataOutputStream1);
    dataOutputStream1.flush();
    byte[] arrayOfByte1 = byteArrayOutputStream1.toByteArray();
    this.a.write(arrayOfByte1);
    CRC32 cRC32 = new CRC32();
    this.a.seek(0L);
    this.a.write(s.b);
    this.a.write(0);
    this.a.write(2);
    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
    dataOutputStream2.writeLong(Long.reverseBytes(l - 32L));
    dataOutputStream2.writeLong(Long.reverseBytes(0xFFFFFFFFL & arrayOfByte1.length));
    cRC32.reset();
    cRC32.update(arrayOfByte1);
    dataOutputStream2.writeInt(Integer.reverseBytes((int)cRC32.getValue()));
    dataOutputStream2.flush();
    byte[] arrayOfByte2 = byteArrayOutputStream2.toByteArray();
    cRC32.reset();
    cRC32.update(arrayOfByte2);
    this.a.writeInt(Integer.reverseBytes((int)cRC32.getValue()));
    this.a.write(arrayOfByte2);
  }
  
  private OutputStream c() throws IOException {
    if (this.h == null)
      this.h = d(); 
    return (OutputStream)this.h;
  }
  
  private h d() throws IOException {
    if (this.b.isEmpty())
      throw new IllegalStateException("No current 7z entry"); 
    OutputStream outputStream = new a(null);
    ArrayList<h> arrayList = new ArrayList();
    boolean bool = true;
    for (u u : a(this.b.get(this.b.size() - 1))) {
      h h1;
      if (!bool) {
        h h2 = new h(outputStream);
        arrayList.add(h2);
        h1 = h2;
      } 
      outputStream = k.a((OutputStream)h1, u.a(), u.b());
      bool = false;
    } 
    if (!arrayList.isEmpty())
      this.i = arrayList.<h>toArray(new h[arrayList.size()]); 
    return new w(this, outputStream);
  }
  
  private Iterable<? extends u> a(r paramr) {
    Iterable<? extends u> iterable = paramr.q();
    return (iterable == null) ? this.j : iterable;
  }
  
  private void a(DataOutput paramDataOutput) throws IOException {
    paramDataOutput.write(1);
    paramDataOutput.write(4);
    b(paramDataOutput);
    f(paramDataOutput);
    paramDataOutput.write(0);
  }
  
  private void b(DataOutput paramDataOutput) throws IOException {
    if (this.c > 0) {
      c(paramDataOutput);
      d(paramDataOutput);
    } 
    e(paramDataOutput);
    paramDataOutput.write(0);
  }
  
  private void c(DataOutput paramDataOutput) throws IOException {
    paramDataOutput.write(6);
    a(paramDataOutput, 0L);
    a(paramDataOutput, 0xFFFFFFFFL & this.c);
    paramDataOutput.write(9);
    for (r r : this.b) {
      if (r.b())
        a(paramDataOutput, r.p()); 
    } 
    paramDataOutput.write(10);
    paramDataOutput.write(1);
    for (r r : this.b) {
      if (r.b())
        paramDataOutput.writeInt(Integer.reverseBytes((int)r.o())); 
    } 
    paramDataOutput.write(0);
  }
  
  private void d(DataOutput paramDataOutput) throws IOException {
    paramDataOutput.write(7);
    paramDataOutput.write(11);
    a(paramDataOutput, this.c);
    paramDataOutput.write(0);
    for (r r : this.b) {
      if (r.b())
        a(paramDataOutput, r); 
    } 
    paramDataOutput.write(12);
    for (r r : this.b) {
      if (r.b()) {
        long[] arrayOfLong = this.k.get(r);
        if (arrayOfLong != null)
          for (long l : arrayOfLong)
            a(paramDataOutput, l);  
        a(paramDataOutput, r.getSize());
      } 
    } 
    paramDataOutput.write(10);
    paramDataOutput.write(1);
    for (r r : this.b) {
      if (r.b())
        paramDataOutput.writeInt(Integer.reverseBytes((int)r.m())); 
    } 
    paramDataOutput.write(0);
  }
  
  private void a(DataOutput paramDataOutput, r paramr) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte b1 = 0;
    for (u u : a(paramr)) {
      b1++;
      a(u, byteArrayOutputStream);
    } 
    a(paramDataOutput, b1);
    paramDataOutput.write(byteArrayOutputStream.toByteArray());
    for (byte b2 = 0; b2 < b1 - 1; b2++) {
      a(paramDataOutput, (b2 + 1));
      a(paramDataOutput, b2);
    } 
  }
  
  private void a(u paramu, OutputStream paramOutputStream) throws IOException {
    byte[] arrayOfByte1 = paramu.a().b();
    byte[] arrayOfByte2 = k.a(paramu.a()).b(paramu.b());
    int i = arrayOfByte1.length;
    if (arrayOfByte2.length > 0)
      i |= 0x20; 
    paramOutputStream.write(i);
    paramOutputStream.write(arrayOfByte1);
    if (arrayOfByte2.length > 0) {
      paramOutputStream.write(arrayOfByte2.length);
      paramOutputStream.write(arrayOfByte2);
    } 
  }
  
  private void e(DataOutput paramDataOutput) throws IOException {
    paramDataOutput.write(8);
    paramDataOutput.write(0);
  }
  
  private void f(DataOutput paramDataOutput) throws IOException {
    paramDataOutput.write(5);
    a(paramDataOutput, this.b.size());
    g(paramDataOutput);
    h(paramDataOutput);
    i(paramDataOutput);
    j(paramDataOutput);
    k(paramDataOutput);
    l(paramDataOutput);
    m(paramDataOutput);
    n(paramDataOutput);
    paramDataOutput.write(0);
  }
  
  private void g(DataOutput paramDataOutput) throws IOException {
    boolean bool = false;
    for (r r : this.b) {
      if (!r.b()) {
        bool = true;
        break;
      } 
    } 
    if (bool) {
      paramDataOutput.write(14);
      BitSet bitSet = new BitSet(this.b.size());
      for (byte b = 0; b < this.b.size(); b++)
        bitSet.set(b, !((r)this.b.get(b)).b()); 
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      a(dataOutputStream, bitSet, this.b.size());
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void h(DataOutput paramDataOutput) throws IOException {
    int i = 0;
    byte b1 = 0;
    BitSet bitSet = new BitSet(0);
    for (byte b2 = 0; b2 < this.b.size(); b2++) {
      if (!((r)this.b.get(b2)).b()) {
        boolean bool = ((r)this.b.get(b2)).isDirectory();
        bitSet.set(b1++, !bool);
        i |= !bool ? 1 : 0;
      } 
    } 
    if (i != 0) {
      paramDataOutput.write(15);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      a(dataOutputStream, bitSet, b1);
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void i(DataOutput paramDataOutput) throws IOException {
    boolean bool = false;
    BitSet bitSet = new BitSet(0);
    byte b1 = 0;
    for (byte b2 = 0; b2 < this.b.size(); b2++) {
      if (!((r)this.b.get(b2)).b()) {
        boolean bool1 = ((r)this.b.get(b2)).c();
        bitSet.set(b1++, bool1);
        bool |= bool1;
      } 
    } 
    if (bool) {
      paramDataOutput.write(16);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      a(dataOutputStream, bitSet, b1);
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void j(DataOutput paramDataOutput) throws IOException {
    paramDataOutput.write(17);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    dataOutputStream.write(0);
    for (r r : this.b) {
      dataOutputStream.write(r.getName().getBytes("UTF-16LE"));
      dataOutputStream.writeShort(0);
    } 
    dataOutputStream.flush();
    byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    a(paramDataOutput, arrayOfByte.length);
    paramDataOutput.write(arrayOfByte);
  }
  
  private void k(DataOutput paramDataOutput) throws IOException {
    byte b = 0;
    for (r r : this.b) {
      if (r.d())
        b++; 
    } 
    if (b > 0) {
      paramDataOutput.write(18);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      if (b != this.b.size()) {
        dataOutputStream.write(0);
        BitSet bitSet = new BitSet(this.b.size());
        for (byte b1 = 0; b1 < this.b.size(); b1++)
          bitSet.set(b1, ((r)this.b.get(b1)).d()); 
        a(dataOutputStream, bitSet, this.b.size());
      } else {
        dataOutputStream.write(1);
      } 
      dataOutputStream.write(0);
      for (r r : this.b) {
        if (r.d())
          dataOutputStream.writeLong(Long.reverseBytes(r.d(r.e()))); 
      } 
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void l(DataOutput paramDataOutput) throws IOException {
    byte b = 0;
    for (r r : this.b) {
      if (r.g())
        b++; 
    } 
    if (b > 0) {
      paramDataOutput.write(19);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      if (b != this.b.size()) {
        dataOutputStream.write(0);
        BitSet bitSet = new BitSet(this.b.size());
        for (byte b1 = 0; b1 < this.b.size(); b1++)
          bitSet.set(b1, ((r)this.b.get(b1)).g()); 
        a(dataOutputStream, bitSet, this.b.size());
      } else {
        dataOutputStream.write(1);
      } 
      dataOutputStream.write(0);
      for (r r : this.b) {
        if (r.g())
          dataOutputStream.writeLong(Long.reverseBytes(r.d(r.h()))); 
      } 
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void m(DataOutput paramDataOutput) throws IOException {
    byte b = 0;
    for (r r : this.b) {
      if (r.f())
        b++; 
    } 
    if (b > 0) {
      paramDataOutput.write(20);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      if (b != this.b.size()) {
        dataOutputStream.write(0);
        BitSet bitSet = new BitSet(this.b.size());
        for (byte b1 = 0; b1 < this.b.size(); b1++)
          bitSet.set(b1, ((r)this.b.get(b1)).f()); 
        a(dataOutputStream, bitSet, this.b.size());
      } else {
        dataOutputStream.write(1);
      } 
      dataOutputStream.write(0);
      for (r r : this.b) {
        if (r.f())
          dataOutputStream.writeLong(Long.reverseBytes(r.d(r.a()))); 
      } 
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void n(DataOutput paramDataOutput) throws IOException {
    byte b = 0;
    for (r r : this.b) {
      if (r.i())
        b++; 
    } 
    if (b > 0) {
      paramDataOutput.write(21);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
      if (b != this.b.size()) {
        dataOutputStream.write(0);
        BitSet bitSet = new BitSet(this.b.size());
        for (byte b1 = 0; b1 < this.b.size(); b1++)
          bitSet.set(b1, ((r)this.b.get(b1)).i()); 
        a(dataOutputStream, bitSet, this.b.size());
      } else {
        dataOutputStream.write(1);
      } 
      dataOutputStream.write(0);
      for (r r : this.b) {
        if (r.i())
          dataOutputStream.writeInt(Integer.reverseBytes(r.j())); 
      } 
      dataOutputStream.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      a(paramDataOutput, arrayOfByte.length);
      paramDataOutput.write(arrayOfByte);
    } 
  }
  
  private void a(DataOutput paramDataOutput, long paramLong) throws IOException {
    int i = 0;
    int j = 128;
    byte b;
    for (b = 0; b < 8; b++) {
      if (paramLong < 1L << 7 * (b + 1)) {
        i = (int)(i | paramLong >>> 8 * b);
        break;
      } 
      i |= j;
      j >>>= 1;
    } 
    paramDataOutput.write(i);
    while (b > 0) {
      paramDataOutput.write((int)(0xFFL & paramLong));
      paramLong >>>= 8L;
      b--;
    } 
  }
  
  private void a(DataOutput paramDataOutput, BitSet paramBitSet, int paramInt) throws IOException {
    int i = 0;
    byte b1 = 7;
    for (byte b2 = 0; b2 < paramInt; b2++) {
      i |= (paramBitSet.get(b2) ? 1 : 0) << b1;
      if (--b1 < 0) {
        paramDataOutput.write(i);
        b1 = 7;
        i = 0;
      } 
    } 
    if (b1 != 7)
      paramDataOutput.write(i); 
  }
  
  private static <T> Iterable<T> b(Iterable<T> paramIterable) {
    // Byte code:
    //   0: new java/util/LinkedList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 39
    //   24: aload_2
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: astore_3
    //   31: aload_1
    //   32: aload_3
    //   33: invokevirtual addFirst : (Ljava/lang/Object;)V
    //   36: goto -> 15
    //   39: aload_1
    //   40: areturn
  }
  
  private class a extends OutputStream {
    private a(v this$0) {}
    
    public void write(int b) throws IOException {
      v.b(this.a).write(b);
      v.c(this.a).update(b);
      v.d(this.a);
    }
    
    public void write(byte[] b) throws IOException {
      write(b, 0, b.length);
    }
    
    public void write(byte[] b, int off, int len) throws IOException {
      v.b(this.a).write(b, off, len);
      v.c(this.a).update(b, off, len);
      v.a(this.a, len);
    }
    
    public void flush() throws IOException {}
    
    public void close() throws IOException {}
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/v.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */