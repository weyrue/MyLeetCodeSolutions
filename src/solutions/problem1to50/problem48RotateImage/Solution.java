package solutions.problem1to50.problem48RotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        int tmp, l = matrix.length;
        for (int m = 0; m < l / 2; m++) {
            for (int k = m; k < l - 1 - m; k++) {
                tmp = matrix[m][k];
                matrix[m][k] = matrix[l - 1 - k][m];
                matrix[l - 1 - k][m] = matrix[l - 1 - m][l - 1 - k];
                matrix[l - 1 - m][l - 1 - k] = matrix[k][l - 1 - m];
                matrix[k][l - 1 - m] = tmp;
            }
        }
    }
}