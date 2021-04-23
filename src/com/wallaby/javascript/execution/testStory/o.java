package com.wallaby.javascript.execution.testStory;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.TextRange;
import com.intellij.testFramework.LightVirtualFile;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;

public class o extends LightVirtualFile {
  private TestStory a;
  
  private Integer b;
  
  private boolean c = true;
  
  private boolean d = true;
  
  private boolean e;
  
  public o(TestStory paramTestStory) {
    setFileType((FileType)TestStoryFileType.INSTANCE);
    setLanguage(TestStoryLanguage.INSTANCE);
    this.a = paramTestStory;
    this.a.k();
  }
  
  public CharSequence getContent() {
    return this.a.h();
  }
  
  public TestStory.LineDecorationData a(int paramInt) {
    return this.a.a(paramInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {
    this.a.a(paramInt, paramString, paramBoolean);
  }
  
  public TextRange[] a() {
    return this.a.j();
  }
  
  public String getName() {
    return "Test Story";
  }
  
  public TestStory.OriginalLineData b(int paramInt) {
    return this.a.b(paramInt);
  }
  
  public Integer c(int paramInt) {
    return this.a.c(paramInt);
  }
  
  public boolean b() {
    return this.a.e();
  }
  
  public boolean c() {
    return this.a.f();
  }
  
  public int d() {
    return this.a.a();
  }
  
  public int e() {
    return this.a.b();
  }
  
  public void a(TestStory paramTestStory) {
    this.a = paramTestStory;
    this.a.k();
    this.c = true;
    this.d = true;
    this.e = false;
  }
  
  public int f() {
    return this.a.c();
  }
  
  public TestStory.LexicalRegion[] g() {
    return this.a.i();
  }
  
  public void d(int paramInt) {
    this.b = Integer.valueOf(paramInt);
  }
  
  public Integer h() {
    return this.b;
  }
  
  public void i() {
    this.c = false;
  }
  
  public void j() {
    this.d = false;
  }
  
  public boolean k() {
    return this.c;
  }
  
  public boolean l() {
    return this.e;
  }
  
  public void m() {
    this.e = true;
  }
  
  public TestStory.TestStoryEntry e(int paramInt) {
    return this.a.d(paramInt);
  }
  
  public boolean n() {
    return this.d;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/testStory/o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */