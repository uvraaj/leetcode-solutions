class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }
    private void swap(int[] nums, int zero_index, int nonzero_index) {
        int temp = nums[zero_index];
        nums[zero_index] = nums[nonzero_index];
        nums[nonzero_index] = temp;
    }
}