package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，
 * 返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 *
 * HJ9
 */
public class GetSingleNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            System.out.println(getReverseSingleNnm(s));
        }
    }

    private static String getReverseSingleNnm(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (res.lastIndexOf(String.valueOf(chars[i])) != -1){
                continue;
            }
            res.append(chars[i]);
        }
        return res.toString();
    }
}
