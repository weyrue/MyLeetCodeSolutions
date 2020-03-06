package solutions.problem1to50.Problem36ValidSudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] boardCheckArray = new int[27][9];

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[j].length; i++) {
                if (board[j][i] == '.') continue;
                //行
                if (boardCheckArray[j][board[j][i]-'1'] == 1) return false;
                boardCheckArray[j][board[j][i]-'1'] = 1;
                //列
                if (boardCheckArray[i + 9][board[j][i]-'1'] == 1) return false;
                boardCheckArray[i + 9][board[j][i]-'1'] = 1;
                //3x3
                if (boardCheckArray[18 + 3 * (j / 3) + (i / 3)][board[j][i]-'1'] == 1) return false;
                boardCheckArray[18 + 3 * (j / 3) + (i / 3)][board[j][i]-'1'] = 1;
            }
        }
        return true;
    }
}
