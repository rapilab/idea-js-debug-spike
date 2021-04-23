package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;

public class UncoveredRegions {
  private String id;
  
  private UncoveredRegionData data;
  
  public String a() {
    return StringUtil.notNullize(this.id);
  }
  
  public String b() {
    return this.data.a();
  }
  
  public int[][] c() {
    return this.data.b();
  }
  
  private class UncoveredRegionData {
    private String file;
    
    private ArrayList<int[]> ranges;
    
    public String a() {
      return StringUtil.notNullize(this.file);
    }
    
    int[][] b() {
      return (this.ranges == null) ? new int[0][] : this.ranges.<int[]>toArray(new int[this.ranges.size()][]);
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/UncoveredRegions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */