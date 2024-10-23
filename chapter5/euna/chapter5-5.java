...
for (XmlTest test : m_suite.getTests()) {
    TestRunner tr = m_runnerFactory.newTestRunner(this, test);
    tr.addListener(m_textReporter); m_testRunners.add(tr);

    invoker = tr.getInvoker();

    for (ITestNGMethod m : tr.getBeforeSuiteMethods()) {
        beforeSuiteMethods.put(m.getMethod(), m);
    }

    for (ITestNGMethod m : tr.getAfterSuiteMethods()) {
        afterSuiteMethods.put(m.getMethod(), m);
    }
}
...

// 함수가 너무 긴 경우에는 변수를 코드 근처로 내리는 것이 좋을 수도 있음
// 하지만 이 경우 함수가 길어서 발생한 문제이기 때문에 이미 좋은 코드가 아님 ㅡㅡ