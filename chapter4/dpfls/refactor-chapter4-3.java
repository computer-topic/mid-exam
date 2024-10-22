private void startSending() {
    try {
        doSending();
    } catch(SocketException e) {
        // normal. someone stopped the request.
    } catch(Exception e) {
        addErrorMessageAndClose();
    }
}

private void addErrorMessageAndClose() {
    try {
        response.add(ErrorResponder.makeExceptionString(e));
        response.closeAll();
    } catch(Exception e1) {
    }
}