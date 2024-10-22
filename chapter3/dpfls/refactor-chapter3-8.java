public void delete() {
    try {
        tryDeletePageAndAssociations();
    } catch (Exception error) {
        logger.log(error.getMessage());
    }
}

private void tryDeletePageAndAssociations() {
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
}