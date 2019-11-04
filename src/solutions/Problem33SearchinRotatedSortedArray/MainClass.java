package solutions.Problem33SearchinRotatedSortedArray;

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
        String line = "[4,5,6,7,0,1,2]";
        int[] nums = stringToIntegerArray(line);
        int target = 0;

        int ret = new Solution().search(nums, target);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
