package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字
 * （如17，27，37...70，71，72，73...）的个数
 *
 * HJ55
 */
public class FindSevenCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            int num = Integer.parseInt(s);
            int count = 0;
            for (int i = 7; i <= num; i++) {
                if (i % 7 == 0 || findSeven(i)){
                    count++;
                }
            }
            System.out.println(count);

        }
    }

    private static Boolean findSeven(int n) {
        while (n > 0){
            if (n % 10 == 7){
                return true;
            }else {
                n /= 10;
            }
        }
        return false;
    }
}
