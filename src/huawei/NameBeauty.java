package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 *
 * 本题含有多组数据。
 *
 * 输入描述:
 * 整数N，后续N个名字
 *
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 *
 * HJ45
 */
public class NameBeauty {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())) {
            int n = Integer.parseInt(s);
            String[] name = new String[n];
            for (int i = 0; i < n; i++) {
                String str = bf.readLine().toLowerCase();
                name[i] = str;
            }
            int[] ans = getBeauty(name, n);
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i]);
            }
        }
    }

    private static int[] getBeauty(String[] name, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int beauty = 0;
            int[] countChar = new int[26];
            for (int j = 0; j < 26; j++) {
                countChar[j] = 0;
            }
            for (int j = 0; j < name[i].length(); j++) {
                countChar[name[i].charAt(j) - 'a']++;
            }
            Arrays.sort(countChar);
            int weight = 26;
            for (int j = 25; j >= 0; j--) {
                if (countChar[j] == 0){
                    break;
                }
                beauty += countChar[j] * weight;
                weight--;
            }
            res[i] = beauty;
        }
        return res;
    }
}
