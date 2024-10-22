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
    private boolean[] primeFlags;
    private boolean[] primeNumbers;

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
        initializePrimeFlags(maxValue + 1);
        markMultiplesAsNotPrime();
        return initializePrimeNumbers(primeCount);
    }

    private int[] initializePrimeFlags(int size) {
        primeFlags = new boolean[size];
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
      primeNumbers = new int[primeCount];
      for (int i = 0, j = 0; i < size; i++) {
          if (isUncrossedNumber(i)) {
              primeNumbers[j++] = i;
          }
      }
      return primeNumbers;
    }

    private void markMultiplesAsNotPrime() {
        int limit;

        limit = getLimit();
        for (int i = 2; i <= limit; i++) {
            if (isUncrossedNumber(i)) {
                markMultipleAsNotPrime(i)
            }
        }
    }

    private int getLimit() {
        double limit;

        limit = Math.sqrt(primeFlags.length);
        return (int) limit;
    }

    private boolean isUncrossedNumber(int i) {
        return primeFlags[i];
    }

    private void markMultipleAsNotPrime(int i) {
        for (int j = 2 * i; j < size; j += i) {
            primeFlags[j] = false;
        }
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