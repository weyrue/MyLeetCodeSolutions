package solutions.problem1to50.Problem33SearchinRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return searchPartly(nums, target, 0, nums.length - 1);
    }

    private int searchPartly(int[] nums, int target, int headIndex, int endIndex) {
        //只剩下1个或2个元素，判断其是否是target值
        if (nums[headIndex] == target) return headIndex;
        if (nums[endIndex] == target) return endIndex;
        if (headIndex == endIndex || endIndex == (headIndex + 1)) return -1;
        //中点位置
        int midIndex = (headIndex + endIndex) / 2;
        //nums[headIndex] < nums[endIndex]表示此段子序列是未旋转的有序序列
        if (nums[headIndex] < nums[endIndex]) {
            //若target > nums[midIndex],则target在右半边子序列，否则在左半边子序列
            if (target > nums[midIndex]) {
                return searchPartly(nums, target, midIndex, endIndex);
            } else {
                return searchPartly(nums, target, headIndex, midIndex);
            }
        }
        //nums[headIndex] > nums[endIndex]表示此段子序列是旋转的序列
        else {
            //nums[midIndex] > nums[headIndex]说明pivot在右半段子序列
            if (nums[midIndex] > nums[headIndex]) {
                //若nums[headIndex] < target < nums[midIndex]，则target在左半边子序列
                if (nums[headIndex] < target && target < nums[midIndex]) {
                    return searchPartly(nums, target, headIndex, midIndex);
                }
                //否则target在右半边子序列
                else {
                    return searchPartly(nums, target, midIndex, endIndex);
                }
            }
            //nums[midIndex] < nums[endIndex]说明pivot在左半段子序列
            else {
                //若nums[midIndex] < target < nums[endIndex]，则target在右半边子序列
                if (nums[midIndex] < target && target < nums[endIndex]) {
                    return searchPartly(nums, target, midIndex, endIndex);
                }
                //否则target在左半边子序列
                else {
                    return searchPartly(nums, target, headIndex, midIndex);
                }
            }
        }
    }
}
