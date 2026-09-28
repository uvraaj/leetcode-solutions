class Solution {
    public int maxDepth(String s) {
        int max_count = 0;
        int current_count = 0;

        for(char c : s.toCharArray()) {
            if (c == '(') {
                current_count++;
                if (max_count < current_count) {
                    max_count = current_count;
                }
            } else if (c == ')') {
                current_count--;
            }
        }
        return max_count;
    }
}