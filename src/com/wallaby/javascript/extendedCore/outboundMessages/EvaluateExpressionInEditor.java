package com.wallaby.javascript.extendedCore.outboundMessages;

public class EvaluateExpressionInEditor extends OutboundMessageBase {
  private String path;
  
  private String content;
  
  private int[] range;
  
  private String action;
  
  public EvaluateExpressionInEditor(String path, String content, int[] range, String action) {
    super("evaluateExpressionInEditor");
    this.path = path;
    this.content = content;
    this.range = range;
    this.action = action;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/EvaluateExpressionInEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */