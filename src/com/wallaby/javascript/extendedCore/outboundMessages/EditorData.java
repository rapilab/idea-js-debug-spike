package com.wallaby.javascript.extendedCore.outboundMessages;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.application.ex.ApplicationInfoEx;
import com.intellij.openapi.application.impl.ApplicationInfoImpl;
import com.intellij.openapi.extensions.PluginId;

public class EditorData extends OutboundMessageBase {
  private final EditorVersion data;
  
  public EditorData() {
    super("copyDiagnosticsReportToClipboard");
    ApplicationInfoEx applicationInfoEx = ApplicationInfoImpl.getShadowInstance();
    IdeaPluginDescriptor ideaPluginDescriptor = PluginManager.getPlugin(PluginId.getId("wallaby.js"));
    assert ideaPluginDescriptor != null;
    this.data = new EditorVersion(applicationInfoEx.getFullApplicationName(), ideaPluginDescriptor.getVersion(), null);
  }
  
  private class EditorVersion {
    private final String editorVersion;
    
    private final String pluginVersion;
    
    private EditorVersion(String editorVersion, String pluginVersion) {
      this.editorVersion = editorVersion;
      this.pluginVersion = pluginVersion;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/EditorData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */