package solutions.problem1to50;

public class Problem5LongestPalindromicSubstring {

    private int low_pos = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s == null) return null;
        int length = s.length();
        if (length < 2) return s;

        for (int i = 0; i < length - 1; i++) {
            extendsPalindromeSubString(s, length, i, i);
            extendsPalindromeSubString(s, length, i, i + 1);
        }

        return s.substring(low_pos, low_pos + maxLength);
    }

    private void extendsPalindromeSubString(String s, int length, int start, int end) {
        while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        int palindromeSubString = end - start - 1;
        if (palindromeSubString > maxLength) {
            maxLength = palindromeSubString;
            low_pos = start + 1;
        }
    }

    @Deprecated
    public String longestPalindrome2(String s) {
        // 入参为null是返回null
        if (s == null) return null;
        int length = s.length();
        if (length == 0 || length == 1) return s;

        // 是否回文矩阵
        int[][] isPalindromicMatrix = new int[length][length];

        int start = 0, end = 0;
        // 初始化矩阵对角线上的数据
        for (int k = 0; k < length; k++) {
            isPalindromicMatrix[k][k] = 1;
        }
        // 初始化矩阵对角线下方的一斜排数据
        for (int k = 0; k < length - 1; k++) {
            //若相邻的两位字符相等，则两位子字符串回文
            if (s.charAt(k) == s.charAt(k + 1)) {
                isPalindromicMatrix[k][k + 1] = 1;
                start = k;
                end = k + 1;
            } else
                isPalindromicMatrix[k][k + 1] = 0;
        }

        // 填满剩余的矩阵（由于每次的检查的回文长度都在递增，故不需要判断长度，直接赋值即可）
        for (int i = 2; i < length; i++) {
            for (int k = 0; k < length - i; k++) {
                if (isPalindromicMatrix[k + 1][k + i - 1] == 1 && s.charAt(k) == s.charAt(k + i)) {
                    isPalindromicMatrix[k][k + i] = 1;
                    start = k;
                    end = k + i;
                } else
                    isPalindromicMatrix[k][k + i] = 0;
            }
        }

        return s.substring(start, end + 1);
    }
}
