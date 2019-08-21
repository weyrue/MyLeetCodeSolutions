package solutions.Problem22GenerateParentheses;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;

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
    }

}


