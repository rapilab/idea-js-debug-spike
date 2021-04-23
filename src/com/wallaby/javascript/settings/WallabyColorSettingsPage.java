package com.wallaby.javascript.settings;

import a.a;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.psi.codeStyle.DisplayPrioritySortable;
import com.intellij.util.messages.Topic;
import com.wallaby.javascript.k;
import com.wallaby.javascript.l;
import java.util.Map;
import javax.swing.Icon;

public class WallabyColorSettingsPage implements ColorSettingsPage, DisplayPrioritySortable {
  public static Topic<a> a = Topic.create("Wallaby notifications", a.class);
  
  private static final AttributesDescriptor[] b = new AttributesDescriptor[0];
  
  private static final ColorDescriptor[] c = new ColorDescriptor[] { new ColorDescriptor(k.a("configuration.colorSettings.errorSource", new Object[0]), l.a, ColorDescriptor.Kind.BACKGROUND), new ColorDescriptor(k.a("configuration.colorSettings.errorPath", new Object[0]), l.b, ColorDescriptor.Kind.BACKGROUND), new ColorDescriptor(k.a("configuration.colorSettings.fullyCovered", new Object[0]), l.c, ColorDescriptor.Kind.BACKGROUND), new ColorDescriptor(k.a("configuration.colorSettings.partiallyCovered", new Object[0]), l.d, ColorDescriptor.Kind.BACKGROUND), new ColorDescriptor(k.a("configuration.colorSettings.notCovered", new Object[0]), l.e, ColorDescriptor.Kind.BACKGROUND), new ColorDescriptor(k.a("configuration.colorSettings.inlineError", new Object[0]), l.f, ColorDescriptor.Kind.FOREGROUND), new ColorDescriptor(k.a("configuration.colorSettings.inlineLog", new Object[0]), l.g, ColorDescriptor.Kind.FOREGROUND), new ColorDescriptor(k.a("configuration.colorSettings.inlineSystemLog", new Object[0]), l.h, ColorDescriptor.Kind.FOREGROUND), new ColorDescriptor(k.a("configuration.colorSettings.activeDebuggerStep", new Object[0]), l.i, ColorDescriptor.Kind.BACKGROUND) };
  
  public Icon getIcon() {
    return a.a;
  }
  
  public SyntaxHighlighter getHighlighter() {
    ((a)ApplicationManager.getApplication().getMessageBus().syncPublisher(a)).colorSettingsChanged();
    return (SyntaxHighlighter)new b(this);
  }
  
  public String getDemoText() {
    return "";
  }
  
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }
  
  public AttributesDescriptor[] getAttributeDescriptors() {
    return b;
  }
  
  public ColorDescriptor[] getColorDescriptors() {
    return c;
  }
  
  public String getDisplayName() {
    return k.a("configuration.name", new Object[0]);
  }
  
  public DisplayPriority getPriority() {
    return DisplayPriority.OTHER_SETTINGS;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/settings/WallabyColorSettingsPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */