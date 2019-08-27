package solutions.Problem30SubstringwithConcatenationofAllWords;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> dict = new HashMap<>();

        for (String str : words) {
            if (!dict.containsKey(str)) dict.put(str, Integer.valueOf(1));
            else dict.put(str, dict.get(str) + 1);
        }

        return null;
    }
}
