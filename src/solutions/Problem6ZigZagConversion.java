package solutions;

public class Problem6ZigZagConversion {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length < 2 || numRows < 2) return s;
        StringBuilder sb = new StringBuilder();
        // 两倍步距，减少计算量
        int doubleStep = 2 * (numRows - 1);

        int k = 0;
        while (k < length) {
            sb.append(s.charAt(k));
            k += doubleStep;
        }
        for (int i = 1; i < numRows - 1; i++) {
            if (i < length) sb.append(s.charAt(i));

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

        int t = numRows - 1;
        while (t < length) {
            sb.append(s.charAt(t));
            t += doubleStep;
        }

        return sb.toString();
    }
}
