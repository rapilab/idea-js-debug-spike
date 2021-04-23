package com.wallaby.javascript.actions;

import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStatus;

class e implements NavigationItem {
  e(JumpToTestAction.a parama, String paramString1, String paramString2, TestStatus paramTestStatus, boolean paramBoolean, int[] paramArrayOfint, WallabyController paramWallabyController, int paramInt1, int paramInt2, String paramString3) {}
  
  public String getName() {
    return this.a;
  }
  
  public ItemPresentation getPresentation() {
    return new f(this);
  }
  
  public void navigate(boolean b) {
    try {
      if (this.e != null) {
        (new OpenFileDescriptor(this.f.d(), this.f.b(this.b), this.g, this.h)).navigate(true);
      } else {
        this.f.a(this.b, this.i);
      } 
    } catch (Exception exception) {
      WallabyController.a.warn(exception);
    } 
  }
  
  public boolean canNavigate() {
    return true;
  }
  
  public boolean canNavigateToSource() {
    return true;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */