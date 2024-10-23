...
for (XmlTest test : suite.getTests()) {
    TestRunner tr = runnerFactory.newTestRunner(this, test); // 이게 안좋은 예시인듯
    tr.addListener(m_textReporter);
    testRunners.add(tr);
    invoker = tr.getInvoker();
    for (ITestNGMethod m : tr.getBeforeSuiteMethods()) {
        beforeSuiteMethods.put(m.getMethod(), m);
    }
    for (ITestNGMethod m : tr.getAfterSuiteMethods()) {
        afterSuiteMethods.put(m.getMethod(), m);
    }
}
...