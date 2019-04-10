package solutions;

public class Problem8StringToIntegeratoi {
    public int myAtoi(String str) {
        int myAtoi = 0;
        int checkPos = 0;
        char sign = '+';
        //去除掉字符串前的空格
        while (checkPos < str.length() && str.charAt(checkPos) == ' ') {
            checkPos++;
        }
        // 如果去除空格后没有字符，则返回0
        if (checkPos >= str.length()) return 0;
        // 判断正负号
        if (str.charAt(checkPos) == '-') {
            sign = '-';
            checkPos++;
        } else if (str.charAt(checkPos) == '+') {
            checkPos++;
        }
        // 检查字符串中的数字字符并生成最终数字，每次做越界检查，如果越界则直接返回最大值或最小值
        int checkInteger;
        while (checkPos < str.length()) {
            if (str.charAt(checkPos) >= '0' && str.charAt(checkPos) <= '9') {
                checkInteger = myAtoi;
                myAtoi = 10 * myAtoi + (str.charAt(checkPos) - '0');
                // 越界检查
                if (checkInteger != (myAtoi / 10)) {
                    if (sign == '+') {
                        return 0x7fffffff;
                    } else {
                        return 0x80000000;
                    }
                }
                checkPos++;
            } else {
                break;
            }
        }
        // 最后返回结果，判断正负号
        if (sign == '-') return -myAtoi;
        return myAtoi;
    }
}
