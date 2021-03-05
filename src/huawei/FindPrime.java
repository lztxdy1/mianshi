package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 任意一个偶数（大于2）都可以由2个素数组成，
 * 组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
 *
 *  HJ60
 */
public class FindPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (null != (s = bufferedReader.readLine())){
            int num = Integer.parseInt(s);
            for (int i = num / 2; i > 2; i--) {
                if (findPrime(i) && findPrime(num - i)){
                    System.out.println(i);
                    System.out.println(num - i);
                    break;
                }
            }
        }
    }

    private static boolean findPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
