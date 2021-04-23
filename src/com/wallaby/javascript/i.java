package com.wallaby.javascript;

import com.intellij.util.ui.UIUtil;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

class i extends JPanel {
  i(h.a parama, LayoutManager paramLayoutManager) {
    super(paramLayoutManager);
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(UIUtil.isUnderDarcula() ? h.a.a() : h.a.b());
    g.drawLine(0, 0, getWidth(), 0);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */