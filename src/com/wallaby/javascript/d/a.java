package com.wallaby.javascript.d;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.io.FileUtilRt;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.Base64;
import com.intellij.util.SystemProperties;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.g;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class a {
  private static final String d = "wallabyjs@gmail.com";
  
  private static final String e = "Freedom";
  
  public static final String a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmquk0Iu5UP2kASDwGjNDCkkuneWReQxxSGWPx28q+5MWEXnigj5kGLI140zavsGhOIPVDObB7p5ru17gd8L6xZgBuapy2B2z5PnBbAGOqZBDwUASCibYtJ6N4wrLyUlCE3JaRlMDu+4VY/ybtzPCxMWzdSzkoHpImD4nnM+FLJO7gUCqAy0JdFyT9L7OwflZZaMvhonbK4jEHDolK7l2EBSPxZOxj5w5VBbnlqZA8e+tKmBIUTtrnhkzmsKFLqVSuzJwi28+veK/AzOW/F1UQRxsSu886j4IVz3Qdsx3tlD1s+xZuZpGZt4+pmne0Ons0KhQ0PL5gx6ZmogWq9drmwIDAQAB";
  
  public static final String b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4pDotejtzhiT/lpNfd0H2Dv08NTSJ8/ixuQz3iJiVRxQkot5Sn45wu4QiQEoY5NQ/tDf8V9mDeePNU/Zd8KYdyRFoq6bwOlHc0HAa50tecRCECESB+t3TVcqLMogX32vgQkSmly0sFxtGFBjN8WxV+Q7WQ8neft7JKaXtm+2Ft7P41ond+SfBeToh9mn9DFft+OuI2vz7s0OSjd+P2bw+GEIr3otl3CA5RrIH9WRsAVjawv+z5LvakQXtO6JNNmJgErHWZmkBIlv2VHDsoSdMLga2jTiEHrkZylKPFoz/hOdh/iVH4/r1AWxBhj8IgQlRcLJgvSBzJo4OlBhlYh6xwIDAQAB";
  
  private static File f = new File(SystemProperties.getUserHome() + File.separator + ".wallaby");
  
  public static File c = new File(f + File.separator + "key.lic");
  
  private static final File g = new File(PathManager.getPluginsPath() + File.separator + "wallaby.lic");
  
  private static final File h = new File((new File(PathManager.getSystemPath() + File.separator + "wallaby")).getAbsolutePath() + File.separator + "key.lic");
  
  private static boolean i;
  
  private static Date j;
  
  public a() {
    i = true;
  }
  
  public static void a() {
    i = false;
  }
  
  public static void a(Date paramDate) {
    j = paramDate;
  }
  
  public g b() {
    try {
      boolean bool1 = g.exists();
      boolean bool2 = h.exists();
      boolean bool3 = c.exists();
      if (!bool3 && !bool1 && !bool2)
        return g.a(); 
      FileUtilRt.createDirectory(f);
      if (!c.exists())
        if (bool1) {
          String str1 = StringUtil.join(FileUtilRt.loadLines(g.getAbsolutePath()), System.getProperty("line.separator"));
          d(str1);
          g.delete();
          if (bool2)
            h.delete(); 
        } else if (bool2) {
          String str1 = StringUtil.join(FileUtilRt.loadLines(h.getAbsolutePath()), System.getProperty("line.separator"));
          d(str1);
          h.delete();
        }  
      String str = StringUtil.join(FileUtilRt.loadLines(c.getAbsolutePath()), System.getProperty("line.separator"));
      return a(str);
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
      return g.a();
    } 
  }
  
  public g a(String paramString) {
    try {
      if (paramString != null)
        paramString = paramString.replaceAll("\r\n|\n|\r", "").trim(); 
      if (!i && !WallabyController.b)
        return g.a(); 
      g g = g.a();
      String str1 = new String(Base64.decode(paramString));
      String[] arrayOfString1 = str1.split("\n");
      String str2 = arrayOfString1[0];
      String str3 = arrayOfString1[1];
      String str4 = null;
      String str5 = null;
      String[] arrayOfString2 = str3.split(",");
      if (arrayOfString2.length >= 1)
        str4 = arrayOfString2[0]; 
      if (arrayOfString2.length >= 2)
        str5 = arrayOfString2[1]; 
      if (str5 == null)
        return g.a(); 
      String str6 = arrayOfString1[2];
      String str7 = arrayOfString1[3];
      PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode((str5 != null && str5.contains("Freedom")) ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4pDotejtzhiT/lpNfd0H2Dv08NTSJ8/ixuQz3iJiVRxQkot5Sn45wu4QiQEoY5NQ/tDf8V9mDeePNU/Zd8KYdyRFoq6bwOlHc0HAa50tecRCECESB+t3TVcqLMogX32vgQkSmly0sFxtGFBjN8WxV+Q7WQ8neft7JKaXtm+2Ft7P41ond+SfBeToh9mn9DFft+OuI2vz7s0OSjd+P2bw+GEIr3otl3CA5RrIH9WRsAVjawv+z5LvakQXtO6JNNmJgErHWZmkBIlv2VHDsoSdMLga2jTiEHrkZylKPFoz/hOdh/iVH4/r1AWxBhj8IgQlRcLJgvSBzJo4OlBhlYh6xwIDAQAB" : "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmquk0Iu5UP2kASDwGjNDCkkuneWReQxxSGWPx28q+5MWEXnigj5kGLI140zavsGhOIPVDObB7p5ru17gd8L6xZgBuapy2B2z5PnBbAGOqZBDwUASCibYtJ6N4wrLyUlCE3JaRlMDu+4VY/ybtzPCxMWzdSzkoHpImD4nnM+FLJO7gUCqAy0JdFyT9L7OwflZZaMvhonbK4jEHDolK7l2EBSPxZOxj5w5VBbnlqZA8e+tKmBIUTtrnhkzmsKFLqVSuzJwi28+veK/AzOW/F1UQRxsSu886j4IVz3Qdsx3tlD1s+xZuZpGZt4+pmne0Ons0KhQ0PL5gx6ZmogWq9drmwIDAQAB")));
      Signature signature = Signature.getInstance("SHA512withRSA");
      signature.initVerify(publicKey);
      signature.update((str2 + str3 + str6).getBytes());
      boolean bool1 = signature.verify(Base64.decode(str7));
      if (!bool1)
        return g; 
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
      Date date1 = simpleDateFormat.parse(str6);
      Date date2 = simpleDateFormat.parse(simpleDateFormat.format(j));
      Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      calendar1.set(2019, 4, 27, 0, 0, 0);
      if (date1.before(calendar1.getTime()) && date1.before(date2))
        return g.a(paramString); 
      boolean bool2 = date1.before(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
      if (bool2)
        return "wallabyjs@gmail.com".equals(str4) ? g : g.a(paramString, str2, date1); 
      Calendar calendar2 = Calendar.getInstance();
      calendar2.setTime(new Date());
      calendar2.add(5, 14);
      boolean bool3 = date1.before(calendar2.getTime());
      return bool3 ? g.a(paramString, str2, date1, str5) : g.b(paramString, str2, date1, str5);
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
      return g.a();
    } 
  }
  
  public void b(String paramString) {
    try {
      d(paramString);
    } catch (IOException iOException) {
      WallabyController.a.warn(iOException);
    } 
  }
  
  private void d(String paramString) throws IOException {
    FileUtil.writeToFile(c, paramString);
  }
  
  public String c() {
    try {
      File file = new File(f + File.separator + ".ol");
      if (!file.exists())
        return ""; 
      String str1 = StringUtil.join(new String[] { FileUtilRt.loadFile(file) });
      String str2 = new String(Base64.decode(str1));
      JsonParser jsonParser = new JsonParser();
      JsonElement jsonElement = jsonParser.parse(str2);
      if (jsonElement.getAsJsonObject().has("wallabyEmail"))
        return jsonElement.getAsJsonObject().get("wallabyEmail").getAsString(); 
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
    } 
    return "";
  }
  
  public void c(String paramString) {
    try {
      String str;
      File file = new File(f + File.separator + ".ol");
      if (paramString.length() == 0) {
        if (file.exists())
          file.delete(); 
        return;
      } 
      if (!file.exists()) {
        str = "{}";
      } else {
        String str1 = StringUtil.join(new String[] { FileUtilRt.loadFile(file) });
        str = new String(Base64.decode(str1));
      } 
      JsonParser jsonParser = new JsonParser();
      JsonElement jsonElement = jsonParser.parse(str);
      jsonElement.getAsJsonObject().addProperty("wallabyEmail", paramString);
      jsonElement.getAsJsonObject().addProperty("lastUpdate", Long.valueOf((new Date()).getTime()));
      FileUtil.writeToFile(file, Base64.encode(jsonElement.toString().getBytes()));
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/d/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */