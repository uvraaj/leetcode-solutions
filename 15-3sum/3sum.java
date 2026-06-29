class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triple_set = new HashSet<>(); //set to store unique triplets
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> hash_set = new HashSet<>(); //set to store elements seen so far

            for (int j = i+1; j < n; j++) {
                //calculating the third element, needed to form the triplet
                int third = -(nums[i] + nums[j]);

                if (hash_set.contains(third)) {
                    //found the triplet
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    //sort the triplets to ensure uniqueness in set
                    Collections.sort(temp);
                    triple_set.add(temp);
                }
                //if it does not contains, then add it for future checks
                hash_set.add(nums[j]);
            }
        }

        //converting the set into the List
        List<List<Integer>> ans = new ArrayList<>(triple_set);
        return ans;
    }
}