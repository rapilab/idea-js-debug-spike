package com.wallaby.javascript.extendedCore.inboundMessages;

import java.util.ArrayList;

public class a {
  ArrayList<FileMessage> a = new ArrayList<>();
  
  private Boolean b;
  
  public void a(FileMessage paramFileMessage) {
    this.a.add(paramFileMessage);
  }
  
  public FileMessage[] a() {
    return this.a.<FileMessage>toArray(new FileMessage[0]);
  }
  
  public boolean b() {
    return (this.b != null && this.b.booleanValue());
  }
  
  public void a(boolean paramBoolean) {
    this.b = Boolean.valueOf(paramBoolean);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */