package huawei.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * HJ1
 */
public class LastStringLen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = br.readLine())){
            String[] str = s.split(" ");
            String lastStr = str[str.length - 1];
            System.out.println(lastStr.length());
        }
    }
}
