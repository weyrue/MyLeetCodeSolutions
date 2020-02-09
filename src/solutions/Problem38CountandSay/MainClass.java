package solutions.Problem38CountandSay;

public class MainClass {
    public static void main(String[] args) {
        int n = 6;

        String ret = new Solution().countAndSay(n);

        String out = ret;

        System.out.print(out);
    }
}
