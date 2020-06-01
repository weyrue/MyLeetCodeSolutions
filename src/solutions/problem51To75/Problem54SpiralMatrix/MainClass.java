package solutions.problem51To75.Problem54SpiralMatrix;

import org.json.JSONArray;

import java.util.List;

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {

//        JsonArray jsonArray = JsonArray.readFrom(input);
        JSONArray jsonArray = new org.json.JSONArray(input);
        if (jsonArray.length() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.length()][];
        for (int i = 0; i < arr.length; i++) {
//            JSONArray cols = jsonArray.get(i).asArray();
            JSONArray cols = jsonArray.getJSONArray(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) {
        String line = "[\n" +
                " [ 1, 2, 3 ],\n" +
                " [ 4, 5, 6 ],\n" +
                " [ 7, 8, 9 ],\n" +
                " [ 10, 11, 12 ],\n" +
                " [ 13, 14, 15 ]\n" +
                "]";
        int[][] matrix = stringToInt2dArray(line);

        List<Integer> ret = new Solution().spiralOrder(matrix);

        String out = integerArrayListToString(ret);

        System.out.print(out);
    }
}