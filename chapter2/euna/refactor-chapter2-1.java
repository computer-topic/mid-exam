
private static boolean[] isPrime = new boolean[n];


---- public 메서드라고 가정
for (i = 1 ; i <= n ; i++) {
  isPrime[i] = true;
}

for (factor = 2 ; factor <= maxValue / 2 ; factor++) {
  number = i + i;
  checkMultipleValue(number, maxValue, i);
}

for (i = 1; i <= n; i++)
  printPrimeNumber(i);
----

private void checkMultipleValue(int number, int maxValue, int factor){
  while(number < target) {
    isPrime[number] = false;
    number = number + factor;
  }
}

private void printPrimeNumber(int number) {
  if (isPrime[number]) {
    System.out.println(i + "is prime");
  }
}