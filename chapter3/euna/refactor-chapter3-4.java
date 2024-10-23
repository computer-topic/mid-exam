public static String makeTestableHtml(PageData pageData, boolean isSuite) {
  WikiPage wikiPage = pageData.getWikiPage();
  StringBuffer testContent = new StringBuffer();

  if (isTestPage(pageData)) {
    setUpContent(pageData, isSuite, testContent);
    appendPageDataContent(pageData, testContent);
    tearDownContent(pageData, isSuite, testContent);
  }
  pageData.setContent(testContent.toString());
  return pageData.getHtml();
}

private boolean isTestPage(PageData pageData) {
  return pageData.hasAttribute("Test");
}

private void getPagePathName(WikiPage suitePage) {
  WikiPagePath pagePath = suitePage.getFullPath();
  String pagePathName = PathParser.render(pagePath);
}

private void appendContentForTest(String includeType, String pagePathName, StringBuffer testContent) {
  String includeContent = String.format("!include -%s .", includeType);
  testContent.append(includeContent)
        .append(pagePathName)
        .append("\n")
}

private void setUpContent(PageData pageData, boolean isSuite, StringBuffer testContent) {
  if(isSuite) {
    setUpForSuiteTest(pageData, testContent);
  }
  setUpForTest(pageData, testContent)
}

private void setUpForSuiteTest(PageData pageData, StringBuffer testContent) {
  WikiPage suiteSetUp = PageCrawlerImpl.getInheritedPage(...); // setUpForSuiteTest와 setUpForTest의 코드 중 이 라인에서 차이가 있을 수 있다고 생각해 메서드에서 공통부분을 추출하여 하나의 메서드로 사용하지 않았습니다
  if (suiteSetUp != null) {
    String pagePathName = getPagePathName(suiteSetUp, testContent);
    appendContentForTest("setup", pagePathName, testContent)
  }
}

private void setUpForTest(PageData pageData, StringBuffer testContent) {
  WikiPage setUp = PageCrawlerImpl.getInheritedPage(...);
  if (setUp != null) {
    String pagePathName = getPagePathName(setUp);
    appendContentForTest("setup", pagePathName, testContent)
  }
}

private void appendPageDataContent(PageData pageData, StringBuffer testContent) {
  testContent.append(pageData.getContent());
}

private void tearDownContent(PageData pageData, boolean isSuite, StringBuffer testContent) {
  tearDownForTest(pageData, testContent);
  if(isSuite) {
    tearDownForSuiteTest(includeSuiteSetup, testContent);
  }
}

private void tearDownForTest(PageData pageData, StringBuffer testContent) {
  WikiPage teardown = PageCrawlerImpl.getInheritedPage(...);
  if (teardown != null) {
    String pagePathName = getPagePathName(teardown);
    appendContentForTest("teardown", pagePathName, testContent);
  }
}

private void tearDownForSuiteTest(PageData pageData, StringBuffer testContent) {
  WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(...);
  if (suiteTeardown != null) {
    String pagePathName = getPagePathName(suiteTeardown);
    appendContentForTest("teardown", pagePathName, testContent);
  }
}