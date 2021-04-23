package com.wallaby.javascript.c;

public class e<V> {
  private final V a;
  
  private final Exception b;
  
  private e(V paramV, Exception paramException) {
    this.a = paramV;
    this.b = paramException;
  }
  
  public V a() {
    return this.a;
  }
  
  public Exception b() {
    return this.b;
  }
  
  public static <V> e<V> c() {
    return new e<>(null, null);
  }
  
  public static <V> e<V> a(Exception paramException) {
    return new e<>(null, paramException);
  }
  
  public static <V> e<V> a(V paramV) {
    return new e<>(paramV, null);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/c/e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */