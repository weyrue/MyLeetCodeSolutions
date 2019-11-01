package solutions.Problem32LongestValidParentheses;

public class MainClass {
    public static void main(String[] args) {
        String s = "(()";

        int ret = new Solution().longestValidParentheses(s);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
