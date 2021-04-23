package com.wallaby.javascript;

import com.intellij.execution.filters.HyperlinkInfo;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.JBColor;
import com.intellij.util.Alarm;
import com.intellij.util.containers.ContainerUtil;
import com.wallaby.javascript.actions.i;
import com.wallaby.javascript.actions.j;
import com.wallaby.javascript.extendedCore.inboundMessages.ErrorEntry;
import com.wallaby.javascript.extendedCore.inboundMessages.Location;
import com.wallaby.javascript.extendedCore.inboundMessages.TestEntry;
import com.wallaby.javascript.extendedCore.inboundMessages.TestMessage;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestPrinter {
  private static final int a = 5;
  
  private static final int b = 4;
  
  private static final HashMap<ContentType, ConsoleViewContentType> c = new HashMap<>();
  
  private static final Runnable d;
  
  private static final ColorKey e = ColorKey.createColorKey("WALLABY.DIFF_ADDED", (Color)new JBColor((ConsoleViewContentType.USER_INPUT.getAttributes().getForegroundColor() != null) ? ConsoleViewContentType.USER_INPUT.getAttributes().getForegroundColor() : new Color(0, 127, 0), new Color(98, 180, 85)));
  
  private final int f;
  
  private final m g;
  
  private ConsoleView h;
  
  private Alarm i;
  
  private DiffPatchMatch j = new DiffPatchMatch();
  
  TestPrinter(m context, ConsoleView consoleView) {
    this(context, consoleView, 0);
  }
  
  public TestPrinter(m context, ConsoleView consoleView, int delay) {
    this.f = delay;
    this.g = context;
    this.h = consoleView;
    if (this.f > 0)
      this.i = new Alarm(Alarm.ThreadToUse.POOLED_THREAD, (Disposable)consoleView); 
  }
  
  public void a() {
    if (this.f > 0)
      this.i.cancelAllRequests(); 
  }
  
  public void a(TestEntry[] paramArrayOfTestEntry, Runnable paramRunnable, boolean paramBoolean) {
    Runnable runnable = () -> a(paramArrayOfTestEntry, paramRunnable, true, paramBoolean);
    if (this.f == 0) {
      runnable.run();
    } else {
      this.i.cancelAllRequests();
      this.i.addRequest(runnable, this.f);
    } 
  }
  
  public void a(String paramString) {
    b(paramString, ContentType.ERROR_TEXT, 0);
    b();
    this.h.scrollTo(0);
  }
  
  public void a(ErrorEntry[] paramArrayOfErrorEntry) {
    for (ErrorEntry errorEntry : paramArrayOfErrorEntry) {
      Location[] arrayOfLocation = errorEntry.e();
      if (errorEntry.c() && arrayOfLocation.length > 0) {
        a(k.a("console.run.messages.updateFileSnapshotsLink", new Object[0]), paramProject -> {
              try {
                this.g.d(paramArrayOfLocation[0].d());
              } catch (Exception exception) {
                WallabyController.a.warn(exception);
              } 
            }0);
        b();
        b();
      } 
      b(errorEntry.a(), ContentType.ERROR_TEXT, 0);
      for (Location location : arrayOfLocation) {
        a(location.e(), location.d(), location.c(), 1, (Runnable)null);
        b();
      } 
      b();
    } 
    this.h.scrollTo(0);
  }
  
  private void a(TestEntry[] paramArrayOfTestEntry, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2) {
    List<TestEntry> list = Arrays.asList(paramArrayOfTestEntry);
    for (TestEntry testEntry : paramBoolean1 ? ContainerUtil.getFirstItems(list, paramBoolean2 ? 1 : 5) : list) {
      List<String> list1 = Arrays.asList(testEntry.b());
      String str1 = !list1.isEmpty() ? list1.get(list1.size() - 1) : "";
      String str2 = StringUtil.join(ContainerUtil.getFirstItems(list1, list1.size() - 1), " ");
      Long long_ = testEntry.d();
      String str3 = str1 + ((long_ != null) ? (" [" + long_ + " ms]") : "");
      String str4 = testEntry.c();
      if (str4 == null) {
        a(testEntry.a(), ContentType.NORMAL_TEXT, 0);
      } else {
        a(testEntry.a(), (HyperlinkInfo)new i(testEntry.a(), testEntry.c(), paramRunnable), 0);
      } 
      boolean bool = ((testEntry.e()).length > 0) ? true : false;
      ContentType contentType1 = bool ? ContentType.FAILED_TEST_NAME : ContentType.PASSED_TEST_NAME;
      ContentType contentType2 = bool ? ContentType.FAILED_SUITE_PATH : ContentType.PASSED_SUITE_PATH;
      a(" " + str2, contentType2, 0);
      b(" " + str3, contentType1, 0);
      for (ErrorEntry errorEntry : testEntry.e()) {
        b();
        String str5 = errorEntry.d();
        String str6 = errorEntry.b();
        if (!StringUtil.notNullize(str5).isEmpty() && !StringUtil.notNullize(str6).isEmpty())
          a(str5, str6, 1, paramRunnable, errorEntry.c() ? (() -> {
                String str = paramTestEntry.c().split(":")[0];
                try {
                  this.g.a(paramTestEntry.a(), Integer.parseInt(str), true);
                } catch (Exception exception) {
                  WallabyController.a.warn(exception);
                } 
              }) : null); 
        b(errorEntry.a(), ContentType.ERROR_TEXT, 1);
        for (Location location : errorEntry.e()) {
          a(location.e(), location.d(), location.c(), 2, paramRunnable);
          b();
        } 
      } 
      if ((testEntry.f()).length > 0) {
        b();
        b(k.a("console.run.messages.fromConsole", new Object[0]), ContentType.NORMAL_TEXT, 1);
        for (TestMessage testMessage : testEntry.f()) {
          a(testMessage.d() + " ", ContentType.NORMAL_TEXT, 2);
          a(testMessage.c(), testMessage.b(), testMessage.a(), 0, paramRunnable);
          b();
          b();
        } 
      } 
      b();
    } 
    if ((paramBoolean1 && paramArrayOfTestEntry.length > 5) || (paramBoolean2 && paramArrayOfTestEntry.length > 1)) {
      int i = paramArrayOfTestEntry.length - (paramBoolean2 ? 1 : 5);
      a(String.format(k.a("console.run.messages.showMore", new Object[0]), new Object[] { Integer.valueOf(i) }), paramProject -> {
            int i = this.h.getContentSize();
            this.h.clear();
            a(paramArrayOfTestEntry, paramRunnable, false, false);
            this.h.scrollTo(i);
          }0);
      b();
    } 
    this.h.scrollTo(0);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, Runnable paramRunnable1, Runnable paramRunnable2) {
    a("", ContentType.NORMAL_TEXT, paramInt);
    a(k.a("console.run.messages.diffLink", new Object[0]), (HyperlinkInfo)new j(paramString1, paramString2, paramRunnable1), 0);
    if (paramRunnable2 != null) {
      a("  ", ContentType.NORMAL_TEXT, 0);
      a(k.a("console.run.messages.updateSnapshotLink", new Object[0]), paramProject -> {
            paramRunnable1.run();
            if (paramRunnable2 != null)
              paramRunnable2.run(); 
          }0);
    } 
    b();
    b();
    LinkedList<DiffPatchMatch.a> linkedList = this.j.c(paramString1, paramString2);
    for (byte b = 0; b < linkedList.size(); b++) {
      boolean bool1 = (b == 0) ? true : false;
      boolean bool2 = (b == linkedList.size() - 1) ? true : false;
      DiffPatchMatch.a a = linkedList.get(b);
      if (a.a == DiffPatchMatch.Operation.INSERT) {
        a(a.b, ContentType.DIFF_ADDED, paramInt, bool1, bool2);
      } else if (a.a == DiffPatchMatch.Operation.DELETE) {
        a(a.b, ContentType.DIFF_REMOVED, paramInt, bool1, bool2);
      } else {
        a(a.b, ContentType.NORMAL_TEXT, paramInt, bool1, bool2);
      } 
    } 
    b();
    b();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, Runnable paramRunnable) {
    if (paramString2.length() == 0)
      return; 
    a("at " + (paramString1.isEmpty() ? "" : (paramString1 + " ")), ContentType.NORMAL_TEXT, paramInt);
    a(paramString2 + ":" + e(paramString3), (HyperlinkInfo)new i(paramString2, paramString3, paramRunnable), 0);
  }
  
  private String e(String paramString) {
    Integer integer;
    if (paramString == null)
      return ""; 
    if (paramString.length() == 0)
      return ""; 
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length == 1)
      return paramString; 
    try {
      integer = Integer.valueOf(Integer.parseInt(arrayOfString[1]));
      integer = Integer.valueOf(integer.intValue() + 1);
    } catch (Exception exception) {
      integer = null;
    } 
    return (integer == null) ? arrayOfString[1] : (arrayOfString[0] + ":" + integer.intValue());
  }
  
  public void a(String paramString, HyperlinkInfo paramHyperlinkInfo) {
    a(paramString, paramHyperlinkInfo, 0);
  }
  
  private void a(String paramString, HyperlinkInfo paramHyperlinkInfo, int paramInt) {
    a(StringUtil.repeat("\t", paramInt), ContentType.NORMAL_TEXT, paramInt);
    this.h.printHyperlink(paramString, paramHyperlinkInfo);
  }
  
  private void a(String paramString, ConsoleViewContentType paramConsoleViewContentType, int paramInt) {
    String[] arrayOfString = (paramString != null) ? paramString.split("\\r?\\n") : new String[0];
    boolean bool = (arrayOfString.length > 1) ? true : false;
    for (String str : arrayOfString)
      this.h.print(StringUtil.repeat("\t", paramInt) + str + (bool ? "\n" : ""), paramConsoleViewContentType); 
  }
  
  private void a(String paramString, ContentType paramContentType, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool = (ContentType.NORMAL_TEXT == paramContentType) ? true : false;
    String[] arrayOfString = (paramString != null) ? paramString.split("\\r?\\n", -1) : new String[0];
    if (bool)
      arrayOfString = a(arrayOfString, paramBoolean1, paramBoolean2); 
    for (byte b = 0; b < arrayOfString.length; b++) {
      this.h.print(StringUtil.repeat("\t", (b == 0) ? (paramBoolean1 ? paramInt : 0) : paramInt), ConsoleViewContentType.NORMAL_OUTPUT);
      this.h.print(arrayOfString[b] + ((b < arrayOfString.length - 1) ? "\n" : ""), c.get(paramContentType));
    } 
  }
  
  private String[] a(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2) {
    int i = paramArrayOfString.length;
    if (i <= 4)
      return paramArrayOfString; 
    if (!paramBoolean1 && !paramBoolean2 && i <= 8)
      return paramArrayOfString; 
    ArrayList<String> arrayList = new ArrayList();
    if (paramBoolean1) {
      arrayList.add("...");
      arrayList.addAll(Arrays.asList(Arrays.copyOfRange(paramArrayOfString, i - 4, i)));
      return arrayList.<String>toArray(new String[0]);
    } 
    if (paramBoolean2) {
      arrayList.addAll(Arrays.asList(Arrays.copyOfRange(paramArrayOfString, 0, 4)));
      arrayList.add("...");
      return arrayList.<String>toArray(new String[0]);
    } 
    arrayList.addAll(Arrays.asList(Arrays.copyOfRange(paramArrayOfString, 0, 4)));
    arrayList.add("...");
    arrayList.addAll(Arrays.asList(Arrays.copyOfRange(paramArrayOfString, i - 4, i)));
    return arrayList.<String>toArray(new String[0]);
  }
  
  private void a(String paramString, ContentType paramContentType, int paramInt) {
    a(paramString, c.get(paramContentType), paramInt);
  }
  
  private void b() {
    this.h.print("\n", ConsoleViewContentType.NORMAL_OUTPUT);
  }
  
  private void b(String paramString, ContentType paramContentType, int paramInt) {
    a(paramString, paramContentType, paramInt);
    b();
  }
  
  public void b(String paramString) {
    a(paramString, ContentType.NORMAL_TEXT, 0);
    b();
  }
  
  public void c(String paramString) {
    a(paramString, ContentType.NORMAL_TEXT, 0);
  }
  
  public void d(String paramString) {
    a(paramString, ContentType.ERROR_TEXT, 0);
  }
  
  static {
    d = (() -> {
        EditorColorsManager editorColorsManager = EditorColorsManager.getInstance();
        EditorColorsScheme editorColorsScheme = editorColorsManager.getGlobalScheme();
        c.put(ContentType.CONSOLE_LOG, ConsoleViewContentType.NORMAL_OUTPUT);
        c.put(ContentType.CONSOLE_DIR, ConsoleViewContentType.NORMAL_OUTPUT);
        c.put(ContentType.CONSOLE_ERROR, ConsoleViewContentType.ERROR_OUTPUT);
        c.put(ContentType.CONSOLE_WARN, new ConsoleViewContentType("CONSOLE_WARN", ConsoleViewContentType.LOG_WARNING_OUTPUT_KEY));
        c.put(ContentType.NORMAL_TEXT, ConsoleViewContentType.NORMAL_OUTPUT);
        c.put(ContentType.ERROR_TEXT, ConsoleViewContentType.ERROR_OUTPUT);
        c.put(ContentType.PASSED_SUITE_PATH, ConsoleViewContentType.NORMAL_OUTPUT);
        c.put(ContentType.FAILED_SUITE_PATH, ConsoleViewContentType.ERROR_OUTPUT);
        TextAttributes textAttributes1 = ConsoleViewContentType.NORMAL_OUTPUT.getAttributes().clone();
        textAttributes1.setFontType(1);
        TextAttributes textAttributes2 = textAttributes1.clone();
        textAttributes2.setForegroundColor(ConsoleViewContentType.ERROR_OUTPUT.getAttributes().getForegroundColor());
        c.put(ContentType.PASSED_TEST_NAME, new ConsoleViewContentType("PASSED_TEST_NAME", textAttributes1));
        c.put(ContentType.FAILED_TEST_NAME, new ConsoleViewContentType("FAILED_TEST_NAME", textAttributes2));
        c.put(ContentType.DIFF_ADDED, new ConsoleViewContentType("DIFF_ADDED", new TextAttributes(editorColorsScheme.getColor(e), null, editorColorsScheme.getColor(e), EffectType.LINE_UNDERSCORE, 0)));
        c.put(ContentType.DIFF_REMOVED, new ConsoleViewContentType("DIFF_REMOVED", new TextAttributes(ConsoleViewContentType.ERROR_OUTPUT.getAttributes().getForegroundColor(), null, ConsoleViewContentType.ERROR_OUTPUT.getAttributes().getForegroundColor(), EffectType.LINE_UNDERSCORE, 0)));
      });
    d.run();
  }
  
  private enum ContentType {
    FAILED_SUITE_PATH, PASSED_SUITE_PATH, FAILED_TEST_NAME, PASSED_TEST_NAME, NORMAL_TEXT, DIFF_ADDED, DIFF_REMOVED, ERROR_TEXT, CONSOLE_LOG, CONSOLE_WARN, CONSOLE_ERROR, CONSOLE_DIR;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/TestPrinter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */