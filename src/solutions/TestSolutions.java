package solutions;

public class TestSolutions {
    public static void main(String[] args) {
        problem5LongestPalindromicSubstring();
    }

    /**
     * 4. Median of Two Sorted Arrays
     *
     * @version 1.0
     * @author Yi
     * @date 3/26/2019
     */
    private static void problem4MedianofTwoSortedArrays() {
        int[] nums1 = {};
        int[] nums2 = {1};

        Problem4MedianofTwoSortedArrays methodClass = new Problem4MedianofTwoSortedArrays();
        double median = methodClass.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median = " + median);
    }

    private static void problem5LongestPalindromicSubstring() {
        String input = "dcbbc";

        Problem5LongestPalindromicSubstring methodClass = new Problem5LongestPalindromicSubstring();
        String output = methodClass.longestPalindrome(input);
//        String output = methodClass.longestPalindrome2(input);

        System.out.println("output = " + output);

    }
}
