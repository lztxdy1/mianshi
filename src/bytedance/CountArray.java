package bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 *
 * 区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。
 * 如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 *
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 *
 * 区间内的所有数字都在[0, 100]的范围内;
 */
public class CountArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {

            a[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index1 = i;
            int index2 = i + 1;
            while (index1 >= 0 && a[i] <= a[index1]){
                sum += a[index1];
                index1--;
            }
            while (index2 < n && a[i] <= a[index2]){
                sum += a[index2];
                index2++;
            }
            b[i] = a[i]  * sum;
        }
        int max = b[0];
        for (int i = 1; i < n; i++) {
            if (max < b[i]){
                max = b[i];
            }
        }
        System.out.println(max);
    }
}
