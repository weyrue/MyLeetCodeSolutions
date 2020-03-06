package solutions.problem1to50.Problem30SubstringwithConcatenationofAllWords;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> subStringList = new LinkedList<>();
        if (words == null || words.length == 0) return subStringList;
        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        if (s.length() < totalLength) return subStringList;
        Map<String, Integer> dictMap = new HashMap<>();
        /*
         * 生成words统计MAP
         */
        for (String word : words)
            dictMap.put(word, dictMap.getOrDefault(word, 0) + 1);
        /*
         *
         */
        Map<String, Integer> countMap;

        //已命中的单词数
        int totalHits, iStart, iEnd;
        //本次
        for (int delta = 0; delta < wordLength; delta++) {
            countMap = new HashMap<>();
            totalHits = 0;
            iStart = iEnd = delta;

            while (iEnd <= s.length() - wordLength) {
                if (iStart + totalLength > s.length()) break;
                String subString = s.substring(iEnd, iEnd + wordLength);
                iEnd += wordLength;
                /* 子字符串不是words中单词时，iStart和iEnd统一向iEnd后移一个单词位 */
                if (!dictMap.containsKey(subString)) {
                    iStart = iEnd;
                    totalHits = 0;
                    countMap = new HashMap<>();
                    continue;
                }
                /* 当word超额时, iStart移动到第一个使word不超额的位置*/
                if (countMap.containsKey(subString) && countMap.get(subString) == dictMap.get(subString)) {
                    while (iStart < iEnd) {
                        String subSubString = s.substring(iStart, iStart + wordLength);
                        iStart += wordLength;
                        if (subSubString.equals(subString)) {
                            break;
                        } else {
                            countMap.put(subSubString, countMap.get(subSubString) - 1);
                            totalHits--;
                        }
                    }
                    continue;
                }
                /* 子字符串是words中单词且word未超额时，统计加1 */
                countMap.put(subString, countMap.getOrDefault(subString, 0) + 1);
                totalHits++;
                if (totalHits == words.length) {
                    subStringList.add(iStart);
                    totalHits--;
                    String firstString = s.substring(iStart, iStart + wordLength);
                    countMap.put(firstString, countMap.get(firstString) - 1);
                    iStart += wordLength;
                }
            }
        }
        return subStringList;
    }
}
