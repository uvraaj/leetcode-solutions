class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        find_combinations(1, k, n, new ArrayList<>(), result);

        return result;
    }

    private void find_combinations(int starting_num, int k_numbers, int target, List<Integer> tempList, List<List<Integer>> result) {
        //base case: we need to stop when target is found or combination exceeds the k digits
        if (target == 0 && k_numbers == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = starting_num; i < 10; i++) {
            //we need not to include combinations greater than k digits and numbers greater than target value
            if (k_numbers <= 0 || i > target) break;

            tempList.add(i);
            find_combinations(i + 1, k_numbers - 1, target - i, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}