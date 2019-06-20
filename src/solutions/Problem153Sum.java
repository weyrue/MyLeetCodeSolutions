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
        if (nums.length < 3) return zeroList;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if (nums[i] > 0) break;
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < 0) continue;

            List<List<Integer>> twoSumList = twoSum(nums, -nums[i], i + 1);

            if (!twoSumList.isEmpty()) {
                for (List<Integer> singleTwoSumList : twoSumList) {
                    singleTwoSumList.add(0, nums[i]);
                    zeroList.add(singleTwoSumList);
                }
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
    private List<List<Integer>> twoSum(int[] nums, int sum, int startIndex) {
        List<List<Integer>> sumList = new LinkedList<>();

        int formerIndex = startIndex, latterIndex = nums.length - 1;

        while (formerIndex < latterIndex) {
            int tmpSum = nums[formerIndex] + nums[latterIndex];

            if (tmpSum > sum) {
                latterIndex--;
            } else if (tmpSum < sum) {
                formerIndex++;
            } else {
                List<Integer> tmpList = new LinkedList<>();
                tmpList.add(nums[formerIndex]);
                tmpList.add(nums[latterIndex]);
                sumList.add(tmpList);
                formerIndex++;
                while (formerIndex < nums.length && nums[formerIndex] == nums[formerIndex - 1])
                    formerIndex++;
            }
        }

        return sumList;
    }
}
