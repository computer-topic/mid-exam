import java.util.*;

/**
* The algorithm used is the Sieve of Eratosthenes.
* Given an array of integers starting at 2.
* Cross out all multiples of 2.
* Find the next uncrossed integer, and cross out all of its multiples.
* Repeat until you have passed the square root of the maximum value.
*/
public class GeneratePrimes {
  private static boolean[] flagPrimes;
  private static int size;
  public static final int MIN_PRIME = 2;

  public static int[] generatePrimes(int maxValue) {
    if (invalidValue(maxValue)) {
      return new int[0];
    }
    
    size = maxValue + 1;
    initializeFlagPrimes();
    checkPrimeForSieveOfEratosthenes();
    return getPrimes();
  }
  
  private static boolean invalidValue(int maxValue) {
    return maxValue < MIN_PRIME;
  }

  private static void initializeFlagPrimes() {
    flagPrimes = new boolean[size];

    for (int i = 0; i < size; i++)
      flagPrimes[i] = true;

    // get rid of known non-primes
    flagPrimes[0] = flagPrimes[1] = false;
  }

  private static void checkPrimeForSieveOfEratosthenes() {
    for (int candidate = 2; candidate < Math.sqrt(size) + 1; candidate++) {
      if (flagPrimes[candidate]) {
        for (int factorableNumber = 2 * candidate; factorableNumber < size; factorableNumber += candidate)
          flagPrimes[factorableNumber] = false;
      }
    }    
  }

  private static int[] getPrimes() {
    int count = getPrimeCount();
    int[] primes = new int[count];

    for (int candidate = 0, index = 0; candidate < size; candidate++) {
      if (flagPrimes[candidate])
        primes[index++] = candidate;
    }
    return primes;
  }

  private static int getPrimeCount() {
    int count = 0;

    for (int candidate = 0; candidate < size; candidate++) {
      if (flagPrimes[candidate])
        count++;
    }
    return count;
  }
}