public static String makeTestableHtmlPage(PageData pageData, boolean isSuite) {
  WikiPage wikiPage = pageData.getWikiPage();
  StringBuffer testContent = new StringBuffer();

  if (isTestPage(pageData)) {
    setUpAndTearDownPages(pageData, isSuite, testContent);
  }
  return pageData.getHtml();
}

private void setUpAndTearDownPages(PageData pageData, boolean isSuite, StringBuffer testContent) {
  setUpContent(pageData, isSuite, testContent);
    appendPageDataContent(pageData, testContent);
    tearDownContent(pageData, isSuite, testContent);
    pageData.setContent(testContent.toString());
}

private boolean isTestPage(PageData pageData) {
  return pageData.hasAttribute("Test");
}

private String getPagePathName(WikiPage suitePage) {
  WikiPagePath pagePath = suitePage.getFullPath();
  return PathParser.render(pagePath);
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
    String pagePathName = getPagePathName(suiteSetUp);
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

// -- 교재 코드

private String render(boolean isSuite) throws Exception {
  this.isSuite = isSuite; // 클래스 내 멤버변수로 분리하여 클래스 레벨에서 사용할 수 있도록 세팅
  if (isTestPage()) {
    includeSetupAndTeardownPages();
  }
  return pageData.getHtml();
}

private boolean isTestPage() throws Exception {
  return pageData.hasAttribute("Test"); // 교재에서는 클래스 멤버변수에 pageData도 분리하는 것 같음
}

private void includeSetupAndTeardownPages() throws Exception {
  includeSetupPages();
  includePageContent();
  includeTeardownPages();
  updatePageContent();
  // 메서드 이름을 include~로 통일하여 가독성 향상 + 추가하는 행위에 대해 include라는 하나의 단어 사용
}

private void includeSetupPages() throws Exception {
  if (isSuite) {
    includeSuiteSetupPage();
  }
  includeSetupPage();
}

private void includeSuiteSetupPage() throws Exception {
  include(SuiteResponder.SUITE_SETUP_NAME, "-setup");
}

private void includeSetupPage() throws Exception {
  include("SetUp", "-setUp");
}

private void includePageContent() thorws Exception {
  newPageContent.append(pageData.getContent());
}

private void includeTeardownPages() thorws Exception {
  includeTeardownPage();
  if (isSuite) {
    includeSuiteTearDownPage();
  }
}

private void includeTeardownPage() thorws Excpetion {
  include("TearDown", "-teardown"); // 여긴 왜 SuiteResponder로 사용안하지?
}

private void includeSuiteTearDownPage() throws Exception {
  include(SuiteResponder.SUITE_TEARDOWN_NAME, "-teardown")
}

private void updatePageContent() thorws Exception {
  pageData.setContent(newPageContent.toString());
}

private void include(String pageName, String arg) throws Exception { // 아래 메서드가 공통되는 로직이라면 내 코드에서도 이렇게 묶을 수 있음
  WikiPage inheritedPage = findInheritedPage(pageName);
  if (inheritedPage != null) {
    String pagePathName = getPathNameForPage(ingeritedPage);
    buildIncludeDirective(pagePathName, arg);
  }
}

private WikiPage findInheritedPage(String pageName) throws Exception { // 각 페이지마다 다른 로직이 아니어서 공통으로 묶을 수 있나봄
  return PageCrawlerImpl.getInheritedPage(pageName, testPage);
}

private String getPathNameForPage(WikiPage page) throws Exception {
  WikiPagePath pagePath = pageCrawler.getPullPath(page);
  return PathParser.render(pagePath);
}

private void buildIncludeDirective(String pagePathName, String arg) {
  newPageContenet
    .append(arg)
    .append(" .")
    .append(pagePathName)
    .append("\n")
}

