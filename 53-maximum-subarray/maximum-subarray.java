class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        long curr_sum = 0;
        long max_sum = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            //add current element to the sum
            curr_sum += nums[i];

            //update the sum, if curr_sum is greater than the max_sum
            if (curr_sum > max_sum) max_sum = curr_sum;
            //reset the sum to zero, if it becomes less than zero
            if (curr_sum < 0) curr_sum = 0;
        }
        return (int) max_sum;
    }
}