package com.wallaby.javascript;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.Base64;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class g {
  private String a;
  
  private boolean b;
  
  private boolean c;
  
  private String d;
  
  private Date e;
  
  private boolean f;
  
  private final boolean g;
  
  private g(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, Date paramDate, boolean paramBoolean3, boolean paramBoolean4) {
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString2;
    this.e = paramDate;
    this.f = paramBoolean3;
    this.g = paramBoolean4;
  }
  
  public static g a() {
    return new g("", false, false, null, null, false, false);
  }
  
  public static g a(String paramString) {
    return new g(paramString, false, false, null, null, false, true);
  }
  
  public static g a(String paramString1, String paramString2, Date paramDate) {
    return new g(paramString1, true, true, paramString2, paramDate, false, false);
  }
  
  public static g a(String paramString1, String paramString2, Date paramDate, String paramString3) {
    long l = TimeUnit.DAYS.convert(paramDate.getTime() - (new Date()).getTime(), TimeUnit.MILLISECONDS);
    String str = (l == 0L) ? "today" : ((l == 1L) ? "tomorrow" : ("in " + l + " days"));
    return new g(paramString1, true, false, paramString2, paramDate, paramString3.startsWith("Wallaby.js + Quokka.js"), false);
  }
  
  public static g b(String paramString1, String paramString2, Date paramDate, String paramString3) {
    return new g(paramString1, true, false, paramString2, paramDate, paramString3.startsWith("Wallaby.js + Quokka.js"), false);
  }
  
  boolean b() {
    return this.g;
  }
  
  boolean c() {
    boolean bool = true;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
      bool = (Base64.encode(messageDigest.digest(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmquk0Iu5UP2kASDwGjNDCkkuneWReQxxSGWPx28q+5MWEXnigj5kGLI140zavsGhOIPVDObB7p5ru17gd8L6xZgBuapy2B2z5PnBbAGOqZBDwUASCibYtJ6N4wrLyUlCE3JaRlMDu+4VY/ybtzPCxMWzdSzkoHpImD4nnM+FLJO7gUCqAy0JdFyT9L7OwflZZaMvhonbK4jEHDolK7l2EBSPxZOxj5w5VBbnlqZA8e+tKmBIUTtrnhkzmsKFLqVSuzJwi28+veK/AzOW/F1UQRxsSu886j4IVz3Qdsx3tlD1s+xZuZpGZt4+pmne0Ons0KhQ0PL5gx6ZmogWq9drmwIDAQAB"))).equals("p0u8OKD4WhC0g1lcf81tZ5K1p4pjcWeeVP37uJ3a5p3jN68ZKLvftscsmzzLzgzSYe9fo/uC3oHwPLxWleVMAw==") && Base64.encode(messageDigest.digest(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4pDotejtzhiT/lpNfd0H2Dv08NTSJ8/ixuQz3iJiVRxQkot5Sn45wu4QiQEoY5NQ/tDf8V9mDeePNU/Zd8KYdyRFoq6bwOlHc0HAa50tecRCECESB+t3TVcqLMogX32vgQkSmly0sFxtGFBjN8WxV+Q7WQ8neft7JKaXtm+2Ft7P41ond+SfBeToh9mn9DFft+OuI2vz7s0OSjd+P2bw+GEIr3otl3CA5RrIH9WRsAVjawv+z5LvakQXtO6JNNmJgErHWZmkBIlv2VHDsoSdMLga2jTiEHrkZylKPFoz/hOdh/iVH4/r1AWxBhj8IgQlRcLJgvSBzJo4OlBhlYh6xwIDAQAB"))).equals("fWWvyHVRrj83IRQijTKT/xemrRJAZhpSedf2OgwOLc6sT4YHqnbSuK/vQkh5tHPBrEwkffZKMMjioPn+OJU6rg==")) ? true : false;
    } catch (Exception exception) {}
    return (this.b && bool);
  }
  
  boolean d() {
    return (c() && f());
  }
  
  boolean e() {
    return (c() && !f());
  }
  
  boolean f() {
    return this.c;
  }
  
  boolean g() {
    return this.f;
  }
  
  String h() {
    return StringUtil.notNullize(this.d);
  }
  
  String i() {
    if (this.e == null)
      return ""; 
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM d, yyyy");
    return simpleDateFormat.format(this.e);
  }
  
  String j() {
    if (this.e == null)
      return ""; 
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    return simpleDateFormat.format(this.e);
  }
  
  public String k() {
    return this.a;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */