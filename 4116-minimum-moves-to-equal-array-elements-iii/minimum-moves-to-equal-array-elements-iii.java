class Solution {
    public int minMoves(int[] nums) {
        int max = 0, sum = 0;

        for (int x : nums) {
            max = Math.max(max, x);
            sum += x;
        }

        return nums.length * max - sum;
    }
}