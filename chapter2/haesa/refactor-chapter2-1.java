for (primeCandidate = 1; i <= max; i++) {
    flag[i] = true;
}

for (factor = 2; i <= max / 2; factor++) {
  factorableNumber = factor + factor;

  while (factorableNumber <= max) {
    flag[factorableNumber] = false;
    factorableNumber = factorableNumber + factor;
  }
}

for (primeCandidate = 1; primeCandidate <= max; primeCandidate++) {
    if (flag[primeCandidate]) {
      System.out.printin(primeCandidate + "is prime.");
  }
}