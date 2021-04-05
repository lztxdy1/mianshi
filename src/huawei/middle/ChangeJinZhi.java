package huawei.middle;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *   HJ5
 */
public class ChangeJinZhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            String number = s.substring(2);
            int len = number.length();
            int sum = 0;
            for (int i = len - 1; i >= 0; i--) {
                //System.out.println(i);
                char c = number.charAt(i);
                System.out.println(c);
                int temp = (int)c;
                if (temp >= 65){
                    temp = temp - 65 + 10;
                }else{
                    temp = temp - 48;
                }
                sum += (int)Math.pow(16, len - i - 1) * temp;
            }
            System.out.println(sum);

        }
    }
}
