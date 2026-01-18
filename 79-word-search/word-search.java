class Solution {
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        // frequency pruning
        if(!canForm(board,word)) return false;

        // reverse word pruning
        if (count(word.charAt(0),board) > count(word.charAt(word.length()-1),board)) {
            word = new StringBuilder(word).reverse().toString();
        }

        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = dfs(board,i,j,word,0);
                    if(ans == true) return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board,int i,int j, String word,int idx){
        if(idx == word.length()) return true;

        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(idx)){
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '$';

        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];

            boolean ans = dfs(board,r,c,word,idx+1);
            if(ans == true) return true;
        }

        //backtrack
        board[i][j] = ch;
        return false;
    }

    static boolean canForm(char[][] board, String word){
        int[] freq = new int[128];
        for(char[] row : board){
            for(char ch : row){
                freq[ch]++;
            }
        }

        for(char ch : word.toCharArray()){
            freq[ch]--;
            if(freq[ch] < 0) return false;
        }

        return true;
    }

    static int count(char c, char[][] board) {
        int count = 0;
        for (char[] row : board) {
            for (char letter : row) {
                if (letter == c) count++;
            }
        }
        return count;
    }
}