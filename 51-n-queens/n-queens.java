class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // start backtracking from column 0
        solve(0, board, result, n);
        return result;
    }

    private void solve(int col, char[][] board, List<List<String>> result, int n) {
        // base case: if all the columns are filled, save the solution
        if (col == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }

        // try to place queen in each row for the current column
        for (int row = 0; row < n; row++) {
            if (is_safe(row, col, board, n)) {
                // place queen
                board[row][col] = 'Q';

                // Recurse to the next column
                solve(col + 1, board, result, n);

                // backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean is_safe(int row, int col, char[][] board, int n) {
        // check left in the same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') { return false; }
        }

        // check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') { return false; }
        }

        //check lower left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') { return false; }
        }

        // if it is safe to place
        return true;
    }
}