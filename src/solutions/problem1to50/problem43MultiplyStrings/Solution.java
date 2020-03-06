package solutions.problem1to50.problem43MultiplyStrings;

class Solution {
    public String multiply(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int[] product = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                product[i + j + 1] += charToInt(num1Array[i]) * charToInt(num2Array[j]);
            }
        }

        int carry = 0;
        /*
         * 处理进位
         */
        for (int i = product.length - 1; i >= 0; i--) {
            product[i] += carry;
            carry = product[i] / 10;
            product[i] = product[i] - 10 * carry;
        }

        int i = 0;
        while (i < product.length - 1 && product[i] == 0)
            i++;
        StringBuilder sb = new StringBuilder(product.length - i);
        for (; i < product.length; i++) {
            sb.append(intToChar(product[i]));
        }

        return sb.toString();
    }

//    public String multiply(String num1, String num2) {
//        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
//        StringBuilder sb = new StringBuilder(num1.length() + num2.length());
//
//
//     * 模拟竖式计算乘法
//
//        for (int i = num2.length() - 1; i >= 0; i--) {
//            int carry = 0, calculatePosition = num2.length() - 1 - i;
//            for (int j = num1.length() - 1; j >= 0; j--) {
//                int localProduct = carry + charToInt(num1.charAt(j)) * charToInt(num2.charAt(i));
//                carry = localProduct / 10;
//                if (sb.length() > calculatePosition) {
//                    int sum1 = charToInt(sb.charAt(calculatePosition)) + localProduct - 10 * carry;
//                    // 处理加法进位
//                    if (sum1 > 9) {
//                        sum1 -= 10;
//                        int checkPosition = calculatePosition + 1;
//                        while (true) {
//                            if (sb.length() > checkPosition) {
//                                int sum2 = 1 + charToInt(sb.charAt(checkPosition));
//                                if (sum2 > 9) {
//                                    sb.setCharAt(checkPosition, intToChar(sum2 - 10));
//                                } else {
//                                    sb.setCharAt(checkPosition, intToChar(sum2));
//                                    break;
//                                }
//                            } else {
//                                sb.append(intToChar(1));
//                                break;
//                            }
//                            checkPosition++;
//                        }
//                    }
//
//                    sb.setCharAt(calculatePosition, intToChar(sum1));
//                } else {
//                    sb.append(intToChar(localProduct - 10 * carry));
//                }
//                calculatePosition++;
//            }
//            // 处理最后一个进位
//            if (sb.length() > calculatePosition) {
//                sb.setCharAt(calculatePosition, intToChar(charToInt(sb.charAt(calculatePosition)) + carry));
//            } else {
//                sb.append(intToChar(carry));
//            }
//
//        }
//
//        for (int i = sb.length() - 1; i >= 0; i--) {
//            if (i == 0 || sb.charAt(i) != '0') break;
//            sb.deleteCharAt(i);
//        }
//
//        sb.reverse();
//        return sb.toString();
//    }

    private int charToInt(char c) {
        return c - '0';
    }

    private char intToChar(int i) {
        return (char) ((int) '0' + i);
    }
}
