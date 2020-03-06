package solutions.problem1to50.problem44WildcardMatching;

class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0) == 1;
    }

    // 1-true，0-unknown，-1-false
    private int isMatch(String s, String p, int i, int j) {
        if (j == p.length())
            return i == s.length() ? 1 : 0;
        if (i == s.length()) {
            while (j < p.length() && p.charAt(j) == '*') j++;
            return j == p.length() ? 1 : -1;
        }

        if (p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*') j++;
            for (int k = i; k <= s.length(); k++) {
                int result = isMatch(s, p, k, j);
                if (result == 1 || result == -1)
                    return result;
            }
        } else {
            if (
                    (i < s.length())
                    && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
            )
                return isMatch(s, p, i + 1, j + 1);
        }
        return 0;
    }

//    /**
//     * 动态规划
//     *
//     * @param s string
//     * @param p patten
//     * @return boolean
//     * @author Yi
//     * @since 2/11/2020
//     */
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//        // boolean类型缺省值为false
//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//
//        dp[0][0] = true;
//        for (int j = 1; j <= p.length(); j++) {
//            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
//        }
//
//        for (int j = 1; j <= p.length(); j++) {
//            if (p.charAt(j - 1) == '*') {
//                for (int i = 1; i <= s.length(); i++) {
//                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                }
//            } else {
//                for (int i = 1; i <= s.length(); i++) {
//                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
//                }
//            }
//        }
//        return dp[s.length()][p.length()];
//    }
}
