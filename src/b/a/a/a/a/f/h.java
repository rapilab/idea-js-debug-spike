package b.a.a.a.a.f;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

enum h {
  public void a(s params, r paramr) throws IOException {
    File file1 = new File(paramr.getName());
    if (paramr.isDirectory()) {
      if (!file1.isDirectory() && !file1.mkdirs())
        throw new IOException("Cannot create directory " + file1); 
      System.out.println("created directory " + file1);
      return;
    } 
    System.out.println("extracting to " + file1);
    File file2 = file1.getParentFile();
    if (file2 != null && !file2.exists() && !file2.mkdirs())
      throw new IOException("Cannot create " + file2); 
    FileOutputStream fileOutputStream = new FileOutputStream(file1);
    try {
      long l1 = paramr.getSize();
      long l2 = 0L;
      while (l2 < l1) {
        int i = (int)Math.min(l1 - l2, (f.a()).length);
        int j = params.a(f.a(), 0, i);
        if (j < 1)
          throw new IOException("reached end of entry " + paramr.getName() + " after " + l2 + " bytes, expected " + l1); 
        l2 += j;
        fileOutputStream.write(f.a(), 0, j);
      } 
    } finally {
      fileOutputStream.close();
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/a/f/h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */