private void startSending() {
  try {
    doSending();
  } catch(SocketException e) {
    // someone stopped the request.
    ...
  } catch(Exception e) {
    makeErrorResponse(response);
  }
}

private void makeErrorResponse(Response response) {
  try {
      response.add(ErrorResponder.makeExceptionString(e));
      response.closeAll();
  } catch(Exception e) {
    ...
  }
}
