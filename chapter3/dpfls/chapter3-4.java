public static String testableHtml(PageData pageData, boolean includeSuiteSetup)
{
  WikiPage wikiPage = pageData.getWikiPage();
  StringBuffer buffer = new StringBuffer();
  if (pageData.hasAttribute("Test")) {
    if (includeSuiteSetup) {
      WikiPage suiteSetup = PageCrawlerImp.getInheritedPage(...);
      if (suiteSetup != null) {
        WikiPagePath pagePath = suiteSetup.getFullPath();
        String pagePathName = PathParser.render(pagePath);
        buffer.append("!include -setup .")
              .append(pagePathName)
              .append("\n");
      }
    }
    WikiPage setup = PageCrawlerImp.getInheritedPage(...);
    if (setup != null) {
      WikiPagePath setupPath = setup.getFullPath();
      String setupPathName = PathParser.render(setupPath);
      buffer.append("!include -setup .")
            .append(setupPathName)
            .append("\n");
    }
  }
  buffer.append(pageData.getContent());

  if (pageData.hasAttribute("Test")) {
    WikiPage teardown = PageCrawlerImpl.getInheritedPage(...);
    if (teardown != null) {
      WikiPagePath tearDownPath = teardonw.getFullPath();
      String tearDownPathName = PathParser.render(tearDownPath);
      buffer.append("\n")
            .append("!include -teardown .")
            .append(tearDownPathName)
            .append("\n");
    }
    if (includeSuiteSetup) {
      WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(...);
      if (suiteTeardown != null) {
        WikiPagePath pagePath = suiteTeardown.getFullPath();
        String pagePathName = PathParser.render(pagePath);
        buffer.append("!include -teardown .")
              .append(pagePathName)
              .append("\n");
      }
    }
  }

  pageData.setContent(buffer.toString());
  return pageData.getHtml();
}