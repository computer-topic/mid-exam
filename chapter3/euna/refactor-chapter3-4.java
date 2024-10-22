public static String testableHtml(PageData pageData, boolean includeSuiteSetup)
{
  WikiPage wikiPage = pageData.getWikiPage();
  StringBuffer testContent = new StringBuffer();
  String pageDataContent = pageData.getContent();
  
  setUpContent(pageData, includeSuiteSetup, testContent);
  appendPageDataContent(testContent, pageDataContent);
  tearDownContent(pageData, includeSuiteSetup, testContent);

  pageData.setContent(testContent.toString());
  return pageData.getHtml();
}

private void setUpContent(PageData pageData, boolean includeSuiteSetup,n StringBuffer testContent) {
  if (pageData.hasAttribute("Test")) {
    setUpForSuiteTest(pageData, includeSuiteSetup, testContent);
    WikiPage setup = PageCrawlerImp.getInheritedPage(...);
    appendSetUpContent(setup, testContent)
  }
}

private void setUpForSuiteTest(PageData pageData, boolean includeSuiteSetup, PageDStringBuffer testContent) {
  if (includeSuiteSetup) {
      WikiPage suiteSetup = PageCrawlerImp.getInheritedPage(...);
      appendSetUpContent(suiteSetup, testContent);
  }
}

private void appendSetUpContent(WikiPage setUpPage, StringBuffer testContent) {
  if (setUpPage != null) {
    WikiPagePath setupPath = page.getFullPath();
    String setupPathName = PathParser.render(setupPath);
    appendContentForTest(testContent, "setup", setupPathName);
  }
}

private void appendPageDataContent(StringBuffer testContent, String pageDataContent) {
  testContent.append(pageDataContent);
}

private void tearDownContent(PageData pageData, boolean includeSuiteSetup StringBuffer testContent) {
  if (pageData.hasAttribute("Test")) {
    WikiPage setup = PageCrawlerImp.getInheritedPage(...);
    appendTearDownContent(setup, testContent);
    tearDownForSuiteTest(includeSuiteSetup, testContent);
  }
}

private void appendTearDownContent(WikiPage tearDownPage, StringBuffer testContent) {
  if (tearDownPage != null) {
    WikiPagePath tearDownPath = teardonw.getFullPath();
    String tearDownPathName = PathParser.render(tearDownPath);
    tearDownForSuiteTest(includeSuiteSetup, testContent);
  }
}

private void tearDownForSuiteTest(boolean includeSuiteSetup, StringBuffer testContent) {
  if (includeSuiteSetup) {
      WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(...);
      appendTearDownContent(suiteTeardown, testContent);
  }
}

private void appendContentForTest(StringBuffer testContent, String includeType, String pagePathName) {
  String includeContent = String.format("!include -%s .", includeType);
  testContent.append(includeContent)
        .append(pagePathName)
        .append("\n")
}