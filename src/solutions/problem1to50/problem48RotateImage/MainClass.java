package solutions.problem1to50.problem48RotateImage;

public class MainClass {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};

        new Solution().rotate(matrix);
        String out = int2dArrayToString(matrix);

        System.out.print(out);
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            int2dArrayToString(sb, item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void int2dArrayToString(StringBuilder sb, int[] item) {
        sb.append('[');
        for (int num : item) {
            sb.append(num);
            sb.append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
    }

}
