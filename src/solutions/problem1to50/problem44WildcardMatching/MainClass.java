package solutions.problem1to50.problem44WildcardMatching;

public class MainClass {

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) {
//        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba" ;
//        String p = "a*******ba";
//        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb" ;
//        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";

        String s = "aa" ;
        String p = "*";

        boolean ret = new Solution().isMatch(s, p);

        String out = booleanToString(ret);

        System.out.print(out);
    }
}
