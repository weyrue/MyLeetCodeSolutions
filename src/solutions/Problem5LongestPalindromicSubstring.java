package solutions;

public class Problem5LongestPalindromicSubstring {
    public String longestPalindrome(String input) {
        char[] s = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        String longestPalindromicSubstring = "";

        if (s == null || s.length == 0) return longestPalindromicSubstring;

        int sLength = s.length;
        sb.append(s[0]);
        int longestLength = 1;
        if (sLength > 1) {
            // 第一位的情况单独拿出来讨论
            if (s[0] == s[1]) {
                sb.append(s[1]);
                longestLength = 2;
            }
            // 讨论第二位开始到倒数第二位
            int lengthToLast;
            int innerLoop1, innerLoop2;
            for (int i = 1; i < sLength - 1; i++) {
                lengthToLast = sLength - i - 1;
                if (i < lengthToLast) {
                    innerLoop1 = i;
                } else {
                    innerLoop1 = lengthToLast;
                }

                int tmpLength1 = 1;
                for (int j = 1; j <= innerLoop1; j++) {
                    if (s[i - j] == s[i + j]) {
                        tmpLength1 += 2;
                    } else {
                        break;
                    }
                }

                if (i + 1 < lengthToLast) {
                    innerLoop2 = i + 1;
                } else {
                    innerLoop2 = lengthToLast;
                }

                int tmpLength2 = 0;
                for (int j = 1; j <= innerLoop2; j++) {
                    if (s[i + 1 - j] == s[i + j]) {
                        tmpLength2 += 2;
                    } else {
                        break;
                    }
                }

                //判断本次循环是否有新的最长回文数
                int chooseWhich = 0;
                if (tmpLength1 > longestLength) {
                    if (tmpLength2 > tmpLength1) {
                        chooseWhich = 2;
                        longestLength = tmpLength2;
                    } else {
                        chooseWhich = 1;
                        longestLength = tmpLength1;
                    }
                } else if (tmpLength2 > longestLength) {
                    chooseWhich = 2;
                    longestLength = tmpLength2;
                }

                switch (chooseWhich) {
                    case 1:
                        sb.delete(0, sb.length());
                        for (int k = (i - (tmpLength1 - 1) / 2); k <= (i + (tmpLength1 - 1) / 2); k++)
                            sb.append(s[k]);
                        break;
                    case 2:
                        sb.delete(0, sb.length());
                        for (int k = (i + 1 - tmpLength2 / 2); k <= (i + tmpLength2 / 2); k++)
                            sb.append(s[k]);
                        break;
                    default:
                        break;
                }

            }
            // 讨论最后一位的情况
        }

        longestPalindromicSubstring = sb.toString();

        return longestPalindromicSubstring;
    }
}
