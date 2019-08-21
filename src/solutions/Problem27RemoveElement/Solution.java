package solutions.Problem27RemoveElement;

/*
 * 设置一个变量（pos）记录当前一个可插入非val元素的位置
 * 从头到尾遍历，如果不是val则将其复制到pos位置，然后pos加1
 * 最后返回pos即是去除所有val元素后的数组长度
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[pos++] = nums[i];
        }
        return pos;
    }
}
