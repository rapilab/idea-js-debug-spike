package com.wallaby.javascript.execution;

import a.a;
import com.intellij.execution.ExecutionManager;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.filters.BrowserHyperlinkInfo;
import com.intellij.execution.filters.HyperlinkInfo;
import com.intellij.execution.filters.TextConsoleBuilderImpl;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessListener;
import com.intellij.execution.process.ProcessOutputTypes;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.execution.ui.ExecutionConsoleEx;
import com.intellij.execution.ui.ObservableConsoleView;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.execution.ui.RunnerLayoutUi;
import com.intellij.execution.ui.layout.PlaceInGrid;
import com.intellij.icons.AllIcons;
import com.intellij.ide.util.treeView.AbstractTreeStructure;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComponentWithActions;
import com.intellij.openapi.ui.Splitter;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vcs.changes.issueLinks.LinkMouseListenerBase;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.JBColor;
import com.intellij.ui.PopupHandler;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.SimpleColoredComponent;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.content.Content;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;
import com.intellij.util.ui.UIUtil;
import com.wallaby.javascript.TestPrinter;
import com.wallaby.javascript.actions.JumpToTestAction;
import com.wallaby.javascript.execution.a.c;
import com.wallaby.javascript.execution.a.d;
import com.wallaby.javascript.execution.a.f;
import com.wallaby.javascript.execution.b.a;
import com.wallaby.javascript.execution.b.b;
import com.wallaby.javascript.execution.b.f;
import com.wallaby.javascript.execution.b.g;
import com.wallaby.javascript.extendedCore.inboundMessages.ErrorEntry;
import com.wallaby.javascript.extendedCore.inboundMessages.FileMessage;
import com.wallaby.javascript.extendedCore.inboundMessages.StatsTrace;
import com.wallaby.javascript.extendedCore.inboundMessages.TestEntry;
import com.wallaby.javascript.extendedCore.inboundMessages.Trace;
import com.wallaby.javascript.extendedCore.inboundMessages.a;
import com.wallaby.javascript.k;
import com.wallaby.javascript.m;
import com.wallaby.javascript.z;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;

public class n implements ExecutionConsoleEx, ObservableConsoleView, ComponentWithActions, z {
  private final ConsoleView a;
  
  private final ConsoleView b;
  
  private DefaultActionGroup c;
  
  private Content d;
  
  private boolean e;
  
  private TestPrinter f;
  
  private m g;
  
  private JScrollPane h;
  
  private JScrollPane i;
  
  private Map<String, a> j = new HashMap<>();
  
  private SimpleTreeBuilder k;
  
  private m l;
  
  private m m;
  
  private JPanel n;
  
  private JScrollPane o;
  
  private JScrollPane p;
  
  private Splitter q;
  
  private JPanel r;
  
  private JPanel s;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private SimpleTreeBuilder v;
  
  private c w;
  
  private StatsTrace x;
  
  private Trace.TraceData y;
  
  private RunnerLayoutUi z;
  
  private Content A;
  
  private Content B;
  
  private d C;
  
  private f D;
  
  private JPanel E;
  
  private Content F;
  
  private Integer G;
  
  n(x paramx, ProcessHandler paramProcessHandler, m paramm) {
    this.g = paramm;
    this.a = (new TextConsoleBuilderImpl(paramx.a())).getConsole();
    this.b = (new TextConsoleBuilderImpl(paramx.a())).getConsole();
    this.f = new TestPrinter(paramm, this.b, 200);
    Disposer.register((Disposable)this, (Disposable)this.a);
    Disposer.register((Disposable)this, (Disposable)this.b);
    paramProcessHandler.addProcessListener((ProcessListener)new o(this));
  }
  
  public void buildUi(RunnerLayoutUi layoutUi) {
    this.z = layoutUi;
    layoutUi.addContent(d(layoutUi), 1, PlaceInGrid.bottom, false);
    layoutUi.addContent(c(layoutUi), 2, PlaceInGrid.bottom, false);
    layoutUi.addContent(b(layoutUi), 3, PlaceInGrid.bottom, false);
    layoutUi.addContent(a(layoutUi), 4, PlaceInGrid.bottom, false);
    layoutUi.getOptions().setMinimizeActionEnabled(false);
    layoutUi.getOptions().setTopToolbar((ActionGroup)c(), "DebuggerToolbar");
  }
  
  private GridBagConstraints b() {
    return new GridBagConstraints(0, 0, 1, 1, 1.0D, 1.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0);
  }
  
  private Content a(RunnerLayoutUi paramRunnerLayoutUi) {
    this.n = new JPanel(new GridBagLayout());
    this.n.setBorder(BorderFactory.createEmptyBorder());
    this.o = ScrollPaneFactory.createScrollPane(null, 4);
    this.p = ScrollPaneFactory.createScrollPane(null, 1);
    this.q = new Splitter();
    this.q.setFirstComponent(this.o);
    this.q.setSecondComponent(this.p);
    this.q.setHonorComponentsMinimumSize(false);
    this.q.setProportion(0.5F);
    SimpleColoredComponent simpleColoredComponent1 = new SimpleColoredComponent();
    simpleColoredComponent1.append("Time Travel Debugger has not been started (");
    simpleColoredComponent1.append("read documentation", new SimpleTextAttributes(16, (Color)a("Link.activeForeground", (Color)a("link.foreground", new Color(5807606)))), new SimpleColoredComponent.BrowserLauncherTag("https://wallabyjs.com/docs/intro/time-travel-debugger.html?editor=jb"));
    simpleColoredComponent1.append(")");
    LinkMouseListenerBase.installSingleTagOn(simpleColoredComponent1);
    this.r = new JPanel();
    this.r.setLayout(new GridBagLayout());
    JPanel jPanel1 = new JPanel();
    jPanel1.add((Component)simpleColoredComponent1);
    this.r.add(jPanel1);
    Disposer.register((Disposable)this, this.q::dispose);
    SimpleColoredComponent simpleColoredComponent2 = new SimpleColoredComponent();
    simpleColoredComponent2.append("No logged values (");
    simpleColoredComponent2.append("read documentation", new SimpleTextAttributes(16, (Color)a("Link.activeForeground", (Color)a("link.foreground", new Color(5807606)))), new SimpleColoredComponent.BrowserLauncherTag("https://wallabyjs.com/docs/intro/time-travel-debugger.html?editor=jb#inspecting-runtime-values"));
    simpleColoredComponent2.append(")");
    LinkMouseListenerBase.installSingleTagOn(simpleColoredComponent2);
    this.s = new JPanel();
    this.s.setLayout(new GridBagLayout());
    JPanel jPanel2 = new JPanel();
    jPanel2.add((Component)simpleColoredComponent2);
    this.s.add(jPanel2);
    this.n.add(this.r, b());
    this.A = paramRunnerLayoutUi.createContent(k.a("console.run.debuggerContentId", new Object[0]), this.n, k.a("console.run.debuggerHeader", new Object[0]), AllIcons.Actions.Lightning, null);
    this.A.setCloseable(false);
    this.o.setViewportView(this.s);
    this.u = true;
    this.t = false;
    return this.A;
  }
  
  public static JBColor a(String paramString, Color paramColor) {
    Color color = UIManager.getColor(paramString);
    if (color == null)
      color = paramColor; 
    return new JBColor(color, color);
  }
  
  private DefaultActionGroup c() {
    DefaultActionGroup defaultActionGroup = new DefaultActionGroup();
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.DebugStartAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.DebugStopAction"));
    defaultActionGroup.addSeparator();
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.OpenTestStoryAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.UnlockTestStoryAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.LockTestStoryAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.LoadStartOfTruncatedTestStoryAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.LoadEndOfTruncatedTestStoryAction"));
    defaultActionGroup.addSeparator();
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.ProfileTestAction"));
    defaultActionGroup.addSeparator();
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceBackwardToBreakpointAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceBackwardToSelectionAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTracePrevStepOutAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTracePrevStepAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTracePrevStepOverAction"));
    defaultActionGroup.addSeparator();
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceNextStepOverAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceNextStepAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceNextStepOutAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceForwardToSelectionAction"));
    defaultActionGroup.add(ActionManager.getInstance().getAction("com.wallaby.javascript.actions.PlayTraceForwardToBreakpointAction"));
    return defaultActionGroup;
  }
  
  private Content b(RunnerLayoutUi paramRunnerLayoutUi) {
    this.h = ScrollPaneFactory.createScrollPane();
    this.h.putClientProperty(UIUtil.KEEP_BORDER_SIDES, Integer.valueOf(4));
    this.i = ScrollPaneFactory.createScrollPane();
    this.i.putClientProperty(UIUtil.KEEP_BORDER_SIDES, Integer.valueOf(1));
    Splitter splitter = new Splitter();
    splitter.setFirstComponent(this.h);
    splitter.setSecondComponent(this.i);
    splitter.setHonorComponentsMinimumSize(false);
    splitter.setProportion(0.2F);
    SimpleColoredComponent simpleColoredComponent = new SimpleColoredComponent();
    simpleColoredComponent.append("No logged values (");
    simpleColoredComponent.append("read documentation", new SimpleTextAttributes(16, (Color)a("Link.activeForeground", (Color)a("link.foreground", new Color(5807606)))), new SimpleColoredComponent.BrowserLauncherTag("https://wallabyjs.com/docs/intro/value-explorer.html"));
    simpleColoredComponent.append(")");
    LinkMouseListenerBase.installSingleTagOn(simpleColoredComponent);
    this.E = new JPanel();
    this.E.setLayout(new GridBagLayout());
    JPanel jPanel = new JPanel();
    jPanel.add((Component)simpleColoredComponent);
    this.E.add(jPanel);
    Disposer.register((Disposable)this, splitter::dispose);
    this.F = paramRunnerLayoutUi.createContent(k.a("console.run.valueExplorerContentId", new Object[0]), (JComponent)splitter, k.a("console.run.valueExplorerHeader", new Object[0]), AllIcons.Debugger.Value, splitter.getFirstComponent());
    this.F.setCloseable(false);
    this.h.setViewportView(g());
    this.i.setViewportView(this.E);
    return this.F;
  }
  
  private Content c(RunnerLayoutUi paramRunnerLayoutUi) {
    this.d = paramRunnerLayoutUi.createContent(k.a("console.server.consoleContentId", new Object[0]), this.a.getComponent(), k.a("console.server.header", new Object[0]), AllIcons.Debugger.Console, this.a.getPreferredFocusableComponent());
    this.d.setCloseable(false);
    return this.d;
  }
  
  private Content d(RunnerLayoutUi paramRunnerLayoutUi) {
    Content content = paramRunnerLayoutUi.createContent(k.a("console.run.consoleContentId", new Object[0]), this, k.a("console.run.header", new Object[0]), a.f, this.b.getPreferredFocusableComponent());
    content.setCloseable(false);
    return content;
  }
  
  private void a(SimpleTreeBuilder paramSimpleTreeBuilder, JScrollPane paramJScrollPane) {
    if (paramSimpleTreeBuilder != null)
      Disposer.dispose((Disposable)paramSimpleTreeBuilder); 
    if (paramJScrollPane != null)
      paramJScrollPane.setViewportView((Component)null); 
  }
  
  private void d() {
    a(this.k, this.h);
    this.h = null;
    this.k = null;
  }
  
  private void e() {
    if (this.l != null) {
      a(this.l.b(), this.i);
      this.l = null;
    } 
    this.i = null;
  }
  
  private JComponent f() {
    this.C = new d();
    this.C.setRootVisible(false);
    this.C.setShowsRootHandles(true);
    this.C.getSelectionModel().setSelectionMode(1);
    p p = new p(this);
    this.v = new q(this, (JTree)this.C, this.C.getBuilderModel(), (AbstractTreeStructure)p, null);
    this.D = new f(this.v, this.g);
    this.w = new c(this.g, this.D);
    this.w.a(this.y, this.x);
    this.v.initRootNode();
    this.v.updateFromRoot();
    this.C.getSelectionModel().clearSelection();
    return (JComponent)this.C;
  }
  
  private JComponent g() {
    b b = new b();
    b.setRootVisible(false);
    b.setShowsRootHandles(true);
    b.getSelectionModel().setSelectionMode(1);
    b.a(parama -> {
          this.l = a(false, ());
          if (this.i != null)
            this.i.setViewportView((Component)this.l.c()); 
        });
    r r = new r(this);
    s s = new s(this, r);
    this.k = new SimpleTreeBuilder((JTree)b, b.getBuilderModel(), (AbstractTreeStructure)s, null);
    this.k.initRootNode();
    this.k.updateFromRoot();
    return (JComponent)b;
  }
  
  private m a(boolean paramBoolean, Callable<a[]> paramCallable) {
    g g = new g(this.g);
    SimpleTree simpleTree = new SimpleTree();
    simpleTree.setRootVisible(false);
    simpleTree.setShowsRootHandles(true);
    t t = new t(this, paramCallable, g, paramBoolean);
    u u = new u(this, t);
    v v = new v(this, (JTree)simpleTree, simpleTree.getBuilderModel(), (AbstractTreeStructure)u, null);
    v.initRootNode();
    v.updateFromRoot();
    PopupHandler.installPopupHandler((JComponent)simpleTree, new w(this, simpleTree), "unknown", ActionManager.getInstance());
    return new m(g, v, simpleTree);
  }
  
  public String getExecutionConsoleId() {
    return k.a("console.run.executionConsoleId", new Object[0]);
  }
  
  public JComponent getComponent() {
    return this.b.getComponent();
  }
  
  public JComponent getPreferredFocusableComponent() {
    return this.b.getPreferredFocusableComponent();
  }
  
  public void dispose() {
    d();
    e();
    h();
  }
  
  private void h() {
    this.B = null;
    if (this.m != null) {
      a(this.m.b(), this.p);
      this.m = null;
    } 
  }
  
  public void addChangeListener(ObservableConsoleView.ChangeListener listener, Disposable parent) {}
  
  public ActionGroup getToolbarActions() {
    if (this.c != null)
      return (ActionGroup)this.c; 
    DefaultActionGroup defaultActionGroup = new DefaultActionGroup();
    AnAction[] arrayOfAnAction = this.b.createConsoleActions();
    for (AnAction anAction : arrayOfAnAction)
      defaultActionGroup.add(anAction); 
    defaultActionGroup.addSeparator();
    this.c = defaultActionGroup;
    return (ActionGroup)this.c;
  }
  
  public JComponent getSearchComponent() {
    return null;
  }
  
  public String getToolbarPlace() {
    return "unknown";
  }
  
  public JComponent getToolbarContextComponent() {
    return this.b.getComponent();
  }
  
  public boolean isContentBuiltIn() {
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ErrorEntry[] paramArrayOfErrorEntry, TestEntry[] paramArrayOfTestEntry, String paramString1, String paramString2) {
    this.b.clear();
    this.f.a();
    if (paramInt4 >= 0 && paramString2.length() == 0) {
      int i = paramInt4 - paramInt3 - paramInt1 - paramInt2;
      this.f.c((paramInt3 == 1) ? String.format(k.a("console.run.messages.oneTestFailing", new Object[0]), new Object[] { Integer.valueOf(i) }) : String.format(k.a("console.run.messages.someTestsFailing", new Object[0]), new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i) }));
      if (paramInt1 != 0) {
        this.f.c(", ");
        this.f.a(String.format(k.a("console.run.messages.someTestsSkipped", new Object[0]), new Object[] { Integer.valueOf(paramInt1) }), paramProject -> (new JumpToTestAction()).a(paramProject, null, "skipped"));
      } 
      if (paramInt2 != 0) {
        this.f.c(", ");
        this.f.a(String.format(k.a("console.run.messages.someTestsTodo", new Object[0]), new Object[] { Integer.valueOf(paramInt2) }), paramProject -> (new JumpToTestAction()).a(paramProject, null, "todo"));
      } 
      this.f.c(String.format(" %s ", new Object[] { paramString1 }));
      this.f.a(k.a("console.run.messages.wallabyAppLinkText", new Object[0]), (HyperlinkInfo)new BrowserHyperlinkInfo(this.g.v()));
      this.f.b("");
      this.f.b("");
    } 
    if (paramArrayOfErrorEntry.length > 0)
      this.f.a(paramArrayOfErrorEntry); 
    if (paramString2.length() > 0)
      this.f.a(paramString2); 
    if (paramArrayOfTestEntry.length > 0) {
      boolean[] arrayOfBoolean = new boolean[1];
      ApplicationManager.getApplication().invokeAndWait(() -> {
            ToolWindow toolWindow = this.g.b();
            paramArrayOfboolean[0] = (toolWindow == null || !toolWindow.isVisible());
          }ModalityState.defaultModalityState());
      this.f.a(paramArrayOfTestEntry, null, arrayOfBoolean[0]);
    } 
    ApplicationManager.getApplication().invokeLater(() -> this.z.updateActionsNow());
  }
  
  public void a(String paramString) {
    this.b.clear();
    this.f.a();
    this.f.d(paramString);
  }
  
  public void b(String paramString) {
    this.a.print("core v" + paramString + System.lineSeparator(), ConsoleViewContentType.getConsoleViewType(ProcessOutputTypes.STDOUT));
  }
  
  public void a(a parama) {
    HashSet hashSet = new HashSet(this.j.keySet());
    for (FileMessage fileMessage : parama.a()) {
      String str = fileMessage.b();
      a a1 = this.j.get(str);
      if (a1 != null) {
        a1.a(fileMessage);
      } else {
        this.j.put(str, new a(this.g, fileMessage));
      } 
      hashSet.remove(str);
    } 
    if (!parama.b())
      for (String str : hashSet)
        this.j.remove(str);  
    if (this.k != null)
      this.k.updateFromRoot(); 
    if (this.l != null) {
      boolean bool = false;
      for (a a1 : this.j.values()) {
        if ((a1.a()).length > 0) {
          bool = true;
          break;
        } 
      } 
      SimpleTreeBuilder simpleTreeBuilder = this.l.b();
      if (!bool && this.i != null) {
        this.i.setViewportView(this.E);
      } else if (simpleTreeBuilder != null) {
        this.l.a().a(simpleTreeBuilder);
        if (this.G != null) {
          f f1 = a(this.G.intValue());
          if (f1 != null) {
            k();
            ApplicationManager.getApplication().invokeLater(() -> this.z.selectAndFocus(this.F, true, true).doWhenDone(()));
          } 
        } 
      } 
    } 
    if (this.m != null) {
      boolean bool1 = false;
      for (a a1 : this.j.values()) {
        if ((a1.a()).length > 0) {
          bool1 = true;
          break;
        } 
      } 
      boolean bool2 = bool1;
      ApplicationManager.getApplication().invokeLater(() -> {
            if (!paramBoolean) {
              this.p.setViewportView(this.s);
            } else if (this.m != null) {
              if (this.p.getViewport().getView() != this.m.c())
                this.p.setViewportView((Component)this.m.c()); 
              this.m.a().a(this.m.b());
              this.m.c().invalidate();
              this.m.c().revalidate();
            } 
          });
    } 
    this.G = null;
  }
  
  private void i() {
    if (this.t)
      return; 
    this.t = true;
    ApplicationManager.getApplication().invokeLater(() -> {
          if (this.u)
            this.u = false; 
          this.o.setViewportView(f());
          this.m = a(true, ());
          this.p.setViewportView(this.s);
          this.n.removeAll();
          this.n.add((Component)this.q, b());
          this.n.invalidate();
          this.n.revalidate();
          this.n.repaint();
        });
    this.B = this.z.getContentManager().getSelectedContent();
    ApplicationManager.getApplication().invokeLater(() -> this.z.selectAndFocus(this.A, false, false));
  }
  
  private void j() {
    if (this.u)
      return; 
    this.u = true;
    ApplicationManager.getApplication().invokeLater(() -> {
          if (this.t) {
            if (this.m != null && this.m.b() != null)
              Disposer.dispose((Disposable)this.m.b()); 
            this.m = null;
            this.n.removeAll();
            this.n.add(this.r, b());
            this.t = false;
          } 
          this.n.invalidate();
          this.n.revalidate();
          this.n.repaint();
        });
    if (this.B != null)
      ApplicationManager.getApplication().invokeLater(() -> {
            if (this.B != null) {
              this.z.selectAndFocus(this.B, false, false);
              this.B = null;
            } 
          }); 
  }
  
  public void a() {
    j();
  }
  
  public void a(Trace.TraceData paramTraceData) {
    if (paramTraceData != null) {
      this.y = paramTraceData;
      if (this.x != null) {
        i();
        ApplicationManager.getApplication().invokeLater(() -> {
              this.w.a(this.y, this.x);
              this.D.a();
            });
      } 
    } 
  }
  
  public void a(StatsTrace paramStatsTrace) {
    if (paramStatsTrace == null)
      return; 
    this.x = paramStatsTrace;
    if (this.y != null) {
      i();
      ApplicationManager.getApplication().invokeLater(() -> {
            this.w.a(this.y, this.x);
            this.D.a();
          });
    } 
  }
  
  public void a(String paramString, int paramInt) {
    this.G = null;
    AbstractTreeStructure abstractTreeStructure = this.k.getTreeStructure();
    Object[] arrayOfObject = abstractTreeStructure.getChildElements(abstractTreeStructure.getRootElement());
    a a1 = null;
    for (Object object : arrayOfObject) {
      a1 = (a)object;
      if (a1.getName().equals(paramString))
        break; 
    } 
    if (a1 == null)
      return; 
    a a2 = a1;
    if (a2.b()) {
      k();
      ApplicationManager.getApplication().invokeLater(() -> this.z.selectAndFocus(this.F, true, true).doWhenDone(()));
    } else {
      this.G = Integer.valueOf(paramInt);
      this.k.select(a2);
      this.z.selectAndFocus(this.F, true, true).doWhenDone(() -> k());
    } 
  }
  
  private f a(int paramInt) {
    AbstractTreeStructure abstractTreeStructure = this.l.b().getTreeStructure();
    Object[] arrayOfObject = abstractTreeStructure.getChildElements(abstractTreeStructure.getRootElement());
    f f1 = null;
    for (Object object : arrayOfObject) {
      f1 = (f)object;
      if (f1.d() == paramInt)
        break; 
    } 
    return f1;
  }
  
  private void k() {
    ExecutionManager executionManager = ExecutionManager.getInstance(this.g.d());
    RunContentDescriptor runContentDescriptor = this.g.c();
    if (runContentDescriptor == null)
      return; 
    executionManager.getContentManager().toFrontRunContent(DefaultRunExecutor.getRunExecutorInstance(), runContentDescriptor);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */