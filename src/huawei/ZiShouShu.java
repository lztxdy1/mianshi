package huawei;

import java.util.Scanner;

/**
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。
 * 例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 *
 *
 * 接口说明
 *
 *
 * /*
 * 功能: 求出n以内的自守数的个数
 *
 *
 * 输入参数：
 * int n
 *
 * 返回值：
 * n以内自守数的数量。
 *
 *
 * HJ99
 * */


public class ZiShouShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int number = scanner.nextInt();
            System.out.println(CalcAutomorphicNumbers(number));
        }
    }

    private static int CalcAutomorphicNumbers(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int lastNum = i % 10;
            int temp = i;
            int j = 1;
            if (lastNum != 0 && lastNum != 1 && lastNum != 5 && lastNum != 6){
                continue;
            }
            while (temp != 0){
                temp /= 10;
                j *= 10;
            }
            if ((i * i - i) % j == 0){
                count++;
            }

        }
        return count;
    }
}
