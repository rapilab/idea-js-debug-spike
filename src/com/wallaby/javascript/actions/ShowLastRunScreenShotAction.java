package com.wallaby.javascript.actions;

import a.a;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.vfs.VirtualFile;
import com.wallaby.javascript.WallabyController;
import com.wallaby.javascript.k;
import com.wallaby.javascript.m;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShowLastRunScreenShotAction extends AnAction {
  public ShowLastRunScreenShotAction() {
    super(a.a);
  }
  
  public void actionPerformed(AnActionEvent e) {
    Editor editor = (Editor)CommonDataKeys.EDITOR.getData(e.getDataContext());
    if (editor == null)
      return; 
    VirtualFile virtualFile = (VirtualFile)CommonDataKeys.VIRTUAL_FILE.getData(e.getDataContext());
    if (virtualFile == null)
      return; 
    Project project = editor.getProject();
    if (project == null)
      return; 
    WallabyController wallabyController = WallabyController.a(project);
    a(editor, (m)wallabyController);
  }
  
  static void a(Editor paramEditor, m paramm) {
    Project project = paramEditor.getProject();
    if (project == null)
      return; 
    try {
      JBPopup jBPopup = JBPopupFactory.getInstance().createComponentPopupBuilder(new JLabel(new ImageIcon(ImageIO.read(new File(paramm.a())))), null).setCancelOnClickOutside(true).setCancelKeyEnabled(true).setRequestFocus(false).setResizable(true).setMovable(true).setTitle(k.a("dialogs.screenShot.title", new Object[0])).createPopup();
      jBPopup.addListener(new k(jBPopup));
      jBPopup.showCenteredInCurrentWindow(project);
    } catch (IOException iOException) {}
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/actions/ShowLastRunScreenShotAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */