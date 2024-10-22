public class TestPageGenerator {
  private StringBuffer newPageContent = new StringBuffer();

  public static String renderPageWithSetupAndTeardown(PageData pageData, boolean isSuite) {
    boolean isTestPage = pageData.hasAttribute("Test");

    if (isTestPage) {
      includeSetupPage(pageData, isSuite);
      includePageContent(pageData);
      includeTeardownPage(pageData, isSuite);
      updatePageContent(pageData);
    }

    return pageData.getHtml();
  }

  private void includeSetupPage(PageData pageData, boolean isSuite) {
    String type = "setup";

    if (isSuite) {
      WikiPage suiteSetupWikiPage = PageCrawlerImp.getInheritedPage(pageData, ...);
      appendNewPageContent(suiteSetupWikiPage, type, isSuite);
    }

    WikiPage setupWikiPage = PageCrawlerImp.getInheritedPage(pageData, ...);
    appendNewPageContent(setupWikiPage, type, isSuite);
  }

  private void appendNewPageContent(WikiPage wikiPage, String type, boolean isSuite) {
    if (wikiPage == null) {
      return;
    }

    boolean isSuiteTeardown = type == "teardown" && isSuite;
    String newLine = String.format("%s", isSuiteTeardown ? "\n" : "");
    String includedType = String.format("!include  -%s .", type);
    String wikiPagePathName = getWikiPagePathName(wikiPage);

    newPageContent
      .append(newLine)
      .append(includedType)
      .append(wikiPagePathName)
      .append("\n");
  }

  private void includeTeardownPage(PageData pageData, boolean isSuite) {
    String type = "teardown";

    WikiPage teardownWikiPage = PageCrawlerImpl.getInheritedPage(pageData, ...);
    appendNewPageContent(teardownWikiPage, type, isSuite);

    if (isSuite) {
      WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(pageData, ...);
      appendNewPageContent(teardownWikiPage, type, isSuite);
    }
  }

  private String getWikiPagePathName(WikiPage wikiPage) {
    WikiPagePath wikiPagePath = wikiPage.getFullPath();
    return PathParser.render(wikiPagePath);
  }

  private void includePageContent(PageData pageData) {
    newPageContent.append(pageData.getContent());
  }

  private void updatePageContent(PageData pageData) {
    pageData.setContent(newPageContent.toString());
  }
}