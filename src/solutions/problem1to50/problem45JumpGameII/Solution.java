package solutions.problem1to50.problem45JumpGameII;

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] >= nums.length - 1) return 1;

        int step = 1;
        /* 定义当前步数可达最远位置和上一步可达最远位置 */
        int thisStepFarthest = nums[0], lastStepFarthest = 0;

        /*
         * 假设第k-1步可达最远位置为f(k-1)，第k步可达最远位置为f(k)，每次循环计算第k+1步可达最远位置为f(k+1)。
         * 令指针i在f(k-1)~f(k)之间循环，f(k+1)相当于从f(k-1)走两步可达的最远位置。
         */
        while (thisStepFarthest < nums.length - 1) {
            step++;
            int f_k = thisStepFarthest;
            for (lastStepFarthest++; lastStepFarthest <= f_k; lastStepFarthest++) {
                thisStepFarthest = Math.max(thisStepFarthest, lastStepFarthest + nums[lastStepFarthest]);
            }
            lastStepFarthest = f_k;
            if (f_k == thisStepFarthest) return -1;
        }

        return step;
    }

//    public int jump(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] += i;
//        }
//
//        int k = nums.length - 1;
//        int step = 0;
//        while (true) {
//            if (k == 0) return step;
//            boolean findStep = false;
//            for (int j = 0; j <= k; j++) {
//                if (nums[j] >= k) {
//                    step++;
//                    k = j;
//                    findStep = true;
//                    break;
//                }
//            }
//
//            if (!findStep) return -1;
//        }
//    }
}
