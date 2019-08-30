package solutions.Problem30SubstringwithConcatenationofAllWords;

import java.util.List;

public class MainClass {
    public static String[] stringToStringArray(String line) {
//        JsonArray jsonArray = JsonArray.readFrom(line);
//        String[] arr = new String[jsonArray.size()];
        String[] arr = line.substring(1, line.length() - 1).split(",");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll("\"", "");
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
        String line = "abaababbaba";
        String s = line;
        line = "\"ba\",\"ab\",\"ab\"";
        String[] words = stringToStringArray(line);

        List<Integer> ret = new Solution().findSubstring(s, words);

        String out = integerArrayListToString(ret);

        System.out.print(out);
    }
}

