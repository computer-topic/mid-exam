import java.util.*;

/**
* This class Generates prime numbers up to a user specified
* maximum. The algorithm used is the Sieve of Eratosthenes.
* The algorithm is quite simple. Given an array of integers
* starting at 2. Cross out all multiples of 2. Find the next
* uncrossed integer, and cross out all of its multiples.
* Repeat until you have passed the square root of the maximum
* value.
*/
public class PrimesGenerator {
  private static boolean[] isPrime;
  private static int[] results;
  private static int size;

  public static int[] generatePrimes(int limitValue) {
    if (limitValue < 2) { // invalid case
      return new int[0];
    }
    allocateAndInitializeIsPrime(limitValue);
    makeNonPrimesFalse();
    movePrimesIntoResult();
    return results;
  }

  private static void allocateAndInitializeIsPrime(int limitValue) {
    size = limitValue + 1;
    isPrime = new boolean[size];
    for (int i = 0; i < size; i++) {
      isPrime[i] = true;
    }
  }

  private static void makeNonPrimesFalse() {
    // 0 and 1 are non-prime
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i <= Math.sqrt(size); i++) {
      if (isPrime[i]) {
        makeMultipleFalse(i);
      }
    }
  }

  private static void makeMultipleFalse(int prime) {
    for (int multiple = 2 * prime; multiple < size; multiple += prime) {
      isPrime[multiple] = false;
    }
  }

  private static void movePrimesIntoResult() {
    int count = getPrimeCount();

    results = new int[count];
    for (int i = 0, j = 0; i < size; i++) {
      if (isPrime[i]) {
        results[j++] = i;
      }
    }
  }

  private static int getPrimeCount() {
    int count = 0;

    for (int i = 0; i < size; i++) {
      if (isPrime[i]) {
        count++;
      }
    }
    return count;
  }
}

// -- 아래는 교재 코드임

import java.util.*;

/**
* This class Generates prime numbers up to a user specified
* maximum. The algorithm used is the Sieve of Eratosthenes.
* Given an array of integers starting at 2:
* Find the first uncrossed integer, and cross out all its multiples.
* Repeat Until there are no more multiples in the array.
*/
public class PrimesGenerator {
  private static boolean[] isCrossedOut;
  private static int[] results;

  public static int[] generatePrimes(int generateLimit) {
    if (generateLimit < 2) { // return null array if bad input
      return new int[0];
    }
    uncrossedIntegersUpTo(generateLimit);
    crossOutMultiples();
    putUncrossedIntegersIntoResults();
    return results;
  }

  private static void uncrossIntegersUpTo(int generateLimit) {
    isCrossedOut = new boolean[generateLimit + 1];
    // 여기서 '<=' 를 사용함으로써 다른 for문과 차이점이 생기게 되는데, size 변수를 설명적 변수로 두고 < 로 통일해서 작성하는것도 좋은듯
    for (int i = 0; i <= generateLimit; i++) { 
      isCrossedOut[i] = true;
    }
  }

  // sieve 알고리즘에서 루트까지 검사하는 부연설명 대신 limit 결정에 대한 함수로 분리
  private static void crossOutMultiples() {
    int limit = determineInterationLimit();
    for (int i = 2; i <= Math.sqrt(size); i++) {
      if (isCrossedOut[i]) {
        crossOutMultiplesOf(i);
      }
    }
  }

  private static int determineInterationLimit() {
    // Every multiple in the array has a prime factor that
    // is less than or equal to the root of the array size,
    // so we don't have to cross out multiples of numbers
    // larger than that root.
    double iterationLimit = Math.sqrt(isCrossedOut.length);
    return (int) iterationLimit;
  }

  private static void crossOutMultiplesOf(int i) {
    // 여기서는 배수를 x 표시하는게 주 목적이므로 multiple로 표현하는게 좋은 기법
    for (int multiple = 2 * i; multiple < isCrossedOut.length; multiple += i) {
      isCrossedOut[multiple] = false; // 이 부분도 crossOut(i)로 함수 분리하는 방법도 좋다고 하심
    }
  }

  private static void putUncrossedIntegersIntoResults() {
    int size = countUncrossedIntegers();

    results = new int[size];
    for (int i = 0, j = 0; i < isCrossedOut.length; i++) {
      if (notCrossed(i)) {
        results[j++] = i;
      }
    }
  }

  private static int countUncrossedIntegers() {
    int count = 0;

    for (int i = 0; i < isCrossedOut.length; i++) {
      if (notCrossed(i)) {
        count++;
      }
    }
    return count;
  }

  private static boolean notCrossed(int i) { // 교재에는 없지만 이런 내용이지 않을까 ?
    return isCrossedOut[i];
  }
}

// 교재는 주석에 담긴 cross의 의미를 담아 변수명 및 함수명을 결정하고,
// sieve 알고리즘을 강조 또는 부연설명하는 주석을 남기는데 중점적으로 리팩토링함