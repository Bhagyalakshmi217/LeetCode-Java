
class Solution {
    public boolean canArrange(int[] arr, int k) {

        int[] freq = new int[k];

        // Count remainder frequencies
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            freq[rem]++;
        }

        // Remainder 0 must occur an even number of times
        if (freq[0] % 2 != 0) {
            return false;
        }

        // Check complementary remainders
        for (int rem = 1; rem <= k / 2; rem++) {

            if (rem == k - rem) {
                if (freq[rem] % 2 != 0) {
                    return false;
                }
            } else {
                if (freq[rem] != freq[k - rem]) {
                    return false;
                }
            }
        }

        return true;
    }
}
