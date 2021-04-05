package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入一个只包含小写英文字母和数字的字符串，
 * 按照不同字符统计个数由多到少输出统计结果，
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 *
 *   HJ102
 */
public class CharCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = bufferedReader.readLine()) != null){
            char[] chars = s.toCharArray();
            int[] charNum = new int[129];

            for (char i : chars) {
                charNum[(int)i]++;
            }
            int max = 0;
            for (int i = 0; i < charNum.length; i++) {
                if (charNum[i] > max){
                    max = charNum[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            while (max != 0){
                for (int i = 0; i < charNum.length; i++) {
                    if (charNum[i] == max) {
                        sb.append((char)i);
                    }
                }
                max--;
            }

            System.out.println(sb.toString());

        }
    }
}
