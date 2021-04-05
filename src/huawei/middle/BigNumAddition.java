package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入两个用字符串表示的整数，求它们所表示的数之和。
 * 字符串的长度不超过10000。
 * 本题含有多组样例输入。
 *    HJ57
 */

public class BigNumAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            String num1 = s.trim();
            String num2 = bf.readLine().trim();
            StringBuilder sb = new StringBuilder(num1);
            StringBuilder sb1 = new StringBuilder(num2);
            while (sb.length() != sb1.length()){
                if (sb.length() > sb1.length()){
                    sb1.insert(0, '0');
                }else {
                    sb.insert(0, '0');
                }
            }
            System.out.println(addition(sb.toString(), sb1.toString()));
        }
        bf.close();
    }

    private static String addition(String str1, String str2) {
        int ten = 0;
        int one = 0;
        StringBuilder sb2 = new StringBuilder();
        for (int i = str1.length() - 1; i >= 0; i--) {
            int a = str1.charAt(i) - '0';
            int b = str2.charAt(i) - '0';
            int c = a + b + ten;
            ten = c / 10;
            one = c % 10;
            sb2.insert(0, one);
        }
        if (ten > 0){
            sb2.insert(0, ten);
        }
        return sb2.toString();
    }
}
