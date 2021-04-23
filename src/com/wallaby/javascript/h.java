package com.wallaby.javascript;

import com.intellij.execution.filters.TextConsoleBuilderImpl;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.IdeFocusManager;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.intellij.ui.awt.RelativePoint;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.ui.JBUI;
import com.wallaby.javascript.actions.ShowLineTestsAction;
import com.wallaby.javascript.extendedCore.inboundMessages.LineReport;
import com.wallaby.javascript.extendedCore.inboundMessages.TestEntry;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

abstract class h {
  private static volatile a b;
  
  static void a(LineReport paramLineReport, Project paramProject, Editor paramEditor, f paramf, AnActionEvent paramAnActionEvent) {
    synchronized (ShowLineTestsAction.class) {
      if (b != null) {
        a.a(b);
        b = null;
      } 
      b = new a(paramProject, WallabyController.a(paramProject), paramEditor, paramAnActionEvent, paramLineReport, paramf.a());
    } 
    if (!a && b == null)
      throw new AssertionError(); 
  }
  
  static {
    b = null;
  }
  
  public static class a extends JPanel implements KeyListener {
    private static final Color a = (Color)Gray._135;
    
    private static final Color b = (Color)new JBColor(a.brighter(), (Color)Gray._75);
    
    private final JBPopup c;
    
    private final JLabel d;
    
    private final ConsoleView e;
    
    private final Runnable f = this::c;
    
    private final TestPrinter g;
    
    a(Project param1Project, m param1m, Editor param1Editor, AnActionEvent param1AnActionEvent, LineReport param1LineReport, CoverageState param1CoverageState) {
      super(new BorderLayout(0, 0));
      setFocusable(true);
      addKeyListener(this);
      setBorder((Border)JBUI.Borders.empty());
      setBackground(JBColor.background());
      setPreferredSize(new Dimension(600, 300));
      this.d = new JLabel(" ");
      Font font = this.d.getFont();
      this.d.setFont(font.deriveFont(Math.max(10.0F, font.getSize() - 4.0F)));
      this.d.setHorizontalAlignment(2);
      i i = new i(this, new BorderLayout());
      i.setBorder(BorderFactory.createEmptyBorder(1, 4, 1, 4));
      i.add(this.d, "Center");
      TextConsoleBuilderImpl textConsoleBuilderImpl = new TextConsoleBuilderImpl(param1Project);
      textConsoleBuilderImpl.setViewer(true);
      textConsoleBuilderImpl.setUsePredefinedMessageFilter(false);
      this.e = textConsoleBuilderImpl.getConsole();
      this.g = new TestPrinter(param1m, this.e);
      JComponent jComponent1 = this.e.getComponent();
      add(jComponent1, "Center");
      add(i, "South");
      a(param1LineReport, param1CoverageState);
      this.c = JBPopupFactory.getInstance().createComponentPopupBuilder(this, this).setResizable(true).setModalContext(false).setFocusable(true).setRequestFocus(true).setTitle(k.a("dialogs.showTests.title", new Object[0])).setCancelOnWindowDeactivation(true).setCancelOnOtherWindowOpen(true).setMovable(true).setCancelKeyEnabled(false).setCancelCallback(() -> {
            h.a(null);
            return Boolean.valueOf(true);
          }).createPopup();
      this.c.addListener(new j(this));
      if (param1AnActionEvent != null) {
        if (param1AnActionEvent.getInputEvent() instanceof MouseEvent) {
          this.c.show(new RelativePoint((MouseEvent)param1AnActionEvent.getInputEvent()));
        } else {
          this.c.showInBestPositionFor(param1AnActionEvent.getDataContext());
        } 
      } else {
        this.c.showInBestPositionFor(param1Editor);
      } 
      IdeFocusManager ideFocusManager = IdeFocusManager.getInstance(param1Project);
      JComponent jComponent2 = this.e.getPreferredFocusableComponent();
      jComponent2.addKeyListener(this);
      ideFocusManager.requestFocus(jComponent2, true);
    }
    
    private void a(LineReport param1LineReport, CoverageState param1CoverageState) {
      TestEntry[] arrayOfTestEntry = param1LineReport.d();
      if (arrayOfTestEntry.length > 0) {
        int i = ContainerUtil.filter((Object[])arrayOfTestEntry, param1TestEntry -> ((param1TestEntry.e()).length != 0)).size();
        this.d.setText(String.format(k.a("dialogs.showTests.detailsTemplate", new Object[0]), new Object[] { Integer.valueOf(i), Integer.valueOf(arrayOfTestEntry.length - i), Integer.valueOf(arrayOfTestEntry.length) }));
        this.g.a(arrayOfTestEntry, this.f, false);
      } else {
        this.d.setText("");
        this.g.c((param1CoverageState == CoverageState.NOT_COVERED) ? k.a("dialogs.showTests.noCoveringTestsAtAll", new Object[0]) : k.a("dialogs.showTests.noCoveringTests", new Object[0]));
      } 
    }
    
    public void keyTyped(KeyEvent keyEvent) {}
    
    public void keyPressed(KeyEvent keyEvent) {
      if (keyEvent.getKeyCode() == 27)
        c(); 
    }
    
    public void keyReleased(KeyEvent keyEvent) {}
    
    private void c() {
      this.c.cancel();
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */