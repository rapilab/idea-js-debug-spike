package com.wallaby.javascript.execution.b;

import com.google.gson.ExclusionStrategy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wallaby.javascript.extendedCore.inboundMessages.ExpressionNode;

public class d {
  private Integer a;
  
  private Integer b;
  
  private JsonObject c;
  
  public Integer a() {
    return this.a;
  }
  
  public Integer b() {
    return this.b;
  }
  
  void a(int paramInt) {
    this.a = Integer.valueOf(paramInt);
  }
  
  void b(int paramInt) {
    this.b = Integer.valueOf(paramInt);
  }
  
  void a(c paramc) {
    this.c = a(paramc.a(), paramc.b(), true);
  }
  
  public JsonObject c() {
    return this.c;
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    d d1 = (d)o;
    return ((this.a != null) ? !this.a.equals(d1.a) : (d1.a != null)) ? false : (((this.b != null) ? !this.b.equals(d1.b) : (d1.b != null)) ? false : ((this.c != null) ? this.c.equals(d1.c) : ((d1.c == null))));
  }
  
  public int hashCode() {
    null = (this.a != null) ? this.a.hashCode() : 0;
    null = 31 * null + ((this.b != null) ? this.b.hashCode() : 0);
    return 31 * null + ((this.c != null) ? this.c.hashCode() : 0);
  }
  
  private JsonObject a(ExpressionNode paramExpressionNode1, ExpressionNode paramExpressionNode2, boolean paramBoolean) {
    JsonObject jsonObject = (new GsonBuilder()).setExclusionStrategies(new ExclusionStrategy[] { new e(this) }).create().toJsonTree(paramExpressionNode1).getAsJsonObject();
    if (!paramBoolean)
      return jsonObject; 
    JsonArray jsonArray = new JsonArray();
    for (ExpressionNode expressionNode : paramExpressionNode1.r()) {
      boolean bool = (((expressionNode.r()).length == 0 && expressionNode == paramExpressionNode2) || ((expressionNode.r()).length > 0 && !expressionNode.r()[0].i())) ? true : false;
      JsonObject jsonObject1 = a(expressionNode, paramExpressionNode2, !bool);
      if (bool)
        jsonObject1.addProperty("props", Boolean.valueOf(true)); 
      jsonArray.add((JsonElement)jsonObject1);
    } 
    jsonObject.add("props", (JsonElement)jsonArray);
    return jsonObject;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/b/d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */