package solutions.Problem32LongestValidParentheses;

class Solution {
//    public int longestValidParentheses(String s) {
//        if (s == null || s.isEmpty()) return 0;
//
//        int maxLength = 0, startPosition = 0;
//        List<Integer> stack = new LinkedList<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.add(0, i);
//            } else {
//                if (stack.isEmpty()) {
//                    startPosition = i + 1;
//                    continue;
//                }
//                stack.remove(0);
//
//                maxLength = stack.isEmpty() ? Math.max(maxLength, i - startPosition + 1) : Math.max(maxLength, i - stack.get(0));
//            }
//        }
//        return maxLength;
//    }

    //动态规划法
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        //dynamicArray记录以i位置结尾的最长完整括号组的长度
        int[] dynamicArray = new int[s.length()];
        dynamicArray[0] = 0;
        int maxLength = 0;
        //当i位置为'('时，dynamicArray[i]为0，因为不是完整括号组
        //当i位置为')'时，先要去掉其前面完整括号组，即dynamicArray[i - 1]个字符
        //查看去掉dynamicArray[i - 1]个字符后前一个字符是否是'('
        //如果不是，则dynamicArray[i]=0
        //如果是，则说明i位置的')'和前面dynamicArray[i - 1]字符以及再前一位的'('组成完整括号组，长度为2+dynamicArray[i - 1]
        //其与'('之前的字符串可能组成完整括号组，所以dynamicArray[i]=2 + dynamicArray[i - 1]+dynamicArray[i - 2 - dynamicArray[i - 1]]
        for (int i = 1; i < s.length(); i++) {
            //当i位置为'('时，dynamicArray[i]为0，因为不是完整括号组
            if (s.charAt(i) == '(') {
                dynamicArray[i] = 0;
                continue;
            }
            //当i位置为')'时，先要去掉其前面完整括号组，即dynamicArray[i - 1]个字符
            //查看去掉dynamicArray[i - 1]个字符后前一个字符是否是'('
            //如果不是，则dynamicArray[i]=0
            if ((i - 1 - dynamicArray[i - 1]) < 0 || s.charAt(i - 1 - dynamicArray[i - 1]) != '(') {
                dynamicArray[i] = 0;
                continue;
            }
            //如果是，则说明i位置的')'和前面dynamicArray[i - 1]字符以及再前一位的'('组成完整括号组，长度为2+dynamicArray[i - 1]
            //其与'('之前的字符串可能组成完整括号组，所以dynamicArray[i]=2 + dynamicArray[i - 1]+dynamicArray[i - 2 - dynamicArray[i - 1]]
            dynamicArray[i] = 2 + dynamicArray[i - 1] + ((i - 2 - dynamicArray[i - 1]) >= 0 ? dynamicArray[i - 2 - dynamicArray[i - 1]] : 0);
            //判断是否大于maxLength
            maxLength = dynamicArray[i] > maxLength ? dynamicArray[i] : maxLength;
        }

        return maxLength;
    }
}
