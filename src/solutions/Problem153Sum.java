package solutions;

import java.util.*;

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
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ret = new Solution15().threeSum(nums);

        String out = int2dListToString(ret);

        System.out.print(out);
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> zeroList = new LinkedList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int[] subNums = Arrays.copyOf(nums, i);

            List<List<Integer>> subList = twoSum(subNums, -nums[i]);

            for (List<Integer> twoSumIndexlist : subList) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[twoSumIndexlist.get(0)]);
                list.add(nums[twoSumIndexlist.get(1)]);
                list.add(nums[i]);
                zeroList.add(list);
            }

        }

        return zeroList;
    }

    /**
     * 返回和为sum的两个数字的index
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

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = sum - nums[i];
            if (valueIndexMap.containsKey(difference)) {
                sumList.add(Arrays.asList(valueIndexMap.get(difference), i));
            }
            valueIndexMap.put(nums[i], i);
        }

        return sumList;
    }
}
