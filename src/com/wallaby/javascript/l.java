package com.wallaby.javascript;

import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.ui.DarculaColors;
import com.intellij.ui.JBColor;
import java.awt.Color;

public class l {
  public static final ColorKey a = ColorKey.createColorKey("WALLABY.ERROR_SOURCE", (Color)new JBColor(DarculaColors.RED, DarculaColors.RED));
  
  public static final ColorKey b = ColorKey.createColorKey("WALLABY.ERROR_PATH", (Color)new JBColor(new Color(255, 160, 160), new Color(255, 160, 160)));
  
  public static final ColorKey c = ColorKey.createColorKey("WALLABY.FULL_COVERAGE", (Color)new JBColor(new Color(98, 180, 85), new Color(98, 180, 85)));
  
  public static final ColorKey d = ColorKey.createColorKey("WALLABY.PARTIAL_COVERAGE", (Color)new JBColor(new Color(210, 160, 50), (Color)JBColor.ORANGE));
  
  public static final ColorKey e = ColorKey.createColorKey("WALLABY.NO_COVERAGE", (Color)JBColor.GRAY);
  
  public static final ColorKey f = ColorKey.createColorKey("WALLABY.INLINE_ERROR", ConsoleViewContentType.ERROR_OUTPUT.getAttributes().getForegroundColor());
  
  public static final ColorKey g = ColorKey.createColorKey("WALLABY.INLINE_LOG", ConsoleViewContentType.SYSTEM_OUTPUT.getAttributes().getForegroundColor());
  
  public static final ColorKey h = ColorKey.createColorKey("WALLABY.INLINE_SYSTEM_LOG", (Color)JBColor.GRAY);
  
  public static final ColorKey i = ColorKey.createColorKey("WALLABY.ACTIVE_DEBUGGER_STEP", (Color)new JBColor(new Color(255, 255, 186), new Color(75, 75, 24)));
  
  public static Color a(ColorKey paramColorKey) {
    EditorColorsManager editorColorsManager = EditorColorsManager.getInstance();
    EditorColorsScheme editorColorsScheme = editorColorsManager.getGlobalScheme();
    return editorColorsScheme.getColor(paramColorKey);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */