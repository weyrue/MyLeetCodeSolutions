package solutions.problem1to50.problem42TrappingRainWater;

/**
 * 42. Trapping Rain Water
 *
 * @author Yi
 * @version 1.0
 * @since 2/10/2020
 */
class Solution {
    /**
     * @param height height
     * @return area
     * @author Yi
     * @since 2/10/2020
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int area = 0;
        while (true) {
            int area_tmp = localTrap(height);
            if (area_tmp <= 0) return area;
            area += area_tmp;
        }
    }

    public int localTrap(int[] height) {
        /*
         * 创建并计算height数组的导数
         */
        int[] derivative = new int[height.length];
        derivative[0] = height[0];
        for (int i = 1; i < derivative.length; i++) {
            derivative[i] = height[i] - height[i - 1];
        }
        /*
         * 计算局部积水量
         */
        int i = 0, localArea = 0;
        while (i < (derivative.length - 2)) {
            /*
             * 寻找左边界
             */
            int localStartIndex = -1;
            while (i < (derivative.length - 1)) {
                // 不能超过数组长度，导数为非负，下一位导数为负
                if (derivative[i] >= 0 && derivative[i + 1] < 0) {
                    localStartIndex = i;
                    break;
                }
                i++;
            }
            //没找到左边界则跳出
            if (localStartIndex < 0) break;
            /*
             * 寻找右边界
             */
            int localEndIndex = -1;
            i = localStartIndex + 2;
            while (i < derivative.length) {
                // 导数为正且下一位导数为非正，或导数为正且是数组最后一位
                if (derivative[i] > 0 && (i == (derivative.length - 1) || derivative[i + 1] <= 0)) {
                    localEndIndex = i;
                    break;
                }
                i++;
            }
            //没找到右边界则跳出
            if (localEndIndex < 0) break;
            /*
             * 左右边界均存在时，计算本次积水量
             */
            // 局部高度取两个边界中最小的
            int localHeight = height[localStartIndex] > height[localEndIndex] ? height[localEndIndex] : height[localStartIndex];
            // 对于每个洼点，积水量就是局部高度减洼点高度
            // 计算后将洼点填平值局部高度，以便下一轮计算
            for (int j = localStartIndex + 1; j < localEndIndex; j++) {
                if (height[j] < localHeight) {
                    localArea += (localHeight - height[j]);
                    height[j] = localHeight;
                }
            }
        }
        return localArea;
    }
}