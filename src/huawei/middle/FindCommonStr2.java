package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindCommonStr2{
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line=sc.readLine())!=null){
            String strA = line;
            String strB = sc.readLine();
            if (strA.length() > strB.length()) {
                String temp = strA;
                strA = strB;//strA是较短的子串
                strB = temp;
            }
            System.out.println(findMaxCommonStr(strA,strB));
        }
    }
    private static String findMaxCommonStr(String str1, String str2) {
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        int[][] dp = new int[str1Char.length + 1][str2Char.length + 1];
        int maxLen = 0;
        int start = 0;
        for (int i = 1; i <= str1Char.length; i++) {
            for (int j = 1; j <= str2Char.length; j++) {
                if (str1Char[i - 1] == str2Char[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        start = i - maxLen;//记录最长公共子串的起始位置
                    }
                }
            }
        }
        return str1.substring(start, start + maxLen);
    }

}

