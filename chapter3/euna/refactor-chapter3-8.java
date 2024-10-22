try {
  deletePage(page);;
  registry.deleteReference(page.name);
  configKeys.deleteKey(page.name.makeKey());
  logger.log("page deleted");
} catch (RuntimeException e) {
  logger.log(e.getMessage());
}