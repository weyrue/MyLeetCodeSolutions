package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem153Sum {
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
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

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

        List<List<Integer>> ret = new Solution15().threeSum(nums);

        String out = int2dListToString(ret);

        System.out.print(out);
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> zeroList = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 1; i--) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;

            int[] subNums = Arrays.copyOf(nums, i);

            List<List<Integer>> subList = twoSum(subNums, -nums[i]);

            for (List<Integer> twoSumIndexlist : subList) {
                List<Integer> list = new LinkedList<>();

                list.add(twoSumIndexlist.get(0));
                list.add(twoSumIndexlist.get(1));
                list.add(nums[i]);
                zeroList.add(list);
            }

        }

        return zeroList;
    }

    /**
     * 返回和为sum的两个数字
     *
     * @param nums 数组
     * @param sum  和
     * @return
     * @version 1.0
     * @author Yi
     * @date 5/16/2019
     */
    private List<List<Integer>> twoSum(int[] nums, int sum) {
        List<List<Integer>> sumList = new LinkedList<>();
        int lowerIndex = 0, higherIndex = nums.length - 1;

        while (higherIndex > lowerIndex) {
            if (nums[lowerIndex] + nums[higherIndex] == sum) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[lowerIndex++]);
                list.add(nums[higherIndex--]);
                sumList.add(list);
                while (higherIndex >= 0 && nums[higherIndex] == nums[higherIndex + 1]) higherIndex--;
                while (lowerIndex < nums.length && nums[lowerIndex] == nums[lowerIndex - 1]) lowerIndex++;
            } else {
                while (higherIndex > 0 && ((higherIndex < nums.length - 1 && nums[higherIndex] == nums[higherIndex + 1]) || nums[lowerIndex] + nums[higherIndex] > sum)) {
                    higherIndex--;
                }
                while (lowerIndex < nums.length - 1 && ((lowerIndex > 0 && nums[lowerIndex] == nums[lowerIndex - 1]) || nums[lowerIndex] + nums[higherIndex] < sum)) {
                    lowerIndex++;
                }
            }
        }

        return sumList;
    }
}
