class Solution {
    public String removeOuterParentheses(String s) {
        String result = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            //corner case
            if((count == 1 && s.charAt(i) == '(') || count == 0) {
                continue;
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}