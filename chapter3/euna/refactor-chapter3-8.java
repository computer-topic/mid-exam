try {
  deletePage(page);;
  registry.deleteReference(page.name);
  configKeys.deleteKey(page.name.makeKey());
  logger.log("page deleted");
} catch (RuntimeException e) {
  logger.log(e.getMessage());
}

// 교재 코드
// public void delete(Page page) {
//   try {
//     deletePageAndAllReferences(page);
//   } catch (Exception e) {
//     logError(e);
//   }
// }

// private void deletePageAndAllReferences(Page page) throws Exception {
//   deletePage(page);
//   registry.deleteReference(page.name);
//   configKeys.deleteKey(page.name.makeKey());
//   logger.log("page deleted"); // <- 교재에는 누락되었지만 본래 의도라면 살려야하는 코드임
// }

// private void logError(Exception e) {
//   logger.log(e.getMessage());
// }