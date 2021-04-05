package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 *   HJ40
 */
public class FindCharCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            char[] chars = s.toCharArray();
            System.out.println(findChar(chars));
        }
    }

    private static String findChar(char[] ch) {
        int len = ch.length;
        int num = 0;
        int ch1 = 0;
        int space = 0;
        int other = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z'){
                ch1++;
            }else if (c >= '0' && c <= '9'){
                num++;
            }else if (c == ' '){
                space++;
            }else {
                other++;
            }

        }
        sb.append(ch1 + "\n" + space + "\n" + num + "\n" + other);
        return sb.toString();
    }
}
