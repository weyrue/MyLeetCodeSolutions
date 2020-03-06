package solutions.problem1to50.problem41FirstMissingPositive;

class Solution {
    //主要思想是把数字交换到相应的位置，那么数组中第一个不是对应数字的就是最小丢失正整数
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        //没有i++，是因为交换过来的新的数可能会继续交换，直到不再需要交换为止
        for (int i = 0; i < nums.length; ) {
            //4中情况不交换，直接跳过
            //nums[i]小于1
            //nums[i]大于数组长度（最小丢失正整数一定小于等于数组长度+1）
            //数组上该位置已经是对应数字（如位置0对应1）
            //nums[i]应该交换的位置已经是对应数字（发生在有重复数字的情况）
            if (nums[i] < 1 || nums[i] > nums.length || nums[i] == (i + 1) || nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }
            int switchTmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = switchTmp;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return (i + 1);
        }

        return nums.length + 1;
    }
}