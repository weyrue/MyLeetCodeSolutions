package solutions;

import java.util.Arrays;

public class Problem163SumClosest {
    public static void main(String[] args) {
        int[] nums = {-4, -7, -2, 2, 5, -2, 1, 9, 3, 9, 4, 9, -9, -3, 7, 4, 1, 0, 8, 5, -7, -7};
        int target = 29;
        int ret = new Solution16().threeSumClosest(nums, target);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}

/**
 * 主要思想是将3 sum closest问题拆分成2 sum closest，在解决2 sum closest问题。
 * 解决2 sum closest可以利用两边夹逼的方法，逐步找到最接近的。
 * <p>
 * 1. 首先利用Arrays.sort(nums)对数组进行排序（排序是复杂度为O(NlogN)，排序为了使2Sum可以夹逼方法）。
 * 2. 选出第一个数字，即从第一个数字循环到倒数第三个数字，遇到和上一个数字相同的便跳过（重复数字情况一样，不用重复计算）。
 * 3. 剩下的问题便是在余下数组中找到两数和最接近target-num[i]的2 sum closest问题。
 * <p>
 * 2 sum closest问题
 * 设置当前最小的|(nums[l]+nums[r])-(target-num[i])|为Min|δ|
 * （1）在首尾设置两个指针l、r，计算|(nums[l]+nums[r])-(target-num[i])|，若比当前的最小值Min|δ|小，则将其替换。
 * （2）移动l或r，若(nums[l]+nums[r])-(target-num[i])大于Min|δ|，则将r向左移动一位，否则将l向右移动一位。
 * 此步骤是为了防止最优解被跳过，假如nums[l]+nums[r-1]是最优解，若此时l++，则此最优解会被跳过。
 * （3）重复以上步骤直到l和r相交，即l>=r。
 * <p>
 * 4. 比较包含nums[i]的3 sum closest是否是当前最接近target的，如果是则替换为当前3 sum closest。
 */
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        /** 数组长度为3时直接相加返回 */
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        /** 初始化变量 */
        int threeSum = nums[0] + nums[1] + nums[2];
        int delta = Math.abs(threeSum - target);
        /** 排序 */
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && threeSum != target; i++) {
            // 跳过重复的数字
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 计算包含nums[i]的局部最优解
            int threeSumTmp = nums[i] + twoSumClosest(nums, target - nums[i], i + 1);
            // 若局部最优解优于当前最有解则替换
            int del = Math.abs(threeSumTmp - target);
            if (del < delta) {
                threeSum = threeSumTmp;
                delta = del;
            }
        }

        return threeSum;
    }

    /**
     * 2 Sum Closest
     *
     * @param nums   数组
     * @param target 两数目标和
     * @param l      起始位置
     * @return
     * @version 1.0
     * @author Yi
     * @date 6/25/2019
     */
    private int twoSumClosest(int[] nums, int target, int l) {
        int r = nums.length - 1;
        // 只有两个元素时相加返回
        if (r - l <= 1) return nums[l] + nums[r];
        // 初始化变量
        int twoSum = nums[l] + nums[r];
        int absDelta = Math.abs(twoSum - target);

        while (l < r && twoSum != target) {
            int twoSumTmp = nums[l] + nums[r];
            int del = twoSumTmp - target;
            // 若局部最优解优于当前最有解则替换
            if (Math.abs(del) < absDelta) {
                twoSum = twoSumTmp;
                absDelta = Math.abs(del);
            }
            // 判断夹逼移动方向
            if (del >= absDelta) {
                r--;
            } else {
                l++;
            }
        }

        return twoSum;
    }
}
