package com.wallaby.javascript.execution;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.configurations.RefactoringListenerProvider;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfigurationError;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiUtilBase;
import com.intellij.refactoring.listeners.RefactoringElementListener;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.b.a;
import com.wallaby.javascript.k;
import java.io.File;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Element;

public class j extends LocatableConfigurationBase implements RefactoringListenerProvider {
  private b d;
  
  private static final String e = "config";
  
  public static final String a = "Configuration File";
  
  private static final String f = "node";
  
  public static final String b = "{SYSTEM DEFAULT}";
  
  private static final String g = "wsl";
  
  public static final String c = "Automatic";
  
  private static String h;
  
  private static final String i = "configFolder";
  
  private static final String j = "configType";
  
  private final Project k;
  
  j(Project paramProject, ConfigurationFactory paramConfigurationFactory, String paramString) {
    super(paramProject, paramConfigurationFactory, paramString);
    this.k = paramProject;
    String str = "";
    str = (String)ApplicationManager.getApplication().runReadAction(() -> {
          List<VirtualFile> list = a.c(paramProject);
          return (list.size() > 0) ? FileUtil.toSystemDependentName(((VirtualFile)list.get(0)).getPath()) : "";
        });
    h = WallabyController.a(getProject()).V();
    this.d = new b(str, FileUtil.toSystemDependentName(paramProject.getBasePath()), "{SYSTEM DEFAULT}", "No", "Automatic");
  }
  
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new l(getProject());
  }
  
  public RunProfileState getState(Executor executor, ExecutionEnvironment environment) throws ExecutionException {
    try {
      checkConfiguration();
    } catch (RuntimeConfigurationError runtimeConfigurationError) {
      throw new ExecutionException(runtimeConfigurationError.getMessage());
    } catch (RuntimeConfigurationException runtimeConfigurationException) {}
    return new d(getProject(), environment);
  }
  
  public b a() {
    return this.d;
  }
  
  void a(b paramb) {
    this.d = paramb;
  }
  
  private static void a(Element paramElement, b paramb, String paramString) {
    paramElement.setAttribute("configType", paramb.f());
    if (!paramb.f().equals("Configuration File")) {
      paramElement.setAttribute("configFolder", FileUtil.toSystemIndependentName(paramb.b()));
    } else {
      paramElement.setAttribute("config", FileUtil.toSystemIndependentName(paramb.a()));
    } 
    String str = paramb.c();
    if (!paramString.equals(str))
      paramElement.setAttribute("node", FileUtil.toSystemIndependentName(str)); 
    paramElement.setAttribute("wsl", paramb.e());
  }
  
  private b a(Element paramElement) {
    String str1 = StringUtil.notNullize(a(paramElement, "configType"), "Configuration File");
    if (StringUtil.isEmpty(str1))
      str1 = "Configuration File"; 
    String str2 = FileUtil.toSystemDependentName(StringUtil.notNullize(a(paramElement, "config")));
    String str3 = FileUtil.toSystemDependentName(StringUtil.notNullize(a(paramElement, "configFolder")));
    if (StringUtil.isEmpty(str3))
      str3 = FileUtil.toSystemDependentName(this.k.getBasePath()); 
    String str4 = StringUtil.notNullize(a(paramElement, "node"), "{SYSTEM DEFAULT}");
    if (StringUtil.isEmpty(str4) || str4.equals(h))
      str4 = "{SYSTEM DEFAULT}"; 
    String str5 = StringUtil.notNullize(a(paramElement, "wsl"), "No");
    if (StringUtil.isEmpty(str5))
      str5 = "No"; 
    String str6 = FileUtil.toSystemDependentName(str4);
    return new b(str2, str3, str6, str5, str1);
  }
  
  public void readExternal(Element element) throws InvalidDataException {
    super.readExternal(element);
    a(a(element));
  }
  
  public void writeExternal(Element element) throws WriteExternalException {
    super.writeExternal(element);
    a(element, a(), "{SYSTEM DEFAULT}");
  }
  
  public RefactoringElementListener getRefactoringElementListener(PsiElement element) {
    VirtualFile virtualFile = PsiUtilBase.asVirtualFile(element);
    if (virtualFile == null)
      return null; 
    String str1 = virtualFile.getPath();
    String str2 = FileUtil.toSystemIndependentName(this.d.a());
    return (RefactoringElementListener)(str2.equals(str1) ? new k(this) : null);
  }
  
  private static String a(Element paramElement, String paramString) {
    Attribute attribute = paramElement.getAttribute(paramString);
    return (attribute != null) ? attribute.getValue() : null;
  }
  
  public void checkConfiguration() throws RuntimeConfigurationException {
    VirtualFile virtualFile;
    boolean bool1 = this.d.f().equals("Configuration File");
    String str1 = this.d.b();
    String str2 = this.d.a();
    String str3 = this.d.c();
    boolean bool2 = "Yes".equals(this.d.e());
    if (bool1) {
      if (str2.trim().isEmpty())
        throw new RuntimeConfigurationError(k.a("configuration.validation.emptyConfigPath", new Object[0])); 
      File file1 = new File(str2);
      if (!file1.isFile() || !file1.exists())
        throw new RuntimeConfigurationError(k.a("configuration.validation.incorrectConfigPath", new Object[0])); 
      virtualFile = LocalFileSystem.getInstance().findFileByIoFile(file1);
      if (virtualFile == null)
        throw new RuntimeConfigurationError(k.a("configuration.validation.canNotFindVirtualFile", new Object[0])); 
    } else {
      if (str1.trim().isEmpty())
        throw new RuntimeConfigurationError(k.a("configuration.validation.emptyConfigFolderPath", new Object[0])); 
      File file1 = new File(str1);
      if (!file1.isDirectory() || !file1.exists())
        throw new RuntimeConfigurationError(k.a("configuration.validation.incorrectConfigFolderPath", new Object[0])); 
      virtualFile = LocalFileSystem.getInstance().findFileByIoFile(file1);
      if (virtualFile == null)
        throw new RuntimeConfigurationError(k.a("configuration.validation.canNotFindVirtualFolder", new Object[0])); 
    } 
    if (str3.trim().isEmpty())
      throw new RuntimeConfigurationError(k.a("configuration.validation.emptyNodePath", new Object[0])); 
    File file = new File(str3);
    if (!bool2 && !"{SYSTEM DEFAULT}".equals(str3) && (!file.isFile() || !file.exists()))
      throw new RuntimeConfigurationError(k.a("configuration.validation.incorrectNodePath", new Object[0])); 
    a a = new a(virtualFile, str3, bool2, bool1, this.d.g());
    this.d.a(a);
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */