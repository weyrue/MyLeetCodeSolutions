package solutions.problem1to50.Problem31NextPermutation;

class Solution {
    public void nextPermutation(int[] nums) {
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] >= nums[nums.length - 1]) {
//                swapNumToEnd(nums, i);
//            } else {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] > nums[i]) {
//                        swapTwoNums(nums, i, j);
//                        break;
//                    }
//                }
//                break;
//            }
//        }

        //从后向前寻找i，使得nums[i]小于nums[i + 1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        //若不存在这样的i，说明是最大的字典序情况，则将所有数字顺序反转后返回
        if (i < 0) {
            reverseNums(nums, 0, nums.length - 1);
            return;
        }
        //找到这样的i，将i后面的所有数字顺序反转
        reverseNums(nums, i + 1, nums.length - 1);
        //反转后（此时i之后的数字顺序为由小变大的顺序），寻找i之后第一个比nums[i]大的数字，并交换该数字和nums[i]，然后返回
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                swapTwoNums(nums, i, j);
                return;
            }
        }
    }

    /**
     * 将某个位置的数字移动到队尾
     *
     * @param nums  数组
     * @param index 需要移动到队尾的数字位置
     * @return
     * @version 1.0
     * @author Yi
     * @date 9/2/2019
     */
    private void swapNumToEnd(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++)
            swapTwoNums(nums, i, i + 1);
    }

    /**
     * 交换两个位置的数字
     *
     * @param nums        数组
     * @param firstIndex  第一个数字
     * @param secondIndex 第二个数字
     * @return
     * @version 1.0
     * @author Yi
     * @date 9/2/2019
     */
    private void swapTwoNums(int[] nums, int firstIndex, int secondIndex) {
        int tmp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = tmp;
    }

    private void reverseNums(int[] nums, int left, int right) {
        while (left < right) {
            swapTwoNums(nums, left++, right--);
        }
    }
}
