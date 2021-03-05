package huawei;

import java.util.Scanner;

/**
 * 计算一个数字的立方根，不使用库函数。
 * 保留一位小数。
 *
 * HJ107
 */
public class GetLIFangGen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()){
            double number = scanner.nextDouble();
            System.out.println(String.format("%.2f", getCubeRoot(number)));
        }
    }

    private static double getCubeRoot(double number) {
        double num1;
        double num2;
        num1 = number;
        if (number == 0){
            return 0;
        }
        num2 = ( 2 * num1 + number / num1 / num1 ) / 3;
        while (Math.abs(num2 - num1) > 0.000000000001){
            num1 = num2;
            num2 = ( 2 * num1 + number / num1 / num1 ) / 3;
        }
        return num2;
    }
}
