class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Loop from 0 to 2^n (e.g., 0 to 7)
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            
            // Check every bit position
            for (int j = 0; j < n; j++) {
                // If the j-th bit is set, include nums[j]
                if ((i >> j & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}