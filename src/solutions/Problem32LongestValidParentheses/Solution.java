package solutions.Problem32LongestValidParentheses;

class Solution {
    public int longestValidParentheses(String s) {
        int maxSize = 0, tmpMaxSize = 0;
        int leftPairStackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftPairStackSize++;
            } else {
                if (leftPairStackSize > 1) {
                    leftPairStackSize--;
                    tmpMaxSize += 2;
                    if(i==(s.length()-1)) {
                        maxSize = tmpMaxSize > maxSize ? tmpMaxSize : maxSize;
                        break;
                    }
                    continue;
                }
                if (leftPairStackSize == 1) {
                    leftPairStackSize = 0;
                    tmpMaxSize += 2;
                    if (s.length() > (i + 2) && s.charAt(i + 1) == '(') {
                        leftPairStackSize = 1;
                        i++;
                        continue;
                    }
                    maxSize = tmpMaxSize > maxSize ? tmpMaxSize : maxSize;
                    tmpMaxSize = 0;
                }
            }
        }

        return maxSize;
    }
}
