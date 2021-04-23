package com.wallaby.javascript.c;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Ref;
import com.intellij.util.Producer;
import com.intellij.util.io.HttpRequests;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.concurrent.Callable;

public class b {
  public static final String a = "${content-length}";
  
  private static final Logger b = Logger.getInstance(b.class);
  
  public static <V> e<V> a(Project paramProject, String paramString1, String paramString2, Callable<? extends V> paramCallable, Producer<Boolean> paramProducer) {
    for (byte b1 = 1;; b1++) {
      Ref ref1 = Ref.create(null);
      Ref ref2 = Ref.create(null);
      boolean bool1 = ProgressManager.getInstance().runProcessWithProgressSynchronously(() -> {
            ProgressIndicator progressIndicator = ProgressManager.getInstance().getProgressIndicator();
            progressIndicator.setText(paramString);
            try {
              Object object = paramCallable.call();
              paramRef1.set(object);
            } catch (Exception exception) {
              paramRef2.set(exception);
            } 
          }paramString1, true, paramProject);
      if (!bool1)
        return e.c(); 
      Exception exception = (Exception)ref2.get();
      if (exception == null)
        return e.a((V)ref1.get()); 
      b.info("[attempt#" + b1 + "] Cannot '" + paramString2 + "'");
      boolean bool2 = false;
      if (paramProducer != null)
        bool2 = Boolean.TRUE.equals(paramProducer.produce()); 
      if (!bool2)
        return e.a(exception); 
    } 
  }
  
  private static void a(ProgressIndicator paramProgressIndicator, String paramString, OutputStream paramOutputStream) throws IOException {
    String str = (paramProgressIndicator != null) ? paramProgressIndicator.getText() : null;
    b(paramProgressIndicator, str, -1);
    if (paramProgressIndicator != null)
      paramProgressIndicator.setText2("Downloading " + paramString); 
    HttpRequests.request(paramString).productNameAsUserAgent().connect(new c(paramProgressIndicator, str, paramOutputStream));
  }
  
  private static void b(ProgressIndicator paramProgressIndicator, String paramString, int paramInt) {
    if (paramProgressIndicator != null && paramString != null) {
      int i = paramString.indexOf("${content-length}");
      if (i != -1) {
        String str1 = a(paramInt);
        String str2 = paramString.substring(0, i) + str1 + paramString.substring(i + "${content-length}".length());
        paramProgressIndicator.setText(str2);
      } 
    } 
  }
  
  private static String a(int paramInt) {
    if (paramInt < 0)
      return ""; 
    char c = 'Ѐ';
    return (paramInt < 1024) ? (", " + paramInt + " bytes") : ((paramInt < 1048576) ? String.format(Locale.US, ", %.1f kB", new Object[] { Double.valueOf(paramInt / 1024.0D) }) : String.format(Locale.US, ", %.1f MB", new Object[] { Double.valueOf(paramInt / 1048576.0D) }));
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/c/b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */