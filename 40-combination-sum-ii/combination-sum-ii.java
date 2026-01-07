import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array to handle duplicates easily
        Arrays.sort(candidates);
        
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] candidates, int target, List<Integer> tempList, List<List<Integer>> result) {
        // Base Case: Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 2. Skip duplicates at the same recursive level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // 3. Optimization: If the number is greater than remaining target, stop the loop
            if (candidates[i] > target) break;

            tempList.add(candidates[i]);
            // i + 1 use kar rahe hain kyunki ek element ek hi baar use hoga
            backtrack(i + 1, candidates, target - candidates[i], tempList, result);
            
            // Backtrack: remove the last element
            tempList.remove(tempList.size() - 1);
        }
    }
}