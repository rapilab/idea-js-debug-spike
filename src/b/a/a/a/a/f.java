package b.a.a.a.a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public final class f {
  private static final e a = new e();
  
  public static void a(String[] paramArrayOfString) throws Exception {
    c c;
    if (paramArrayOfString.length == 0) {
      a();
      return;
    } 
    System.out.println("Analysing " + paramArrayOfString[0]);
    File file = new File(paramArrayOfString[0]);
    if (!file.isFile())
      System.err.println(file + " doesn't exist or is a directory"); 
    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
    if (paramArrayOfString.length > 1) {
      c = a.a(paramArrayOfString[1], bufferedInputStream);
    } else {
      c = a.a(bufferedInputStream);
    } 
    System.out.println("Created " + c.toString());
    a a;
    while ((a = c.a()) != null)
      System.out.println(a.getName()); 
    c.close();
    bufferedInputStream.close();
  }
  
  private static void a() {
    System.out.println("Parameters: archive-name [archive-type]");
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */