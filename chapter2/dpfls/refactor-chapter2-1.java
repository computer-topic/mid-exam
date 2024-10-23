private static void initializeFlagArr(boolean[] isPrime, int max) {
    for (int primeCandidate = 1; primeCandidate <= max; primeCandidate++) {
        isPrime[primeCandidate] = true;
    }
}

private static void checkPrimeNumber(boolean[] isPrime, int max) {
    int factorableNumber;

    for (int factor = 2; factor <= max / 2; factor++) {
        factorableNumber = factor + factor;
        while(factorableNumber <= max) {
            isPrime[factorableNumber] = false;
            factorableNumber = factorableNumber + factor;
        }
    }
}

private static void printPrimeNumber(boolean[] isPrime, int max) {
    for (int primeCandidate = 1; primeCandidate <= max; i++) {
        if (isPrime[primeCandidate]) {
            System.out.printin(primeCandidate + "is prime.");
        }
    }
}

initializeFlagArr(isPrime, n);
checkPrimeNumber(n);
printPrimeNumber(isPrime, n);