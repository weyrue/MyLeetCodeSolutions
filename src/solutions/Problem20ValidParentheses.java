package solutions;

public class Problem20ValidParentheses {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) {
        String s = "{[]}";

        boolean ret = new Solution20().isValid(s);

        String out = booleanToString(ret);

        System.out.print(out);
    }
}

/**
 * 同样的算法，原始数组效率要比LinkedList快一些。
 */
class Solution20 {
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