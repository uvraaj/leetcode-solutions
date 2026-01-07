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
                //if target is zero return empty list
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        //there is a chance of finding a valid combination
        if (candidates[curr_index] <= target) {
            //adding the possible number to the temporay list
            tempList.add(candidates[curr_index]);
            //finding another posiible element via recursion
            generate_combinations(curr_index, candidates, target - candidates[curr_index], tempList, result);
            //backtracking to the previous stage in order to find another combinations
            tempList.remove(tempList.size() - 1);
        }
        //moving to next element
        generate_combinations(curr_index + 1, candidates, target, tempList, result);
    }
}