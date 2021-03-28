package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 找出字符串中第一个只出现一次的字符
 *
 * 输入描述:
 * 输入几个非空字符串
 *
 * 输出描述:
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 * HJ59
 */
public class FindFirstChar {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())) {
            System.out.println(getFirstOneChar(s));
        }
    }

    private static String getFirstOneChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)){
                return String.valueOf(c);
            }
        }
        return "-1";
    }

}
