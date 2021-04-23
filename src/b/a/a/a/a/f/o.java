package b.a.a.a.a.f;

import java.util.LinkedList;

class o {
  i[] a;
  
  long b;
  
  long c;
  
  d[] d;
  
  long[] e;
  
  long[] f;
  
  boolean g;
  
  long h;
  
  int i;
  
  Iterable<i> a() {
    LinkedList<i> linkedList = new LinkedList();
    for (int j = (int)this.e[0]; j != -1; j = (k != -1) ? (int)(this.d[k]).a : -1) {
      linkedList.addLast(this.a[j]);
      int k = b(j);
    } 
    return linkedList;
  }
  
  int a(int paramInt) {
    for (byte b = 0; b < this.d.length; b++) {
      if ((this.d[b]).a == paramInt)
        return b; 
    } 
    return -1;
  }
  
  int b(int paramInt) {
    for (byte b = 0; b < this.d.length; b++) {
      if ((this.d[b]).b == paramInt)
        return b; 
    } 
    return -1;
  }
  
  long b() {
    if (this.c == 0L)
      return 0L; 
    for (int j = (int)this.c - 1; j >= 0; j--) {
      if (b(j) < 0)
        return this.f[j]; 
    } 
    return 0L;
  }
  
  long a(i parami) {
    if (this.a != null)
      for (byte b = 0; b < this.a.length; b++) {
        if (this.a[b] == parami)
          return this.f[b]; 
      }  
    return 0L;
  }
  
  public String toString() {
    return "Folder with " + this.a.length + " coders, " + this.b + " input streams, " + this.c + " output streams, " + this.d.length + " bind pairs, " + this.e.length + " packed streams, " + this.f.length + " unpack sizes, " + (this.g ? ("with CRC " + this.h) : "without CRC") + " and " + this.i + " unpack streams";
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/o.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */