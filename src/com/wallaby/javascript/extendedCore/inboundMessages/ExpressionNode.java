package com.wallaby.javascript.extendedCore.inboundMessages;

import com.google.gson.JsonElement;
import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;

public class ExpressionNode {
  private String name;
  
  private String id;
  
  private ExpressionLabel label;
  
  private Boolean expandable;
  
  private Boolean disallowToCopyPath;
  
  private Boolean disallowToCopyData;
  
  private ArrayList<String> queryPath;
  
  private ArrayList<String> expressionPath;
  
  private Boolean autoExpand;
  
  private String capped;
  
  private Boolean cappedProps;
  
  private Boolean getter;
  
  private Boolean setter;
  
  private Boolean loadActionNode;
  
  private Boolean functionsNode;
  
  private Boolean rangeNode;
  
  private Boolean callStackNode = null;
  
  private Boolean callStackEntryNode = null;
  
  private Boolean proxyNode = null;
  
  private String type;
  
  private String error;
  
  private Integer length;
  
  private ArrayList<ExpressionNode> props;
  
  private JsonElement value;
  
  private String context;
  
  private Boolean rootValueNode = null;
  
  private ExpressionLocation expressionLocation;
  
  private Location target;
  
  public ExpressionLabel a() {
    return (this.label == null) ? new ExpressionLabel() : this.label;
  }
  
  public boolean b() {
    return (this.autoExpand != null && this.autoExpand.booleanValue());
  }
  
  public boolean c() {
    return ((this.cappedProps == null || !this.cappedProps.booleanValue()) && (this.callStackNode == null || !this.callStackNode.booleanValue()) && (this.capped == null || StringUtil.notNullize(this.capped) == "false") && (this.loadActionNode == null || !this.loadActionNode.booleanValue()) && (this.rangeNode == null || !this.rangeNode.booleanValue()) && !"string".equals(this.type) && (this.getter == null || !this.getter.booleanValue()) && (this.setter == null || !this.setter.booleanValue()));
  }
  
  public boolean d() {
    return (this.expandable != null && this.expandable.booleanValue());
  }
  
  public boolean e() {
    return (this.error != null && !this.error.isEmpty());
  }
  
  public boolean f() {
    return (this.getter != null && this.getter.booleanValue());
  }
  
  public boolean g() {
    return (this.loadActionNode != null && this.loadActionNode.booleanValue());
  }
  
  public boolean h() {
    return (this.functionsNode != null && this.functionsNode.booleanValue());
  }
  
  public boolean i() {
    return (this.rangeNode != null && this.rangeNode.booleanValue());
  }
  
  public boolean j() {
    return (this.callStackEntryNode != null && this.callStackEntryNode.booleanValue());
  }
  
  public boolean k() {
    return (this.callStackNode != null && this.callStackNode.booleanValue());
  }
  
  public boolean l() {
    return (this.proxyNode != null && this.proxyNode.booleanValue());
  }
  
  public boolean m() {
    return (this.disallowToCopyPath == null || !this.disallowToCopyPath.booleanValue());
  }
  
  public boolean n() {
    return (this.disallowToCopyData == null || !this.disallowToCopyData.booleanValue());
  }
  
  public ExpressionLocation o() {
    return this.expressionLocation;
  }
  
  public String[] p() {
    return (this.queryPath == null) ? new String[0] : this.queryPath.<String>toArray(new String[0]);
  }
  
  public String[] q() {
    return (this.expressionPath == null) ? new String[0] : this.expressionPath.<String>toArray(new String[0]);
  }
  
  public ExpressionNode[] r() {
    return (this.props == null) ? new ExpressionNode[0] : this.props.<ExpressionNode>toArray(new ExpressionNode[0]);
  }
  
  public String s() {
    return StringUtil.notNullize(this.id);
  }
  
  public String t() {
    return StringUtil.notNullize(this.type);
  }
  
  public Integer u() {
    return this.length;
  }
  
  public String v() {
    return this.name;
  }
  
  public Location w() {
    return this.target;
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true; 
    if (o == null || getClass() != o.getClass())
      return false; 
    ExpressionNode expressionNode = (ExpressionNode)o;
    return ((this.id != null) ? !this.id.equals(expressionNode.id) : (expressionNode.id != null)) ? false : (((this.label != null) ? !this.label.equals(expressionNode.label) : (expressionNode.label != null)) ? false : (((this.expandable != null) ? !this.expandable.equals(expressionNode.expandable) : (expressionNode.expandable != null)) ? false : (((this.disallowToCopyPath != null) ? !this.disallowToCopyPath.equals(expressionNode.disallowToCopyPath) : (expressionNode.disallowToCopyPath != null)) ? false : (((this.disallowToCopyData != null) ? !this.disallowToCopyData.equals(expressionNode.disallowToCopyData) : (expressionNode.disallowToCopyData != null)) ? false : (((this.queryPath != null) ? !this.queryPath.equals(expressionNode.queryPath) : (expressionNode.queryPath != null)) ? false : (((this.capped != null) ? !this.capped.equals(expressionNode.capped) : (expressionNode.capped != null)) ? false : (((this.cappedProps != null) ? !this.cappedProps.equals(expressionNode.cappedProps) : (expressionNode.cappedProps != null)) ? false : (((this.autoExpand != null) ? !this.autoExpand.equals(expressionNode.autoExpand) : (expressionNode.autoExpand != null)) ? false : (((this.getter != null) ? !this.getter.equals(expressionNode.getter) : (expressionNode.getter != null)) ? false : (((this.setter != null) ? !this.setter.equals(expressionNode.setter) : (expressionNode.setter != null)) ? false : (((this.loadActionNode != null) ? !this.loadActionNode.equals(expressionNode.loadActionNode) : (expressionNode.loadActionNode != null)) ? false : (((this.rangeNode != null) ? !this.rangeNode.equals(expressionNode.rangeNode) : (expressionNode.rangeNode != null)) ? false : (((this.type != null) ? !this.type.equals(expressionNode.type) : (expressionNode.type != null)) ? false : (((this.error != null) ? !this.error.equals(expressionNode.error) : (expressionNode.error != null)) ? false : (((this.length != null) ? !this.length.equals(expressionNode.length) : (expressionNode.length != null)) ? false : (((this.target != null) ? !this.target.equals(expressionNode.target) : (expressionNode.target != null)) ? false : ((this.props != null) ? this.props.equals(expressionNode.props) : ((expressionNode.props == null)))))))))))))))))));
  }
  
  public int hashCode() {
    null = (this.id != null) ? this.id.hashCode() : 0;
    null = 31 * null + ((this.label != null) ? this.label.hashCode() : 0);
    null = 31 * null + ((this.expandable != null) ? this.expandable.hashCode() : 0);
    null = 31 * null + ((this.disallowToCopyPath != null) ? this.disallowToCopyPath.hashCode() : 0);
    null = 31 * null + ((this.disallowToCopyData != null) ? this.disallowToCopyData.hashCode() : 0);
    null = 31 * null + ((this.queryPath != null) ? this.queryPath.hashCode() : 0);
    null = 31 * null + ((this.capped != null) ? this.capped.hashCode() : 0);
    null = 31 * null + ((this.cappedProps != null) ? this.cappedProps.hashCode() : 0);
    null = 31 * null + ((this.autoExpand != null) ? this.autoExpand.hashCode() : 0);
    null = 31 * null + ((this.getter != null) ? this.getter.hashCode() : 0);
    null = 31 * null + ((this.setter != null) ? this.setter.hashCode() : 0);
    null = 31 * null + ((this.loadActionNode != null) ? this.loadActionNode.hashCode() : 0);
    null = 31 * null + ((this.rangeNode != null) ? this.rangeNode.hashCode() : 0);
    null = 31 * null + ((this.type != null) ? this.type.hashCode() : 0);
    null = 31 * null + ((this.error != null) ? this.error.hashCode() : 0);
    null = 31 * null + ((this.length != null) ? this.length.hashCode() : 0);
    null = 31 * null + ((this.props != null) ? this.props.hashCode() : 0);
    return 31 * null + ((this.target != null) ? this.target.hashCode() : 0);
  }
  
  public void a(String paramString) {
    this.context = paramString;
  }
  
  public void x() {
    this.rootValueNode = Boolean.valueOf(true);
  }
  
  public void b(String paramString) {
    this.name = paramString;
  }
  
  public void a(String paramString, int paramInt) {
    this.expressionLocation = new ExpressionLocation(paramString, paramInt);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/ExpressionNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */