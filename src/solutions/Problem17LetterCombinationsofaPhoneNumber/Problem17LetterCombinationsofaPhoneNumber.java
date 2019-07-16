package solutions.Problem17LetterCombinationsofaPhoneNumber;

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

        List<String> ret = new Solution().letterCombinations(digits);

        String out = stringListToString(ret);

        System.out.print(out);
    }
}

