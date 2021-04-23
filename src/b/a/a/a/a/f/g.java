package b.a.a.a.a.f;

enum g {
  public void a(s params, r paramr) {
    System.out.print(paramr.getName());
    if (paramr.isDirectory()) {
      System.out.print(" dir");
    } else {
      System.out.print(" " + paramr.p() + "/" + paramr.getSize());
    } 
    if (paramr.f()) {
      System.out.print(" " + paramr.a());
    } else {
      System.out.print(" no last modified date");
    } 
    if (!paramr.isDirectory()) {
      System.out.println(" " + a(paramr));
    } else {
      System.out.println("");
    } 
  }
  
  private String a(r paramr) {
    StringBuilder stringBuilder = new StringBuilder();
    boolean bool = true;
    for (u u : paramr.q()) {
      if (!bool)
        stringBuilder.append(", "); 
      bool = false;
      stringBuilder.append(u.a());
      if (u.b() != null)
        stringBuilder.append("(" + u.b() + ")"); 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */