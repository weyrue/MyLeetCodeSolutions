package solutions.Problem20ValidParentheses;

/**
 * 利用栈数据结构
 * 当输入字符是'(','{','['时，将其插入到栈的顶部
 * 当输入字符是')','}',']'时，从栈顶部取出一个字符，判断其是否与输入字符匹配，即'('与')'、'{'与'}'、'['与']'。
 * 若匹配则继续以上操作，否则直接返回false，即输入不合法。
 * 当循环以上操作结束时，若栈中没有字符则返回true，否则返回false。
 * 注：同样的算法，用原始数组做栈效率要比LinkedList快一些。
 */
class Solution {
    /**
     * 同样的算法，用原始数组做栈效率要比LinkedList快一些。
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        char[] stack = new char[s.length()];
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            if (top == 0) {
                stack[top++] = s.charAt(i);
            } else {
                switch (s.charAt(i)) {
                    case ')':
                        if ('(' != stack[--top]) return false;
                        break;
                    case '}':
                        if ('{' != stack[--top]) return false;
                        break;
                    case ']':
                        if ('[' != stack[--top]) return false;
                        break;
                    default:
                        stack[top++] = s.charAt(i);
                        break;
                }
            }
        }
        return top == 0;
    }
}
