package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个
 *
 * HJ65
 */
public class FindCommonStr {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = null;
        while (null != (str1 = bufferedReader.readLine())){
            String str2 = bufferedReader.readLine();
            int len1 = str1.length();
            int len2 = str2.length();
            if (len1 > len2){
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            System.out.println(findCommonStr(str1, str2));
        }
    }

    private static String findCommonStr(String str1, String str2) {
        int maxSubStrLen = 1;
        String maxSubStr = str1.substring(0, 1);
        for (int i = 0; i < str1.length(); i++) {
            int count = str1.length() - i + 1;
            for (int j = 0; j < count; j++) {
                int startIndex = j;
                int endIndex = j + i;
                String subStr = str1.substring(startIndex, endIndex);
                if (str2.contains(subStr)){
                    if (subStr.length() > maxSubStrLen) {
                        maxSubStrLen = subStr.length();
                        maxSubStr = subStr;
                    }
                }
            }
        }
        return maxSubStr;
    }
}
