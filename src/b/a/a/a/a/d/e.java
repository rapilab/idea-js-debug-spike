package b.a.a.a.a.d;

import b.a.a.a.a.a;
import b.a.a.a.a.b;
import b.a.a.a.a.c;
import b.a.a.a.a.h.D;
import b.a.a.a.a.h.E;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class e extends c {
  private g b;
  
  private c c;
  
  private boolean d;
  
  private boolean e;
  
  private long f;
  
  private long g;
  
  private int h;
  
  private final byte[] i = new byte[1024];
  
  private byte[] j;
  
  private int k;
  
  private long l;
  
  protected k a;
  
  private final Map<Integer, a> m = new HashMap<Integer, a>();
  
  private final Map<Integer, c> n = new HashMap<Integer, c>();
  
  private Queue<c> o;
  
  private final D p;
  
  public e(InputStream paramInputStream) throws b {
    this(paramInputStream, null);
  }
  
  public e(InputStream paramInputStream, String paramString) throws b {
    this.a = new k(paramInputStream);
    this.e = false;
    this.p = E.a(paramString);
    try {
      byte[] arrayOfByte = this.a.b();
      if (!h.b(arrayOfByte))
        throw new l(); 
      this.b = new g(arrayOfByte, this.p);
      this.a.a(this.b.k(), this.b.n());
      this.j = new byte[4096];
      g();
      h();
    } catch (IOException iOException) {
      throw new b(iOException.getMessage(), iOException);
    } 
    a a = new a(2, 2, 4, ".");
    this.m.put(Integer.valueOf(2), a);
    this.o = new PriorityQueue<c>(10, new f(this));
  }
  
  public int b() {
    return (int)c();
  }
  
  public long c() {
    return this.a.c();
  }
  
  public g d() {
    return this.b;
  }
  
  private void g() throws IOException {
    byte[] arrayOfByte = this.a.b();
    if (!h.b(arrayOfByte))
      throw new i(); 
    this.c = c.a(arrayOfByte);
    if (b.b.f != this.c.j())
      throw new i(); 
    if (this.a.skip((1024 * this.c.k())) == -1L)
      throw new EOFException(); 
    this.h = this.c.k();
  }
  
  private void h() throws IOException {
    byte[] arrayOfByte = this.a.b();
    if (!h.b(arrayOfByte))
      throw new i(); 
    this.c = c.a(arrayOfByte);
    if (b.b.c != this.c.j())
      throw new i(); 
    if (this.a.skip((1024 * this.c.k())) == -1L)
      throw new EOFException(); 
    this.h = this.c.k();
  }
  
  public c e() throws IOException {
    return f();
  }
  
  public c f() throws IOException {
    c c1 = null;
    String str = null;
    if (!this.o.isEmpty())
      return this.o.remove(); 
    while (c1 == null) {
      if (this.e)
        return null; 
      while (this.h < this.c.k()) {
        if (!this.c.d(this.h++) && this.a.skip(1024L) == -1L)
          throw new EOFException(); 
      } 
      this.h = 0;
      this.l = this.a.c();
      byte[] arrayOfByte = this.a.b();
      if (!h.b(arrayOfByte))
        throw new i(); 
      this.c = c.a(arrayOfByte);
      while (b.b.d == this.c.j()) {
        if (this.a.skip((1024 * (this.c.k() - this.c.l()))) == -1L)
          throw new EOFException(); 
        this.l = this.a.c();
        arrayOfByte = this.a.b();
        if (!h.b(arrayOfByte))
          throw new i(); 
        this.c = c.a(arrayOfByte);
      } 
      if (b.b.e == this.c.j()) {
        this.e = true;
        return null;
      } 
      c1 = this.c;
      if (c1.isDirectory()) {
        a(this.c);
        this.g = 0L;
        this.f = 0L;
        this.h = this.c.k();
      } else {
        this.g = 0L;
        this.f = this.c.v();
        this.h = 0;
      } 
      this.k = this.i.length;
      str = b(c1);
      if (str == null)
        c1 = null; 
    } 
    c1.b(str);
    c1.a(((a)this.m.get(Integer.valueOf(c1.c()))).d());
    c1.a(this.l);
    return c1;
  }
  
  private void a(c paramc) throws IOException {
    long l = paramc.v();
    boolean bool = true;
    while (bool || b.b.d == paramc.j()) {
      if (!bool)
        this.a.b(); 
      if (!this.m.containsKey(Integer.valueOf(paramc.c())) && b.b.b == paramc.j())
        this.n.put(Integer.valueOf(paramc.c()), paramc); 
      int i = 1024 * paramc.k();
      if (this.j.length < i)
        this.j = new byte[i]; 
      if (this.a.read(this.j, 0, i) != i)
        throw new EOFException(); 
      int j = 0;
      int m;
      for (m = 0; m < i - 8 && m < l - 8L; m += j) {
        int n = h.b(this.j, m);
        j = h.c(this.j, m + 4);
        byte b = this.j[m + 6];
        String str = h.a(this.p, this.j, m + 8, this.j[m + 7]);
        if (!".".equals(str) && !"..".equals(str)) {
          a a = new a(n, paramc.c(), b, str);
          this.m.put(Integer.valueOf(n), a);
          for (Map.Entry<Integer, c> entry : this.n.entrySet()) {
            String str1 = b((c)entry.getValue());
            if (str1 != null) {
              ((c)entry.getValue()).b(str1);
              ((c)entry.getValue()).a(((a)this.m.get(entry.getKey())).d());
              this.o.add((c)entry.getValue());
            } 
          } 
          for (c c1 : this.o)
            this.n.remove(Integer.valueOf(c1.c())); 
        } 
      } 
      byte[] arrayOfByte = this.a.a();
      if (!h.b(arrayOfByte))
        throw new i(); 
      paramc = c.a(arrayOfByte);
      bool = false;
      l -= 1024L;
    } 
  }
  
  private String b(c paramc) {
    Stack<String> stack = new Stack();
    a a = null;
    int i;
    for (i = paramc.c();; i = a.b()) {
      if (!this.m.containsKey(Integer.valueOf(i))) {
        stack.clear();
        break;
      } 
      a = this.m.get(Integer.valueOf(i));
      stack.push(a.d());
      if (a.a() == a.b())
        break; 
    } 
    if (stack.isEmpty()) {
      this.n.put(Integer.valueOf(paramc.c()), paramc);
      return null;
    } 
    StringBuilder stringBuilder = new StringBuilder(stack.pop());
    while (!stack.isEmpty()) {
      stringBuilder.append('/');
      stringBuilder.append(stack.pop());
    } 
    return stringBuilder.toString();
  }
  
  public int read(byte[] buf, int off, int len) throws IOException {
    int i = 0;
    if (this.e || this.d || this.g >= this.f)
      return -1; 
    if (this.c == null)
      throw new IllegalStateException("No current dump entry"); 
    if (len + this.g > this.f)
      len = (int)(this.f - this.g); 
    while (len > 0) {
      int j = (len > this.i.length - this.k) ? (this.i.length - this.k) : len;
      if (this.k + j <= this.i.length) {
        System.arraycopy(this.i, this.k, buf, off, j);
        i += j;
        this.k += j;
        len -= j;
        off += j;
      } 
      if (len > 0) {
        if (this.h >= 512) {
          byte[] arrayOfByte = this.a.b();
          if (!h.b(arrayOfByte))
            throw new i(); 
          this.c = c.a(arrayOfByte);
          this.h = 0;
        } 
        if (!this.c.d(this.h++)) {
          int m = this.a.read(this.i, 0, this.i.length);
          if (m != this.i.length)
            throw new EOFException(); 
        } else {
          Arrays.fill(this.i, (byte)0);
        } 
        this.k = 0;
      } 
    } 
    this.g += i;
    return i;
  }
  
  public void close() throws IOException {
    if (!this.d) {
      this.d = true;
      this.a.close();
    } 
  }
  
  public static boolean a(byte[] paramArrayOfbyte, int paramInt) {
    return (paramInt < 32) ? false : ((paramInt >= 1024) ? h.b(paramArrayOfbyte) : ((60012 == h.b(paramArrayOfbyte, 24))));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/d/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */