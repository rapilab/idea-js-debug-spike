package com.wallaby.javascript.extendedCore.outboundMessages;

import com.wallaby.javascript.extendedCore.inboundMessages.TestStory;

public class RequestTestStory extends RequestWithCallbackBase {
  private RequestTestStoryDetails request;
  
  public RequestTestStory(Integer traceStep, TestStory.TestStoryEntry fragmentToHide) {
    super("testTimeline");
    this.request = new RequestTestStoryDetails(traceStep, fragmentToHide, null);
  }
  
  private class RequestTestStoryDetails {
    private final TestStory.TestStoryEntry hide;
    
    private Integer before = null;
    
    private Integer after = null;
    
    private RequestTestStoryDetails(Integer traceStep, TestStory.TestStoryEntry fragmentToHide) {
      this.before = traceStep;
      this.after = traceStep;
      this.hide = fragmentToHide;
    }
  }
}


/* Location:              /Users/fdhuang/works/idea/code/libs/wallaby-intellij.jar!/com/wallaby/javascript/extendedCore/outboundMessages/RequestTestStory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */