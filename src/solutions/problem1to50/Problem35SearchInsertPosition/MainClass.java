package solutions.problem1to50.Problem35SearchInsertPosition;

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

    public static void main(String[] args) {
        String line = "[1,3]";
        int[] nums = stringToIntegerArray(line);
        int target = 1;

        int ret = new Solution().searchInsert(nums, target);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}