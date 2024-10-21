private static void initializeFlagArr(boolean[] flag, int size) {
    for (int i = 0; i <= size; i++) {
        flag[i] = true;
    }
}

private static void checkPrimeNumber(int size) {
    int j;

    for （int i = 2; i <= size / 2; i++） {
        j = i + i;
        while (j <= size) {
            flag[j] = false;
            j = j + i;
        }
    }
}

private static void printPrimeNumber(boolean[] flag, int size) {
    for （int i = 1; i <= size; i++） {
        if (flag[i]) {
            System.out.printin(i + "is prime.");
        }
    }
}

initializeFlagArr(flag, n);
checkPrimeNumber(n);
printPrimeNumber(flag, n);