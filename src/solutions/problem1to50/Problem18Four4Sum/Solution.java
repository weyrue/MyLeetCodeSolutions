package solutions.problem1to50.Problem18Four4Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 首先利用Arrays.sort(nums)对数组进行排序（排序是复杂度为O(NlogN)，排序为了使2Sum可以以O(N)的复杂度解决）。
 * 2. 选出第一个数字，即从第一个数字循环到倒数第4个数字，遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算）。
 * 3. 剩下的问题便是在余下数组中找到两数和为target-num[i]的3Sum问题
 * <p>
 * 3Sum问题（有序数组）：
 * 1）. 首先利用Arrays.sort(nums)对数组进行排序（排序是复杂度为O(NlogN)，排序为了使2Sum可以以O(N)的复杂度解决）。
 * 2）. 选出第一个数字，即从第一个数字循环到倒数第三个数字，遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算）。
 * 3）. 剩下的问题便是在余下数组中找到两数和为target-num[i]的2Sum问题
 * <p>
 * 2Sum问题（有序数组）：
 * （1）在首尾设置两个指针l、r，若nums[l]+nums[r]大于target-num[i]，则让r向左移动一位（因为数组有序，所以nums[r-1]<=nums[r]），否则让l向右移动一位。
 * （2）重复以上工作，直到找到l、r使得nums[l]+nums[r]==target-num[i]。
 * （3）由于可能有大于一组的解，所以在找到一组解后，可将l向右移动一位（或r向左移动一位），继续查找，直到l与r相交（边界条件为l>=r）。
 * （4）找到所有的2Sum解后返回给3Sum问题。
 * <p>
 * 4）. num[i]和2Sum问题的解一并组成了3Sum的解。
 * <p>
 * 4. num[i]和3Sum问题的解一并组成了4Sum的解。
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> targetList = new LinkedList<>();
        if (nums.length < 4) return targetList;
        /** 排序 */
        Arrays.sort(nums);
        /** 选出第一个数字（即从第一个数字循环到倒数第4个数字），遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算） */
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 最小的3个数之和大于target时直接退出(递增数组)
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // 最大的3个数之和小于target时跳到下一次循环(递增数组)
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) continue;
            // 计算3Sum
            List<List<Integer>> threeSumList = threeSum(nums, target - nums[i], i + 1);

            // nums[i]和3Sum问题的解一并组成了4Sum的解
            if (!threeSumList.isEmpty()) {
                for (List<Integer> singleThreeSumList : threeSumList) {
                    singleThreeSumList.add(0, nums[i]);
                    targetList.add(singleThreeSumList);
                }
            }
        }

        return targetList;
    }

    private List<List<Integer>> threeSum(int[] nums, int target, int startIndex) {
        List<List<Integer>> zeroList = new LinkedList<>();
        /** 数组长度小于3时无解，返回空链表 */
        if (nums.length < 3) return zeroList;
        /** 排序 */
        /** 选出第一个数字（即从第一个数字循环到倒数第三个数字），遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算） */
        for (int i = startIndex; i < nums.length - 2; i++) {
            // 遇到和上一个数字相同的便跳过
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            // 最小的3个数之和大于零时直接退出(递增数组)
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) break;
            // 最大的3个数之和小于0时跳到下一次循环(递增数组)
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < target) continue;
            // 计算2Sum
            List<List<Integer>> twoSumList = twoSum(nums, target - nums[i], i + 1);

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