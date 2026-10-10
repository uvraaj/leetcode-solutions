class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] d = new int[100001];
        long k = (long) k1 + k2;
        long sum = 0;
        int max = 0;

        // Step 1: Count the differences and find the max boundary
        for (int i = 0; i < nums1.length; i++) {
            int x = Math.abs(nums1[i] - nums2[i]);
            d[x]++;
            sum += x;
            max = Math.max(max, x);
        }

        // If we have enough budget to reduce every single difference to 0
        if (sum <= k) return 0;

        // Step 2: Shave the biggest differences in bulk, level by level
        for (int i = max; i > 0 && k > 0; i--) {
            if (d[i] > 0) {
                long move = Math.min(k, (long) d[i]);
                d[i] -= move;
                d[i - 1] += move; // Drop them to the next smaller bucket
                k -= move;
            }
        }

        // Step 3: Add up the squares
        long ans = 0;
        for (int i = 0; i <= max; i++) {
            if (d[i] > 0) {
                ans += (long) i * i * d[i];
            }
        }

        return ans;
    }
}