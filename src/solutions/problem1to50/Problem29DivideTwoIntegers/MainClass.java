package solutions.problem1to50.Problem29DivideTwoIntegers;

public class MainClass {
    public static void main(String[] args) {
        String line = "-2147483648";
        int dividend = Integer.parseInt(line);
        line = "2147483647";
        int divisor = Integer.parseInt(line);

        int ret = new Solution().divide(dividend, divisor);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
