package solutions.Problem22GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * 采用递归思想，若某一位可以为'('或')'时，递归两次，若只有一种选择则递归一次
 * 设置两个变量
 * 一个变量记录还剩多少个左括号没有使用（openRemain，初始值为n）
 * 另一个变量记录还剩多少个右括号需要匹配已经使用的左括号（closeNeedToMatch，初始值为0）
 * 当closeNeedToMatch不等于0时，即存在已经出现的左括号没有右括号匹配，此时下一个字符可以是')'
 * 当openRemain不等于0时，即存在还没有使用的左括号，此时下一个字符可以是'('
 * 当closeNeedToMatch和openRemain均为0时，结束算法
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> generateParenthesis = new LinkedList<>();
        /**
         * 生成某一位的的字符，并保存
         */
        generateParenthesisByPos(new char[2 * n], generateParenthesis, 0, n, 0);
        return generateParenthesis;
    }

    /**
     * 生成某一位的的字符，并保存
     *
     * @param array               存储单个情况的结果
     * @param generateParenthesis 存储全部结果的链表
     * @param pos                 本次循环需要插入字符的位置
     * @param openRemain          记录还剩多少个左括号没有使用
     * @param closeNeedToMatch    记录还剩多少个右括号需要匹配已经使用的左括号
     * @version 1.0
     * @author Yi
     * @date 7/16/2019
     */
    private void generateParenthesisByPos(char[] array, List<String> generateParenthesis, int pos, int openRemain, int closeNeedToMatch) {
        /**
         * 结束条件，到达最后一位时结束（最后一位一定是')'）
         */
        if (pos == array.length - 1) {
            array[pos] = ')';
            generateParenthesis.add(String.valueOf(array));
            return;
        }
        /**
         * 当openRemain不等于0时，即存在还没有使用的左括号，此时下一个字符可以是'('
         */
        if (openRemain != 0) {
            array[pos] = '(';
            generateParenthesisByPos(array, generateParenthesis, pos + 1, openRemain - 1, closeNeedToMatch + 1);
        }
        /**
         * 当closeNeedToMatch不等于0时，即存在已经出现的左括号没有右括号匹配，此时下一个字符可以是')'
         */
        if (closeNeedToMatch != 0) {
            array[pos] = ')';
            generateParenthesisByPos(array, generateParenthesis, pos + 1, openRemain, closeNeedToMatch - 1);
        }
    }
}
