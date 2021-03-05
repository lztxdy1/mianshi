package huawei;

import java.util.Scanner;

/**
 * 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
 *
 * HJ46
 */
public class SubPreString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            String k = scanner.nextLine();
            System.out.println(getSubPreStr(s, k));
        }
    }

    private static String getSubPreStr(String s, String k) {
        int num = Integer.parseInt(k);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
}
