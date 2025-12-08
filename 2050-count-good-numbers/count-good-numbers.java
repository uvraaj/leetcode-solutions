class Solution {
    public int countGoodNumbers(long n) {
        long MOD = 1000000007;
        long even_slots = n / 2;
        long odd_slots = n - even_slots;

        long even_index = binary_exponentiation(5, odd_slots, MOD);
        long odd_index = binary_exponentiation(4, even_slots, MOD);

        return (int)((even_index * odd_index) % MOD);
    }

    private long binary_exponentiation(long base, long exponent, long MOD) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent = exponent / 2;
        }
        return result;
    }
}