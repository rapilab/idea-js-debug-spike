package b.a.a.a.c.e;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

public class h {
  public static void a(File paramFile) throws IOException {
    a(paramFile, paramFile, null);
  }
  
  public static void a(File paramFile, Map<String, String> paramMap) throws IOException {
    a(paramFile, paramFile, paramMap);
  }
  
  public static void a(File paramFile1, File paramFile2) throws IOException {
    a(paramFile1, paramFile2, null);
  }
  
  public static void a(File paramFile1, File paramFile2, Map<String, String> paramMap) throws IOException {
    if (paramMap == null)
      paramMap = new HashMap<String, String>(); 
    paramMap.put("pack.segment.limit", "-1");
    File file = File.createTempFile("commons-compress", "pack200normalize");
    file.deleteOnExit();
    try {
      JarOutputStream jarOutputStream;
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      JarFile jarFile = null;
      try {
        Pack200.Packer packer = Pack200.newPacker();
        packer.properties().putAll(paramMap);
        packer.pack(jarFile = new JarFile(paramFile1), fileOutputStream);
        jarFile = null;
        fileOutputStream.close();
        fileOutputStream = null;
        Pack200.Unpacker unpacker = Pack200.newUnpacker();
        jarOutputStream = new JarOutputStream(new FileOutputStream(paramFile2));
        unpacker.unpack(file, jarOutputStream);
      } finally {
        if (jarFile != null)
          jarFile.close(); 
        if (jarOutputStream != null)
          jarOutputStream.close(); 
      } 
    } finally {
      file.delete();
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/b/a/a/a/c/e/h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */