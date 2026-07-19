
class Solution {
    /**
     * Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.
     * @param left The left integer of the range.
     * @param right The right integer of the range.
     * @return The count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.
     */
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBits = countSetBits(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the number of set bits in the binary representation of an integer.
     * @param n The integer to count set bits for.
     * @return The number of set bits in the binary representation of the given integer.
     */
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Checks if a number is prime.
     * @param n The number to check for primality.
     * @return True if the number is prime, false otherwise.
     */
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}