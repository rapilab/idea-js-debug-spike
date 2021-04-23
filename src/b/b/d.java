package b.b;

import b.b.b.a;
import b.b.d.d;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;

public interface d {
  public static final int e = 80;
  
  public static final int f = 443;
  
  void a(int paramInt, String paramString);
  
  void a(int paramInt);
  
  void a();
  
  void b(int paramInt, String paramString);
  
  void b(String paramString) throws NotYetConnectedException;
  
  void a(ByteBuffer paramByteBuffer) throws IllegalArgumentException, NotYetConnectedException;
  
  void a(byte[] paramArrayOfbyte) throws IllegalArgumentException, NotYetConnectedException;
  
  void a(d paramd);
  
  void a(d.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  boolean b();
  
  InetSocketAddress c();
  
  InetSocketAddress d();
  
  boolean e();
  
  boolean f();
  
  boolean g();
  
  boolean h();
  
  boolean i();
  
  a j();
  
  a k();
  
  String l();
  
  public enum a {
    a, b, c, d, e;
    
    public static a[] a() {
      return (a[])f.clone();
    }
    
    public static a a(String param1String) {
      return Enum.<a>valueOf(a.class, param1String);
    }
  }
  
  public enum b {
    a, b;
    
    public static b[] a() {
      return (b[])c.clone();
    }
    
    public static b a(String param1String) {
      return Enum.<b>valueOf(b.class, param1String);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */