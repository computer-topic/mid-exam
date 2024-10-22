public static String renderPage(PageData pageData, boolean includeSuiteSetup) {
    boolean isTestPage = pageData.hasAttribute("Test");

    if (isTestPage) {
        StringBuffer buffer = new StringBuffer();

        setup(buffer);
        buffer.append(pageData.getContent());
        teardown(buffer);
    }
    pageData.setContent(buffer.toString());
    return pageData.getHtml();
}

private void setup(StringBuffer buffer) {
    String message = "!include -setup .";

    writeMessagePathName(buffer, message);
    if (includeSuiteSetup)
        writeMessagePathName(buffer, message);
}

private void teardown(StringBuffer buffer) {
    String message = "!include -teardown .";

    writeMessagePathName(buffer, message);
    if (includeSuiteSetup)
        writeMessagePathName(buffer, message);
}

private void writeMessagePathName(StringBuffer buffer, String message) {
    WikiPage page = PageCrawlerImp.getInheritedPage(...);

    if (page)
        return ;
    WikiPagePath path = page.getFullPath();
    String pathName = PathParser.render(path);
    fillBuffer(buffer, message, pathName)
}

private void fillBuffer(StringBuffer buffer, String message, String pagePathName) {
    buffer.append(message)
        .append(pagePathName)
        .append("\n");
}