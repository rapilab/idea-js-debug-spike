package b.b.f;

class d implements Thread.UncaughtExceptionHandler {
  d(c.b paramb, c paramc) {}
  
  public void uncaughtException(Thread t, Throwable e) {
    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/f/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */