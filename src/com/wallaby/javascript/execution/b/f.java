package com.wallaby.javascript.execution.b;

import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColorsUtil;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.util.containers.ContainerUtil;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLabel;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionLocation;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionNode;
import com.wallaby.javascript.extendedCore.inboundMessages.Message;
import java.util.Arrays;
import javax.swing.Icon;

public class f extends SimpleNode {
  private final ExpressionNode b;
  
  private final g c;
  
  private final Message d;
  
  private final boolean e;
  
  private final boolean f;
  
  private final int g;
  
  private final int h;
  
  private boolean i;
  
  private ExpressionNode j;
  
  private f k;
  
  private String l;
  
  public f(g paramg, String paramString, boolean paramBoolean, Message paramMessage) {
    this.l = paramString;
    this.e = true;
    this.c = paramg;
    this.d = paramMessage;
    this.b = paramMessage.i();
    this.g = paramMessage.a();
    this.h = paramMessage.b();
    this.f = (this.b.b() && this.b.c());
    ExpressionLabel expressionLabel = this.b.a();
    if (paramBoolean) {
      getPresentation().addText(paramString, SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
      getPresentation().addText(", ", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    } 
    getPresentation().addText("line " + this.g, SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
    getPresentation().addText((!paramMessage.e().isEmpty() ? (" " + a(paramMessage.e())) : "") + " ", a(DefaultLanguageHighlighterColors.IDENTIFIER));
    getPresentation().addText(expressionLabel.d(), i());
    a(getPresentation());
    paramg.a(this);
  }
  
  private f(g paramg, ExpressionNode paramExpressionNode, f paramf) {
    this.k = paramf;
    this.g = paramf.g;
    this.h = paramf.h;
    this.e = false;
    this.c = paramg;
    this.d = paramf.d;
    this.l = paramf.l;
    this.b = paramExpressionNode;
    this.f = (paramf.f && this.b.c());
    PresentationData presentationData = getPresentation();
    if (!this.b.a().b().isEmpty())
      presentationData.addText(this.b.a().b(), a(DefaultLanguageHighlighterColors.IDENTIFIER)); 
    if (!this.b.a().a().isEmpty()) {
      presentationData.addText(": ", SimpleTextAttributes.REGULAR_ATTRIBUTES);
      presentationData.addText(this.b.a().a() + " ", SimpleTextAttributes.GRAYED_ATTRIBUTES);
    } 
    if (!this.b.a().d().isEmpty()) {
      presentationData.addText(this.b.a().a().isEmpty() ? ": " : "", SimpleTextAttributes.REGULAR_ATTRIBUTES);
      presentationData.addText(this.b.a().d(), i());
    } 
    if (!this.b.a().c().isEmpty())
      presentationData.addText(" " + this.b.a().c(), SimpleTextAttributes.GRAYED_ATTRIBUTES); 
    if (paramExpressionNode.i())
      this.j = (paramf.j != null) ? paramf.j : paramf.b; 
    a(getPresentation());
    paramg.a(this);
  }
  
  private SimpleTextAttributes i() {
    TextAttributesKey textAttributesKey = DefaultLanguageHighlighterColors.KEYWORD;
    String str = this.b.t();
    if (this.b.e())
      return SimpleTextAttributes.ERROR_ATTRIBUTES; 
    if (str.equals("string") || str.equals("date") || str.equals("regexp")) {
      textAttributesKey = DefaultLanguageHighlighterColors.STRING;
    } else if (str.equals("number") || str.equals("boolean")) {
      textAttributesKey = DefaultLanguageHighlighterColors.NUMBER;
    } 
    return a(textAttributesKey);
  }
  
  private SimpleTextAttributes a(TextAttributesKey paramTextAttributesKey) {
    return SimpleTextAttributes.fromTextAttributes(EditorColorsUtil.getGlobalOrDefaultColorScheme().getAttributes(paramTextAttributesKey));
  }
  
  public boolean a() {
    return this.b.m();
  }
  
  public boolean b() {
    return this.b.n();
  }
  
  private String a(String paramString) {
    return paramString.replaceAll("\\r\\n\\s*", " ").replaceAll("\\n\\s*", " ");
  }
  
  private void a(PresentationData paramPresentationData) {
    if (this.b.h() || this.b.k() || this.b.l())
      return; 
    Icon icon = AllIcons.Debugger.Value;
    String str = this.b.t();
    if (this.b.e()) {
      icon = AllIcons.General.BalloonError;
    } else if (str.equals("array") || this.b.i()) {
      icon = AllIcons.Debugger.Db_array;
    } else if (str.equals("string") || str.equals("number") || str.equals("boolean") || str.equals("date") || str.equals("regexp") || str.equals("symbol") || str.equals("undefined") || str.equals("null")) {
      icon = AllIcons.Debugger.Db_primitive;
    } else if (str.equals("function")) {
      icon = AllIcons.Nodes.Function;
    } else if (this.b.j()) {
      icon = AllIcons.Debugger.Frame;
    } 
    paramPresentationData.setIcon(icon);
  }
  
  public SimpleNode[] getChildren() {
    if (!this.b.d())
      return new SimpleNode[0]; 
    ExpressionNode[] arrayOfExpressionNode = this.b.r();
    if (arrayOfExpressionNode.length > 0) {
      String str = this.b.t();
      if (!this.b.i() && !str.equals("array") && !str.equals("Map") && !str.equals("Set"))
        Arrays.sort(arrayOfExpressionNode, (paramExpressionNode1, paramExpressionNode2) -> {
              if (paramExpressionNode1.k() || paramExpressionNode1.h() || paramExpressionNode1.g() || paramExpressionNode2.k() || paramExpressionNode2.h() || paramExpressionNode2.g())
                return 0; 
              String str1 = paramExpressionNode1.a().b().toLowerCase();
              String str2 = paramExpressionNode2.a().b().toLowerCase();
              return str1.compareTo(str2);
            }); 
      return (SimpleNode[])ContainerUtil.map((Object[])arrayOfExpressionNode, paramExpressionNode -> new f(this.c, paramExpressionNode, this)).toArray((Object[])new SimpleNode[arrayOfExpressionNode.length]);
    } 
    if (!this.i) {
      this.i = true;
      this.c.a(!this.b.i() ? this.b.p() : this.j.p(), k(), j());
    } 
    return new SimpleNode[0];
  }
  
  private ExpressionLocation j() {
    f f1;
    for (f1 = this; f1 != null && !f1.g(); f1 = f1.k);
    if (!a && f1 == null)
      throw new AssertionError(); 
    return f1.b.o();
  }
  
  private d k() {
    d d = new d();
    if (this.b.g())
      d.a(2147483647); 
    if (this.b.t().equals("string"))
      d.b(2147483647); 
    if (this.b.i() && this.j != null)
      d.a(new c(this.j, this.b)); 
    return d;
  }
  
  public boolean isAlwaysShowPlus() {
    return this.b.d();
  }
  
  public boolean isAlwaysLeaf() {
    return !this.b.d();
  }
  
  public Object[] getEqualityObjects() {
    return new Object[] { this.b };
  }
  
  public String c() {
    return this.b.s();
  }
  
  public boolean isAutoExpandNode() {
    return (this.f && this.c.b(c()));
  }
  
  public int d() {
    return this.g;
  }
  
  public void e() {
    this.c.a(this.b);
  }
  
  public void f() {
    if ((this.b.q()).length > 0)
      this.c.a(StringUtil.join(this.b.q())); 
  }
  
  public boolean g() {
    return this.e;
  }
  
  public void h() {
    this.c.a(this.l, this.g, this.h);
  }
  
  public void handleSelection(SimpleTree tree) {
    super.handleSelection(tree);
    if (this.b.j() && this.b.w() != null)
      this.c.a(this.b.w().d(), this.b.w().a(), this.b.w().b()); 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/b/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */