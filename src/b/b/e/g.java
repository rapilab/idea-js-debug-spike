package b.b.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
  private byte[] a;
  
  private TreeMap<String, String> b = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
  
  public Iterator<String> c() {
    return Collections.<String>unmodifiableSet(this.b.keySet()).iterator();
  }
  
  public String b(String paramString) {
    String str = this.b.get(paramString);
    return (str == null) ? "" : str;
  }
  
  public byte[] d() {
    return this.a;
  }
  
  public void a(byte[] paramArrayOfbyte) {
    this.a = paramArrayOfbyte;
  }
  
  public void a(String paramString1, String paramString2) {
    this.b.put(paramString1, paramString2);
  }
  
  public boolean c(String paramString) {
    return this.b.containsKey(paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/e/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */