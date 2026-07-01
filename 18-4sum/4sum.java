class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        //list of lists to store the result
        List<List<Integer>> result = new ArrayList<>();

        //set of lists, to remove the duplicate quadruples
        Set<List<Integer>> set_of_list = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                //set, to store the elements visited so far
                Set<Long> seen = new HashSet<>();

                for (int k = j+1; k < n; k++) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k];
                    long fourth = (long)target - sum;

                    if (seen.contains(fourth)) {
                        //found a match
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);

                        //sort the list, so that duplicates can be removed
                        Collections.sort(temp);
                        set_of_list.add(temp);
                    }
                    //if not, then add to the set
                    seen.add((long)nums[k]);
                }
            }
        }
        result.addAll(set_of_list);
        return result;
    }
}