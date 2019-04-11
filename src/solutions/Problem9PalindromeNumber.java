package solutions;

public class Problem9PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 负数一定不是回文的
        if (x < 0) return false;
        // 个位数一定是回文的
        if (x < 10) return true;
        // 非零的10的整数倍一定不是回文的（可能是为了凑最快速度）
        if (x % 10 == 0 && x != 0) return false;
        // 存数字字符
        int[] digits = new int[10];
        int pos = 0;
        // 逐位检查数字字符
        while (x > 9) {
            digits[pos++] = x - x / 10 * 10;
            x = x / 10;
        }
        digits[pos] = x;
        // 首尾判断是否回文
        int checkPos = 0;
        while (pos > checkPos && digits[checkPos] == digits[pos]) {
            checkPos++;
            pos--;
        }
        if (pos > checkPos) return false;

        return true;
    }
}
