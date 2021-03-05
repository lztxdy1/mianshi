package huawei;

import java.util.Scanner;

/**
 * 将一个字符中所有的整数前后加上符号“*”，
 * 其他字符保持不变。连续的数字视为一个整数
 *
 *   HJ96
 */
public class ExpressNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(getExpressNumber(s));
        }
    }

    public static String getExpressNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 0;
       while (i < len){
           if ((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57){
               sb.append("*" + s.charAt(i));
               while (++i < len && (int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57){
                   sb.append(s.charAt(i));
               }
               sb.append("*");
           }else {
               sb.append(s.charAt(i));
               i++;
           }
       }
        return sb.toString();
    }
}
