public class HtmlRenderer {
  private StringBuffer buffer = new StringBuffer();

  public static String getHtmlWithTest(PageData pageData, boolean includeSuiteSetup) {
    WikiPage wikiPage = pageData.getWikiPage();
    boolean hasTest = pageData.hasAttribute("Test");

    if (hasTest) {
      setupTest(includeSuiteSetup);
    }

    appendPageData();

    if (hasTest) {
      teardownTest(includeSuiteSetup);
    }

    renderHtml()
    return pageData.getHtml();
  }

  private void setupTest(boolean includeSuiteSetup) {
    if (includeSuiteSetup) {
      WikiPage suiteSetupWikiPage = PageCrawlerImp.getInheritedPage(...);
      appendSetupLogToBuffer(suiteSetupWikiPage);
    }

    WikiPage setupWikiPage = PageCrawlerImp.getInheritedPage(...);
    appendSetupLogToBuffer(setupWikiPage);
  }

  private void appendSetupLogToBuffer(WikiPage wikiPage) {
    if (wikiPage != null) {
      String wikiPagePathName = getWikiPagePathName(wikiPage);
      buffer.append("!include -setup .")
            .append(wikiPagePathName)
            .append("\n");
    }
  }

  private void teardownTest(boolean includeSuiteSetup) {
    WikiPage teardownWikiPage = PageCrawlerImpl.getInheritedPage(...);
    appendTeardownLogToBuffer(teardownWikiPage);

    if (includeSuiteSetup) {
      WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(...);
      appendTeardownLogToBuffer(suiteTeardown, includeSuiteSetup);
    }
  }

  private void appendTeardownLogToBuffer(WikiPage wikiPage) {
    if (wikiPage != null) {
      String wikiPagePathName = getWikiPagePathName(wikiPage);
      buffer.append("\n")
            .append("!include -teardown .")
            .append(wikiPagePathName)
            .append("\n");
    }
  }

  private void appendTeardownLogToBuffer(WikiPage wikiPage, boolean includeSuiteSetup) {
    if (wikiPage != null) {
      String wikiPagePathName = getWikiPagePathName(wikiPage);
      buffer.append(includeSuiteSetup ? "" : "\n")
            .append("!include -teardown .")
            .append(wikiPagePathName)
            .append("\n");
    }
  }

  private String getWikiPagePathName(WikiPage wikiPage) {
    WikiPagePath wikiPagePath = wikiPage.getFullPath();
    return PathParser.render(wikiPagePath);
  }

  private void appendPageData() {
    buffer.append(pageData.getContent());
  }

  private void renderHtml() {
    pageData.setContent(buffer.toString());
  }
}