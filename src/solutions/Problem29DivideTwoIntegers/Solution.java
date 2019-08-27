package solutions.Problem29DivideTwoIntegers;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == Integer.MAX_VALUE) {
            if (dividend == Integer.MIN_VALUE) return -1;
            else if (dividend == Integer.MAX_VALUE) return 1;
            else return 0;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isPositive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend = isPositive ? dividend - divisor : dividend + divisor;
            result++;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        for (int i = 30; i >= 0; i--) {
            if (dividend >= (divisor << i) && divisor <= ((1 << (31 - i)) - 1)) {
                result += (1 << i);
                dividend -= (divisor << i);
            }
        }
        return isPositive ? result : -result;
    }
}