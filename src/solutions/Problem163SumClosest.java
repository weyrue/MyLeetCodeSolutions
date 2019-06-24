package solutions;

import java.util.Arrays;

public class Problem163SumClosest {
    public static void main(String[] args) {
        int[] nums = {-4, -7, -2, 2, 5, -2, 1, 9, 3, 9, 4, 9, -9, -3, 7, 4, 1, 0, 8, 5, -7, -7};
        int target = 29;
        int ret = new Solution().threeSumClosest(nums, target);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];

        int threeSum = nums[0] + nums[1] + nums[2];
        int delta = Math.abs(threeSum - target);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && threeSum != target; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int threeSumTmp = nums[i] + twoSumClosest(nums, target - nums[i], i + 1, nums.length - 1);

            int del = Math.abs(threeSumTmp - target);
            if (del < delta) {
                threeSum = threeSumTmp;
                delta = del;
            }
        }

        return threeSum;
    }

    private int twoSumClosest(int[] nums, int target, int l, int r) {
        if (r - l <= 1) return nums[l] + nums[r];

        int twoSum = nums[l] + nums[r];
        int absDelta = Math.abs(twoSum - target);

        while (l < r && twoSum != target) {
            int twoSumTmp = nums[l] + nums[r];
            int del = twoSumTmp - target;

            if (Math.abs(del) < absDelta) {
                twoSum = twoSumTmp;
                absDelta = Math.abs(del);
            }

            if (del >= absDelta) {
                r--;
            } else {
                l++;
            }
        }

        return twoSum;
    }
}
