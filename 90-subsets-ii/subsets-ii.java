class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> non_duplicate_subset = new ArrayList<>();

        Arrays.sort(nums);

        generate_non_duplicate_subset(0, nums, non_duplicate_subset, new ArrayList<>());

        return non_duplicate_subset;
    }

    private void generate_non_duplicate_subset(int start_index, int[] nums, List<List<Integer>> non_duplicate_subset, List<Integer> tempList) {

        non_duplicate_subset.add(new ArrayList<>(tempList));

        for (int i = start_index; i < nums.length; i++) {
            if (i > start_index && nums[i] == nums[i-1]) continue;

            tempList.add(nums[i]);
            generate_non_duplicate_subset(i + 1, nums, non_duplicate_subset, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}