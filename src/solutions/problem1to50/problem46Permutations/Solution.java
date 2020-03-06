package solutions.problem1to50.problem46Permutations;

import java.util.*;

/**
 * 所有数字轮番交换到最后一位，然后递归（剩下的数字轮番交换到倒数第二位...），以此类推，每完成一圈的交换便是一个结果。
 * 此算法成立的原因是原始数组中的数字互不相同。
 *
 * @author Yi
 * @version 0ms
 * @since 3/5/2020
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();

        permuteHelper(resultList, nums, nums.length - 1);

        return resultList;
    }

    private void permuteHelper(List<List<Integer>> resultList, int[] nums, int endPos) {
        if (endPos == 0) {
            List<Integer> partialResult = new ArrayList<>(nums.length);
            for (int num : nums) partialResult.add(num);
            resultList.add(partialResult);
            return;
        }

        for (int i = 0; i <= endPos; i++) {
            swap(nums, i, endPos);
            permuteHelper(resultList, nums, endPos - 1);
            swap(nums, i, endPos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

///**
// * 此算法可以应对重复数字的情况。
// * 1. 原始数组排序，这样相同的数字靠在一起。
// * 2. 用一个boolean[]数组记录原始数组中的数字是否用过
// * 3. 从结果的第一位数字开始，原始数组中所有不同的数字轮番放在第一位（遇到重复数字情况跳过）。
// *    判断重复数字的因素是此位和上一位数字一样，且上一位数字没有使用过，即上一轮循环是同样数字。
// * 4. 然后递归计算第二位的数字，以此类推。
// *
// * @version 1ms
// * @author Yi
// * @since 3/5/2020
// */
//class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> resultList = new LinkedList<>();
//        if (nums == null || nums.length == 0) return resultList;
//        if (nums.length == 1) {
//            Integer[] result = {nums[0]};
//            resultList.add(Arrays.asList(result));
//            return resultList;
//        }
//
//        Arrays.sort(nums);
//
//        generateResult(resultList, nums, 0, new ArrayList<>(Collections.nCopies(nums.length, nums[0])), new boolean[nums.length]);
//
//        return resultList;
//    }
//
//    private void generateResult(List<List<Integer>> resultList, int[] nums, int startPos, ArrayList<Integer> partialResult, boolean[] isUsed) {
//        /* 只剩下两个数字和最后两位 */
//        if (startPos == nums.length - 2) {
//            /* 只剩下两个数字，只有两种情况（数字不同）或一种情况（数字相同） */
//            int i = 0, m = 0, n = 0;
//            for (; i < nums.length; i++) {
//                if (isUsed[i]) continue;
//                m = i++;
//                for (; i < nums.length; i++) {
//                    if (isUsed[i]) continue;
//                    n = i;
//                    break;
//                }
//                break;
//            }
//
//            partialResult.set(nums.length - 2, nums[m]);
//            partialResult.set(nums.length - 1, nums[n]);
//            resultList.add(new ArrayList<>(partialResult));
//            /* 剩下两个不相同数字的话多一种情况 */
//            if (nums[m] != nums[n]) {
//                partialResult.set(nums.length - 2, nums[n]);
//                partialResult.set(nums.length - 1, nums[m]);
//                resultList.add(new ArrayList<>(partialResult));
//            }
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                /* 此数字已使用过，则进行下一次循环 */
//                if (isUsed[i]) continue;
//                /*
//                 * 遇到重复数字情况，则进行下一次循环。
//                 * 重复数字情况指此位和上一位数字一样，且上一位数字没有使用过，即上一轮循环是同样数字。
//                 */
//                if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) continue;
//
//                partialResult.set(startPos, nums[i]);
//                isUsed[i] = true;
//                generateResult(resultList, nums, startPos + 1, partialResult, isUsed);
//                isUsed[i] = false;
//            }
//        }
//    }
//}