package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;

public class FileMessage {
  private ArrayList<Message> messages;
  
  private String name;
  
  private String myId;
  
  public Message[] a() {
    return (this.messages == null) ? new Message[0] : this.messages.<Message>toArray(new Message[0]);
  }
  
  public String b() {
    return StringUtil.notNullize(this.myId);
  }
  
  public void a(String paramString) {
    this.myId = paramString;
  }
  
  public String c() {
    return StringUtil.notNullize(this.name);
  }
  
  public void d() {
    for (Message message : this.messages) {
      ExpressionNode expressionNode = message.i();
      if (StringUtil.notNullize(expressionNode.v()).isEmpty())
        expressionNode.b(message.e()); 
      if (StringUtil.notNullize(expressionNode.v()).isEmpty())
        expressionNode.b(message.e()); 
      String[] arrayOfString = message.c().split(":");
      if (!StringUtil.notNullize(arrayOfString[0]).isEmpty())
        expressionNode.b("line " + arrayOfString[0] + ": " + expressionNode.v()); 
      if (StringUtil.notNullize(expressionNode.a().b()).isEmpty())
        expressionNode.a().a(expressionNode.v()); 
      expressionNode.a(message.e());
      expressionNode.x();
      int i = 0;
      try {
        i = Integer.parseInt(arrayOfString[0]);
      } catch (Exception exception) {}
      expressionNode.a(this.name, i);
    } 
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/FileMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */