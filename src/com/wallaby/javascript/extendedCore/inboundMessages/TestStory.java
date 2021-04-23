package com.wallaby.javascript.extendedCore.inboundMessages;

import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class TestStory {
  private boolean isBuilt;
  
  private CharSequence myText;
  
  private int myCurrentLineNumber;
  
  private ArrayList<LexicalRegion> myLexicalRegions;
  
  private ArrayList<TextRange> myContextRanges;
  
  private HashMap<Integer, LineDecorationData> myLineDecorationData = new HashMap<>();
  
  private HashMap<Integer, OriginalLineData> myLineMappingData = new HashMap<>();
  
  private HashMap<Integer, Integer> myLineByStepData = new HashMap<>();
  
  private Integer myFirstStep;
  
  private Integer myLastStep;
  
  private String id;
  
  private TestStoryData data;
  
  public LineDecorationData a(int paramInt) {
    return this.myLineDecorationData.get(Integer.valueOf(paramInt));
  }
  
  public OriginalLineData b(int paramInt) {
    return this.myLineMappingData.get(Integer.valueOf(paramInt));
  }
  
  public Integer c(int paramInt) {
    return this.myLineByStepData.get(Integer.valueOf(paramInt));
  }
  
  public int a() {
    return (this.myFirstStep != null) ? this.myFirstStep.intValue() : 0;
  }
  
  public int b() {
    return (this.myLastStep != null) ? this.myLastStep.intValue() : 0;
  }
  
  public int c() {
    return (this.data != null) ? this.data.a() : 0;
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {
    this.myLineDecorationData.put(Integer.valueOf(paramInt), new LineDecorationData(paramBoolean ? LineType.SYSTEM_LOG : LineType.USER_LOG, paramString));
  }
  
  public TestStoryEntry d(int paramInt) {
    OriginalLineData originalLineData = b(paramInt);
    return (originalLineData == null) ? null : OriginalLineData.a(originalLineData);
  }
  
  public String d() {
    return StringUtil.notNullize(this.id);
  }
  
  public boolean e() {
    return (this.data != null && TestStoryData.a(this.data) != null && TestStoryData.a(this.data).booleanValue());
  }
  
  public boolean f() {
    return (this.data != null && TestStoryData.b(this.data) != null && TestStoryData.b(this.data).booleanValue());
  }
  
  public TestStoryEntry[] g() {
    return (this.data == null || TestStoryData.c(this.data) == null) ? new TestStoryEntry[0] : (TestStoryEntry[])TestStoryData.c(this.data).toArray((Object[])new TestStoryEntry[0]);
  }
  
  public CharSequence h() {
    if (!this.isBuilt)
      k(); 
    return this.myText;
  }
  
  public LexicalRegion[] i() {
    if (!this.isBuilt)
      k(); 
    return this.myLexicalRegions.<LexicalRegion>toArray(new LexicalRegion[0]);
  }
  
  public TextRange[] j() {
    if (!this.isBuilt)
      k(); 
    return this.myContextRanges.<TextRange>toArray(new TextRange[0]);
  }
  
  public void k() {
    StringBuilder stringBuilder = new StringBuilder();
    this.myLexicalRegions = new ArrayList<>();
    this.myContextRanges = new ArrayList<>();
    this.myLineDecorationData = new HashMap<>();
    this.myLineMappingData = new HashMap<>();
    this.myLineByStepData = new HashMap<>();
    this.myFirstStep = null;
    this.myLastStep = null;
    this.myCurrentLineNumber = 0;
    if (e())
      this.myLineDecorationData.put(Integer.valueOf(this.myCurrentLineNumber), new LineDecorationData(LineType.FILE_CONTENT_SEPARATOR, "···")); 
    for (TestStoryEntry testStoryEntry : g()) {
      String str = testStoryEntry.b();
      a(stringBuilder, str);
      int i = stringBuilder.length();
      for (TestStoryLine testStoryLine : testStoryEntry.a()) {
        if (TestStoryLine.a(testStoryLine)) {
          this.myLexicalRegions.add(new LexicalRegion(ContentRegionType.CODE, i, stringBuilder.length()));
          String str1 = "​\n";
          stringBuilder.append(str1);
          this.myLineDecorationData.put(Integer.valueOf(this.myCurrentLineNumber), new LineDecorationData(LineType.FILE_CONTENT_SEPARATOR, "···"));
          this.myCurrentLineNumber++;
          this.myLexicalRegions.add(new LexicalRegion(ContentRegionType.SEPARATOR, stringBuilder.length() - str1.length(), stringBuilder.length()));
          i = stringBuilder.length();
        } else {
          String str1 = TestStoryLine.b(testStoryLine);
          Integer integer = TestStoryLine.c(testStoryLine);
          int[][] arrayOfInt = TestStoryLine.d(testStoryLine);
          if (!TestStoryLine.e(testStoryLine) || (arrayOfInt.length > 0 && !TestStoryLine.a(testStoryLine)))
            if (arrayOfInt.length > 0) {
              for (int[] arrayOfInt1 : arrayOfInt)
                this.myContextRanges.add(new TextRange(stringBuilder.length() + arrayOfInt1[0], stringBuilder.length() + arrayOfInt1[1])); 
            } else {
              this.myContextRanges.add(new TextRange(stringBuilder.length(), stringBuilder.length() + str1.length()));
            }  
          stringBuilder.append(str1).append('\n');
          if (TestStoryLine.f(testStoryLine))
            this.myLineDecorationData.put(Integer.valueOf(this.myCurrentLineNumber), new LineDecorationData(LineType.ERROR, TestStoryLine.g(testStoryLine))); 
          OriginalLineData originalLineData = null;
          if (integer != null) {
            originalLineData = new OriginalLineData(integer.intValue() - 1, testStoryEntry);
            this.myLineMappingData.put(Integer.valueOf(this.myCurrentLineNumber), originalLineData);
          } 
          if (TestStoryLine.e(testStoryLine)) {
            (new int[1])[0] = testStoryEntry.c();
            int[] arrayOfInt1 = (TestStoryLine.h(testStoryLine) != null) ? TestStoryLine.h(testStoryLine) : new int[1];
            if (this.myFirstStep == null)
              this.myFirstStep = Integer.valueOf(arrayOfInt1[0]); 
            this.myLastStep = Integer.valueOf(arrayOfInt1[arrayOfInt1.length - 1]);
            for (int j : arrayOfInt1)
              this.myLineByStepData.put(Integer.valueOf(j), Integer.valueOf(this.myCurrentLineNumber)); 
            if (originalLineData != null)
              originalLineData.a(arrayOfInt1[0]); 
          } 
          this.myCurrentLineNumber++;
        } 
      } 
      this.myLexicalRegions.add(new LexicalRegion(ContentRegionType.CODE, i, stringBuilder.length()));
      a(stringBuilder);
    } 
    if (f())
      this.myLineDecorationData.put(Integer.valueOf(this.myCurrentLineNumber), new LineDecorationData(LineType.FILE_CONTENT_SEPARATOR, "···")); 
    this.myText = stringBuilder.toString();
    this.isBuilt = true;
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString) {
    String str = "​\n\n\n";
    paramStringBuilder.append(str);
    this.myLineDecorationData.put(Integer.valueOf(this.myCurrentLineNumber + 1), new LineDecorationData(LineType.FILE_NAME, paramString));
    this.myCurrentLineNumber += 3;
    this.myLexicalRegions.add(new LexicalRegion(ContentRegionType.SEPARATOR, paramStringBuilder.length() - str.length(), paramStringBuilder.length()));
  }
  
  private void a(StringBuilder paramStringBuilder) {
    String str = "​\n";
    paramStringBuilder.append(str);
    this.myLineDecorationData.put(Integer.valueOf(this.myCurrentLineNumber), new LineDecorationData(LineType.FILES_SEPARATOR, ""));
    this.myCurrentLineNumber++;
    this.myLexicalRegions.add(new LexicalRegion(ContentRegionType.SEPARATOR, paramStringBuilder.length() - str.length(), paramStringBuilder.length()));
  }
  
  public class TestStoryLine {
    private Integer n;
    
    private String content;
    
    private String error;
    
    private Boolean separator;
    
    private Boolean executedLine;
    
    private int[] steps;
    
    private ArrayList<int[]> contextRanges;
    
    private boolean a() {
      return (this.separator != null && this.separator.booleanValue());
    }
    
    private boolean b() {
      return (this.executedLine != null && this.executedLine.booleanValue());
    }
    
    private String c() {
      return StringUtil.notNullize(this.content);
    }
    
    private boolean d() {
      return (this.error != null);
    }
    
    private Integer e() {
      return this.n;
    }
    
    private String f() {
      return StringUtil.notNullize(this.error);
    }
    
    private int[] g() {
      return this.steps;
    }
    
    private int[][] h() {
      return (this.contextRanges == null) ? new int[0][] : this.contextRanges.<int[]>toArray(new int[this.contextRanges.size()][]);
    }
  }
  
  public class TestStoryEntry {
    private String file;
    
    private Integer fileId;
    
    private Integer step;
    
    private Boolean hideable;
    
    private ArrayList<TestStory.TestStoryLine> lines;
    
    private ArrayList<Integer> rangeIds;
    
    public TestStory.TestStoryLine[] a() {
      return (this.lines == null) ? new TestStory.TestStoryLine[0] : this.lines.<TestStory.TestStoryLine>toArray(new TestStory.TestStoryLine[0]);
    }
    
    public String b() {
      return StringUtil.notNullize(this.file);
    }
    
    public int c() {
      return (this.step != null) ? this.step.intValue() : 0;
    }
    
    public boolean d() {
      return (this.hideable != null && this.hideable.booleanValue());
    }
  }
  
  public class TestStoryData {
    private Boolean truncatedStart;
    
    private Boolean truncatedEnd;
    
    private ArrayList<TestStory.TestStoryEntry> entries;
    
    private Integer maxLineNumber;
    
    public int a() {
      return (this.maxLineNumber != null) ? this.maxLineNumber.intValue() : 0;
    }
  }
  
  public class LexicalRegion {
    private TestStory.ContentRegionType myType;
    
    private int myStart;
    
    private int myEnd;
    
    public LexicalRegion(TestStory.ContentRegionType type, int start, int end) {
      this.myType = type;
      this.myStart = start;
      this.myEnd = end;
    }
    
    public TestStory.ContentRegionType a() {
      return this.myType;
    }
    
    public int b() {
      return this.myStart;
    }
    
    public int c() {
      return this.myEnd;
    }
  }
  
  public class LineDecorationData {
    private final TestStory.LineType myType;
    
    private String myContent;
    
    public LineDecorationData(TestStory.LineType type, String content) {
      this.myType = type;
      this.myContent = content;
    }
    
    public TestStory.LineType a() {
      return this.myType;
    }
    
    public String b() {
      return this.myContent;
    }
  }
  
  public class LineData {
    private final int myLineNumber;
    
    private final int myStartOffset;
    
    private final int myEndOffset;
    
    private final boolean myIsFullLine;
    
    public LineData(int lineNumber) {
      this.myLineNumber = lineNumber;
      this.myIsFullLine = true;
      this.myStartOffset = 0;
      this.myEndOffset = 0;
    }
    
    public LineData(int lineNumber, int startOffset, int endOffset) {
      this.myLineNumber = lineNumber;
      this.myIsFullLine = false;
      this.myStartOffset = startOffset;
      this.myEndOffset = endOffset;
    }
    
    public int a() {
      return this.myLineNumber;
    }
    
    public boolean b() {
      return this.myIsFullLine;
    }
    
    public int c() {
      return this.myStartOffset;
    }
    
    public int d() {
      return this.myEndOffset;
    }
  }
  
  public class OriginalLineData {
    private final int myLineNumber;
    
    private final TestStory.TestStoryEntry myTestStoryEntry;
    
    private Integer myStep;
    
    public OriginalLineData(int lineNumber, TestStory.TestStoryEntry testStoryEntry) {
      this.myTestStoryEntry = testStoryEntry;
      this.myLineNumber = lineNumber;
    }
    
    public String a() {
      return this.myTestStoryEntry.b();
    }
    
    public int b() {
      return this.myLineNumber;
    }
    
    public void a(int param1Int) {
      this.myStep = Integer.valueOf(param1Int);
    }
    
    public Integer c() {
      return this.myStep;
    }
    
    public boolean d() {
      return this.myTestStoryEntry.d();
    }
  }
  
  public enum LineType {
    FILE_NAME, FILE_CONTENT_SEPARATOR, FILES_SEPARATOR, ERROR, USER_LOG, SYSTEM_LOG;
  }
  
  public enum ContentRegionType {
    SEPARATOR, CODE;
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/inboundMessages/TestStory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */