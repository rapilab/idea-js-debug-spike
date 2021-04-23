package com.wallaby.javascript.extendedCore;

import b.b.e.h;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessListener;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtilRt;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.Consumer;
import com.intellij.util.SystemProperties;
import com.intellij.util.concurrency.QueueProcessor;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.extendedCore.inboundMessages.Busy;
import com.wallaby.javascript.extendedCore.inboundMessages.DocumentUpdates;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLocation;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionNode;
import com.wallaby.javascript.extendedCore.inboundMessages.FileMessage;
import com.wallaby.javascript.extendedCore.inboundMessages.FilesToTrack;
import com.wallaby.javascript.extendedCore.inboundMessages.LineReport;
import com.wallaby.javascript.extendedCore.inboundMessages.Live;
import com.wallaby.javascript.extendedCore.inboundMessages.Location;
import com.wallaby.javascript.extendedCore.inboundMessages.NavigationRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.Notification;
import com.wallaby.javascript.extendedCore.inboundMessages.ProjectConfigured;
import com.wallaby.javascript.extendedCore.inboundMessages.ShowDiffMessage;
import com.wallaby.javascript.extendedCore.inboundMessages.Started;
import com.wallaby.javascript.extendedCore.inboundMessages.Stats;
import com.wallaby.javascript.extendedCore.inboundMessages.StatsTrace;
import com.wallaby.javascript.extendedCore.inboundMessages.Stopped;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterTestSelectionRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterToggled;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStoryReset;
import com.wallaby.javascript.extendedCore.inboundMessages.Tests;
import com.wallaby.javascript.extendedCore.inboundMessages.Trace;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceCallStack;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceFile;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceNavigationReset;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceTest;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceTestSelectionRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.UncoveredRegions;
import com.wallaby.javascript.extendedCore.inboundMessages.WallabyAppUrl;
import com.wallaby.javascript.extendedCore.inboundMessages.a;
import com.wallaby.javascript.extendedCore.outboundMessages.AddTestLocations;
import com.wallaby.javascript.extendedCore.outboundMessages.ContinueTrial;
import com.wallaby.javascript.extendedCore.outboundMessages.CopyToClipboard;
import com.wallaby.javascript.extendedCore.outboundMessages.EditorData;
import com.wallaby.javascript.extendedCore.outboundMessages.EvaluateExpressionInEditor;
import com.wallaby.javascript.extendedCore.outboundMessages.ExpressionsToEvaluate;
import com.wallaby.javascript.extendedCore.outboundMessages.FailingTest;
import com.wallaby.javascript.extendedCore.outboundMessages.FileChangedInEditor;
import com.wallaby.javascript.extendedCore.outboundMessages.FileClosedInAllEditors;
import com.wallaby.javascript.extendedCore.outboundMessages.FileOpenedInEditor;
import com.wallaby.javascript.extendedCore.outboundMessages.GetFileMessages;
import com.wallaby.javascript.extendedCore.outboundMessages.LineLocation;
import com.wallaby.javascript.extendedCore.outboundMessages.RemoveLogs;
import com.wallaby.javascript.extendedCore.outboundMessages.RequestLineReport;
import com.wallaby.javascript.extendedCore.outboundMessages.RequestLocation;
import com.wallaby.javascript.extendedCore.outboundMessages.RequestTestStory;
import com.wallaby.javascript.extendedCore.outboundMessages.RequestTests;
import com.wallaby.javascript.extendedCore.outboundMessages.RequestTrace;
import com.wallaby.javascript.extendedCore.outboundMessages.RequestUncoveredRegions;
import com.wallaby.javascript.extendedCore.outboundMessages.RunMode;
import com.wallaby.javascript.extendedCore.outboundMessages.RunTests;
import com.wallaby.javascript.extendedCore.outboundMessages.ToggleTestFilter;
import com.wallaby.javascript.extendedCore.outboundMessages.TraceContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client implements Disposable {
  private static final String a = System.getProperty("WallabyNodeModulesPath");
  
  private static String b = "localhost";
  
  private final String c;
  
  private final String[] d;
  
  private final String e;
  
  private final String f;
  
  private final String g;
  
  private final String[] h;
  
  private final boolean i;
  
  private final String j;
  
  private final boolean k;
  
  private final List<Runnable> l = new ArrayList<>();
  
  private final List<Consumer<Busy>> m = new ArrayList<>();
  
  private final List<Consumer<DocumentUpdates>> n = new ArrayList<>();
  
  private final List<Consumer<a>> o = new ArrayList<>();
  
  private final List<Consumer<FilesToTrack>> p = new ArrayList<>();
  
  private final List<Consumer<Live>> q = new ArrayList<>();
  
  private final List<Consumer<WallabyAppUrl>> r = new ArrayList<>();
  
  private final List<Consumer<Location>> s = new ArrayList<>();
  
  private final List<Consumer<Notification>> t = new ArrayList<>();
  
  private final List<Consumer<ProjectConfigured>> u = new ArrayList<>();
  
  private final List<Consumer<Started>> v = new ArrayList<>();
  
  private final List<Consumer<Stats>> w = new ArrayList<>();
  
  private final List<Consumer<Stopped>> x = new ArrayList<>();
  
  private final List<Consumer<UncoveredRegions>> y = new ArrayList<>();
  
  private final List<Consumer<LineReport>> z = new ArrayList<>();
  
  private final List<Consumer<Tests>> A = new ArrayList<>();
  
  private final List<Consumer<ShowDiffMessage>> B = new ArrayList<>();
  
  private final List<Consumer<NavigationRequested>> C = new ArrayList<>();
  
  private final List<Consumer<TestFilterToggled>> D = new ArrayList<>();
  
  private final List<Consumer<Trace>> E = new ArrayList<>();
  
  private final List<Consumer<Trace.TraceData>> F = new ArrayList<>();
  
  private final List<Consumer<TestStory>> G = new ArrayList<>();
  
  private final List<Consumer<TraceNavigationReset>> H = new ArrayList<>();
  
  private final List<Consumer<TestStoryReset>> I = new ArrayList<>();
  
  private final List<Consumer<TraceTestSelectionRequested>> J = new ArrayList<>();
  
  private final List<Consumer<TestFilterTestSelectionRequested>> K = new ArrayList<>();
  
  private final Gson L;
  
  private final Gson M;
  
  private final QueueProcessor<Runnable> N;
  
  private final QueueProcessor<Runnable> O;
  
  private final String P;
  
  private final boolean Q;
  
  private final List<Runnable> R = new ArrayList<>();
  
  private final Gson S;
  
  private boolean T = false;
  
  private b.b.a.b U;
  
  private Thread V;
  
  private boolean W = false;
  
  private boolean X = false;
  
  private JsonObject Y = new JsonObject();
  
  public Client(String nodePath, String[] nodeParams, String workingDirectory, String wallabyPath, String projectCachePath, String configPath, String[] testsPaths, boolean useConfigurationFile, String lkp, boolean useWsl, boolean onlineLicenseCheck, Consumer<Started> started, Consumer<Stopped> stopped, Consumer<Notification> notification, Consumer<Busy> busy, Consumer<Stats> stats, Consumer<a> fileMessages, Consumer<ProjectConfigured> projectConfigured, Consumer<FilesToTrack> filesToTrack, Consumer<Live> live, Consumer<DocumentUpdates> documentUpdates, Consumer<Location> location, Consumer<UncoveredRegions> uncoveredRegions, Consumer<LineReport> lineReport, Consumer<Tests> tests, Consumer<ShowDiffMessage> showDiffMessage, Consumer<NavigationRequested> navigationRequested, Consumer<TestFilterToggled> testFilterToggled, Consumer<Trace> trace, Consumer<Trace.TraceData> traceData, Consumer<TestStory> testStory, Consumer<TestStoryReset> testStoryReset, Consumer<TraceNavigationReset> traceNavigationReset, Consumer<TraceTestSelectionRequested> traceTestSelectionRequested, Consumer<TestFilterTestSelectionRequested> testFilterTestSelectionRequested, Consumer<WallabyAppUrl> wallabyAppUrlUpdated) {
    this.c = useWsl ? FileUtilRt.toSystemIndependentName(nodePath) : nodePath;
    this.d = nodeParams;
    this.e = workingDirectory;
    this.P = wallabyPath;
    this.f = projectCachePath;
    this.g = configPath;
    this.h = testsPaths;
    this.i = useConfigurationFile;
    this.j = lkp;
    this.Q = useWsl;
    this.k = onlineLicenseCheck;
    this.q.add(paramLive -> p());
    this.o.add(this::a);
    if (busy != null)
      this.m.add(busy); 
    if (documentUpdates != null)
      this.n.add(documentUpdates); 
    if (fileMessages != null)
      this.o.add(fileMessages); 
    if (filesToTrack != null)
      this.p.add(filesToTrack); 
    if (live != null)
      this.q.add(live); 
    if (location != null)
      this.s.add(location); 
    if (notification != null)
      this.t.add(notification); 
    if (projectConfigured != null)
      this.u.add(projectConfigured); 
    if (started != null)
      this.v.add(started); 
    if (stats != null)
      this.w.add(stats); 
    if (stopped != null)
      this.x.add(stopped); 
    if (uncoveredRegions != null)
      this.y.add(uncoveredRegions); 
    if (lineReport != null)
      this.z.add(lineReport); 
    if (tests != null)
      this.A.add(tests); 
    if (showDiffMessage != null)
      this.B.add(showDiffMessage); 
    if (navigationRequested != null)
      this.C.add(navigationRequested); 
    if (testFilterToggled != null)
      this.D.add(testFilterToggled); 
    if (trace != null)
      this.E.add(trace); 
    if (traceData != null)
      this.F.add(traceData); 
    if (testStory != null)
      this.G.add(testStory); 
    if (testStoryReset != null)
      this.I.add(testStoryReset); 
    if (traceNavigationReset != null)
      this.H.add(traceNavigationReset); 
    if (traceTestSelectionRequested != null)
      this.J.add(traceTestSelectionRequested); 
    if (testFilterTestSelectionRequested != null)
      this.K.add(testFilterTestSelectionRequested); 
    if (wallabyAppUrlUpdated != null)
      this.r.add(wallabyAppUrlUpdated); 
    GsonBuilder gsonBuilder1 = new GsonBuilder();
    gsonBuilder1.registerTypeAdapter(Notification.class, new c(null));
    gsonBuilder1.registerTypeAdapter(Stats.class, new e(null));
    gsonBuilder1.registerTypeAdapter(a.class, new a(null));
    gsonBuilder1.registerTypeAdapter(Location.class, new b(null));
    this.L = gsonBuilder1.create();
    this.M = (new GsonBuilder()).create();
    GsonBuilder gsonBuilder2 = new GsonBuilder();
    gsonBuilder2.registerTypeAdapter(StatsTrace.class, new f(null));
    this.S = gsonBuilder2.create();
    this.N = QueueProcessor.createRunnableQueueProcessor();
    this.O = QueueProcessor.createRunnableQueueProcessor();
  }
  
  private static int o() {
    try (ServerSocket null = new ServerSocket(0)) {
      serverSocket.setReuseAddress(true);
      int i = serverSocket.getLocalPort();
      try {
        serverSocket.close();
      } catch (IOException iOException) {}
      return i;
    } catch (IOException iOException) {
      throw new IllegalStateException("Could not find a free TCP/IP port to start wallaby server");
    } 
  }
  
  public OSProcessHandler a() {
    try {
      this.X = false;
      int i = o();
      GeneralCommandLine generalCommandLine = d(i);
      if (!StringUtil.isEmpty(a))
        generalCommandLine.getEnvironment().put("NODE_MODULES_OVERRIDE", a); 
      generalCommandLine.withCharset(StandardCharsets.UTF_8);
      a a = new a(this, generalCommandLine, true);
      ProcessTerminatedListener.attach((ProcessHandler)a);
      a.setShouldDestroyProcessRecursively(true);
      a.addProcessListener((ProcessListener)new b(this, i));
      return (OSProcessHandler)a;
    } catch (Exception exception) {
      a(this.t, new Notification("error", "Error starting wallaby.js server, " + exception.getMessage()));
      a(this.x, new Stopped());
      WallabyController.a.warn("Error starting wallaby.js server.", exception);
      return null;
    } 
  }
  
  private GeneralCommandLine d(int paramInt) throws Exception {
    String str6;
    String str7;
    String str1 = this.P;
    String str2 = this.c;
    String str3 = SystemProperties.getUserHome();
    String str4 = this.f;
    String str5 = this.j;
    try {
      str6 = Paths.get(this.g, new String[0]).toRealPath(new java.nio.file.LinkOption[0]).toString();
    } catch (Exception exception) {
      str6 = this.g;
    } 
    if (this.i) {
      str6 = FileUtilRt.toSystemDependentName(str6, FileSystems.getDefault().getSeparator().charAt(0));
    } else {
      str6 = FileUtilRt.toSystemDependentName(str6, FileSystems.getDefault().getSeparator().charAt(0)) + FileSystems.getDefault().getSeparator().charAt(0) + "auto.detect";
    } 
    try {
      str7 = Paths.get(this.e, new String[0]).toRealPath(new java.nio.file.LinkOption[0]).toString();
    } catch (Exception exception) {
      str7 = this.e;
    } 
    GeneralCommandLine generalCommandLine = new GeneralCommandLine();
    generalCommandLine.withWorkDirectory(str7);
    if (this.Q && SystemInfo.isWindows) {
      String str = System.getenv("SystemRoot") + "\\system32\\wsl.exe";
      if (!(new File(str)).exists())
        str = System.getenv("SystemRoot") + "\\sysnative\\wsl.exe"; 
      generalCommandLine.setExePath(str);
      a(generalCommandLine, "nodePath", str2);
      str1 = h(str1);
      str4 = h(str4) + "-wsl";
      str3 = h(str3);
      str6 = h(str6);
      str5 = h(str5);
    } else {
      generalCommandLine.setExePath(str2);
    } 
    for (String str : this.d) {
      if (str.indexOf(false) < 0 || str.length() != 1)
        a(generalCommandLine, "nodeParam", str); 
    } 
    a(generalCommandLine, "wallabyPath", str1);
    a(generalCommandLine, "extended-core-ws", "extended-core-ws");
    a(generalCommandLine, "projectCachePath", "--projectCachePath=" + str4);
    a(generalCommandLine, "configPath", "--configPath=" + str6);
    if (this.h != null && this.h.length > 0)
      for (String str : this.h)
        a(generalCommandLine, "testsPath", "--testsPath=" + str);  
    a(generalCommandLine, "lkp", "--lkp=" + str5);
    a(generalCommandLine, "client", "--client=IntelliJ");
    a(generalCommandLine, "editorTypeScript", "--editorTypeScript=undefined");
    a(generalCommandLine, "port", "--port=" + paramInt);
    a(generalCommandLine, "quokka", "--quokka=");
    a(generalCommandLine, "homeDir", "--homeDir=" + str3);
    a(generalCommandLine, "cv", "--cv=undefined");
    a(generalCommandLine, "ol", "--ol=" + (this.k ? "true" : "false"));
    return generalCommandLine;
  }
  
  private void a(GeneralCommandLine paramGeneralCommandLine, String paramString1, String paramString2) throws Exception {
    if (paramString2.indexOf(false) >= 0)
      throw new Exception(paramString1 + " contains a null character [" + StringUtil.replace(paramString2, "\000", "\\u0000") + "]"); 
    paramGeneralCommandLine.addParameter(paramString2);
  }
  
  private String h(String paramString) throws Exception {
    if (StringUtil.isEmpty(paramString))
      return paramString; 
    String str1 = System.getenv("SystemRoot") + "\\system32\\wsl.exe";
    if (!(new File(str1)).exists())
      str1 = System.getenv("SystemRoot") + "\\sysnative\\wsl.exe"; 
    paramString = paramString.replace('\\', '/');
    String str2 = str1 + " wslpath -a \"" + paramString + "\"";
    Process process = Runtime.getRuntime().exec(str2);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String str3 = bufferedReader.readLine();
    process.waitFor();
    return str3;
  }
  
  private void a(Runnable paramRunnable) {
    if (this.T)
      return; 
    Runnable runnable = () -> {
        if (this.T)
          return; 
        this.O.add(paramRunnable);
      };
    if (this.U == null || !this.U.f()) {
      this.l.add(runnable);
    } else if (!this.W) {
      this.R.add(runnable);
    } else {
      runnable.run();
    } 
  }
  
  private void p() {
    this.N.add(() -> {
          this.W = true;
          for (Runnable runnable : this.R)
            runnable.run(); 
          this.R.clear();
        });
  }
  
  private void a(int paramInt, String paramString) {
    try {
      this.U = new c(this, new URI("ws://" + paramString + ":" + paramInt), paramString, paramInt);
      this.V = new Thread(() -> {
            try {
              this.U.run();
            } catch (Exception exception) {
              WallabyController.a.warn(exception);
            } 
          });
      this.V.start();
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
    } 
  }
  
  private <T> void a(List<Consumer<T>> paramList, T paramT) {
    if (paramT != null)
      for (Consumer<T> consumer : paramList)
        consumer.consume(paramT);  
  }
  
  private void i(String paramString) {
    a(() -> this.U.b(paramString));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    i(this.M.toJson(new FileChangedInEditor(paramString1, paramString2, paramInt1, paramInt2)));
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfint, String paramString3) {
    i(this.M.toJson(new EvaluateExpressionInEditor(paramString1, paramString2, paramArrayOfint, paramString3)));
  }
  
  public void a(String paramString) {
    i(this.M.toJson(new FileOpenedInEditor(paramString)));
  }
  
  public void b(String paramString) {
    i(this.M.toJson(new FileClosedInAllEditors(paramString)));
  }
  
  private void a(a parama) {
    if (parama.b())
      return; 
    HashMap<Object, Object> hashMap = new HashMap<>();
    JsonObject jsonObject = this.Y;
    for (Map.Entry entry : jsonObject.entrySet()) {
      String[] arrayOfString = ((String)entry.getKey()).split(",");
      String str = arrayOfString[0];
      if (!hashMap.containsKey(str))
        hashMap.put(str, new ArrayList()); 
      ((ArrayList)hashMap.get(str)).add(entry.getKey());
    } 
    for (FileMessage fileMessage : parama.a()) {
      String str = fileMessage.b();
      hashMap.remove(str);
    } 
    for (ArrayList arrayList : hashMap.values()) {
      for (String str : arrayList)
        jsonObject.remove(str); 
    } 
  }
  
  public void a(String[] paramArrayOfString, com.wallaby.javascript.execution.b.d paramd, ExpressionLocation paramExpressionLocation) {
    JsonObject jsonObject1 = this.Y;
    for (String str : paramArrayOfString) {
      if (!jsonObject1.has(str))
        jsonObject1.add(str, (JsonElement)new JsonObject()); 
      jsonObject1 = jsonObject1.getAsJsonObject(str);
    } 
    if (paramd.a() != null)
      jsonObject1.addProperty("props", paramd.a()); 
    if (paramd.b() != null)
      jsonObject1.addProperty("strLength", paramd.b()); 
    JsonObject jsonObject2 = paramd.c();
    if (jsonObject2 != null)
      jsonObject1.add("ranges", (JsonElement)jsonObject2); 
    i(this.M.toJson(new ExpressionsToEvaluate(this.Y)));
    i(this.M.toJson(RunTests.a(paramExpressionLocation)));
  }
  
  public void a(ExpressionNode paramExpressionNode) {
    i(this.M.toJson(new CopyToClipboard(this.M.toJsonTree(paramExpressionNode))));
  }
  
  public void c(String paramString) {
    i(this.M.toJson(new CopyToClipboard(paramString)));
  }
  
  public void a(RunTests paramRunTests) {
    i(this.M.toJson(paramRunTests));
  }
  
  public void d(String paramString) {
    i(this.M.toJson(new GetFileMessages(paramString)));
  }
  
  public void b() {
    i(this.M.toJson(new ContinueTrial()));
  }
  
  public void dispose() {
    if (this.T)
      return; 
    this.T = true;
    this.l.clear();
    this.R.clear();
    this.N.clear();
    this.O.clear();
    try {
      this.U.p();
    } catch (Exception exception) {}
    if (this.V != null)
      this.V.interrupt(); 
  }
  
  public void a(String paramString, int paramInt) {
    i(this.M.toJson(new RequestLocation(paramString, paramInt, "failingTest")));
  }
  
  public void b(String paramString, int paramInt) {
    i(this.M.toJson(new RequestLocation(paramString, paramInt, "errorSource")));
  }
  
  public void a(String paramString1, String paramString2) {
    i(this.M.toJson(new RequestLocation(paramString1, paramString2, "unexecutedTest")));
  }
  
  public void c(String paramString, int paramInt) {
    i(this.M.toJson(new RequestUncoveredRegions(paramString, paramInt)));
  }
  
  public void e(String paramString) {
    i(this.M.toJson(new RequestUncoveredRegions(paramString)));
  }
  
  public void c() {
    i(this.M.toJson(new RequestTests()));
  }
  
  public void d(String paramString, int paramInt) {
    i(this.M.toJson(new RequestLineReport(paramString, paramInt)));
  }
  
  public void e(String paramString, int paramInt) {
    i(this.M.toJson(new FailingTest(paramString, paramInt)));
  }
  
  public void d() {
    i(this.M.toJson(new EditorData()));
  }
  
  public void e() {
    i(this.M.toJson(new RunMode("immediate")));
  }
  
  public void f() {
    i(this.M.toJson(new RunMode("onsave")));
  }
  
  public void f(String paramString) {
    i(this.M.toJson(new ToggleTestFilter(paramString)));
  }
  
  public void f(String paramString, int paramInt) {
    i(this.M.toJson(new ToggleTestFilter(paramString, paramInt)));
  }
  
  public void a(String paramString, Object[] paramArrayOfObject) {
    i(this.M.toJson(new ToggleTestFilter(paramString, paramArrayOfObject)));
  }
  
  public void g(String paramString) {
    i(this.M.toJson(new AddTestLocations(new String[] { paramString })));
  }
  
  public void a(String[] paramArrayOfString) {
    i(this.M.toJson(new AddTestLocations(paramArrayOfString)));
  }
  
  public void a(String paramString, int paramInt, Integer paramInteger) {
    i(this.M.toJson(new RequestTrace(paramString, paramInt, paramInteger, RequestTrace.StepDirection.Backward)));
  }
  
  public void b(String paramString, int paramInt, Integer paramInteger) {
    i(this.M.toJson(new RequestTrace(paramString, paramInt, paramInteger, RequestTrace.StepDirection.Forward)));
  }
  
  public void g() {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Into, RequestTrace.StepDirection.Forward)));
  }
  
  public void a(int paramInt) {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Into, RequestTrace.StepDirection.Forward, paramInt)));
  }
  
  public void h() {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Out, RequestTrace.StepDirection.Forward)));
  }
  
  public void i() {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Over, RequestTrace.StepDirection.Forward)));
  }
  
  public void j() {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Into, RequestTrace.StepDirection.Backward)));
  }
  
  public void k() {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Out, RequestTrace.StepDirection.Backward)));
  }
  
  public void l() {
    i(this.M.toJson(new RequestTrace(RequestTrace.StepType.Over, RequestTrace.StepDirection.Backward)));
  }
  
  public void m() {
    i(this.M.toJson(new TraceContext(Boolean.valueOf(true), null, null)));
  }
  
  public void b(int paramInt) {
    i(this.M.toJson(new TraceContext(Boolean.valueOf(false), Integer.valueOf(paramInt), null)));
    i(this.M.toJson(RunTests.a()));
  }
  
  public void c(int paramInt) {
    i(this.M.toJson(new TraceContext(Boolean.valueOf(false), null, Integer.valueOf(paramInt))));
  }
  
  public void a(Integer paramInteger, TestStory.TestStoryEntry paramTestStoryEntry) {
    i(this.M.toJson(new RequestTestStory(paramInteger, paramTestStoryEntry)));
  }
  
  public void a(LineLocation[] paramArrayOfLineLocation) {
    i(this.M.toJson(new RequestTrace(paramArrayOfLineLocation, RequestTrace.StepDirection.Forward)));
  }
  
  public void b(LineLocation[] paramArrayOfLineLocation) {
    i(this.M.toJson(new RequestTrace(paramArrayOfLineLocation, RequestTrace.StepDirection.Backward)));
  }
  
  public void a(String paramString, Integer paramInteger) {
    i(this.M.toJson(new RemoveLogs(paramString, paramInteger)));
  }
  
  private class f implements JsonDeserializer<StatsTrace> {
    private f(Client this$0) {}
    
    public StatsTrace a(JsonElement param1JsonElement, Type param1Type, JsonDeserializationContext param1JsonDeserializationContext) throws JsonParseException {
      StatsTrace statsTrace = new StatsTrace();
      if (param1JsonElement.getAsJsonObject().get("length") != null)
        statsTrace.a(param1JsonElement.getAsJsonObject().get("length").getAsInt()); 
      if (param1JsonElement.getAsJsonObject().get("currentFrame") != null)
        statsTrace.b(param1JsonElement.getAsJsonObject().get("currentFrame").getAsInt()); 
      if (param1JsonElement.getAsJsonObject().get("tests") != null) {
        JsonObject jsonObject = param1JsonElement.getAsJsonObject().get("tests").getAsJsonObject();
        ArrayList<TraceTest> arrayList = new ArrayList();
        for (Map.Entry entry : jsonObject.entrySet())
          arrayList.add(new TraceTest(((JsonElement)entry.getValue()).getAsJsonObject().get("name").getAsString(), ((JsonElement)entry.getValue()).getAsJsonObject().get("start").getAsInt())); 
        statsTrace.a(arrayList.<TraceTest>toArray(new TraceTest[arrayList.size()]));
      } 
      if (param1JsonElement.getAsJsonObject().get("files") != null) {
        JsonObject jsonObject = param1JsonElement.getAsJsonObject().get("files").getAsJsonObject();
        ArrayList<TraceFile> arrayList = new ArrayList();
        for (Map.Entry entry : jsonObject.entrySet())
          arrayList.add(new TraceFile(((JsonElement)entry.getValue()).getAsJsonObject().get("name").getAsString(), ((JsonElement)entry.getValue()).getAsJsonObject().get("start").getAsInt())); 
        statsTrace.a(arrayList.<TraceFile>toArray(new TraceFile[arrayList.size()]));
      } 
      if (param1JsonElement.getAsJsonObject().get("callStack") != null) {
        JsonObject jsonObject = param1JsonElement.getAsJsonObject().get("callStack").getAsJsonObject();
        ArrayList<TraceCallStack> arrayList = new ArrayList();
        for (Map.Entry entry : jsonObject.entrySet()) {
          TraceCallStack traceCallStack = new TraceCallStack(Integer.parseInt((String)entry.getKey()));
          arrayList.add(traceCallStack);
          JsonArray jsonArray = ((JsonElement)entry.getValue()).getAsJsonObject().get("stack").getAsJsonArray();
          for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject1 = jsonElement.getAsJsonObject();
            String str = (jsonObject1.get("context") != null) ? jsonObject1.get("context").getAsString() : "…";
            if (jsonObject1.get("range") != null && jsonObject1.get("frame") != null && jsonObject1.get("file") != null && jsonObject1.get("loc") != null) {
              String str1 = jsonObject1.get("file").getAsString();
              int i = jsonObject1.get("frame").getAsInt();
              ArrayList<Integer> arrayList1 = new ArrayList();
              ArrayList<Integer> arrayList2 = new ArrayList();
              for (JsonElement jsonElement1 : jsonObject1.get("range").getAsJsonArray())
                arrayList1.add(Integer.valueOf(jsonElement1.getAsInt())); 
              for (JsonElement jsonElement1 : jsonObject1.get("loc").getAsJsonArray())
                arrayList2.add(Integer.valueOf(jsonElement1.getAsInt())); 
              traceCallStack.a(str1, str, i, arrayList2.<Integer>toArray(new Integer[arrayList2.size()]), arrayList1.<Integer>toArray(new Integer[arrayList1.size()]));
            } 
          } 
        } 
        statsTrace.a(arrayList.<TraceCallStack>toArray(new TraceCallStack[arrayList.size()]));
      } 
      return statsTrace;
    }
  }
  
  private class b implements JsonDeserializer<Location> {
    private b(Client this$0) {}
    
    public Location a(JsonElement param1JsonElement, Type param1Type, JsonDeserializationContext param1JsonDeserializationContext) throws JsonParseException {
      if (param1JsonElement.getAsJsonObject().get("data") == null)
        return (Location)Client.G(this.a).fromJson(param1JsonElement, Location.class); 
      JsonObject jsonObject = param1JsonElement.getAsJsonObject().get("data").getAsJsonObject();
      JsonArray jsonArray = jsonObject.get("loc").getAsJsonArray();
      Location location = new Location();
      location.a(jsonObject.get("file").getAsString());
      location.a(jsonArray.get(0).getAsInt(), jsonArray.get(1).getAsInt());
      location.b(param1JsonElement.getAsJsonObject().get("id").getAsString());
      return location;
    }
  }
  
  private class a implements JsonDeserializer<a> {
    private a(Client this$0) {}
    
    public a a(JsonElement param1JsonElement, Type param1Type, JsonDeserializationContext param1JsonDeserializationContext) throws JsonParseException {
      a a1 = new a();
      JsonObject jsonObject1 = param1JsonElement.getAsJsonObject();
      a1.a((jsonObject1.get("specificFile") != null));
      JsonObject jsonObject2 = (jsonObject1.get("files") != null) ? jsonObject1.get("files").getAsJsonObject() : null;
      if (jsonObject2 != null)
        for (Map.Entry entry : jsonObject2.entrySet()) {
          FileMessage fileMessage = (FileMessage)Client.G(this.a).fromJson((JsonElement)entry.getValue(), FileMessage.class);
          if (fileMessage != null) {
            fileMessage.d();
            fileMessage.a((String)entry.getKey());
            a1.a(fileMessage);
          } 
        }  
      return a1;
    }
  }
  
  private class e implements JsonDeserializer<Stats> {
    private e(Client this$0) {}
    
    public Stats a(JsonElement param1JsonElement, Type param1Type, JsonDeserializationContext param1JsonDeserializationContext) throws JsonParseException {
      Stats stats = new Stats();
      if (param1JsonElement == null)
        return stats; 
      JsonElement jsonElement = param1JsonElement.getAsJsonObject().get("data");
      if (jsonElement == null) {
        stats.a();
        return stats;
      } 
      String str = jsonElement.isJsonPrimitive() ? jsonElement.getAsString() : null;
      if (str != null) {
        stats.a(str);
        return stats;
      } 
      return (Stats)Client.H(this.a).fromJson(jsonElement, Stats.class);
    }
  }
  
  private class c implements JsonDeserializer<Notification> {
    private c(Client this$0) {}
    
    public Notification a(JsonElement param1JsonElement, Type param1Type, JsonDeserializationContext param1JsonDeserializationContext) throws JsonParseException {
      JsonObject jsonObject = param1JsonElement.getAsJsonObject().getAsJsonObject("notification");
      return (jsonObject == null) ? new Notification() : (Notification)Client.G(this.a).fromJson((JsonElement)jsonObject, Notification.class);
    }
  }
  
  private class d extends b.b.a.b {
    d(Client this$0, URI param1URI) {
      super(param1URI);
    }
    
    public void a(h param1h) {
      Client.f(this.d).add(() -> {
            for (Runnable runnable : Client.F(this.d))
              runnable.run(); 
            Client.F(this.d).clear();
          });
    }
    
    public void a(String param1String) {
      try {
        Client.IncomingMessage incomingMessage = (Client.IncomingMessage)Client.g(this.d).fromJson(param1String, Client.IncomingMessage.class);
        String str = incomingMessage.a();
        if (!str.equals("busy"))
          WallabyController.a.debug("Server message received: " + str + ", message: " + param1String); 
        if (str.equals("ping"))
          return; 
        Client.f(this.d).add(() -> {
              try {
                if (Client.h(this.d))
                  return; 
                switch (param1String1) {
                  case "notification":
                    a(param1String2, Notification.class, Client.b(this.d));
                    break;
                  case "started":
                    a(param1String2, Started.class, Client.i(this.d));
                    break;
                  case "live":
                    a(param1String2, Live.class, Client.j(this.d));
                    break;
                  case "wallabyAppUrl":
                    a(param1String2, WallabyAppUrl.class, Client.k(this.d));
                    break;
                  case "busy":
                    a(param1String2, Busy.class, Client.l(this.d));
                    break;
                  case "documentUpdates":
                    a(param1String2, DocumentUpdates.class, Client.m(this.d));
                    break;
                  case "stats":
                    a(param1String2, Stats.class, Client.n(this.d));
                    break;
                  case "location":
                    a(param1String2, Location.class, Client.o(this.d));
                    break;
                  case "filesToTrack":
                    a(param1String2, FilesToTrack.class, Client.p(this.d));
                    break;
                  case "fileMessages":
                    a(param1String2, a.class, Client.q(this.d));
                    break;
                  case "projectConfigured":
                    a(param1String2, ProjectConfigured.class, Client.r(this.d));
                    break;
                  case "uncoveredRegions":
                    a(param1String2, UncoveredRegions.class, Client.s(this.d));
                    break;
                  case "lineReport":
                    a(param1String2, LineReport.class, Client.t(this.d));
                    break;
                  case "tests":
                    a(param1String2, Tests.class, Client.u(this.d));
                    break;
                  case "error":
                    a(param1String2, ShowDiffMessage.class, Client.v(this.d));
                    break;
                  case "navigationRequested":
                    a(param1String2, NavigationRequested.class, Client.w(this.d));
                    break;
                  case "testFilterToggled":
                    a(param1String2, TestFilterToggled.class, Client.x(this.d));
                    break;
                  case "stopped":
                    this.d.dispose();
                    a(param1String2, Stopped.class, Client.d(this.d));
                    break;
                  case "trace":
                    a(param1String2, Trace.class, Client.y(this.d));
                    break;
                  case "testTimeline":
                    a(param1String2, TestStory.class, Client.z(this.d));
                    break;
                  case "testTimelineReset":
                    a(param1String2, TestStoryReset.class, Client.A(this.d));
                    break;
                  case "traceNavigated":
                    a(param1String2, Trace.TraceData.class, Client.B(this.d));
                    break;
                  case "traceNavigationReset":
                    a(param1String2, TraceNavigationReset.class, Client.C(this.d));
                    break;
                  case "traceTestSelectionRequested":
                    a(param1String2, TraceTestSelectionRequested.class, Client.D(this.d));
                    break;
                  case "testFilterTestSelectionRequested":
                    a(param1String2, TestFilterTestSelectionRequested.class, Client.E(this.d));
                    break;
                } 
              } catch (Exception exception) {
                WallabyController.a.warn(exception);
                Notification notification = new Notification("error", "An error occurred while processing Wallaby output.");
                for (Consumer consumer : Client.b(this.d))
                  consumer.consume(notification); 
              } 
            });
      } catch (Exception exception) {
        WallabyController.a.warn(exception);
      } 
    }
    
    private <T> void a(String param1String, Class<T> param1Class, List<Consumer<T>> param1List) {
      Object object = null;
      try {
        object = Client.g(this.d).fromJson(param1String, param1Class);
      } catch (Exception exception) {
        WallabyController.a.warn("Error deserializing " + param1Class.getName() + ", " + param1String);
        WallabyController.a.warn(exception);
      } 
      if (object != null)
        for (Consumer<T> consumer : param1List)
          consumer.consume(object);  
    }
    
    public void a(int param1Int, String param1String, boolean param1Boolean) {}
    
    public void a(Exception param1Exception) {
      WallabyController.a.error(param1Exception);
    }
  }
  
  private static class IncomingMessage {
    private String type;
    
    String a() {
      return this.type;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */