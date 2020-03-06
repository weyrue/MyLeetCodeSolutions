package solutions.problem1to50.Problem35SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target < nums[0]) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        int headIndex = 0, endIndex = nums.length - 1, midIndex;
        while (true) {
            if ((endIndex - headIndex) == 1) {
                if (nums[headIndex] == target) return headIndex;
//                if (nums[endIndex] < target) return endIndex;

                return endIndex;
            }

            midIndex = (headIndex + endIndex) / 2;
            if (nums[midIndex] == target) return midIndex;

            if (nums[midIndex] > target) endIndex = midIndex;
            else headIndex = midIndex;
        }
    }
}