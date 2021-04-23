package b.a.a.a.a.h;

import b.a.a.a.d.i;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public class G implements Closeable {
  private static final int d = 509;
  
  static final int a = 15;
  
  static final int b = 8;
  
  private static final int e = 0;
  
  private static final int f = 1;
  
  private static final int g = 2;
  
  private static final int h = 3;
  
  private final List<y> i = new LinkedList<y>();
  
  private final Map<String, LinkedList<y>> j = new HashMap<String, LinkedList<y>>(509);
  
  private final String k;
  
  private final D l;
  
  private final String m;
  
  private final RandomAccessFile n;
  
  private final boolean o;
  
  private boolean p;
  
  private final byte[] q = new byte[8];
  
  private final byte[] r = new byte[4];
  
  private final byte[] s = new byte[42];
  
  private final byte[] t = new byte[2];
  
  private static final int u = 42;
  
  private static final long v = J.a(A.l);
  
  static final int c = 22;
  
  private static final int w = 65557;
  
  private static final int x = 16;
  
  private static final int y = 20;
  
  private static final int z = 8;
  
  private static final int A = 48;
  
  private static final long B = 26L;
  
  private final Comparator<y> C = new I(this);
  
  public G(File paramFile) throws IOException {
    this(paramFile, "UTF8");
  }
  
  public G(String paramString) throws IOException {
    this(new File(paramString), "UTF8");
  }
  
  public G(String paramString1, String paramString2) throws IOException {
    this(new File(paramString1), paramString2, true);
  }
  
  public G(File paramFile, String paramString) throws IOException {
    this(paramFile, paramString, true);
  }
  
  public G(File paramFile, String paramString, boolean paramBoolean) throws IOException {
    this.m = paramFile.getAbsolutePath();
    this.k = paramString;
    this.l = E.a(paramString);
    this.o = paramBoolean;
    this.n = new RandomAccessFile(paramFile, "r");
    boolean bool = false;
    try {
      Map<y, c> map = d();
      b(map);
      bool = true;
    } finally {
      if (!bool) {
        this.p = true;
        i.a(this.n);
      } 
    } 
  }
  
  public String a() {
    return this.k;
  }
  
  public void close() throws IOException {
    this.p = true;
    this.n.close();
  }
  
  public static void a(G paramG) {
    i.a(paramG);
  }
  
  public Enumeration<y> b() {
    return Collections.enumeration(this.i);
  }
  
  public Enumeration<y> c() {
    y[] arrayOfY = this.i.<y>toArray(new y[0]);
    Arrays.sort(arrayOfY, this.C);
    return Collections.enumeration(Arrays.asList(arrayOfY));
  }
  
  public y a(String paramString) {
    LinkedList<y> linkedList = this.j.get(paramString);
    return (linkedList != null) ? linkedList.getFirst() : null;
  }
  
  public Iterable<y> b(String paramString) {
    List<y> list = this.j.get(paramString);
    return (list != null) ? list : Collections.<y>emptyList();
  }
  
  public Iterable<y> c(String paramString) {
    y[] arrayOfY = new y[0];
    if (this.j.containsKey(paramString)) {
      arrayOfY = (y[])((LinkedList)this.j.get(paramString)).toArray((Object[])arrayOfY);
      Arrays.sort(arrayOfY, this.C);
    } 
    return Arrays.asList(arrayOfY);
  }
  
  public boolean a(y paramy) {
    return M.a(paramy);
  }
  
  public InputStream b(y paramy) throws IOException, ZipException {
    Inflater inflater;
    if (!(paramy instanceof b))
      return null; 
    d d = ((b)paramy).b();
    M.b(paramy);
    long l = d.a(d);
    a a = new a(this, l, paramy.getCompressedSize());
    switch (null.a[K.a(paramy.getMethod()).ordinal()]) {
      case 1:
        return a;
      case 2:
        return (InputStream)new r(a);
      case 3:
        return new f(paramy.p().e(), paramy.p().f(), new BufferedInputStream(a));
      case 4:
        a.a();
        inflater = new Inflater(true);
        return new H(this, a, inflater, inflater);
    } 
    throw new ZipException("Found unsupported compression method " + paramy.getMethod());
  }
  
  public String c(y paramy) throws IOException {
    if (paramy != null && paramy.g()) {
      InputStream inputStream = null;
      try {
        inputStream = b(paramy);
        byte[] arrayOfByte = i.a(inputStream);
        return this.l.a(arrayOfByte);
      } finally {
        if (inputStream != null)
          inputStream.close(); 
      } 
    } 
    return null;
  }
  
  protected void finalize() throws Throwable {
    try {
      if (!this.p) {
        System.err.println("Cleaning up unclosed ZipFile for archive " + this.m);
        close();
      } 
    } finally {
      super.finalize();
    } 
  }
  
  private Map<y, c> d() throws IOException {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    e();
    this.n.readFully(this.r);
    long l = J.a(this.r);
    if (l != v && i())
      throw new IOException("central directory is empty, can't expand corrupt archive."); 
    while (l == v) {
      a((Map)hashMap);
      this.n.readFully(this.r);
      l = J.a(this.r);
    } 
    return (Map)hashMap;
  }
  
  private void a(Map<y, c> paramMap) throws IOException {
    this.n.readFully(this.s);
    boolean bool = false;
    d d = new d(null);
    b b = new b(d);
    int i = L.a(this.s, bool);
    bool += true;
    b.c(i >> 8 & 0xF);
    bool += true;
    i i1 = i.a(this.s, bool);
    boolean bool1 = i1.a();
    D d1 = bool1 ? E.b : this.l;
    b.a(i1);
    bool += true;
    b.setMethod(L.a(this.s, bool));
    bool += true;
    long l = M.c(J.a(this.s, bool));
    b.setTime(l);
    bool += true;
    b.setCrc(J.a(this.s, bool));
    bool += true;
    b.setCompressedSize(J.a(this.s, bool));
    bool += true;
    b.setSize(J.a(this.s, bool));
    bool += true;
    int j = L.a(this.s, bool);
    bool += true;
    int k = L.a(this.s, bool);
    bool += true;
    int m = L.a(this.s, bool);
    bool += true;
    int n = L.a(this.s, bool);
    bool += true;
    b.a(L.a(this.s, bool));
    bool += true;
    b.a(J.a(this.s, bool));
    bool += true;
    byte[] arrayOfByte1 = new byte[j];
    this.n.readFully(arrayOfByte1);
    b.a(d1.a(arrayOfByte1), arrayOfByte1);
    d.a(d, J.a(this.s, bool));
    this.i.add(b);
    byte[] arrayOfByte2 = new byte[k];
    this.n.readFully(arrayOfByte2);
    b.a(arrayOfByte2);
    a(b, d, n);
    byte[] arrayOfByte3 = new byte[m];
    this.n.readFully(arrayOfByte3);
    b.setComment(d1.a(arrayOfByte3));
    if (!bool1 && this.o)
      paramMap.put(b, new c(arrayOfByte1, arrayOfByte3, null)); 
  }
  
  private void a(y paramy, d paramd, int paramInt) throws IOException {
    v v = (v)paramy.b(v.a);
    if (v != null) {
      boolean bool1 = (paramy.getSize() == 4294967295L) ? true : false;
      boolean bool2 = (paramy.getCompressedSize() == 4294967295L) ? true : false;
      boolean bool3 = (d.b(paramd) == 4294967295L) ? true : false;
      v.a(bool1, bool2, bool3, (paramInt == 65535));
      if (bool1) {
        paramy.setSize(v.b().b());
      } else if (bool2) {
        v.a(new C(paramy.getSize()));
      } 
      if (bool2) {
        paramy.setCompressedSize(v.g().b());
      } else if (bool1) {
        v.b(new C(paramy.getCompressedSize()));
      } 
      if (bool3)
        d.a(paramd, v.h().b()); 
    } 
  }
  
  private void e() throws IOException {
    h();
    boolean bool = false;
    boolean bool1 = (this.n.getFilePointer() > 20L) ? true : false;
    if (bool1) {
      this.n.seek(this.n.getFilePointer() - 20L);
      this.n.readFully(this.r);
      bool = Arrays.equals(A.o, this.r);
    } 
    if (!bool) {
      if (bool1)
        a(16); 
      g();
    } else {
      f();
    } 
  }
  
  private void f() throws IOException {
    a(4);
    this.n.readFully(this.q);
    this.n.seek(C.a(this.q));
    this.n.readFully(this.r);
    if (!Arrays.equals(this.r, A.n))
      throw new ZipException("archive's ZIP64 end of central directory locator is corrupt."); 
    a(44);
    this.n.readFully(this.q);
    this.n.seek(C.a(this.q));
  }
  
  private void g() throws IOException {
    a(16);
    this.n.readFully(this.r);
    this.n.seek(J.a(this.r));
  }
  
  private void h() throws IOException {
    boolean bool = a(22L, 65557L, A.m);
    if (!bool)
      throw new ZipException("archive is not a ZIP archive"); 
  }
  
  private boolean a(long paramLong1, long paramLong2, byte[] paramArrayOfbyte) throws IOException {
    boolean bool = false;
    long l1 = this.n.length() - paramLong1;
    long l2 = Math.max(0L, this.n.length() - paramLong2);
    if (l1 >= 0L)
      while (l1 >= l2) {
        this.n.seek(l1);
        int i = this.n.read();
        if (i == -1)
          break; 
        if (i == paramArrayOfbyte[0]) {
          i = this.n.read();
          if (i == paramArrayOfbyte[1]) {
            i = this.n.read();
            if (i == paramArrayOfbyte[2]) {
              i = this.n.read();
              if (i == paramArrayOfbyte[3]) {
                bool = true;
                break;
              } 
            } 
          } 
        } 
        l1--;
      }  
    if (bool)
      this.n.seek(l1); 
    return bool;
  }
  
  private void a(int paramInt) throws IOException {
    for (int i = 0; i < paramInt; i += j) {
      int j = this.n.skipBytes(paramInt - i);
      if (j <= 0)
        throw new EOFException(); 
    } 
  }
  
  private void b(Map<y, c> paramMap) throws IOException {
    for (y y : this.i) {
      b b = (b)y;
      d d = b.b();
      long l = d.b(d);
      this.n.seek(l + 26L);
      this.n.readFully(this.t);
      int i = L.a(this.t);
      this.n.readFully(this.t);
      int j = L.a(this.t);
      int k;
      for (k = i; k > 0; k -= m) {
        int m = this.n.skipBytes(k);
        if (m <= 0)
          throw new IOException("failed to skip file name in local file header"); 
      } 
      byte[] arrayOfByte = new byte[j];
      this.n.readFully(arrayOfByte);
      b.setExtra(arrayOfByte);
      d.b(d, l + 26L + 2L + 2L + i + j);
      if (paramMap.containsKey(b)) {
        c c = paramMap.get(b);
        M.a(b, c.a(c), c.b(c));
      } 
      String str = b.getName();
      LinkedList<y> linkedList = this.j.get(str);
      if (linkedList == null) {
        linkedList = new LinkedList();
        this.j.put(str, linkedList);
      } 
      linkedList.addLast(b);
    } 
  }
  
  private boolean i() throws IOException {
    this.n.seek(0L);
    this.n.readFully(this.r);
    return Arrays.equals(this.r, A.j);
  }
  
  private static class b extends y {
    private final G.d d;
    
    b(G.d param1d) {
      this.d = param1d;
    }
    
    G.d b() {
      return this.d;
    }
    
    public int hashCode() {
      return 3 * super.hashCode() + (int)(G.d.b(this.d) % 2147483647L);
    }
    
    public boolean equals(Object other) {
      if (super.equals(other)) {
        b b1 = (b)other;
        return (G.d.b(this.d) == G.d.b(b1.d) && G.d.a(this.d) == G.d.a(b1.d));
      } 
      return false;
    }
  }
  
  private static final class c {
    private final byte[] a;
    
    private final byte[] b;
    
    private c(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      this.a = param1ArrayOfbyte1;
      this.b = param1ArrayOfbyte2;
    }
  }
  
  private class a extends InputStream {
    private long b;
    
    private long c;
    
    private boolean d = false;
    
    a(G this$0, long param1Long1, long param1Long2) {
      this.b = param1Long2;
      this.c = param1Long1;
    }
    
    public int read() throws IOException {
      if (this.b-- <= 0L) {
        if (this.d) {
          this.d = false;
          return 0;
        } 
        return -1;
      } 
      synchronized (G.b(this.a)) {
        G.b(this.a).seek(this.c++);
        return G.b(this.a).read();
      } 
    }
    
    public int read(byte[] b, int off, int len) throws IOException {
      if (this.b <= 0L) {
        if (this.d) {
          this.d = false;
          b[off] = 0;
          return 1;
        } 
        return -1;
      } 
      if (len <= 0)
        return 0; 
      if (len > this.b)
        len = (int)this.b; 
      int i = -1;
      synchronized (G.b(this.a)) {
        G.b(this.a).seek(this.c);
        i = G.b(this.a).read(b, off, len);
      } 
      if (i > 0) {
        this.c += i;
        this.b -= i;
      } 
      return i;
    }
    
    void a() {
      this.d = true;
    }
  }
  
  private static final class d {
    private long a = -1L;
    
    private long b = -1L;
    
    private d() {}
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/h/G.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */