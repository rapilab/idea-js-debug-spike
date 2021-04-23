package com.wallaby.javascript;

import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.ex.MarkupModelEx;
import com.intellij.openapi.editor.impl.DocumentMarkupModel;
import com.intellij.util.Processor;
import java.util.Date;

class c implements DocumentListener {
  c(b paramb) {}
  
  public void beforeDocumentChange(DocumentEvent e) {
    if (b.a(this.a))
      return; 
    int i = e.getOffset();
    int j = b.b(this.a).getLineNumber(i) + 1;
    int k = b.b(this.a).getLineNumber(i + e.getOldFragment().length()) + 1;
    synchronized (b.c(this.a)) {
      if (b.a.a(b.d(this.a)) == null || b.a.a(b.d(this.a)).intValue() > j)
        b.a.a(b.d(this.a), Integer.valueOf(j)); 
      if (b.a.b(b.d(this.a)) == null || b.a.b(b.d(this.a)).intValue() < k)
        b.a.b(b.d(this.a), Integer.valueOf(k)); 
    } 
    b.f(this.a).cancelRequest(b.e(this.a));
    int m = e.getNewLength() - e.getOldLength();
    if (m > 0)
      return; 
    int n = b.b(this.a).getLineNumber(i);
    MarkupModelEx markupModelEx = (MarkupModelEx)DocumentMarkupModel.forDocument(b.b(this.a), b.g(this.a), true);
    markupModelEx.processRangeHighlightersOverlappingWith(b.b(this.a).getLineStartOffset(n), b.b(this.a).getLineEndOffset(b.b(this.a).getLineNumber(i + Math.abs(m))), (Processor)new d(this, n));
  }
  
  public void documentChanged(DocumentEvent e) {
    if (b.a(this.a))
      return; 
    b.f(this.a).cancelRequest(b.e(this.a));
    b.f(this.a).addRequest(b.e(this.a), b.h(this.a));
    b.a(this.a, (new Date()).getTime());
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */