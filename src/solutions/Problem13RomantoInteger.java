package solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem13RomantoInteger {
    public static void main(String[] args) {
        String s = "III";

        int ret = new Solution13().romanToInt2(s);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}

class Solution13 {
    public int romanToInt(String s) {
        int resultInteger = 0;
        char[] romanBaseChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] romanBaseInt = {1, 5, 10, 50, 100, 500, 1000};

        Map<Character, Integer> romanBase = new HashMap<>();
        for (int i = 0; i < romanBaseChar.length; i++) {
            romanBase.put(romanBaseChar[i], romanBaseInt[i]);
        }

        int index = 0;
        while (index < s.length()) {
            int romanFormer = romanBase.get(s.charAt(index));
            if (index < s.length() - 1) {
                int romanLater = romanBase.get(s.charAt(index + 1));
                if (romanFormer < romanLater) {
                    resultInteger += (romanLater - romanFormer);
                    index += 2;
                } else {
                    resultInteger += romanFormer;
                    index++;
                }
            } else {
                resultInteger += romanFormer;
                index++;
            }
        }
        return resultInteger;
    }

    public int romanToInt2(String s) {
        int resultInteger = 0;
        int index = 0;
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case 'I':
                    if (index < s.length() - 1) {
                        if (s.charAt(index + 1) == 'V') {
                            resultInteger += 4;
                            index += 2;
                        } else if (s.charAt(index + 1) == 'X') {
                            resultInteger += 9;
                            index += 2;
                        } else {
                            resultInteger += 1;
                            index++;
                        }
                    }else{
                        resultInteger += 1;
                        index++;
                    }
                    break;
                case 'V':
                    resultInteger += 5;
                    index++;
                    break;
                case 'X':
                    if (index < s.length() - 1) {
                        if (s.charAt(index + 1) == 'L') {
                            resultInteger += 40;
                            index += 2;
                        } else if (s.charAt(index + 1) == 'C') {
                            resultInteger += 90;
                            index += 2;
                        } else {
                            resultInteger += 10;
                            index++;
                        }
                    }else{
                        resultInteger += 10;
                        index++;
                    }
                    break;
                case 'L':
                    resultInteger += 50;
                    index++;
                    break;
                case 'C':
                    if (index < s.length() - 1) {
                        if (s.charAt(index + 1) == 'D') {
                            resultInteger += 400;
                            index += 2;
                        } else if (s.charAt(index + 1) == 'M') {
                            resultInteger += 900;
                            index += 2;
                        } else {
                            resultInteger += 100;
                            index++;
                        }
                    }else{
                        resultInteger += 100;
                        index++;
                    }
                    break;
                case 'D':
                    resultInteger += 500;
                    index++;
                    break;
                case 'M':
                    resultInteger += 1000;
                    index++;
                    break;
                default:
                    index++;
                    break;
            }

        }

        return resultInteger;
    }
}
