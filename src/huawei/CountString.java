package huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 *编写一个函数，计算字符串中含有的不同字符的个数。
 * 字符在ACSII码范围内(0~127)，换行表示结束符，
 * 不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 *
 *    HJ10
 */
public class CountString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while (scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine());
            s = stringBuilder.toString();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (! set.contains(Integer.valueOf(s.charAt(i)))){
                    set.add(Integer.valueOf(s.charAt(i)));
                }
            }
            System.out.println(set.size());
        }


    }
}
