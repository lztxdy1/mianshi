package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 * HJ6
 */
public class ZhiShuYinZi {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            int num = Integer.parseInt(s);
            //List<Integer> res = getPrime(num);
            //for (Integer re : res) {
            //    System.out.println(re);
            //}
            System.out.println(getPrime2(num));
        }
    }



    ////方法一
    //private static List<Integer> getPrime(int num) {
    //    List<Integer> list = new ArrayList<>();
    //    int i = 2;
    //    while (i <= num){
    //        if (num % i == 0){
    //            list.add(i);
    //            num /= i;
    //        }else {
    //            i++;
    //        }
    //    }
    //    return list;
    //}
    //方法二
    private static String getPrime2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                sb.append(i).append(" ");
                num /= i;
                i--;
            }
        }
        sb.append(num).append(" ");
        return sb.toString();
    }


}
