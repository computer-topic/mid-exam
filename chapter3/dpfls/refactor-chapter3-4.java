public static String renderPage(PageData pageData, boolean isSuite) {
    boolean isTestPage;
    StringBuffer buffer;

    isTestPage = pageData.hasAttribute("Test");
    if (isTestPage) {
        buffer = new StringBuffer();
        setup(buffer, isSuite);
        buffer.append(pageData.getContent());
        teardown(buffer, isSuite);
        pageData.setContent(buffer.toString());
    }
    return pageData.getHtml();
}

private void setup(StringBuffer buffer, boolean isSuite) {
    String message;

    message = "!include -setup .";
    writeMessagePathName(buffer, message);
    if (isSuite)
        writeMessagePathName(buffer, message);
}

private void teardown(StringBuffer buffer, boolean isSuite) {
    String message;

    message = "!include -teardown .";
    writeMessagePathName(buffer, message);
    if (isSuite)
        writeMessagePathName(buffer, message);
}

private void writeMessagePathName(StringBuffer buffer, String message) {
    WikiPage page;
    WikiPagePath path;
    String pathName;

    page = PageCrawlerImp.getInheritedPage(...)
    if (page)
        return ;
    path = page.getFullPath();
    pathName = PathParser.render(path);
    fillBuffer(buffer, message, pathName)
}

private void fillBuffer(StringBuffer buffer, String message, String pagePathName) {
    buffer.append(message)
        .append(pagePathName)
        .append("\n");
}