class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        // Use n+1 for easier boundary handling
        int[][] diff = new int[n + 1][n + 1];

        // Step 1: Mark all query boundaries in O(q)
        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c3 = q[3];
            
            diff[r1][c1]++;
            diff[r1][c3 + 1]--;
            diff[r2 + 1][c1]--;
            diff[r2 + 1][c3 + 1]++;
        }

        // Step 2: Reconstruct the matrix using 2D prefix sum (O(n^2))
        int[][] mat = new int[n][n];
        
        // Pass 1: Row-wise prefix sum (spreads horizontally)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        // Pass 2: Column-wise prefix sum (spreads vertically)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        // Step 3: Copy the n x n part to the final matrix
        // (We could have done this in-place, but this is clearer)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = diff[i][j];
            }
        }
        
        return mat;
    }
}