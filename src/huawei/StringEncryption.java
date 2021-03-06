package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。
 * 下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
 * 如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，
 * 修改过的那个单词属于字母表的下面，如下所示：
 *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，
 * 信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一
 * 一取代原文的字母(字母字符的大小写状态应该保留)。因此，
 * 使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 * HJ36
 */
public class StringEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            String key = s;
            String str = bf.readLine();
            System.out.println(getEncryptionStr(key, str));
        }
    }

    private static String getEncryptionStr(String key, String str) {
        List<Character> list = new ArrayList<>();       //密文
        List<Character> list1 = new ArrayList<>();      //明文
        for (int i = 0; i < key.length(); i++) {        //key去重
            if (!list.contains(key.charAt(i))){
                list.add(key.charAt(i));
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {             //初始化明文和密文
            list1.add((char)i);
            if (!list.contains((char)i)){
                list.add((char)i);
            }
        }
        Map<Character, Character> map = new HashMap<>(); //建立明文密文对应关系
        for (int i = 0; i < 26; i++) {
            map.put(list1.get(i), list.get(i));
        }
        StringBuilder sb = new StringBuilder();          //获取明文经过加密后的密文
        for (int i = 0; i < str.length(); i++) {
            sb.append(map.get(str.charAt(i)));
        }
        return sb.toString();
    }
}
