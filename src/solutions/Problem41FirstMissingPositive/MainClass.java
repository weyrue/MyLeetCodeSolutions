package solutions.Problem41FirstMissingPositive;

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
        String line = "[7,8,9,11,12]";
        int[] nums = stringToIntegerArray(line);

        int ret = new Solution().firstMissingPositive(nums);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
