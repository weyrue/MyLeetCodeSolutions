package solutions.problem1to50;

public class Problem12IntegertoRoman {
    public static void main(String[] args) {
        int num = 1994;

        String ret = new Solution12().intToRoman(num);

        String out = (ret);

        System.out.print(out);
    }

}

class Solution12 {
    public String intToRoman(int num) {
        /** 1,5,10,50,100,500,100 对应的罗马数字 */
        char[] romanBaseChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        /**
         * k表示用于判断每位数字的除数，每次循环后除以10
         * i表示romanBaseChar的定位，比如40罗马表示为XL，即romanBaseChar[i]romanBaseChar[i+1]，i=2。
         * digit表示每一位的数字
         */
        int k = 1000, i = 6, digit;
        while (k > 0) {
            // 计算该位的数字
            digit = num / k;
            // 数字对应的每种情况直接写出来
            switch (digit) {
                case 1:
                    sb.append(romanBaseChar[i]);
                    break;
                case 2:
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i]);
                    break;
                case 3:
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i]);
                    break;
                case 4:
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i + 1]);
                    break;
                case 5:
                    sb.append(romanBaseChar[i + 1]);
                    break;
                case 6:
                    sb.append(romanBaseChar[i + 1]);
                    sb.append(romanBaseChar[i]);
                    break;
                case 7:
                    sb.append(romanBaseChar[i + 1]);
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i]);
                    break;
                case 8:
                    sb.append(romanBaseChar[i + 1]);
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i]);
                    break;
                case 9:
                    sb.append(romanBaseChar[i]);
                    sb.append(romanBaseChar[i + 2]);
                    break;
                default:
                    break;
            }
            // 去掉首位数字，用于下一次循环
            num = num - digit * k;
            // 除数缩小为十分之一，用于下一次循环
            k = k / 10;
            // romanBaseChar定位前移两位
            i -= 2;
        }
        return sb.toString();
    }
}

