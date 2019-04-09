package solutions;

public class Problem6ZigZagConversion {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length < 2 || numRows < 2) return s;
        StringBuilder sb = new StringBuilder();
        // 两倍步距，减少计算量
        int doubleStep = 2 * (numRows - 1);
        // 生成第一行数据
        int k = 0;
        while (k < length) {
            sb.append(s.charAt(k));
            k += doubleStep;
        }
        //生成中间行数据
        for (int i = 1; i < numRows - 1; i++) {
            // 中间行的第一列单独处理
            if (i < length) sb.append(s.charAt(i));
            // 每个中间列有两个数据
            int checkPoint, checkPointMiddlePosition = doubleStep;
            while (true) {
                checkPoint = checkPointMiddlePosition - i;
                if (checkPoint >= length) break;
                sb.append(s.charAt(checkPoint));

                checkPoint = checkPointMiddlePosition + i;
                if (checkPoint >= length) break;
                sb.append(s.charAt(checkPoint));

                checkPointMiddlePosition += doubleStep;
            }
        }
        // 生成最后一列数据
        int t = numRows - 1;
        while (t < length) {
            sb.append(s.charAt(t));
            t += doubleStep;
        }

        return sb.toString();
    }
}
