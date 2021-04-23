package com.wallaby.javascript.extendedCore.inboundMessages;

import java.util.Map;
import java.util.Set;

public class DocumentUpdates {
  private Map<String, DocumentUpdate> updates;
  
  public Set<String> a() {
    return this.updates.keySet();
  }
  
  public DocumentUpdate a(String paramString) {
    return this.updates.get(paramString);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/DocumentUpdates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */