package solutions.Problem22GenerateParentheses;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class MainClass {
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
        String line = "3";
        int n = Integer.parseInt(line);

        List<String> ret = new Solution().generateParenthesis(n);

        String out = stringListToString(ret);

        System.out.print(out);

        AtomicLong sequenceNumber = new AtomicLong(0);
        sequenceNumber.getAndIncrement();
        final Set<String> set = new HashSet<>();
        set.add("1");
        set.remove("1");

    }


}
