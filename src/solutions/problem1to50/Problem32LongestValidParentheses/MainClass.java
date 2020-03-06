package solutions.problem1to50.Problem32LongestValidParentheses;

public class MainClass {
    public static void main(String[] args) {
        String s = "(()(((()";
//        String s = ")()(((())))(";
//        String s = "())()(()())";

        int ret = new Solution().longestValidParentheses(s);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
