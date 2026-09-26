class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int start_index, int end_index){
        while(start_index < end_index) {
            int temp = nums[start_index];
            nums[start_index] = nums[end_index];
            nums[end_index] = temp;
            start_index++;
            end_index--;
        }
    }
}