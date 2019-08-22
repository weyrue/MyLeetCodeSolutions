package solutions.Problem29DivideTwoIntegers;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == Integer.MAX_VALUE || divisor == Integer.MIN_VALUE) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MAX_VALUE;
        boolean isPositive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        int result = -1;
        if (dividend > 0) {
            divisor = Math.abs(divisor);
            while (dividend >= 0) {
                dividend -= divisor;
                result++;
            }
        } else {
            divisor = -Math.abs(divisor);
            while (dividend <= 0) {
                dividend -= divisor;
                result++;
            }
        }

        return isPositive ? result : -result;
    }
}