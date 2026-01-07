class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        generate_combinations(0, candidates, target, tempList, result);

        return result;
    }
    private void generate_combinations(int curr_index, int[] candidates, int target,List<Integer> tempList, List<List<Integer>> result) {
        //base case: if checked for all elements of the candidates array
        if (curr_index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        if (candidates[curr_index] <= target) {
            tempList.add(candidates[curr_index]);
            generate_combinations(curr_index, candidates, target - candidates[curr_index], tempList, result);
            tempList.remove(tempList.size() - 1);
        }
        //moving to next element
        generate_combinations(curr_index + 1, candidates, target, tempList, result);
    }
}