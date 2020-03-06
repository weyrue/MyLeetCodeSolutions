package solutions.problem1to50.problem49GroupAnagrams;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
//        String[] line = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] line = {"huh", "tit"};
        List<List<String>> res = new Solution().groupAnagrams(line);
        System.out.println(string2dListToString(res));
    }

    private static String string2dListToString(List<List<String>> strs) {
        StringBuilder sb = new StringBuilder("[");
        for (List<String> list : strs) {
            sb.append(integerArrayListToString(list));
            sb.append(',');
            sb.append('\n');
        }

        sb.setCharAt(sb.length() - 2, ']');
        return sb.toString();
    }

    private static String integerArrayListToString(List<String> strs, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            result.append(strs.get(index)).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayListToString(List<String> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}
