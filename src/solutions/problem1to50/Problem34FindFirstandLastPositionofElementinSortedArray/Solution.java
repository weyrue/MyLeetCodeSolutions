package solutions.problem1to50.Problem34FindFirstandLastPositionofElementinSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            return new int[]{-1, -1};
        }
        int headIndex = searchRangeHead(nums, target, 0, nums.length - 1);
        int endIndex = searchRangeEnd(nums, target, headIndex > 0 ? headIndex : 0, nums.length - 1);
        return new int[]{headIndex, endIndex};
    }

    private int searchRangeHead(int[] nums, int target, int headIndex, int endIndex) {
        if (nums[headIndex] == target) return headIndex;
        int midIndex;
        while (true) {
            if (headIndex == endIndex || (endIndex - headIndex) == 1) {
                if (nums[headIndex] == target && nums[headIndex - 1] < target) return headIndex;
                if (nums[endIndex] == target && nums[endIndex - 1] < target) return endIndex;
                return -1;
            }

            midIndex = (headIndex + endIndex) / 2;

            if (nums[midIndex] == target && nums[midIndex - 1] < target) return midIndex;

            if (nums[midIndex] < target) {
                headIndex = midIndex;
            } else {
                endIndex = midIndex;
            }
        }
    }

    private int searchRangeEnd(int[] nums, int target, int headIndex, int endIndex) {
        if (nums[endIndex] == target) return endIndex;
        int midIndex;
        while (true) {
            if (headIndex == endIndex || (endIndex - headIndex) == 1) {
                if (nums[endIndex] == target && nums[endIndex + 1] > target) return endIndex;
                if (nums[headIndex] == target && nums[headIndex + 1] > target) return headIndex;
                return -1;
            }

            midIndex = (headIndex + endIndex) / 2;

            if (nums[midIndex] == target && nums[midIndex + 1] > target) return midIndex;

            if (nums[midIndex] > target) {
                endIndex = midIndex;
            } else {
                headIndex = midIndex;
            }
        }
    }
}

