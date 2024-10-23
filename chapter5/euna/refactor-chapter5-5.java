...
for (XmlTest test : suite.getTests()) {
    TestRunner testRunner = runnerFactory.newTestRunner(this, test); // 이게 안좋은 예시인듯
    testRunners.addListener(textReporter);
    testRunners.add(testRunner);
    invoker = testRunners.getInvoker();
    for (ITestNGMethod method : testRunner.getBeforeSuiteMethods()) {
        beforeSuiteMethods.put(method.getMethod(), method);
    }
    for (ITestNGMethod method : testRunner.getAfterSuiteMethods()) {
        afterSuiteMethods.put(method.getMethod(), method);
    }
}
...