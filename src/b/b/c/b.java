package b.b.c;

public class b extends Exception {
  private static final long a = 3731842424390998726L;
  
  private int b;
  
  public b(int paramInt) {
    this.b = paramInt;
  }
  
  public b(int paramInt, String paramString) {
    super(paramString);
    this.b = paramInt;
  }
  
  public b(int paramInt, Throwable paramThrowable) {
    super(paramThrowable);
    this.b = paramInt;
  }
  
  public b(int paramInt, String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
    this.b = paramInt;
  }
  
  public int a() {
    return this.b;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/b/c/b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */