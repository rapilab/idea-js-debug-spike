package com.wallaby.javascript.b;

import com.intellij.openapi.util.io.FileUtilRt;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.nio.file.Path;
import java.nio.file.Paths;

public class a {
  private final VirtualFile a;
  
  private final VirtualFile b;
  
  private final boolean c;
  
  private final boolean d;
  
  private String e;
  
  private String[] f;
  
  public a(VirtualFile paramVirtualFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString) {
    this.e = paramString;
    this.a = paramBoolean2 ? paramVirtualFile.getParent() : paramVirtualFile;
    this.b = paramVirtualFile;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.f = paramArrayOfString;
  }
  
  public VirtualFile a() {
    return this.a;
  }
  
  public VirtualFile b() {
    return this.b;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public boolean d() {
    return this.d;
  }
  
  public String e() {
    return this.e.equals("{SYSTEM DEFAULT}") ? "node" : this.e;
  }
  
  public String[] f() {
    return this.f;
  }
  
  public String a(String paramString) {
    Path path = Paths.get(paramString, new String[0]);
    return path.isAbsolute() ? StringUtil.trimLeading(FileUtilRt.toSystemIndependentName(Paths.get(this.a.getPath(), new String[0]).relativize(path).toString()), '/') : StringUtil.trimLeading(FileUtilRt.toSystemIndependentName(paramString), '/');
  }
  
  public String b(String paramString) {
    String str = FileUtilRt.toSystemIndependentName(this.a.getPath()) + "/" + paramString;
    return FileUtilRt.toSystemDependentName(str);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/b/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */