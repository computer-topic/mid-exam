public void delete() {
    try {
        tryDeletePageAndAssociations(page);
    } catch (Exception error) {
        logger.log(error.getMessage());
    }
}

private void tryDeletePageAndAssociations(Page page) {
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
    logger.log("page deleted");
}