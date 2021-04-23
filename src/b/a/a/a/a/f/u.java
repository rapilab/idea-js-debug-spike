package b.a.a.a.a.f;

public class u {
  private final t a;
  
  private final Object b;
  
  public u(t paramt) {
    this(paramt, null);
  }
  
  public u(t paramt, Object paramObject) {
    this.a = paramt;
    this.b = paramObject;
    if (paramObject != null && !k.a(paramt).a(paramObject))
      throw new IllegalArgumentException("The " + paramt + " method doesn't support options of type " + paramObject.getClass()); 
  }
  
  public t a() {
    return this.a;
  }
  
  public Object b() {
    return this.b;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/u.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */