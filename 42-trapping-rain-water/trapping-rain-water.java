class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int trapped_water = 0;
        int start = 0;
        int end = n-1;
        int left_max = height[0];
        int right_max = height[n-1];

        while (start < end) {
            left_max = Math.max(left_max, height[start]);
            right_max = Math.max(right_max, height[end]);

            if (left_max < right_max) {
                trapped_water += left_max - height[start];
                start++;
            } else {
                trapped_water += right_max - height[end];
                end--;
            }
        }
        return trapped_water;
    }
}