package solutions;

public class Problem4MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 第一种情况a(m)<b(1)或b(n)<a(1)
        if (nums1[m - 1] < nums2[0]) {
            return situation1(nums1, nums2);
        }
        if (nums1[0] > nums2[n - 1]) {
            return situation1(nums2, nums1);
        }

        return 0;
    }

    /**
     * 第一种情况a(m)<b(1)或b(n)<a(1)
     *
     * @param
     * @return
     * @version 1.0
     * @author Yi
     * @date 3/26/2019
     */
    private double situation1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        if (!isOdd(totalLength)) {
            int medianPosB = totalLength / 2;
            int medianPosA = medianPosB - 1;
            if (medianPosA >= m) {
                return ((double) nums2[medianPosA - m] + (double) nums2[medianPosB - m]) / 2;
            } else if (medianPosB < m) {
                return ((double) nums1[medianPosA] + (double) nums1[medianPosB]) / 2;
            } else {
                return ((double) nums1[medianPosA] + (double) nums2[medianPosB - m]) / 2;
            }
        } else {
            int medianPos = (totalLength - 1) / 2;
            if (medianPos < m) {
                return (double) nums1[medianPos];
            } else {
                return (double) nums2[medianPos - m];
            }
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
