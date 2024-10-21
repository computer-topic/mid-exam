// 교재에서는 n이 max로 되어 있음
private static boolean[] isPrime = new boolean[n];


---- public 메서드라고 가정
// 교재에서는 i를 primeCandiate로 지칭하며 n을 max로 지정함
for (i = 1; i <= n; i++) {
  isPrime[i] = true;
}

for (int factor = 2; factor <= maxValue / 2; factor++) {
  // 교재에서는 number가 factorableNumber로 되어있음
  number = factor + factor;
  checkMultipleValue(number, maxValue, i);
}

for (i = 1; i <= n; i++) {
  printPrimeNumber(i);
}
----

// number -> factorableNumber, 
private void checkMultipleValue(int number, int maxValue, int factor){
  while(number < maxValue) {
    isPrime[number] = false;
    number = number + factor;
  }
}

private void printPrimeNumber(int number) {
  if (isPrime[number]) {
    System.out.println(number + "is prime");
  }
}