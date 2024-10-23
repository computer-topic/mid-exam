public int countTestCases(List<Test> tests) {
  int count = 0;

  for (Test test : tests)
    count += test.countTestCases();
  return count;
}