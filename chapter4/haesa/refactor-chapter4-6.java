import java.util.*;

/**
* The algorithm used is the Sieve of Eratosthenes.
* Given an array of integers starting at 2.
* Cross out all multiples of 2.
* Find the next uncrossed integer, and cross out all of its multiples.
* Repeat until you have passed the square root of the maximum value.
*/
public class PrimesGenerator {
  private static boolean[] flaggedPrimes;
  private static int size;
  public static final int MIN_PRIME = 2;

  public static int[] generatePrimes(int maxValue) {
    if (invalidValue(maxValue)) {
      return new int[0];
    }
    
    size = maxValue + 1;
    initializeFlaggedPrimes();
    checkPrimeForSieveOfEratosthenes();
    return getPrimes();
  }
  
  private static boolean invalidValue(int maxValue) {
    return maxValue < MIN_PRIME;
  }

  private static void initializeFlaggedPrimes() {
    flaggedPrimes = new boolean[size];

    for (int i = 0; i < size; i++)
      flaggedPrimes[i] = true;

    // get rid of known non-primes
    flaggedPrimes[0] = flaggedPrimes[1] = false;
  }

  private static void checkPrimeForSieveOfEratosthenes() {
    for (int candidate = 2; candidate < Math.sqrt(size) + 1; candidate++) {
      if (flaggedPrimes[candidate]) {
        markMultipleFalse(candidate);
      }
    }
  }
  
  private markMultipleFalse(int candidate) {
    for (int multiple = 2 * candidate; multiple < size; multiple += candidate)
      flaggedPrimes[multiple] = false;    
  }

  private static int[] getPrimes() {
    int count = getPrimeCount();
    int[] primes = new int[count];

    for (int candidate = 0, index = 0; candidate < size; candidate++) {
      if (flaggedPrimes[candidate])
        primes[index++] = candidate;
    }
    return primes;
  }

  private static int getPrimeCount() {
    int count = 0;

    for (int candidate = 0; candidate < size; candidate++) {
      if (flaggedPrimes[candidate])
        count++;
    }
    return count;
  }
}