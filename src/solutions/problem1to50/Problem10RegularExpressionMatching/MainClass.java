package solutions.problem1to50.Problem10RegularExpressionMatching;

public class MainClass {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) {
        String s = "bbbba";
        String p = ".*a*a";

        boolean ret = new Solution().isMatch(s, p);

        String out = booleanToString(ret);

        System.out.print(out);
    }


}
