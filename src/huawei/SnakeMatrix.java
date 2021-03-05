package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * 请注意本题含有多组样例输入。
 *
 * HJ35
 */
public class SnakeMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            int n = Integer.parseInt(s);
            //System.out.println(getSnakeMatrix(n));
            System.out.println(getSnakeMatrix2(n));
        }
    }

    private static String getSnakeMatrix2(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int start = (i - 1) * i / 2 + 1;
            int step = i + 1;
            for (int j = 1; j <= n - i + 1; j++) {
                sb.append(start).append(" ");
                start += step;
                step++;
            }
            sb.setCharAt(sb.length() - 1, '\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String getSnakeMatrix(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {             //行
            for (int j = 1; j <= n - i ; j++) {    //列
                int temp = ((j + i - 1) * (j + i - 1) + j + i - 1) / 2 - i + 1;
                sb.append(temp + " ");
            }
            int temp1 = (n * n + n) / 2 - i + 1;
            if (i == n){
                sb.append(temp1);
            }else {
                sb.append(temp1 + "\n");
            }
        }
        return sb.toString();
    }
}
