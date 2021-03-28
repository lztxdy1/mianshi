package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，
 * 不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系
 * （如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；
 * 顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 */
public class PuKePai {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            String[] str = s.split("-");
            System.out.println(judge(str[0], str[1]));
        }
    }

    private static String judge(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(){
            {
                put("A",14);
                put("2",15);
                put("3",3);
                put("4",4);
                put("5",5);
                put("6",6);
                put("7",7);
                put("8",8);
                put("9",9);
                put("10",10);
                put("J",11);
                put("Q",12);
                put("K",13);
                put("joker",16);
                put("JOKER",17);
            }
        };
        if (s1.equals("joker JOKER") || s1.equals("JOKER joker")){
            return s1;
        }else if (s2.equals("joker JOKER") || s2.equals("JOKER joker")){
            return s2;
        }
        String[] player1 = s1.split(" ");
        int n1 = map.get(player1[0]);
        String[] player2 = s2.split(" ");
        int n2 = map.get(player2[0]);
        if (isBoom(s1) && isBoom(s2)){
            return n1 > n2 ? s1 : s2;
        }else if (isBoom(s1)){
            return s1;
        }else if (isBoom(s2)){
            return s2;
        }else if (player1.length == player2.length){
            return n1 > n2 ? s1 : s2;
        }else {
            return "ERROR";
        }

    }

    private static boolean isBoom(String s) {
        String[] temp = s.split(" ");
        if (temp.length != 4){
            return false;
        }
        String currentStr = temp[0];
        for (int i = 1; i < 4; i++) {
            if (!currentStr.equals(temp[i])){
                return false;
            }
        }
        return true;
    }
}
