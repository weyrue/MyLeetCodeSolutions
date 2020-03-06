package solutions.problem1to50.Problem20ValidParentheses;

public class Problem20ValidParentheses {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) {
        String s = "{[]}";

        boolean ret = new Solution().isValid(s);

        String out = booleanToString(ret);

        System.out.print(out);
    }
}