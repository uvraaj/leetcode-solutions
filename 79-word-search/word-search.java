class Solution {
    public boolean exist(char[][] board, String word) {
        //number of rows
        int rows = board.length;

        //number of columns
        int columns = board[0].length;

        //exploring every possiblity
        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //search
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        //no match found
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int curr_index) {
        //match found
        if (curr_index == word.length()) return true;

        //boundary and mismatch check
        if (i < 0 ||
            j < 0 ||
            i >= board.length ||
            j >= board[0].length ||
            board[i][j] != word.charAt(curr_index)) {
                return false;
            }

        //if char matched then store it temporarily
        char temp = board[i][j];
        board[i][j] = '#';

        //explore next possible directions
        boolean found = dfs(board, word, i+1, j, curr_index+1) ||
                        dfs(board, word, i-1, j, curr_index+1) ||
                        dfs(board, word, i, j+1, curr_index+1) ||
                        dfs(board, word, i, j-1, curr_index+1);

        //backtrack and restore
        board[i][j] = temp;
        return found;
    }
}