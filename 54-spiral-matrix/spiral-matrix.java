class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length; //number of rows
        int column = matrix[0].length; //number of columns

        //pointers for transversal
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = column - 1;

        //tranversing the matrix in spiral spiralOrder
        while (top <= bottom && left <= right) {

            //left -> right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //top -> bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //right -> left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //bottom -> top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
