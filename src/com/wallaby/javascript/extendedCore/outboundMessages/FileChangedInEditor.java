package com.wallaby.javascript.extendedCore.outboundMessages;

public class FileChangedInEditor extends OutboundMessageBase {
  private final String path;
  
  private final String content;
  
  private String transientChange = null;
  
  private ChangeFrame changeFrame = null;
  
  public String a() {
    return this.path;
  }
  
  public String b() {
    return this.content;
  }
  
  public int c() {
    return ChangeFrame.a(this.changeFrame);
  }
  
  public int d() {
    return ChangeFrame.b(this.changeFrame);
  }
  
  private FileChangedInEditor(String path, String content, Integer start, Integer end, String transientChange) {
    super("fileChangedInEditor");
    this.path = path;
    this.content = content;
    if (transientChange != null)
      this.transientChange = transientChange; 
    if (start != null && end != null)
      this.changeFrame = new ChangeFrame(start.intValue(), end.intValue()); 
  }
  
  public FileChangedInEditor(String path, String content, int start, int end) {
    this(path, content, Integer.valueOf(start), Integer.valueOf(end), null);
  }
  
  public FileChangedInEditor(String path, String content, String transientChange) {
    this(path, content, null, null, transientChange);
  }
  
  public class ChangeFrame {
    private final int start;
    
    private final int end;
    
    public ChangeFrame(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/FileChangedInEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */