package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 *
 * HJ14
 */
public class StringSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            int n = Integer.parseInt(s);
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = bf.readLine();
            }
            Arrays.sort(str);
            for (int i = 0; i < n; i++) {
                System.out.println(str[i]);
            }
        }
    }

}
