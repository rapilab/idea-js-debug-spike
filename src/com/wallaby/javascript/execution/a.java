package com.wallaby.javascript.execution;

import com.intellij.json.JsonFileType;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScope;
import com.intellij.ui.TextFieldWithHistory;
import com.intellij.ui.TextFieldWithHistoryWithBrowseButton;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.ui.SwingHelper;
import com.wallaby.javascript.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

class a {
  static TextFieldWithHistoryWithBrowseButton a(Project paramProject) {
    TextFieldWithHistoryWithBrowseButton textFieldWithHistoryWithBrowseButton = new TextFieldWithHistoryWithBrowseButton();
    TextFieldWithHistory textFieldWithHistory = (TextFieldWithHistory)textFieldWithHistoryWithBrowseButton.getChildComponent();
    textFieldWithHistory.setHistorySize(-1);
    textFieldWithHistory.setMinimumAndPreferredWidth(0);
    SwingHelper.addHistoryOnExpansion(textFieldWithHistory, () -> {
          List<VirtualFile> list = c(paramProject);
          List<Comparable> list1 = ContainerUtil.map(list, ());
          Collections.sort(list1);
          return list1;
        });
    SwingHelper.installFileCompletionAndBrowseDialog(paramProject, textFieldWithHistoryWithBrowseButton, k.a("configuration.dialogTitle.config", new Object[0]), (new FileChooserDescriptor(true, false, false, false, false, false)).withRoots(new VirtualFile[] { ProjectUtil.guessProjectDir(paramProject) }).withFileFilter(paramVirtualFile -> (paramVirtualFile.getFileType() == StdFileTypes.JS || paramVirtualFile.getFileType() == JsonFileType.INSTANCE)));
    return textFieldWithHistoryWithBrowseButton;
  }
  
  static TextFieldWithHistoryWithBrowseButton b(Project paramProject) {
    TextFieldWithHistoryWithBrowseButton textFieldWithHistoryWithBrowseButton = new TextFieldWithHistoryWithBrowseButton();
    TextFieldWithHistory textFieldWithHistory = (TextFieldWithHistory)textFieldWithHistoryWithBrowseButton.getChildComponent();
    textFieldWithHistory.setHistorySize(-1);
    textFieldWithHistory.setMinimumAndPreferredWidth(0);
    SwingHelper.installFileCompletionAndBrowseDialog(paramProject, textFieldWithHistoryWithBrowseButton, k.a("configuration.dialogTitle.configFolder", new Object[0]), (new FileChooserDescriptor(false, true, false, false, false, false)).withRoots(new VirtualFile[] { ProjectUtil.guessProjectDir(paramProject) }));
    return textFieldWithHistoryWithBrowseButton;
  }
  
  static void a(TextFieldWithHistory paramTextFieldWithHistory, String paramString) {
    paramTextFieldWithHistory.setText(paramString);
    paramTextFieldWithHistory.addCurrentTextToHistory();
  }
  
  public static List<VirtualFile> c(Project paramProject) {
    GlobalSearchScope globalSearchScope = ProjectScope.getContentScope(paramProject);
    Collection collection1 = FileTypeIndex.getFiles((FileType)StdFileTypes.JS, globalSearchScope);
    Collection collection2 = FileTypeIndex.getFiles((FileType)JsonFileType.INSTANCE, globalSearchScope);
    ArrayList<VirtualFile> arrayList = ContainerUtil.newArrayList();
    for (VirtualFile virtualFile : ContainerUtil.concat(new Iterable[] { collection1, collection2 })) {
      if (virtualFile.getName().startsWith("wallaby"))
        arrayList.add(virtualFile); 
    } 
    return arrayList;
  }
  
  static TextFieldWithHistoryWithBrowseButton d(Project paramProject) {
    TextFieldWithHistoryWithBrowseButton textFieldWithHistoryWithBrowseButton = new TextFieldWithHistoryWithBrowseButton();
    SwingHelper.installFileCompletionAndBrowseDialog(paramProject, textFieldWithHistoryWithBrowseButton, k.a("configuration.dialogTitle.node", new Object[0]), new FileChooserDescriptor(true, false, false, false, false, false));
    return textFieldWithHistoryWithBrowseButton;
  }
  
  static ComboBox a() {
    ComboBox comboBox = new ComboBox();
    String[] arrayOfString = { "Automatic", "Configuration File" };
    DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>(arrayOfString);
    comboBox.setModel(defaultComboBoxModel);
    comboBox.setMaximumRowCount(2);
    comboBox.setEditable(false);
    comboBox.setMinimumAndPreferredWidth(240);
    return comboBox;
  }
  
  static ComboBox b() {
    ComboBox comboBox = new ComboBox();
    String[] arrayOfString = { "No", "Yes" };
    DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>(arrayOfString);
    comboBox.setModel(defaultComboBoxModel);
    comboBox.setMaximumRowCount(2);
    comboBox.setEditable(false);
    comboBox.setMinimumAndPreferredWidth(60);
    return comboBox;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/execution/a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */