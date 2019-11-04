package solutions.Problem33SearchinRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        return searchPartly(nums, target, 0, nums.length);
    }

    private int searchPartly(int[] nums, int target, int headIndex, int endIndex) {
        //只剩下一个元素，判断其是否是target值
        if (headIndex == endIndex) {
            if (nums[headIndex] == target) return headIndex;
            return -1;
        }
        int midIndex = (headIndex + endIndex) / 2;
        //nums[headIndex]<nums[endIndex]表示此段子序列是未旋转的有序序列
        //否则此段子序列是旋转的序列
        if (nums[headIndex] < nums[endIndex]) {
            //nums[midIndex]>nums[headIndex]说明pivot在右半段子序列
            //nums[midIndex]<nums[endIndex]说明pivot在左半段子序列
            if (nums[midIndex] > nums[headIndex]) {

            } else {

            }

        } else {

        }

        return 0;
    }
}
