package com.wallaby.javascript.c;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.NullableFunction;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class f {
  private static final Logger a = Logger.getInstance(f.class);
  
  public static void a(Project paramProject, String paramString, File paramFile1, File paramFile2, boolean paramBoolean) throws d {
    a(paramProject, paramString, paramFile1, paramFile2, (NullableFunction<? super String, String>)null, paramBoolean);
  }
  
  public static void a(Project paramProject, String paramString, File paramFile1, File paramFile2, NullableFunction<? super String, String> paramNullableFunction, boolean paramBoolean) throws d {
    e<?> e = b.a(paramProject, paramString, "Unpacking ...", () -> {
          ProgressIndicator progressIndicator = ProgressManager.getInstance().getProgressIndicator();
          a(progressIndicator, paramFile1, paramFile2, paramNullableFunction, (a)null, paramBoolean);
          return Boolean.valueOf(true);
        }() -> Boolean.valueOf(false));
    Boolean bool = (Boolean)e.a();
    if (bool == null) {
      Exception exception = e.b();
      if (exception != null)
        throw new d("Unpacking failed, downloaded archive is broken"); 
      throw new d("Unpacking was cancelled");
    } 
  }
  
  private static File a(ProgressIndicator paramProgressIndicator, File paramFile, boolean paramBoolean) throws IOException {
    if (paramProgressIndicator != null)
      paramProgressIndicator.setText("Extracting..."); 
    return paramBoolean ? FileUtil.createTempDirectory("unzip-dir-", null) : paramFile;
  }
  
  public static void a(ProgressIndicator paramProgressIndicator, File paramFile1, File paramFile2, NullableFunction<? super String, String> paramNullableFunction, a parama, boolean paramBoolean) throws IOException {
    File file = a(paramProgressIndicator, paramFile1, paramBoolean);
    try (ZipFile null = new ZipFile(paramFile2, 1)) {
      Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
      while (enumeration.hasMoreElements()) {
        ZipEntry zipEntry = enumeration.nextElement();
        try (InputStream null = zipFile.getInputStream(zipEntry)) {
          a(paramProgressIndicator, zipEntry, inputStream, file, paramNullableFunction, parama);
        } 
      } 
    } 
    a(paramBoolean, file, paramFile1);
  }
  
  private static void a(boolean paramBoolean, File paramFile1, File paramFile2) throws IOException {
    if (paramBoolean) {
      File file;
      File[] arrayOfFile = paramFile1.listFiles();
      if (arrayOfFile != null && arrayOfFile.length == 1 && arrayOfFile[0].isDirectory()) {
        file = arrayOfFile[0];
      } else {
        file = paramFile1;
      } 
      FileUtil.copyDirContent(file, paramFile2);
      FileUtil.delete(paramFile1);
    } 
  }
  
  private static void a(ProgressIndicator paramProgressIndicator, ZipEntry paramZipEntry, InputStream paramInputStream, File paramFile, NullableFunction<? super String, String> paramNullableFunction, a parama) throws IOException {
    String str = a(paramZipEntry);
    if (paramNullableFunction != null) {
      str = (String)paramNullableFunction.fun(str);
      if (str == null)
        return; 
    } 
    File file1 = a.a(paramFile, str);
    File file2 = paramZipEntry.isDirectory() ? file1 : file1.getParentFile();
    if (!file2.exists() && !file2.mkdirs())
      throw new IOException("Unable to create dir: '" + file2 + "'!"); 
    if (paramZipEntry.isDirectory())
      return; 
    if (paramProgressIndicator != null)
      paramProgressIndicator.setText("Extracting " + str + " ..."); 
    if (parama == null) {
      try (FileOutputStream null = new FileOutputStream(file1)) {
        FileUtil.copy(paramInputStream, fileOutputStream);
      } 
    } else {
      byte[] arrayOfByte = parama.a(FileUtil.loadBytes(paramInputStream), file1);
      if (arrayOfByte != null)
        FileUtil.writeToFile(file1, arrayOfByte); 
    } 
    a.info("Extract: " + str);
  }
  
  private static String a(ZipEntry paramZipEntry) {
    String str = StringUtil.trimStart(paramZipEntry.getName(), "/");
    return StringUtil.trimEnd(str, "/");
  }
  
  public static interface a {
    byte[] a(byte[] param1ArrayOfbyte, File param1File) throws IOException;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/c/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */