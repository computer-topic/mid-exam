public int countTestCases() {
    int count = 0;
    Test each;

    for (each : tests)
        count += each.countTestCases();
    return count;
}