public int countTestCases() {
  int count = 0;

  for (Test test : tests)
    count += test.countTestCases();
  return count;
}