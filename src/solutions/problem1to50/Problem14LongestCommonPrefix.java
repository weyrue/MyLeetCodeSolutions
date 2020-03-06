package solutions.problem1to50;

public class Problem14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        String ret = new Solution14().longestCommonPrefix(strs);

        String out = (ret);

        System.out.print(out);
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int resultIndex = strs[0].length();
        final char[] strs0 = strs[0].toCharArray();

        for (int i = 1; i < strs.length; i++) {
            final char[] strsi = strs[i].toCharArray();

            int j = 0, largestIndex = resultIndex < strs[i].length() ? resultIndex : strs[i].length();

            while (j < largestIndex && strs0[j] == strsi[j]) j++;

            resultIndex = j;
        }

        return strs[0].substring(0, resultIndex);
    }
}
