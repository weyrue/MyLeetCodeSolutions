package solutions.problem1to50.problem42TrappingRainWater;

public class MainClass {
    public static void main(String[] args) {
//        String line = "[1,0,2,1,0,1,3,2,1,2,1,3]";
//        String line = "[5,4,1,2]";
        String line = "[5,5,1,7,1,1,5,2,7,6]";
        int[] height = stringToIntegerArray(line);

        int ret = new Solution().trap(height);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

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
}
