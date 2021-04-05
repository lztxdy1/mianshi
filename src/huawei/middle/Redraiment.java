package huawei.middle;

import java.util.Scanner;

/**
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，
 * 从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，
 * 你能替Redraiment研究他最多走的步数吗？
 *
 * HJ103
 */
public class Redraiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] step = new int[n];
            for (int i = 0; i < n; i++) {
                step[i] = scanner.nextInt();
            }
            System.out.println(getMaxStep(step, n));
        }
    }

    private static int getMaxStep(int[] step, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (step[j] < step[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxStep = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxStep){
                maxStep = dp[i];
            }
        }
        return maxStep;

    }
}
