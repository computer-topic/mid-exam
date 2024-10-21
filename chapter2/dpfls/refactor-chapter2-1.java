private static void initializeFlagArr(boolean[] isPrime, int size) {
    for (int i = 0; i <= size; i++) {
        isPrime[i] = true;
    }
}

private static void checkPrimeNumber(boolean[] isPrime, int size) {
    int factorableNumber;

    for （int factor = 2; i <= factor / 2; i++） {
        factorableNumber = factor + factor;
        while (factorableNumber <= size) {
        isPrime[factorableNumber] = false;
        factorableNumber = factorableNumber + factor;
        }
    }
}

private static void printPrimeNumber(boolean[] isPrime, int size) {
    for （int primeCandidate = 1; primeCandidate <= size; i++） {
        if (isPrime[primeCandidate]) {
            System.out.printin(primeCandidate + "is prime.");
        }
    }
}

initializeFlagArr(isPrime, n);
checkPrimeNumber(n);
printPrimeNumber(isPrime, n);