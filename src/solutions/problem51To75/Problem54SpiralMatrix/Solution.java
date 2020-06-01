package solutions.problem51To75.Problem54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0] == null
                || matrix[0].length == 0)
            return null;

        int m = matrix.length, n = matrix[0].length;

        List<Integer> output = new ArrayList<>(m * n);

        for (int k = 0; ; k++) {
            int mLimit = m - k - 1, nLimit = n - k - 1;
            if (k > mLimit || k > nLimit) break;
            if (k == mLimit) {
                for (int i = k; i <= nLimit; i++) output.add(matrix[k][i]);
                break;
            }
            if (k == nLimit) {
                for (int j = k; j <= mLimit; j++) output.add(matrix[j][k]);
                break;
            }
            for (int i = k; i <= nLimit; i++) output.add(matrix[k][i]);
            for (int j = k + 1; j <= mLimit; j++) output.add(matrix[j][nLimit]);
            for (int i = nLimit - 1; i >= k; i--) output.add(matrix[mLimit][i]);
            for (int j = mLimit - 1; j > k; j--) output.add(matrix[j][k]);
        }

        return output;
    }
}
