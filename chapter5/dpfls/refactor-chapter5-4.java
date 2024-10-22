public int countTestCases() {
    int count;

    count = 0;
    for (Test each : tests)
        count += each.countTestCases();
    return count;
}