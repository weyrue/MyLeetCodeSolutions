package solutions.Problem38CountandSay;

class Solution {
    public String countAndSay(int n) {
        String countAndSay = "1";

        for (int i = 1; i < n; i++) {
            countAndSay = countAndSay(countAndSay);
        }

        return countAndSay;
    }

    //
    private String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int index_pointer = 0;
        int charCount = 1;
        while (index_pointer < s.length()) {
            //若下一位和这一位相同，则计数器charCount加1，进入下一个循环
            //若不相同，则结算数字
            if (index_pointer < (s.length() - 1) && s.charAt(index_pointer) == s.charAt(index_pointer + 1)) {
                charCount++;
            } else {
                sb.append(charCount);
                sb.append(s.charAt(index_pointer));
                charCount = 1;
            }
            //
            index_pointer++;
        }
        return sb.toString();
    }
}