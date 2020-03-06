package solutions.problem1to50.problem50Powxn;

/**
 * 二分法，迭代回溯
 * n为正整数时：
 * n为偶数时，x^n=x^(n/2)*x^(n/2)
 * n为奇数时，x^n=x*x^((n-1)/2)*x^((n-1)/2)
 * 注意幂为负数和边界条件
 *
 * @author Yi
 * @version 0ms-100%
 * @since 3/6/2020
 */
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        /* int正数最大为2^31-1，故n为-2^31时，将其加1再计算 */
        if (n == -2147483648) return 1 / x * myPow(x, n + 1);
        if (n < 0) return 1 / myPowHelper(x, -n);
        return myPowHelper(x, n);
    }

    private double myPowHelper(double x, int n) {
        if (n == 0) return 1;
        int n_half = n / 2;
        double partialResult = myPowHelper(x, n_half);
        if (n == 2 * n_half) return partialResult * partialResult;
        else return x * partialResult * partialResult;
    }
}