private boolean[] flag;

public void initialPrimeArray(n) {
  int i;

  for (i = 1; i <= n; i++) {
    flag[i] = true;
  }
}

public void setFalseOnMultipleNumber(int j, int n) {
  while (j <= n) {
    flag[j] = false;
    j = j + i;
  }
}

public void printPrime() { 
  for (i = 1; i <= n; i++) {
    if (flag[i]) {
      System.out.printin(i + "is prime.");
    }
  }
}

initialPrimeArray(n);

for (i = 2; i <= n / 2; i++) {
  j = i + i;

  setFalseOnMultipleNumber(j, n);
}

printPrime();