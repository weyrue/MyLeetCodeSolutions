package solutions;

public class Problem10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (!s.isEmpty() && !p.isEmpty()) {
            int si = 0, pi = 0;

            while (pi < p.length() && si < s.length()) {
                if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
                    if (p.charAt(pi) == '.') {
                        pi += 2;
                        boolean moveToEnd = true;
                        while (pi < p.length()) {
                            if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
                                pi += 2;
                                continue;
                            } else {
                                moveToEnd = false;
                                while (si < s.length()) {
                                    if (s.charAt(si) == p.charAt(pi)) {
                                        si++;
                                        pi++;
                                        break;
                                    }
                                    si++;
                                }
                                break;
                            }
                        }

//                        char repeatChar = s.charAt(si++);
//                        while (si < s.length() && repeatChar == s.charAt(si))
//                            si++;

                        if (moveToEnd) si = s.length();

                    } else if (p.charAt(pi) >= 'a' && p.charAt(pi) <= 'z') {
                        int count = 0;

                        while (si < s.length() && s.charAt(si) == p.charAt(pi)) {
                            si++;
                            count++;
                        }

                        char checkChar = p.charAt(pi);

                        pi += 2;

                        int mandatoryCount = 0;
                        while (pi < p.length() && (p.charAt(pi) == checkChar || p.charAt(pi) == '*')) {
                            if (p.charAt(pi) == checkChar) mandatoryCount++;
                            pi++;
                        }

                        if (count < mandatoryCount) return false;
                    }
                } else {
                    if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
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
