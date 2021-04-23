package com.wallaby.javascript;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.intellij.codeInsight.highlighting.HighlightManager;
import com.intellij.codeInsight.hint.HintUtil;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.IntentionManager;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionManager;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.icons.AllIcons;
import com.intellij.ide.DataManager;
import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.NotificationsConfiguration;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.AbbreviationManager;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.event.SelectionEvent;
import com.intellij.openapi.editor.ex.DocumentEx;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.impl.DocumentMarkupModel;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.fileEditor.impl.EditorWithProviderComposite;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.popup.IconButton;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.JBPopupListener;
import com.intellij.openapi.ui.popup.LightweightWindowEvent;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.ShutDownTracker;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.io.FileUtilRt;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.IdeFocusManager;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.ui.AppIcon;
import com.intellij.ui.ColorUtil;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.intellij.ui.LightColors;
import com.intellij.util.Consumer;
import com.intellij.util.SystemProperties;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.ui.UIUtil;
import com.intellij.xdebugger.ui.DebuggerColors;
import com.intellij.xml.util.XmlStringUtil;
import com.wallaby.javascript.actions.AddTestToFilterIntentionAction;
import com.wallaby.javascript.actions.ClearFileValuesIntentionAction;
import com.wallaby.javascript.actions.ClearValueIntentionAction;
import com.wallaby.javascript.actions.CopyValueIntentionAction;
import com.wallaby.javascript.actions.DebugStartIntentionAction;
import com.wallaby.javascript.actions.HideTestStoryFragmentsIntentionAction;
import com.wallaby.javascript.actions.JumpToErrorSourceIntentionAction;
import com.wallaby.javascript.actions.JumpToFailingTestIntentionAction;
import com.wallaby.javascript.actions.JumpToOriginalLocationIntentionAction;
import com.wallaby.javascript.actions.OpenTestStoryIntentionAction;
import com.wallaby.javascript.actions.ProfileTestIntentionAction;
import com.wallaby.javascript.actions.RemoveTestFromFilterIntentionAction;
import com.wallaby.javascript.actions.RevealValueIntentionAction;
import com.wallaby.javascript.actions.RunAllTestsIntentionAction;
import com.wallaby.javascript.actions.RunTestFileIntentionAction;
import com.wallaby.javascript.actions.RunTestIntentionAction;
import com.wallaby.javascript.actions.ShowAssertionErrorDiffIntentionAction;
import com.wallaby.javascript.actions.ShowFileUncoveredRangesIntentionAction;
import com.wallaby.javascript.actions.ShowLastRunScreenShotIntentionAction;
import com.wallaby.javascript.actions.ShowLineTestsIntentionAction;
import com.wallaby.javascript.actions.ShowLineUncoveredRangesIntentionAction;
import com.wallaby.javascript.actions.ShowValueIntentionAction;
import com.wallaby.javascript.actions.UpdateFileSnapshotsIntentionAction;
import com.wallaby.javascript.actions.UpdateProjectSnapshotsIntentionAction;
import com.wallaby.javascript.actions.UpdateTestSnapshotsIntentionAction;
import com.wallaby.javascript.actions.j;
import com.wallaby.javascript.b.a;
import com.wallaby.javascript.d.a;
import com.wallaby.javascript.editor.TestStoryLinePainter;
import com.wallaby.javascript.editor.WallabyLinePainter;
import com.wallaby.javascript.execution.b.d;
import com.wallaby.javascript.execution.testStory.g;
import com.wallaby.javascript.execution.testStory.o;
import com.wallaby.javascript.extendedCore.Client;
import com.wallaby.javascript.extendedCore.inboundMessages.Busy;
import com.wallaby.javascript.extendedCore.inboundMessages.DocumentUpdate;
import com.wallaby.javascript.extendedCore.inboundMessages.DocumentUpdates;
import com.wallaby.javascript.extendedCore.inboundMessages.ErrorEntry;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLocation;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionNode;
import com.wallaby.javascript.extendedCore.inboundMessages.FilesToTrack;
import com.wallaby.javascript.extendedCore.inboundMessages.LineData;
import com.wallaby.javascript.extendedCore.inboundMessages.LineReport;
import com.wallaby.javascript.extendedCore.inboundMessages.Live;
import com.wallaby.javascript.extendedCore.inboundMessages.Location;
import com.wallaby.javascript.extendedCore.inboundMessages.NavigationRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.Notification;
import com.wallaby.javascript.extendedCore.inboundMessages.ProjectConfigured;
import com.wallaby.javascript.extendedCore.inboundMessages.ShowDiffMessage;
import com.wallaby.javascript.extendedCore.inboundMessages.Started;
import com.wallaby.javascript.extendedCore.inboundMessages.Stats;
import com.wallaby.javascript.extendedCore.inboundMessages.Stopped;
import com.wallaby.javascript.extendedCore.inboundMessages.Test;
import com.wallaby.javascript.extendedCore.inboundMessages.TestEntry;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterTestSelectionRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.TestFilterToggled;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStoryReset;
import com.wallaby.javascript.extendedCore.inboundMessages.Tests;
import com.wallaby.javascript.extendedCore.inboundMessages.Trace;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceNavigationReset;
import com.wallaby.javascript.extendedCore.inboundMessages.TraceTestSelectionRequested;
import com.wallaby.javascript.extendedCore.inboundMessages.UncoveredRegions;
import com.wallaby.javascript.extendedCore.inboundMessages.WallabyAppUrl;
import com.wallaby.javascript.extendedCore.inboundMessages.a;
import com.wallaby.javascript.extendedCore.outboundMessages.FileChangedInEditor;
import com.wallaby.javascript.extendedCore.outboundMessages.LineLocation;
import com.wallaby.javascript.extendedCore.outboundMessages.RunTests;
import com.wallaby.javascript.settings.WallabyColorSettingsPage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;

public class WallabyController implements Disposable, ProjectComponent, m {
  public static final Logger a = Logger.getInstance("Wallaby");
  
  private static boolean f = false;
  
  private static final NotificationGroup g = new NotificationGroup(k.a("notifications.extendedCore.name", new Object[0]), NotificationDisplayType.STICKY_BALLOON, true);
  
  private static final NotificationGroup h = new NotificationGroup(k.a("notifications.license.expired.group.name", new Object[0]), NotificationDisplayType.STICKY_BALLOON, true);
  
  private static final NotificationGroup i = new NotificationGroup(k.a("notifications.license.expiring.group.name", new Object[0]), NotificationDisplayType.STICKY_BALLOON, true);
  
  private static final String j = "https://activate";
  
  private static final String k = "https://continue";
  
  private static final String l = "https://mute";
  
  private static final int m = 5000;
  
  private w n;
  
  private Project o;
  
  private ProcessHandler p;
  
  private ProcessHandler q;
  
  private t r;
  
  private String s = null;
  
  private static final Key<WallabyController> t = new Key("WallabyControllerKey");
  
  private Client u;
  
  private Client v = null;
  
  private Stats w;
  
  private ConcurrentHashMap<String, String> x;
  
  private HashSet<Notification> y;
  
  private File z = new File(PathManager.getSystemPath() + File.separator + "wallaby");
  
  private WallabyDependencies A;
  
  private volatile ConcurrentHashMap<String, b> B;
  
  private a C;
  
  private z D;
  
  private boolean E = false;
  
  private String F = null;
  
  private Integer G = null;
  
  private boolean H = false;
  
  private static boolean I = false;
  
  private boolean J = false;
  
  private Editor K;
  
  public static final boolean b = (System.getProperty("WallabyNoUpdate") != null);
  
  private AnActionEvent L;
  
  private int M;
  
  private boolean N = false;
  
  private int O = 0;
  
  private ArrayList<FileChangedInEditor> P;
  
  Collection<Pair<Editor, RangeHighlighter>> c = new ArrayList<>();
  
  Collection<Pair<Editor, RangeHighlighter>> d = new ArrayList<>();
  
  Collection<Pair<MarkupModel, RangeHighlighter>> e = new ArrayList<>();
  
  private boolean Q = false;
  
  private Trace.TraceData R = null;
  
  private Editor S = null;
  
  private Consumer<Test[]> T;
  
  private Consumer<o> U;
  
  private o V;
  
  private Consumer<TestFilterTestSelectionRequested.Test[]> W;
  
  private Runnable X;
  
  private int[] Y = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
  
  private boolean Z;
  
  protected WallabyController(Project project) {
    this.o = project;
    try {
      ShutDownTracker.getInstance().registerShutdownTask(() -> {
            try {
              if (this.p != null)
                this.p.destroyProcess(); 
            } catch (Exception exception) {}
            try {
              if (this.q != null)
                this.q.destroyProcess(); 
            } catch (Exception exception) {}
          });
    } catch (Exception exception) {}
  }
  
  public boolean a(v paramv) {
    try {
      return (this.Y[0] >= paramv.a() && this.Y[1] >= paramv.b() && this.Y[2] >= paramv.c());
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public static WallabyController a(Project paramProject) {
    return (paramProject == null) ? null : (WallabyController)paramProject.getComponent(WallabyController.class);
  }
  
  public void initComponent() {
    FileUtilRt.createDirectory(this.z);
    aa();
    Z();
    this.A = new WallabyDependencies(this.o, this.z);
    j(this.A.b());
    Y();
    if (!f) {
      f = true;
      EditorActionManager editorActionManager = EditorActionManager.getInstance();
      EditorActionHandler editorActionHandler = editorActionManager.getActionHandler("EditorEscape");
      editorActionManager.setActionHandler("EditorEscape", new a(editorActionHandler, null));
    } 
  }
  
  public void disposeComponent() {}
  
  public String getComponentName() {
    return "Wallaby.js";
  }
  
  private void W() {
    X();
    StatusBar statusBar = WindowManager.getInstance().getStatusBar(this.o);
    if (statusBar != null) {
      this.n = new w(this);
      statusBar.addWidget((StatusBarWidget)this.n, "after ReadOnlyAttribute", (Disposable)this.o);
    } 
  }
  
  private void X() {
    StatusBar statusBar = WindowManager.getInstance().getStatusBar(this.o);
    if (statusBar != null && this.n != null) {
      statusBar.removeWidget(this.n.ID());
      this.n = null;
    } 
  }
  
  private void Y() {
    try {
      Runnable runnable = () -> {
          try {
            f.a.a();
            if (this.B != null)
              for (b b : this.B.values())
                b.b();  
          } catch (Exception exception) {
            a.warn(exception);
          } 
          try {
            TestStoryLinePainter.a();
            WallabyLinePainter.a();
          } catch (Exception exception) {
            a.warn(exception);
          } 
        };
      ApplicationManager.getApplication().getMessageBus().connect(this).subscribe(WallabyColorSettingsPage.a, runnable::run);
      EditorColorsManager.getInstance();
      ApplicationManager.getApplication().getMessageBus().connect(this).subscribe(EditorColorsManager.TOPIC, paramEditorColorsScheme -> paramRunnable.run());
    } catch (Exception exception) {
      a.warn(exception);
    } 
  }
  
  private void a(IntentionAction paramIntentionAction, String paramString) {
    IntentionManager intentionManager = IntentionManager.getInstance();
    if (!ContainerUtil.exists((Object[])intentionManager.getIntentionActions(), paramIntentionAction2 -> paramIntentionAction2.getClass().equals(paramIntentionAction1.getClass())))
      intentionManager.registerIntentionAndMetaData(paramIntentionAction, new String[] { paramString }); 
  }
  
  private void Z() {
    String str = k.a("intention.action.category", new Object[0]);
    a((IntentionAction)new ShowLineTestsIntentionAction(), str);
    a((IntentionAction)new RunTestIntentionAction(), str);
    a((IntentionAction)new RunTestFileIntentionAction(), str);
    a((IntentionAction)new RunAllTestsIntentionAction(), str);
    a((IntentionAction)new ShowValueIntentionAction(), str);
    a((IntentionAction)new CopyValueIntentionAction(), str);
    a((IntentionAction)new ShowLineUncoveredRangesIntentionAction(), str);
    a((IntentionAction)new ShowFileUncoveredRangesIntentionAction(), str);
    a((IntentionAction)new ShowLastRunScreenShotIntentionAction(), str);
    a((IntentionAction)new JumpToFailingTestIntentionAction(), str);
    a((IntentionAction)new JumpToErrorSourceIntentionAction(), str);
    a((IntentionAction)new ShowAssertionErrorDiffIntentionAction(), str);
    a((IntentionAction)new UpdateProjectSnapshotsIntentionAction(), str);
    a((IntentionAction)new UpdateFileSnapshotsIntentionAction(), str);
    a((IntentionAction)new UpdateTestSnapshotsIntentionAction(), str);
    a((IntentionAction)new AddTestToFilterIntentionAction(), str);
    a((IntentionAction)new RemoveTestFromFilterIntentionAction(), str);
    a((IntentionAction)new DebugStartIntentionAction(), str);
    a((IntentionAction)new ProfileTestIntentionAction(), str);
    a((IntentionAction)new RevealValueIntentionAction(), str);
    a((IntentionAction)new JumpToOriginalLocationIntentionAction(), str);
    a((IntentionAction)new HideTestStoryFragmentsIntentionAction(), str);
    a((IntentionAction)new OpenTestStoryIntentionAction(), str);
    a((IntentionAction)new ClearValueIntentionAction(), str);
    a((IntentionAction)new ClearFileValuesIntentionAction(), str);
  }
  
  private void aa() {
    try {
      Set set = AbbreviationManager.getInstance().getAbbreviations();
      String str = "w";
      if (set.contains(str))
        str = "wallaby"; 
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowLineTestsAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowValueAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.CopyValueAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.RunTestAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.RunTestFileAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.RunAllTestsAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowLineUncoveredRangesAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowFileUncoveredRangesAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowLastRunScreenShotAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.UpdateProjectSnapshotsAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.UpdateFileSnapshotsAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.UpdateTestSnapshotsAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ToggleTestFilterAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ResetTestFilterAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.DebugRevealTraceStepAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.DebugStartAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ProfileTestAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.OpenTestStoryAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.UnlockTestStoryAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.LockTestStoryAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.LoadStartOfTruncatedTestStoryAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.LoadEndOfTruncatedTestStoryAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.DebugStopAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceBackwardToSelectionAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceForwardToSelectionAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceBackwardToBreakpointAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceForwardToBreakpointAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceNextStepAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceNextStepOutAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTraceNextStepOverAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTracePrevStepAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTracePrevStepOutAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.PlayTracePrevStepOverAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.JumpToTestAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.StartExclusiveTestRunAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.AddToExclusiveTestRunAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.JumpToFailingTestAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.JumpToErrorSourceAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowAssertionErrorDiffAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.CopyDiagnosticsReport");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ShowLicenseAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ClearValueAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ClearFileValuesAction");
      AbbreviationManager.getInstance().register(str, "com.wallaby.javascript.actions.ClearAllValuesAction");
    } catch (Exception exception) {
      a.error("An error occurred setting up Abbreviations");
      a.error(exception);
      a(g, NotificationType.ERROR, "Error initializing Wallaby Plugin", exception.getMessage());
    } 
  }
  
  private String b(a parama) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(parama.b().getPath().getBytes(StandardCharsets.UTF_8));
      byte[] arrayOfByte = messageDigest.digest();
      BigInteger bigInteger = new BigInteger(1, arrayOfByte);
      StringBuilder stringBuilder = new StringBuilder(bigInteger.toString(16).substring(0, 16));
      while (stringBuilder.length() < 16)
        stringBuilder.insert(0, "0"); 
      return stringBuilder.toString();
    } catch (Exception exception) {
      return this.o.getName() + "_" + parama.b().getNameWithoutExtension();
    } 
  }
  
  public void k() {
    a a1 = new a();
    g g = a1.b();
    String str1 = a1.c();
    String str2 = g.c() ? g.k() : "";
    Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,63}$");
    JPanel jPanel = new JPanel(new BorderLayout());
    jPanel.setPreferredSize(new Dimension(400, 330));
    jPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 1, 5));
    JBPopup jBPopup = JBPopupFactory.getInstance().createComponentPopupBuilder(jPanel, null).setCancelOnClickOutside(false).setCancelKeyEnabled(true).setModalContext(true).setRequestFocus(true).setResizable(true).setMovable(true).setCancelButton(new IconButton("Close", AllIcons.Actions.Close, AllIcons.Actions.CloseHovered)).setTitle(k.a("notifications.license.title", new Object[0])).createPopup();
    JTextArea jTextArea = new JTextArea();
    jTextArea.setLineWrap(true);
    jTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(UIUtil.isUnderDarcula() ? (Color)new JBColor(Gray._135.brighter(), (Color)Gray._75) : (Color)Gray._135), BorderFactory.createEmptyBorder(2, 5, 2, 5)));
    jPanel.add(jTextArea, "Center");
    JLabel jLabel = new JLabel();
    jLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
    jPanel.add(jLabel, "North");
    JButton jButton = new JButton(k.a("notifications.license.activate.title", new Object[0]));
    jPanel.add(jButton, "South");
    if (str1.length() > 0) {
      jTextArea.setText(str1);
      jButton.setEnabled(true);
    } else {
      jTextArea.setText(str2);
    } 
    Consumer consumer1 = paramg -> {
        if (paramg.c()) {
          paramJButton.setEnabled(true);
          paramJLabel.setText(String.format("<html>Registered to <b>%s</b><br/>Free upgrades until <b>%s</b></html>", new Object[] { paramg.h(), paramg.i() }));
        } else if (paramg.b()) {
          paramJButton.setEnabled(false);
          paramJLabel.setText("<html>This license key cannot be used with this version of the Wallaby.js IntelliJ Plugin; you must downgrade to an earlier version.</html>");
        } else {
          paramJButton.setEnabled(false);
          paramJLabel.setText("<html>&nbsp;<br/>&nbsp;</html>");
        } 
      };
    Consumer consumer2 = paramg -> {
        if (paramg.c() && paramg.g()) {
          File file1 = new File(SystemProperties.getUserHome() + File.separator + ".quokka");
          File file2 = new File(file1 + File.separator + ".qlc");
          FileUtilRt.createDirectory(file1);
          try {
            FileUtil.writeToFile(file2, paramg.k());
          } catch (IOException iOException) {
            a.warn(iOException);
          } 
          JsonParser jsonParser = new JsonParser();
          File file3 = new File(file1 + File.separator + "config.json");
          try {
            JsonElement jsonElement = jsonParser.parse(StringUtil.join(FileUtilRt.loadLines(file3), ""));
            jsonElement.getAsJsonObject().addProperty("pro", Boolean.valueOf(true));
            FileUtil.writeToFile(file3, jsonElement.toString());
          } catch (Exception exception) {
            a.debug("Creating a new quokka config file");
            try {
              FileUtil.writeToFile(file3, "{\"pro\":true}");
            } catch (IOException iOException) {
              a.warn(iOException);
            } 
          } 
        } 
      };
    Runnable runnable = () -> {
        if (paramPattern.matcher(paramJTextArea.getText()).matches()) {
          paramJButton.setEnabled(true);
          paramJLabel.setText(String.format("<html>Registered to <b>%s</b><br/>Expiry date will be updated after activation.</html>", new Object[] { paramJTextArea.getText() }));
        } else {
          g g = parama.a(paramJTextArea.getText());
          if (g.c())
            parama.b(g.k()); 
          paramConsumer1.consume(g);
          paramConsumer2.consume(g);
        } 
      };
    jButton.addActionListener(paramActionEvent -> {
          paramRunnable.run();
          if (paramString1.length() == 0 && paramString2.equals(paramJTextArea.getText())) {
            paramJBPopup.closeOk(null);
            return;
          } 
          if (paramPattern.matcher(paramJTextArea.getText()).matches()) {
            parama.c(paramJTextArea.getText());
            if (this.v != null) {
              this.v.dispose();
              this.v = null;
            } 
            try {
              if (this.q != null) {
                this.q.destroyProcess();
                this.q = null;
              } 
            } catch (Exception exception) {}
            File file = new File(a.c.getPath());
            if (this.A.a()) {
              this.v = new Client("node", this.A.d(), file.getParent(), this.A.e(), file.getParent(), file.getParent(), null, false, a.c.getPath(), false, true, (), (), this::a, (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), (), ());
              this.q = (ProcessHandler)this.v.a();
              this.q.startNotify();
            } 
            paramJBPopup.closeOk(null);
          } else {
            parama.c("");
            g g = parama.b();
            if (!paramString2.equals(g.k()) && g.c()) {
              a(true);
              a(g, NotificationType.INFORMATION, k.a("notifications.license.title", new Object[0]), k.a("notifications.license.activated", new Object[] { g.h(), g.i() }));
              paramJBPopup.closeOk(null);
            } 
          } 
        });
    jBPopup.addListener(new n(this, jBPopup));
    if (pattern.matcher(jTextArea.getText()).matches() && !g.c()) {
      jButton.setEnabled(true);
      jLabel.setText(String.format("<html>Registered to <b>%s</b><br/>Expiry date will be updated after activation.</html>", new Object[] { jTextArea.getText() }));
    } else {
      consumer1.consume(g);
    } 
    jTextArea.getDocument().addDocumentListener((DocumentListener)new o(this, runnable));
    jBPopup.showCenteredInCurrentWindow(this.o);
    IdeFocusManager.getInstance(this.o).requestFocus(jTextArea, true);
  }
  
  public void l() {
    if (!this.H)
      return; 
    this.u.d();
  }
  
  public void m() {
    if (!this.H)
      return; 
    this.u.f();
  }
  
  public void n() {
    if (!this.H)
      return; 
    this.u.e();
  }
  
  public void a(String[] paramArrayOfString, d paramd, ExpressionLocation paramExpressionLocation) {
    if (!this.H)
      return; 
    this.u.a(paramArrayOfString, paramd, paramExpressionLocation);
  }
  
  public void a(String paramString) {
    if (!this.H)
      return; 
    this.u.c(paramString);
  }
  
  public void a(ExpressionNode paramExpressionNode) {
    if (!this.H)
      return; 
    this.u.a(paramExpressionNode);
  }
  
  public b a(Editor paramEditor) {
    VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(paramEditor.getDocument());
    return (virtualFile == null) ? null : a(virtualFile);
  }
  
  public b a(VirtualFile paramVirtualFile) {
    return (this.B == null) ? null : this.B.get(paramVirtualFile.getPath());
  }
  
  public void a(VirtualFile paramVirtualFile, String paramString, int paramInt1, int paramInt2) {
    String str = this.C.a(paramVirtualFile.getPath());
    if (!this.H) {
      this.P.add(new FileChangedInEditor(str, paramString, paramInt1, paramInt2));
      return;
    } 
    ab();
    this.u.a(str, paramString, paramInt1, paramInt2);
  }
  
  private void ab() {
    Collection<Pair<Editor, RangeHighlighter>> collection = this.c;
    this.c = new ArrayList<>();
    ApplicationManager.getApplication().invokeLater(() -> a(paramCollection));
  }
  
  private void a(Collection<Pair<Editor, RangeHighlighter>> paramCollection) {
    if (this.o == null || this.o.isDisposed())
      return; 
    HighlightManager highlightManager = HighlightManager.getInstance(this.o);
    for (Pair<Editor, RangeHighlighter> pair : paramCollection) {
      if (!((Editor)pair.first).isDisposed())
        highlightManager.removeSegmentHighlighter((Editor)pair.first, (RangeHighlighter)pair.second); 
    } 
  }
  
  public VirtualFile b(String paramString) {
    String str = this.C.b(paramString);
    return LocalFileSystem.getInstance().findFileByPath(str);
  }
  
  public void c(String paramString) {
    if (!this.H)
      return; 
    this.u.d(paramString);
  }
  
  public void o() {
    if (!this.H)
      return; 
    this.N = true;
    FileDocumentManager.getInstance().saveAllDocuments();
    this.u.a(new RunTests());
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.N = true;
    FileDocumentManager.getInstance().saveAllDocuments();
    this.u.a(new RunTests(str, paramInt, false, paramBoolean));
  }
  
  public void d(String paramString) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.N = true;
    FileDocumentManager.getInstance().saveAllDocuments();
    this.u.a(new RunTests(str));
  }
  
  public void a(String paramString, int paramInt) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.a(str, paramInt);
  }
  
  public void a(String paramString1, String paramString2) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString1);
    this.u.a(str, paramString2);
  }
  
  public boolean b(String paramString, int paramInt) {
    if (this.w == null)
      return false; 
    if (this.B == null)
      return false; 
    b b = this.B.get(paramString);
    if (b == null)
      return false; 
    f f = b.b(paramInt - 1);
    return (f == null) ? false : ((f.a() != CoverageState.NOT_COVERED));
  }
  
  public boolean c(String paramString, int paramInt) {
    if (this.w == null)
      return false; 
    String str = this.C.a(paramString);
    for (TestEntry testEntry : this.w.k()) {
      if (testEntry.a().equals(str) && (testEntry.e()).length > 0)
        return true; 
    } 
    return false;
  }
  
  public void d(String paramString, int paramInt) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.b(str, paramInt);
  }
  
  public boolean e(String paramString, int paramInt) {
    return c(paramString, paramInt);
  }
  
  public void a(b paramb, int[] paramArrayOfint, String paramString) {
    if (!this.H)
      return; 
    String str = this.C.a(paramb.d());
    this.u.a(str, paramb.f(), paramArrayOfint, paramString);
  }
  
  public void f(String paramString, int paramInt) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.c(str, paramInt);
  }
  
  public void e(String paramString) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.e(str);
  }
  
  public void a(Consumer<Test[]> paramConsumer) {
    if (!this.H)
      return; 
    if (this.w == null)
      return; 
    this.T = paramConsumer;
    this.u.c();
  }
  
  public void a(Integer paramInteger, TestStory.TestStoryEntry paramTestStoryEntry, Consumer<o> paramConsumer) {
    if (!this.H)
      return; 
    this.U = paramConsumer;
    this.u.a(paramInteger, paramTestStoryEntry);
  }
  
  public o p() {
    return this.V;
  }
  
  public boolean s() {
    return (p() != null);
  }
  
  public boolean t() {
    o o1 = p();
    return (o1 == null) ? false : o1.l();
  }
  
  public void q() {
    o o1 = p();
    if (o1 == null)
      return; 
    o1.m();
    b(true);
  }
  
  public void r() {
    o o1 = p();
    if (o1 == null)
      return; 
    a((Integer)null, (TestStory.TestStoryEntry)null, (Consumer<o>)null);
  }
  
  public void a(String paramString, int paramInt, Editor paramEditor, AnActionEvent paramAnActionEvent) {
    if (!this.H)
      return; 
    this.K = paramEditor;
    this.L = paramAnActionEvent;
    String str = this.C.a(paramString);
    this.u.d(str, paramInt);
  }
  
  public void g(String paramString, int paramInt) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.e(str, paramInt);
  }
  
  public boolean h(String paramString, int paramInt) {
    if (this.w == null)
      return false; 
    String str = this.C.a(paramString);
    for (TestEntry testEntry : this.w.k()) {
      if (testEntry.a().equals(str))
        for (ErrorEntry errorEntry : testEntry.e()) {
          String str1 = errorEntry.d();
          String str2 = errorEntry.b();
          if (!StringUtil.notNullize(str1).isEmpty() && !StringUtil.notNullize(str2).isEmpty())
            return true; 
        }  
    } 
    return false;
  }
  
  public boolean u() {
    if (this.w == null)
      return false; 
    for (TestEntry testEntry : this.w.k()) {
      for (ErrorEntry errorEntry : testEntry.e()) {
        if (errorEntry.c())
          return true; 
      } 
    } 
    return false;
  }
  
  public boolean f(String paramString) {
    if (this.w == null)
      return false; 
    String str = this.C.a(paramString);
    for (TestEntry testEntry : this.w.k()) {
      if (testEntry.a().equals(str))
        for (ErrorEntry errorEntry : testEntry.e()) {
          if (errorEntry.c())
            return true; 
        }  
    } 
    for (ErrorEntry errorEntry : this.w.j()) {
      if (errorEntry.c())
        return true; 
    } 
    return false;
  }
  
  public boolean i(String paramString, int paramInt) {
    return f(paramString);
  }
  
  public void g(String paramString) {
    this.W = null;
    if (!this.H)
      return; 
    this.u.f(StringUtil.isEmptyOrSpaces(paramString) ? null : this.C.a(paramString));
  }
  
  public void a(String paramString, int paramInt, Consumer<TestFilterTestSelectionRequested.Test[]> paramConsumer) {
    if (!this.H)
      return; 
    this.W = paramConsumer;
    this.u.f(this.C.a(paramString), paramInt);
  }
  
  public void a(String paramString, Object[] paramArrayOfObject) {
    this.W = null;
    if (!this.H)
      return; 
    this.u.a(this.C.a(paramString), paramArrayOfObject);
  }
  
  public void h(String paramString) {
    if (!this.H)
      return; 
    this.u.g(this.C.a(paramString));
  }
  
  public void a(String[] paramArrayOfString) {
    if (!this.H)
      return; 
    this.u.a((String[])ContainerUtil.map((Object[])paramArrayOfString, paramString -> this.C.a(paramString)).toArray((Object[])new String[paramArrayOfString.length]));
  }
  
  public void j(String paramString, int paramInt) {
    if (this.D == null)
      return; 
    String str = this.C.a(paramString);
    this.D.a(str, paramInt);
  }
  
  public String v() {
    return !h() ? "https://wallabyjs.com/app/" : ((this.G != null && this.G.intValue() != 0) ? (this.F + "?port=" + this.G.intValue()) : this.F);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int[] paramArrayOfint) {
    if (!this.H)
      return; 
    b(false);
    a(paramInt1, paramString, paramInt2, paramInt3, paramArrayOfint, false, true, false, true);
    this.u.c(paramInt1);
  }
  
  public boolean w() {
    return (this.H && this.Q && this.R != null && a(v.a));
  }
  
  public void x() {
    if (this.H && this.Q && this.R != null)
      a(this.R.b()); 
  }
  
  public boolean y() {
    return !a(v.a) ? false : ((this.H && !this.Q));
  }
  
  public void a(Editor paramEditor, String paramString, int paramInt, Runnable paramRunnable) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.S = paramEditor;
    this.X = paramRunnable;
    this.u.a(new RunTests(str, paramInt, true, null));
  }
  
  public boolean z() {
    return (this.H && this.Q);
  }
  
  public void A() {
    if (!this.H)
      return; 
    this.u.m();
    this.D.a();
    this.Q = false;
    this.R = null;
    this.S = null;
    this.X = null;
    b(false);
    ac();
  }
  
  public boolean T() {
    return this.Z;
  }
  
  public boolean U() {
    return !a(v.g) ? false : ((T() && this.H && !this.Q));
  }
  
  public void k(String paramString, int paramInt) {
    if (!U())
      return; 
    String str = this.C.a(paramString);
    this.u.a(new RunTests(str, paramInt, true, false));
  }
  
  private void ac() {
    this.U = null;
    o o1 = this.V;
    if (o1 != null)
      ApplicationManager.getApplication().invokeLater(() -> {
            if (this.o.isDisposed())
              return; 
            FileEditorManager.getInstance(this.o).closeFile((VirtualFile)paramo);
          }); 
    this.V = null;
  }
  
  public boolean B() {
    return (this.H && this.Q);
  }
  
  public void a(String paramString, int paramInt, Integer paramInteger) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.a(str, paramInt, paramInteger);
  }
  
  public boolean C() {
    return (this.H && this.Q);
  }
  
  public void b(String paramString, int paramInt, Integer paramInteger) {
    if (!this.H)
      return; 
    String str = this.C.a(paramString);
    this.u.b(str, paramInt, paramInteger);
  }
  
  public boolean D() {
    return (a(v.b) && this.H && this.Q);
  }
  
  public boolean E() {
    return (a(v.b) && this.H && this.Q);
  }
  
  public void a(LineLocation[] paramArrayOfLineLocation) {
    this.u.a(paramArrayOfLineLocation);
  }
  
  public void b(LineLocation[] paramArrayOfLineLocation) {
    this.u.b(paramArrayOfLineLocation);
  }
  
  public boolean F() {
    return (this.H && this.Q);
  }
  
  public void G() {
    if (!this.H)
      return; 
    this.u.g();
  }
  
  public boolean H() {
    return (this.H && this.Q);
  }
  
  public void I() {
    if (!this.H)
      return; 
    this.u.h();
  }
  
  public boolean J() {
    return (this.H && this.Q);
  }
  
  public void K() {
    if (!this.H)
      return; 
    this.u.i();
  }
  
  public boolean L() {
    return (this.H && this.Q);
  }
  
  public void M() {
    if (!this.H)
      return; 
    this.u.j();
  }
  
  public boolean N() {
    return (this.H && this.Q);
  }
  
  public void O() {
    if (!this.H)
      return; 
    this.u.k();
  }
  
  public boolean P() {
    return (this.H && this.Q);
  }
  
  public void Q() {
    if (!this.H)
      return; 
    this.u.l();
  }
  
  public boolean R() {
    return (!this.H || !this.Q);
  }
  
  public void a(int paramInt) {
    if (!this.H)
      return; 
    this.u.a(paramInt);
  }
  
  public void b(int paramInt) {
    if (!this.H)
      return; 
    this.u.b(paramInt);
  }
  
  public boolean S() {
    return (this.H && this.Q);
  }
  
  public void a(String paramString, Integer paramInteger) {
    if (!this.H)
      return; 
    this.u.a((paramString != null) ? this.C.a(paramString) : null, paramInteger);
  }
  
  private void i(String paramString) throws ExecutionException {
    a(g, NotificationType.ERROR, k.a("notifications.extendedCore.title", new Object[0]), k.a(paramString, new Object[0]));
    throw new ExecutionException(k.a("notifications.startup.error", new Object[0]));
  }
  
  private void a(boolean paramBoolean) {
    ProgressManager.getInstance().run((Task)new p(this, this.o, k.a("background.preparing", new Object[0]), false, paramBoolean));
  }
  
  public synchronized ProcessHandler a(a parama) throws ExecutionException {
    if (this.u != null)
      i("notifications.runConfiguration.wallabyAlreadyLive"); 
    if (I && !(new a()).b().e()) {
      ae();
      i("notifications.license.trialOverPlain");
    } 
    try {
      FileDocumentManager.getInstance().saveAllDocuments();
    } catch (Exception exception) {
      a.warn("Error while saving opened documents", exception);
    } 
    if (!this.A.a())
      throw new ExecutionException(k.a("notifications.missingCore", new Object[0])); 
    File file = new File(this.z.getAbsolutePath() + File.separator + "projects" + File.separator + b(parama));
    this.s = file.getAbsolutePath() + File.separator + "instrumented" + File.separator + "screen.png";
    f.a.a();
    this.C = parama;
    this.x = new ConcurrentHashMap<>();
    this.B = new ConcurrentHashMap<>();
    this.y = new HashSet<>();
    this.P = new ArrayList<>();
    this.F = "http://localhost:51245/";
    if (this.n == null)
      W(); 
    a(WallabyStatus.PROGRESS);
    a(false);
    String[] arrayOfString = (parama.f() == null) ? null : (String[])ContainerUtil.map((Object[])parama.f(), parama::a).toArray((Object[])new String[(parama.f()).length]);
    this.u = new Client(parama.e(), this.A.d(), parama.a().getPath(), this.A.e(), file.getAbsolutePath(), parama.b().getPath(), arrayOfString, parama.d(), a.c.getPath(), parama.c(), false, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a, this::a);
    this.p = (ProcessHandler)this.u.a();
    this.p.putUserData(t, this);
    return this.p;
  }
  
  private void a(WallabyAppUrl paramWallabyAppUrl) {
    this.F = paramWallabyAppUrl.a();
  }
  
  private void a(TestStoryReset paramTestStoryReset) {
    if (this.V != null && this.V.l())
      return; 
    ac();
  }
  
  private void b(boolean paramBoolean) {
    ArrayList<Pair> arrayList1 = new ArrayList();
    ArrayList<Pair> arrayList2 = new ArrayList();
    ArrayList<Pair> arrayList3 = new ArrayList();
    ArrayList<Pair> arrayList4 = new ArrayList();
    if (paramBoolean) {
      for (Pair<Editor, RangeHighlighter> pair : this.d) {
        if (FileDocumentManager.getInstance().getFile(((RangeHighlighter)pair.second).getDocument()) instanceof o) {
          arrayList1.add(pair);
          continue;
        } 
        arrayList2.add(pair);
      } 
      for (Pair<MarkupModel, RangeHighlighter> pair : this.e) {
        if (FileDocumentManager.getInstance().getFile(((RangeHighlighter)pair.second).getDocument()) instanceof o) {
          arrayList3.add(pair);
          continue;
        } 
        arrayList4.add(pair);
      } 
    } else {
      arrayList1.addAll((Collection)this.d);
      arrayList3.addAll((Collection)this.e);
    } 
    this.d = (Collection)arrayList2;
    this.e = (Collection)arrayList4;
    ApplicationManager.getApplication().invokeLater(() -> {
          a(paramCollection1);
          for (Pair pair : paramCollection2)
            ((RangeHighlighter)pair.second).dispose(); 
        });
  }
  
  private void a(Trace.TraceData paramTraceData, boolean paramBoolean) {
    if (paramTraceData != null && paramTraceData.e())
      paramBoolean = false; 
    b(false);
    this.D.a(paramTraceData);
    if (paramTraceData != null)
      this.R = paramTraceData; 
    this.Q = true;
    this.S = null;
    if (this.X != null) {
      Runnable runnable = this.X;
      this.X = null;
      ApplicationManager.getApplication().invokeLater(runnable);
    } 
    if (paramTraceData == null && this.R != null) {
      a(this.R, true, paramBoolean, true);
    } else if (paramTraceData != null) {
      a(paramTraceData, false, paramBoolean, true);
    } 
  }
  
  private void a(Trace.TraceData paramTraceData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    a(paramTraceData.b(), paramTraceData.c(), paramTraceData.d()[0] - 1, paramTraceData.d()[1], paramTraceData.a(), paramBoolean1, false, paramBoolean2, paramBoolean3);
  }
  
  private boolean ad() {
    if (this.V == null)
      return false; 
    FileEditorManagerEx fileEditorManagerEx = (FileEditorManagerEx)FileEditorManager.getInstance(this.o);
    return (ContainerUtil.find((Object[])fileEditorManagerEx.getSelectedEditors(), paramFileEditor -> this.V.equals(paramFileEditor.getFile())) != null);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int[] paramArrayOfint, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    Project project = this.o;
    VirtualFile virtualFile = b(paramString);
    ApplicationManager.getApplication().invokeLater(() -> {
          o o1 = p();
          if (o1 != null && !o1.l()) {
            Integer integer = o1.c(paramInt1);
            if (integer != null) {
              if (o1.n())
                a(paramProject, (VirtualFile)o1, integer.intValue(), paramArrayOfint[1], false); 
              for (EditorEx editorEx : b.a(paramProject, (VirtualFile)o1))
                a(paramProject, editorEx, paramBoolean1, paramBoolean2, integer.intValue(), integer.intValue() + paramArrayOfint[2] - paramArrayOfint[0], paramArrayOfint[1], paramArrayOfint[3]); 
            } else if (paramBoolean3) {
              a(Integer.valueOf(paramInt1), (TestStory.TestStoryEntry)null, (Consumer<o>)null);
            } 
          } 
          if (!paramBoolean4 && (o1 == null || o1.n()))
            a(paramProject, paramVirtualFile, paramInt2, paramInt3, true); 
          b b = a(paramVirtualFile);
          if (b != null)
            for (EditorEx editorEx : b.a(paramProject, paramVirtualFile))
              a(paramProject, editorEx, paramBoolean1, paramBoolean2, paramArrayOfint[0] - 1, paramArrayOfint[2] - 1, paramArrayOfint[1], paramArrayOfint[3]);  
        });
  }
  
  private void a(Project paramProject, VirtualFile paramVirtualFile, int paramInt1, int paramInt2, boolean paramBoolean) {
    boolean bool = ad();
    FileEditorManagerEx fileEditorManagerEx = (FileEditorManagerEx)FileEditorManager.getInstance(this.o);
    if (ContainerUtil.find((Object[])fileEditorManagerEx.getSelectedEditors(), paramFileEditor -> paramVirtualFile.equals(paramFileEditor.getFile())) != null)
      paramBoolean = false; 
    if (paramBoolean && bool && !paramVirtualFile.equals(this.V)) {
      EditorWindow editorWindow = (EditorWindow)ContainerUtil.find((Object[])fileEditorManagerEx.getWindows(), paramEditorWindow -> {
            EditorWithProviderComposite editorWithProviderComposite = paramEditorWindow.getSelectedEditor();
            return (editorWithProviderComposite == null) ? true : (!editorWithProviderComposite.getFile().equals(this.V));
          });
      if (editorWindow != null)
        try {
          fileEditorManagerEx.openFileWithProviders(paramVirtualFile, false, editorWindow);
        } catch (Exception exception) {
          a.warn(exception);
        }  
    } else if (paramBoolean) {
      OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(paramProject, paramVirtualFile, paramInt1, paramInt2);
      try {
        openFileDescriptor.navigate(true);
      } catch (Exception exception) {
        a.warn(exception);
      } 
    } 
    for (EditorEx editorEx : b.a(paramProject, paramVirtualFile)) {
      LogicalPosition logicalPosition = new LogicalPosition(paramInt1, paramInt2);
      editorEx.getScrollingModel().scrollTo(logicalPosition, ScrollType.MAKE_VISIBLE);
      editorEx.getCaretModel().moveToLogicalPosition(logicalPosition);
    } 
  }
  
  private void a(Project paramProject, EditorEx paramEditorEx, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    boolean bool1 = (paramInt1 != paramInt2) ? true : false;
    DocumentEx documentEx = paramEditorEx.getDocument();
    if (paramInt3 == 0) {
      int k = documentEx.getLineStartOffset(paramInt1);
      int n = documentEx.getLineEndOffset(paramInt1);
      String str = documentEx.getText(TextRange.create(k, n));
      i = k + str.indexOf(str.trim());
    } else {
      i = documentEx.getLineStartOffset(paramInt1) + paramInt3;
    } 
    int j = bool1 ? documentEx.getLineEndOffset(paramInt1) : (documentEx.getLineStartOffset(paramInt2) + paramInt4);
    boolean bool2 = false;
    if (!bool1) {
      String str1 = documentEx.getText(TextRange.create(documentEx.getLineStartOffset(paramInt1), documentEx.getLineEndOffset(paramInt1)));
      String str2 = documentEx.getText(TextRange.create(i, j));
      if (str1.equals(str2)) {
        bool2 = true;
      } else if (str1.startsWith(str2)) {
        String str = str1.substring(str2.length()).trim();
        if (str.replaceAll("(^//(.*))|(^/\\*(.*?)\\*/)|(^/\\*(.*?)[^\\*/]$)", "").trim().length() == 0)
          bool2 = true; 
      } 
    } 
    HighlightManager highlightManager = HighlightManager.getInstance(paramProject);
    ArrayList arrayList = new ArrayList();
    EditorColorsScheme editorColorsScheme = EditorColorsManager.getInstance().getGlobalScheme();
    Color color1 = paramBoolean1 ? HintUtil.getErrorColor() : (paramBoolean2 ? editorColorsScheme.getAttributes(DebuggerColors.NOT_TOP_FRAME_ATTRIBUTES).getBackgroundColor() : l.a(l.i));
    Color color2 = (paramBoolean1 || !paramBoolean2) ? null : editorColorsScheme.getAttributes(DebuggerColors.NOT_TOP_FRAME_ATTRIBUTES).getForegroundColor();
    TextAttributes textAttributes = new TextAttributes(color2, color1, bool2 ? null : (ColorUtil.isDark(color1) ? color1.brighter().brighter() : color1.darker().darker()), EffectType.BOXED, 0);
    if (bool2) {
      MarkupModel markupModel = DocumentMarkupModel.forDocument((Document)paramEditorEx.getDocument(), this.o, true);
      RangeHighlighter rangeHighlighter = markupModel.addLineHighlighter(paramInt1, 5999, textAttributes);
      this.e.add(new Pair(markupModel, rangeHighlighter));
    } else {
      highlightManager.addOccurrenceHighlight((Editor)paramEditorEx, i, j, textAttributes, 0, arrayList, color1);
      for (RangeHighlighter rangeHighlighter : arrayList)
        this.d.add(new Pair(paramEditorEx, rangeHighlighter)); 
    } 
  }
  
  private void a(Trace.TraceData paramTraceData) {
    a(paramTraceData, true);
  }
  
  private void a(Trace paramTrace) {
    a(paramTrace.h(), false);
  }
  
  private void a(TraceTestSelectionRequested paramTraceTestSelectionRequested) {
    ApplicationManager.getApplication().invokeLater(() -> {
          DefaultActionGroup defaultActionGroup = new DefaultActionGroup();
          for (TraceTestSelectionRequested.TraceTestSelectionData traceTestSelectionData : paramTraceTestSelectionRequested.a())
            defaultActionGroup.add(new q(this, traceTestSelectionData.b(), "Select test", traceTestSelectionData.a() ? AllIcons.RunConfigurations.TestError : AllIcons.RunConfigurations.TestPassed, paramTraceTestSelectionRequested, traceTestSelectionData)); 
          JBPopupFactory.getInstance().createActionGroupPopup("Select test to debug", (ActionGroup)defaultActionGroup, DataManager.getInstance().getDataContext(this.S.getComponent()), JBPopupFactory.ActionSelectionAid.SPEEDSEARCH, false).showInBestPositionFor(this.S);
        });
  }
  
  private void a(TestFilterTestSelectionRequested paramTestFilterTestSelectionRequested) {
    if (this.W == null)
      return; 
    Consumer<TestFilterTestSelectionRequested.Test[]> consumer = this.W;
    this.W = null;
    consumer.consume(paramTestFilterTestSelectionRequested.a());
  }
  
  private void a(TraceNavigationReset paramTraceNavigationReset) {
    A();
  }
  
  private void a(NavigationRequested paramNavigationRequested) {
    Project project = this.o;
    VirtualFile virtualFile = b(paramNavigationRequested.a());
    ApplicationManager.getApplication().invokeLater(() -> {
          OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(paramProject, paramVirtualFile, paramNavigationRequested.b() - 1, paramNavigationRequested.c());
          try {
            openFileDescriptor.navigate(true);
          } catch (Exception exception) {
            a.warn(exception);
          } 
        });
  }
  
  private void a(Stopped paramStopped) {
    if (paramStopped.a())
      ae(); 
    if (this.y != null) {
      if (this.y.size() > 0 && this.O == 5)
        ae(); 
      this.y.forEach(Notification::expire);
    } 
    ag();
  }
  
  private void ae() {
    ApplicationManager.getApplication().invokeLater(() -> {
          if (this.D != null)
            this.D.a(k.a("notifications.license.trialOverPlain", new Object[0])); 
        });
    a(g, NotificationType.ERROR, k.a("notifications.license.title", new Object[0]), k.a("notifications.license.trialOver", new Object[0]));
    I = true;
  }
  
  private void a(ShowDiffMessage paramShowDiffMessage) {
    if (k(paramShowDiffMessage.a()))
      return; 
    ApplicationManager.getApplication().invokeLater(() -> (new j(paramShowDiffMessage.b().d(), paramShowDiffMessage.b().b(), null)).navigate(this.o));
  }
  
  private void a(LineReport paramLineReport) {
    if (k(paramLineReport.a()))
      return; 
    if (this.K.isDisposed())
      return; 
    ApplicationManager.getApplication().invokeLater(() -> {
          Project project = this.o;
          VirtualFile virtualFile = b(paramLineReport.b());
          b b = a(virtualFile);
          f f = b.b(paramLineReport.c() - 1);
          if (f == null)
            return; 
          EditorEx[] arrayOfEditorEx = b.a(project, virtualFile);
          for (EditorEx editorEx : arrayOfEditorEx) {
            if (editorEx == this.K) {
              h.a(paramLineReport, project, (Editor)arrayOfEditorEx[0], f, this.L);
              return;
            } 
          } 
          this.L = null;
          this.K = null;
        });
  }
  
  private void a(Tests paramTests) {
    if (k(paramTests.a()) || this.T == null)
      return; 
    Consumer<Test[]> consumer = this.T;
    this.T = null;
    consumer.consume(paramTests.b());
  }
  
  private void a(TestStory paramTestStory) {
    if (k(paramTestStory.d()))
      return; 
    boolean bool = (this.V != null) ? true : false;
    if (bool) {
      this.V.a(paramTestStory);
    } else {
      this.V = new o(paramTestStory);
    } 
    Consumer<o> consumer = this.U;
    this.T = null;
    if (consumer != null)
      consumer.consume(this.V); 
    if (bool) {
      CharSequence charSequence = this.V.getContent();
      ApplicationManager.getApplication().invokeLater(() -> {
            Document document = FileDocumentManager.getInstance().getDocument((VirtualFile)this.V);
            if (document != null)
              ApplicationManager.getApplication().runWriteAction(()); 
            b(());
          });
    } 
    a(this.R, false, false, this.V.k());
  }
  
  private void b(Consumer<Editor> paramConsumer) {
    if (this.V == null)
      return; 
    FileEditorManager fileEditorManager = FileEditorManager.getInstance(this.o);
    for (FileEditor fileEditor : fileEditorManager.getEditors((VirtualFile)this.V)) {
      if (fileEditor instanceof TextEditor) {
        TextEditor textEditor = (TextEditor)fileEditor;
        Editor editor = textEditor.getEditor();
        paramConsumer.consume(editor);
      } 
    } 
  }
  
  private void a(UncoveredRegions paramUncoveredRegions) {
    if (k(paramUncoveredRegions.a()))
      return; 
    Project project = this.o;
    VirtualFile virtualFile = b(paramUncoveredRegions.b());
    b b = a(virtualFile);
    ApplicationManager.getApplication().invokeLater(() -> {
          HighlightManager highlightManager = HighlightManager.getInstance(paramProject);
          for (int[] arrayOfInt : paramUncoveredRegions.c()) {
            int i = paramb.a().getLineStartOffset(arrayOfInt[0] - 1) + arrayOfInt[1];
            int j = paramb.a().getLineStartOffset(arrayOfInt[2] - 1) + arrayOfInt[3];
            ArrayList arrayList = new ArrayList();
            for (EditorEx editorEx : b.a(paramProject, paramVirtualFile)) {
              highlightManager.addRangeHighlight((Editor)editorEx, i, j, new TextAttributes(null, LightColors.RED, null, EffectType.BOXED, 0), true, false, arrayList);
              for (RangeHighlighter rangeHighlighter : arrayList)
                this.c.add(new Pair(editorEx, rangeHighlighter)); 
            } 
          } 
        });
  }
  
  private void j(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return; 
    String[] arrayOfString = paramString.split("\\.");
    try {
      this.Y[0] = Integer.parseInt(arrayOfString[0]);
      this.Y[1] = Integer.parseInt(arrayOfString[1]);
      this.Y[2] = Integer.parseInt(arrayOfString[2]);
    } catch (Exception exception) {
      this.Y[0] = Integer.MAX_VALUE;
      this.Y[1] = Integer.MAX_VALUE;
      this.Y[2] = Integer.MAX_VALUE;
    } 
  }
  
  private void a(Started paramStarted) {
    if (this.D != null) {
      j(paramStarted.a());
      this.D.b(paramStarted.a());
    } 
  }
  
  private void a(Busy paramBusy) {
    a(WallabyStatus.PROGRESS);
  }
  
  private void a(Stats paramStats) {
    if (paramStats.l()) {
      this.D.a(paramStats.i());
      b(paramStats);
    } 
    if (this.w != null) {
      if (this.w.b()) {
        a(WallabyStatus.RED);
      } else {
        a(WallabyStatus.GREEN);
      } 
    } else {
      a(WallabyStatus.INACTIVE);
    } 
  }
  
  private void a(ProjectConfigured paramProjectConfigured) {
    if ((new a()).b().b()) {
      ag();
      a(g, NotificationType.ERROR, k.a("notifications.extendedCore.title", new Object[0]), k.a("notifications.license.invalidVersion", new Object[0]));
    } 
    this.E = paramProjectConfigured.c().booleanValue();
    this.M = (paramProjectConfigured.a() <= 0) ? 100 : paramProjectConfigured.a();
    this.Z = paramProjectConfigured.d();
  }
  
  private boolean k(String paramString) {
    try {
      long l1 = Long.parseLong(paramString.split(":")[0]);
      long l2 = (new Date()).getTime();
      if (l2 - l1 > 5000L)
        return true; 
    } catch (Exception exception) {
      a.warn(exception);
      return true;
    } 
    return false;
  }
  
  private void a(Location paramLocation) {
    if (k(paramLocation.f()))
      return; 
    Project project = this.o;
    VirtualFile virtualFile = b(paramLocation.d());
    ApplicationManager.getApplication().invokeLater(() -> {
          OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(paramProject, paramVirtualFile, paramLocation.a() - 1, paramLocation.b());
          try {
            openFileDescriptor.navigate(true);
          } catch (Exception exception) {
            a.warn(exception);
          } 
        });
  }
  
  private void a(DocumentUpdates paramDocumentUpdates) {
    TestStory.OriginalLineData originalLineData = (this.V != null && this.V.h() != null) ? this.V.b(this.V.h().intValue()) : null;
    boolean bool = false;
    for (String str1 : paramDocumentUpdates.a()) {
      DocumentUpdate documentUpdate = paramDocumentUpdates.a(str1);
      String str2 = this.C.b(str1);
      VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(str2);
      if (virtualFile != null && this.B != null) {
        b b = this.B.get(virtualFile.getPath());
        if (b != null)
          ((b)this.B.get(virtualFile.getPath())).a(documentUpdate); 
      } 
      if (originalLineData != null && originalLineData.a().equals(str1))
        for (LineData lineData : documentUpdate.a()) {
          if (lineData.e() && lineData.a() == originalLineData.b() + 1) {
            this.V.a(this.V.h().intValue(), lineData.d(), (lineData.g() != null && lineData.g().c()));
            bool = true;
          } 
        }  
    } 
    if (bool)
      ApplicationManager.getApplication().invokeLater(() -> b(())); 
  }
  
  private void a(Live paramLive) {
    this.G = Integer.valueOf(paramLive.b());
    this.H = true;
    this.r.a(this::b, this::c, this::a);
    for (VirtualFile virtualFile : this.r.a())
      b(virtualFile); 
    for (FileChangedInEditor fileChangedInEditor : this.P)
      this.u.a(fileChangedInEditor.a(), fileChangedInEditor.b(), fileChangedInEditor.c(), fileChangedInEditor.d()); 
    this.P.clear();
  }
  
  private void a(SelectionEvent paramSelectionEvent) {
    if (!this.H)
      return; 
    if (!this.Q)
      return; 
    Editor editor = paramSelectionEvent.getEditor();
    PsiFile psiFile = (PsiFile)ApplicationManager.getApplication().runReadAction(() -> {
          if (this.o.isDisposed())
            return null; 
          PsiDocumentManager psiDocumentManager = PsiDocumentManager.getInstance(this.o);
          Document document = paramEditor.getDocument();
          return psiDocumentManager.getPsiFile(document);
        });
    if (psiFile == null || !psiFile.isPhysical())
      return; 
    VirtualFile virtualFile = psiFile.getVirtualFile();
    if (virtualFile instanceof o) {
      o o1 = (o)virtualFile;
      if (!o1.l()) {
        int i = paramSelectionEvent.getNewRange().getStartOffset();
        int j = paramSelectionEvent.getNewRange().getEndOffset();
        if (j - i > 0) {
          LogicalPosition logicalPosition1 = editor.offsetToLogicalPosition(i);
          LogicalPosition logicalPosition2 = editor.offsetToLogicalPosition(j);
          TestStory.OriginalLineData originalLineData = o1.b(logicalPosition1.line);
          if (originalLineData != null) {
            int[] arrayOfInt = { originalLineData.b() + 1, logicalPosition1.column, originalLineData.b() + 1 + logicalPosition2.line - logicalPosition1.line, logicalPosition2.column };
            String str1 = originalLineData.a();
            String str2 = this.C.b(str1);
            VirtualFile virtualFile1 = LocalFileSystem.getInstance().findFileByPath(str2);
            if (virtualFile1 != null) {
              Document document = FileDocumentManager.getInstance().getDocument(virtualFile1);
              if (document != null) {
                this.u.a(str1, b.a(document.getText(), virtualFile1.getDetectedLineSeparator()), arrayOfInt, "show");
                o1.d(logicalPosition1.line);
              } 
            } 
          } 
        } 
      } 
    } else {
      String str = e().a(virtualFile.getPath());
      if (this.x.contains(str) && this.B != null) {
        b b = this.B.get(virtualFile.getPath());
        if (b != null) {
          int i = paramSelectionEvent.getNewRange().getStartOffset();
          int j = paramSelectionEvent.getNewRange().getEndOffset();
          if (j - i > 0) {
            LogicalPosition logicalPosition1 = editor.offsetToLogicalPosition(i);
            LogicalPosition logicalPosition2 = editor.offsetToLogicalPosition(j);
            int[] arrayOfInt = { logicalPosition1.line + 1, logicalPosition1.column, logicalPosition2.line + 1, logicalPosition2.column };
            a(b, arrayOfInt, "show");
          } 
        } 
      } 
    } 
  }
  
  private void b(VirtualFile paramVirtualFile) {
    String str = e().a(paramVirtualFile.getPath());
    if (this.x.contains(str)) {
      this.u.a(str);
      if (this.B != null && !this.B.containsKey(paramVirtualFile.getPath())) {
        Document document = this.r.a(paramVirtualFile);
        if (document != null) {
          b b = new b(this.o, this, paramVirtualFile, document, this.M);
          this.B.put(paramVirtualFile.getPath(), b);
          if (FileDocumentManager.getInstance().isDocumentUnsaved(document)) {
            String str1 = b.f();
            a(paramVirtualFile, str1, 1, (str1.split("\r\n|\r|\n")).length);
          } 
        } 
      } 
    } 
  }
  
  private void c(VirtualFile paramVirtualFile) {
    if (paramVirtualFile instanceof o && this.V != null) {
      ApplicationManager.getApplication().invokeLater(() -> {
            if (this.V != null && (FileEditorManager.getInstance(this.o).getAllEditors((VirtualFile)this.V)).length == 0)
              this.V = null; 
          });
      return;
    } 
    String str = e().a(paramVirtualFile.getPath());
    if (this.x.contains(str) && this.B != null) {
      this.u.b(str);
      b b = this.B.get(paramVirtualFile.getPath());
      if (b != null) {
        b.dispose();
        this.B.remove(paramVirtualFile.getPath());
      } 
    } 
  }
  
  private void a(FilesToTrack paramFilesToTrack) {
    HashMap<String, String> hashMap = new HashMap<>(this.x);
    for (String str1 : paramFilesToTrack.a()) {
      this.x.put(str1, str1);
      hashMap.remove(str1, str1);
      String str2 = this.C.b(str1);
      VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(str2);
      if (virtualFile != null && (FileEditorManager.getInstance(this.o).getAllEditors(virtualFile)).length > 0 && this.B != null && !this.B.containsKey(virtualFile.getPath()))
        b(virtualFile); 
    } 
    if (!paramFilesToTrack.b())
      hashMap.forEach((paramString1, paramString2) -> {
            if (this.x.contains(paramString1) && this.B != null) {
              this.x.remove(paramString1);
              this.u.b(paramString1);
              String str = FileUtilRt.toSystemIndependentName(this.C.b(paramString1));
              this.r.a(str);
              b b = this.B.get(str);
              if (b != null) {
                b.dispose();
                this.B.remove(str);
              } 
            } 
          }); 
  }
  
  private void a(a parama) {
    this.D.a(parama);
  }
  
  private void a(Notification paramNotification) {
    String str1 = paramNotification.b();
    str1 = str1.replace("href=\"#\" class=\"activate-link\"", "href=\"https://activate\"").replace("href=\"#\" class=\"continue-trial-link\"", "href=\"https://continue\"").replace("<br/>", "<br/><br/>");
    NotificationType notificationType = paramNotification.a().equals("warning") ? NotificationType.WARNING : (paramNotification.a().equals("error") ? NotificationType.ERROR : NotificationType.INFORMATION);
    boolean bool = (paramNotification.c().equals("expiredLicense") || paramNotification.c().equals("expiringLicense")) ? true : false;
    NotificationGroup notificationGroup = paramNotification.c().equals("expiredLicense") ? h : (paramNotification.c().equals("expiringLicense") ? i : g);
    String str2 = bool ? k.a("notifications.license.title", new Object[0]) : k.a("notifications.extendedCore.title", new Object[0]);
    if (bool)
      str1 = str1 + "<br/><br/>To stop receiving the message, you may <a href=\"https://mute\">mute this notification.</a>"; 
    a(notificationGroup, notificationType, str2, str1);
  }
  
  private void a(TestFilterToggled paramTestFilterToggled) {
    this.J = paramTestFilterToggled.a();
  }
  
  private void a(NotificationGroup paramNotificationGroup, NotificationType paramNotificationType, String paramString1, String paramString2) {
    if (paramString2.contains("https://continue")) {
      this.O++;
      if (this.O == 5) {
        ae();
        ah();
        return;
      } 
    } 
    Notification notification = paramNotificationGroup.createNotification(paramString1, XmlStringUtil.wrapInHtml(paramString2), paramNotificationType, (paramNotification, paramHyperlinkEvent) -> {
          String str = paramHyperlinkEvent.getURL().toString();
          if ("https://continue".equals(str)) {
            paramNotification.expire();
            if (this.u != null)
              this.u.b(); 
          } else if ("https://activate".equals(str)) {
            paramNotification.expire();
            k();
          } else if ("https://mute".equals(str)) {
            paramNotification.expire();
            NotificationsConfiguration.getNotificationsConfiguration().changeSettings(paramNotification.getGroupId(), NotificationDisplayType.NONE, true, false);
          } else if (str != null && (str.startsWith("http://") || str.startsWith("https://"))) {
            BrowserLauncher.getInstance().open(str);
          } 
        });
    if (paramString2.contains("https://continue")) {
      this.y.add(notification);
      notification.whenExpired(() -> this.y.remove(paramNotification));
    } 
    notification.notify(this.o);
  }
  
  private void af() {
    if (!this.N)
      return; 
    ApplicationManager.getApplication().invokeLater(() -> {
          try {
            for (FileEditor fileEditor : FileEditorManager.getInstance(this.o).getAllEditors()) {
              if (fileEditor instanceof TextEditor) {
                TextEditor textEditor = (TextEditor)fileEditor;
                VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(textEditor.getEditor().getDocument());
                if (virtualFile != null)
                  virtualFile.refresh(false, false); 
              } 
            } 
          } catch (Exception exception) {
            a.warn(exception);
          } 
        });
  }
  
  private void b(Stats paramStats) {
    af();
    if (this.w != null && this.w.equals(paramStats))
      return; 
    this.w = paramStats;
    if (this.D != null)
      this.D.a(this.w.d(), this.w.e(), this.w.f(), this.w.g(), this.w.j(), this.w.k(), this.w.h(), this.w.c()); 
  }
  
  private void ag() {
    if (this.p != null)
      this.p.destroyProcess(); 
    ah();
  }
  
  public a e() {
    return this.C;
  }
  
  public boolean f() {
    return this.E;
  }
  
  public boolean g() {
    return (this.w == null) ? false : this.w.b();
  }
  
  public boolean h() {
    return this.H;
  }
  
  public boolean i() {
    return (this.w != null);
  }
  
  public boolean j() {
    return this.J;
  }
  
  private synchronized void ah() {
    this.W = null;
    this.T = null;
    ac();
    if (this.u != null) {
      this.u.dispose();
      this.u = null;
    } 
    if (this.p != null) {
      this.p.putUserData(t, null);
      this.p = null;
    } 
    if (this.B != null) {
      ConcurrentHashMap<String, b> concurrentHashMap = this.B;
      this.B = null;
      for (b b : concurrentHashMap.values())
        b.dispose(); 
    } 
    ApplicationManager.getApplication().invokeLater(this::X);
    this.H = false;
    this.J = false;
    this.w = null;
    this.x = null;
    this.y = null;
    this.B = null;
    this.s = null;
    this.P = null;
    this.Q = false;
    this.R = null;
    b(false);
    if (this.D != null) {
      this.D.a();
      z z1 = this.D;
      ApplicationManager.getApplication().invokeLater(() -> {
            paramz.a(new a());
            paramz.a("Wallaby has stopped, results are no longer available.");
          });
    } 
    this.D = null;
    t t1 = this.r;
    if (t1 != null)
      t1.b(); 
  }
  
  public void projectOpened() {
    this.r = new t(this.o);
    EditorFactory.getInstance().addEditorFactoryListener(this.r, (Disposable)this.o);
    r r = new r(this);
    ProjectManager.getInstance().addProjectManagerListener(this.o, r);
  }
  
  public void projectClosed() {}
  
  private void a(WallabyStatus paramWallabyStatus) {
    ApplicationManager.getApplication().invokeLater(() -> {
          if (this.n != null) {
            this.n.a(paramWallabyStatus);
            try {
              if (paramWallabyStatus == WallabyStatus.RED) {
                AppIcon.getInstance().setErrorBadge(this.o, k.a("status.red", new Object[0]));
              } else if (paramWallabyStatus == WallabyStatus.GREEN) {
                AppIcon.getInstance().setOkBadge(this.o, false);
              } 
            } catch (Exception exception) {}
          } 
        });
  }
  
  public void dispose() {
    ah();
  }
  
  public void a(z paramz) {
    this.D = paramz;
  }
  
  public String a() {
    return StringUtil.notNullize(this.s);
  }
  
  public ToolWindow b() {
    ExecutionManager executionManager = ExecutionManager.getInstance(this.o);
    RunContentDescriptor runContentDescriptor = c();
    return (runContentDescriptor == null) ? null : executionManager.getContentManager().getToolWindowByDescriptor(runContentDescriptor);
  }
  
  public RunContentDescriptor c() {
    ExecutionManager executionManager = ExecutionManager.getInstance(this.o);
    List list = executionManager.getContentManager().getAllDescriptors();
    if (list.isEmpty())
      return null; 
    for (RunContentDescriptor runContentDescriptor : list) {
      ProcessHandler processHandler = runContentDescriptor.getProcessHandler();
      if (processHandler == null || processHandler.getUserData(t) == null)
        continue; 
      return runContentDescriptor;
    } 
    return null;
  }
  
  public Project d() {
    return this.o;
  }
  
  public String V() {
    return this.A.c();
  }
  
  private final class a extends EditorActionHandler {
    private final EditorActionHandler b;
    
    private Long c;
    
    private a(WallabyController this$0, EditorActionHandler param1EditorActionHandler) {
      this.b = param1EditorActionHandler;
    }
    
    protected boolean isEnabledForCaret(Editor editor, Caret caret, DataContext dataContext) {
      Project project = (Project)CommonDataKeys.PROJECT.getData(dataContext);
      if (project != null) {
        WallabyController wallabyController = WallabyController.a(project);
        if (wallabyController != null && WallabyController.d(wallabyController) && wallabyController.a(v.h)) {
          b b = wallabyController.a(editor);
          if (b != null && b.h())
            return true; 
        } 
      } 
      return this.b.isEnabled(editor, caret, dataContext);
    }
    
    protected void doExecute(Editor editor, Caret caret, DataContext dataContext) {
      Project project = (Project)CommonDataKeys.PROJECT.getData(dataContext);
      if (project != null) {
        WallabyController wallabyController = WallabyController.a(project);
        if (wallabyController != null && WallabyController.d(wallabyController) && wallabyController.a(v.h)) {
          b b = wallabyController.a(editor);
          if (b != null && b.h()) {
            f f = b.a(editor.getCaretModel().getOffset());
            if (f != null && f.g()) {
              this.c = null;
              wallabyController.a(b.d(), Integer.valueOf(f.k()));
            } else {
              long l = System.currentTimeMillis();
              if (this.c == null) {
                this.c = Long.valueOf(l);
              } else if (l - this.c.longValue() <= 500L) {
                this.c = null;
                wallabyController.a(b.d(), (Integer)null);
              } else {
                this.c = null;
              } 
            } 
          } 
        } 
      } 
      this.b.execute(editor, caret, dataContext);
    }
  }
  
  public class b implements JBPopupListener {
    b(WallabyController this$0) {}
    
    public void beforeShown(LightweightWindowEvent event) {}
    
    public void onClosed(LightweightWindowEvent event) {}
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/WallabyController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */