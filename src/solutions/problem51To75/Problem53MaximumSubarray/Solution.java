package solutions.problem51To75.Problem53MaximumSubarray;

class Solution {
    /*
     * 假设Σai+Σaj<0且存在Σaj>0，那么必然有Σai<0。
     * Σai<0会使之在if (sum < 0) sum = 0这一步被抛弃，即不存在Σai+Σaj这样的连续相加。
     * 故不存在Σaj>0
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;

        }
        return max;
    }
}
