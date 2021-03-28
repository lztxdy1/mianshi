package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * HJ8
 */
public class MergeTable {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            int n = Integer.parseInt(s);
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String[] str = bf.readLine().split(" ");
                if (!map.containsKey(Integer.parseInt(str[0]))){
                    map.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                }else {
                    map.put(Integer.parseInt(str[0]), map.get(Integer.parseInt(str[0])) + Integer.parseInt(str[1]));
                }
            }
            for (Map.Entry entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
