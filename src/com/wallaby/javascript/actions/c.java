package com.wallaby.javascript.actions;

import com.intellij.ide.actions.GotoActionBase;
import com.intellij.ide.util.gotoByName.ChooseByNameFilter;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import com.intellij.navigation.NavigationItem;

class c extends GotoActionBase.GotoActionCallback<Object> {
  c(JumpToTestAction paramJumpToTestAction) {}
  
  protected ChooseByNameFilter<Object> createFilter(ChooseByNamePopup popup) {
    return null;
  }
  
  public void elementChosen(ChooseByNamePopup popup, Object element) {
    ((NavigationItem)element).navigate(false);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */