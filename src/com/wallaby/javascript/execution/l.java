package com.wallaby.javascript.execution;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.TextFieldWithHistory;
import com.intellij.ui.TextFieldWithHistoryWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import com.wallaby.javascript.k;
import java.awt.Component;
import java.awt.event.ItemEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class l extends SettingsEditor<j> {
  private final TextFieldWithHistoryWithBrowseButton a;
  
  private final TextFieldWithHistoryWithBrowseButton b;
  
  private final TextFieldWithHistoryWithBrowseButton c;
  
  private final ComboBox d;
  
  private final ComboBox e;
  
  private final JPanel f;
  
  private JLabel g;
  
  private JLabel h;
  
  private final Project i;
  
  l(Project paramProject) {
    this.i = paramProject;
    this.a = a.a(paramProject);
    this.b = a.b(paramProject);
    this.c = a.d(paramProject);
    this.e = a.a();
    if (SystemInfo.isWindows) {
      this.d = a.b();
      this.f = FormBuilder.createFormBuilder().addLabeledComponent(k.a("configuration.label.configType", new Object[0]), (JComponent)this.e).addLabeledComponent(k.a("configuration.label.configFile", new Object[0]), (JComponent)this.a).addLabeledComponent(k.a("configuration.label.configFolder", new Object[0]), (JComponent)this.b).addLabeledComponent(k.a("configuration.label.nodeFile", new Object[0]), (JComponent)this.c).addTooltip("This is the node executable to run wallaby.js itself. Do not change the path unless necessary.").addLabeledComponent(k.a("configuration.label.wsl", new Object[0]), (JComponent)this.d).getPanel();
    } else {
      this.d = null;
      this.f = FormBuilder.createFormBuilder().addLabeledComponent(k.a("configuration.label.configType", new Object[0]), (JComponent)this.e).addLabeledComponent(k.a("configuration.label.configFile", new Object[0]), (JComponent)this.a).addLabeledComponent(k.a("configuration.label.configFolder", new Object[0]), (JComponent)this.b).addLabeledComponent(k.a("configuration.label.nodeFile", new Object[0]), (JComponent)this.c).addTooltip("This is the node executable to run wallaby.js itself. Do not change the path unless necessary.").getPanel();
    } 
    this.g = null;
    this.h = null;
    for (byte b = 0; b < this.f.getComponentCount(); b++) {
      Component component = this.f.getComponent(b);
      if (component instanceof JLabel) {
        JLabel jLabel = (JLabel)component;
        if (jLabel.getLabelFor() == this.a) {
          this.g = jLabel;
        } else if (jLabel.getLabelFor() == this.b) {
          this.h = jLabel;
        } 
      } 
    } 
    a(false);
    this.e.addItemListener(paramItemEvent -> {
          if (paramItemEvent.getStateChange() == 1)
            a(this.e.getSelectedItem().toString().equals("Configuration File")); 
        });
  }
  
  private void a(boolean paramBoolean) {
    this.a.setVisible(paramBoolean);
    this.g.setVisible(paramBoolean);
    this.b.setVisible(!paramBoolean);
    this.h.setVisible(!paramBoolean);
  }
  
  protected void a(j paramj) {
    b b = paramj.a();
    this.e.setSelectedItem(b.f());
    a.a((TextFieldWithHistory)this.b.getChildComponent(), FileUtil.toSystemDependentName(this.i.getBasePath()));
    if (!b.b().equals(FileUtil.toSystemDependentName(this.i.getBasePath())))
      a.a((TextFieldWithHistory)this.b.getChildComponent(), b.b()); 
    a.a((TextFieldWithHistory)this.b.getChildComponent(), b.b());
    a.a((TextFieldWithHistory)this.a.getChildComponent(), b.a());
    a.a((TextFieldWithHistory)this.c.getChildComponent(), "{SYSTEM DEFAULT}");
    a.a((TextFieldWithHistory)this.c.getChildComponent(), b.c());
    if (SystemInfo.isWindows)
      this.d.setSelectedItem(b.e()); 
  }
  
  protected void b(j paramj) {
    paramj.a(new b(StringUtil.notNullize(((TextFieldWithHistory)this.a.getChildComponent()).getText()), StringUtil.notNullize(((TextFieldWithHistory)this.b.getChildComponent()).getText()), StringUtil.notNullize(((TextFieldWithHistory)this.c.getChildComponent()).getText()), StringUtil.notNullize((this.d == null) ? "No" : this.d.getSelectedItem().toString()), StringUtil.notNullize(this.e.getSelectedItem().toString())));
  }
  
  protected JComponent createEditor() {
    return this.f;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */