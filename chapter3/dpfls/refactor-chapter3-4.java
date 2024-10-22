public static String renderPage(PageData pageData, boolean isSuite) {
    if (isTestPage(pageData))
        includeSetupAndTeardownPages(pageData);
    return pageData.getHtml();
}

private void isTestPage(PageData pageData){
    return pageData.hasAttribute("Test");
}

private void includeSetupAndTeardownPages(PageData pageData) {
    StringBuffer buffer;

    buffer = new StringBuffer();
    setup(buffer, isSuite);
    buffer.append(pageData.getContent());
    teardown(buffer, isSuite);
    pageData.setContent(buffer.toString());
}

private void setup(StringBuffer buffer, boolean isSuite) {
    String type;

    type = "setup";
    writeMessagePathName(buffer, type);
    if (isSuite)
        writeMessagePathName(buffer, type);
}

private void teardown(StringBuffer buffer, boolean isSuite) {
    String type;

    type = "teardown";
    writeMessagePathName(buffer, type);
    if (isSuite)
        writeMessagePathName(buffer, type);
}

private void writeMessagePathName(StringBuffer buffer, String type) {
    WikiPage page;
    WikiPagePath path;
    String pathName;

    page = PageCrawlerImp.getInheritedPage(...)
    if (page)
        return ;
    path = page.getFullPath();
    pathName = PathParser.render(path);
    fillBuffer(buffer, type, pathName)
}

private void fillBuffer(StringBuffer buffer, String type, String pagePathName) {
    buffer.append("!include -")
        .append(type)
        .append(" .")
        .append(pagePathName)
        .append("\n");
}