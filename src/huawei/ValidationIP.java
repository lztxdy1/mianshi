package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 现在IPV4下用一个32位无符号整数来表示，
 * 一般用点分方式来显示，点将IP地址分成4个部分，
 * 每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），
 * 如10.137.17.1，是我们非常熟悉的IP地址，一
 * 个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 *
 *HJ90
 */
public class ValidationIP {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = bufferedReader.readLine()) != null){
            System.out.println(validationIP(s));
        }
    }

    private static String validationIP(String s) {
        String[] strings = s.split("\\.");
        if (strings.length != 4){
            return "NO";
        }
        for (int i = 0; i < strings.length; i++) {
            int temp = Integer.parseInt(strings[i]);
            if (temp < 0 || temp > 255){
                return "NO";
            }
        }
        return "YES";
    }
}
