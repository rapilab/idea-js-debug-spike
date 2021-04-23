package b.b;

import b.b.b.a;
import b.b.c.b;
import b.b.c.d;
import b.b.d.d;
import b.b.d.e;
import b.b.e.a;
import b.b.e.e;
import b.b.e.h;
import b.b.e.i;
import java.net.InetSocketAddress;

public abstract class e implements h {
  public i a(d paramd, a parama, a parama1) throws b {
    return (i)new e();
  }
  
  public void a(d paramd, a parama, h paramh) throws b {}
  
  public void a(d paramd, a parama) throws b {}
  
  public void a(d paramd, d paramd1) {}
  
  public void b(d paramd, d paramd1) {
    e e1 = new e(paramd1);
    e1.a(d.a.e);
    paramd.a((d)e1);
  }
  
  public void c(d paramd, d paramd1) {}
  
  public String a(d paramd) throws b {
    InetSocketAddress inetSocketAddress = paramd.d();
    if (null == inetSocketAddress)
      throw new d("socket not bound"); 
    StringBuffer stringBuffer = new StringBuffer(90);
    stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    stringBuffer.append(inetSocketAddress.getPort());
    stringBuffer.append("\" /></cross-domain-policy>\000");
    return stringBuffer.toString();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */