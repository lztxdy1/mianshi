package huawei.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数
 * HJ2
 */
public class CountChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = br.readLine())) {
            String str = s.toLowerCase();
            char[] ch = br.readLine().toLowerCase().toCharArray();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (ch[0] == str.charAt(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
