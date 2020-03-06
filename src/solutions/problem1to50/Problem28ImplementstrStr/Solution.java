package solutions.problem1to50.Problem28ImplementstrStr;

/*
 * 逐位比较即可
 * 小技巧：先截取haystack的substring在通过equals方法比较会稍微快一些
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.isEmpty()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) return i;
        }

        return -1;
    }
}
