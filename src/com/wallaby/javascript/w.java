package com.wallaby.javascript;

import a.a;
import com.intellij.openapi.wm.CustomStatusBarWidget;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.util.ui.AsyncProcessIcon;
import com.intellij.util.ui.JBUI;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class w extends JButton implements CustomStatusBarWidget {
  private JLabel a = new JLabel();
  
  private AsyncProcessIcon b = new AsyncProcessIcon("wallaby process");
  
  private StatusBar c;
  
  private WallabyStatus d;
  
  w(m paramm) {
    setOpaque(false);
    setVisible(true);
    setBorder((Border)JBUI.Borders.empty());
    addMouseListener(new x(this, paramm));
  }
  
  protected void paintComponent(Graphics graphics) {}
  
  public JComponent getComponent() {
    return this;
  }
  
  public String ID() {
    return k.a("status.widget.id", new Object[0]);
  }
  
  public StatusBarWidget.WidgetPresentation getPresentation(StatusBarWidget.PlatformType type) {
    return null;
  }
  
  public void install(StatusBar statusBar) {
    this.c = statusBar;
    a(WallabyStatus.INACTIVE);
  }
  
  public Dimension getPreferredSize() {
    return this.b.getPreferredSize();
  }
  
  public Dimension getMinimumSize() {
    return this.b.getMinimumSize();
  }
  
  public Dimension getMaximumSize() {
    return this.b.getMaximumSize();
  }
  
  void a(WallabyStatus paramWallabyStatus) {
    if (this.d == paramWallabyStatus)
      return; 
    removeAll();
    switch (y.a[paramWallabyStatus.ordinal()]) {
      case 1:
        this.a.setIcon(a.b);
        setToolTipText(k.a("status.red", new Object[0]));
        add(this.a);
        break;
      case 2:
        this.a.setIcon(a.a);
        setToolTipText(k.a("status.green", new Object[0]));
        add(this.a);
        break;
      case 3:
        this.a.setIcon(a.c);
        setToolTipText(k.a("status.inactive", new Object[0]));
        add(this.a);
        break;
      case 4:
        setToolTipText(k.a("status.progress", new Object[0]));
        add((Component)this.b);
        break;
    } 
    if (this.c != null) {
      this.c.updateWidget(ID());
      invalidate();
      revalidate();
    } 
    this.d = paramWallabyStatus;
  }
  
  public void dispose() {
    this.b.dispose();
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */