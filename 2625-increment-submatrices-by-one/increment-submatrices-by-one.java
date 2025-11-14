class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] mat = new int[n][n] ;

        for(int i=0; i<queries.length; ++i) {

            int[] v = queries[i] ;

            for(int x=v[0]; x<=v[2]; ++x) {
                for(int y=v[1]; y<=v[3]; ++y) {
                    mat[x][y] += 1 ; 
                }
            }

        }

        return mat ;

    }
}