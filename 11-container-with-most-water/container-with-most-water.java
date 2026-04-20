class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max_area = 0;

        while (start < end) {
            int min_height = Math.min(height[start], height[end]);
            max_area = Math.max(max_area, min_height * (end - start));

            if (start < end && height[start] <= min_height) start++;
            if (start < end && height[end] <= min_height) end --;
        }
        return max_area;
    }
}