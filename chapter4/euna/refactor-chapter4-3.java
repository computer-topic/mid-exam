private void startSending() {
  try {
    doSending();
  } catch(SocketException e) {
    // someone stopped the request.
    ...
  } catch(Exception e) {
    // 교재에서는 addExceptionAndClosedResponse(e)라고 함
    makeErrorResponse(e);
  }
}

// 교재에서는 addExceptionAndClosedResponse라고 메서드명을 붙임
private void makeErrorResponse(Exception e) {
  try {
      response.add(ErrorResponder.makeExceptionString(e));
      response.closeAll();
  } catch(Exception e1) {
    ...
  }
}
