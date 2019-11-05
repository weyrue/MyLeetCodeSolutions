package solutions.Problem34FindFirstandLastPositionofElementinSortedArray;

public class MainClass {
    private static int[] stringToIntegerArray(String input) {
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

    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) {
        String line = "[0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10]";
        int[] nums = stringToIntegerArray(line);
        int target = 4;

        int[] ret = new Solution().searchRange(nums, target);

        String out = integerArrayToString(ret);

        System.out.print(out);
    }
}
