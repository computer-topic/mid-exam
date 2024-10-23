public int countTestCases(List<Test> tests) {
    int count;

    count = 0;
    for (Test eachTest : tests)
        count += eachTest.countTestCases();
    return count;
}