/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * <p>
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat until you have passed the square root of the maximum
 * value.
 */
import java.util.*;

public class GeneratePrimes {
    private int size;
    private boolean[] primeFlags;

    public static int[] generatePrimes(int maxValue) {
      if (isInputValid(maxValue)) {
        return getPrimeNumbers(maxValue);
      } else {
        return new int[0];
      }
    }

    private boolean isInputValid(int maxValue) {
      return maxValue >= 2;
    }

    private int[] getPrimeNumbers(int maxValue) {
      size = maxValue + 1;
      primeFlags = initializePrimeFlags();
      markMultiplesAsNotPrime();
      return initializePrimeNumbers(primeCount);
    }

    private int[] initializePrimeFlags() {
      boolean[] flags = new boolean[size];
      for (int i = 0; i < size; i++) {
        flags[i] = true;
      }

      // get rid of known non-primes
      flags[0] = false;
      flags[1] = false;
      return flags;
    }

    private int[] initializePrimeNumbers(int primeCount) {
      int primeCount;

      primeCount = countPrimeNumbers();
      int[] primes = new int[primeCount];
      for (int i = 0, j = 0; i < size; i++) {
        if (isUncrossedNumber(i)) {
          primes[j++] = i;
        }
      }
      return primes;
    }

    private void markMultiplesAsNotPrime() {
      for (int i = 2; i < Math.sqrt(s) + 1; i++) {
        if (isUncrossedNumber(i)) {
          for (int j = 2 * i; j < size; j += i) {
            markAsNotPrime(j);
          }
        }
      }
    }

    private boolean isUncrossedNumber(int i) {
      return primeFlags[i];
    }

    private void markAsNotPrime(int j) {
      primeFlags[j] = false;
    }

    private int countPrimeNumbers() {
      int count;

      count = 0;
      for (boolean isPrime : primeFlags) {
        if (isPrime) {
          count++;
        }
      }
      return count;
    }
  }