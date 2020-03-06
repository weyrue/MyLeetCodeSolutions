package solutions.problem1to50.problem49GroupAnagrams;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 维护一组质数，总共26个，对应26个字符（因为质数相乘得到的值只有一种乘法组合）。
 * 每个字符串中的字母对应的质数相乘计算出的值若相等，则字母组合也一定相同，否则不同。
 *
 * @author Yi
 * @version 3ms-100%
 * @since 3/5/2020
 */
class Solution {
    private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101};

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new LinkedList<>();
        if (strs == null || strs.length == 0) return resList;
        if (strs.length == 1) {
            resList.add(new LinkedList<>());
            resList.get(0).add(strs[0]);
            return resList;
        }
        Map<Integer, List<String>> keyListMap = new HashMap<>();

        for (String str : strs) {
            int score = calculateScore(str);
            List<String> list = keyListMap.get(score);
            if (list == null) {
                list = new LinkedList<>();
                keyListMap.put(score, list);
                resList.add(list);
            }
            list.add(str);
        }

        return resList;
    }

    private static int calculateScore(String str) {
        int score = 1;
        for (int i = 0; i < str.length(); i++) {
            score *= primes[str.charAt(i) - 'a'];
        }
        return score;
    }
}

///**
// * 维护一个Map，key是排好序的字符串，value是相同字母组合字符串列表。
// * 对于每个字符串，先按字母顺序排序，再根据Map把原始字符串放置到相应的位置。
// *
// * @author Yi
// * @version 6ms-98.19%
// * @since 3/5/2020
// */
//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> resList = new LinkedList<>();
//        Map<String, List<String>> keyPositionMap = new HashMap<>();
//
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String orderedStr = String.valueOf(chars);
//
//            if (!keyPositionMap.containsKey(orderedStr)) {
//                keyPositionMap.put(orderedStr, new LinkedList<>());
//            }
//            keyPositionMap.get(orderedStr).add(str);
//        }
//
//        for (Map.Entry<String, List<String>> entry : keyPositionMap.entrySet()) {
//            resList.add(entry.getValue());
//        }
//
//        return resList;
//    }
//}
