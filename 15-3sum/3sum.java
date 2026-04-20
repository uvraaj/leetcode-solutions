class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0; //as stated in the question
        Arrays.sort(nums);  //this will help finding the triplets easier
        Set<List<Integer>> set = new HashSet<>();   //using set data structure, to remove duplicates
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {  //sum is smaller, we need greater numbers
                    j++;
                } else {    //sum is larger, we need smaller numbers
                    k--;
                }
            }
        }
        result.addAll(set);
        return result;
    }
}