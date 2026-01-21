import java.util.List;
import java.util.Arrays;

class Solution {
    // Change parameter from int[] to List<Integer>
    public int[] minBitwiseArray(List<Integer> nums) {
        int N = nums.size(); // Use .size() instead of .length
        int[] Ans = new int[N];
        Arrays.fill(Ans, -1);

        for (int i = 0; i < N; i++) {
            int val = nums.get(i); // Use .get(i) instead of [i]
            
            if (val == 2) continue;

            int n = val;
            int pos = 0;

            // Logic remains the same
            while (n > 0 && ((n >> pos) & 1) == 1) {
                pos++;
            }

            if ((1 << pos) > n) {
                int highestBit = 31 - Integer.numberOfLeadingZeros(n);
                n = n & ~(1 << highestBit);
            } else {
                n = n & ~(1 << (pos - 1));
            }

            Ans[i] = n;
        }

        return Ans;
    }
}