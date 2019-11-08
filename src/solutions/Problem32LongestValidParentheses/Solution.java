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
        int[] dynamicArray = new int[s.length()];
        dynamicArray[0] = 0;
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dynamicArray[i] = 0;
                continue;
            }
            if ((i - 1 - dynamicArray[i - 1]) < 0 || s.charAt(i - 1 - dynamicArray[i - 1]) != '(') {
                dynamicArray[i] = 0;
                continue;
            }
            dynamicArray[i] = 2 + dynamicArray[i - 1] + ((i - 2 - dynamicArray[i - 1]) >= 0 ? dynamicArray[i - 2 - dynamicArray[i - 1]] : 0);
            maxLength = dynamicArray[i] > maxLength ? dynamicArray[i] : maxLength;
        }

        return maxLength;
    }
}
