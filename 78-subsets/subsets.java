class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());  //empty list as required in the solution

        for (int num : nums) {
            int size = result.size();
            
            for (int i = 0; i < size; i++) {
                List<Integer> subsets = new ArrayList<>(result.get(i));
                subsets.add(num);
                result.add(subsets);
            }
        }
        return result;
    }
}