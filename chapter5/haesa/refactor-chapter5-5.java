...
for (XmlTest test : suite.getTests()) {
    TestRunner testRunner = runnerFactory.newTestRunner(this, test);
    testRunner.addListener(textReporter);
    testRunners.add(testRunner);

    invoker = testRunner.getInvoker();
    
    for (ITestNGMethod method : testRunner.getBeforeSuiteMethods()) {
        beforeSuiteMethods.put(method.getMethod(), method);
    }

    for (ITestNGMethod method : testRunner.getAfterSuiteMethods()) {
        afterSuiteMethods.put(method.getMethod(), method);
    }
}
...