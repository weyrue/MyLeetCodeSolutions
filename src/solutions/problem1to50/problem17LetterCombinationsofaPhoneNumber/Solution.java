package solutions.problem1to50.problem17LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法类似于计数器，每一位都在0~9循环（本题中是0~2或0~3），当某一位到达数字上限时归0且前一位进位。
 * 然后再将对应数字转换为相应的字母组合即可。
 */
class Solution {
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
        /**
         * 算法类似于计数器，每一位都在0~9循环（本题中是0~2或0~3），当某一位到达数字上限时归0且前一位进位
         * p为记录每一位的数字（用数字表示位置），其实位置都是0
         */
        int[] p = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            p[i] = 0;
        }
        /**
         * chars表示p中数字所代表的的字母的组合
         */
        char[] chars = new char[digits.length()];
        /**
         * 穷举法，枚举全部情况
         */
        while (true) {
            // 从末位向第二位的每个位置循环（循环不包括首位，即p[0]位置）
            for (int i = digits.length() - 1; i > 0; i--) {
                // 当某一位到达数字上限时归0且前一位进位
                if (p[i] == digit2letterArray[digits.charAt(i) - '0'].length()) {
                    p[i] = 0;
                    p[i - 1]++;
                }
                // 修改对应位置的字符
                chars[i] = digit2letterArray[digits.charAt(i) - '0'].charAt(p[i]);
            }
            // 首位p[0]的逻辑与其他位置相同，只是在到达数字上限时跳出循环而不是进位。未到达数字上限时正常修改对应位置的字符。
            if (p[0] < digit2letterArray[digits.charAt(0) - '0'].length()) {
                chars[0] = digit2letterArray[digits.charAt(0) - '0'].charAt(p[0]);
                // 添加到结果集合中
                result.add(String.valueOf(chars));
            } else {
                break;
            }
            // 末尾数字+1，以便下一次循环使用
            p[digits.length() - 1]++;
        }
        return result;
    }
}
