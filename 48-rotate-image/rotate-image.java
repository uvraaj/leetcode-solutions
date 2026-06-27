class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int boundary = n-1;

        for (int i = 0; i < n/2; i++) { //this loops keeps the track till the centre of the matrix
            for (int j = i; j < boundary-i; j++) {  // this prevents double swaping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[boundary-j][i];
                matrix[boundary-j][i] = matrix[boundary-i][boundary - j];
                matrix[boundary-i][boundary - j] = matrix[j][boundary-i];
                matrix[j][boundary-i] = temp;
            }
        }

    }
}