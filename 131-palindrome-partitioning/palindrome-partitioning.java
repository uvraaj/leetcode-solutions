class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        generate_substrings(0, s, new ArrayList<>(), result);

        return result;
    }

    private void generate_substrings(int start, String str, List<String> tempList, List<List<String>> result) {
        //base case
        if (start == str.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int end = start + 1; end <= str.length(); end++) {
            if (is_palindrome(str, start, end - 1)) {
                tempList.add(str.substring(start, end));

                generate_substrings(end, str, tempList, result);

                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean is_palindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) { return false; }
        }
        return true;
    }
}