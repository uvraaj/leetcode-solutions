class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int n = height.length;
        int start = 0;
        int end = n-1;

        while (start < end) {
            int min_height = Math.min(height[start], height[end]);
            max_area = Math.max(max_area, min_height * (end - start));

            if (start < end && min_height >= height[start]) start++;
            if (start < end && min_height >= height[end]) end--;
        }

        return max_area;
    }
}