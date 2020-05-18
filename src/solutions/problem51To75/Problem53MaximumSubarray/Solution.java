package solutions.problem51To75.Problem53MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSubSum = nums[0];
        int sum_tmp = 0;
        int maxMinus = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                sum_tmp += nums[i];
                if (nums[i] > maxMinus) maxMinus = nums[i];
            } else {
                maxMinus = nums[i];
                if (sum_tmp > 0) {
                    sum_tmp += nums[i];
                } else {
                    sum_tmp = nums[i];
                }
                if (sum_tmp > maxSubSum) maxSubSum = sum_tmp;
            }
        }

        if (maxMinus <= 0) return maxMinus;

        return maxSubSum;
    }
}
