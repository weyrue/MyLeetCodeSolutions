package solutions.problem1to50;

public class Problem4MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLeftLength = nums1.length;
        int bLeftLength = nums2.length;
        int totalLength = aLeftLength + bLeftLength;
        int nums1_start = 0;
        int nums2_start = 0;

        boolean isOdd = isOdd(totalLength);
        // 一共需要去掉k个元素
        int k = (aLeftLength + bLeftLength - 1) / 2;

        while (k > 1) {
            int t = k / 2;

            if (t >= bLeftLength) {
                //nums1前t个元素全部舍弃
                nums1_start += t;
                k -= t;
                aLeftLength -= t;
            } else if (t >= aLeftLength) {
                //nums2前t个元素全部舍弃
                nums2_start += t;
                k -= t;
                bLeftLength -= t;
            } else {
                // nums1[t-1]>=nums1[t-1]时，nums2中前t个元素可全部舍弃，反之亦然
                if (nums1[nums1_start + t - 1] >= nums2[nums2_start + t - 1]) {
                    nums2_start += t;
                    k -= t;
                    bLeftLength -= t;
                } else {
                    nums1_start += t;
                    k -= t;
                    aLeftLength -= t;
                }
            }
        }

        while (k > 0) {
            if (1 > bLeftLength) {
                //nums1前t个元素全部舍弃
                nums1_start++;
                aLeftLength--;
            } else if (1 > aLeftLength) {
                //nums2前t个元素全部舍弃
                nums2_start++;
                bLeftLength--;
            } else {
                // nums1[t-1]>=nums1[t-1]时，nums2中前t个元素可全部舍弃，反之亦然
                if (nums1[nums1_start] >= nums2[nums2_start]) {
                    nums2_start++;
                    bLeftLength--;
                } else {
                    nums1_start++;
                    aLeftLength--;
                }
            }
            k--;
        }

        if (isOdd) {
            k += 1;
        } else {
            k += 2;
        }

        double median = 0;

        while (k > 0) {
            if (1 > bLeftLength) {
                //nums1前t个元素全部舍弃
                median += nums1[nums1_start];
                nums1_start++;
                aLeftLength--;
            } else if (1 > aLeftLength) {
                //nums2前t个元素全部舍弃
                median += nums2[nums2_start];
                nums2_start++;
                bLeftLength--;
            } else {
                // nums1[t-1]>=nums1[t-1]时，nums2中前t个元素可全部舍弃，反之亦然
                if (nums1[nums1_start] >= nums2[nums2_start]) {
                    median += nums2[nums2_start];
                    nums2_start++;
                    bLeftLength--;
                } else {
                    median += nums1[nums1_start];
                    nums1_start++;
                    aLeftLength--;
                }
            }
            k--;
        }

        if (isOdd) {
            return median;
        } else {
            return median / 2;
        }

    }

    /**
     * 判断是否为奇数
     *
     * @param k 需要判断的整数
     * @return 奇数返回true，偶数返回false
     * @version 1.0
     * @author Yi
     * @date 3/26/2019
     */
    private boolean isOdd(int k) {
        return !(k == ((k / 2) * 2));
    }
}
