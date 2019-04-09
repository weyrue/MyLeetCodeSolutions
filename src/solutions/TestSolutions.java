package solutions;

public class TestSolutions {
    public static void main(String[] args) {
//        problem5LongestPalindromicSubstring();
//        problem6ZigZagConversion();
        problem7ReverseInteger();
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

    /**
     * @version 1.0
     * @author Yi
     * @date 4/8/2019
     */
    private static void problem5LongestPalindromicSubstring() {
        String input = "dcbbc";

        Problem5LongestPalindromicSubstring methodClass = new Problem5LongestPalindromicSubstring();
        String output = methodClass.longestPalindrome(input);

        System.out.println("output = " + output);
    }

    /**
     * 6. ZigZag Conversion
     *
     * @version 1.0
     * @author Yi
     * @date 4/8/2019
     */
    private static void problem6ZigZagConversion() {
        String s = "AB";
        int numRows = 1;

        Problem6ZigZagConversion methodClass = new Problem6ZigZagConversion();
        String zigzagString = methodClass.convert(s, numRows);

        System.out.println("zigzagString = " + zigzagString);
    }

    /**
     * 7. Reverse Integer
     *
     * @version 1.0
     * @author Yi
     * @date 4/9/2019
     */
    private static void problem7ReverseInteger() {
        int x = -534236469;

        Problem7ReverseInteger methodClass = new Problem7ReverseInteger();
        int reverseInteger = methodClass.reverse(x);

        System.out.println("reverseInteger = " + reverseInteger);
    }
}
