package solutions.Problem32LongestValidParentheses;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;

        int maxLength = 0, startPosition = 0;
        List<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(0, i);
            } else {
                if (stack.isEmpty()) {
                    startPosition = i + 1;
                    continue;
                }
                stack.remove(0);

                maxLength = stack.isEmpty() ? Math.max(maxLength, i - startPosition + 1) : Math.max(maxLength, i - stack.get(0));
            }
        }
        return maxLength;
    }

//    public int longestValidParentheses(String s) {
//        if (s == null || s.isEmpty()) return 0;
//
//        int maxLength = 0, addableMaxLength = 0, startPosition = -1, tmpMaxLength = 0;
//        List<Integer> stack = new LinkedList<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
////                if (tmpMaxLength > maxLength) maxLength = tmpMaxLength;
//                stack.add(0, i);
//            } else {
//                if (stack.isEmpty()) {
//                    tmpMaxLength = 0;
//                    startPosition = i;
//                    addableMaxLength = 0;
//                    continue;
//                }
//                stack.remove(0);
//                tmpMaxLength += 2;
//                if ((i - startPosition) == (addableMaxLength + tmpMaxLength)) {
//                    if ((i - startPosition) > maxLength) {
//                        maxLength = i - startPosition;
//                    }
//                } else if (tmpMaxLength > maxLength) {
//                    maxLength = tmpMaxLength;
//                }
//                if (stack.isEmpty()) {
//                    addableMaxLength = tmpMaxLength;
//                    tmpMaxLength = 0;
//                }
//            }
//        }
//        return maxLength;
//    }
}
