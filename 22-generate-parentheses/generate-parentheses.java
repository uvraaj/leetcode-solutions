class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generate_parentheses(n, 0, 0, "", result);

        return result;
    }
    private void generate_parentheses(int total_pairs, int opening_parentheses, int closing_parentheses, String temp, List<String> result) {
        //base case
        if (temp.length() == total_pairs * 2) {
            result.add(temp);
            return;
        }

        if (opening_parentheses < total_pairs) {
            generate_parentheses(total_pairs,opening_parentheses + 1, closing_parentheses, temp + '(', result);
        }

        if (closing_parentheses < opening_parentheses) {
            generate_parentheses(total_pairs,opening_parentheses, closing_parentheses + 1, temp + ')', result);
        }
    }
}