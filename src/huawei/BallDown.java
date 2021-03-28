package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 * 输入描述:
 * 输入起始高度，int型
 *
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 *
 * HJ38
 */
public class BallDown {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            int startHigh = Integer.parseInt(s);
            List<Double> lists = getDownLength(startHigh);
            System.out.println(lists.get(0));
            System.out.println((double)Math.round( lists.get(1) * 1000000) / 1000000);
        }
    }

    private static List getDownLength(int startHigh) {
        double totalLength = 0.0;
        double s = startHigh;
        List<Double> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            totalLength += s;
            s = s / 2.0;
        }
        totalLength += startHigh;
        double lastLength = s / 2.0;
        list.add(totalLength);
        list.add(lastLength);
       return list;
    }
}
