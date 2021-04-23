package com.wallaby.javascript;

import com.google.gson.GsonBuilder;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.io.FileUtilRt;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.Consumer;
import com.intellij.util.SystemProperties;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.Predicate;
import com.intellij.util.net.HTTPMethod;
import com.intellij.util.net.HttpConfigurable;
import com.intellij.util.net.IOExceptionDialog;
import com.intellij.util.net.NetUtils;
import com.wallaby.javascript.c.f;
import com.wallaby.javascript.d.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class WallabyDependencies {
  private static final long b = 1200000L;
  
  private final File c;
  
  private final File d;
  
  private final Project e;
  
  private String f;
  
  private Date g;
  
  private String h;
  
  private static final String i = "https://update.wallabyjs.com/";
  
  private static final String j = "http://update.wallabyjs.com/";
  
  private static final String k = "https://s3.amazonaws.com/wallaby-downloads/";
  
  private static final String l = "wallaby.json";
  
  private static final String m = "wallaby-v";
  
  private static final String n;
  
  public WallabyDependencies(Project project, File root) {
    String str = "8.5.0";
    f();
    g g = (new a()).b();
    if (StringUtil.isEmpty(this.h))
      this.h = "wallaby.json"; 
    this.h += "?licensed=" + g.e();
    if (g.d())
      this.h += "&expire=" + g.j(); 
    this.e = project;
    this.d = new File(root.getAbsolutePath() + File.separator + "wallaby");
    this.f = this.d.getAbsolutePath() + File.separator + "server.js";
    this.c = new File(root.getAbsolutePath() + File.separator + "node_v" + "8.5.0" + File.separator + (SystemInfo.isWindows ? "node.exe" : "node"));
  }
  
  public boolean a() {
    ArrayList<File> arrayList = new ArrayList();
    try {
      if (!StringUtil.isEmpty(n)) {
        this.f = n;
      } else {
        String str = b();
        if (str == null || !a(g(), str)) {
          File file = FileUtil.createTempFile("versionDataFile", ".json");
          arrayList.add(file);
          a("http://update.wallabyjs.com/", this.h, file, k.a("background.checkingLatestVersion", new Object[0]));
          String str1 = a(a(file));
          try {
            FileUtilRt.delete(this.d);
            FileUtilRt.createDirectory(this.d);
            File file1 = FileUtilRt.createTempFile("wallaby", null);
            arrayList.add(file1);
            a("https://s3.amazonaws.com/wallaby-downloads/", "wallaby-v" + str1 + ".zip", file1, (String)null);
            a(file1, paramFile -> {
                  paramList.add(paramFile);
                  a(paramFile, this.d);
                });
            this.g = new Date();
          } catch (Exception exception) {
            FileUtilRt.delete(this.d);
            throw exception;
          } 
        } 
      } 
    } catch (Exception exception) {
      WallabyController.a.warn("Failed to check/install wallaby.js dependencies, " + exception.getMessage());
      return false;
    } finally {
      for (File file : arrayList) {
        try {
          FileUtilRt.delete(file);
        } catch (Exception exception) {
          WallabyController.a.warn("Failed to clean up temporary files after dependency check/update, " + exception.getMessage());
        } 
      } 
    } 
    return true;
  }
  
  private void f() {
    Date date = null;
    try {
      Enumeration<URL> enumeration = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
      while (enumeration.hasMoreElements()) {
        Manifest manifest = new Manifest(((URL)enumeration.nextElement()).openStream());
        Attributes attributes = manifest.getMainAttributes();
        if (attributes == null)
          continue; 
        String str1 = attributes.getValue("Created-By");
        if (!"Wallaby.js".equals(str1))
          continue; 
        String str2 = attributes.getValue("Build-TimeStamp");
        String str3 = attributes.getValue("Build-Period");
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
          date = new Date();
          a.a();
          a.a(date);
        } else {
          long l = Long.parseLong(str2);
          date = new Date(l);
          a.a(date);
        } 
        this.h = attributes.getValue("Version-Url");
      } 
    } catch (Exception exception) {}
    if (date == null) {
      a.a();
      a.a(new Date());
    } 
  }
  
  private MyVersionData a(File paramFile) throws Exception {
    return (MyVersionData)(new GsonBuilder()).create().fromJson(StringUtil.join(FileUtilRt.loadLines(paramFile.getAbsolutePath()), ""), MyVersionData.class);
  }
  
  public String a(MyVersionData paramMyVersionData) throws Exception {
    String str = a(paramMyVersionData, g());
    if (str == null)
      throw new Exception("Can not find compatible latest version of wallaby.js server, try installing the latest plugin version"); 
    return str;
  }
  
  private boolean a(String paramString1, String paramString2) {
    String str = paramString1.substring(0, paramString1.lastIndexOf("."));
    return paramString2.startsWith(str);
  }
  
  private String a(MyVersionData paramMyVersionData, String paramString) {
    return (String)ContainerUtil.find(MyVersionData.a(paramMyVersionData), paramString2 -> a(paramString1, paramString2));
  }
  
  private void a(File paramFile1, File paramFile2) {
    boolean bool = false;
    do {
      try {
        if (paramFile1.isDirectory() && paramFile2.isDirectory()) {
          FileUtil.copyDir(paramFile1, paramFile2);
        } else {
          FileUtilRt.copy(paramFile1, paramFile2);
        } 
      } catch (Exception exception) {
        WallabyController.a.warn("Failed to copy wallaby.js dependencies, " + exception.getMessage());
        String str = "Can not copy extract files to " + paramFile2.getAbsolutePath() + ". ";
        bool = IOExceptionDialog.showErrorDialog("Copy Error", str);
      } 
    } while (bool);
  }
  
  private void a(File paramFile, Consumer<File> paramConsumer) {
    boolean bool = false;
    do {
      try {
        File file = FileUtil.createTempDirectory("unzip-dir-", null);
        f.a(this.e, "Unzipping dependencies", paramFile, file, true);
        paramConsumer.consume(file);
      } catch (Exception exception) {
        WallabyController.a.warn("Failed to extract wallaby.js dependencies, " + exception.getMessage());
        String str = "Can not extract files from downloaded archive " + paramFile.getAbsolutePath() + ". ";
        bool = IOExceptionDialog.showErrorDialog("Unzipping Error", str);
      } 
    } while (bool);
  }
  
  private void a(String paramString1, String paramString2, File paramFile, String paramString3) {
    String[] arrayOfString = new String[1];
    Runnable runnable = () -> {
        a a = new a(ProgressManager.getInstance().getProgressIndicator());
        a.a("https://update.wallabyjs.com/", paramString1, paramString2, paramFile);
        paramArrayOfString[0] = a.a();
      };
    boolean bool = false;
    do {
      if (!ProgressManager.getInstance().runProcessWithProgressSynchronously(runnable, StringUtil.isEmpty(paramString3) ? k.a("background.downloadingDependencies", new Object[0]) : paramString3, true, this.e))
        continue; 
      if (!StringUtil.isEmpty(arrayOfString[0])) {
        WallabyController.a.warn("Failed to download wallaby.js dependencies, " + arrayOfString[0]);
        String str = "Can not download from " + paramString2 + ". ";
        bool = IOExceptionDialog.showErrorDialog("Download Error", str);
      } else {
        bool = false;
      } 
    } while (bool);
  }
  
  public String b() {
    if (!this.d.exists())
      return null; 
    File file = new File(this.d.getAbsolutePath() + File.separator + "package.json");
    if (!file.exists())
      return null; 
    try {
      MyPackageJson myPackageJson = (MyPackageJson)(new GsonBuilder()).create().fromJson(StringUtil.join(FileUtilRt.loadLines(file.getAbsolutePath()), ""), MyPackageJson.class);
      return MyPackageJson.a(myPackageJson);
    } catch (Exception exception) {
      WallabyController.a.warn("Failed to get wallaby.js server version, " + exception.getMessage());
      return null;
    } 
  }
  
  public void a(ProgressIndicator paramProgressIndicator, boolean paramBoolean) {
    if (!StringUtil.isEmpty(n))
      return; 
    if (!paramBoolean && this.g != null && (new Date()).getTime() - this.g.getTime() < 1200000L)
      return; 
    try {
      this.g = new Date();
      File file = FileUtil.createTempFile("versionDataFile", ".json");
      a a = new a(paramProgressIndicator);
      a.a("https://update.wallabyjs.com/", "http://update.wallabyjs.com/", this.h, file);
      MyVersionData myVersionData = a(file);
      String str = a(myVersionData);
      if (!str.equals(b())) {
        paramProgressIndicator.setText(k.a("background.serverUpdate", new Object[0]));
        File file1 = FileUtilRt.createTempFile("wallaby", null);
        a.a("https://update.wallabyjs.com/", "https://s3.amazonaws.com/wallaby-downloads/", "wallaby-v" + str + ".zip", file1);
        File file2 = FileUtil.createTempDirectory("unzip-dir-", null);
        f.a(paramProgressIndicator, file2, file1, null, null, true);
        FileUtil.copyDir(file2, this.d);
      } 
      try {
        FileUtilRt.delete(file);
      } catch (Exception exception) {
        WallabyController.a.warn("Failed to delete temporary file, " + exception.getMessage());
      } 
    } catch (Exception exception) {
      WallabyController.a.warn("Failed to check or update wallaby.js server, " + exception.getMessage());
    } 
  }
  
  private String g() {
    IdeaPluginDescriptor ideaPluginDescriptor = PluginManager.getPlugin(PluginId.getId("wallaby.js"));
    if (!a && ideaPluginDescriptor == null)
      throw new AssertionError(); 
    return ideaPluginDescriptor.getVersion();
  }
  
  public String c() {
    return this.c.getAbsolutePath();
  }
  
  public String[] d() {
    return new String[] { "--harmony" };
  }
  
  public String e() {
    return this.f;
  }
  
  static {
    n = System.getProperty("WallabyServerPath");
  }
  
  private static final class c {
    public static b a(String param1String) {
      return new b(param1String);
    }
    
    public static String a(IOException param1IOException, a param1a, boolean param1Boolean) throws IOException {
      URLConnection uRLConnection = param1a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot download '").append(uRLConnection.getURL().toExternalForm()).append("': ").append(param1IOException.getMessage());
      if (param1Boolean)
        stringBuilder.append("\n, headers: ").append(uRLConnection.getHeaderFields()); 
      if (uRLConnection instanceof HttpURLConnection) {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
        stringBuilder.append("\n, response: ").append(httpURLConnection.getResponseCode()).append(' ').append(httpURLConnection.getResponseMessage());
      } 
      return stringBuilder.toString();
    }
    
    static <T> void a(b param1b, c<T> param1c) throws IOException {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(new URLClassLoader(new URL[0], classLoader));
      try {
        b(param1b, param1c);
      } finally {
        Thread.currentThread().setContextClassLoader(classLoader);
      } 
    }
    
    static <T> void b(b param1b, c<T> param1c) throws IOException {
      s s = new s(param1b);
      try {
        param1c.process(s);
      } finally {
        s.a(s);
      } 
    }
    
    private static URLConnection b(b param1b) throws IOException {
      String str = param1b.a;
      byte b1 = 0;
      while (b1 < param1b.d) {
        URLConnection uRLConnection;
        if (param1b.f && StringUtil.startsWith(str, "http:"))
          str = "https:" + str.substring(5); 
        if (ApplicationManager.getApplication() == null) {
          uRLConnection = (new URL(str)).openConnection();
        } else {
          uRLConnection = HttpConfigurable.getInstance().openConnection(str);
        } 
        uRLConnection.setConnectTimeout(param1b.b);
        uRLConnection.setReadTimeout(param1b.c);
        if (param1b.h != null)
          uRLConnection.setRequestProperty("User-Agent", param1b.h); 
        if (param1b.g != null && uRLConnection instanceof HttpsURLConnection)
          ((HttpsURLConnection)uRLConnection).setHostnameVerifier(param1b.g); 
        if (param1b.j != null)
          ((HttpURLConnection)uRLConnection).setRequestMethod(param1b.j.name()); 
        if (param1b.e)
          uRLConnection.setRequestProperty("Accept-Encoding", "gzip"); 
        if (param1b.i != null)
          uRLConnection.setRequestProperty("Accept", param1b.i); 
        uRLConnection.setUseCaches(false);
        if (uRLConnection instanceof HttpURLConnection) {
          int i = ((HttpURLConnection)uRLConnection).getResponseCode();
          if (i != 200 && i != 304) {
            ((HttpURLConnection)uRLConnection).disconnect();
            if (i == 301 || i == 302) {
              str = uRLConnection.getHeaderField("Location");
              if (str != null) {
                b1++;
                continue;
              } 
            } 
            throw new IOException(k.a("messages.connection.failed.with.http.code.N", new Object[] { Integer.valueOf(i) }));
          } 
        } 
        return uRLConnection;
      } 
      throw new IOException(k.a("messages.connection.failed.redirects", new Object[0]));
    }
    
    private static final class b {
      private static final boolean k = (StringUtil.compareVersionNumbers(SystemInfo.JAVA_RUNTIME_VERSION, "1.8") >= 0 && !SystemProperties.getBooleanProperty("idea.parallel.class.loader", true));
      
      final String a;
      
      int b = 10000;
      
      int c = 60000;
      
      int d = 10;
      
      boolean e = true;
      
      boolean f;
      
      HostnameVerifier g;
      
      String h;
      
      String i;
      
      HTTPMethod j;
      
      b(String param2String) {
        this.a = param2String;
      }
      
      public b a(String param2String) {
        this.h = param2String;
        return this;
      }
      
      public b a() {
        Application application = ApplicationManager.getApplication();
        return (application != null && !application.isDisposed()) ? a(ApplicationInfo.getInstance().getVersionName()) : a("IntelliJ");
      }
      
      public <T> void a(WallabyDependencies.c.c<T> param2c) throws IOException {
        if (k) {
          WallabyDependencies.c.a(this, param2c);
        } else {
          WallabyDependencies.c.b(this, param2c);
        } 
      }
    }
    
    public static interface c<T> {
      T process(WallabyDependencies.c.a param2a) throws IOException;
    }
    
    public static interface a {
      URLConnection a() throws IOException;
      
      InputStream b() throws IOException;
    }
  }
  
  private static class b {
    public static final String a = "${content-length}";
    
    public static void a(ProgressIndicator param1ProgressIndicator, String param1String, File param1File1, File param1File2, Predicate<String> param1Predicate) throws IOException {
      try {
        b(param1ProgressIndicator, param1String, param1File2);
        if (param1Predicate != null) {
          String str = FileUtil.loadFile(param1File2);
          if (!param1Predicate.apply(str))
            return; 
        } 
        FileUtil.rename(param1File2, param1File1);
      } finally {
        FileUtil.delete(param1File2);
      } 
    }
    
    public static void a(ProgressIndicator param1ProgressIndicator, String param1String, File param1File) throws IOException {
      File file = FileUtil.createTempFile("for-actual-downloading-", null);
      a(param1ProgressIndicator, param1String, param1File, file, null);
    }
    
    public static void b(ProgressIndicator param1ProgressIndicator, String param1String, File param1File) throws IOException {
      boolean bool = FileUtil.createParentDirs(param1File);
      if (!bool)
        throw new IOException("Parent dir of '" + param1File.getAbsolutePath() + "' can not be created!"); 
      try (FileOutputStream null = new FileOutputStream(param1File)) {
        a(param1ProgressIndicator, param1String, fileOutputStream);
      } 
    }
    
    private static void a(ProgressIndicator param1ProgressIndicator, String param1String, OutputStream param1OutputStream) throws IOException {
      String str = (param1ProgressIndicator != null) ? param1ProgressIndicator.getText() : null;
      a(param1ProgressIndicator, str, -1);
      if (param1ProgressIndicator != null)
        param1ProgressIndicator.setText2("Downloading " + param1String); 
      try {
        WallabyDependencies.c.a(param1String).a().a(param1a -> {
              try {
                int i = param1a.a().getContentLength();
                a(param1ProgressIndicator, param1String, i);
                NetUtils.copyStreamContent(param1ProgressIndicator, param1a.b(), param1OutputStream, i);
              } catch (IOException iOException) {
                throw new IOException(WallabyDependencies.c.a(iOException, param1a, true), iOException);
              } 
              return null;
            });
      } catch (IOException iOException) {
        throw new IOException("Cannot download " + param1String, iOException);
      } 
    }
    
    private static void a(ProgressIndicator param1ProgressIndicator, String param1String, int param1Int) {
      if (param1ProgressIndicator != null && param1String != null) {
        int i = param1String.indexOf("${content-length}");
        if (i != -1) {
          String str1 = a(param1Int);
          String str2 = param1String.substring(0, i) + str1 + param1String.substring(i + "${content-length}".length());
          param1ProgressIndicator.setText(str2);
        } 
      } 
    }
    
    private static String a(int param1Int) {
      if (param1Int < 0)
        return ""; 
      char c = 'Ѐ';
      return (param1Int < 1024) ? (", " + param1Int + " bytes") : ((param1Int < 1048576) ? String.format(Locale.US, ", %.1f kB", new Object[] { Double.valueOf(param1Int / 1024.0D) }) : String.format(Locale.US, ", %.1f MB", new Object[] { Double.valueOf(param1Int / 1048576.0D) }));
    }
  }
  
  private static class a {
    private final ProgressIndicator a;
    
    private String b;
    
    public a(ProgressIndicator param1ProgressIndicator) {
      this.a = param1ProgressIndicator;
      this.b = null;
    }
    
    public void a(String param1String1, String param1String2, String param1String3, File param1File) {
      this.b = null;
      String str1 = param1String1 + param1String3;
      String str2 = param1String2 + param1String3;
      try {
        a(str1, param1File);
      } catch (a a1) {
        try {
          a(str2, param1File);
        } catch (a a2) {
          this.b = a2.toString();
        } 
      } 
    }
    
    public String a() {
      return this.b;
    }
    
    private void a(String param1String, File param1File) throws a {
      try {
        WallabyDependencies.b.a(this.a, param1String, param1File);
      } catch (IOException iOException) {
        if (param1File.exists())
          FileUtil.delete(param1File); 
        throw new a(iOException);
      } 
    }
    
    public static class a extends Exception {
      public a(Throwable param2Throwable) {
        super(param2Throwable);
      }
      
      public String a() {
        Throwable throwable = getCause();
        return (throwable == null) ? getMessage() : ((throwable instanceof java.io.FileNotFoundException) ? "File not found" : ((throwable instanceof java.net.UnknownHostException) ? "Unknown host" : throwable.getMessage()));
      }
      
      public String toString() {
        return a();
      }
    }
  }
  
  private class MyPackageJson {
    private String version;
  }
  
  private class MyVersionData {
    private ArrayList<String> latestServer;
    
    private String latestIntelliJPlugin;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/WallabyDependencies.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */