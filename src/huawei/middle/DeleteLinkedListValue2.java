package huawei.middle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 *
 * 构造过程，例如
 *
 * 1 <- 2
 *
 * 3 <- 2
 *
 * 5 <- 1
 *
 * 4 <- 5
 *
 * 7 <- 2
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 删除 结点 2
 *
 * 则结果为 7 3 1 5 4
 *
 * 链表长度不大于1000，每个节点的值不大于10000。
 * 本题含有多组样例。
 *
 * 输入描述:
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述:
 * 输出删除结点后的序列，每个数后都要加空格
 *
 * HJ48
 */
public class DeleteLinkedListValue2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            int head = input.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(head);
            for (int i = 0; i < n - 1; i++) {
                int b = input.nextInt();
                int a = input.nextInt();
                if(!list.contains(a)){
                    list.add(a);
                    list.add(b);
                }
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j)==a){
                        list.add(j+1,b);
                    }
                }
            }
            int x = input.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)==x){
                    list.remove(i);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println(); //要加这一句，不然过不了
        }
    }
}
