package solutions.problem1to50.Problem28ImplementstrStr;

public class MainClass {
    public static void main(String[] args) {
        String line = "a";
        String haystack = line;
        line = "a";
        String needle = line;

        int ret = new Solution().strStr(haystack, needle);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
