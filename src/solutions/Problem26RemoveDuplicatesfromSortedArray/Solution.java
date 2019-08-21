package solutions.Problem26RemoveDuplicatesfromSortedArray;

/*
 * 设置一个变量（length）记录当前最后一个不重复的元素记录的位置。
 * 从头到尾遍历，若遇到一个新的不同的元素，则将length加1，然后复制一份存在nums[length]位置。
 *
 * 注：在循环中，continue是跳转到循环结尾而不是进入下一次循环，由此可能会带来额外的耗时...
 *     本题中0ms答案和1ms答案的区别则在于此
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        /* 数组长度为0或1时直接返回 */
        if (nums.length < 2) return nums.length;
        /* 记录当前最后一个不重复的元素记录的位置 */
        int length = 0;
        /* 从头到尾遍历，若遇到一个新的不同的元素，则将length加1，然后复制一份存在nums[length]位置 */
        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[length]) continue;
//            nums[++length] = nums[i];

            if (nums[i] != nums[length])
                nums[++length] = nums[i];
        }
        /* 不重复元素的个数为后一个不重复的元素记录的位置加1 */
        return length + 1;
    }
}
