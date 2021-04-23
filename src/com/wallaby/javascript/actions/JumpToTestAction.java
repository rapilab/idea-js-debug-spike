package com.wallaby.javascript.actions;

import com.intellij.ide.actions.GotoActionBase;
import com.intellij.ide.util.gotoByName.ChooseByNameItemProvider;
import com.intellij.ide.util.gotoByName.ChooseByNameModel;
import com.intellij.ide.util.gotoByName.ChooseByNameModelEx;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import com.intellij.ide.util.gotoByName.ContributorsBasedGotoByModel;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.extendedCore.inboundMessages.Test;
import com.wallaby.javascript.extendedCore.inboundMessages.TestStatus;
import com.wallaby.javascript.k;

public class JumpToTestAction extends GotoActionBase {
  public JumpToTestAction() {
    Presentation presentation = getTemplatePresentation();
    presentation.setIcon(a.a.a);
  }
  
  public void actionPerformed(AnActionEvent actionEvent) {
    super.actionPerformed(actionEvent);
  }
  
  public void gotoActionPerformed(AnActionEvent actionEvent) {
    Project project = actionEvent.getProject();
    if (project == null)
      return; 
    a(project, actionEvent, "");
  }
  
  public void a(Project paramProject, AnActionEvent paramAnActionEvent, String paramString) {
    if (paramAnActionEvent == null)
      myInAction = WallabyController.class; 
    WallabyController wallabyController = WallabyController.a(paramProject);
    if (wallabyController == null)
      return; 
    wallabyController.a(paramArrayOfTest -> {
          b b = new b(paramWallabyController, paramArrayOfTest);
          ApplicationManager.getApplication().invokeLater(());
        });
  }
  
  private static class a implements ChooseByNameContributor {
    private String[] a;
    
    private NavigationItem[] b;
    
    public a(WallabyController param1WallabyController, Test[] param1ArrayOfTest) {
      this.a = new String[param1ArrayOfTest.length];
      this.b = new NavigationItem[param1ArrayOfTest.length];
      for (byte b = 0; b < param1ArrayOfTest.length; b++) {
        Test test = param1ArrayOfTest[b];
        String str1 = test.a();
        String str2 = test.c();
        String str3 = test.d();
        String str4 = StringUtil.isEmpty(str2) ? str3 : (str2 + " > " + str3);
        TestStatus testStatus = test.e();
        boolean bool = test.f();
        int[] arrayOfInt = test.b();
        String str5 = (testStatus == TestStatus.Skipped) ? ("[skipped] " + str4) : ((testStatus == TestStatus.Todo) ? ("[todo] " + str4) : str4);
        boolean bool1 = (arrayOfInt == null || arrayOfInt.length < 1) ? false : (arrayOfInt[0] - 1);
        boolean bool2 = (arrayOfInt == null || arrayOfInt.length < 2) ? false : arrayOfInt[1];
        this.a[b] = str5;
        this.b[b] = new e(this, str5, str1, testStatus, bool, arrayOfInt, param1WallabyController, bool1, bool2, str3);
      } 
    }
    
    public String[] getNames(Project project, boolean includeNonProjectItems) {
      return this.a;
    }
    
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
      return this.b;
    }
  }
  
  private static class b extends ContributorsBasedGotoByModel {
    public b(WallabyController param1WallabyController, Test[] param1ArrayOfTest) {
      super(param1WallabyController.d(), new ChooseByNameContributor[] { new JumpToTestAction.a(param1WallabyController, param1ArrayOfTest) });
    }
    
    public String getPromptText() {
      return "Enter test name:";
    }
    
    public String getCheckBoxName() {
      return null;
    }
    
    public char getCheckBoxMnemonic() {
      return Character.MIN_VALUE;
    }
    
    public String getNotInMessage() {
      return "";
    }
    
    public String getNotFoundMessage() {
      return k.a("messages.no.matches.found", new Object[0]);
    }
    
    public boolean loadInitialCheckBoxState() {
      return false;
    }
    
    public void saveInitialCheckBoxState(boolean state) {}
    
    public String[] getSeparators() {
      return new String[0];
    }
    
    public String getFullName(Object element) {
      return ((NavigationItem)element).getName();
    }
    
    public boolean willOpenEditor() {
      return true;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/JumpToTestAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */