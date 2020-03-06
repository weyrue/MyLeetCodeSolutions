package solutions.problem1to50.problem50Powxn;

import java.text.DecimalFormat;

public class MainClass {
    public static void main(String[] args) {
        String line = "2.00000";
        double x = Double.parseDouble(line);
//        line = "-2147483648";
        line = "-2147483648";
        int n = Integer.parseInt(line);

        double ret = new Solution().myPow(x, n);

        String out = doubleToString(ret);

        System.out.print(out);
    }

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }
}
