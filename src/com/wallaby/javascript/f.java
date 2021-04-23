package com.wallaby.javascript;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.ex.MarkupModelEx;
import com.intellij.openapi.editor.impl.DocumentMarkupModel;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.Gray;
import com.wallaby.javascript.actions.GutterClickAction;
import com.wallaby.javascript.extendedCore.inboundMessages.LineData;
import com.wallaby.javascript.extendedCore.inboundMessages.LineMetadata;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;

public class f implements Disposable {
  static final Key<f> a = new Key("DocumentLineKey");
  
  private final Document b;
  
  private final VirtualFile c;
  
  private final Project d;
  
  private final int e;
  
  private boolean f;
  
  private String g;
  
  private String h;
  
  private CoverageState i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private RangeHighlighter o;
  
  public f(Project paramProject, VirtualFile paramVirtualFile, Document paramDocument, LineData paramLineData) {
    this.c = paramVirtualFile;
    this.d = paramProject;
    this.b = paramDocument;
    this.e = paramLineData.a();
    this.i = paramLineData.b();
    this.g = paramLineData.d();
    this.h = paramLineData.f();
    this.j = paramLineData.c();
    LineMetadata lineMetadata = paramLineData.g();
    if (lineMetadata != null) {
      this.l = lineMetadata.b();
      if (lineMetadata.a() != null) {
        this.f = lineMetadata.a().b();
        this.k = lineMetadata.a().a();
      } else {
        this.f = lineMetadata.c();
      } 
    } 
  }
  
  public CoverageState a() {
    return this.i;
  }
  
  public String b() {
    return StringUtil.notNullize(this.h);
  }
  
  public String c() {
    return StringUtil.notNullize(this.g);
  }
  
  public boolean d() {
    return this.j;
  }
  
  public boolean e() {
    return this.l;
  }
  
  public boolean f() {
    return this.f;
  }
  
  public boolean g() {
    return this.k;
  }
  
  boolean h() {
    return (!this.m && !this.n && (this.o == null || this.o.isValid()));
  }
  
  public boolean a(LineData paramLineData) {
    CoverageState coverageState = paramLineData.b();
    String str1 = paramLineData.d();
    String str2 = paramLineData.f();
    boolean bool1 = paramLineData.c();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    LineMetadata lineMetadata = paramLineData.g();
    if (lineMetadata != null) {
      bool2 = lineMetadata.b();
      if (lineMetadata.a() != null) {
        bool3 = lineMetadata.a().b();
        bool4 = lineMetadata.a().a();
      } else {
        bool3 = lineMetadata.c();
      } 
    } 
    boolean bool = (this.i != coverageState || !c().equals(str1) || !b().equals(str2) || bool1 != this.j || bool2 != this.l || bool3 != this.f || bool4 != this.k) ? true : false;
    this.i = coverageState;
    this.j = bool1;
    this.l = bool2;
    this.f = bool3;
    this.k = bool4;
    this.g = str1;
    this.h = str2;
    return bool;
  }
  
  public void i() {
    if (h()) {
      this.o.setGutterIconRenderer(null);
      this.m = true;
    } 
  }
  
  public boolean a(int paramInt) {
    return (paramInt < n());
  }
  
  public void dispose() {
    this.n = true;
    if (this.o != null) {
      this.o.dispose();
      this.o.putUserData(a, null);
    } 
  }
  
  void j() {
    if (this.o == null)
      try {
        this.o = m();
        this.o.putUserData(a, this);
      } catch (Exception exception) {
        this.m = true;
        return;
      }  
    if (this.o.isValid())
      l(); 
    int i = n();
    for (EditorEx editorEx : b.a(this.d, this.c))
      editorEx.repaint(this.b.getLineStartOffset(i), this.b.getLineEndOffset(i)); 
  }
  
  private RangeHighlighter m() {
    MarkupModelEx markupModelEx = (MarkupModelEx)DocumentMarkupModel.forDocument(this.b, this.d, true);
    return (RangeHighlighter)markupModelEx.addPersistentLineHighlighter(n(), 5999, null);
  }
  
  public int k() {
    if (this.o == null)
      return this.e; 
    try {
      return this.b.getLineNumber(this.o.getStartOffset()) + 1;
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
      return this.e;
    } 
  }
  
  private int n() {
    return k() - 1;
  }
  
  void l() {
    if (this.o != null)
      this.o.setGutterIconRenderer(new a(this)); 
  }
  
  public static class a extends GutterIconRenderer {
    private static final HashMap<CoverageState, Icon> a = new HashMap<>();
    
    private static final int b = 10;
    
    private static GutterIconRenderer.Alignment c = GutterIconRenderer.Alignment.LEFT;
    
    private static final Runnable d = () -> {
        a.put(CoverageState.NOT_COVERED, a(l.a(l.e)));
        a.put(CoverageState.FULL_COVERAGE, a(l.a(l.c)));
        a.put(CoverageState.PARTIAL_COVERAGE, a(l.a(l.d)));
        a.put(CoverageState.ERROR_SOURCE, a(l.a(l.a)));
        a.put(CoverageState.ERROR_PATH, a(l.a(l.b)));
      };
    
    private final Icon e;
    
    private final f f;
    
    private static a a(Color param1Color) {
      return new a(10, param1Color);
    }
    
    a(f param1f) {
      this.e = a.get(f.a(param1f));
      this.f = param1f;
    }
    
    static void a() {
      d.run();
    }
    
    public AnAction getClickAction() {
      return (AnAction)new GutterClickAction(this.f);
    }
    
    public Icon getIcon() {
      return this.e;
    }
    
    public GutterIconRenderer.Alignment getAlignment() {
      return c;
    }
    
    public boolean equals(Object o) {
      if (this == o)
        return true; 
      if (o == null || getClass() != o.getClass())
        return false; 
      a a1 = (a)o;
      return this.e.equals(a1.e);
    }
    
    public int hashCode() {
      return this.e.hashCode();
    }
    
    static {
      d.run();
      try {
        if (ApplicationInfo.getInstance().getVersionName().equals("Rider"))
          c = GutterIconRenderer.Alignment.RIGHT; 
      } catch (Exception exception) {}
    }
    
    private static class a extends b {
      private int a;
      
      a(int param2Int, Color param2Color) {
        super(param2Int, param2Color);
        this.a = param2Int;
      }
      
      public void paintIcon(Component component, Graphics g, int i, int j) {
        Graphics2D graphics2D = (Graphics2D)g;
        int k = getIconWidth();
        int m = getIconHeight();
        graphics2D.setColor(a());
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int n = i + (k - this.a) / 2;
        int i1 = j + (m - this.a) / 2;
        graphics2D.fillRoundRect(n, i1, this.a, this.a, this.a / 2, this.a / 2);
      }
    }
    
    private static class b extends c {
      private final Color a;
      
      private boolean b;
      
      private int c;
      
      b(int param2Int1, int param2Int2, Color param2Color, boolean param2Boolean) {
        super(param2Int1, param2Int1);
        this.a = param2Color;
        this.c = param2Int2;
        this.b = param2Boolean;
      }
      
      b(int param2Int, Color param2Color, boolean param2Boolean) {
        this(param2Int, param2Int, param2Color, param2Boolean);
      }
      
      b(int param2Int, Color param2Color) {
        this(param2Int, param2Color, false);
      }
      
      Color a() {
        return this.a;
      }
      
      public void paintIcon(Component component, Graphics g, int i, int j) {
        int k = getIconWidth();
        int m = getIconHeight();
        g.setColor(a());
        int n = i + (k - this.c) / 2;
        int i1 = j + (m - this.c) / 2;
        g.fillRect(n, i1, this.c, this.c);
        if (this.b) {
          g.setColor(Gray.x00.withAlpha(40));
          g.drawRect(n, i1, this.c, this.c);
        } 
      }
      
      public boolean equals(Object o) {
        if (this == o)
          return true; 
        if (o != null && getClass() == o.getClass()) {
          if (!super.equals(o))
            return false; 
          b b1 = (b)o;
          return (this.b != b1.b) ? false : ((this.c != b1.c) ? false : ((this.a != null) ? this.a.equals(b1.a) : ((b1.a == null))));
        } 
        return false;
      }
      
      public int hashCode() {
        null = super.hashCode();
        null = 31 * null + ((this.a != null) ? this.a.hashCode() : 0);
        null = 31 * null + (this.b ? 1 : 0);
        return 31 * null + this.c;
      }
    }
    
    private static class c implements Icon {
      private static final Map<Integer, Icon> a = new HashMap<>();
      
      private final int b;
      
      private final int c;
      
      private float d = 1.0F;
      
      c(int param2Int1, int param2Int2) {
        this.b = param2Int1;
        this.c = param2Int2;
      }
      
      static Icon a(int param2Int) {
        Icon icon = a.get(Integer.valueOf(param2Int));
        if (icon == null && param2Int < 129)
          a.put(Integer.valueOf(param2Int), icon = a(param2Int, param2Int)); 
        return (icon == null) ? new c(param2Int, param2Int) : icon;
      }
      
      static Icon a(int param2Int1, int param2Int2) {
        return (param2Int1 == param2Int2) ? a(param2Int1) : new c(param2Int1, param2Int2);
      }
      
      public int getIconWidth() {
        return (this.d == 1.0F) ? this.b : (int)(this.b * this.d);
      }
      
      public int getIconHeight() {
        return (this.d == 1.0F) ? this.c : (int)(this.c * this.d);
      }
      
      public void paintIcon(Component component, Graphics g, int i, int j) {}
      
      public boolean equals(Object o) {
        if (this == o)
          return true; 
        if (!(o instanceof c))
          return false; 
        c c1 = (c)o;
        return (this.c == c1.c && this.b == c1.b && this.d == c1.d);
      }
      
      public int hashCode() {
        null = this.b;
        null = 31 * null + this.c;
        return 31 * null + ((this.d != 0.0F) ? Float.floatToIntBits(this.d) : 0);
      }
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */