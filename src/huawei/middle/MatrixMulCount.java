package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 *
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 *
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 *
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 *
 * HJ70
 */
public class MatrixMulCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while (null != (str = bufferedReader.readLine())){
            int n = Integer.parseInt(str);
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] matrix = bufferedReader.readLine().split(" ");
                arr[i][0] = Integer.parseInt(matrix[0]);
                arr[i][1] = Integer.parseInt(matrix[1]);
            }
            int len = arr.length - 1;
            char[] ruler = bufferedReader.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for (int i = ruler.length - 1; i >= 0; i--) {
                char first = ruler[i];
                if (first == ')'){
                    stack.push(-1);
                }else if (first == '('){
                    int m1 = stack.pop();
                    int m2 = stack.pop();
                    sum += arr[m1][0] * arr[m2][0] * arr[m2][1];
                    arr[m1][1] = arr[m2][1];
                    stack.pop();
                    stack.push(m1);
                }else {
                    stack.push(len);
                    len--;
                }
            }
            System.out.println(sum);
        }
    }
}
