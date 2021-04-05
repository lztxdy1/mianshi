package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，
 * 每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。
 * 请大家给Lily帮忙，通过C语言解决。
 *
 * HJ34
 */
public class ImagesManage {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = bufferedReader.readLine()) != null){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            System.out.println(chars);
        }
    }
}
