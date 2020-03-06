package solutions.problem1to50;

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

/**
 * 1. 首先利用Arrays.sort(nums)对数组进行排序（排序是复杂度为O(NlogN)，排序为了使2Sum可以以O(N)的复杂度解决）。
 * 2. 选出第一个数字，即从第一个数字循环到倒数第三个数字，遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算）。
 * 3. 剩下的问题便是在余下数组中找到两数和为target-num[i]的2Sum问题
 *
 * 2Sum问题（有序数组）：
 * （1）在首尾设置两个指针l、r，若nums[l]+nums[r]大于target-num[i]，则让r向左移动一位（因为数组有序，所以nums[r-1]<=nums[r]），否则让l向右移动一位。
 * （2）重复以上工作，直到找到l、r使得nums[l]+nums[r]==target-num[i]。
 * （3）由于可能有大于一组的解，所以在找到一组解后，可将l向右移动一位（或r向左移动一位），继续查找，直到l与r相交（边界条件为l>=r）。
 * （4）找到所有的2Sum解后返回给3Sum问题。
 *
 * 4. num[i]和2Sum问题的解一并组成了3Sum的解。
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> zeroList = new LinkedList<>();
        /** 数组长度小于3时无解，返回空链表 */
        if (nums.length < 3) return zeroList;
        /** 排序 */
        Arrays.sort(nums);
        /** 选出第一个数字（即从第一个数字循环到倒数第三个数字），遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算） */
        for (int i = 0; i < nums.length - 2; i++) {
            // 遇到和上一个数字相同的便跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 第一个数字大于0则直接退出(递增数组)
            if (nums[i] > 0) break;
            // 最小的3个数之和大于零时直接退出(递增数组)
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            // 最大的3个数之和小于0时跳到下一次循环(递增数组)
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < 0) continue;
            // 计算2Sum
            List<List<Integer>> twoSumList = twoSum(nums, -nums[i], i + 1);

            // num[i]和2Sum问题的解一并组成了3Sum的解
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
     * @param sum  起始位置
     * @return
     * @version 1.0
     * @author Yi
     * @date 5/16/2019
     */
    private List<List<Integer>> twoSum(int[] nums, int sum, int startIndex) {
        List<List<Integer>> sumList = new LinkedList<>();
        // 设置首尾两个标识位
        int formerIndex = startIndex, latterIndex = nums.length - 1;
        // 循环条件为l<r
        while (formerIndex < latterIndex) {
            // 若nums[l]+nums[r]大于target-num[i]，
            // 则让r向左移动一位（因为数组有序，所以nums[r-1]<=nums[r]），
            // 否则让l向右移动一位。
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
                // 跳过重复数字
                while (formerIndex < nums.length && nums[formerIndex] == nums[formerIndex - 1])
                    formerIndex++;
            }
        }

        return sumList;
    }
}
