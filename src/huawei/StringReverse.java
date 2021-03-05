package huawei;

import java.util.Scanner;

/**
 * 接受一个只包含小写字母的字符串，
 * 然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * HJ12
 */
public class StringReverse {
//    public static String stringReverse(String s){
//        int len = s.length();
//        int left = 0;
//        int right = len;
//        while (left < right){
//
//        }
//        return s;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            StringBuilder sb = new StringBuilder();
            sb.append(scanner.nextLine());
            System.out.println(sb);
            System.out.println(sb.reverse());
        }
    }
}
