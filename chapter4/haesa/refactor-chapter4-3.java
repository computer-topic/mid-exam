private void startSending() {
  try {
    doSending();
  } catch(SocketException e) {
    // normal. someone stopped the request.
  } catch(Exception e) {
    addExceptionMessageAndCloseResponse(e)
  }
}

/**
  개인적으로 함수 인터페이스와 catch 블럭에서 Exception 이름이 동일해도 되는지 궁금함!
  1. 동일한 이름을 사용하면 컴파일 레벨에서 오류가 난다 ✅
*/
private void addExceptionMessageAndCloseResponse(Exception e) {
  try {
    response.add(ErrorResponder.makeExceptionString(e));
    response.closeAll();
  } catch (Exception e1) {
    ...
  }
}