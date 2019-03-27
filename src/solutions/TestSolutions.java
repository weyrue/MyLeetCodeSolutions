package solutions;

public class TestSolutions {
    public static void main(String[] args) {
        problem4MedianofTwoSortedArrays();
    }

    /**
     * 4. Median of Two Sorted Arrays
     *
     * @version 1.0
     * @author Yi
     * @date 3/26/2019
     */
    private static void problem4MedianofTwoSortedArrays() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {7, 8, 9, 10};

        Problem4MedianofTwoSortedArrays methodClass = new Problem4MedianofTwoSortedArrays();
        double median = methodClass.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median = " + median);
    }
}
