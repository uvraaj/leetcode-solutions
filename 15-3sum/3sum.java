class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        //creating a list of lists to store the result
        List<List<Integer>> result = new ArrayList<>();

        //sort the array, to apply the two pointer approach
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            //skip the duplicate
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //two pointers approch
            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    //found a triplet, sum == 0;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    //storing this triplet in the resultant list
                    result.add(temp);

                    //moving forward, to find another pair
                    j++;
                    k--;

                    //skip the duplicates
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return result;
    }
}