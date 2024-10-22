import java.util.*;

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