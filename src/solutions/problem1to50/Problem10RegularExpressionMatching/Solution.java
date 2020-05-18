package solutions.problem1to50.Problem10RegularExpressionMatching;

class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchRecursion(s, p, 0, 0);
//        return isMatchDynamicProgramming(s, p);
    }

    private boolean isMatchRecursion(String s, String p, int si, int pi) {
        // p为空且s为空时返回true
        if (pi >= p.length()) return si >= s.length();
        // 判断s.charAt(si)和p.charAt(pi)是否匹配
        boolean isCharMatch = si < s.length() && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi));
        // 当p为'.*'或者'a*'形式时，有两种情况
        // 1. 检查原字符串s和匹配字符串去掉前两位（p.substring(2)）后的匹配情况（由于*可以为0个或者多个）
        // 2. 当s.charAt(si)和p.charAt(pi)匹配的情况下，检查s.substring(1)和p的匹配情况
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
            return isCharMatch && isMatchRecursion(s, p, si + 1, pi) || isMatchRecursion(s, p, si, pi + 2);
        } else {
            return isCharMatch && isMatchRecursion(s, p, si + 1, pi + 1);
        }
    }

    private boolean isMatchDynamicProgramming(String s, String p) {
        // dp[i][j]表示s[0,i)和p[0,j)的匹配情况
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化
        dp[0][0] = true;
        // 初始化s为空字符串的情况
        for (int pi = 2; pi <= p.length(); pi++) {
            dp[0][pi] = p.charAt(pi - 1) == '*' && dp[0][pi - 2];
        }
        // 开始动态规划
        // 状态转移方程
        // p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
        // If p.charAt(j) == ‘.’ : dp[i][j] = dp[i-1][j-1];
        //
        // If p.charAt(j) == ‘*’:
        // here are two sub conditions:
        // if p.charAt(pi-1) != s.charAt(si) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
        // if p.charAt(pi-1) == s.charAt(si) or p.charAt(pi-1) == ‘.’:
        // dp[i][j] = dp[i-1][j] // in this case, a* counts as multiple a
        // dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
        for (int j = 1; j <= p.length(); j++) {
            int pi = j - 1;
            if (p.charAt(pi) == '*') {
                for (int i = 1; i <= s.length(); i++) {
                    int si = i - 1;
                    if (s.charAt(si) == p.charAt(pi - 1) || p.charAt(pi - 1) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            } else {
                for (int i = 1; i <= s.length(); i++) {
                    int si = i - 1;
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
