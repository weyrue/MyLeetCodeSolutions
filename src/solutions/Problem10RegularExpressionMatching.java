package solutions;

public class Problem10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (!s.isEmpty() && !p.isEmpty()) {
            int si = 0, pi = 0;

            while (pi < p.length() && si < s.length()) {
                if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
                    if (p.charAt(pi) == '.') {
                        return true;
                    } else if (p.charAt(pi) >= 'a' && p.charAt(pi) <= 'z') {
                        while (si < s.length() && s.charAt(si) == p.charAt(pi))
                            si++;
                        pi += 2;
                    }
                } else {
                    if (s.charAt(si) == p.charAt(pi)) {
                        si++;
                        pi++;
                    } else {
                        return false;
                    }
                }
            }

            if (pi < p.length() || si < s.length()) return false;
        } else if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else {
            return false;
        }

        return true;
    }
}
