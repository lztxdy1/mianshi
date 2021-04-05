package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、
 * 数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 *
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 *
 *
 * 输出：
 *
 * 返回匹配的结果，正确输出true，错误输出false
 *
 *
 * HJ71
 */
public class TongPeiFu {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String matchStr = null;
        while ((matchStr = bufferedReader.readLine()) != null){
            String str = bufferedReader.readLine();
            System.out.println(matchingString(str, matchStr));
        }
    }

    private static Boolean matchingString(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        int index1 = 0;
        int index2 = 0;
        int st = -1;
        int match = 0;
        while (index1 < str1Len){

            if (index2 < str2Len && (str1.charAt(index1) == str2.charAt(index2) || str2.charAt(index2) == '?') ){
                index1++;
                index2++;
            }else if (index2 < str2Len && str2.charAt(index2) == '*'){
                st = index2;
                match = index1;
                index2++;
            }else if (st != -1){
                index2 = st + 1;
                index1 = ++match;
            }else {
                return false;
            }
        }
        while (index2 < str2Len && str2.charAt(index2) == '*'){
            index2++;
        }
        return index2 == str2Len;

    }
}
