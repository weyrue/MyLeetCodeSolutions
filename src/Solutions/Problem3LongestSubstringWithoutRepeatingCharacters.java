package solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "bbbb";
        System.out.println("maxLength: " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int startPos = 0;
        int maxLength = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            char c = s.charAt(i);
            if (characterIntegerMap.containsKey(c) && characterIntegerMap.get(c) >= startPos) {
                int tempLength = i - startPos;
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }
                startPos = characterIntegerMap.get(c) + 1;
            }
            characterIntegerMap.put(c, i);
        }

        // 循环至队尾的情况单独考虑
        if (length > 0) {
            int i = length - 1;
            char c = s.charAt(i);
            if (characterIntegerMap.containsKey(c) && characterIntegerMap.get(c) >= startPos) {
                int tempLength = i - startPos;
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }
            } else {
                int tempLength = i - startPos + 1;
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }
            }
        }

        return maxLength;
    }
}
