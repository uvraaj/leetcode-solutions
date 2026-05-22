class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        if (nums == null || length == 0) {
            return -1;
        }
        int pivot = findPeakIndex(0, length-1, nums);

        int search1 = binarySearch(0, pivot, target, nums);
        if(search1 != -1) {
            return search1;
        }
        return binarySearch(pivot+1, length-1, target, nums);
        }

    private int findPeakIndex(int start, int end, int[] nums) {
        while(start < end) {
            int mid = start + (end - start + 1) / 2;

            if(nums[mid] >= nums[start]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    private int binarySearch (int start, int end, int target, int[] nums) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) { return mid; }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  
    }
}



