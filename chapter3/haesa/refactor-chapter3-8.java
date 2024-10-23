public void deletePageAndReference(Page page) {
  try {
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
    logger.log("page deleted");
  } catch (Exception e) {
    logError(e);
  }  
}

private void logError(Exception e) {
  logger.log(e.getMessage());
}