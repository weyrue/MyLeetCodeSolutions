package solutions;

public class TestSolutions {
    public static void main(String[] args) {
//        problem5LongestPalindromicSubstring();
//        problem6ZigZagConversion();
//        problem7ReverseInteger();
//        problem8StringToIntegeratoi();
//        problem9PalindromeNumber();
//        problem10RegularExpressionMatching();
        problem11ContainerWithMostWater();
    }

    /**
     * 11. Container With Most Water
     *
     * @version 1.0
     * @author Yi
     * @date 5/10/2019
     */
    private static void problem11ContainerWithMostWater() {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = {1, 2};

        Problem11ContainerWithMostWater methodClass = new Problem11ContainerWithMostWater();
//        int maxArea = methodClass.maxArea(height);

//        System.out.println("maxArea = " + maxArea);
    }

    /**
     * 10. Regular Expression Matching
     *
     * @version 1.0
     * @author Yi
     * @date 4/29/2019
     */
    private static void problem10RegularExpressionMatching() {
        String s = "a";
        String p = "";

        Problem10RegularExpressionMatching methodClass = new Problem10RegularExpressionMatching();
        boolean isMatch = methodClass.isMatch(s, p);

        System.out.println("isMatch = " + isMatch);
    }

    /**
     * 9. Palindrome Number
     *
     * @version 1.0
     * @author Yi
     * @date 4/10/2019
     */
    private static void problem9PalindromeNumber() {
        int x = 1221;

        Problem9PalindromeNumber methodClass = new Problem9PalindromeNumber();
        boolean isPalindrome = methodClass.isPalindrome(x);

        System.out.println("isPalindrome = " + isPalindrome);
    }

    /**
     * 8. String to Integer (atoi)
     *
     * @version 1.0
     * @author Yi
     * @date 4/10/2019
     */
    private static void problem8StringToIntegeratoi() {
        String str = "    ";

        Problem8StringToIntegeratoi methodClass = new Problem8StringToIntegeratoi();
        int myAtoi = methodClass.myAtoi(str);

        System.out.println("myAtoi = " + myAtoi);
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
     * 5. Longest Palindromic Substring
     *
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

}
