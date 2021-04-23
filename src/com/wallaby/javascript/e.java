package com.wallaby.javascript;

import com.intellij.openapi.editor.ex.RangeHighlighterEx;
import com.intellij.util.CommonProcessors;

class e extends CommonProcessors.FindProcessor<RangeHighlighterEx> {
  e(b paramb, f[] paramArrayOff) {}
  
  protected boolean a(RangeHighlighterEx paramRangeHighlighterEx) {
    f f1 = (f)paramRangeHighlighterEx.getUserData(f.a);
    if (f1 != null && f1.h())
      this.a[0] = f1; 
    return (this.a[0] != null);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */