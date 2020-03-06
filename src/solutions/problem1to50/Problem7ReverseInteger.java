package solutions.problem1to50;

public class Problem7ReverseInteger {
    public int reverse(int x) {
        // 也表示最终的结果
        int y = 0;
        // 分正数和负数的情况，区别只在于while循环中判断条件的差别
        if (x < 0) {
            while (x < -9) {
                int x_tmp = x / 10;
                y = 10 * y + x - x_tmp * 10;
                x = x_tmp;
            }
            // 最后一位情况单独处理，且做一次除法检查，若数据不一致说明越界，则返回0
            int checkInteger = y;
            y = 10 * y + x;
            if (checkInteger != (y - x) / 10) return 0;
        } else {
            while (x > 9) {
                int x_tmp = x / 10;
                y = 10 * y + x - x_tmp * 10;
                x = x_tmp;
            }
            // 最后一位情况单独处理，且做一次除法检查，若数据不一致说明越界，则返回0
            int checkInteger = y;
            y = 10 * y + x;
            if (checkInteger != (y - x) / 10) return 0;
        }

        return y;
    }
}
