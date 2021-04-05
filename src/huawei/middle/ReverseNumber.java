package huawei.middle;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * HJ11
 */
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextInt()){
            stringBuilder.append(scanner.nextInt());
            String s = stringBuilder.reverse().toString();
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
            }

        }

    }
}
