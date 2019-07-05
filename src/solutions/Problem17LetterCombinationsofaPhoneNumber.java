package solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem17LetterCombinationsofaPhoneNumber {
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        String digits = "279";

        List<String> ret = new Solution17().letterCombinations(digits);

        String out = stringListToString(ret);

        System.out.print(out);
    }
}

class Solution17 {
    /**
     * 用String数组和charAt方法比用Map速度快
     */
    private static final String[] digit2letterArray = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        int[] p = new int[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            p[i] = 0;
        }

        char[] chars = new char[digits.length()];
        while (true) {
            for (int i = digits.length() - 1; i > 0; i--) {
                if (p[i] == digit2letterArray[digits.charAt(i) - '0'].length()) {
                    p[i] = 0;
                    p[i - 1]++;
                }
                chars[i] = digit2letterArray[digits.charAt(i) - '0'].charAt(p[i]);
            }
            if (p[0] < digit2letterArray[digits.charAt(0) - '0'].length()) {
                chars[0] = digit2letterArray[digits.charAt(0) - '0'].charAt(p[0]);
                result.add(String.valueOf(chars));
            } else {
                break;
            }

            p[digits.length() - 1]++;
        }

        return result;
    }
}
