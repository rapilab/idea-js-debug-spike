package com.wallaby.javascript.actions;

import com.intellij.icons.AllIcons;
import com.intellij.navigation.ItemPresentation;
import javax.swing.Icon;

class f implements ItemPresentation {
  f(e parame) {}
  
  public String getPresentableText() {
    return this.a.a;
  }
  
  public String getLocationString() {
    return this.a.b;
  }
  
  public Icon getIcon(boolean b) {
    switch (d.a[this.a.c.ordinal()]) {
      case 1:
        return AllIcons.RunConfigurations.TestSkipped;
      case 2:
        return AllIcons.RunConfigurations.TestUnknown;
    } 
    return this.a.d ? AllIcons.RunConfigurations.TestError : AllIcons.RunConfigurations.TestPassed;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */