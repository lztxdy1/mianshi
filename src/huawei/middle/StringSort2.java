package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 * HJ26
 */
public class StringSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            System.out.println(strSort(s));
        }
    }

    private static String strSort(String s) {
        List<Character> list = new ArrayList<>(s.length());
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)){
                list.add(c);
            }
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return Character.toLowerCase(c1) - Character.toLowerCase(c2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))){
                sb.append(list.get(j++));
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
