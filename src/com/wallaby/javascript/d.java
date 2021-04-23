package com.wallaby.javascript;

import com.intellij.openapi.editor.ex.RangeHighlighterEx;
import com.intellij.util.CommonProcessors;

class d extends CommonProcessors.FindProcessor<RangeHighlighterEx> {
  d(c paramc, int paramInt) {}
  
  protected boolean a(RangeHighlighterEx paramRangeHighlighterEx) {
    f f = (f)paramRangeHighlighterEx.getUserData(f.a);
    if (f != null && f.h() && f.a(this.a))
      f.i(); 
    return false;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */